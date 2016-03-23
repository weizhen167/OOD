import java.io.IOException;

import org.junit.Test;

public class TestDraught {

    @Test
    public void testGame() throws IOException {
       NetworkClientTester.assertGameMatches(
                (input, output) -> new Controller(Draught.make8x8game(), input,
                        output).playGame(), 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

        NetworkClientTester.assertGameMatches(
                (input, output) -> new Controller(Draught.make8x8game(), input,
                        output).playGame(), 3, 2, 1, 1, 1, 1, 3, 2, 4, 1, 5, 1,
                6, 1, 2, 2, 4, 1, 1, 1, 1, 1, 3, 2, 2, 1, 2, 1, 1, 1, 1, 1, 2,
                1, 1, 1, 4, 1, 3, 1, 1, 1, 2, 2);

        NetworkClientTester.assertGameMatches(
                (input, output) -> new Controller(Draught.make8x8game(), input,
                        output).playGame(), 2, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2,
                3, 2, 5, 2, 2, 1, 2, 1, 6, 1, 5, 2, 1, 1, 2, 1, 2, 1, 2, 2, 2,
                1, 4, 2, 6, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1,
                4, 1, 1, 1, 4, 1, 1, 2, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1);

        NetworkClientTester.assertGameMatches(
                (input, output) -> new Controller(Draught.make8x8game(), input,
                        output).playGame(), 3, 2, 3, 1, 1, 1, 2, 1, 3, 1, 1, 1,
                1, 1, 2, 1, 1, 1, 2, 1, 3, 1, 2, 1, 3, 1, 1, 1, 5, 1, 1, 1, 1,
                1, 1, 1, 2, 1, 1, 1, 1, 1, 5, 2, 3, 1, 4, 1, 3, 1, 5, 1, 3, 1,
                1, 1, 1, 2, 1, 1, 1, 1, 5, 1, 1, 1, 7, 1, 1, 1, 4, 1, 1, 1, 2,
                1, 1, 3, 4, 1, 1, 2);
    }
}
//