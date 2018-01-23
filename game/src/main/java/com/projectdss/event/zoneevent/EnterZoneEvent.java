package com.projectdss.event.zoneevent;

import com.projectdss.character.MainCharacter;
import com.projectdss.event.EventParameter;
import com.projectdss.event.ZoneEvent;
import com.projectdss.map.Minizone;
import com.projectdss.map.World;
import com.projectdss.map.Zone;

/**
 * EnterZone.java
 * 
 * @author Santiago Godoy Poce
 */
public class EnterZoneEvent extends ZoneEvent {
    public EnterZoneEvent(){}

    public EnterZoneEvent(String description) {
        super(description);
    }

    @Override
    public void run(EventParameter eventParameter) {
        MainCharacter player = eventParameter.getPlayer();
        World world = eventParameter.getWorld();
        Zone zone = world.getZones()[player.getIdZone()];
        
        player.setIsIn(true);
        player.setIdMinizone(zone.getMinizones()[0].getId());
    }

}