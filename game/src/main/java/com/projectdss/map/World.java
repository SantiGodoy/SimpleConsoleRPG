package com.projectdss.map;

import java.util.Set;

/**
 * Represents the global map of the game.
 * @author Santiago Godoy Poce
 */
public class World {
    private final String name;
    private boolean[][] adjacencyMatrixZone;
    private final Set<Zone> zones;

    public World(String name, Set<Zone> zones, boolean[][] adjacencyMatrixZone) {
        this.name   = name;
        this.adjacencyMatrixZone = adjacencyMatrixZone;
        this.zones  = zones;
    }

    public String getName() {   
        return name;
    }

    public int length() {
        return zones.size();
    }

    public Set<Zone> getZones() {
        return zones;
    }
    
    public boolean[][] getAdjacencyMatrixZone() {
        return adjacencyMatrixZone;
    }

    public void invertAdjacencyZone(int i, int j) {
        adjacencyMatrixZone[i][j] = !adjacencyMatrixZone[i][j];
    }

    public Zone getZone(int index) {
        int counter = 0;
        for(int j = 0; j < adjacencyMatrixZone.length; ++j) {
            if(adjacencyMatrixZone[id][j] == true) {
                if(counter == index)
                    return (Zone)zones.toArray()[j];
                ++counter;
            }
        }
    }
}