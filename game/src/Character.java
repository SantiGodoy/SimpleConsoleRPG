
import java.util.*;

/**
 * 
 */
public abstract class Character {

    /**
     * Default constructor
     */
    public Character() {
    }

    /**
     * 
     */
    protected int id;

    /**
     * 
     */
    protected String name;

    /**
     * 
     */
    protected int level;

    /**
     * 
     */
    protected int health;

    /**
     * 
     */
    protected int strength;

    /**
     * 
     */
    protected int agility;

    /**
     * 
     */
    protected int defense;

    /**
     * 
     */
    protected Set<Ability> abilities;





    /**
     * @param id 
     * @param name 
     * @param level 
     * @param health 
     * @param strength 
     * @param agility 
     * @param defense 
     * @param abilities
     */
    public void Character(int id, String name, int level, int health, int strength, int agility, int defense, Set<Ability> abilities) {
        // TODO implement here
    }

    /**
     * @param health
     */
    public void setHealth(int health) {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getId() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public String getName() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public int getLevel() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int getHealth() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int getStrength() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int getAgility() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int getDefense() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public Set<Ability> getAbilities() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Boolean isAlive() {
        // TODO implement here
        return null;
    }

}