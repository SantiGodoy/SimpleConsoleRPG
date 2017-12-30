package com.projectdss.map;

/**
 * Represents the global map of the game.
 * @author Santiago Godoy Poce
 */
public class World {
    private final String name;
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
}