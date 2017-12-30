package com.proyectdss.item.combatitem.runecombatitem.weaponrunecombatitem;

import java.util.*;
import com.proyectdss.Rarity;

/**
 * @author JoseCorrero
 * 
 * Class LifestealWeaponRuneCombatItem represents any WeaponRuneCombatItem that can be added 
 * to a WeaponEquipableCombatItemDecorator to create a LifestealWeaponEquipableCombatItem.
 */
public class LifestealWeaponRuneCombatItem extends WeaponRuneCombatItem {

    private int lifesteal;

    public LifestealWeaponRuneCombatItem(int id, String name, Rarity rarity, String description, 
                                         int lifesteal) {
        super(id, name, rarity, description);
        this.lifesteal = lifesteal;
    }

    @override
    public int use() {
        return lifesteal;
    }

}