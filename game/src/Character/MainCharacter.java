
import java.util.*;

/**
 * 
 */
public class MainCharacter extends Character {

    private int maxAbilityPoints;
    private int currentAbilityPoints;
    private Inventory inventory;
    private Equipment equipment;
    private int experiencePoints;
    private int money;
    private String gender;

    public MainCharacter() {
    }

    public MainCharacter(int id, String name, int health, int abilityPoints, int strength, int agility, int defense,
            Set<Ability> abilities, String gender) {
        super(id, name, 1, health, strength, agility, defense, abilities);
        this.maxAbilityPoints = abilityPoints;
        this.currentAbilityPoints = abilityPoints;
        this.experiencePoints = 0;
        this.money = 0;
        this.gender = gender;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setExperienceP(int xp) {
        experiencePoints = experiencePoints + xp;

        if (experiencePoints >= (100 * level)){
          ++this.level;
          this.experiencePoints %= (100 * level);
        }      
    }

    public void setMaxAbilityP(int abilityPoints) {
        this.maxAbilityPoints = abilityPoints;
    }

    public void setCurrentAbilityP(int abilityPoints) {
        if(abilityPoints > maxAbilityPoints){
            this.currentAbilityPoints = maxAbilityPoints;
        } else {
            if(abilityPoints < 0){
                this.currentAbilityPoints = 0;
            } else {
                this.currentAbilityPoints = abilityPoints;
            }
        }
    }

    public void addAbility(Ability ability) {
        //Proximamente 
    }

    public int getMaxAbilityP() {
        return maxAbilityPoints;
    }

    public int getCurrentAbilityP() {
        return currentAbilityPoints;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public int getExperienceP() {
        return experiencePoints;
    }

    public int getMoney() {
        return money;
    }

}