package com.projectdss;

import com.projectdss.ElementType;
import com.projectdss.CharacterStats;

/**
 * @author JoseCorrero
 * 
 * Class Ability.
 */
public abstract class Ability implements Comparable<Ability> {

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

    @Override
    public int compareTo(Ability compareAbility) {
        if(this.getType() == null)
            if(compareAbility.getType() == null)
                return this.getName().compareTo(compareAbility.getName());
            else
                return 1;
        else
            if(compareAbility.getType() == null)
                return -1;
            else
                if(this.getType() == compareAbility.getType())
                    return this.getName().compareTo(compareAbility.getName());
                else
                    return this.getType().compareTo(compareAbility.getType());
    }

    public abstract ElementType getType();

    public abstract int use(CharacterStats player1, CharacterStats player2);

}