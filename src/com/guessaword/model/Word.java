package com.guessaword.model;

import java.util.*;

public class Word {
    public static final String RESET = "\033[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final int WORD_LENGTH = 5;

    private char[] wordArr;
    private char[] playerWord;


    public Map<Integer, String> checkLetter(){
        Map<Integer, String> result = new HashMap<>();

        List<Character> wordList = toList(wordArr);
        List<Character> playerList = toList(playerWord);


        char holder;
        for(int i = 0; i < WORD_LENGTH; i++){
            if (wordList.get(i).equals(playerList.get(i))){
                holder = playerList.get(i);
                result.put(i,ANSI_GREEN + holder + RESET);
            }
            else if (wordList.contains(playerList.get(i))){
                holder = playerList.get(i);
                result.put(i, ANSI_YELLOW + holder + RESET);
            }
            else{
                holder = playerList.get(i);
                result.put(i,ANSI_WHITE + holder + RESET);
            }
        }
        return result;
    }

    public boolean areWordsEqual(){
        return Arrays.toString(wordArr).equalsIgnoreCase(Arrays.toString(playerWord));
    }


    public char[] getWordArr(){
        return wordArr;
    }
    

    public void setPlayerWord(String input) throws IllegalArgumentException{
        if (input.length() != WORD_LENGTH )
        {
            throw new IllegalArgumentException("Invalid Word: " + input +". Must be a 5-letter word.");
        }
        playerWord = input.toUpperCase().toCharArray();
    }

    private List<Character> toList(char[] items){
        List<Character> result = new ArrayList<>();
        for (char item: items){
            result.add(item);
        }
        return result;
    }

    public void setWordArr(String input){
        this.wordArr = input.toUpperCase().toCharArray();
    }


    @Override
    public String toString(){
        return getClass().getSimpleName()+": word="+ Arrays.toString(getWordArr()) +", displayWord=" + Arrays.toString(getWordArr());
    }

}