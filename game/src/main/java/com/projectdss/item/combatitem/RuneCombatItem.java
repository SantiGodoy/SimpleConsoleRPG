package com.projectdss.item.combatitem;

import com.projectdss.Rarity;
import com.projectdss.item.CombatItem;

/**
 * @author JoseCorrero
 * 
 * Class RuneCombatItem represents any CombatItem that can be added to 
 * an EquipableCombatItem to enhance it.
 */
public abstract class RuneCombatItem extends CombatItem {

    public RuneCombatItem(){}

    public RuneCombatItem(String name, Rarity rarity, String description) {
        super(name, rarity, description);
    }

}