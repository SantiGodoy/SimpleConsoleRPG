
import java.util.*;

/**
 * 
 */
public class Boss extends Enemy {

    /**
     * Default constructor
     */
    public Boss() {
    }

    /**
     * 
     */
    private State state;

    /**
     * 
     */
    private Item itemDrop;



    /**
     * @param id 
     * @param name 
     * @param level 
     * @param health 
     * @param strength 
     * @param agility 
     * @param defense 
     * @param abilities 
     * @param xpDrop 
     * @param message 
     * @param itemDrop
     */
    public void Boss(int id, String name, int level, int health, int strength, int agility, int defense, Set<Ability> abilities, int xpDrop, String message, int itemDrop) {
        // TODO implement here
    }

    /**
     * 
     */
    public void request() {
        // TODO implement here
    }

    /**
     * 
     */
    public void calculateState() {
        // TODO implement here
    }

    /**
     * @param state
     */
    public void setState(State state) {
        // TODO implement here
    }

    /**
     * @return
     */
    public State getState() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Item getItemDrop() {
        // TODO implement here
        return null;
    }

}