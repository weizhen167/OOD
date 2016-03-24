import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class CoinGameModelAdaptorTest {

    String[] list0 = {};
    String[] list1 = { "p1", "p2", "p3" };
    String[] list2 = { "p1", "p2" };
    String[] list3 = { "p1", "pp", "" };

    private String str1 = "";
    private String str2 = "What";
    private String str3 = "OOOO";
    private String str4 = "----";
    private String str5 = "-O-O-O-O-O-O";
    private String str6 = "-O";
    private String str7 = "-OO-";
    private String str8 = "O---------O";
    private String str9 = "O-O--O-OOO-OO-O";

    CoinGameModelAdaptor m1 = CoinGameModelAdaptor.fromString(str5, "p1");
    CoinGameModelAdaptor m2 = CoinGameModelAdaptor.fromString(str6, "p1");
    CoinGameModelAdaptor m3 = CoinGameModelAdaptor.fromString(str7, "p1");
    CoinGameModelAdaptor m4 = CoinGameModelAdaptor.fromString(str8, "p8",
            "p12", "p1", "p2", "p3");
    CoinGameModelAdaptor m5 = CoinGameModelAdaptor.fromString(str9, "p1");

    @Test
    public void testboardSize() {
        assertEquals(m1.boardSize(), 12);
        assertEquals(m2.boardSize(), 2);
        assertEquals(m3.boardSize(), 4);
    }

    @Test
    public void testcoinCount() {
        assertEquals(m1.coinCount(), 6);
        assertEquals(m2.coinCount(), 1);
        assertEquals(m3.coinCount(), 2);
        assertEquals(m4.coinCount(), 2);
        assertEquals(m5.coinCount(), 9);
    }

    @Test
    public void testgetCoinPositions() {
        int[] bit = m1.getCoinPositions();
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        for (int i = 0; i < bit.length; i++) {
            l1.add(bit[i]);
        }
        ArrayList<Integer> l11 = new ArrayList<Integer>(Arrays.asList(1, 3, 5,
                7, 9, 11));
        assertEquals(l11, l1);

        bit = m2.getCoinPositions();
        l1 = new ArrayList<Integer>();
        for (int i = 0; i < bit.length; i++) {
            l1.add(bit[i]);
        }
        ArrayList<Integer> l22 = new ArrayList<Integer>(Arrays.asList(1));
        assertEquals(l22, l1);

        bit = m3.getCoinPositions();
        l1 = new ArrayList<Integer>();
        for (int i = 0; i < bit.length; i++) {
            l1.add(bit[i]);
        }
        ArrayList<Integer> l33 = new ArrayList<Integer>(Arrays.asList(1, 2));
        assertEquals(l1, l33);

        bit = m4.getCoinPositions();
        l1 = new ArrayList<Integer>();
        for (int i = 0; i < bit.length; i++) {
            l1.add(bit[i]);
        }
        ArrayList<Integer> l44 = new ArrayList<Integer>(Arrays.asList(0, 10));
        assertEquals(l1, l44);
    }

    @Test
    public void testgetPlayOrder() {
        m1.addPlayerAfter(m1.getCurrentPlayer(), "p2");
        m1.addPlayerAfter(m1.getCurrentPlayer(), "p3");
        m1.addPlayerAfter(m1.getCurrentPlayer(), "p4");
        m1.addPlayerAfter(m1.getCurrentPlayer(), "p5");

        ArrayList<String> l1 = new ArrayList<String>();
        CoinGamePlayer[] bit = m1.getPlayOrder();
        for (int i = 0; i < bit.length; i++) {
            l1.add(bit[i].getName());
        }
        ArrayList<String> l11 = new ArrayList<String>(Arrays.asList("p1", "p5",
                "p4", "p3", "p2"));
        assertEquals(l1, l11);

        bit = m2.getPlayOrder();
        l1 = new ArrayList<String>();
        for (int i = 0; i < bit.length; i++) {
            l1.add(bit[i].getName());
        }
        ArrayList<String> l22 = new ArrayList<String>(Arrays.asList("p1"));
        assertEquals(l22, l1);

        ArrayList<String> l33 = new ArrayList<String>(Arrays.asList("p1", "p4"));

        m3.addPlayerAfter(m3.getCurrentPlayer(), "p4");
        bit = m3.getPlayOrder();
        l1 = new ArrayList<String>();
        for (int i = 0; i < bit.length; i++) {
            l1.add(bit[i].getName());
        }
        assertEquals(l33, l1);

        m5.addPlayerAfter(m5.getplayer("p1"), "p2");
        m5.addPlayerAfter(m5.getCurrentPlayer(), "p3");
        m5.addPlayerAfter(m5.getplayer("p3"), "p4");
        m5.addPlayerAfter(m5.getplayer("p2"), "p5");
        m5.addPlayerAfter(m5.getplayer("p2"), "p6");
        m5.addPlayerAfter(m5.getplayer("p3"), "p7");
        m5.getCurrentPlayer().move(1, 1);
        m5.getCurrentPlayer().move(2, 2);
        m5.getCurrentPlayer().move(3, 3);
        m5.addPlayerAfter(m5.getCurrentPlayer(), "p8");
        m5.getCurrentPlayer().move(4, 4);
        m5.getCurrentPlayer().move(5, 5);
        m5.addPlayerAfter(m5.getCurrentPlayer(), "p9");
        m5.addPlayerAfter(m5.getplayer("p1"), "p10");
        m5.addPlayerAfter(m5.getplayer("p8"), "p11");
        m5.getCurrentPlayer().move(6, 6);

        l1 = new ArrayList<String>();
        bit = m5.getPlayOrder();
        for (int i = 0; i < bit.length; i++) {
            l1.add(bit[i].getName());
        }
        ArrayList<String> l55 = new ArrayList<String>(Arrays.asList("p1",
                "p10", "p3", "p7", "p4", "p8", "p11", "p2", "p9", "p6", "p5"));
        assertEquals(l55, l1);
        m4.addPlayerAfter(m4.getplayer("p3"), "p4");
    }

    @Test
    public void testgetWinner() {
        m1.addPlayerAfter(m1.getCurrentPlayer(), "p2");
        m1.addPlayerAfter(m1.getCurrentPlayer(), "p3");
        m1.addPlayerAfter(m1.getCurrentPlayer(), "p4");
        m1.addPlayerAfter(m1.getCurrentPlayer(), "p5");
        assertNull(m1.getWinner());
        m1.getCurrentPlayer().move(0, 0);
        m1.getCurrentPlayer().move(1, 1);
        m1.getCurrentPlayer().move(2, 2);
        m1.getCurrentPlayer().move(3, 3);
        m1.addPlayerAfter(m1.getCurrentPlayer(), "p6");
        assertNull(m1.getWinner());
        m1.getCurrentPlayer().move(4, 4);
        assertNull(m1.getWinner());
        m1.getCurrentPlayer().move(5, 5);
        assertEquals(m1.getWinner().getName(), "p6");
    }

    @Test
    public void testgetCurrentPlayer() {
        assertEquals(m5.getCurrentPlayer().getName(), "p1");
        m5.getCurrentPlayer().move(8, 13); // O-O--O-OOO-OO-O 14 9
        assertEquals(m5.getCurrentPlayer().getName(), "p1");
        m5.addPlayerAfter(m5.getCurrentPlayer(), "p2");
        m5.getCurrentPlayer().move(2, 4); // O-O--O-OOO-OOO
        assertEquals(m5.getCurrentPlayer().getName(), "p2");
        m5.getCurrentPlayer().move(3, 5); // O-O-O--OOO-OOO
        assertEquals(m5.getCurrentPlayer().getName(), "p1");
        m5.addPlayerAfter(m5.getCurrentPlayer(), "p3");
        m5.addPlayerAfter(m5.getCurrentPlayer(), "p4");
        m5.getCurrentPlayer().move(4, 6); // O-O-OOOOOOO
        assertEquals(m5.getCurrentPlayer().getName(), "p4");
        m5.addPlayerAfter(m5.getCurrentPlayer(), "p5");
        m5.getCurrentPlayer().move(5, 7);
        assertEquals(m5.getCurrentPlayer().getName(), "p5");
        m5.getCurrentPlayer().move(6, 8);
        assertEquals(m5.getCurrentPlayer().getName(), "p3");
        assertNull(m5.getWinner());
        m5.getCurrentPlayer().move(7, 9);
        assertEquals(m5.getCurrentPlayer().getName(), "p2");
        m5.addPlayerAfter(m5.getCurrentPlayer(), "p6");
        m5.getCurrentPlayer().move(8, 10);
        assertEquals(m5.getCurrentPlayer().getName(), "p6");
        m5.getCurrentPlayer().move(1, 1);
        assertEquals(m5.getCurrentPlayer().getName(), "p1");
        assertNull(m5.getWinner());
        m5.addPlayerAfter(m5.getCurrentPlayer(), "p7");
        m5.getCurrentPlayer().move(2, 2);
        assertEquals(m5.getCurrentPlayer().getName(), "p7");
        m5.addPlayerAfter(m5.getCurrentPlayer(), "p8");
        m5.getCurrentPlayer().move(3, 3);
        m5.addPlayerAfter(m5.getCurrentPlayer(), "p9");
        assertEquals(m5.getCurrentPlayer().getName(), "p8");
        m5.getCurrentPlayer().move(4, 4);
        assertEquals(m5.getCurrentPlayer().getName(), "p9");
        assertNull(m5.getWinner());
        m5.getCurrentPlayer().move(5, 5);
        assertEquals(m5.getCurrentPlayer().getName(), "p4");
        m5.getCurrentPlayer().move(6, 6);
        assertEquals(m5.getCurrentPlayer().getName(), "p5");
        assertNull(m5.getWinner());
        m5.getCurrentPlayer().move(7, 7);
        assertEquals(m5.getCurrentPlayer().getName(), "p3");
        m5.getCurrentPlayer().move(8, 8);
        assertEquals(m5.getWinner().getName(), "p3");
        assertNull(m5.getCurrentPlayer());
    }

    @Test
    public void testaddPlayerAfter() {
        assertEquals(m1.addPlayerAfter(m1.getplayer("p1"), "p2").getName(),
                "p2");
        assertEquals(m1.addPlayerAfter(m1.getCurrentPlayer(), "p3").getName(),
                "p3");
        assertEquals(m1.addPlayerAfter(m1.getplayer("p3"), "p4").getName(),
                "p4");
        assertEquals(m1.addPlayerAfter(m1.getplayer("p2"), "p5").getName(),
                "p5");
        m1.getCurrentPlayer().move(0, 0);
        m1.getCurrentPlayer().move(1, 1);
        assertEquals(m1.addPlayerAfter(m1.getplayer("p2"), "p6").getName(),
                "p6");
        m1.getCurrentPlayer().move(2, 2);
        m1.getCurrentPlayer().move(3, 3);
        assertEquals(m1.addPlayerAfter(m1.getplayer("p3"), "p7").getName(),
                "p7");
        m1.getCurrentPlayer().move(4, 4);// [p1, p3, p7, p4, p2, p6, p5, p8]
        assertEquals(m1.addPlayerAfter(m1.getCurrentPlayer(), "p8").getName(),
                "p8");
        m1.getCurrentPlayer().move(5, 5);// 1 3 7 4 2 6 5
    }

    @Test
    public void testPlayerequals() {
        m4.addPlayerAfter(m4.getplayer("p3"), "p3");
        assertEquals(m4.getPlayOrder()[4].getName(),
                m4.getPlayOrder()[5].getName());
        assertFalse(m4.getPlayOrder()[4].equals(m4.getPlayOrder()[5]));
        CoinGamePlayer[] bit = m4.getPlayOrder();
        ArrayList<String> l1 = new ArrayList<String>();
        for (int i = 0; i < bit.length; i++) {
            l1.add(bit[i].getName());
        }
        ArrayList<String> l11 = new ArrayList<String>(Arrays.asList("p8",
                "p12", "p1", "p2", "p3", "p3"));
        assertEquals(l1, l11);
        m4.getCurrentPlayer().move(1, 9);
        m4.getCurrentPlayer().move(1, 8);
        m4.getCurrentPlayer().move(1, 7);
        m4.getCurrentPlayer().move(1, 6);
        m4.getCurrentPlayer().move(1, 5);
        m4.getCurrentPlayer().move(1, 4);
        m4.getCurrentPlayer().move(1, 3);
        assertNull(m4.getWinner());
        m4.getCurrentPlayer().move(1, 2);
        m4.getCurrentPlayer().move(1, 1);
        assertEquals(m4.getWinner().getName(), "p1");
        assertNull(m4.getCurrentPlayer());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException1() {
        CoinGameModelAdaptor.fromString(str1, list1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException2() {
        CoinGameModelAdaptor.fromString(str2, list1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException3() {
        CoinGameModelAdaptor.fromString(str3, list1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException4() {
        CoinGameModelAdaptor.fromString(str4, list1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException5() {
        CoinGameModelAdaptor.fromString(str5, list0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException6() {
        CoinGameModelAdaptor.fromString(str5, list3);
    }

    @Test(expected = NullPointerException.class)
    public void testException7() {
        CoinGameModelAdaptor.fromString(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void testException8() {
        CoinGameModelAdaptor.fromString(str5, null);
    }

    @Test(expected = NullPointerException.class)
    public void testException9() {
        CoinGameModelAdaptor.fromString(null, list1);
    }

    @Test(expected = NullPointerException.class)
    public void testException10() {
        m1.addPlayerAfter(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void testException11() {
        m1.addPlayerAfter(m1.getCurrentPlayer(), null);
    }

    @Test(expected = NullPointerException.class)
    public void testException12() {
        m1.addPlayerAfter(null, "p4");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException14() {
        m1.addPlayerAfter(m1.getCurrentPlayer(), "");
    }

    @Test(expected = NullPointerException.class)
    public void testException15() {
        m2.getCurrentPlayer().move(0, 0);
        m2.addPlayerAfter(m2.getCurrentPlayer(), "p2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException16() {
        m3.getCurrentPlayer().move(1, 3);// -00- 1 2
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException17() {
        m3.getCurrentPlayer().move(1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException18() {
        m3.getCurrentPlayer().move(1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException19() {
        m3.getCurrentPlayer().move(1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException20() {
        m3.getCurrentPlayer().move(1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException21() {
        m3.getCurrentPlayer().move(3, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException22() {
        m3.getCurrentPlayer().move(-3, 3);
    }
}
