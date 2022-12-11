package utils;

public class ValidatorImpl implements Validator {

    public boolean validateMove(char[][] gameBoard, int xCord, int yCord, char currentTurn, char currentOpponent) {
        if (gameBoard[xCord][yCord] != 0)
            return false;
        if (check(gameBoard, xCord - 1, yCord, -1, 0, currentTurn, currentOpponent))
            return true;
        if (check(gameBoard, xCord + 1, yCord, 1, 0, currentTurn, currentOpponent))
            return true;
        if (check(gameBoard, xCord, yCord - 1, 0, -1, currentTurn, currentOpponent))
            return true;
        if (check(gameBoard, xCord, yCord + 1, 0, 1, currentTurn, currentOpponent))
            return true;
        if (check(gameBoard, xCord - 1, yCord - 1, -1, -1, currentTurn, currentOpponent))
            return true;
        if (check(gameBoard, xCord + 1, yCord - 1, 1, -1, currentTurn, currentOpponent))
            return true;
        if (check(gameBoard, xCord - 1, yCord + 1, -1, 1, currentTurn, currentOpponent))
            return true;
        if (check(gameBoard, xCord + 1, yCord + 1, 1, 1, currentTurn, currentOpponent))
            return true;
        return false;
    }

    public boolean hasValidMoves(char[][] gameBoard, int xCord, int yCord, char currentTurn, char currentOpponent) {
        for (int i = 0; i < gameBoard.length; i++)
            for (int j = 0; j < gameBoard.length; j++)
                if (validateMove(gameBoard, i, j, currentTurn, currentOpponent))
                    return true;
        return false;
    }

    public boolean check(char[][] gameBoard, int xCord, int yCord, int dirX, int dirY,
                                 char currentTurn, char opponentSymbol) {
        if (xCord < 0 || xCord > 7 || yCord < 0 || yCord > 7)
            return false;
        if (dirX == 0 && dirY == 0)
            return false;
        if (gameBoard[xCord][yCord] == opponentSymbol) {
            while (xCord >= 0 && xCord <= 7 && yCord >= 0 && yCord <= 7) {
                xCord += dirX;
                yCord += dirY;
                if (gameBoard[xCord][yCord] == 0)
                    return false;
                if (gameBoard[xCord][yCord] == currentTurn)
                    return true;
            }
        }
        return false;
    }
}
