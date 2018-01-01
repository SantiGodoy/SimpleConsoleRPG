package com.proyectdss.item.combatitem.runecombatitem.weaponrunecombatitem;

import com.proyectdss.Rarity;
import com.proyectdss.item.combatitem.equipablecombatitem.WeaponEquipableCombatItem;

/**
 * @author JoseCorrero
 * 
 * Class LifestealWeaponRuneCombatItem represents any WeaponRuneCombatItemDecorator that 
 * can be added to a WeaponEquipableCombatItem to enhance its lifesteal.
 */
public class LifestealWeaponRuneCombatItem extends WeaponRuneCombatItemDecorator {

    private int lifesteal;

    public LifestealWeaponRuneCombatItem(int id, String name, Rarity rarity, String description, 
                                         WeaponRuneCombatItem rune, int lifesteal) {
        super(id, name, rarity, description, rune);
        this.lifesteal = lifesteal;
    }

    @Override
    public void use(WeaponEquipableCombatItem weapon) {
        super.use(weapon);
        weapon.setLifesteal(weapon.getLifesteal() + lifesteal);
    }

    @Override
    public void disuse(WeaponEquipableCombatItem weapon) {
        super.disuse(weapon);
        weapon.setLifesteal(weapon.getLifesteal() - lifesteal);
    }

}