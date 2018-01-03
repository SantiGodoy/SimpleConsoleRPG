package com.projectdss.input;

import java.util.Scanner;

public class ConsoleInput implements InputHandler {
    @Override
    public int getInput() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}