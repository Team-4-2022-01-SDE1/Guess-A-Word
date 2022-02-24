package com.guessaword.controller;

import com.guessaword.model.Player;
import com.guessaword.model.WordBank;
import com.guessaword.model.board.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class GuessAWordAppTest {
    private List<String> dict = new ArrayList<>();
    private WordBank wordBank;

    @Before
    public void setUp() {
        List<String> dict = new ArrayList<>();
        wordBank = new WordBank(dict);
    }

    @Test
    public void testStart_returnsTrue_wordIsInWordsListFromWordBank() {
        String word = wordBank.getWord();
        List<String> words = wordBank.getDict();
        assertTrue(words.contains(word));
    }
}