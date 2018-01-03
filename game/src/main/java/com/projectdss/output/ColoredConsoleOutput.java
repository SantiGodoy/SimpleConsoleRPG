package com.projectdss.output;

import com.projectdss.output.ConsoleOutput;
import com.projectdss.character.MainCharacter;

public class ColoredConsoleOutput extends ConsoleOutput {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";
    
    @Override
    public void showHUD(MainCharacter player) {
        System.out.println();
    }

    @Override
    public void showStartingMessage(String message) {
        System.out.println(ANSI_CYAN + message + ANSI_RESET);
    }

    @Override
    public void showGameOverMessage(String message) {
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }

    @Override
    public void showWinMessage(String message) {
        System.out.println(ANSI_GREEN + message + ANSI_RESET);
    }

    @Override
    public void showGlobalMenu() {
        System.out.println(ANSI_WHITE + "Main Menu" + ANSI_RESET + 
        ANSI_GREEN + "\n\t1- New Game" +
        "\n\t2- Option" +
        "\n\t3- Credits" + ANSI_RESET);
    }

    @Override
    public void showGameInformation() {
        System.out.println(ANSI_PURPLE + "Developers:" + 
        "\n\tJosé Correro Barquín" +
        "\n\tSantiago Godoy Poce" +
        "\n\tAntonio García Velatta" + ANSI_RESET);
        Thread.sleep(7000);
    }
}