package com.projectdss.event;

import com.projectdss.Event;

/**
 * Represents the different events in a zone.
 * 
 * @author Santiago Godoy Poce
 */
public abstract class ZoneEvent extends Event {
    public ZoneEvent(int id, String description) {
        super(id, description);
    }

    public abstract void run(EventParameter eventParameter);
}