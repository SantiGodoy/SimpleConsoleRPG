package com.projectdss;

import com.projectdss.character.MainCharacter;
import com.projectdss.event.EventParameter;
import com.projectdss.input.InputManager;
import com.projectdss.output.OutputHandler;
import com.projectdss.output.OutputManager;
import com.projectdss.output.StandardConsoleOutput;


/**
 * @author JoseCorrero
 * 
 * Class DecisionEngine.
 */
public class DecisionEngine {

    private MainCharacter player;
    private OutputManager output;
    private InputManager input;
    private Loader loader;
    private Saver saver;

    public DecisionEngine(MainCharacter player, OutputManager output, InputManager input,
                          Loader loader, Saver saver) {
        this.player = player;
        this.output= output;
        this.input = input;
        this.loader = loader;
        this.saver = saver;
    }

    public void run() {
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
                    case 1: //Load
                        break;
                    case 2: //Save
                        break;
                    case 3: //Save
                            return;
                        break;
                    case 4: return;
                        break;
                    default:
                }
            } else
                events[indexEvent - 1].run(new EventParameter(output, input, player));
        }
    }

}