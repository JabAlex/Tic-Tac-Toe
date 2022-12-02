package com.tictactoe;

public class TicTacToeRunner {
    public static void main(String[] args) {
        UserCommunicationHandler userCommunicationHandler = new UserCommunicationHandler();
        Game game = new Game();
        boolean end = false;

        while(!end) {
            switch (userCommunicationHandler.startGameOption()) {
                case 1:
                    game.singlePlayerMode();
                    break;
                case 2:
                    game.twoPlayerMode();
                    break;
                case 3:
                    end = true;
                    break;
            }
        }

    }
}
