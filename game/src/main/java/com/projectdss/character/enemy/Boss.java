
import java.lang.annotation.ElementType;
import java.util.*;

/**
 * 
 */
public class Boss extends Enemy {

 

    private State state;

    public Boss() {
    }

    public Boss(int id, String name, int level, int health, int mana, int strength, int defense, int agility, ElementType type, Set<Ability> abilities, int xpDrop, String message, Map<Item, Integer> itemDrop) {
    super(id, name, level, health, mana, strength, defense, agility, type, abilities,xpDrop, message, itemDrop);
    }
 
 
    public void request() {
        // TODO implement here
    }

    public void calculateState() {
        // TODO implement here
    }

  
    public void setState(State state) {
        // TODO implement here
    }

   
    public State getState() {
        // TODO implement here
        return null;
    }


}