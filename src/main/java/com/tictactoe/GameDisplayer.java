package com.tictactoe;

import java.util.Map;

public class Board {
    public void drawBoard(Map gameState){
        System.out.println(" " + gameState.get("a1")+ " │ " + gameState.get("a2") + " │ " + gameState.get("a3"));
        System.out.println("───┼───┼───");
        System.out.println(" " + gameState.get("b1")+ " │ " + gameState.get("b2") + " │ " + gameState.get("b3"));
        System.out.println("───┼───┼───");
        System.out.println(" " + gameState.get("c1")+ " │ " + gameState.get("c2") + " │ " + gameState.get("c3"));
    }
    public void startGame(){
        System.out.print("""
         Tic Tac Toe
         ────────────
         Options:
         1. Single Player
         2. Two Players
         
         Choose option: 
         """);
    }
}
