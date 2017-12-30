package com.proyectdss.item.combatitem.runecombatitem.armorrunecombatitem;

import java.util.*;
import com.proyectdss.Rarity;

/**
 * @author JoseCorrero
 * 
 * Class DefenseArmorRuneCombatItem represents any ArmorRuneCombatItem that can be added 
 * to an ArmorEquipableCombatItemDecorator to create a DefenseArmorEquipableCombatItem.
 */
public class DefenseArmorRuneCombatItem extends ArmorRuneCombatItem {

    private int extraDefense;

    public DefenseArmorRuneCombatItem(int id, String name, Rarity rarity, String description, 
                                      int extraDefense) {
        super(id, name, rarity, description);
        this.extraDefense = extraDefense;
    }

    @override
    public int use() {
        return extraDefense;
    }

}