package com.tictactoe;

import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTestSuite {
    @Test
    void gameEndTest(){
        //Given
        Board columnBoard = new Board();
        Board diagonalBoard = new Board();
        Board emptyBoard = new Board();
        Board drawBoard = new Board();
        //When
        columnBoard.setCharacter("a1",'X');
        columnBoard.setCharacter("a2",'X');
        columnBoard.setCharacter("a3",'X');

        diagonalBoard.setCharacter("a1", 'O');
        diagonalBoard.setCharacter("b2", 'O');
        diagonalBoard.setCharacter("c3", 'O');

        drawBoard.setCharacter("a1", 'X');
        drawBoard.setCharacter("a2", 'X');
        drawBoard.setCharacter("a3", 'O');
        drawBoard.setCharacter("b1", 'O');
        drawBoard.setCharacter("b2", 'X');
        drawBoard.setCharacter("b3", 'X');
        drawBoard.setCharacter("c1", 'X');
        drawBoard.setCharacter("c2", 'O');
        drawBoard.setCharacter("c3", 'O');

        //Then
        assertTrue(columnBoard.endChecker());
        assertEquals(1, columnBoard.resultChecker());
        assertTrue(diagonalBoard.endChecker());
        assertEquals(2, diagonalBoard.resultChecker());
        assertTrue(drawBoard.endChecker());
        assertEquals(0, drawBoard.resultChecker());
        assertFalse(emptyBoard.endChecker());
    }
    @Test
    void inputErrorTest(){
        Board board = new Board();

        board.setCharacter("a1", 'X');

        assertThrows( FieldOccupiedException.class, () -> board.setCharacter("a1", 'O'));
        assertThrows(InputMismatchException.class, () -> board.setCharacter("d1", 'X'));
        assertThrows(InputMismatchException.class, () -> board.setCharacter("a4", 'X'));
        assertDoesNotThrow(() -> board.setCharacter("a2", 'O'));
    }
}
