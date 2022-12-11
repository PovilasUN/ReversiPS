package main;

public class Board {
    private final int BOARD_SIZE = 8;
    private final int MAX_SCORE = 64;
    private final char[][] board;
    private static Board instance;

    private Board() {
        this.board = new char[BOARD_SIZE][BOARD_SIZE];
        this.board[3][4] = 'O';
        this.board[4][3] = 'O';
        this.board[3][3] = 'X';
        this.board[4][4] = 'X';
    }

    public static synchronized Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }

    public void renderBoard() {
        System.out.println("---------------------------");
        System.out.print(" ");
        for (int i = 0; i < 8; i++) {
            System.out.print(" "+ i + " ");
        }
        System.out.println();
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print(i  + "");
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] != 0)
                    System.out.print(" " + board[i][j] + " " );
                else
                    System.out.print(" - ");
            }
            System.out.println();
        }
        System.out.println("---------------------------");
    }

    public int countSymbol(char symbolChar) {
        int count = 0;
        for (int i = 0; i < BOARD_SIZE; i++)
            for (int j = 0; j < BOARD_SIZE; j++)
                if (board[i][j] == symbolChar)
                    count++;
        return count;
    }

    public String returnWinner() {
        if (countSymbol('X') > countSymbol('O'))
            return "Player X.";
        return "Player O.";
    }

    public boolean isBoardFull() {
        return countSymbol('X') + countSymbol('O') == MAX_SCORE;
    }

    public char[][] getBoard() {
        return board;
    }
}
