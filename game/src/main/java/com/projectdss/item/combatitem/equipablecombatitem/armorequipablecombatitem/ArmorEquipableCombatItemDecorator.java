package com.proyectdss.item.combatitem.equipablecombatitem.armorequipablecombatitem;

import java.util.*;
import com.proyectdss.Rarity;
import com.proyectdss.Character;

/**
 * @author JoseCorrero
 *
 * Class ArmorEquipableCombatItemDecorator represents any ArmorEquipableCombatItem
 * that has been enhanced with some ArmorRuneCombatItem.
 */
public abstract class ArmorEquipableCombatItemDecorator extends ArmorEquipableCombatItem {

    protected ArmorEquipableCombatItem armor;
    protected ArmorRuneCombatItem rune;

    public ArmorEquipableCombatItemDecorator(int id, 
                                             ArmorEquipableCombatItem armor,
                                             ArmorRuneCombatItem rune) {
        super(id, 
              armor.getName() + " (" + rune.getName() + ")", 
              armor.getRarity(), 
              armor.getDescription() + "\n" + rune.getDescription(), 
              armor.getBaseDefense());

        this.armor = armor;
        this.rune = rune;

        armor.merged = true;
        rune.merged = true;
    }

    @override
    public int use(Character player1, Character player2) {
        return armor.use(player1, player2);
    }

}