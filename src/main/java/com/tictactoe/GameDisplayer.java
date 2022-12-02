package com.tictactoe;

import java.util.Map;

public class GameDisplayer {
    public void drawBoard(Map<String, Character> gameState){
        System.out.println("    a   b   c \n");
        System.out.println("1   " + gameState.get("a1")+ " │ " + gameState.get("b1") + " │ " + gameState.get("c1"));
        System.out.println("   ───┼───┼───");
        System.out.println("2   " + gameState.get("a2")+ " │ " + gameState.get("b2") + " │ " + gameState.get("c2"));
        System.out.println("   ───┼───┼───");
        System.out.println("3   " + gameState.get("a3")+ " │ " + gameState.get("b3") + " │ " + gameState.get("c3") + "\n");
    }

}
