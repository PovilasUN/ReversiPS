package main;

import userInput.End;
import userInput.Start;
import utils.Validator;
import utils.ValidatorImpl;

public class Main {
    public static void main(String[] args) {
        Validator validator = new ValidatorImpl();
        ReversiGame reversiGame = new ReversiGame(validator, new GameLogic(validator));
        Menu menu = new Menu();
        int userInput = menu.displayMenu();
        if (userInput == 1)
            menu.executeUserBaseOnInput(new Start(reversiGame));
        else
            menu.executeUserBaseOnInput(new End());
    }
}
