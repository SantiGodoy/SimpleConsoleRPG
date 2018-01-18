package com.projectdss;

import com.projectdss.ElementType;
import com.projectdss.CharacterStats;

/**
 * @author JoseCorrero
 * 
 * Class Ability.
 */
public abstract class Ability implements Comparable<Ability> {

    protected final String name;
    protected final String description;
    protected final int necessaryMana;
    protected final ElementType type;

    public Ability(String name, String description, int necessaryMana, ElementType type) {
        this.name = name;
        this.description = description;
        this.necessaryMana = necessaryMana;
        this.type = type;
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

    public ElementType getType() {
        return type;
    }

    @Override
    public int compareTo(Ability compareAbility) {
        int compareTypes = this.type.compareTo(compareAbility.getType());

        if(compareTypes == 0)
            return this.getName().compareTo(compareAbility.getName());
        else
            return compareTypes;
    }

    public abstract int use(CharacterStats player1, CharacterStats player2);

}