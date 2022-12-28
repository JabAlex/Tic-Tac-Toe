package com.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EasyMovePicker implements MovePicker{
    public int[] pickMove(Board board){
        int[] chosenMove;
        char[][] gameState = board.getBoard();
        List<int[]> possibleMoves = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i < board.getBoard().length; i++){
            for (int j = 0; j < board.getBoard().length; j++){
                if(gameState[i][j] == ' ') possibleMoves.add(new int[]{i, j});
            }
        }
        chosenMove = possibleMoves.get(random.nextInt() & possibleMoves.size() - 1);
        return chosenMove;
    }

}
