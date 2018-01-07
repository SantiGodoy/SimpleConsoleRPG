package com.projectdss.event.minizoneevent;

import com.projectdss.event.EventParameter;
import com.projectdss.event.MinizoneEvent;

/**
 * Joke.java
 * 
 * @author Santiago Godoy Poce
 */
public class JokeMinizoneEvent extends MinizoneEvent {
    public JokeMinizoneEvent(int id, String description) {
        super(id, description);
    }

    public void run(EventParameter eventParameter) {
        eventParameter.getOutput().showJoke(description);
    }
}