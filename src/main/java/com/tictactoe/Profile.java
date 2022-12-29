package com.tictactoe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Profile implements Serializable {
    private String name;
    private List<Board> savedGames = new ArrayList<>();
    private int playedGames;
    private int wonGames;
    private int lostGames;
    private int drawnGames;

    public Profile(String name) {
        this.name = name;
    }

    public void saveGame(Board board){
        savedGames.add(board);
    }
    public Board loadGame(int option){
        Board chosenGame = savedGames.get(option);
        return chosenGame;
    }
    public void addPlayedGame(){
        playedGames++;
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

    public String getName() {
        return name;
    }

    public List<Board> getSavedGames() {
        return savedGames;
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
