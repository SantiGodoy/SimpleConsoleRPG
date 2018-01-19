package com.projectdss;

import com.projectdss.ElementType;

public class CharacterStats {

    private int maxHealth;
    private int currentHealth;
    private int maxMana;
    private int currentMana;  
    private int strength;
    private int magicalPower;
    private int resistance;  
    private int agility;
    private ElementType offensiveType;
    private ElementType defensiveType;
    private int baseDamage;
    private int trueDamage;
    private int lifesteal;
    private int baseDefense;
    private int reflect;

    public CharacterStats() {}

    public CharacterStats(int health, int mana, int strength, int magicalPower, 
                          int resistance, int agility, ElementType type) {
        this.maxHealth = health;
        this.currentHealth = health;
        this.maxMana = mana;
        this.currentMana = mana;
        this.strength = strength;
        this.magicalPower = magicalPower;
        this.resistance = resistance;
        this.agility = agility;
        this.offensiveType = type;
        this.defensiveType = type;
        this.baseDamage = strength;
        this.trueDamage = 0;
        this.lifesteal = 0;
        this.baseDefense = resistance;
        this.reflect = 0;
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

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setOffensiveType(ElementType type) {
        this.offensiveType = type;
    }

    public void setDefensiveType(ElementType type) {
        this.defensiveType = type;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public void setTrueDamage(int trueDamage) {
        this.trueDamage = trueDamage;
    }

    public void setLifesteal(int lifesteal) {
        this.lifesteal = lifesteal;
    }
    
    public void setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }

    public void setReflect(int reflect) {
        this.reflect = reflect;
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

    public int getResistance() {
        return resistance;
    }

    public int getAgility() {
        return agility;
    }

    public ElementType getOffensiveType(){
        return offensiveType;
    }

    public ElementType getDefensiveType(){
        return defensiveType;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getTrueDamage() {
        return trueDamage;
    }

    public int getLifesteal() {
        return lifesteal;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    public int getReflect() {
        return reflect;
    }
    
}