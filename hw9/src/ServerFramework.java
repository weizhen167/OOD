import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * A framework for draughts servers with remote clients. To use, extend this
 * class, overriding method {@link #runGame(ClientView, ClientView)} so that it
 * runs a game with the given pair of clients. The framework calls {@code
 * runGame} in a new thread each time and then continues listening for
 * connections, which means that multiple games can happen at the same time.
 * (You don't have to understand threads or do anything with them to make this
 * happen.) Each call to {@code runGame} must create a new model for that pair
 * of clients, so that multiple pairs of clients can play multiple independent
 * games at the same time.
 *
 * <p>
 * To start accepting client connections, instantiate your class and call
 * method {@link #listen()} (or {@link #listen(int)}.
 */
public abstract class ServerFramework {
  /**
   * Runs a draughts game with the given views for the players. This method
   * may be called by the framework multiple times to start multiple
   * independent games, so it should create and run a fresh game each time it
   * is called.
   *
   * @param player1 the first player's view
   * @param player2 the second player's view
   */
  protected abstract void runGame(@NotNull ClientView player1,
                                  @NotNull ClientView player2);

  /**
   * The default port to listen on ({@value #PORT}).
   */
  @SuppressWarnings("JavaDoc")
  public static final int PORT = 3509;

  /**
   * Listens for connections on port {@value #PORT} and starts a game for each
   * two clients that connect.
   *
   * @throws IOException network trouble
   */
  public final void listen() throws IOException {
    listen(PORT);
  }

  /**
   * Listens for connections on the given port and starts a game for each two
   * clients that connect.
   *
   * @param port the port to listen on
   * @throws IOException network trouble
   */
  public final void listen(int port) throws IOException {
    try (ServerSocket serverSocket = new ServerSocket(port)) {
      log("Accepting connections on port %d", port);

      //noinspection InfiniteLoopStatement
      for (;;) {
        try {
          Socket socket1 = serverSocket.accept();
          log("First player connected from %s", ip(socket1));

          try {
            Socket socket2 = serverSocket.accept();
            log("Second player connected from %s", ip(socket2));

            spawnThread(() -> {
              try (SocketClientView view1 = new SocketClientView(socket1);
                   SocketClientView view2 = new SocketClientView(socket2))
              {
                runGame(view1, view2);
              } catch (IOException e) {
                log("IOException in game thread: %s", e);
              } catch (NoSuchElementException e) {
                log("Client disconnected unexpectedly (%s, %s)",
                    ip(socket1), ip(socket2));
              }
            });
          } catch (IOException e) {
            socket1.close();
            log("IOException in accept (player 2): %s", e);
          }
        } catch (IOException e) {
          log("IOException in accept (player 1): %s", e);
        }
      }
    }
  }

  /**
   * Prints a server log message. Takes a format string and arguments to
   * substitute, in the style of {@link PrintStream#printf(String, Object...)
   * } or {@link Formatter#format(String, Object...)}. The message is printed
   * on {@link System#err} and includes a timestamp.
   *
   * @param format the format string
   * @param args the arguments to substitute
   */
  protected static void log(String format, Object... args) {
    System.err.printf("[%tF %<tT] ", new Date());
    System.err.printf(format, args);
    System.err.println();
  }

  /**
   * The actual {@link ClientView} implementation, which proxies a remote
   * {@link ClientView} over a socket.
   */
  private class SocketClientView implements ClientView, Closeable {
    private SocketClientView(Socket socket) throws IOException {
      this.socket = socket;
      out = new Formatter(socket.getOutputStream());
      in  = new Scanner(socket.getInputStream());
    }
    private final @NotNull Socket socket;
    private final @NotNull Formatter out;  // to socket
    private final @NotNull Scanner in;     // from socket

    @Override
    public void setPosition(int index, boolean isFirst, boolean isCrowned) {
      out.format("SET %d %s %s%n", index,
                 isFirst ? "FIRST" : "SECOND",
                 isCrowned ? "CROWNED" : "NORMAL").flush();
    }

    @Override
    public void clearPosition(int index) {
      out.format("UNSET %d%n", index).flush();
    }

    @Override
    public @NotNull <T extends Move>
    T getChoice(@NotNull Collection<T> options)
    {
      List<T> optionsList = new ArrayList<>(options);

      out.format("CHOOSE%n");
      for (T move : optionsList) {
        out.format("  %d %d%n", move.from(), move.to());
      }
      out.format("END_CHOOSE%n").flush();

      int response = in.nextInt();

      if (response < 0 || response >= optionsList.size()) {
        out.format("ERROR %d is not a valid choice%n", response).flush();
        throw new NoSuchElementException("Invalid choice: " + response);
      }

      return optionsList.get(response);
    }

    @Override
    public void waitingForOtherPlayer() {
      out.format("WAIT%n").flush();
    }

    @Override
    public void displayResult(boolean isWinner) {
      out.format(isWinner ? "WIN%n" : "LOSE%n").flush();
    }

    @Override
    public void close() throws IOException {
      log("Disconnected client %s", ip(socket));
      socket.close();
    }
  }

  /**
   * Runs the given action (function object) in a new thread.
   *
   * @param action the function object to invoke
   * @return the new thread
   */
  private static @NotNull Thread spawnThread(@NotNull Runnable action) {
    Thread thread = new Thread(action);
    thread.start();
    return thread;
  }

  /**
   * An action with no parameters or result, executed for its side effects.
   */
  private interface Action { void execute(); }

  /**
   * Gets the remote IP address connected to a socket.
   *
   * @param socket the socket
   * @return the IP address
   */
  private static @NotNull String ip(@NotNull Socket socket) {
    return ((InetSocketAddress) socket.getRemoteSocketAddress())
            .getHostString();
  }
}
