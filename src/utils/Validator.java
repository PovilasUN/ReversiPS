package utils;

public interface Validator {

    boolean validateMove(char[][] gameBoard, int xCord, int yCord, char currentTurn, char currentOpponent);
    boolean hasValidMoves(char[][] gameBoard, int xCord, int yCord, char currentTurn, char currentOpponent);
    boolean check(char[][] gameBoard, int xCord, int yCord, int dirX, int dirY, char currentTurn, char opponentSymbol);
}
