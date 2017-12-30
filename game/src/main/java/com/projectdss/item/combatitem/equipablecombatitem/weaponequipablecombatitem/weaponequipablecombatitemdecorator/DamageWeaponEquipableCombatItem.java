package com.proyectdss.item.combatitem.equipablecombatitem.weaponequipablecombatitem.weaponequipablecombatitemdecorator;

import java.util.*;
import com.proyectdss.Rarity;
import com.proyectdss.Character;

/**
 * @author JoseCorrero
 *
 * Class DamageWeaponEquipableCombatItem represents any WeaponEquipableCombatItemDecorator 
 * that has a DamageWeaponRuneCombatItem added.
 */
public class DamageWeaponEquipableCombatItem extends WeaponEquipableCombatItemDecorator {

    public DamageWeaponEquipableCombatItem(int id, 
                                           WeaponEquipableCombatItem weapon,
                                           DamageWeaponRuneCombatItem rune) {
        super(id, weapon, rune);
    }

    @override
    public int use(Character player1, Character player2) {
        return super.use(player1, player2) + rune.use();
    }

}