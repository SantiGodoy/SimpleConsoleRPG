package com.proyectdss.item.combatitem.equipablecombatitem.armorequipablecombatitem.armorequipablecombatitemdecorator;

import java.util.*;
import com.proyectdss.Rarity;
import com.proyectdss.Character;

/**
 * @author JoseCorrero
 *
 * Class ElementalArmorEquipableCombatItem represents any ArmorEquipableCombatItemDecorator
 * that has an ElementalArmorRuneCombatItem added.
 */
public class ElementalArmorEquipableCombatItem extends ArmorEquipableCombatItemDecorator {

    public ElementalArmorEquipableCombatItem(int id, 
                                             ArmorEquipableCombatItem armor,
                                             ElementalArmorRuneCombatItem rune) {
        super(id, armor, rune);
    }

    @override
    public int use(Character player1, Character player2) {
        return super.use(player1, player2) * ElementType.elementalMatrix[player1.getType()][rune.use()];
    }

}