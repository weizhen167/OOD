import java.util.ArrayList;
import java.util.Scanner;

public class Gameconsole {
    static String output;
    static String temp;
    static int coinindex;
    static int boardpo;
    static StrictCoinGameModel s1;
    static String playername;
    static int newpos;

    static void step1() {
        System.out.println("Please input game model of the game:");
        Scanner sca = new Scanner(System.in);
        output = sca.nextLine();
        System.out.println("Please input start player name of the game:");
        sca = new Scanner(System.in);
        playername = sca.nextLine();
        System.out.println("game model is: " + output + "?(please input Y/N)");
        step1_1();
    }

    static void step1_1() {
        Scanner sca = new Scanner(System.in);
        temp = sca.nextLine();
        if (temp.equals("N")) {
            step1();
        }
        if (temp.equals("Y")) {
            step2_1();
        } else {
            System.out.println("Please input'Y' or 'N'");
            step1_1();
        }
    }

    static void step2_1() {
        try {
        s1 = new StrictCoinGameModel(output, playername);
        } catch (IllegalArgumentException e) {
            System.out.println("");
            System.out.println("");
            System.out.println("!!!!!!!Warning!!!!!!!");
            System.out.println(e);
            System.out.println("");
            System.out.println("");
            step1();
        }
        step3();
    }
    
    static void stepaddplayer(){
        System.out.println("input a new postion?");
        Scanner sca = new Scanner(System.in);
        newpos = Integer.parseInt(sca.nextLine());
        System.out.println("input a new player name?");
        sca = new Scanner(System.in);
        playername = sca.nextLine();
        try {
            s1.addNewPlayer(newpos, playername);
        } catch(IllegalArgumentException e) {
            System.out.println("");
            System.out.println("");
            System.out.println("!!!!!!!Warning!!!!!!!");
            System.out.println(e);
            stepaddplayer();
        }
        step3();
    }

    static void step3() {
        System.out.println("What coin do you want to move?");
        System.out.println("please input index of coin");
        System.out.println("or you can input 'addnew' to input anther player");
        Scanner sca = new Scanner(System.in);
        String str = sca.nextLine();
        if (str.equals("addnew")) {
            stepaddplayer();
        }
        try {
            coinindex = Integer.parseInt(str);
            System.out.println("which Position do you want place this coin?");
            System.out.println("please input a new Position");
            step3_1();
        } catch (NumberFormatException e) {
            System.out.println("");
            System.out.println("");
            //System.out.println("!!!!!!!Warning!!!!!!!");
            //System.out.println("please input a number as index of coin");
            System.out.println("");
            System.out.println("");
            step3();
        }
    }

    static void step3_1() {
        Scanner sca = new Scanner(System.in);
        String str = sca.nextLine();
        try {
            boardpo = Integer.parseInt(str);
            step4();
        } catch (NumberFormatException e) {
            System.out.println("");
            System.out.println("");
            //System.out.println("!!!!!!!Warning!!!!!!!");
            //System.out.println("please input a number as new board Position");
            System.out.println("");
            System.out.println("");
            step3_1_1();
        }
    }

    static void step3_1_1() {
        System.out.println("which Position do you want place this coin?");
        System.out.println("please input a new Position");
        System.out.println("or you can input 'addnew' to input anther player");
        Scanner sca = new Scanner(System.in);
        String str = sca.nextLine();
        if (str.equals("addnew")) {
            stepaddplayer();
        }
        try {
            boardpo = Integer.parseInt(str);
            step4();
        } catch (NumberFormatException e) {
            System.out.println("");
            System.out.println("");
            System.out.println("!!!!!!!Warning!!!!!!!");
            System.out.println("please input a number as new board Position");
            System.out.println("");
            System.out.println("");
            step3_1_1();
        }
    }

    public static String list2str(ArrayList<Integer> i) {
        ArrayList<Integer> n1 = new ArrayList<Integer>(i);
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

    static void step4() {
        try {
            s1.move(coinindex, boardpo);
        } catch (IllegalArgumentException e) {
            System.out.println("");
            System.out.println("");
            System.out.println("!!!!!!!Warning!!!!!!!");
            System.out.println(e);
            System.out.println("");
            System.out.println("");
            step3();
        }
    }

    public static void main(String args[]) {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out
                .println("    :5G8Shh3G&i    .r93hh3&9i     ;SAAA5;   1AH&r    "
                        + ";9&1:         i3G8ShhS8&h          :G5"
                        + "     .i9HAX.     .9AAXs:  :5AAA5hhSGH3 ");
        System.out
                .println("  1A@Mh,    3B   ,3M@S,   G@@5     G@@8     sA#@@r  "
                        + "  Gh        ,3B@H1.    ;M;        :3#@h       G#@@i "
                        + "   sG@@@i     9@@G   .,8r ");
        System.out
                .println(" X@@&.          rM@@r     8@@B    r@@B.    ,&.:M@@s"
                        + "  s8        iM@@3        .       ,5SB@@s      S13@@5 "
                        + " ,3hG@@3     ;@@#:,:5h    ");
        System.out
                .println("3@@M.          ;@@@S     :#@@5    B@@s     9h  :B@@s"
                        + " X:        B@@X    ;h55Si      13r A@@i     ;X 1@@X "
                        + "s8i;@@B.     A@@815A#.    ");
        System.out
                .println("A@@8           8@@M.    .H@@3    3@@X     iX    ,H@@&h"
                        + "        .M@@h     H@@G.    s8Xh15#@@:     Xr :@@#9S."
                        + " H@@s     h@@&   :i     ");
        System.out
                .println("s@@B:    .i;   r@@B    iB@&r    i@@#,    .&;     ,A@H "
                        + "         s#@A.   1@@B    i35. . :@@@.    59   B@Ai"
                        + "  3@@G     :#@@:    ,53.  ");
        System.out
                .println(" ;9HH8Shhhi.    iGH8113&9i    :s&BBX;   i8Hr.     .X; "
                        + "          :SA&S1hAH&i  i3B5    ;5BBHs.  hHS:  93 "
                        + " ;5BBBS:  ,rGBBAh1h3GHH:   ");
        System.out.println("============================================"
                + "==========================================="
                + "=============================================");
        System.out.println("============================================="
                + "============================================"
                + "===========================================");
        System.out.println("==========================================="
                + "==========================================="
                + "==============================================");
        System.out.println("");
        System.out.println("");
        step1();

    }
}
