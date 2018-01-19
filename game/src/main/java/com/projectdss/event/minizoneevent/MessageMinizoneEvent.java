package com.projectdss.event.minizoneevent;

import com.projectdss.event.EventParameter;
import com.projectdss.event.MinizoneEvent;

/**
 * MessageMinizoneEvent.java
 * 
 * @author Santiago Godoy Poce
 */
public class MessageMinizoneEvent extends MinizoneEvent {

    public MessageMinizoneEvent(){}

    public MessageMinizoneEvent(String description) {
        super(description);
    }

    public void run(EventParameter eventParameter) {
        eventParameter.getOutput().showJoke(description);
    }
}