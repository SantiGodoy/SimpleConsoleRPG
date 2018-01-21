package com.projectdss.event.minizoneevent;

import com.projectdss.event.EventParameter;
import com.projectdss.event.MinizoneEvent;
import com.projectdss.map.Minizone;

/**
 * TravelMinizone.java
 * 
 * @author Santiago Godoy Poce
 */
public class TravelMinizoneEvent extends MinizoneEvent {

    public TravelMinizoneEvent() {}

    public TravelMinizoneEvent(String description) {
        super(description);
    }

    public void run(EventParameter eventParameter) {
        int options = eventParameter.getOutput().showAdjacentMinizones(eventParameter.getPlayer().getMinizone());
        int indexMinizone = eventParameter.getInput(0, options);
        if(indexMinizone != 0)
            eventParameter.getPlayer().setMinizone(eventParameter.getPlayer().
                getZone().getAdjacentMinizone(indexMinizone, eventParameter.getPlayer().getMinizone()));
    }
}