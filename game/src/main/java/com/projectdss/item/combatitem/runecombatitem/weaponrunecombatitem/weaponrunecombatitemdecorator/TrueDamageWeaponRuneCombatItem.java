package com.projectdss.item.combatitem.runecombatitem.weaponrunecombatitem.weaponrunecombatitemdecorator;

import com.projectdss.Rarity;
import com.projectdss.item.combatitem.runecombatitem.WeaponRuneCombatItem;
import com.projectdss.item.combatitem.equipablecombatitem.WeaponEquipableCombatItem;
import com.projectdss.item.combatitem.runecombatitem.weaponrunecombatitem.WeaponRuneCombatItemDecorator;

/**
 * @author JoseCorrero
 * 
 * Class TrueDamageWeaponRuneCombatItem represents any WeaponRuneCombatItemDecorator that 
 * can be added to a WeaponEquipableCombatItem to enhance its true damage.
 */
public class TrueDamageWeaponRuneCombatItem extends WeaponRuneCombatItemDecorator {

    private final int trueDamage;

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