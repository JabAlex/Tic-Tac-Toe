package com.tictactoe;

import java.io.Serializable;


public class Profile implements Serializable {
    private final String name;
    private int wonGames;
    private int lostGames;
    private int drawnGames;

    public Profile(String name) {
        this.name = name;
    }

    public void addWonGame(){
        wonGames++;
    }
    public void addLostGame(){
        lostGames++;
    }
    public void addDrawnGame(){
        drawnGames++;
    }
    public void resetStats(){
        wonGames = 0;
        lostGames = 0;
        drawnGames = 0;
    }

    public String getName() {
        return name;
    }

    public int getWonGames() {
        return wonGames;
    }
    public int getLostGames() {
        return lostGames;
    }
    public int getDrawnGames() {
        return drawnGames;
    }

}
