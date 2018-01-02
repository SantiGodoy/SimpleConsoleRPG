package com.projectdss.event;

import com.projectdss.Event;

/**
 * Represents the different events in a minizone
 * 
 * @author Santiago Godoy Poce
 */
public abstract class MinizoneEvent extends Event {
    public MinizoneEvent(int id, String message) {
        super(id, message);
    }
}