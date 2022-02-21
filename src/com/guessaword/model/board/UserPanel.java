package com.guessaword.model.board;

import com.guessaword.model.Player;

import java.util.List;

public class UserPanel {

    Player player;
    List<Player> players;

    public String showUser(String username) {
        players = getListOfPlayers();
        if (!checkIfValidUser(username)) {
            // create a new user
            // player = new Player(username);
        } else {
            player = getPlayerFromList(username);
        }
        String user = "";
        // to display username and statistics
        return user;
    }

    private List<Player> getListOfPlayers() {
        // read list of players from file
        return players;
    }

    private boolean checkIfValidUser(String username) {
        // check if username is on list
        return true;
    }

    private Player getPlayerFromList(String username) {
        // get player object from list
        return player;
    }
}
