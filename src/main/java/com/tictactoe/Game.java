package com.tictactoe;

public class Game {
    GameDisplayer gameDisplayer = new GameDisplayer();
    UserCommunicationHandler userCommunicationHandler = new UserCommunicationHandler();
    public void singlePlayerMode(){

    }
    public void twoPlayerMode(){
        Board board = new Board();
        char player = 'X';
        gameDisplayer.drawBoard(board.getBoard());
        while(endChecker(board)) {
            board.setCharacter(userCommunicationHandler.placeCharacter(player, board), player);
            gameDisplayer.drawBoard(board.getBoard());
            player = switchPlayer(player);
        }
        if(!board.getBoard().containsValue(' ')){
            userCommunicationHandler.showResult("Draw!");
        }
        else {
            player = switchPlayer(player);
            userCommunicationHandler.showResult("" + player);
        }
    }
    private char switchPlayer(char player){
        if(player == 'O') player = 'X';
        else player = 'O';
        return player;
    }
    private boolean endChecker(Board board){
        boolean check = true;
        int row;
        char column;
        int xCount = 0;
        int oCount = 0;
        for (column = 'a'; column <= 'c'; column++){
            for(row = 1; row <= 3; row ++){
                if(board.getBoard().get("" + column + row) == 'X') xCount++;
                if(board.getBoard().get("" + column + row) == 'O') oCount++;
            }
            if(xCount >= 3 || oCount >= 3) {
                check = false;
                break;
            }
            xCount = 0;
            oCount = 0;
        }
        for (row = 1; row <= 3; row++){
            for(column = 'a'; column <= 'c'; column ++){
                if(board.getBoard().get("" + column + row) == 'X') xCount++;
                if(board.getBoard().get("" + column + row) == 'O') oCount++;
            }
            if(xCount >= 3 || oCount >= 3) {
                check = false;
                break;
            }
            xCount = 0;
            oCount = 0;
        }
        if(board.getBoard().get("a1") == 'X' &&
                board.getBoard().get("b2") == 'X' &&
                board.getBoard().get("c3") == 'X') check = false;
        if(board.getBoard().get("a1") == 'O' &&
                board.getBoard().get("b2") == 'O' &&
                board.getBoard().get("c3") == 'O') check = false;
        if(board.getBoard().get("a3") == 'X' &&
                board.getBoard().get("b2") == 'X' &&
                board.getBoard().get("c1") == 'X') check = false;
        if(board.getBoard().get("a3") == 'O' &&
                board.getBoard().get("b2") == 'O' &&
                board.getBoard().get("c1") == 'O') check = false;

        if(!board.getBoard().containsValue(' ')) check = false;
        return check;
    }
}
