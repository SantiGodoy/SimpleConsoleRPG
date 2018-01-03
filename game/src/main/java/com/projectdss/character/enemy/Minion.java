
import java.util.*;

/**
 * 
 */
public class Minion extends Enemy {

  
    public Minion() {
    }

  
    public Minion(int id, String name, int level, int health, int mana, int strength,  int defense, ElementType type, int agility, Set<Ability> abilities, int xpDrop, String message, Map<item, Integer> itemDrop) {
        super(id, name, level, health, mana, strength, defense, type, agility, abilities, xpDrop, message, itemDrop);
    }

}