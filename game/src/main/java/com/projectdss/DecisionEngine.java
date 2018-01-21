package com.projectdss;

import com.projectdss.character.MainCharacter;
import com.projectdss.event.EventParameter;
import com.projectdss.input.InputManager;
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
    private final String startFilePath = "../src/main/resources/map.xml";
    private final String saveFilePath = "../src/main/resources/save.xml";

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
                case 1: run(loader.loadMainCharacter(startFilePath));
                    break;
                case 2: run(loader.loadMainCharacter(saveFilePath));
                    break;
                case 3: output.showGlobalSettings();
                        option = input.getInput(0, 2);
                        switch(option) {
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

    private void run(MainCharacter player) {
        int numOptions, indexEvent;
        Event[] events;

        while(player.isAlive()) {
            output.showWorldInformation(player);

            if(player.isIn())
                events = player.getZone().getEvents();
            else
                events = player.getMinizone().getEvents();

            numOptions = output.showEvents(events);
            indexEvent = input.getInput(0, numOptions);
            if(indexEvent == 0) {
                output.showSaveLoadExitOptions();
                int option = input.getInput(0, 4);
                switch(option) {
                    case 1: loader.loadMainCharacter(saveFilePath);
                        break;
                    case 2: saver.saveMainCharacter(saveFilePath);
                        break;
                    case 3: saver.saveMainCharacter(saveFilePath);
                            return;
                    case 4: return;
                    default:
                }
            } else
                events[indexEvent - 1].run(new EventParameter(output, input, player));
        }
    }

}