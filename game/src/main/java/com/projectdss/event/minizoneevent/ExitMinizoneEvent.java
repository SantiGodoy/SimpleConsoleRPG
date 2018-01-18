package com.projectdss.event.minizoneevent;

import com.projectdss.event.EventParameter;
import com.projectdss.event.MinizoneEvent;
import com.projectdss.event.ZoneEvent;
import java.util.Set;

/**
 * ExitMinizone.java
 * 
 * @author Santiago Godoy Poce
 */
public class ExitMinizoneEvent extends MinizoneEvent {
    public ExitMinizoneEvent(String description) {
        super(description);
    }

    public void run(EventParameter eventParameter) {
        eventParameter.getOutput().showZoneEvents();
        eventParameter.getInput(1, 2);
    }
}