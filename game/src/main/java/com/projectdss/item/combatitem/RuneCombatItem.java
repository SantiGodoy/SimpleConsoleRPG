package com.proyectdss.item.combatitem;

import com.proyectdss.Rarity;

/**
 * @author JoseCorrero
 * 
 * Class RuneCombatItem represents any CombatItem that can be added to 
 * an EquipableCombatItem to enhance it.
 */
public abstract class RuneCombatItem extends CombatItem {

    protected boolean merged;

    public RuneCombatItem() {}

    public RuneCombatItem(int id, String name, Rarity rarity, String description) {
        super(id, name, rarity, description);
        this.merged = false;
    }

    public void setMerged(boolean merged) {
        this.merged = merged;
    }

    public boolean isMerged() {
        return merged;
    }

}