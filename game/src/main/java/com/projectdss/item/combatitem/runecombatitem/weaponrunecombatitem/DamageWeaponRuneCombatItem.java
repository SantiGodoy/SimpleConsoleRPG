package com.proyectdss.item.combatitem.runecombatitem.weaponrunecombatitem;

import java.util.*;
import com.proyectdss.Rarity;

/**
 * @author JoseCorrero
 * 
 * Class DamageWeaponRuneCombatItem represents any WeaponRuneCombatItem that can be added 
 * to a WeaponEquipableCombatItemDecorator to create a DamageWeaponEquipableCombatItem.
 */
public class DamageWeaponRuneCombatItem extends WeaponRuneCombatItem {

    private int extraDamage;

    public DamageWeaponRuneCombatItem(int id, String name, Rarity rarity, String description, 
                                      int extraDamage) {
        super(id, name, rarity, description);
        this.extraDamage = extraDamage;
    }

    @override
    public int use() {
        return extraDamage;
    }

}