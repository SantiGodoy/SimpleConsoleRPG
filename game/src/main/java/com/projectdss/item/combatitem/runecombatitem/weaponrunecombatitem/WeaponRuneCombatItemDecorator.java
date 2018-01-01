package com.proyectdss.item.combatitem.runecombatitem.weaponrunecombatitem;

import com.proyectdss.Rarity;
import com.proyectdss.item.combatitem.equipablecombatitem.WeaponEquipableCombatItem;

/**
 * @author JoseCorrero
 * 
 * Class WeaponRuneCombatItemDecorator represents any WeaponRuneCombatItem that 
 * can be added to a WeaponEquipableCombatItem to enhance its base damage and something else.
 */
public abstract class WeaponRuneCombatItemDecorator extends WeaponRuneCombatItem {

    protected WeaponRuneCombatItem rune;

    public WeaponRuneCombatItemDecorator(int id, String name, Rarity rarity, String description, 
                                         WeaponRuneCombatItem rune) {
        super(id, name, rarity, description);
        this.rune = rune;
    }

    @Override
    public int getSharpness() {
        return rune.getSharpness();
    }

    @Override
    public void use(WeaponEquipableCombatItem weapon) {
        rune.use(weapon);
    }

    @Override
    public void disuse(WeaponEquipableCombatItem weapon) {
        rune.disuse(weapon);
    }

}