package com.tictactoe;

public class HardMovePicker implements MovePicker{

    private final char character;
    private final char opponentCharacter;


    public HardMovePicker(char character, char opponentCharacter) {
        this.character = character;
        this.opponentCharacter = opponentCharacter;
    }

    public int[] pickMove(Board board) {
        int[] chosenMove = new int[2];
        int bestValue = -1000;
        int moveValue;
        int moveCount;
        for(int row = 0; row < board.getBoard().length; row++){
            for(int column = 0; column < board.getBoard().length; column++){
                if(board.getBoard()[row][column] == ' '){
                    moveCount = board.getMoveCount();
                    board.setCharacter(row, column, character);
                    moveValue = minmax(board, 0, false);
                    board.setCharacter(row, column, ' ');
                    board.setMoveCount(moveCount);
                    if(moveValue > bestValue){
                        chosenMove[0] = row;
                        chosenMove[1] = column;
                        bestValue = moveValue;
                    }
                }
            }
        }
        return chosenMove;
    }
    private int minmax(Board board, int depth, boolean isMax){
        int moveCount;
        if(!isMax) {
            if (board.endChecker() == 1) return 10 - depth;
        }
        else {
            if (board.endChecker() == 1) return depth - 10;
        }
        if(board.endChecker() == -1) return 0;
        int best;
        if(isMax){
            best = -1000;
            for(int i = 0; i < board.getBoard().length; i++){
                for(int j = 0; j < board.getBoard().length; j++){
                    if(board.getBoard()[i][j] == ' ') {
                        moveCount = board.getMoveCount();
                        board.setCharacter(i, j, character);
                        best = Math.max(best, minmax(board, depth + 1, false));
                        board.setCharacter(i, j, ' ');
                        board.setMoveCount(moveCount);
                    }
                }
            }
        }
        else{
            best = 1000;
            for(int i = 0; i < board.getBoard().length; i ++){
                for(int j = 0; j < board.getBoard().length; j++){
                    if(board.getBoard()[i][j] == ' ') {
                        moveCount = board.getMoveCount();
                        board.setCharacter(i, j, opponentCharacter);
                        best = Math.min(best, minmax(board, depth + 1, true));
                        board.setCharacter(i, j, ' ');
                        board.setMoveCount(moveCount);
                    }
                }
            }
        }
        return best;
    }

}
