package com.projectdss.event.minizoneevent;

import com.projectdss.character.MainCharacter;
import com.projectdss.event.EventParameter;
import com.projectdss.event.MinizoneEvent;
import com.projectdss.map.Minizone;
import com.projectdss.map.World;
import com.projectdss.map.Zone;

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
        MainCharacter player = eventParameter.getPlayer();
        World world = eventParameter.getWorld();
        Zone zone = world.getZones()[player.getIdZone()];
        Minizone minizone = zone.getMinizones()[player.getIdMinizone()];

        int options = eventParameter.getOutput().showAdjacentMinizones(minizone),
            indexMinizone = eventParameter.getInput(0, options);

        if(indexMinizone != 0)
            player.setIdMinizone(zone.getAdjacentMinizone(indexMinizone, minizone).getId());
    }
}