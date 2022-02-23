package com.guessaword.model.board;

import com.guessaword.model.WordBank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prompts {
    private static Scanner input = new Scanner(System.in);

    public static String getOption() {
        String option = "";
        boolean inValidInput = true;
        while (inValidInput) {
            System.out.print("Are you a returning player [y/n]: ");
            option = input.nextLine();
            if (!option.equalsIgnoreCase("y") || !option.equalsIgnoreCase("n")) {
                inValidInput = false;
            }
        }
        return option;
    }

    public static String getUserName() {
        System.out.print("Please enter a valid username: ");
        return input.nextLine();
    }

    public static String getUserWord() {
        List<String> dict = new ArrayList<>();
        WordBank wordBank = new WordBank(dict);
        dict = wordBank.getDict();
        boolean isInDict = true;
        String userWord = "";

        while (isInDict) {
            System.out.print("\nPlease enter a five letter word: ");
            userWord = input.nextLine();
            for (String str : dict) {
                if (userWord.equalsIgnoreCase(str)) {
                    isInDict = false;
                }
            }
            if (isInDict || userWord.length() != 5) {
                System.out.println("Sorry that word is not a real word.");
                isInDict = true;
            }
        }
        return userWord;
    }
}