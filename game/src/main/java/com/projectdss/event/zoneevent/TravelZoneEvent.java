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
    public TravelZoneEvent(int id, String description) {
        super(id, description);
    }

    public void run(EventParameter eventParameter) {
        System.out.println("¿Hacia qué zona desea viajar?");
        eventParameter.getOutput().showAdjacentZones(eventParameter.getPlayer().getZone());
        int idZone = eventParameter.getInput(1, 5);
        eventParameter.getPlayer().setZone(eventParameter.getPlayer().getWorld().
        getAdjacentZone(idZone, eventParameter.getPlayer().getZone()));
    }
}