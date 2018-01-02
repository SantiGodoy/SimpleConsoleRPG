
package com.projectdss.event.minizoneevent;

import com.projectdss.event.MinizoneEvent;
import com.projectdss.event.ZoneEvent;
import java.util.Set;

/**
 * 
 */
public class ExitMinizone extends MinizoneEvent {
    public ExitMinizone(int id, String description, Set<ZoneEvent> zoneEvents) {
        super(id, description);
        this.zoneEvents = zoneEvents;
    }

    public void run(EventParameter ep) {
        ep.getOutput().showZoneEvents();
    }
}