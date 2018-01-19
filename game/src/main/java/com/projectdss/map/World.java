package com.projectdss.map;

import java.util.Set;

/**
 * World.java
 * 
 * @author Santiago Godoy Poce
 */
public class World {
    private String name;
    private boolean[][] adjacencyMatrixZone;
    private Zone[] zones;

    public World() {}

    public World(String name, Zone[] zones) {
        this.name   = name;
        this.zones  = zones;
    }

    public String getName() {   
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int length() {
        return zones.length;
    }

    public Zone[] getZones() {
        return zones;
    }

    public void setZones(Zone[] zones) {
        this.zones = zones;
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