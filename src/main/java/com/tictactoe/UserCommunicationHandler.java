package com.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserCommunicationHandler {

    public int startGameOption() {
        int option;
        System.out.print("""
         Tic Tac Toe
         ────────────
         Options:
         1. Single Player
         2. Two Players
         3. Change Board Size
         4. Quit
       
         """);
        while (true) {
            try {
                System.out.print("Choose option: ");
                Scanner sc = new Scanner(System.in);
                option = sc.nextInt();
                if(option >= 1 && option <= 4) break;
                else throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, Please try again");
            }
        }
        return option;
    }
    public int changeBoardSize(int size){
        int option;
        System.out.println("Current size: " + size + "x" + size);
        System.out.println("""
                Choose size:
                1. 3x3
                2. 10x10
                3. Custom
                4. Back
                """);
        while (true) {
            try {
                System.out.print("Choose option: ");
                Scanner sc = new Scanner(System.in);
                option = sc.nextInt();
                if(option >= 1 && option <= 4) break;
                else throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, Please try again");
            }
        }
        return option;
    }
    public int setSize(){
        int size;
        while (true) {
            try {
                System.out.println("Choose the size of your board: ");
                Scanner sc = new Scanner(System.in);
                size = sc.nextInt();
                if(size > 1) break;
                else throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("Size must be a number greater than 1, please try again");
            }
        }
        return size;
    }
    public int setInRowToWin(int size) {
        int inRowToWin;
        while (true) {
            try {
                System.out.println("How many characters in a row to win? ");
                Scanner sc = new Scanner(System.in);
                inRowToWin = sc.nextInt();
                if (inRowToWin <= size && inRowToWin > 1) break;
                else throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("Amount of characters must be a number greater than 1 and smaller than the boards size, please try again");
            }
        }
            return inRowToWin;
    }
    public int singlePlayerOption(){
        int option;
        System.out.print("""
                Who goes first?
                1. You
                2. Computer
                
                """);
        while (true){
            try {
                System.out.print("Choose option: ");
                Scanner sc = new Scanner(System.in);
                option = sc.nextInt();
                if (option == 1 || option == 2) break;
                else throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, Please try again");
            }
        }
        return option;
    }
    public int[] placeCharacter(char player, Board board){
        String field;
        int column;
        int row;
        System.out.println("Player " + player + " move");
        while(true) {
            try {
                System.out.print("Choose field to place your character: ");
                Scanner sc = new Scanner(System.in);
                field = sc.next().toLowerCase();
                if(field.length() != 2) throw new InputMismatchException();
                column = field.charAt(0) - 97;
                row = field.charAt(1) - 49;
                board.setCharacter(row, column, player);
                break;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please try again");
            } catch (FieldOccupiedException e) {
                System.out.println("Field is already occupied, please try another field");
            }
        }
        return new int[]{row, column};
    }
    public void showResult(char player){
        switch (player) {
            case 'D' -> System.out.println("Draw");
            case 'X' -> System.out.println("Player X won");
            case 'O' -> System.out.println("Player O won");
            case 'C' -> System.out.println("Computer won");
            case 'P' -> System.out.println("You win!");
        }
    }
}
