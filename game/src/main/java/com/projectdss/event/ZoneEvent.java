package com.projectdss.event;

import com.projectdss.Event;

/**
 * ZoneEvent.java
 * 
 * @author Santiago Godoy Poce
 */
public abstract class ZoneEvent extends Event {
    public ZoneEvent() {}

    public ZoneEvent(String description) {
        super(description);
    }

    public abstract void run(EventParameter eventParameter);
}