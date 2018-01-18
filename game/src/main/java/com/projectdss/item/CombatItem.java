package com.projectdss.item;

import com.projectdss.Item;
import com.projectdss.Rarity;
import com.projectdss.CharacterStats;

/**
 * @author JoseCorrero
 * 
 * Class CombatItem represents any Item that can be used in combat.
 */
public abstract class CombatItem extends Item {

    public CombatItem(String name, Rarity rarity, String description) {
        super(name, rarity, description);
    }

    public abstract void disuse(CharacterStats characteStats);
}