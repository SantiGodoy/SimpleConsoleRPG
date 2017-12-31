package com.proyectdss.item.combatitem.runecombatitem;

import java.util.*;
import com.proyectdss.Rarity;
import com.proyectdss.item.combatitem.equipablecombatitem.WeaponEquipableCombatItem;

/**
 * @author JoseCorrero
 * 
 * Class WeaponRuneCombatItem represents any RuneCombatItem that can be added to 
 * an WeaponEquipableCombatItem to enhance it.
 */
public abstract class WeaponRuneCombatItem extends RuneCombatItem {

    public WeaponRuneCombatItem() {}

    public WeaponRuneCombatItem(int id, String name, Rarity rarity, String description) {
        super(id, name, rarity, description);
    }

    public abstract int getSharpness();

    public abstract void use(WeaponEquipableCombatItem weapon);

    public abstract void disuse(WeaponEquipableCombatItem weapon);

}