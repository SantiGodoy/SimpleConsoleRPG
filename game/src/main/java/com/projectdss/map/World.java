package com.projectdss.map;

import java.util.Set;

/**
 * World.java
 * 
 * @author Santiago Godoy Poce
 */
public class World {
    private final String name;
    private boolean[][] adjacencyMatrixZone;
    private final Zone[] zones;

    public World(String name, Zone[] zones) {
        this.name   = name;
        this.zones  = zones;
    }

    public String getName() {   
        return name;
    }

    public int length() {
        return zones.length;
    }

    public Zone[] getZones() {
        return zones;
    }
    
    public boolean[][] getAdjacencyMatrixZone() {
        return adjacencyMatrixZone;
    }

    public void setAdjacencyMatrixZone(boolean[][] adjacencyMatrixZone) {
        this.adjacencyMatrixZone = adjacencyMatrixZone;
    }

    public Zone getAdjacentZone(int index, Zone zone) {
        int counter = 0;
        for(int j = 0; j < adjacencyMatrixZone.length; ++j) {
            if(adjacencyMatrixZone[zone.getId()][j] == true) {
                if(counter == index)
                    return zones[j];
                ++counter;
            }
        }
        return zone;
    }
}