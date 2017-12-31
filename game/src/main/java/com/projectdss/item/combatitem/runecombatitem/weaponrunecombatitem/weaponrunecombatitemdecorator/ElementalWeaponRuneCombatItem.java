package com.proyectdss.item.combatitem.runecombatitem.weaponrunecombatitem;

import java.util.*;
import com.proyectdss.Rarity;
import com.proyectdss.item.combatitem.equipablecombatitem.WeaponEquipableCombatItem;
import com.proyectdss.ElementType;

/**
 * @author JoseCorrero
 * 
 * Class ElementalWeaponRuneCombatItem represents any WeaponRuneCombatItemDecorator that 
 * can be added to a WeaponEquipableCombatItem to give it an elemental type.
 */
public class ElementalWeaponRuneCombatItem extends WeaponRuneCombatItemDecorator {

    private ElementType type;

    public ElementalWeaponRuneCombatItem(int id, String name, Rarity rarity, String description, 
                                         WeaponRuneCombatItem rune, ElementType type) {
        super(id, name, rarity, description, rune);
        this.type = type;
    }

    @override
    public void use(WeaponEquipableCombatItem weapon) {
        super.use(weapon);
        weapon.setType(type);
    }

    @override
    public void disuse(WeaponEquipableCombatItem weapon) {
        super.disuse(weapon);
        weapon.setType(BASIC);
    }

}