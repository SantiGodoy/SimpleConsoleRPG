package com.projectdss.event.minizoneevent;

import com.projectdss.event.EventParameter;
import com.projectdss.event.MinizoneEvent;
import com.projectdss.map.Minizone;

/**
 * 
 */
public class TravelMinizone extends MinizoneEvent {
    public TravelMinizone(int id, String description) {
        super(id, description);
    }

    public void run(EventParameter eventParameter) {
        System.out.println("¿Hacia dónde desea viajar?");
        eventParameter.getOutput().showAdjacentMinizones(eventParameter.getPlayer().getMinizone());
        int idMinizone = eventParameter.getInput();
        eventParameter.getPlayer().setMinizone((Minizone)eventParameter.getPlayer().getZone().getMinizones().toArray()[idMinizone]);
    }
}