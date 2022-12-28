package com.tictactoe;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTestSuite {

    @Nested
    class GameEndTestsFor3x3{
        @Test
        void gameEndForOHorizontalTest(){
            //Given
            Board board = new Board(3, 3);
            //When
            board.setCharacter(0, 0, 'O');
            board.setCharacter(0, 1, 'O');
            board.setCharacter(0, 2, 'O');
            //Then
            assertEquals(1, board.endChecker());
        }
        @Test
        void gameEndForOVerticalTest(){
            //Given
            Board board = new Board(3, 3);
            //When
            board.setCharacter(0, 1, 'O');
            board.setCharacter(1, 1, 'O');
            board.setCharacter(2, 1, 'O');
            //Then
            assertEquals(1, board.endChecker());
        }
        @Test
        void gameEndForODiagonalTest(){
            //Given
            Board board = new Board(3, 3);
            //When
            board.setCharacter(0, 0, 'O');
            board.setCharacter(1, 1, 'O');
            board.setCharacter(2, 2, 'O');
            //Then
            assertEquals(1, board.endChecker());
        }
        @Test
        void gameEndForXHorizontalTest(){
            //Given
            Board board = new Board(3, 3);
            //When
            board.setCharacter(0, 0, 'X');
            board.setCharacter(0, 1, 'X');
            board.setCharacter(0, 2, 'X');
            //Then
            assertEquals(1, board.endChecker());
        }
        @Test
        void gameEndForXVerticalTest(){
            //Given
            Board board = new Board(3, 3);
            //When
            board.setCharacter(0, 1, 'X');
            board.setCharacter(1, 1, 'X');
            board.setCharacter(2, 1, 'X');
            //Then
            assertEquals(1, board.endChecker());
        }
        @Test
        void gameEndForXDiagonalTest(){
            //Given
            Board board = new Board(3, 3);
            //When
            board.setCharacter(0, 0, 'X');
            board.setCharacter(1, 1, 'X');
            board.setCharacter(2, 2, 'X');
            //Then
            assertEquals(1, board.endChecker());
        }
        @Test
        void drawTest(){
            //Given
            Board board = new Board(3, 3);
            //When
            board.setCharacter(0, 0, 'X');
            board.setCharacter(0, 1, 'O');
            board.setCharacter(0, 2, 'X');
            board.setCharacter(1, 0, 'O');
            board.setCharacter(1, 1, 'O');
            board.setCharacter(1, 2, 'X');
            board.setCharacter(2, 0, 'X');
            board.setCharacter(2, 1, 'X');
            board.setCharacter(2, 2, 'O');
            //Then
            assertEquals(-1, board.endChecker());
        }
    }
    @Nested
    class GameEndTestsFor10x10 {
        @Test
        void gameEndForOHorizontalTest() {
            //Given
            Board board = new Board(10, 5);
            //When
            board.setCharacter(0, 0, 'O');
            board.setCharacter(0, 1, 'O');
            board.setCharacter(0, 2, 'O');
            board.setCharacter(0, 3, 'O');
            board.setCharacter(0, 5, 'X');
            board.setCharacter(0, 4, 'O');
            //Then
            assertEquals(1, board.endChecker());
        }

        @Test
        void gameEndForOVerticalTest() {
            //Given
            Board board = new Board(10, 5);
            //When
            board.setCharacter(0, 0, 'O');
            board.setCharacter(1, 0, 'O');
            board.setCharacter(2, 0, 'O');
            board.setCharacter(3, 0, 'O');
            board.setCharacter(4, 0, 'O');
            //Then
            assertEquals(1, board.endChecker());
        }

        @Test
        void gameEndForODiagonalTest() {
            //Given
            Board board = new Board(10, 5);
            //When
            board.setCharacter(0, 0, 'O');
            board.setCharacter(1, 1, 'O');
            board.setCharacter(2, 2, 'O');
            board.setCharacter(3, 3, 'O');
            board.setCharacter(4, 4, 'O');
            //Then
            assertEquals(1, board.endChecker());
        }

        @Test
        void drawTest() {
            //Given
            Board board = new Board(10, 5);
            //When
            for (int i = 0; i < board.getBoard().length; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < board.getBoard().length; j++) {
                        if ((i + j) % 5 == 0) board.setCharacter(i, j, 'X');
                        else board.setCharacter(i, j, 'O');
                    }
                } else {
                    for (int j = 0; j < board.getBoard().length; j++) {
                        if ((i + j) % 5 == 0) board.setCharacter(i, j, 'O');
                        else board.setCharacter(i, j, 'X');
                    }
                }
            }
                //Then
                assertEquals(-1, board.endChecker());
            }
        }

    @Nested
    class ExceptionTests{
       @Test
       void fieldOccupiedTest(){
           //Given
           Board board = new Board(3, 3);
           //When
           board.setCharacter(0, 0, 'X');
           //Then
           assertThrows(FieldOccupiedException.class, () -> board.setCharacter(0, 0, 'O'));
       }
       @Test
       void fieldDoesntExistTest(){
           //Given
           Board board = new Board(3, 3);
           //When & Then
           assertThrows(InputMismatchException.class, () -> board.setCharacter(-1, 0, 'X'));
       }
    }

    @Nested
    class AITests{
        @Test
        void hardMovePickerTest1(){
            //Given
            Board board = new Board(3, 3);
            MovePicker movePicker = new HardMovePicker('X', 'O');
            int expectedRow = 2;
            int expectedColumn = 0;
            int[] chosenMove;
            //When
            board.setCharacter(1, 1, 'X');
            board.setCharacter(1, 0, 'O');
            board.setCharacter(2, 2, 'X');
            board.setCharacter(0, 0, 'O');
            chosenMove = movePicker.pickMove(board);
            //Then
            assertEquals(expectedRow, chosenMove[0]);
            assertEquals(expectedColumn, chosenMove[1]);
        }
        @Test
        void hardMovePickerTest2(){
            //Given
            Board board = new Board(3, 3);
            MovePicker movePicker = new HardMovePicker('X', 'O');
            int expectedRow = 1;
            int expectedColumn = 0;
            int[] chosenMove;
            //When
            board.setCharacter(1, 1, 'X');
            board.setCharacter(0, 0, 'O');
            board.setCharacter(2, 2, 'X');
            board.setCharacter(2, 0, 'O');
            chosenMove = movePicker.pickMove(board);
            //Then
            assertEquals(expectedRow, chosenMove[0]);
            assertEquals(expectedColumn, chosenMove[1]);
        }
        @Test
        void hardMovePickerTest3(){
            //Given
            Board board = new Board(3, 3);
            MovePicker movePicker = new HardMovePicker('O', 'X');
            int expectedRow = 0;
            int expectedColumn = 0;
            int[] chosenMove;
            //When
            board.setCharacter(1, 1, 'X');
            board.setCharacter(1, 0, 'O');
            board.setCharacter(2, 2, 'X');
            board.setCharacter(2, 1, 'O');
            chosenMove = movePicker.pickMove(board);
            //Then
            assertEquals(expectedRow, chosenMove[0]);
            assertEquals(expectedColumn, chosenMove[1]);
        }
    }

}
