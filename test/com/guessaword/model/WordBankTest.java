package com.guessaword.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class WordBankTest {
    List<String> dict;
    WordBank wordBank;

    @Before
    public void setUp() {
    wordBank = new WordBank(dict);
    }

    @Test
    public void testGetWord_returnsTrue_stringFromGetWordIsInDict() {
        String word = wordBank.getWord();
        dict = wordBank.getDict();
        assertTrue(dict.contains(word));
    }

    @Test
    public void testGetDict_returnsTrue_sizeOfDictFromGetDict() {
        assertEquals(535, wordBank.getDict().size());
    }

    @Test
    public void testSetDict_returnsTrue_setDictCreatesDictOfUniqueWords() {
        wordBank.setDict(dict);
        dict = wordBank.getDict();
        Set dictSet = new HashSet<>(dict);
        assertEquals(dict.size(), dictSet.size());
    }

    @Test
    public void convertToUpper() {
        dict = wordBank.getDict();
        String word = dict.get(0);
        // System.out.println(word);
        assertNotEquals("aargh", word);
    }
}