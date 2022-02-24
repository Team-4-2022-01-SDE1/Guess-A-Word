package com.guessaword.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.*;

public class WordBank {
    protected List<String> dict;
    private static final String LIST_OF_WORDS_FROM_FILE = "data/words.txt";

    public WordBank(List<String> dict) {
        setDict(dict);
    }

    public String getWord() {
        int index = (int)(Math.random() * dict.size()) + 1;
        return dict.get(index);
    }

    public List<String> getDict() {
        return dict;
    }

    public void setDict(List<String> dict) {
        try {
            dict = Files.readAllLines(Path.of(LIST_OF_WORDS_FROM_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dict = convertToUpper(dict);
        Collections.sort(dict);
        this.dict = dict;
    }

    public List<String> convertToUpper(List<String> list) {
        return list.stream()
                .distinct()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}