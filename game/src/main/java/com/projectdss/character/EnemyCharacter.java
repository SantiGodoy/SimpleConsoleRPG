
package com.projectdss.character;
import com.projectdss.Character;

/**
 * 
 */
public abstract class EnemyCharacter extends Character {

   

    protected int xpDrop;
    protected String message;
    protected Map<item, Integer> itemsDrop;

    public EnemyCharacter() {
    }
    
    public EnemyCharacter(int id, String name, int level, int health, int strength, int defense, int agility, ElementType type, Set<Ability> abilities, int xpDrop, String message, Map<item, Integer> itemsDrop) {
        super(id, name, level, health, strength, defense, agility, type, abilities);   
        this.xpDrop = xpDrop;
        this.itemsrop = itemsDrop;
        this.message = message;
    }


    public int getXPDrop() {
        return xpDrop;
    }

 
    public String getMessage() {
        return message;
    }

 
    public Map<item, Integer> getItemsDrop() {
        return itemsDrop;
    }


}