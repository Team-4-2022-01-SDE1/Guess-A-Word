package com.guessaword.model;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

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
        word.setPlayerWord("AARGH");
    }

    @Test
    public void checkLetter_returnMapEntry_whenComperingUserWordAgainstDictionaryWord() {
        Map<Integer,String> wordMap = word.checkLetter();
        assertNotNull(wordMap);
        assertEquals(5,wordMap.size());
        String dictWord = Arrays.toString(word.getWord());
        String playerWord= Arrays.toString(word.getPlayerWord());
        assertEquals(dictWord, playerWord);
    }

}