package com.guessaword.controller;

import com.guessaword.model.board.Prompts;
import com.guessaword.model.board.TitlePanel;
import com.guessaword.model.board.UserPanel;

public class GuessAWordApp {
    TitlePanel titlePanel = new TitlePanel();
    UserPanel userPanel = new UserPanel();



    public void start() {
        titlePanel.showTitle();
        String username = Prompts.getUserName();

        System.out.println(userPanel.showUser(username));


        // showStatistics();
        // showWordPane();
        // showResults
    }
}