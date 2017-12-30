package com.proyectdss.item.combatitem.equipablecombatitem.armorequipablecombatitem;

import java.util.*;
import com.proyectdss.Rarity;
import com.proyectdss.Character;

/**
 * @author JoseCorrero
 *
 * Class SimpleArmorEquipableCombatItem represents any ArmorEquipableCombatItem
 * that has not been enhanced with any ArmorRuneCombatItem.
 */
public class SimpleArmorEquipableCombatItem extends ArmorEquipableCombatItem {

    public SimpleArmorEquipableCombatItem(int id, String name, Rarity rarity, String description, 
                                          int baseDefense) {
        super(id, name, rarity, description, baseDefense);
    }

    @override
    public int use(Character player1, Character player2) {
        int damagePlayer1  = player1.getStrength(),
            defensePlayer2 = player2.getDefense() + baseDefense;

        if(defensePlayer2 < damagePlayer1)
            return damagePlayer1 - defensePlayer2;
        else
            return 0;
    }

}