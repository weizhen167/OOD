
public class CoinGameModelAdaptor implements NewCoinGameModel {

    final int coin;
    final int square;

    CoinGameModel model;
    CoinGamePlayer[] order;
    String[] startplayerlist;
    int id = 0;
    CoinGamePlayer currentplayer;

    public static CoinGameModelAdaptor fromString(String initialBoard,
            String... players) {
        if (initialBoard.length() == 0) {
            throw new IllegalArgumentException(
                    "please input correct game model");
        }
        if (players.length == 0) {
            throw new IllegalArgumentException("input at least one player name");
        }
        if (initialBoard.equals(null) || players.equals(null)) {
            throw new NullPointerException(
                    "initialBoard or players arrary can not be null");
        }
        CoinGameModel o1 = new StrictCoinGameModel(initialBoard, players);
        CoinGameModelAdaptor a1 = new CoinGameModelAdaptor(o1);
        return a1;
    }

    private CoinGameModelAdaptor(CoinGameModel adaptee) {
        this.model = adaptee;
        this.coin = adaptee.coinCount();
        this.square = adaptee.boardSize();
        this.startplayerlist = adaptee.getstartplayer();
        this.order = iniorder(adaptee);

    }

    /**
     * Initialize order list
     * @param adaptee the input model
     * @return order list
     */
    private CoinGamePlayer[] iniorder(CoinGameModel adaptee) {
        String[] current = startplayerlist;
        Player[] list = new Player[current.length];
        int i = 0;
        while (i < current.length) {
            list[i] = makeplayer(current[i], id);
            i++;
            id++;
        }
        return list;
    }

    @Override
    public int boardSize() {
        return square;
    }

    @Override
    public int coinCount() {
        return coin;
    }

    @Override
    public int[] getCoinPositions() {
        int[] list = new int[coin];
        int i = 0;
        while (i < coin) {
            list[i] = model.getCoinPosition(i);
            i++;
        }
        return list;
    }

    @Override
    public CoinGamePlayer[] getPlayOrder() {
        return order;
    }

    @Override
    public CoinGamePlayer getWinner() {
        CoinGamePlayer winner = null;
        if (!model.isGameOver()) {
            return winner;
        } else {
            return currentplayer;
        }
    }

    @Override
    public CoinGamePlayer getCurrentPlayer() {
        if (model.isGameOver()) {
            return null;
        }
        int i = 0;
        CoinGamePlayer mover = null;
        while (i < getPlayOrder().length) {
            if (getPlayOrder()[i].isTurn()) {
                mover = getPlayOrder()[i];
                break;
            }
            i++;
        }
        currentplayer = mover;
        return mover;
    }

    @Override
    public CoinGamePlayer addPlayerAfter(CoinGamePlayer predecessor, String name) {
        if (predecessor == null || name == null) {
            throw new NullPointerException("both parameter have to br not null");
        }
        checkname(predecessor, name);
        int pos = getplayerp(predecessor) + 1;
        model.addNewPlayer(pos, Integer.toString(id));
        CoinGamePlayer p = new Player(name, id);
        id++;
        order = neworder(order, pos, p);
        return getPlayOrder()[pos];
    }

    /**
     * insert the given player into the game order
     * 
     * @param o
     *            old game order
     * @param i
     *            new position
     * @param p
     *            new player
     * @return the new game order
     */
    CoinGamePlayer[] neworder(CoinGamePlayer[] o, int i, CoinGamePlayer p) {
        CoinGamePlayer[] neworder = new CoinGamePlayer[o.length + 1];
        int acc = 0;
        while (acc < o.length + 1) {
            if (acc == i) {
                neworder[acc] = p;
            }
            if (acc < i) {
                neworder[acc] = o[acc];
            }
            if (acc > i) {
                neworder[acc] = o[acc - 1];
            }
            acc++;
        }
        return neworder;
    }

    /**
     * get the given player's position
     * 
     * @param name
     *            the given name
     * @return player's position of the old list
     */
    private int getplayerp(CoinGamePlayer player) {
        CoinGamePlayer[] list = getPlayOrder();
        int i = 0;
        while (i < list.length) {
            if (list[i].equals(player)) {
                break;
            }
            i++;
        }
        return i;
    }

    /**
     * helper of addPlayerAfter() check if the input is valid
     * 
     * @param predecessor
     *            the CoinGamePlayer
     * @param name
     *            the name
     */
    private void checkname(CoinGamePlayer predecessor, String name) {
        CoinGamePlayer[] list = getPlayOrder();
        boolean acc = false;
        int i = 0;
        while (i < list.length) {
            if (list[i].equals(predecessor)) {
                acc = true;
                break;
            }
            i++;
        }
        if (!acc) {
            throw new IllegalArgumentException(
                    "the input player doesn't in game's play order.");
        }
    }

    /**
     * make a new player
     * 
     * @param n
     *            name of the player
     * @return a new CoinGamePlayer
     */
    public Player makeplayer(String n, int m) {
        return new Player(n, m);
    }

    /**
     * search the player by the given name
     * 
     * @param n
     *            name
     * @return a CoinGamePlayer
     */
    public CoinGamePlayer getplayer(String n) {
        int current = model.countPlayer();
        CoinGamePlayer p = null;
        CoinGamePlayer[] list = getPlayOrder();
        int i = 0;
        while (i < current) {
            if (list[i].getName().equals(n)) {
                p = list[i];
                break;
            }
            i++;
        }
        return p;
    }

    class Player implements CoinGamePlayer {

        private String name;
        private final int pid;

        public Player(String name, int id) {
            if (name.equals("")) {
                throw new IllegalArgumentException("the name can not be empty");
            }
            if (name.equals(null)) {
                throw new NullPointerException("both inputs must be not null");
            }
            this.name = name;
            this.pid = id;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public void move(int coinIndex, int newPosition) {
            model.move(coinIndex, newPosition);
        }

        @Override
        public boolean isTurn() {
            return model.whosMove().equals(Integer.toString(pid));
        }

    }
}
