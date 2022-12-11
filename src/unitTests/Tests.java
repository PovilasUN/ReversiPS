package unitTests;

import main.Board;
import main.Player;
import org.junit.jupiter.api.*;

public class Tests {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("**--- Start of Unit Testing ---**");
    }

    @Test
    public void addPointsToXPlayer() {
        var board = Board.getInstance();
        var count = board.countSymbol('X');
        Assertions.assertEquals(2, count);
    }

    @Test
    public void switchPlayersSymbol() {
        var player = new Player('X');
        player.switchPlayer();
        Assertions.assertEquals('O', player.getSymbol());
    }

    @Test
    public void checkIfTheBoardIsFull() {
        var board = Board.getInstance();
        var checkFull = board.isBoardFull();
        Assertions.assertEquals(false, checkFull);
    }

    @AfterEach
    void afterEach() {
        System.out.println("**--- Test finished ---**");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("**--- End of Unit Testing ---**");
    }
}
