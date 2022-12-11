package main;

import userInput.Command;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private int userSelection;

    public int displayMenu() {
        while(true) {
            Scanner userInput = new Scanner(System.in);

            System.out.println("Choose from these choices");
            System.out.println("-------------------------\n");
            System.out.println("1 - Start the Game!");
            System.out.println("0 - Quit");

            try {
                userSelection = userInput.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Enter correct input!");
            }

            if (userSelection == 1 || userSelection == 0)
                break;
            else
                System.out.println("Enter correct input!");
        }
        return userSelection;
    }

    public void executeUserBaseOnInput(Command command) {
        command.execute();
    }
}
