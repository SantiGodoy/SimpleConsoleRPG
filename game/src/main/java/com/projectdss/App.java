package com.projectdss;

import com.projectdss.Loader;
import com.projectdss.Saver;
import com.projectdss.character.MainCharacter;
import com.projectdss.input.ConsoleInput;
import com.projectdss.input.InputManager;
import com.projectdss.map.World;
import com.projectdss.output.ColoredConsoleOutput;
import com.projectdss.output.OutputManager;
import com.projectdss.output.StandardConsoleOutput;

public class App {
    public static void main(String[] args) {
        OutputManager outputManager = new OutputManager(new StandardConsoleOutput());
        InputManager inputManager = new InputManager(new ConsoleInput());
        
        Loader loader = new Loader();
        Saver saver = new Saver();

        DecisionEngine decisionEngine = new DecisionEngine(outputManager, inputManager, loader, saver);
        decisionEngine.startMenu();
    }
}