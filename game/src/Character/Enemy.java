
import java.util.*;

/**
 * 
 */
public abstract class Enemy extends Character {

   

    protected int experiencePointsDrop;
    protected Item itemDrop;
    protected int probabilityDrop;
    protected String message;
    protected ElementType type;


    public Enemy() {
    }
    
    public Enemy(int id, String name, int level, int health, int strength, int agility, int defense, Set<Ability> abilities, int xpDrop, String message, Item itemDrop, int probabilityDrop, ElementType type) {
        super(id, name, level, health, strength, agility, defense, abilities);   
        this.experiencePointsDrop = xpDrop;
        this.itemDrop = itemDrop;
        this.probabilityDrop = probabilityDrop;
        this.message = message;
        this.type = type;
    }


    public int getXPDrop() {
        return experiencePointsDrop;
    }

 
    public String getMessage() {
        return message;
    }

 
    public int getItemDrop() {
        return itemDrop;
    }


}