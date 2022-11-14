public class ReversiGame {
    private final Board gameBoard = new Board();
    private final Player playerX = new Player('X');
    private final Player playerO = new Player('O');
    private final Player currentTurn = playerX;
    private final Player currentOpponent = playerO;


    public void playGame() {
        while (true) {
            gameBoard.renderBoard();
            System.out.println("X current score: " + gameBoard.countXOrO('X'));
            System.out.println("X current score: " + gameBoard.countXOrO('O'));
            currentTurn.getPlayerInput();

            if (GameLogic.validateMove(gameBoard.getBoard(), currentTurn.getXCord(), currentTurn.getYCord(), currentTurn.getSymbol(), currentOpponent.getSymbol()) || (currentTurn.getXCord() == -1)) {
                if (currentTurn.getXCord() != -1) {
                    GameLogic.makeMove(gameBoard.getBoard(), currentTurn.getXCord(), currentTurn.getYCord(), currentTurn.getSymbol(), currentOpponent.getSymbol());
                    currentTurn.switchPlayer();
                    currentOpponent.switchPlayer();
                    if (gameBoard.isBoardFull()) {
                        System.out.println("Game finished. The winner is " + gameBoard.returnWinner());
                        break;
                    }
                }
            } else if (!GameLogic.hasValidMoves(gameBoard.getBoard(), currentTurn.getXCord(), currentTurn.getYCord(), currentTurn.getSymbol(), currentOpponent.getSymbol())) {
                System.out.println("Game finished. You ran out of moves. Winner is Player " + currentOpponent.getSymbol());
            } else {
                System.out.println("Invalid move. Enter move coordinates again.");
            }
        }
    }
}
