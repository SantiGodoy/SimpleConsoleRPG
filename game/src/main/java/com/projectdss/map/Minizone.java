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
    private final int id;
    private final Zone zone;
    private final String name;
    private final String description;
    private Event[] events;
    private final int enemyProbability;
    private EnemyCharacter enemy;

    public Minizone(int id, Zone zone, String name, String description, Event[] events,
         int enemyProbability, EnemyCharacter enemy) {
            this.id = id;
            this.zone = zone;
            this.name = name;
            this.description = description;
            this.events = events;
            this.enemyProbability = enemyProbability;
            this.enemy = enemy;
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

    public void setEvents(Event[] events) {
        this.events = events;
    }

    public Event[] getEvents() {
        return events;
    }

    public int getEnemyProb() {
        return enemyProbability;
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