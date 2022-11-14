public class GameLogic {

    public static boolean validateMove(char[][] gameBoard, int xCord, int yCord, char currentTurn, char currentOpponent) {
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

    public static void makeMove(char[][] gameBoard, int xCord, int yCord, char currentTurn, char currentOpponent ) {
        gameBoard[xCord][yCord] = currentTurn;
        checkAndFlip(gameBoard, xCord - 1, yCord, -1, 0, currentTurn, currentOpponent);
        checkAndFlip(gameBoard, xCord + 1, yCord, 1, 0, currentTurn, currentOpponent);
        checkAndFlip(gameBoard, xCord, yCord - 1, 0, -1, currentTurn, currentOpponent);
        checkAndFlip(gameBoard, xCord, yCord + 1, 0, 1, currentTurn, currentOpponent);
        checkAndFlip(gameBoard, xCord - 1, yCord - 1, -1, -1, currentTurn, currentOpponent);
        checkAndFlip(gameBoard, xCord + 1, yCord - 1, 1, -1, currentTurn, currentOpponent);
        checkAndFlip(gameBoard, xCord - 1, yCord + 1, -1, 1, currentTurn, currentOpponent);
        checkAndFlip(gameBoard, xCord + 1, yCord + 1, 1, 1, currentTurn, currentOpponent);
    }

    public static void checkAndFlip(char[][] gameBoard, int xCord, int yCord, int dirX, int dirY, char currentTurn, char opponentSymbol) {
        if (check(gameBoard, xCord, yCord, dirX, dirY, currentTurn, opponentSymbol))
            flip(gameBoard, xCord, yCord, dirX, dirY, currentTurn, opponentSymbol);
    }

    public static boolean hasValidMoves(char[][] gameBoard, int xCord, int yCord, char currentTurn, char currentOpponent) {
        for (int i = 0; i < gameBoard.length; i++)
            for (int j = 0; j < gameBoard.length; j++)
                if (GameLogic.validateMove(gameBoard, i, j, currentTurn, currentOpponent))
                    return true;
        return false;
    }

    public static boolean check(char[][] gameBoard, int xCord, int yCord, int dirX, int dirY,
                                    char currentTurn, char opponentSymbol) {
        if (xCord < 0 || xCord > 7 || yCord < 0 || yCord > 7)
            return false;
        if (gameBoard[xCord][yCord] == opponentSymbol) {
            while (xCord < 8 && yCord < 8) {
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

    public static void flip(char[][] gameBoard, int xCord, int yCord, int dirX, int dirY, char currentTurn, char opponentSymbol) {
        while (gameBoard[xCord][yCord] == opponentSymbol) {
            gameBoard[xCord][yCord] = currentTurn;
            xCord += dirX;
            yCord += dirY;
        }
    }
}
