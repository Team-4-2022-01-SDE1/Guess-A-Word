package com.guessaword.model.board;

import com.guessaword.model.Player;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class UserPanel {
    private static final String LIST_OF_PLAYERS_FROM_FILE = "Dictionary/players.dat";
    Player player;
    List<String> players = new ArrayList<>();

    public static UserPanel getInstance() {
        UserPanel userPanel = null;
        if (Files.exists(Path.of("data/players.dat"))) {
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

    public void show(String username) {
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
        System.out.printf("%10s%12s%10s%10s%10s%10s%10s%10s%10s%10s\n",
                "--",
                "------",
                "----",
                "-----",
                "------",
                "-----",
                "------",
                "-----",
                "-----",
                "------"
        );
        if (players == null) {
            player = new Player(username);
            System.out.println(player);
            return;
        }
        for (String player: players) {
            if (player.contains(username)) {
                System.out.println(player);
            }
        }
    }
}
