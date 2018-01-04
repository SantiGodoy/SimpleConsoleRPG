
package com.projectdss.character;

import java.lang.annotation.ElementType;

import com.projectdss.Character;
import com.projectdss.inventory.Inventory;

/**
 * 
 */
public class MainCharacter extends Character {

    private String gender;    
    private int xp;
    private Inventory inventory;

    public MainCharacter() {
    }

    public MainCharacter(int id, String name, int health, int mana, int strength, int defense, int agility, ElementType type, Set<Ability> abilities, String gender) {
        super(id, name, 1, health, mana, strength, defense, agility, BASIC, abilities);
        this.xp = 0;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setXP(int xp) {
        while (xp >= (100 * level)){
          ++this.level;
          xp -= (100 * level);
        }      
    }

    public int getXP() {
        return experiencePoints;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public boolean hasWeapon() {
        return inventory.hasWeaponEquipped();
    }

    public boolean hasArmor(){
        return inventory.hasArmorEquipped();
    }

    public WeaponEquipableCombatItem getWeapon(){
        return inventory.getEquippedWeapon();
    }

    public ArmorEquipableCombatItem getArmor(){
        return inventory.getEquippedArmor();
    }
}