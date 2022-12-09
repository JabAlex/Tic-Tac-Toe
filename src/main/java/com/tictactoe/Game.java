package com.tictactoe;

public class Game {
    GameDisplayer gameDisplayer = new GameDisplayer();
    UserCommunicationHandler userCommunicationHandler = new UserCommunicationHandler();
    public void singlePlayerMode(){
        char player;
        char computer;
        boolean playerWin = false;
        Board board = new Board();
        MovePicker movePicker = new EasyMovePicker();
        if(userCommunicationHandler.singlePlayerOption() == 1){
            player = 'X';
            computer = 'O';
        } else{
            player = 'O';
            computer = 'X';
        }
        while(!board.endChecker()){
            if(player == 'X') {
                gameDisplayer.drawBoard(board);
                userCommunicationHandler.placeCharacter(player, board);
                if (!board.endChecker()) board.setCharacter(movePicker.pickMove(board), computer);
                else playerWin = true;
            }
            else {
                board.setCharacter(movePicker.pickMove(board), computer);
                gameDisplayer.drawBoard(board);
                if (!board.endChecker()) {
                    userCommunicationHandler.placeCharacter(player, board);
                    playerWin = true;
                }
                else playerWin = false;
            }
        }
        gameDisplayer.drawBoard(board);
        userCommunicationHandler.showResult(board.resultChecker());
    }
    public void twoPlayerMode(){
        Board board = new Board();
        char player = 'X';
        gameDisplayer.drawBoard(board);
        while(!board.endChecker()) {
            userCommunicationHandler.placeCharacter(player, board);
            gameDisplayer.drawBoard(board);
            player = switchPlayer(player);
        }
        userCommunicationHandler.showResult(board.resultChecker());
    }
    private char switchPlayer(char player){
        if(player == 'O') player = 'X';
        else player = 'O';
        return player;
    }

}
