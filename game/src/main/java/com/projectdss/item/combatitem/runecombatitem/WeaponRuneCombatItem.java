package com.projectdss.item.combatitem.runecombatitem;

import com.projectdss.Rarity;
import com.projectdss.item.combatitem.RuneCombatItem;

/**
 * @author JoseCorrero
 * 
 * Class WeaponRuneCombatItem represents any RuneCombatItem that can be added to 
 * an WeaponEquipableCombatItem to enhance it.
 */
public abstract class WeaponRuneCombatItem extends RuneCombatItem {

    public WeaponRuneCombatItem(){}

    public WeaponRuneCombatItem(String name, Rarity rarity, String description) {
        super(name, rarity, description);
    }

    public abstract int getSharpness();

}