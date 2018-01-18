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

    private final String gender;    
    private int xp;
    private final World world;
    private Zone zone;
    private Minizone minizone;
    private final Inventory inventory;

    public MainCharacter(String name, CharacterStats characterStats, Set<Ability> abilities, 
                         String gender, World world, Zone zone, Minizone minizone, Inventory inventory) {
        super(name, 1, characterStats, abilities);
        this.gender = gender;
        this.xp = 0;
        this.world = world;
        this.zone = zone;
        this.minizone = minizone;
        this.inventory = inventory;
    }

    public void incrementLevel(int[] options) {
        ++level;

        for(int i = 0; i < options.length; ++i) {
            switch(options[i]) {
                case 1: characterStats.setMaxHealth(characterStats.getMaxHealth() + 15);
                    break;
                case 2: characterStats.setMaxMana(characterStats.getMaxMana() + 5);
                    break;
                case 3: characterStats.setStrength(characterStats.getStrength() + 2);
                    break;
                case 4: characterStats.setMagicalPower(characterStats.getMagicalPower() + 3);
                    break;
                case 5: characterStats.setResistance(characterStats.getResistance() + 2);
                    break;
                case 6: characterStats.setAgility(characterStats.getAgility() + 2);
                    break;
            }
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

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public void setMinizone(Minizone minizone) {
        this.minizone = minizone;
    }

    @Override
    public String getGender() {
        return gender;
    }

    public int getXP() {
        return xp;
    }

    public World getWorld() {
        return world;
    }

    public Zone getZone() {
        return zone;
    }

    public Minizone getMinizone() {
        return minizone;
    }
    
    public Inventory getInventory() {
        return inventory;
    }

}