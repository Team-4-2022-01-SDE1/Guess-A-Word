package com.guessaword.model.board;

import com.guessaword.model.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class UserPanel {
    private static final String LIST_OF_PLAYERS_FROM_FILE = "Dictionary/players.dat";
    Player player;
    List<String> players;

    public String showUser(String username) {
        players = getListOfPlayers();
        if (!checkIfValidUser(username)) {
            //player = new Player(username);
        } else {
            player = getPlayerFromList(username);
        }
        return player.toString();
    }

    private List<String> getListOfPlayers() {
        try {
            players = Files.readAllLines(Path.of(LIST_OF_PLAYERS_FROM_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return players;
    }

    private boolean checkIfValidUser(String username) {
        for (String playah : players) {
            if (playah.contains(username)) {
                return true;
            }
        }
        return false;
    }

    private Player getPlayerFromList(String username) {
        for (String playah : players) {
            if (playah.contains(username)) {
                //player = new Player(username);
            }
        }
        return player;
    }
}
