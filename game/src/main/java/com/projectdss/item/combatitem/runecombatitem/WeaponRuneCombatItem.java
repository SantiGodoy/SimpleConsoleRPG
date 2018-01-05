package com.projectdss.item.combatitem.runecombatitem;

import com.projectdss.Rarity;
import com.projectdss.item.combatitem.RuneCombatItem;
import com.projectdss.item.combatitem.equipablecombatitem.WeaponEquipableCombatItem;

/**
 * @author JoseCorrero
 * 
 * Class WeaponRuneCombatItem represents any RuneCombatItem that can be added to 
 * an WeaponEquipableCombatItem to enhance it.
 */
public abstract class WeaponRuneCombatItem extends RuneCombatItem {

    public WeaponRuneCombatItem(int id, String name, Rarity rarity, String description) {
        super(id, name, rarity, description);
    }

    public abstract int getSharpness();

    public abstract void use(WeaponEquipableCombatItem weapon);

    public abstract void disuse(WeaponEquipableCombatItem weapon);

}