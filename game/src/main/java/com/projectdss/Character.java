package com.projectdss;

import java.util.Set;
import com.projectdss.Ability;
import com.projectdss.ElementType;
import com.projectdss.item.combatitem.equipablecombatitem.ArmorEquipableCombatItem;
import com.projectdss.item.combatitem.equipablecombatitem.WeaponEquipableCombatItem;

/**
 * 
 */
public abstract class Character {

    protected int id;
    protected String name;
    protected int level;
    protected int maxHealth;
    protected int currentHealth;
    protected int maxMana;
    protected int currentMana;  
    protected int strength;
    protected int magicalPower;
    protected int defense;  
    protected int agility;
    protected ElementType type;
    protected Set<Ability> abilities;

    public Character() {
    }

    public Character(int id, String name, int level, int health, int mana, int strength, int magicalPower, int defense, int agility, ElementType type, Set<Ability> abilities) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.maxHealth = health;
        this.currentHealth = health;
        this.maxMana = mana;
        this.currentMana = mana;
        this.strength = strength;
        this.magicalPower = magicalPower;
        this.defense = defense;
        this.agility = agility;
        this.type = type;
        this.abilities = abilities;
    }
  
    public void setMaxHealth(int health) {
        this.maxHealth = health;
    }

    public void setCurrentHealth(int health) {
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
    
    public void setMaxMana(int mana) {
        this.maxMana = mana;
    }
    
    public void setCurrentMana(int mana) {
        if(mana > maxMana){
            this.currentMana = maxMana;
        } else {         
             this.currentMana = mana;           
        }
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setMagicalPower(int magicalPower) {
        this.magicalPower = magicalPower;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void addAbility(Ability ability) {
        abilities.add(ability);
    }

    public void removeAbility(Ability ability) {
        abilities.remove(ability);
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

  
    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public int getCurrentMana() {
        return currentMana;
    }
    
    public int getStrength() {
        return strength;
    }

    public int getMagicalPower() {
        return magicalPower;
    }

    public int getDefense() {
        return defense;
    }
  
    public int getAgility() {
        return agility;
    }
    
    public ElementType getType(){
        return type;
    }

    public Set<Ability> getAbilities() {
        return abilities;
    }

    public boolean isAlive() {
        return currentHealth != 0;
    }

    public abstract boolean hasWeapon();

    public abstract boolean hasArmor();

    public abstract WeaponEquipableCombatItem getWeapon();

    public abstract ArmorEquipableCombatItem getArmor();

}