package com.projectdss.event.zoneevent;

import com.projectdss.event.EventParameter;
import com.projectdss.event.ZoneEvent;
import com.projectdss.map.Zone;

/**
 * TravelZone.java
 * 
 * @author Santiago Godoy Poce
 */
public class TravelZoneEvent extends ZoneEvent {

    public TravelZoneEvent() {}

    public TravelZoneEvent(String description) {
        super(description);
    }

    public void run(EventParameter eventParameter) {
        System.out.println("¿Hacia qué zona desea viajar?");
        int options = eventParameter.getOutput().showAdjacentZones(eventParameter.getPlayer().getZone());
        int indexZone = eventParameter.getInput(0, options);
        if(indexZone != 0)
            eventParameter.getPlayer().setZone(eventParameter.getPlayer().getWorld().
                getAdjacentZone(indexZone, eventParameter.getPlayer().getZone()));
    }
}