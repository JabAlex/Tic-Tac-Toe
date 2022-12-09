package com.tictactoe;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.regex.Pattern;

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
    public void setCharacter(String field, Character character) throws FieldOccupiedException {
        if(!Pattern.matches("[abc][1-3]", field)) throw new InputMismatchException();
        if(board.get(field) != ' ') throw new FieldOccupiedException();
        board.replace(field, character);
    }

    public int resultChecker(){
        // -1 game not ended
        // 0 draw
        // 1 X won
        // 2 O won

        int result = -1;
        int row;
        char column;
        int xCount = 0;
        int oCount = 0;
        //Check if there are columns filled with same char
        for (column = 'a'; column <= 'c'; column++){
            for(row = 1; row <= 3; row ++){
                if(board.get("" + column + row) == 'X') xCount++;
                if(board.get("" + column + row) == 'O') oCount++;
            }
            if(xCount >= 3) {
                result = 1;
                break;
            } else if (oCount >= 3) {
                result = 2;
                break;
            }
            xCount = 0;
            oCount = 0;
        }
        //check if there are rows filled with same char
        for (row = 1; row <= 3; row++){
            for(column = 'a'; column <= 'c'; column ++){
                if(board.get("" + column + row) == 'X') xCount++;
                if(board.get("" + column + row) == 'O') oCount++;
            }
            if(xCount >= 3) {
                result = 1;
                break;
            } else if (oCount >= 3) {
                result = 2;
                break;
            }
            xCount = 0;
            oCount = 0;
        }
        //check diagonals
        if(board.get("a1") == 'X' &&
                board.get("b2") == 'X' &&
                board.get("c3") == 'X') result = 1;
        if(board.get("a1") == 'O' &&
                board.get("b2") == 'O' &&
                board.get("c3") == 'O') result = 2;
        if(board.get("a3") == 'X' &&
                board.get("b2") == 'X' &&
                board.get("c1") == 'X') result = 1;
        if(board.get("a3") == 'O' &&
                board.get("b2") == 'O' &&
                board.get("c1") == 'O') result = 2;
        //check for a draw
        if(!board.containsValue(' ')) result = 0;
        return result;
    }
    public boolean endChecker(){
        boolean check = false;
        if(resultChecker() >= 0) check = true;
        return check;
    }
    public Map<String, Character> getBoard() {
        return board;
    }

}
