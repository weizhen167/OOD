
import java.util.ArrayList;

public class Draught {

    int countred;
    int countblk;
    public ArrayList<Box> board;
    final int size;
    String currentplayer;
    public String nextplayer;
    public ArrayList<Integer> currentIdMoveList = new ArrayList<Integer>();
    ArrayList<String> displayList = new ArrayList<String>();
    String winner = null;
    int thisMoveId = 0;
    ArrayList<Box> PosBoard;

    BlackSideDisplay blkdisplay;
    RedSideDisplay reddisplay;

    public static Draught make8x8game() {
        return new Draught(8);
    }

    public static Draught make6x6game() {
        return new Draught(6);
    }

    public static Draught make10x10game() {
        return new Draught(10);
    }

    public Draught(int input) {
        this.PosBoard = initboard(input);
        this.board = initboard(input);
        initRedChess(input);
        initBlkChess(input);
        this.size = input;
        this.currentplayer = "+";
        this.nextplayer = "o";
        this.countred = input / 2 * 3;
        this.countblk = input / 2 * 3;
    }

    // -------------------------------------Game
    // Initialization----------------------------------------------
    public ArrayList<Box> initboard(int input) {
        int i1 = 0; // id
        int i2 = 0; // x
        int i3 = 1; // y
        int acc = 0;
        ArrayList<Box> l1 = new ArrayList<Box>();
        while (i1 < input * input / 2) {
            Box m1 = new Box("white", false, i2, i3, i1, false);
            l1.add(m1);
            acc++;
            if (acc == input / 2 & i2 % 2 == 0) {
                i2 = i2 + 1;
                i3 = 0;
                acc = 0;
                i1++;
            } else if (acc == input / 2 & i2 % 2 == 1) {
                i2 = i2 + 1;
                i3 = 1;
                acc = 0;
                i1++;
            } else {
                i1++;
                i3 = i3 + 2;
            }
        }
        return l1;
    }

    public void initRedChess(int input) {
        int i1 = 0;
        while (i1 < input / 2 * 3) {
            int ix = board.get(i1).getX();
            int iy = board.get(i1).getY();
            int id = board.get(i1).getId();
            Box m1 = new Box("o", false, ix, iy, id, true);
            this.board.set(i1, m1);
            i1++;
        }
    }

    public void initBlkChess(int input) {
        int i1 = (input * input / 2) - 1;
        int i2 = 0;
        while (i2 < input / 2 * 3) {
            int ix = board.get(i1).getX();
            int iy = board.get(i1).getY();
            int id = board.get(i1).getId();
            Box m1 = new Box("+", false, ix, iy, id, true);
            this.board.set(i1, m1);
            i2++;
            i1--;
        }
    }

    // ---------------------------------------------------Game
    // Move-----------------------------------

    public String whoesmove() {
        return this.currentplayer;
    }

    public void takeTurns() {
        if (currentplayer.equals("o")) {
            currentplayer = "+";
            nextplayer = "o";
        } else if (currentplayer.equals("+")) {
            currentplayer = "o";
            nextplayer = "+";
        }
    }

    public boolean isGameOver() {
        boolean win = false;
        if (this.countblk == 0 || this.countred == 0) {
            win = true;
        } else if (!mapMove()) {
            win = true;
        }
        if (win) {
            winner = nextplayer;
        }
        return win;
    }

    public String getWinner() {
        if (this.winner == null) {
            throw new NullPointerException("no winner yet");
        }
        return this.winner;
    }

    public boolean mapMove() {
        currentIdMoveList = new ArrayList<Integer>();
        ArrayList<Integer> capList = new ArrayList<Integer>();
        int i = 0;
        boolean can = false;
        boolean cancap = false;
        ArrayList<Box> board = new ArrayList<Box>(this.board);
        while (i < size * size / 2) {
            if (board.get(i).getColor().equals(whoesmove())) {
                if (board.get(i).cancap()) {
                    capList.add(board.get(i).getId());
                    can = can || true;
                    cancap = cancap || true;
                } else if (board.get(i).canmove()) {
                    currentIdMoveList.add(board.get(i).getId());
                    can = can || true;
                }
            }
            i++;
        }

        if (cancap) {
            currentIdMoveList = capList;
        }
        return can;
    }

    public Box killBox(int x, int y, int id) {
        return new Box("white", false, x, y, id, false);
    }

    public Box CapBox(String color, boolean king, int x, int y, int id) {
        return new Box(color, king, x, y, id, true);
    }
    
    public Box NewBox(String color, boolean king, int x, int y, int id,boolean islive) {
        return new Box(color, king, x, y, id, islive);
    }

    public void moveStep0() {
        if (this.isGameOver()) {
            System.out.println("======Game Over!!======");
            board2Displaylist();
            // this.display();
            System.out.println("======Winner is: [" + this.getWinner()
                    + "]======");
            System.exit(1);
        } else {
            // System.out.println("Now is [" + currentplayer + "]'s turn\n");
            if (this.whoesmove().equals("+")) {
                setdisplaylist();
            }
            if (this.whoesmove().equals("o")) {
                currentIdMoveList = reverse(currentIdMoveList);
                setdisplaylist();
            }
        }
    }

    /*
     * public void moveStep1(int id) {
     * 
     * if (!currentIdMoveList.contains(id)) { throw new
     * NullPointerException("the box " + id + " can not be choosen"); } if
     * (board.get(id).KilledBoxId != 0) { board.get(id).cancap(); }
     * step1Hepler(id); setdisplaylist(); if
     * (this.getBoard().get(thisMoveId).isKing()) {
     * this.displayList.set(thisMoveId, "<<" + this.whoesmove() + ">>"); } else
     * if (!this.getBoard().get(thisMoveId).isKing()) {
     * this.displayList.set(thisMoveId, "<" + this.whoesmove() + ">"); }
     * this.display(); System.out.println("\n[" + this.whoesmove() +
     * "] Choose where to move to:"); }
     */

    public void moveStep1(int id) {
        if (id > this.currentIdMoveList.size()) {
            throw new NullPointerException("the box " + id
                    + " can not be choosen");
        }
        if (board.get(currentIdMoveList.get(id - 1)).KilledBoxId != 0) {
            board.get(currentIdMoveList.get(id - 1)).cancap();
        }
        step1Hepler(currentIdMoveList.get(id - 1));

        if (this.whoesmove().equals("+")
                && !this.getBoard().get(thisMoveId).isKing()) {
            currentIdMoveList = reverse(currentIdMoveList);
            setdisplaylist();
        } else if (this.whoesmove().equals("o")
                && !this.getBoard().get(thisMoveId).isKing()) {
            setdisplaylist();
        } else if (this.whoesmove().equals("+")
                && this.getBoard().get(thisMoveId).isKing()) {
            setdisplaylist();
        } else if (this.whoesmove().equals("o")
                && this.getBoard().get(thisMoveId).isKing()) {
            currentIdMoveList = reverse(currentIdMoveList);
            setdisplaylist();
        }

        if (this.getBoard().get(thisMoveId).isKing()
                && this.getBoard().get(thisMoveId).getColor().equals("+")) {
            this.displayList.set(thisMoveId, "<#>");
        }
        if (this.getBoard().get(thisMoveId).isKing()
                && this.getBoard().get(thisMoveId).getColor().equals("o")) {
            this.displayList.set(thisMoveId, "<@>");
        } else if (!this.getBoard().get(thisMoveId).isKing()) {
            this.displayList.set(thisMoveId, "<" + this.whoesmove() + ">");
        }

    }

    
    public void step1Hepler(int id) {
        thisMoveId = id;
        currentIdMoveList = board.get(id).getExistBoxIds();
    }

    public void moveStep2(int boxid) {
        if (boxid > this.currentIdMoveList.size()) {
            throw new NullPointerException("the box " + boxid
                    + " can not be a target");
        }
        Box x = getBoard().get(thisMoveId);
        if (x.cancap()) {

            Box y = getBoard().get(x.getKilledBoxId());
            Box z = getBoard().get(currentIdMoveList.get(boxid - 1));// new box
            this.board.set(
                    currentIdMoveList.get(boxid - 1),
                    CapBox(x.getColor(), x.isKing(), z.getX(), z.getY(),
                            z.getId()));
            this.board.set(y.getId(), killBox(y.getX(), y.getY(), y.getId()));
            this.board.set(x.getId(), killBox(x.getX(), x.getY(), x.getId()));
            thisMoveId = currentIdMoveList.get(boxid - 1);
            if (this.nextplayer.equals("+")) {
                this.countblk--;
            }
            if (this.nextplayer.equals("o")) {
                this.countred--;
            }
            afterMove2();
        } else {
            Box v = getBoard().get(currentIdMoveList.get(boxid - 1));
            this.board.set(
                    currentIdMoveList.get(boxid - 1),
                    CapBox(x.getColor(), x.isKing(), v.getX(), v.getY(),
                            v.getId()));// put it into new box
            this.board.set(x.getId(), killBox(x.getX(), x.getY(), x.getId()));
            thisMoveId = currentIdMoveList.get(boxid - 1);
            afterMove1();
        }
    }

    public void afterMove1() {
        Box x = getBoard().get(thisMoveId);
        if (x.touchDown()) {
            x.upgrade();
        }
        // System.out.println("good move!");
        board2Displaylist();
        // this.display();
        takeTurns();
        moveStep0();
    }

    public void afterMove2() {
        Box x = getBoard().get(thisMoveId);
        if (x.touchDown() && !x.isKing()) {
            x.upgrade();
            takeTurns();
            moveStep0();
        }
        else if (x.cancap()) {
            // System.out.println("good move!");
            moveStep0();
        }
        else if (!x.cancap()) {
            // System.out.println("good move!");
            board2Displaylist();
            takeTurns();
            moveStep0();
        }
    }

    // -------------------------------------------------UI----------------------

    // must run step 1
    /*
     * public void setdisplaylist() { board2Displaylist(); ArrayList<Integer>
     * l2 = new ArrayList<Integer>(currentIdMoveList); int i = 0; while (i <
     * l2.size()) { if (this.getBoard().get(l2.get(i)).isKing()) {
     * displayList.set(l2.get(i), "[[" + Integer.toString(l2.get(i)) + "]]"); }
     * else { displayList.set(l2.get(i), "[" + Integer.toString(l2.get(i)) +
     * "]"); } i++; } }
     */

    public void setdisplaylist() {
        board2Displaylist();
        ArrayList<Integer> l2 = new ArrayList<Integer>(currentIdMoveList);
        int i = 0;
        while (i < l2.size()) {
            if (this.getBoard().get(l2.get(i)).isKing()) {
                displayList.set(l2.get(i), "[[" + (i + 1) + "]]");
            } else {
                displayList.set(l2.get(i), "[" + (i + 1) + "]");
            }
            i++;
        }
    }

    public ArrayList<Integer> reverse(ArrayList<Integer> l1) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        int i = l1.size() - 1;
        while (i > -1) {
            l.add(l1.get(i));
            i--;
        }
        return l;
    }

    // /step 1 before set;

    public void board2Displaylist() {
        ArrayList<Box> board = new ArrayList<Box>(this.board);
        displayList = new ArrayList<String>();
        int i = 0;
        while (i < board.size()) {
            if (board.get(i).isKing() && board.get(i).getColor().equals("o")) {
                displayList.add("redking");
            } else if (board.get(i).isKing()
                    && board.get(i).getColor().equals("+")) {
                displayList.add("blackking");
            } else {
                displayList.add(board.get(i).getColor());
            }
            i++;
        }
    }

    public void board2Displaylist2() {
        ArrayList<Box> board = new ArrayList<Box>(this.board);
        displayList = new ArrayList<String>();
        int i = 0;
        while (i < board.size()) {
            displayList.add("[" + Integer.toString(board.get(i).getX())
                    + Integer.toString(board.get(i).getY()));
            i++;
        }
    }

    ArrayList<Box> getBoard() {
        return this.board;
    }

    ArrayList<Integer> getids() {
        ArrayList<Box> a = new ArrayList<Box>(this.getBoard());
        ArrayList<Integer> d = new ArrayList<Integer>();
        int i = 0;
        while (i < a.size()) {
            d.add(a.get(i).getId());
            i++;
        }
        return d;
    }

    public class Box {

        public String color;
        public boolean king;
        public int x;
        public int y;
        public int id;
        public boolean live;
        public ArrayList<Integer> ExistBoxIds = new ArrayList<Integer>();
        public int KilledBoxId = 0;

        public Box(String color, boolean king, int x, int y, int id,
                boolean live) {
            this.color = color;
            this.king = king;
            this.x = x;
            this.y = y;
            this.id = id;
            this.live = live;
        }

        // -------------------------------------------UpGrade--------
        public boolean touchDown() {
            if (this.color.equals("o") && this.x == 7) {
                return true;
            }
            if (this.color.equals("+") && this.x == 0) {
                return true;
            }
            return false;
        }

        public void upgrade() {
            this.king = true;
        }

        // -------------------------------------------can
        // cap--------------------------------------
        public boolean cancap() {
            ExistBoxIds = new ArrayList<Integer>();
            boolean can = false;
            boolean a = false;
            boolean b = false;
            boolean c = false;
            boolean d = false;
            if (isKing()) {                
                a = boxCanBeCap(x - 1, y - 1, x - 2, y - 2);
                c = boxCanBeCap(x - 1, y + 1, x - 2, y + 2);
                b = boxCanBeCap(x + 1, y - 1, x + 2, y - 2);
                d = boxCanBeCap(x + 1, y + 1, x + 2, y + 2);                
                can = a || b || c || d;
            } else if (this.getColor().equals("o")) {
                a = boxCanBeCap(x + 1, y + 1, x + 2, y + 2);
                b = boxCanBeCap(x + 1, y - 1, x + 2, y - 2);
                can = a || b;
            } else if (this.getColor().equals("+")) {
                a = boxCanBeCap(x - 1, y + 1, x - 2, y + 2);
                b = boxCanBeCap(x - 1, y - 1, x - 2, y - 2);
                can = a || b;
            }
            return can;
        }

        public boolean boxCanBeCap(int x, int y, int x1, int y1) {
            ArrayList<Box> ls = new ArrayList<Box>(getBoard());
            boolean exist = false;
            int i = 0;
            int rec = 0;
            while (i < ls.size()) {
                Box checkb = ls.get(i);
                if (checkb.getX() == x && checkb.getY() == y && checkb.isLive()
                        && !checkb.getColor().equals(this.getColor())
                        && boxExistafterkill(x1, y1, ls)) {
                    rec = i;
                    exist = exist || true;
                }
                i++;
            }
            if (exist) {
                KilledBoxId = ls.get(rec).getId();
            }
            return exist;
        }

        public boolean boxExistafterkill(int x, int y, ArrayList<Box> ls) {
            if (getBoxId(x, y) == -1) {
                return false;
            }
            int boxid = getBoxId(x, y);
            if (!ls.get(boxid).isLive()) {
                ExistBoxIds.add(ls.get(boxid).getId());
                return true;
            }
            return false;
        }

        public int getBoxId(int x, int y) {
            ArrayList<Box> ls = new ArrayList<Box>(getBoard());
            int newi = -1;
            int i = 0;
            while (i < ls.size()) {
                Box newbox = ls.get(i);
                if (newbox.getX() == x && newbox.getY() == y) {
                    newi = ls.get(i).getId();
                    break;
                }
                i++;
            }
            return newi;
        }

        // ------------------------------------------can
        // move-------------------------------------------
        public boolean canmove() {
            ExistBoxIds = new ArrayList<Integer>();
            boolean can = false;
            boolean a = false;
            boolean b = false;
            boolean c = false;
            boolean d = false;
            if (isKing()) {
                a = boxExist(x - 1, y - 1);
                c = boxExist(x - 1, y + 1); // 1
                b = boxExist(x + 1, y - 1);
                // 2
                d = boxExist(x + 1, y + 1); // 3
                // 4

                can = a || b || c || d;
            } else if (this.getColor().equals("o")) {
                a = boxExist(x + 1, y + 1);
                b = boxExist(x + 1, y - 1);
                can = a || b;
            } else if (this.getColor().equals("+")) {
                a = boxExist(x - 1, y + 1);
                b = boxExist(x - 1, y - 1);
                can = a || b;
            }
            if (can) {
                KilledBoxId = 0;
            }
            return can;
        }

        public boolean boxExist(int x, int y) {
            ArrayList<Box> ls = new ArrayList<Box>(getBoard());
            boolean exist = false;
            int i = 0;
            while (i < ls.size()) {
                if (ls.get(i).getX() == x && ls.get(i).getY() == y
                        && !ls.get(i).isLive()) {
                    exist = true;
                    break;
                }
                i++;
            }
            if (exist) {
                ExistBoxIds.add(ls.get(i).getId());
            }
            return exist;
        }

        public boolean atSide() {
            if (x == 0 || x == 7 || y == 0 || y == 7) {
                return true;
            }
            return false;
        }

        // ----------------------------------------getters
        // ----------------------------------

        public ArrayList<Integer> getExistBoxIds() {
            return ExistBoxIds;
        }

        public int getKilledBoxId() {
            return this.KilledBoxId;
        }

        public String getColor() {
            return color;
        }

        public boolean isKing() {
            return king;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getId() {
            return id;
        }

        public boolean isLive() {
            return live;
        }

    }
}
