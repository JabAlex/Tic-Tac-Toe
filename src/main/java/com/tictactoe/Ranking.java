package com.tictactoe;

import java.util.Comparator;
import java.util.List;

public class Ranking {
    public void showRanking(List<Profile> profileList){
        profileList.sort(Comparator.comparing(Profile::getWonGames, Comparator.reverseOrder()));
        System.out.println("| Name | Won Games | Lost Games | Drawn Games");
        for (Profile profile: profileList) {
            System.out.println("| " + profile.getName() + " | " + profile.getWonGames() + " | " + profile.getLostGames() + " | " + profile.getDrawnGames());
        }
    }
}
