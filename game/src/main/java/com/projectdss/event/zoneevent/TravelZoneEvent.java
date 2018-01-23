package com.projectdss.event.zoneevent;

import com.projectdss.character.MainCharacter;
import com.projectdss.event.EventParameter;
import com.projectdss.event.ZoneEvent;
import com.projectdss.map.World;
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
        MainCharacter player = eventParameter.getPlayer();
        World world = eventParameter.getWorld();
        Zone zone = world.getZones()[player.getIdZone()];

        int options = eventParameter.getOutput().showAdjacentZones(zone),
            indexZone = eventParameter.getInput(0, options);

        if(indexZone != 0)
            player.setIdZone(eventParameter.getWorld().getAdjacentZone(indexZone, zone).getId());
    }
}