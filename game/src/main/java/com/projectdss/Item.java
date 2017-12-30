package com.proyectdss;

import java.util.*;
import com.proyectdss.Rarity;

/**
 * @author JoseCorrero
 * 
 * Class Item.
 */
public abstract class Item {

    protected int id;
    protected String name;
    protected Rarity rarity;
    protected String description;

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
