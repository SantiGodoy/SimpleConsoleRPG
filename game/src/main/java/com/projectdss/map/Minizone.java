package com.projectdss.map;

import java.util.HashSet;
import java.util.Set;
import com.projectdss.Event;
import com.projectdss.character.EnemyCharacter;

/**
 * Minizone.java
 * 
 * @author Santiago Godoy Poce
 */
public class Minizone {
    private int id;
    private Zone zone;
    private String name;
    private String description;
    private Event[] events;
    private EnemyCharacter enemy;

    public Minizone(){}

    public Minizone(int id, Zone zone, String name, String description,
         Event[] events, EnemyCharacter enemy) {
            this.id = id;
            this.zone = zone;
            this.name = name;
            this.description = description;
            this.events = events;
            this.enemy = enemy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Zone getZone() {
        return this.zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
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

    public void setEvents(Event[] events) {
        this.events = events;
    }

    public Event[] getEvents() {
        return events;
    }

    public EnemyCharacter getEnemy() {
        return enemy;
    }

    public void setEnemy(EnemyCharacter enemy) {
        this.enemy = enemy;
    }

    public Set<Minizone> getAdjacentMinizones() {
        Set<Minizone> adjacentMinizones = new HashSet<Minizone>();
        for (int j = 0; j < zone.getAdjacencyMatrixMinizone().length; ++j)
            if(zone.getAdjacencyMatrixMinizone()[id][j] == true)
                adjacentMinizones.add(zone.getMinizones()[j]);
        return adjacentMinizones;
    }
}