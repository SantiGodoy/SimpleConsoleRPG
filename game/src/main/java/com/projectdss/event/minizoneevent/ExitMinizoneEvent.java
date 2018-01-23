package com.projectdss.event.minizoneevent;

import com.projectdss.character.MainCharacter;
import com.projectdss.event.EventParameter;
import com.projectdss.event.MinizoneEvent;

/**
 * ExitMinizone.java
 * 
 * @author Santiago Godoy Poce
 */
public class ExitMinizoneEvent extends MinizoneEvent {

    public ExitMinizoneEvent(){}

    public ExitMinizoneEvent(String description) {
        super(description);
    }

    public void run(EventParameter eventParameter) {
        eventParameter.getPlayer().setIsIn(false);
    }
}