package com.tictactoe;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class EasyMovePicker implements MovePicker{
    public String pickMove(Board board){
        String move;
        Random random = new Random();
        List<String> possibleMoves = board.getBoard().entrySet()
                .stream()
                .filter(entry -> entry.getValue() == ' ')
                .map(Map.Entry::getKey)
                .toList();
        move = possibleMoves.get(Math.floorMod(random.nextInt(), possibleMoves.size()));
        return move;
    }

}
