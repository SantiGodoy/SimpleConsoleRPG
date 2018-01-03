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
        System.out.println();
    }

    @Override
    public void showGameOverMessage(String message) {
        System.out.println();
    }

    @Override
    public void showWinMessage(String message) {
        System.out.println();
    }

    @Override
    public void showGlobalMenu() {
        System.out.println();
    }

    @Override
    public void showGameInformation() {
        System.out.println();
    }
}