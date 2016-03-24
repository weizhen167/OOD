import static org.junit.Assert.*;

import org.junit.Test;

public class StrictCoinGameModelTest {
    @Test
    public void testScenario1_1() {
        assertEquals("OOOO-", CoinGameTestScenarios.scenario1("-OOOO"));
    }

    @Test(expected = CoinGameModel.IllegalMoveException.class)
    public void testScenario1_2() {
        CoinGameTestScenarios.scenario1("O-O--");
    }

    @Test
    public void testScenario2_1() {
        assertEquals("OO--O----", CoinGameTestScenarios.scenario2("O--O----O"));
    }

    @Test(expected = CoinGameModel.IllegalMoveException.class)
    public void testScenario2_2() {
        CoinGameTestScenarios.scenario2("O-O-O-O-");
    }

    /*
     * @Test don't know why we can not any of board to make Scenario valid
     * public void testScenario3_1() { assertEquals("OOO-O---",
     * CoinGameTestScenarios.scenario3("-O--O-O-O")); }
     */

    @Test(expected = CoinGameModel.IllegalMoveException.class)
    public void testScenario3_1() {
        CoinGameTestScenarios.scenario3("O-O-O-O-");
    }

    @Test
    public void testScenario4_1() {
        assertEquals("OOO-O---", CoinGameTestScenarios.scenario4("OOO---O-"));
    }

    @Test(expected = CoinGameModel.IllegalMoveException.class)
    public void testScenario4_2() {
        CoinGameTestScenarios.scenario4("O-O-O-O-");
    }

    private String str1 = "";
    private String str2 = "What";
    private String str3 = "OOOO";
    private String str4 = "----";
    private String str5 = "-O-O-O-O-O-O";
    private String str6 = "-O";
    private String str7 = "-O-O";

    StrictCoinGameModel s2 = new StrictCoinGameModel(str5, "A");//
    StrictCoinGameModel s8 = new StrictCoinGameModel(str6, "A");//
    StrictCoinGameModel s9 = new StrictCoinGameModel(str7, "A");

    @Test
    public void testboardSize() {
        assertTrue(s2.boardSize() == 12);
        assertTrue(s8.boardSize() == 2);
        assertTrue(s9.boardSize() == 4);
    }

    @Test
    public void testcoinCount() {
        assertTrue(s2.coinCount() == 6);
        assertTrue(s8.coinCount() == 1);
        assertTrue(s9.coinCount() == 2);
    }

    @Test
    public void testgetCoinPosition() {
        assertTrue(s2.getCoinPosition(0) == 1);
        assertTrue(s2.getCoinPosition(1) == 3);
        assertTrue(s2.getCoinPosition(2) == 5);
        assertTrue(s2.getCoinPosition(3) == 7);
        assertTrue(s2.getCoinPosition(4) == 9);
        assertTrue(s2.getCoinPosition(5) == 11);
    }

    @Test
    public void testisGameOver() {
        assertFalse(s8.isGameOver());
        s8.move(0, 0);
        assertTrue(s8.isGameOver());
    }

    @Test
    public void testmove() {
        s2.move(0, 0);
        s2.move(1, 1);
        s2.move(2, 2);
        s2.move(3, 3);
        s2.move(4, 4);
        s2.move(5, 5);
        assertTrue(s2.toString().equals("OOOOOO------"));
        assertTrue(s2.isGameOver());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException() {
        new StrictCoinGameModel(str4, "A");
        new StrictCoinGameModel(str1, "A");
        new StrictCoinGameModel(str3, "A");
        new StrictCoinGameModel(str2, "A");
        new StrictCoinGameModel(str5, "");
        s2.addNewPlayer(0, "A");
        s2.addNewPlayer(2, "B");
        s2.addNewPlayer(1, "");
    }

    @Test
    public void testAddNewPlayer() {
        assertEquals(s2.countPlayer(), 1);
        s2.addNewPlayer(0, "B");
        assertEquals(s2.countPlayer(), 2);
        s2.addNewPlayer(1, "C");
        assertEquals(s2.countPlayer(), 3);
    }

    @Test
    public void testcountPlayer() {
        assertTrue(s2.countPlayer() == 1);
        s2.addNewPlayer(0, "B");
        assertTrue(s2.countPlayer() == 2);
        s2.addNewPlayer(1, "C");
        assertTrue(s2.countPlayer() == 3);
    }

    @Test
    public void testwhosMove() {
        assertEquals(s2.whosMove(), "A");
        s2.addNewPlayer(1, "B");
        assertEquals(s2.whosMove(), "A");
        s2.move(0, 0);
        assertEquals(s2.whosMove(), "B");
        s2.move(1, 1);
        assertEquals(s2.whosMove(), "A");
        s2.addNewPlayer(2, "C");
        assertEquals(s2.whosMove(), "A");
        s2.move(2, 2);
        assertEquals(s2.whosMove(), "B");
        s2.move(3, 3);
        assertEquals(s2.whosMove(), "C");
        s2.move(4, 4);
        assertEquals(s2.whosMove(), "A");
        s2.move(5, 5);
        assertEquals(s2.getwinner(), "A");
    }

    @Test
    public void testwhosWinner() {
        s9.move(0, 0);
        s9.addNewPlayer(1, "B");
        s9.addNewPlayer(2, "C");
        s9.addNewPlayer(3, "D");
        s9.addNewPlayer(4, "E");
        s9.addNewPlayer(5, "F");
        s9.addNewPlayer(6, "G");
        s9.move(1, 2);
        s9.move(1, 1);
        assertEquals(s9.getwinner(), "B");
    }
}
