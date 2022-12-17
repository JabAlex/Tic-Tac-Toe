package com.tictactoe;

import java.util.Map;

public class GameDisplayer {

    public void drawBoard(Board board) {
        char column = 'a';
        int row = 1;
        String line = " ";
        String separatorLine = "";
        for (int i = 0; i < board.getBoard().length; i++) {
            line = line + "   " + column;
            column++;
        }
        line.concat(" \n");
        System.out.println(line);
        for (int i = 0; i < board.getBoard().length; i++) {
            line = row + "  ";
            separatorLine = "   ";
            if (row < 10) line = line + " ";
            for (int j = 0; j < board.getBoard().length; j++) {
                line = line + board.getBoard()[i][j];
                if (j != (board.getBoard().length - 1)) line = line + " | ";
                separatorLine = separatorLine + "----";
            }
            System.out.println(line);
            System.out.println(separatorLine);
            row++;
        }
    }
}