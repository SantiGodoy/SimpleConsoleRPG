package com.projectdss.event.minizoneevent;

import com.projectdss.event.EventParameter;
import com.projectdss.event.MinizoneEvent;
import com.projectdss.map.Minizone;

/**
 * TravelMinizone.java
 * 
 * @author Santiago Godoy Poce
 */
public class TravelMinizone extends MinizoneEvent {
    public TravelMinizone(int id, String description) {
        super(id, description);
    }

    public void run(EventParameter eventParameter) {
        System.out.println("¿Hacia dónde desea viajar?");
        eventParameter.getOutput().showAdjacentMinizones(eventParameter.getPlayer().getMinizone());
        int indexMinizone = eventParameter.getInput(1, 5);
        eventParameter.getPlayer().setMinizone(eventParameter.getPlayer().
        getZone().getAdjacentMinizone(indexMinizone, eventParameter.getPlayer().getMinizone()));
    }
}