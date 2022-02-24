package com.guessaword.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class WordTest {
    private Word word;
    private WordBank wordBank;

    @Before
    public void setUp() {
        List<String> dict = new ArrayList<>();
        wordBank = new WordBank(dict);

        word = new Word();
        word.setWord(wordBank.dict.get(1));
        word.setPlayerWord("AARAH");
    }

    @Test
    public void checkLetter() {
        Map<Integer,String> map = word.checkLetter();

        for(Integer key: map.keySet()){
            System.out.println(key + " = " + map.get(key));
        }
        System.out.println(wordBank.dict.get(1));
    }
}