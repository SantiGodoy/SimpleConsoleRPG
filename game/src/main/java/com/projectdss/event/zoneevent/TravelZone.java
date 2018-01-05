package com.projectdss.event.zoneevent;

import com.projectdss.event.EventParameter;
import com.projectdss.event.ZoneEvent;
import com.projectdss.map.Zone;
public class TravelZone extends ZoneEvent {
    public TravelZone(int id, String description) {
        super(id, description);
    }

    public void run(EventParameter eventParameter) {
        System.out.println("¿Hacia qué zona desea viajar?");
        eventParameter.getOutput().showAdjacentZones(eventParameter.getPlayer().getZone());
        int idZone = eventParameter.getInput();
        eventParameter.getPlayer().setZone(eventParameter.getPlayer().getWorld().
        getZone(idZone, eventParameter.getPlayer().getZone()));
    }
}