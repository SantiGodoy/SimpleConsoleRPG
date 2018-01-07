package com.projectdss.event;

import com.projectdss.Event;

/**
 * MinizoneEvent.java
 * 
 * @author Santiago Godoy Poce
 */
public abstract class MinizoneEvent extends Event {
    public MinizoneEvent(int id, String description) {
        super(id, description);
    }

    public void run(EventParameter eventParameter) {

    }
}