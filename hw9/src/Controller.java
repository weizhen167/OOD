
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Controller {

    IntReader sca;
    static int size = 0;
    static int input = 0;
    Draught d1;
    static final IntReader.IntValidator validator = new MyValidator();
    BoardView i;
    ArrayList<Integer> lll = new ArrayList<Integer>();

    Controller(Draught model, InputStream input, Appendable output) {
        this.sca = IntReader.create(input, output,
                "Input must be a number, please reInput");
        this.d1 = model;
        this.i = new BoardView(output);
    }

    void step1() throws IOException {
        d1.moveStep0();
        // System.out.println("\n==========Game Start!!==========\n\n\n");
    }

    void step2() throws IOException {
        this.display();
        input = sca.nextInt(
                "[" + d1.whoesmove() + "] Choose a piece to move: ", validator);
        if(input == 000) {
            System.out.println(lll);
        } else {
        try {            
            d1.moveStep1(input);
            lll.add(input);
            this.display();
        } catch (NullPointerException e) {
            System.err.println("!!Warning" + e.getMessage() + "\n");
            System.out.println("Please reinput...");
            step2();
        }
        step3();
    }
    }

    void step3() throws IOException {

        input = sca.nextInt("[" + d1.whoesmove()
                + "] Choose where to move to: ", validator);
        try {            
            d1.moveStep2(input);
            lll.add(input);
        } catch (NullPointerException e) {
            System.err.println("!!Warning" + e.getMessage() + "\n");
            System.out.println("Please reinput...");
            step3();
        }
        step2();
    }

    public void display() {
        if (d1.whoesmove().equals("o")) {
            d1.reddisplay = new RedSideDisplay(d1.PosBoard, display1());
            try {
                i.draw(d1.reddisplay);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            d1.blkdisplay = new BlackSideDisplay(d1.PosBoard, display1());
            try {
                i.draw(d1.blkdisplay);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // can display by set board
    private ArrayList<String> display1() {
        ArrayList<String> l1 = new ArrayList<String>(d1.displayList);
        int i = 0;
        while (i < l1.size()) {
            String s = d1.displayList.get(i);
            if (s.equals("redking")) {
                l1.set(i, "@");
            }
            if (s.equals("blackking")) {
                l1.set(i, "#");
            }
            if (s.equals("o")) {
                l1.set(i, "o");
            }
            if (s.equals("+")) {
                l1.set(i, "+");
            }
            if (s.equals("white")) {
                l1.set(i, " ");
            }
            i++;
        }
        return l1;
    }

    void playGame() throws IOException {
        step1();
        step2();
    }

}
