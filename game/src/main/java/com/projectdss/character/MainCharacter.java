
package com.projectdss.character;

import com.projectdss.Character;

/**
 * 
 */
public class MainCharacter extends Character {

    private String gender;    
    private int experiencePoints;
    private Inventory inventory;

    public MainCharacter() {
    }

    public MainCharacter(int id, String name, int health, int mana, int strength, int defense, int agility,
            Set<Ability> abilities, String gender) {
        super(id, name, 1, health, mana, strength, defense, agility, abilities);
        this.experiencePoints = 0;
        this.gender = gender;
    }

    public void incrementLevel(){

    }

    public void setXP(int xp) {
        experiencePoints = experiencePoints + xp;

        if (experiencePoints >= (100 * level)){
          ++this.level;
          this.experiencePoints %= (100 * level);
        }      
    }

    public int getXP() {
        return experiencePoints;
    }

    public void getInventory(){
        return inventory;
    }

    public boolean hasWeapon(){

    }

    public void hasArmor(){

    }

    public WeaponEquipableCombatItem getWeapon(){

    }

    public ArmorEquipableCombatItem getArmor(){

    }

}