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
    private int id;
    private String name;
    private String description;
    private boolean[][] adjacencyMatrixMinizone;
    private World world;
    private Minizone[] minizones;
    private Event[] events;

    public Zone(){}

    public Zone(int id, String name, String description, World world,
         Minizone[] minizones, Event[] events) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.world = world;
        this.minizones = minizones;
        this.events = events;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int length() {
        return minizones.length;
    }

    public World getWorld() {
        return this.world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Minizone[] getMinizones() {
        return minizones;
    }

    public void setMinizones(Minizone[] minizones) {
        this.minizones = minizones;
    }

    public Event[] getEvents() {
        return events;
    }

    public void setEvents(Event[] events) {
        this.events = events;
    }

    public boolean[][] getAdjacencyMatrixMinizone() {
        return adjacencyMatrixMinizone;
    }

    public void setAdjacencyMatrixMinizone(boolean[][] adjacencyMatrixMinizone) {
        this.adjacencyMatrixMinizone = adjacencyMatrixMinizone;
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
        return minizone;
    }

    public Set<Zone> getAdjacentZones() {
        Set<Zone> adjacentZones = new HashSet<Zone>();
        for (int j = 0; j < world.getAdjacencyMatrixZone().length; ++j)
            if(world.getAdjacencyMatrixZone()[id][j] == true)
                adjacentZones.add(world.getZones()[j]);
        return adjacentZones;
    }
}