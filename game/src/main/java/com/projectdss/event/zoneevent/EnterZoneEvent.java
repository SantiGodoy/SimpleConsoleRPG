package com.projectdss.event.zoneevent;

import com.projectdss.character.MainCharacter;
import com.projectdss.event.EventParameter;
import com.projectdss.event.ZoneEvent;

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
        eventParameter.getPlayer().setIsIn(true);
    }
}