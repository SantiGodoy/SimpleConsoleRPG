
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

    public void setXP(int xp) {
        while (xp >= (100 * level)){
          ++this.level;
          xp -= (100 * level);
        }      
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