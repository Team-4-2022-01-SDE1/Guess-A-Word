package com.guessaword.model;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class WordTest {
    private Word word;

    @Before
    public void setUp() {
        word = new Word();
        word.setWord("force");
        word.setPlayerWord("earth");
    }

    @Test
    public void checkLetter() {
        Map<Integer,String> map = word.checkLetter();

        for(Integer key: map.keySet()){
            System.out.println(key + " = " + map.get(key));
        }
    }
}