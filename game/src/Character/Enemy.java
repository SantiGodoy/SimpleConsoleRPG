
import java.util.*;

/**
 * 
 */
public abstract class Enemy extends Character {

    /**
     * Default constructor
     */
    public Enemy() {
    }

    /**
     * 
     */
    protected int experiencePointsDrop;

    /**
     * 
     */
    protected int moneyDrop;

    /**
     * 
     */
    protected String message;

    /**
     * 
     */
    protected ElementType type;


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
    public void Enemy(int id, String name, int level, int health, int strength, int agility, int defense, Set<Ability> abilities, int xpDrop, String message, int itemDrop) {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getXPDrop() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public String getMessage() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public int getMoneyDrop() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int getItemDrop() {
        // TODO implement here
        return 0;
    }

}