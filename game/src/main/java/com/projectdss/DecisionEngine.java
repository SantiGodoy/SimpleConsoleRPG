package com.projectdss;

import com.projectdss.Loader;
import com.projectdss.character.MainCharacter;
import com.projectdss.event.EventParameter;
import com.projectdss.input.InputManager;
import com.projectdss.map.World;
import com.projectdss.output.ColoredConsoleOutput;
import com.projectdss.output.OutputHandler;
import com.projectdss.output.OutputManager;
import com.projectdss.output.StandardConsoleOutput;


/**
 * @author JoseCorrero
 * 
 * Class DecisionEngine.
 */
public class DecisionEngine {

    private OutputManager output;
    private InputManager input;
    private Loader loader;
    private Saver saver;
    private final String newGameFilePath = "../src/main/resources/newGame.xml";
    //private final String saveFilePath = "../src/main/resources/save.xml";

    public DecisionEngine(OutputManager output, InputManager input,
                          Loader loader, Saver saver) {
        this.output= output;
        this.input = input;
        this.loader = loader;
        this.saver = saver;
    }

    public void startMenu() {
        int option;

        do {
            output.showGlobalMenu();
            option = input.getInput(0, 4);
            switch(option) {
                case 1: run(loader.loadMainCharacter(newGameFilePath),
                            loader.loadWorld(newGameFilePath));
                    break;
                case 2: 
                    break;
                case 3: output.showGlobalSettings();
                        int option3 = input.getInput(0, 2);
                        switch(option3) {
                            case 1: output = new OutputManager(new StandardConsoleOutput());
                                break;
                            case 2: output = new OutputManager(new ColoredConsoleOutput());
                                break;
                            default:
                                break;
                        }
                    break;
                case 4: output.showGameInformation();
                    break;
                default:
                    break;
            }
        } while(option != 0);
    }

    private void run(MainCharacter player, World world) {
        int numOptions, indexEvent;
        Event[] events;

        while(player.isAlive()) {
            output.showWorldInformation(player, world);

            if(player.isIn())
                events = world.getZones()[player.getIdZone()].getMinizones()[player.getIdMinizone()].getEvents();
            else
                events = world.getZones()[player.getIdZone()].getEvents();

            numOptions = output.showEvents(events);
            indexEvent = input.getInput(0, numOptions);
            if(indexEvent == 0) {
                output.showSaveLoadExitOptions();
                int option = input.getInput(0, 4);
                switch(option) {
                    case 1: //loader.loadMainCharacter(saveFilePath);
                        break;
                    case 2: //saver.saveMainCharacter(saveFilePath);
                        break;
                    case 3: //saver.saveMainCharacter(saveFilePath);
                            return;
                    case 4: return;
                    default:
                }
            } else
                events[indexEvent - 1].run(new EventParameter(output, input, player, world));
        }
    }

}