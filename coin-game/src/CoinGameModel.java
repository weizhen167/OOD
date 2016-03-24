/**
 * An interface for playing a coin game. The rules of a particular coin game
 * will be implemented by classes that implement this interface.
 */
public interface CoinGameModel {
    /**
     * Gets the size of the board (the number of squares)
     *
     * @return the board size
     */
    int boardSize(); //

    /**
     * Gets the number of coins.
     *
     * @return the number of coins
     */
    int coinCount(); //

    /**
     * Gets the (zero-based) position of coin number {@code coinIndex}.
     *
     * @param coinIndex
     *            which coin to look up
     * @return the coin's position
     * @throws IllegalArgumentException
     *             if there is no coin with the requested index
     */
    int getCoinPosition(int coinIndex); //

    /**
     * Returns whether the current game is over. The game is over if there are
     * no valid moves.
     *
     * @return whether the game is over
     */
    boolean isGameOver(); //

    /**
     * Moves coin {@code coinIndex} to position {@code newPosition}, if the
     * requested move is legal. Throws {@code IllegalMoveException} if the
     * requested move is illegal, which can happen in several ways:
     *
     * <ul>
     * <li>There is no coin with the requested index.</li>
     * <li>The new position is occupied by another coin.</li>
     * <li>There is some other reason the move is illegal, as specified by the
     * concrete game.</li>
     * </ul>
     *
     * @param coinIndex
     *            which coin to move (numbered from the left)
     * @param newPosition
     *            where to move it to
     * @throws IllegalMoveException
     *             the move is illegal
     */
    void move(int coinIndex, int newPosition); //

    /**
     * add a new player into the game. we can add new player into the game any
     * time, but we can only add one new player every time(That means if we want
     * add 5 players in sometime, we have to run this method 5 times). when a
     * new player is added, this player's name will never change until the is
     * game over.
     * 
     * @param newPosition
     *            new game queue position for the new user
     * @param playername
     *            new player's name
     * @throws IllegalArgumentException
     *             if {@code newPosition > playercount}
     * @throws IllegalArgumentException
     *             if {@code newPosition < 0}
     * @throws IllegalArgumentException
     *             if the {@code playername was repeated}
     * @throws IllegalArgumentException
     *             if the {@code playername.length < 0}
     */
    void addNewPlayer(int newPosition, String playername); //

    /**
     * Identify which player will play this move.
     * 
     * @return the ID of this move's player
     */
    String whosMove();

    /**
     * count how many players in the game
     * 
     * @return the number of players in game
     */
    int countPlayer();

    /**
     * get the winner of the game
     * 
     * @return String the winner's name
     */
    String getwinner();

    /**
     * The exception thrown by {@code move} when the requested move is illegal.
     *
     * <p>
     * (Implementation Note: Implementing this interface doesn't require
     * "implementing" the {@code IllegalMoveException} class. Nesting a class
     * within an interface is a way to strongly associate that class with the
     * interface, which makes sense here because the exception is intended to be
     * used specifically by implementations and clients of this interface.)
     */
    static class IllegalMoveException extends IllegalArgumentException {
        /**
         * Constructs a illegal move exception with no description.
         */
        public IllegalMoveException() {
            super();
        }

        /**
         * Constructs a illegal move exception with the given description.
         *
         * @param msg
         *            the description
         */
        public IllegalMoveException(String msg) {
            super(msg);
        }
    }
}
