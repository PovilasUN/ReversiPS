package main;

import utils.Validator;

public class GameLogic {

    private Validator validator;

    public GameLogic(Validator validator) {
        this.validator = validator;
    }

    public void makeMove(char[][] gameBoard, int xCord, int yCord, char currentTurn, char currentOpponent ) {
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

    private void checkAndFlip(char[][] gameBoard, int xCord, int yCord, int dirX, int dirY, char currentTurn, char opponentSymbol) {
        if (validator.check(gameBoard, xCord, yCord, dirX, dirY, currentTurn, opponentSymbol))
            flip(gameBoard, xCord, yCord, dirX, dirY, currentTurn, opponentSymbol);
    }

    public void flip(char[][] gameBoard, int xCord, int yCord, int dirX, int dirY, char currentTurn, char opponentSymbol) {
        if (dirX == 0 && dirY == 0)
            return;
        while (gameBoard[xCord][yCord] == opponentSymbol) {
            gameBoard[xCord][yCord] = currentTurn;
            xCord += dirX;
            yCord += dirY;
        }
    }
}
