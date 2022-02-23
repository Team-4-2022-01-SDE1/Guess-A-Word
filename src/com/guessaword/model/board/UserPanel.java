package com.guessaword.model.board;

import com.guessaword.model.Player;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class UserPanel implements Serializable {
    private static final String LIST_OF_PLAYERS_FROM_FILE = "data/players.dat";
    private List<Player> players = new ArrayList<>();

    public static UserPanel getInstance() {
        UserPanel userPanel = null;
        if (Files.exists(Path.of(LIST_OF_PLAYERS_FROM_FILE))) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(LIST_OF_PLAYERS_FROM_FILE))) {
                userPanel = (UserPanel) inputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            userPanel = new UserPanel();
        }
        return userPanel;
    }

    public boolean validateNewUserName(String username) {
        for (Player player: players) {
            if (player.getName().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    public Player show(Player currPlayer) {
        System.out.printf("%10s%12s%10s%10s%10s%10s%10s%10s%10s%10s\n",
                "ID",
                "Player",
                "Wins",
                "First",
                "Second",
                "Third",
                "Fourth",
                "Fifth",
                "Sixth",
                "Losses"
        );
        String five = "-----";
        String six = "------";
        System.out.printf("%10s%12s%10s%10s%10s%10s%10s%10s%10s%10s\n",
                "--",
                six,
                "----",
                five,
                six,
                five,
                six,
                five,
                five,
                six
        );
        boolean isNotNewPlayer = true;
        for (Player player: players) {
            if (player.getName().equalsIgnoreCase(currPlayer.getName())) {
                isNotNewPlayer = false;
                currPlayer = player;
                System.out.println(currPlayer);
            }
        }
        if (isNotNewPlayer) {
            currPlayer.setPlayerId(players.size() + 1);
            System.out.println(currPlayer);
        }
        return currPlayer;
    }

    public void update(Player currPlayer) {
        boolean isNotNewPlayer = true;
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(currPlayer.getName())) {
                isNotNewPlayer = false;
                players.remove(player);
                players.add(currPlayer);
            }
        }
        if (isNotNewPlayer) {
            players.add(currPlayer);
        }
        save();
    }

    public void save() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(LIST_OF_PLAYERS_FROM_FILE))) {
            outputStream.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}