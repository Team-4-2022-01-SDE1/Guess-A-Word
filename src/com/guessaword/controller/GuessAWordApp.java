package com.guessaword.controller;

import com.guessaword.model.Player;
import com.guessaword.model.WordBank;
import com.guessaword.model.board.*;

import java.util.ArrayList;
import java.util.List;

public class GuessAWordApp {
    private List<String> dict = new ArrayList<>();
    private WordBank wordBank = new WordBank(dict);
    private Player player;
    private TitlePanel titlePanel = new TitlePanel();
    private UserPanel userPanel = UserPanel.getInstance();
    private WordPanel wordPanel = new WordPanel();
    private Results results = new Results();

    public void start() {
        String word = wordBank.getWord();
        titlePanel.showTitle();
        titlePanel.showInstructions();
        String username = Prompts.getUserName();
        player = new Player(username);
        if (userPanel == null) {
            System.out.println("Sorry no records exist for " + player.getName());
        } else {
            player = userPanel.show(player);
        }
        /*
        clearConsole();
        titlePanel.showTitle();
        userPanel.show(username);
         */

        int count = wordPanel.showWordPanel(word);
        player.setStats(count);
        results.showResults(count);
        update(player);
    }

    public void update(Player player) {
        if (userPanel == null) {
            System.out.println("Sorry no records exist for " + player.getName());
        } else {
            userPanel.update(player);
        }
    }

    private void clearConsole() {
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system

            if(operatingSystem.contains("Windows")){
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}