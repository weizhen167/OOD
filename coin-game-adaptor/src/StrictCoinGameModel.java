import java.util.ArrayList;

/**
 * 
 * @author Zhen wei
 * @version 2/19/2015
 * @category cs3500 hw5
 * 
 *           StrictCoinGameModel implements CoinGameModel
 */
public class StrictCoinGameModel implements CoinGameModel {

    private final ArrayList<Integer> startlist;
    // this is a final list, it record the most beginning game model as a
    // Integer list

    public ArrayList<Integer> coinlist;
    // this list will be updated after every valid move

    private final int coin;
    // this is a final integer, it record the number of coins

    private final int square;
    // this is a final integer, it record the number of square

    private int turncount = 0;
    // count the number of turns

    private String winner = null;
    // winner's name f the game;

    private int playercount = 0;
    // count the number of players, if a new player has been added,
    // playercount will +1

    private ArrayList<String> playerlistforthisturn = new ArrayList<String>();
    // usually when a new turn start, this list will read
    // playerlistfornextturn's value
    // and then process this turn. players will follow this list's order to play
    // move,whenever any player of this list finished move, remove this player's
    // name
    // from the list then continue the turn until the list empty.

    private ArrayList<String> playerlistfornextturn;

    String[] startplayerlist;

    // when a turn finished, load this turn's data to playerlistforthisturn,
    // then reset this list as a new ArrayList<String>(),
    // then when a player(what ever new or old) has finish move in this turn,
    // add this player's name into this list.

    /**
     * Constructor of StrictCoinGame. the coin of StrictCoinGame can not pass
     * another coin and the can only be moved to the left.when the
     * StrictCoinGameModel has been created, the board must be a non-null String
     * and at least 1 player in the game.
     * 
     * @param board
     *            the game model
     * @param startplayername
     *            the start player name
     * @throws IllegalArgumentException
     *             if {@code board.length() < 0}
     * @throws IllegalArgumentException
     *             if {@code startplayername.length() < 0}
     * @throws IllegalArgumentException
     *             if if {@code board is game over}
     * 
     */
    public StrictCoinGameModel(String board, String... players) {
        if (board.length() == 0) {
            throw new IllegalArgumentException(
                    "please input correct game model");
        }
        if (players.length == 0) {
            throw new IllegalArgumentException("player list can not be empty");
        }
        this.startlist = new ArrayList<Integer>(str2list(board));
        this.coinlist = new ArrayList<Integer>(startlist);
        this.coin = coinCount();
        this.square = startlist.size();

        this.playerlistfornextturn = new ArrayList<String>();
        this.playercount = players.length;
        this.startplayerlist = players;
        for (int i = 0; i < players.length; i++) {
            this.playerlistforthisturn.add(Integer.toString(i));
        }

        if (isGameOver()) {
            throw new IllegalArgumentException(
                    "Your game model is Game-Over, no winner");
        }
    }

    @Override
    public int boardSize() {
        return square;
    }

    @Override
    public int coinCount() {
        int i = 0;
        ArrayList<Integer> coinlist = new ArrayList<Integer>(startlist);
        while (coinlist.size() > 0) {
            if (coinlist.get(0) == 1) {
                i = i + 1;
                coinlist.remove(0);
            } else {
                coinlist.remove(0);
            }
        }
        return i;
    }

    @Override
    public int getCoinPosition(int coinIndex) {
        if (coinIndex >= coin) {
            throw new IllegalArgumentException(
                    "please input correct coin index");
        }
        int c = coinIndex;
        int i = -1;
        ArrayList<Integer> coinlist1 = new ArrayList<Integer>(coinlist);
        while (c >= 0) {
            if (coinlist1.get(0) == 1) {
                c = c - 1;
                i++;
                coinlist1.remove(0);
            } else {
                coinlist1.remove(0);
                i++;
            }
        }
        return i;
    }

    @Override
    public boolean isGameOver() {
        ArrayList<Integer> trygameover = new ArrayList<Integer>(coinlist);
        int i = 0;
        int c = coin;
        while (c > 0) {
            i = i + trygameover.get(0);
            trygameover.remove(0);
            c--;
        }
        if (i == coin) {
            return true;
        }
        return false;
    }

    @Override
    public void move(int coinIndex, int newPosition) {
        if (coinIndex >= coin || coinIndex < 0) {
            throw new IllegalMoveException("please input correct coin index");
        } else if (newPosition >= square || newPosition < 0) {
            throw new IllegalMoveException(
                    "please input correct new board position");
        } else if (coinlist.get(newPosition) == 1) {
            throw new IllegalMoveException(
                    "please input correct new board position");
        } else if (getCoinPosition(coinIndex) < newPosition) {
            throw new IllegalMoveException(
                    "the coin can not be moved to the right");
        } else if (getCoinPosition(coinIndex) == newPosition) {
            throw new IllegalMoveException(
                    "please make sure you move the coin at least 1 space");
        } else if (coinIndex == 0) {
            if (getCoinPosition(coinIndex) == 0) {
                throw new IllegalMoveException("the coin can not be moved");
            } else {
                coinlist.set(getCoinPosition(coinIndex), 0);
                coinlist.set(newPosition, 1);
                System.out.println("");
                System.out.println("move successful!!");
                System.out.println("current board is: ");
                System.out.println(toString());
                aftermove();
            }
        } else if (coinIndex != 0) {
            if (newPosition < getCoinPosition(coinIndex - 1)) {
                throw new IllegalMoveException(
                        "the coin can not pass another coin");
            } else {
                coinlist.set(getCoinPosition(coinIndex), 0);
                coinlist.set(newPosition, 1);
                System.out.println("");
                System.out.println("move successful!!");
                System.out.println("current board is: ");
                System.out.println(toString());
                aftermove();
            }
        }
    }

    @Override
    public String whosMove() {
        if (isGameOver()) {
            return null;
        }
        return playerlistforthisturn.get(0);
    }

    @Override
    public int countPlayer() {
        return playercount;
    }

    @Override
    public String getwinner() {
        return winner;
    }

    @Override
    public String[] getstartplayer() {
        return startplayerlist;
    }

    @Override
    public void addNewPlayer(int newPosition, String playername) {
        if (isGameOver()) {
            throw new NullPointerException(
                    "the game is over, can not add new player");
        }
        if (checkdoublename(playername)) {
            throw new IllegalArgumentException(
                    "the player name can not be replayed");
        }
        if (playername.length() == 0) {
            throw new IllegalArgumentException(
                    "the player name can not be empty");
        }
        if (newPosition > playercount || newPosition < 0) {
            throw new IllegalArgumentException(
                    "the player can not be added because new Position is invaild");
        } else if (playerlistfornextturn.size() == 0) {
            playerlistforthisturn.add(newPosition, playername);
            playercount++;
        } else if (newPosition == playerlistfornextturn.size()) {
            playerlistfornextturn.add(playername);
            playercount++;
        } else if (newPosition > playerlistfornextturn.size()) {
            playerlistforthisturn.add(
                    newPosition - playerlistfornextturn.size(), playername);
            playercount++;
        } else if (newPosition < playerlistfornextturn.size()) {
            playerlistfornextturn.add(newPosition, playername);
            playercount++;
        }
    }

    /**
     * something need to be done after move if the game is over, show notice and
     * the winner if the this turn is over, reset some data and start new turn
     * if the move is success, show the move is success
     */
    public void aftermove() {
        if (isGameOver()) {
            winner = playerlistforthisturn.get(0);
            System.out.println("");
            System.out.println("");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println("^^^^^^^^^^Game Over^^^^^^^^^^");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        } else {
            playerlistfornextturn.add(playerlistforthisturn.get(0));
            playerlistforthisturn.remove(0);
            if (isThisTurnFinished()) {
                System.out.println("==================Turn" + turncount
                        + " Finished==================");
                turncount++;
                playerlistforthisturn = new ArrayList<String>(
                        playerlistfornextturn);
                playerlistfornextturn = new ArrayList<String>();
            } else {
                System.out
                        .println("------------------Move finished------------------");
            }
        }
    }

    /**
     * check if the already name is in the name list
     * 
     * @param name
     *            the name need to be check
     * @return true if the game already have the list, else return false
     */
    private boolean checkdoublename(String name) {
        ArrayList<String> list = new ArrayList<String>(currentorder());
        boolean acc = false;
        while (!list.isEmpty()) {
            acc = acc || (list.get(0)).equals(name);
            list.remove(0);
        }
        return acc;
    }

    /**
     * get current move queue order
     * 
     * @return ArrayList<String> current move queue order
     */
    public ArrayList<String> currentorder() {
        ArrayList<String> arraylist3 = new ArrayList<String>();
        arraylist3.addAll(playerlistfornextturn);
        arraylist3.addAll(playerlistforthisturn);
        return arraylist3;
    }

    /**
     * Identify if this turn is finished.a turn finished with all existed
     * players played one move
     * 
     * @return true if this turn is finished, otherwise return false
     */
    private boolean isThisTurnFinished() {
        return playerlistforthisturn.size() == 0;
    }

    /**
     * make a string to Arraylist<Integer>
     * 
     * @param input
     *            the input String
     * @return ArrayList<Integer> code of every char of the string
     */
    private ArrayList<Integer> str2list(String input) {
        StringBuffer c = new StringBuffer(input);
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (c.length() > 0) {
            if (Character.toString(c.charAt(0)).equals("-")) {
                result.add(0);
                c.deleteCharAt(0);
            } else if (Character.toString(c.charAt(0)).equals("O")) {
                result.add(1);
                c.deleteCharAt(0);
            } else {
                throw new IllegalArgumentException(
                        "please input correct game format 'O' or '-' ");
            }
        }
        return result;
    }

    /**
     * make coinlist to a String
     * 
     * @return a string
     */
    public String toString() {
        ArrayList<Integer> n1 = new ArrayList<Integer>(coinlist);
        String o = "";
        while (n1.size() > 0) {
            if (n1.get(0).equals(1)) {
                o = o + "O";
                n1.remove(0);
            } else {
                o = o + "-";
                n1.remove(0);
            }
        }
        return o;
    }
}
