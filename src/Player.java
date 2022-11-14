import java.util.Scanner;

public class Player {
    private char symbol;
    private int xCord;
    private int yCord;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getXCord() {
        return xCord;
    }

    public int getYCord() {
        return yCord;
    }

    public void switchPlayer() {
        if (symbol == 'X')
            symbol = 'O';
        else
            symbol = 'X';
    }

    public void getPlayerInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("It is player with symbol " + symbol + " turn.");
        System.out.println("Enter coordinates to move.");
        xCord = scanner.nextInt();
        yCord = scanner.nextInt();
    }
}
