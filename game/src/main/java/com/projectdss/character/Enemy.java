
package com.projectdss.character;
import javax.lang.model.element.TypeElement;

import com.projectdss.Character;

/**
 * 
 */
public abstract class Enemy extends Character {

   

    protected int xpDrop;
    protected String message;
    protected Map<item, Integer> itemDrop;

    public Enemy() {
    }
    
    public Enemy(int id, String name, int level, int health, int strength, int defense, int agility, TypeElement type, Set<Ability> abilities, int xpDrop, String message, Map<item, Integer> itemDrop) {
        super(id, name, level, health, strength, defense, agility, type, abilities);   
        this.xpDrop = xpDrop;
        this.itemDrop = itemDrop;
        this.message = message;
    }


    public int getXPDrop() {
        return xpDrop;
    }

 
    public String getMessage() {
        return message;
    }

 
    public Map<item, Integer> getItemDrop() {
        return itemDrop;
    }


}