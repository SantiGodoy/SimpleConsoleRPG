package com.projectdss;

import com.projectdss.ElementType;
import com.projectdss.CharacterStats;

/**
 * @author JoseCorrero
 * 
 * Class Ability.
 */
public abstract class Ability implements Comparable<Ability> {

    protected String name;
    protected String description;
    protected int necessaryMana;
    protected ElementType type;

    public Ability(){}

    public Ability(String name, String description, int necessaryMana, ElementType type) {
        this.name = name;
        this.description = description;
        this.necessaryMana = necessaryMana;
        this.type = type;
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

    public int getNecessaryMana() {
        return necessaryMana;
    }

    public void setNecessaryMana(int necessaryMana) {
        this.necessaryMana = necessaryMana;
    }

    public ElementType getType() {
        return type;
    }

    public void setType(ElementType type) {
        this.type = type;
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