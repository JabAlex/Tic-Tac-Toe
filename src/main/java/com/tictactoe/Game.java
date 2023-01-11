package com.tictactoe;

public class Game {
    GameDisplayer gameDisplayer = new GameDisplayer();
    UserCommunicationHandler userCommunicationHandler = new UserCommunicationHandler();
    public void singlePlayerMode(int size, int inRowToWin, Profile playerProfile){
        char player;
        char computer;
        MovePicker movePicker;
        Board board = new Board(size, inRowToWin);
        if(userCommunicationHandler.singlePlayerOption() == 1){
            player = 'X';
            computer = 'O';
        } else{
            player = 'O';
            computer = 'X';
        }
        if (userCommunicationHandler.difficultyOption() == 2) {
            movePicker = new HardMovePicker(computer, player);
        } else {
            movePicker = new EasyMovePicker();
        }

        while(true){
            try {
                if (computer == 'X') {
                    if (computerMove(computer, board, movePicker, playerProfile)) break;
                    if (playerMove(player, board, playerProfile)) break;
                } else {
                    if (playerMove(player, board, playerProfile)) break;
                    if (computerMove(computer, board, movePicker, playerProfile)) break;
                }
            } catch (ExitGameException e){
                break;
            }
        }
    }

    private boolean playerMove(char player, Board board, Profile playerProfile) {
        gameDisplayer.drawBoard(board);
        userCommunicationHandler.placeCharacter(player, board, playerProfile);
        if(board.endChecker() == 1){
            playerProfile.addWonGame();
            gameDisplayer.drawBoard(board);
            userCommunicationHandler.showResult('P');
            return true;
        }
        if (board.endChecker() == -1){
            playerProfile.addDrawnGame();
            gameDisplayer.drawBoard(board);
            userCommunicationHandler.showResult('D');
            return true;
        }
        return false;
    }

    private boolean computerMove(char computer, Board board, MovePicker movePicker, Profile playerProfile) {
        int[] field;
        field = movePicker.pickMove(board);
        board.setCharacter(field[0], field[1], computer);
        if(board.endChecker() == 1){
            playerProfile.addLostGame();
            gameDisplayer.drawBoard(board);
            userCommunicationHandler.showResult('C');
            return true;
        }
        if(board.endChecker() == -1){
            playerProfile.addDrawnGame();
            gameDisplayer.drawBoard(board);
            userCommunicationHandler.showResult('D');
            return true;
        }
        return false;
    }

    public void twoPlayerMode(int size, int inRowToWin, Profile player1Profile, Profile player2Profile){
        Board board = new Board(size, inRowToWin);
        char player;
        char player1;
        char player2;
        boolean isPlayer1Turn;
        if(userCommunicationHandler.twoPlayerOption(player1Profile.getName(), player2Profile.getName()) == 1){
            player1 = 'X';
            player2 = 'O';
            player = player1;
            isPlayer1Turn = true;
        } else{
            player1 = 'O';
            player2 = 'X';
            player = player2;
            isPlayer1Turn = false;
        }
        gameDisplayer.drawBoard(board);
        while(true) {
            try {
                if (isPlayer1Turn)
                    userCommunicationHandler.placeCharacter(player, board, player1Profile);
                else userCommunicationHandler.placeCharacter(player, board, player2Profile);
            } catch (ExitGameException e){
                break;
            }
            gameDisplayer.drawBoard(board);
            if(board.endChecker() == 1){
                if(isPlayer1Turn) {
                    player1Profile.addWonGame();
                    player2Profile.addLostGame();
                }
                else {
                    player2Profile.addWonGame();
                    player1Profile.addLostGame();
                }
                userCommunicationHandler.showResult(player);
                break;
            }
            if (board.endChecker() == -1){
                player1Profile.addDrawnGame();
                player2Profile.addDrawnGame();
                userCommunicationHandler.showResult('D');
                break;
            }
            if(isPlayer1Turn){
                player = player2;
                isPlayer1Turn = false;
            } else {
                player = player1;
                isPlayer1Turn = true;
            }
        }
    }
}
