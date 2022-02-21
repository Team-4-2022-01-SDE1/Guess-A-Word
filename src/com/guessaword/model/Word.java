package com.guessaword.model;

import java.util.*;

public class Word {
    private char[]  word;
    private char[] playerWord;

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


        for(int i = 0; i < 5; i++){
            if (wordList.get(i).equals(playerList.get(i))){
                result.put(i,"Green"); // TODO: update with ASCII value
            }
            else if (wordList.contains(playerList.get(i))){
                result.put(i, "Yellow"); // TODO: update with ASCII value
            }
            else{
                result.put(i,"Gray"); // TODO: update with ASCII value
            }
        }
        return result;
    }

    public void setPlayerWord(String input){
        playerWord = input.toCharArray();
    }

    public char[] getWord(){
        WordBank bank = new WordBank();
        String bankWord = bank.getWord();
        word = bankWord.toCharArray();

        return word;
    }

    @Override
    public String toString(){
        return getClass().getSimpleName()+": word="+ Arrays.toString(getWord()) +", displayWord=" + Arrays.toString(getWord());
    }

}