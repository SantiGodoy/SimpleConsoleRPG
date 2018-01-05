package com.projectdss.event.minizoneevent;

import com.projectdss.event.EventParameter;
import com.projectdss.event.MinizoneEvent;
import com.projectdss.event.ZoneEvent;
import java.util.Set;

/**
 * 
 */
public class ExitMinizone extends MinizoneEvent {
    public ExitMinizone(int id, String description) {
        super(id, description);
    }

    public void run(EventParameter eventParameter) {
        eventParameter.getOutput().showZoneEvents();
        eventParameter.getInput();
    }
}