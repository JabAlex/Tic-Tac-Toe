package com.tictactoe;

public class Game {
    GameDisplayer gameDisplayer = new GameDisplayer();
    UserCommunicationHandler userCommunicationHandler = new UserCommunicationHandler();
    public void singlePlayerMode(int size, int inRowToWin){
        char player;
        char computer;
        Board board = new Board(size, inRowToWin);
        MovePicker movePicker;
        if(userCommunicationHandler.singlePlayerOption() == 1){
            player = 'X';
            computer = 'O';
        } else{
            player = 'O';
            computer = 'X';
        }
        if(userCommunicationHandler.difficultyOption() == 1) movePicker = new EasyMovePicker();
        else movePicker = new HardMovePicker(computer, player);

        while(true){
            if(computer == 'X'){
                if (computerMove(computer, board, movePicker)) break;
                if (playerMove(player, board)) break;
            }
            else{
                if (playerMove(player, board)) break;
                if (computerMove(computer, board, movePicker)) break;
            }
        }
    }

    private boolean playerMove(char player, Board board) {
        gameDisplayer.drawBoard(board);
        userCommunicationHandler.placeCharacter(player, board);
        if(board.endChecker() == 1){
            gameDisplayer.drawBoard(board);
            userCommunicationHandler.showResult('P');
            return true;
        }
        if (board.endChecker() == -1){
            gameDisplayer.drawBoard(board);
            userCommunicationHandler.showResult('D');
            return true;
        }
        return false;
    }

    private boolean computerMove(char computer, Board board, MovePicker movePicker) {
        int[] field;
        field = movePicker.pickMove(board);
        try{
            board.setCharacter(field[0], field[1], computer);
        }catch(FieldOccupiedException e){
            System.out.println("" + field[0] + field[1]);
        }
        if(board.endChecker() == 1){
            gameDisplayer.drawBoard(board);
            userCommunicationHandler.showResult('C');
            return true;
        }
        if(board.endChecker() == -1){
            gameDisplayer.drawBoard(board);
            userCommunicationHandler.showResult('D');
            return true;
        }
        return false;
    }

    public void twoPlayerMode(int size, int inRowToWin){
        Board board = new Board(size, inRowToWin);
        char player = 'X';
        gameDisplayer.drawBoard(board);
        while(true) {
            userCommunicationHandler.placeCharacter(player, board);
            gameDisplayer.drawBoard(board);
            if(board.endChecker() == 1){
                userCommunicationHandler.showResult(player);
                break;
            }
            if (board.endChecker() == -1){
                userCommunicationHandler.showResult('D');
                break;
            }
            player = switchPlayer(player);
        }
    }
    private char switchPlayer(char player){
        if(player == 'O') player = 'X';
        else player = 'O';
        return player;
    }

}
