
import java.util.*;

/**
 * 
 */
public class MinionEnemyCharacter extends Enemy {

  
    public MinionEnemyCharacter() {
    }

  
    public MinionEnemyCharacter(int id, String name, int level, int health, int mana, int strength,  int defense, int agility, ElementType type, Set<Ability> abilities, int xpDrop, String message, Map<item, Integer> itemsDrop) {
        super(id, name, level, health, mana, strength, defense, agility, type, abilities, xpDrop, message, itemsDrop);
    }

}