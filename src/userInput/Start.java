package userInput;

import main.ReversiGame;

public class Start implements Command {

    private final ReversiGame reversiGame;

    public Start(ReversiGame reversiGame) {
        this.reversiGame = reversiGame;
    }

    @Override
    public void execute() {
        reversiGame.playGame();
    }
}