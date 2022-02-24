package com.guessaword.model.board;

import java.util.Scanner;

public class Prompts {
    private static Scanner input = new Scanner(System.in);

    public static String getUserName() {
        System.out.print("Please enter your username: ");
        return input.nextLine();
    }
}
