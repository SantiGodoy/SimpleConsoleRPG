package com.projectdss.event.minizoneevent;

import com.projectdss.event.EventParameter;
import com.projectdss.event.MinizoneEvent;

/**
 * MessageMinizoneEvent.java
 * 
 * @author Santiago Godoy Poce
 */
public class MessageMinizoneEvent extends MinizoneEvent {

    private String message;

    public MessageMinizoneEvent() {}

    public MessageMinizoneEvent(String description, String message) {
        super(description);
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void run(EventParameter eventParameter) {
        eventParameter.getOutput().showMessage(message);
    }
}