package com.guessaword.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WordTest {
    private Word word;
    private WordBank wordBank;
    private List<String> dict;

    @Before
    public void setUp() {
        dict = new ArrayList<>();
        wordBank = new WordBank(dict);

        word = new Word();
        word.setWordArr(wordBank.dict.get(1));
        word.setPlayerWord("Aargh");
    }

    @Test
    public void checkLetter() {
        Map<Integer,String> map = word.checkLetter();

        for(Map.Entry<Integer,String> item: map.entrySet()){
            System.out.print(item.getValue());
        }


    }
}