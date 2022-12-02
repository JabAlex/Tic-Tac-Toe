package com.tictactoe;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private final Map<String, Character> board = new HashMap<>();
    public Board(){
        board.put("a1", ' ');
        board.put("a2", ' ');
        board.put("a3", ' ');
        board.put("b1", ' ');
        board.put("b2", ' ');
        board.put("b3", ' ');
        board.put("c1", ' ');
        board.put("c2", ' ');
        board.put("c3", ' ');
    }
    public void setCharacter(String field, Character character) {
        board.replace(field, character);
    }
    public Map<String, Character> getBoard() {
        return board;
    }
}
