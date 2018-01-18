
package com.projectdss;

import com.projectdss.event.EventParameter;


/**
 * Represents the different events that the main character 
 * can encounter during the game
 * 
 * @author Santiago Godoy Poce
 */
public abstract class Event {
    protected String description;

    public Event(String description) {
        this.description = description;    
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {    
        return description;
    }

    public abstract void run(EventParameter eventParameter);
}