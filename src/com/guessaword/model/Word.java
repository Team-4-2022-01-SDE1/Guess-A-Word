package com.guessaword.model;

import java.util.*;

public class Word {
    public static final String RESET = "\033[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GRAY = "\u001B[37m";

    private char[] wordArr;
    private char[] playerWord;

    public Map<Integer, String> checkLetter(){
        Map<Integer, String> result = new HashMap<>();

       List<Character> playerList = toList(playerWord);
       List<Character> wordList = toList(wordArr);


        Character holder;
        for(int i = 0; i < 5; i++){
            if (wordList.get(i).equals(playerList.get(i))){
                holder = playerList.get(i);
                result.put(i, BOLD + ANSI_GREEN + holder + RESET);
            }
            else if (wordList.contains(playerList.get(i))){
                holder = playerList.get(i);
                result.put(i, BOLD + ANSI_YELLOW + holder + RESET);
            }
            else{
                holder = playerList.get(i);
                result.put(i, BOLD + ANSI_GRAY + holder + RESET);
            }
        }
        return result;
    }

    public boolean areWordsEqual(){
        return Arrays.toString(wordArr).equalsIgnoreCase(Arrays.toString(playerWord));
    }

    private List<Character> toList(char[] items){
        List<Character> result = new ArrayList<>();
        for (char item: items){
            result.add(item);
        }
        return result;
    }

    public void setPlayerWord(String input){
        playerWord = input.toUpperCase().toCharArray();
    }

    public char[] getWord(){
        return wordArr;
    }

    public void setWord(String word){
        this.wordArr = word.toUpperCase().toCharArray();
    }
  
    @Override
    public String toString(){
        return getClass().getSimpleName()+": word="+ Arrays.toString(getWord()) +", displayWord=" + Arrays.toString(getWord());
    }

}