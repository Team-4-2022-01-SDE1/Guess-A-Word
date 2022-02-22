package com.guessaword.controller;

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
        titlePanel.showTitle();
        String username = Prompts.getUserName();
        userPanel.show(username);
        String word = wordBank.getWord();
        int count = wordPanel.showWordPanel(word);
        results.showResults(count);
    }
}