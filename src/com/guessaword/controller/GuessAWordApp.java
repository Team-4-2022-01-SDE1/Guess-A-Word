package com.guessaword.controller;

import com.guessaword.model.Player;
import com.guessaword.model.WordBank;
import com.guessaword.model.board.*;

import java.util.ArrayList;
import java.util.List;

public class GuessAWordApp {
    private List<String> dict = new ArrayList<>();
    private WordBank wordBank = new WordBank(dict);

    private TitlePanel titlePanel = new TitlePanel();
    private UserPanel userPanel = UserPanel.getInstance();
    private WordPanel wordPanel = new WordPanel();
    private Results results = new Results();

    public void start() {
        Player player;

        String word = wordBank.getWord();
        titlePanel.showTitle();
        titlePanel.showInstructions();

        String option = Prompts.getOption();
        String username = validateUser(option);

        player = new Player(username);

        if (userPanel == null) {
            System.out.println("\nSorry no records exist for " + player.getName());
        } else {
            player = userPanel.show(player);
        }

        int count = wordPanel.showWordPanel(word);
        player.setStats(count);
        results.showResults(count);
        update(player);
    }

    private String validateUser(String option) {
        String username = "";
        boolean invalidUserName = true;
        if (option.equalsIgnoreCase("n")) {
            while (invalidUserName) {
                username = Prompts.getUserName();
                if (userPanel == null) {
                    invalidUserName = false;
                } else {
                    invalidUserName = userPanel.validateNewUserName(username);
                }
            }
        } else {
            username = Prompts.getUserName();
        }
        return username;
    }

    private void update(Player player) {
        if (userPanel == null) {
            System.out.println("\nSorry no records exist for " + player.getName());
        } else {
            userPanel.update(player);
        }
    }
}