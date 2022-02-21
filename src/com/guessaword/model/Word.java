package com.guessaword.model;

import java.util.*;

public class Word {
    public static final String RESET = "\033[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLACK = "\u001B[30m";

    private char[]  word;
    private char[] playerWord;
    private WordBank wordBank;

    public Map<Integer, String> checkLetter(){
        Map<Integer, String> result = new HashMap<>();

       List<Character> playerList = new ArrayList<>();
       List<Character> wordList = new ArrayList<>();

        for (char item: word){
            wordList.add(item);
        }
        for (char item: playerWord){
            playerList.add(item);
        }

        Character holder;
        for(int i = 0; i < 5; i++){
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
                result.put(i,ANSI_BLACK + holder + RESET);
            }
        }
        return result;
    }

    public void setPlayerWord(String input){
        playerWord = input.toCharArray();
    }

    private void setWord(){
        word = wordBank.getWord().toCharArray();
    }
    public char[] getWord(){
        return word;
    }

    // DELETE FOR TEST PROPOSES ONLY
    public void setWord(String input){
        this.word = input.toCharArray();
    }

    @Override
    public String toString(){
        return getClass().getSimpleName()+": word="+ Arrays.toString(getWord()) +", displayWord=" + Arrays.toString(getWord());
    }

}