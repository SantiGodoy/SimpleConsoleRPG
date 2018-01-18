package com.projectdss;

import com.projectdss.Loader;
import com.projectdss.Saver;
import com.projectdss.character.MainCharacter;
import com.projectdss.input.ConsoleInput;
import com.projectdss.map.World;
import com.projectdss.output.ColoredConsoleOutput;
import com.projectdss.output.OutputManager;
import com.projectdss.output.StandardConsoleOutput;

public class App {
    public static void main(String[] args) {
        StandardConsoleOutput standardOutput = new StandardConsoleOutput();
        ColoredConsoleOutput coloredOutput = new ColoredConsoleOutput();

        OutputManager outputManager = new OutputManager(standardOutput);
        
        ConsoleInput consoleInput = new ConsoleInput();

        String filePath = "../../../resources/map.xml";
        Loader mapLoader = new Loader();
        Saver mapSaver = new Saver();

        World world = mapLoader.loadWorld(filePath);
        MainCharacter mainCharacter = mapLoader.loadMainCharacter(filePath);
    }
}