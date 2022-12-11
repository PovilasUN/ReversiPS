package userInput;

import userInput.Command;

public class End implements Command {
    @Override
    public void execute() {
        System.exit(0);
    }
}
