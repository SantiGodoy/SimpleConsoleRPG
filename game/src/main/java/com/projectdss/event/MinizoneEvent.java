package com.projectdss.event;

import com.projectdss.Event;

/**
 * MinizoneEvent.java
 * 
 * @author Santiago Godoy Poce
 */
public abstract class MinizoneEvent extends Event {
    public MinizoneEvent() {}

    public MinizoneEvent(String description) {
        super(description);
    }

    public abstract void run(EventParameter eventParameter);
}