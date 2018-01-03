
package com.projectdss;

/**
 * Represents the different events that the main character 
 * can encounter during the game
 * 
 * @author Santiago Godoy Poce
 */
public abstract class Event {
    protected int id;
    protected String description;

    public Event(int id, String description) {
        this.id = id;
        this.description = description;    
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {    
        return description;
    }

    public abstract void run();
}