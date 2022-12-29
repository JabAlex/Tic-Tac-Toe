package com.tictactoe;

public class TicTacToeRunner {
    public static void main(String[] args) {
        UserCommunicationHandler userCommunicationHandler = new UserCommunicationHandler();
        ProfileManager profileManager = new ProfileManager();
        Ranking ranking = new Ranking();
        Profile player1Profile;
        Profile player2Profile;
        Game game = new Game();
        int size = 3;
        int inRowToWin = 3;
        boolean end = false;
        player1Profile = profileManager.chooseProfile(null, false);
        while(!end) {
            switch (userCommunicationHandler.startGameOption()) {
                case 1:
                    game.singlePlayerMode(size, inRowToWin, player1Profile);
                    profileManager.saveProfiles();
                    break;
                case 2:
                    player2Profile = profileManager.chooseProfile(player1Profile, true);
                    game.twoPlayerMode(size, inRowToWin, player1Profile, player2Profile);
                    profileManager.saveProfiles();
                    break;
                case 3:
                    switch(userCommunicationHandler.changeBoardSize(size)){
                        case 1:
                            size = 3;
                            inRowToWin = 3;
                            break;
                        case 2:
                            size = 10;
                            inRowToWin = 5;
                            break;
                        case 3:
                            size = userCommunicationHandler.setSize();
                            inRowToWin = userCommunicationHandler.setInRowToWin(size);
                            break;
                        case 4: break;
                    }
                    profileManager.saveProfiles();
                    break;
                case 4:
                    switch(userCommunicationHandler.profileOption()){
                        case 1:
                            player1Profile = profileManager.chooseProfile(player1Profile, false);
                            break;
                        case 2:
                            profileManager.deleteProfile();
                    }
                    profileManager.saveProfiles();
                    break;
                case 5:
                    ranking.showRanking(profileManager.getProfileList());
                    break;
                case 6:
                    end = true;
                    break;

            }
        }

    }
}
