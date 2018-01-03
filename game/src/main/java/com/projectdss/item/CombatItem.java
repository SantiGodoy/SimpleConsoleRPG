package com.projectdss.item;

import com.projectdss.Item;
import com.projectdss.Rarity;

/**
 * @author JoseCorrero
 * 
 * Class CombatItem represents any Item that can be used in combat.
 */
public abstract class CombatItem extends Item {

    public CombatItem() {}

    public CombatItem(int id, String name, Rarity rarity, String description) {
        super(id, name, rarity, description);
    }

}