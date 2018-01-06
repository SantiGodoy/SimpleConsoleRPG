
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
 * 
 */
public class MainCharacter extends Character {

    private final String gender;    
    private int xp;
    private final World world;
    private Zone zone;
    private Minizone minizone;
    private final Inventory inventory;

    public MainCharacter(int id, String name, CharacterStats characterStats, Set<Ability> abilities, 
                         String gender, World world, Zone zone, Minizone minizone, Inventory inventory) {
        super(id, name, 1, characterStats, abilities);
        this.gender = gender;
        this.xp = 0;
        this.world = world;
        this.zone = zone;
        this.minizone = minizone;
        this.inventory = inventory;
    }

    public void incrementLevel(int option1, int option2, int option3) {
        ++level;

        int[] options = new int[3];

        options[0] = option1;
        options[1] = option2;
        options[2] = option3;

        for(int i = 0; i < 3; ++i) {
            switch(options[i]) {
                case 1: characterStats.setMaxHealth(characterStats.getMaxHealth() + 80);
                    break;
                case 2: characterStats.setMaxMana(characterStats.getMaxMana() + 30);
                    break;
                case 3: characterStats.setStrength(characterStats.getStrength() + 5);
                    break;
                case 4: characterStats.setMagicalPower(characterStats.getMagicalPower() + 6);
                    break;
                case 5: characterStats.setResistance(characterStats.getResistance() + 5);
                    break;
                case 6: characterStats.setAgility(characterStats.getAgility() + 4);
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