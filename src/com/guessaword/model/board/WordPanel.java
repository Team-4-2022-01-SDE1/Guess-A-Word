package com.guessaword.model.board;

import com.guessaword.model.Word;

import java.util.Map;

public class WordPanel {

    Word word = new Word();
    Map<Integer, String> result;

    public int showWordPanel(String secretWord) {
        // get user input
        String userWord = "";
        word.setWord(secretWord);
        int count = 1;
        while (count < 7) {
            userWord = Prompts.getUserWord();
            word.setPlayerWord(userWord);

            result = word.checkLetter();
            formatResult(result);
            if (secretWord.equalsIgnoreCase(userWord))
                break;
            count++;
        }
        return count;
    }

    private void formatResult(Map<Integer, String> result) {
        System.out.printf("%4s %4s %4s %4s %4s",
                result.get(0),
                result.get(1),
                result.get(2),
                result.get(3),
                result.get(4)
        );
    }
}