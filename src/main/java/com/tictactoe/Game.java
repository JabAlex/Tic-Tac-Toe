package com.tictactoe;

public class Game {
    GameDisplayer gameDisplayer = new GameDisplayer();
    UserCommunicationHandler userCommunicationHandler = new UserCommunicationHandler();
    public void singlePlayerMode(int size, int inRowToWin){
        char player;
        char computer;
        int[] field;
        boolean playerWin = false;
        Board board = new Board(size, inRowToWin);
        MovePicker movePicker = new EasyMovePicker();
        if(userCommunicationHandler.singlePlayerOption() == 1){
            player = 'X';
            computer = 'O';
        } else{
            player = 'O';
            computer = 'X';
        }
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
        int[] field;
        gameDisplayer.drawBoard(board);
        field = userCommunicationHandler.placeCharacter(player, board);
        if(board.endChecker(player, field[0], field[1]) == 1){
            gameDisplayer.drawBoard(board);
            userCommunicationHandler.showResult('P');
            return true;
        }
        if (board.endChecker(player, field[0], field[1]) == -1){
            gameDisplayer.drawBoard(board);
            userCommunicationHandler.showResult('D');
            return true;
        }
        return false;
    }

    private boolean computerMove(char computer, Board board, MovePicker movePicker) {
        int[] field;
        field = movePicker.pickMove(board);
        board.setCharacter(field[0], field[1], computer);
        if(board.endChecker(computer, field[0], field[1]) == 1){
            gameDisplayer.drawBoard(board);
            userCommunicationHandler.showResult('C');
            return true;
        }
        if(board.endChecker(computer, field[0], field[1]) == -1){
            gameDisplayer.drawBoard(board);
            userCommunicationHandler.showResult('D');
            return true;
        }
        return false;
    }

    public void twoPlayerMode(int size, int inRowToWin){
        Board board = new Board(size, inRowToWin);
        char player = 'X';
        int[] field;
        gameDisplayer.drawBoard(board);
        while(true) {
            field = userCommunicationHandler.placeCharacter(player, board);
            gameDisplayer.drawBoard(board);
            if(board.endChecker(player, field[0], field[1]) == 1){
                userCommunicationHandler.showResult(player);
                break;
            }
            if (board.endChecker(player, field[0], field[1]) == -1){
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
