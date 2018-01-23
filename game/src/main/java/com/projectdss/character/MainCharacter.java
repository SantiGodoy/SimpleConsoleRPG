package com.projectdss.character;

import java.util.Set;
import com.projectdss.Ability;
import com.projectdss.map.Zone;
import com.projectdss.map.World;
import com.projectdss.map.Minizone;
import com.projectdss.Character;
import com.projectdss.CharacterStats;
import com.projectdss.inventory.Inventory;

/**
 * @author JoseCorrero
 * 
 * Class MainCharacter.
 */
public class MainCharacter extends Character {

    private String gender;    
    private int xp;
    private int idZone;
    private int idMinizone;
    private boolean isIn;
    private Inventory inventory;

    public MainCharacter(){}

    public MainCharacter(String name, CharacterStats characterStats, Set<Ability> abilities, 
                         String gender, int idZone, int idMinizone, Inventory inventory) {
        super(name, 1, characterStats, abilities);
        this.gender = gender;
        this.xp = 0;
        this.idZone = idZone;
        this.idMinizone = idMinizone;
        this.isIn = true;
        this.inventory = inventory;
    }

    public void incrementLevel(int option) {
        ++level;
        switch(option) {
            case 1: characterStats.setMaxHealth(characterStats.getMaxHealth() + 15);
                    characterStats.setCurrentHealth(characterStats.getCurrentHealth() + 15);
                break;
            case 2: characterStats.setMaxMana(characterStats.getMaxMana() + 5);
                    characterStats.setCurrentMana(characterStats.getCurrentMana() + 15);
                break;
            case 3: characterStats.setStrength(characterStats.getStrength() + 2);
                    characterStats.setBaseDamage(characterStats.getBaseDamage() + 2);
                break;
            case 4: characterStats.setMagicalPower(characterStats.getMagicalPower() + 3);
                break;
            case 5: characterStats.setResistance(characterStats.getResistance() + 2);
                    characterStats.setBaseDefense(characterStats.getBaseDefense() + 2);
                break;
            case 6: characterStats.setAgility(characterStats.getAgility() + 2);
                break;
        }
    }

    public int addXP(int xp) {
        this.xp += xp;

        int levelUp = 0;

        while(this.xp >= (100 * level)) {
            ++levelUp;
            this.xp -= (100 * (level + levelUp));
        }

        return levelUp;
    }

    public void setIdZone(int idZone) {
        this.idZone = idZone;
    }

    public void setIdMinizone(int idMinizone) {
        this.idMinizone = idMinizone;
    }

    public void setIsIn(boolean isIn) {
        this.isIn = isIn;
    }

    @Override
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getIdZone() {
        return idZone;
    }

    public int getIdMinizone() {
        return idMinizone;
    }

    public boolean isIn() {
        return isIn;
    }
    
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

}