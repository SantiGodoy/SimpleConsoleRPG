
package com.projectdss.event.zoneevent;

import com.projectdss.event.EventParameter;
import com.projectdss.event.ZoneEvent;

/**
 * EnterZone.java
 * 
 * @author Santiago Godoy Poce
 */
public class EnterZone extends ZoneEvent {
    public EnterZone(int id, String description) {
        super(id, description);
    }

    public void run(EventParameter eventParameter) {
        eventParameter.getOutput().showMinizoneEvents(eventParameter.getPlayer().getMinizone());
        eventParameter.getInput(1, 4);
    }
}