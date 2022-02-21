package com.guessaword.model.board;

public class TitlePanel {
    public static final String BOLD = "\u001B[1m";
    public static final String ITALIC = "\u001B[3m";
    public static final String UNDERLINE = "\u001B[4m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED	= "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GRAY = "\u001B[37m";

    public void showTitle() {

        title();
        showInstructions();
    }

    public void title() {
        System.out.println(ANSI_CYAN + "███████╗ ██╗   ██╗███████╗███████╗███████╗     █████╗     ██╗    ██╗ ██████╗ ██████╗ ██████╗\n" +
             "██╔════╝ ██║   ██║██╔════╝██╔════╝██╔════╝    ██╔══██╗    ██║    ██║██╔═══██╗██╔══██╗██╔══██╗\n" +
             "██║  ███╗██║   ██║█████╗  ███████╗███████╗    ███████║    ██║ █╗ ██║██║   ██║██████╔╝██║  ██║\n" +
             "██║   ██║██║   ██║██╔══╝  ╚════██║╚════██║    ██╔══██║    ██║███╗██║██║   ██║██╔══██╗██║  ██║\n" +
             "╚██████╔╝╚██████╔╝███████╗███████║███████║    ██║  ██║    ╚███╔███╔╝╚██████╔╝██║  ██║██████╔╝\n" +
             " ╚═════╝  ╚═════╝ ╚══════╝╚══════╝╚══════╝    ╚═╝  ╚═╝     ╚══╝╚══╝  ╚═════╝ ╚═╝  ╚═╝╚═════╝\n\n" + ANSI_RESET);
    }

    public void showInstructions() {
        System.out.println(UNDERLINE + BOLD + ANSI_CYAN + "INSTRUCTIONS" + ANSI_RESET);
        System.out.println(ITALIC + ANSI_RED + "Guess a Word has chosen a 5-letter word. You have 6 tries to guess the word. ");
        System.out.println("Correct and incorrect letters in each of your guesses will be identified as follows:" + ANSI_RESET);
        System.out.println("- Letters highlighted in " + UNDERLINE + BOLD + ANSI_GREEN + "G R E E N" + ANSI_RESET + " appear in the word and are in the correct position.");
        System.out.println("- Letters highlighted in " + UNDERLINE + BOLD + ANSI_YELLOW + "Y E L L O W" + ANSI_RESET + " appear in the word but in a different position.");
        System.out.println("- Letters highlighted in " + UNDERLINE + BOLD + ANSI_GRAY + "G R A Y" + ANSI_RESET + " do not appear in the word.\n\n");
    }
}