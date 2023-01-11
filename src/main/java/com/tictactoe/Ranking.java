package com.tictactoe;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ranking {
    public void showRanking(List<Profile> profileList){
        int option;
        profileList.sort(Comparator.comparing(Profile::getWonGames, Comparator.reverseOrder()));
        System.out.println("Name      |  Won | Lost | Drawn");
        for (Profile profile: profileList) {
            System.out.format("%-10s|%-6s|%-6s|%-6s%n", profile.getName(), profile.getWonGames(), profile.getLostGames(), profile.getDrawnGames());
        }
        while (true) {
            try {
                System.out.print("""
                        1. Back
                        2. Reset rankings
                        """);
                Scanner sc = new Scanner(System.in);
                option = sc.nextInt();
                if (option >= 1 && option <= 2) break;
                else throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, Please try again");
            }
        }
        switch (option){
            case 1:
                break;
            case 2:
                resetRankings(profileList);
                break;
        }
    }
    public void resetRankings(List<Profile> profileList){
        int option;
        while (true) {
            try {
                System.out.print("""
                        Are you sure you want to reset all rankings?
                        1. yes
                        2. no
                        """);
                Scanner sc = new Scanner(System.in);
                option = sc.nextInt();
                if (option >= 1 && option <= 2) break;
                else throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, Please try again");
            }
        }
        if(option == 1) {
            for (Profile profile : profileList) {
                profile.resetStats();
            }
        }
    }
}
