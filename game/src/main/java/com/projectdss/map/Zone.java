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
    private boolean[][] adjacencyMatrixMinizone;
    private final Set<Minizone> minizones;
    private final Set<Event> events;
    
    public Zone(int id, String name, String description,
        boolean[][] adjacencyMatrixMinizone, Set<Minizone> minizones, Set<Event> events) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.adjacencyMatrixMinizone = adjacencyMatrixMinizone;
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

    public void invertAdjacencyMinizone(int i, int j) {
        adjacencyMatrixMinizone[i][j] = !adjacencyMatrixMinizone[i][j];
    }

    public int length() {
        return minizones.size();
    }

    public Set<Minizone> getMinizones() {
        return minizones;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public Event getEvent(int index) {
        return (Event)events.toArray()[index];
    }
}