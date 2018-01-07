package com.projectdss.map;

import java.util.HashSet;
import java.util.Set;
import com.projectdss.Event;

/**
 * Zone.java
 * 
 * @author Santiago Godoy Poce
 */
public class Zone {
    private final int id;
    private final String name;
    private final String description;
    private boolean[][] adjacencyMatrixMinizone;
    private final World world;
    private final Minizone[] minizones;
    private final Event[] events;
    
    public Zone(int id, String name, String description,
        boolean[][] adjacencyMatrixMinizone, Minizone[] minizones, Event[] events) {
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

    public int length() {
        return minizones.length;
    }

    public Minizone[] getMinizones() {
        return minizones;
    }

    public Event[] getEvents() {
        return events;
    }

    public boolean[][] getAdjacencyMatrixMinizone() {
        return adjacencyMatrixMinizone;
    }

    public Minizone getAdjacentMinizone(int index, Minizone minizone) {
        int counter = 0;
        for(int j = 0; j < adjacencyMatrixMinizone.length; ++j) {
            if(adjacencyMatrixMinizone[minizone.getId()][j] == true) {
                if(counter == index)
                    return minizones[j];
                ++counter;
            }
        }
    }

    public Set<Zone> getAdjacentZones() {
        Set<Zone> adjacentZones = new HashSet<Zone>();
        for (int j = 0; j < world.getAdjacencyMatrixZone().length; ++j)
            if(world.getAdjacencyMatrixZone()[id][j] == true)
                adjacentZones.add(world.getZones()[j]);
        return adjacentZones;
    }
}