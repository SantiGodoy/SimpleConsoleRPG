package com.projectdss.map;

import java.util.Set;
import com.projectdss.Event;

/**
 * Represents each zone of the world
 * @author Santiago Godoy Poce
 */
public class Zone {
    private final int id;
    private final String name;
    private final String description;
    private final Minizone[] minizones;
    private final Set<Event> events;
    
    public Zone(int id, String name, String description, Minizone[] minizones, Set<Event> events) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.minizones = minizones;
        this.events = events;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int length() {
        return minizones.length;
    }

    public Minizone[] getMinizones() {
        return minizones;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public Event getEvent(int index) {
        return (Event)events.toArray()[index];
    }
}