package com.proyectdss.item.combatitem.runecombatitem.weaponrunecombatitem;

import java.util.*;
import com.proyectdss.Rarity;
import com.proyectdss.item.combatitem.equipablecombatitem.WeaponEquipableCombatItem;

/**
 * @author JoseCorrero
 * 
 * Class SharpnessWeaponRuneCombatItem represents any WeaponRuneCombatItem that 
 * can be added to a WeaponEquipableCombatItem to enhance its base damage.
 */
public class SharpnessWeaponRuneCombatItem extends WeaponRuneCombatItem {

    private int sharpness;

    public WeaponRuneCombatItemDecorator(int id, String name, Rarity rarity, String description, 
                                         int sharpness) {
        super(id, name, rarity, description);
        this.sharpness = sharpness;
    }

    @override
    public int getSharpness() {
        return sharpness;
    }

    @override
    public void use(WeaponEquipableCombatItem weapon) {
        weapon.setBaseDamage(weapon.getBaseDamage() + sharpness);
    }

    @override
    public void disuse(WeaponEquipableCombatItem weapon) {
        weapon.setBaseDamage(weapon.getBaseDamage() - sharpness);
    }

}