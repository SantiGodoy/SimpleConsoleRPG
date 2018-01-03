package com.projectdss.output;

import com.projectdss.output.ConsoleOutput;
import com.projectdss.character.MainCharacter;

public class StandardConsoleOutput extends ConsoleOutput {

    @Override
    public void showHUD(MainCharacter player) {
        System.out.println();
    }

    @Override
    public void showStartingMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showGameOverMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showWinMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showGlobalMenu() {
        System.out.println("Main Menu" + 
        "\n\t1- New Game" +
        "\n\t2- Option" +
        "\n\t3- Credits");
    }

    @Override
    public void showGameInformation() {
        System.out.println("Developers:" + 
        "\n\tJosé Correro Barquín" +
        "\n\tSantiago Godoy Poce" +
        "\n\tAntonio García Velatta");
        Thread.sleep(7000);
    }
}