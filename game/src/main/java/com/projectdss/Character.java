package com.projectdss;

import java.util.*;

import javax.lang.model.element.TypeElement;

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
    protected int defense;  
    protected int agility;
    protected ElementType type;
    protected Set<Ability> abilities;

    public Character() {
    }

    public Character(int id, String name, int level, int health, int mana, int strength, int defense, int agility, TypeElement type, Set<Ability> abilities) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.maxHealth = health;
        this.currentHealth = health;
        this.maxMana = mana;
        this.currentMana = mana;
        this.strength = strength;
        this.agility = agility;
        this.defense = defense;
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
    //If mana < 0 the currentMana isn't 0, only we can't use the ability.
    public void setCurrentMana(int mana) {
        if(mana > maxMana){
            this.currentMana = maxMana;
        } else {
            if(mana < 0){
                this.currentMana = 0;
            } else {
                this.currentMana = mana;
            }
        }
    }

    public void setStrength (int strength){
        this.strength = strength;
    }

    public void setDefense (int defense){
        this.defense = defense;
    }

    public void setAgility (int agility){
        this.agility = agility;
    }

    public void addAbility (Ability ability){

    }

    public void removeAbility (Ability ability){
        
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

    public Boolean isAlive() {
        return currentHealth != 0;
    }

}