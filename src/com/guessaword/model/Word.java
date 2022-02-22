package com.guessaword.model;

import java.util.*;

public class Word {
    public static final String RESET = "\033[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final int WORD_LENGTH = 5;

    private char[]  word;
    private char[] playerWord;
    private WordBank wordBank; // TODO: Need to initiate.
                               // Can not right now because WorkBank ctor requires List<String> arg

    public Map<Integer, String> checkLetter(){
        Map<Integer, String> result = new HashMap<>();

        List<Character> wordList = toList(word);
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
        return Arrays.toString(word).equalsIgnoreCase(Arrays.toString(playerWord));
    }

    public void setPlayerWord(String input){
        if (input.length() != WORD_LENGTH )
        {
            throw new IllegalArgumentException("Invalid Word: " + input +". Must be a 5-letter word.");
        }
        playerWord = input.toUpperCase().toCharArray();
    }

    // TODO: Need to initiate word bank "new"
    public void setWord(){
        word = wordBank.getWord().toUpperCase().toCharArray();
    }

    public char[] getWord(){
        return word;
    }

    // DELETE FOR TEST PROPOSES ONLY
    public void setWord(String input){
        this.word = input.toUpperCase().toCharArray();
    }

    private List<Character> toList(char[] items){
        List<Character> result = new ArrayList<>();
        for (char item: items){
            result.add(item);
        }
        return result;
    }

    @Override
    public String toString(){
        return getClass().getSimpleName()+": word="+ Arrays.toString(getWord()) +", displayWord=" + Arrays.toString(getWord());
    }

}