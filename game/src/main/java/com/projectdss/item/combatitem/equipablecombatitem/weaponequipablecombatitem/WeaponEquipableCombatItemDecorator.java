package com.proyectdss.item.combatitem.equipablecombatitem.weaponequipablecombatitem;

import java.util.*;
import com.proyectdss.Rarity;
import com.proyectdss.Character;

/**
 * @author JoseCorrero
 *
 * Class WeaponEquipableCombatItemDecorator represents any WeaponEquipableCombatItem
 * that has been enchanced with some WeaponRuneCombatItem.
 */
public abstract class WeaponEquipableCombatItemDecorator extends WeaponEquipableCombatItem {

    protected WeaponEquipableCombatItem weapon;
    protected WeaponRuneCombatItem rune;

    public WeaponEquipableCombatItemDecorator(int id, 
                                              WeaponEquipableCombatItem weapon,
                                              WeaponRuneCombatItem rune) {
        super(id, 
              weapon.getName() + " (" + rune.getName() + ")", 
              weapon.getRarity(), 
              weapon.getDescription() + "\n" + rune.getDescription(), 
              weapon.getBaseDamage());

        this.weapon = weapon;
        this.rune = rune;

        weapon.merged = true;
        rune.merged = true;
    }

    @override
    public int use(Character player1, Character player2) {
        return weapon.use(player1, player2);
    }

}