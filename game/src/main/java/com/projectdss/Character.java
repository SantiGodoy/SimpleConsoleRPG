
import java.util.*;

/**
 * 
 */
public abstract class Character {

 
    protected int id;
    protected String name;
    protected int level;
    protected int maxHealth;
    protected int currentHealth;
    protected int strength;
    protected int agility;
    protected int defense;
    protected Set<Ability> abilities;

    public Character() {
    }

    public Character(int id, String name, int level, int health, int strength, int agility, int defense, Set<Ability> abilities) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.maxHealth = health;
        this.currentHealth = health;
        this.strength = strength;
        this.agility = agility;
        this.defense = defense;
        this.abilities = abilities;
    }

  
    public void setmaxHealth(int health) {
        this.maxHealth = health;
    }

    public void setcurrentHealth(int health) {
        if(health > maxHealth){
            this.currentHealth = maxHealth;
        } else {
            if(health < 0){
                this.currentHealth = 0;
            } else {
                this.currentHealth = health;
            }
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

 
    public int getLevel() {
        return level;
    }

  
    public int getmaxHealth() {
        return maxHealth;
    }

    public int getcurrentHealth() {
        return currentHealth;
    }
    
    public int getStrength() {
        return strength;
    }

  
    public int getAgility() {
        return agility;
    }

  
    public int getDefense() {
        return defense;
    }

   
    public Set<Ability> getAbilities() {
        return abilities;
    }

  
    public Boolean isAlive() {
        return currentHealth != 0;
    }

}