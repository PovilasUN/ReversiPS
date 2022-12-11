package main;

import utils.Validator;

public class ReversiGame {
    private final Board gameBoard = Board.getInstance();
    private final Player playerX = new Player('X');
    private final Player playerO = new Player('O');
    private final Player currentTurn = playerX;
    private final Player currentOpponent = playerO;

    private Validator validator;
    private GameLogic gameLogic;

    public ReversiGame(Validator validator, GameLogic gameLogic) {
        this.validator = validator;
        this.gameLogic = gameLogic;
    }

    public void playGame() {
        while (true) {
            gameBoard.renderBoard();
            System.out.println("X current score: " + gameBoard.countSymbol('X'));
            System.out.println("X current score: " + gameBoard.countSymbol('O'));
            currentTurn.getPlayerInput();

            if (validator.validateMove(gameBoard.getBoard(), currentTurn.getXCord(), currentTurn.getYCord(), currentTurn.getSymbol(), currentOpponent.getSymbol()) || (currentTurn.getXCord() == -1)) {
                if (currentTurn.getXCord() != -1) {
                    gameLogic.makeMove(gameBoard.getBoard(), currentTurn.getXCord(), currentTurn.getYCord(), currentTurn.getSymbol(), currentOpponent.getSymbol());
                    currentTurn.switchPlayer();
                    currentOpponent.switchPlayer();
                    if (gameBoard.isBoardFull()) {
                        System.out.println("Game finished. The winner is " + gameBoard.returnWinner());
                        break;
                    }
                }
            } else if (!validator.hasValidMoves(gameBoard.getBoard(), currentTurn.getXCord(), currentTurn.getYCord(), currentTurn.getSymbol(), currentOpponent.getSymbol())) {
                System.out.println("Game finished. You ran out of moves. Winner is main.Player " + currentOpponent.getSymbol());
            } else {
                System.out.println("Invalid move. Enter move coordinates again.");
            }
        }
    }
}
