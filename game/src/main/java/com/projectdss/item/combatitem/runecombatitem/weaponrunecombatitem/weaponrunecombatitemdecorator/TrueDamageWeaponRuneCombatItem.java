package com.proyectdss.item.combatitem.runecombatitem.weaponrunecombatitem;

import com.proyectdss.Rarity;
import com.proyectdss.item.combatitem.equipablecombatitem.WeaponEquipableCombatItem;

/**
 * @author JoseCorrero
 * 
 * Class TrueDamageWeaponRuneCombatItem represents any WeaponRuneCombatItemDecorator that 
 * can be added to a WeaponEquipableCombatItem to enhance its true damage.
 */
public class TrueDamageWeaponRuneCombatItem extends WeaponRuneCombatItemDecorator {

    private int trueDamage;

    public TrueDamageWeaponRuneCombatItem(int id, String name, Rarity rarity, String description, 
                                          WeaponRuneCombatItem rune, int trueDamage) {
        super(id, name, rarity, description, rune);
        this.trueDamage = trueDamage;
    }

    @Override
    public void use(WeaponEquipableCombatItem weapon) {
        super.use(weapon);
        weapon.setTrueDamage(weapon.getTrueDamage() + trueDamage);
    }

    @Override
    public void disuse(WeaponEquipableCombatItem weapon) {
        super.disuse(weapon);
        weapon.setTrueDamage(weapon.getTrueDamage() - trueDamage);
    }

}