package com.projectdss.map;

import java.util.Set;
import com.projectdss.Event;
import com.projectdss.character.Enemy;

/**
 * Represents each minizone inside a concrete zone
 * @author Santiago Godoy Poce
 */
public class Minizone {
    private final int id;
    private final Zone zone;
    private final String name;
    private final String description;
    private Set<Event> events;
    private final int enemyProbability;
    private Enemy enemy;

    public Minizone(int id, Zone zone, String name, String description, Set<Event> events,
         int enemyProbability, Enemy enemy) {
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

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public Event getEvent(int index) {
        return (Event)events.toArray()[index];
    }

    public int getEnemyProb() {
        return enemyProbability;
    }

    public Enemy getEnemy() {
        return enemy;
    }
}