package com.tictactoe;

import java.util.InputMismatchException;

public class Board {
    private final char[][] board;
    private int inRowToWin;
    private int moveCount = 0;
    public Board(int size, int inRowToWin){
        this.inRowToWin = inRowToWin;
        board = new char[size][size];
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                board[i][j] = ' ';
            }
        }
    }
    public void setCharacter(int row, int column, char player) throws FieldOccupiedException, InputMismatchException{
        if(row < 0 || row >= board.length) throw new InputMismatchException();
        if(column < 0 || column >= board.length) throw new InputMismatchException();
        if(board[row][column] != ' ') throw new FieldOccupiedException();
        board[row][column] = player;
        moveCount++;
    }
    public int endChecker(char character, int row, int column){
        //1 - win
        //0 - game on
        //-1 - draw
        int count = 0;
        //check columns
        for(int i = 0; i < board.length; i++){
            if(board[i][column] == character) count++;
            if(board[i][column] != character) count = 0;
            if(count == inRowToWin) return 1;
        }
        count = 0;
        //check row
        for (int i = 0; i < board.length; i++){
            if (board[row][i] == character) count++;
            if(board[row][i] != character) count = 0;
            if(count == inRowToWin) return 1;
        }
        count = 0;
        //check diagonals
        //y=-x+row+column
        //y=x+row-column
        for(int x = 0; x < board.length; x++){
            if((-1 * x + column + row) >= board.length) x++;
            else {
                if (((-1 * x + column + row)) < 0) break;
                if (board[x][-1 * x + column + row] == character) count++;
                if (board[x][-1 * x + column + row] != character) count = 0;
                if (count == inRowToWin) return 1;
            }
        }
        count = 0;
        for(int x = 0; x < board.length; x++){
            if((x + column - row) < 0) x -= (x + column - row);
            if((x + column - row) >= board.length) break;
            if(board[x][x + column - row] == character) count++;
            if(board[x][x + column - row] != character) count = 0;
            if(count == inRowToWin) return 1;
        }
        //check for draw
        if (moveCount >= board.length * board.length) return -1;
        return 0;
    }

    public char[][] getBoard() {
        return board;
    }

}