package com.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserCommunicationHandler {

    public int startGameOption() {
        int option;
        System.out.print("""
         Tic Tac Toe
         ────────────
         Options:
         1. Single Player
         2. Two Players
         3. Quit
       
         """);
        while (true) {
            try {
                System.out.print("Choose option: ");
                Scanner sc = new Scanner(System.in);
                option = sc.nextInt();
                if(option == 1 || option == 2 || option == 3) break;
                else throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, Please try again");
            }
        }
        return option;
    }
    public String placeCharacter(char player, Board board){
        String field;
        System.out.println("Player " + player + " move");
        while(true) {
            try {
                System.out.print("Choose field to place your character: ");
                Scanner sc = new Scanner(System.in);
                field = sc.next().toLowerCase();
                if (Pattern.matches("[abc][1-3]", field)) {
                    if(board.getBoard().get(field) != ' ') throw new FieldOccupiedException();
                    break;
                }
                else throw new InputMismatchException();

            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please try again");
            } catch (FieldOccupiedException e) {
                System.out.println("Field is already occupied, please try another field");
            }
        }
        return field;
    }
    public void showResult(String result){
        if(result.equals("Draw!")) System.out.println(result);
        else System.out.println("Player " + result + " won!");
    }
}
