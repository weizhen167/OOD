
public class ConsoleMain {
    public static void main(String args[]) throws Exception {
        new Controller(Draught.make8x8game(), System.in, System.out).playGame();
    }
}
