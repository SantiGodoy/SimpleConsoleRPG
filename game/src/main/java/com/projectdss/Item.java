package com.projectdss;

import com.projectdss.Rarity;
import com.projectdss.CharacterStats;

/**
 * @author JoseCorrero
 * 
 * Class Item.
 */
public abstract class Item implements Comparable<Item> {

    protected String name;
    protected Rarity rarity;
    protected String description;

    public Item(){}

    public Item(String name, Rarity rarity, String description) {
       this.name = name;
       this.rarity = rarity;
       this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(Item compareItem) {
        int compareClasses = this.getClass().getName().compareTo(compareItem.getClass().getName());

        if(compareClasses != 0)
            return compareClasses;
        else
            return this.getRarity().compareTo(compareItem.getRarity());
    }

    public abstract void use(CharacterStats characterStats);

}
