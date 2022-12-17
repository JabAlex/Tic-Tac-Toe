package com.tictactoe;

public class TicTacToeRunner {
    public static void main(String[] args) {
        UserCommunicationHandler userCommunicationHandler = new UserCommunicationHandler();
        Game game = new Game();
        int size = 3;
        int inRowToWin = 3;
        boolean end = false;

        while(!end) {
            switch (userCommunicationHandler.startGameOption()) {
                case 1:
                    game.singlePlayerMode(size, inRowToWin);
                    break;
                case 2:
                    game.twoPlayerMode(size, inRowToWin);
                    break;
                case 3:
                    switch(userCommunicationHandler.changeBoardSize(size)){
                        case 1:
                            size = 3;
                            inRowToWin = 3;
                            break;
                        case 2:
                            size = 10;
                            inRowToWin = 5;
                            break;
                        case 3:
                            size = userCommunicationHandler.setSize();
                            inRowToWin = userCommunicationHandler.setInRowToWin(size);
                            break;
                        case 4: break;
                    }
                    break;
                case 4:
                    end = true;
                    break;

            }
        }

    }
}
