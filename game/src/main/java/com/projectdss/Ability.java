package com.projectdss;

import com.projectdss.CharacterStats;

/**
 * @author JoseCorrero
 * 
 * Class Ability.
 */
public abstract class Ability {

    protected final int id;
    protected final String name;
    protected final String description;
    protected final int necessaryMana;

    public Ability(int id, String name, String description, int necessaryMana) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.necessaryMana = necessaryMana;
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

    public int getNecessaryMana() {
        return necessaryMana;
    }

    public abstract void use(CharacterStats player1, CharacterStats player2);

}