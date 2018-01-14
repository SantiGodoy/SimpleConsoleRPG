package com.projectdss;

import com.projectdss.Rarity;
import com.projectdss.CharacterStats;

/**
 * @author JoseCorrero
 * 
 * Class Item.
 */
public abstract class Item implements Comparable<Item> {

    protected final int id;
    protected final String name;
    protected final Rarity rarity;
    protected final String description;

    public Item(int id, String name, Rarity rarity, String description) {
       this.id = id;
       this.name = name;
       this.rarity = rarity;
       this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Item compareItem) {
        return id - compareItem.getId();
    }

    public abstract void use(CharacterStats characterStats);

}
