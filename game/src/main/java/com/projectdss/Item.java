package com.projectdss;

import com.projectdss.Rarity;

/**
 * @author JoseCorrero
 * 
 * Class Item.
 */
public abstract class Item {

    protected final int id;
    protected final String name;
    protected final Rarity rarity;
    protected final String description;

    public Item() {}

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

}
