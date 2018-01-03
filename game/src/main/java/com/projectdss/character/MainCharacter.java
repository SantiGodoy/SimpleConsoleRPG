
package com.projectdss.character;

import com.projectdss.Character;

/**
 * 
 */
public class MainCharacter extends Character {

    private int xp;
    private Inventory inventory;
    private String gender;

    public MainCharacter() {
    }

    public MainCharacter(int id, String name, int health, int abilityPoints, int strength, int agility, int defense,
            Set<Ability> abilities, String gender) {
        super(id, name, 1, health, strength, agility, defense, abilities);
        this.xp = xp;
        this.gender = gender;
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