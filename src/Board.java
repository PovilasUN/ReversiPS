public class Board {
    private final int BOARD_SIZE = 8;

    private final int MAX_SCORE = 64;
    private final char[][] board;

    public Board() {
        this.board = new char[BOARD_SIZE][BOARD_SIZE];
        this.board[3][4] = 'O';
        this.board[4][3] = 'O';
        this.board[3][3] = 'X';
        this.board[4][4] = 'X';
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

    public int countXOrO(char symbolChar) {
        int count = 0;
        for (int i = 0; i < BOARD_SIZE; i++)
            for (int j = 0; j < BOARD_SIZE; j++)
                if (board[i][j] == symbolChar)
                    count++;
        return count;
    }

    public String returnWinner() {
        if (countXOrO('X') > countXOrO('O'))
            return "Player X.";
        return "Player O.";
    }

    public boolean isBoardFull() {
        return countXOrO('X') + countXOrO('O') == MAX_SCORE;
    }

    public char[][] getBoard() {
        return board;
    }
}
