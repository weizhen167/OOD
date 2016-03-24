import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * A view of the game from the perspective of one player.
 */
public interface ClientView {
  /**
   * A move from one position to another.
   */
  interface Move extends Comparable<Move> {
    /**
     * The source position of the move, as a board index.
     * @return the source position
     * @see Position#index()
     */
    int from();

    /**
     * The destination position of the move, as a board index.
     * @return the destination position
     * @see Position#index()
     */
    int to();

    /**
     * Compares {@code Move}s in lexicographic order.
     */
    Comparator<Move> COMPARATOR = Comparator.comparing(Move::from)
                                            .thenComparing(Move::to);

    default int compareTo(@NotNull Move other) {
      return COMPARATOR.compare(this, other);
    }
  }

  /**
   * Sets the specified board position to contain the specified piece.
   *  @param index where to set the piece
   * @param isFirst whether the piece belongs to the first player
   * @param isCrowned whether the piece is crowned
   */
  void setPosition(int index, boolean isFirst, boolean isCrowned);

  /**
   * Clears the piece, if any, from the specified board position.
   *
   * @param index where to clear the piece
   */
  void clearPosition(int index);

  /**
   * Indicates to the user that the game is waiting for the other player.
   */
  void waitingForOtherPlayer();

  /**
   * Asks the users to choose a move from a collection of options, and
   * returns the move chosen by the user.
   *
   * @param options the available moves
   * @param <T> a type that implements {@code Move}
   * @return the chosen move
   */
  @NotNull <T extends Move> T getChoice(@NotNull Collection<T> options);

  /**
   * Displays whether the player on this view is the winner or not.
   *
   * @param isWinner whether this player is the winner
   */
  void displayResult(boolean isWinner);
}
