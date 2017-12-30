package com.proyectdss.item.combatitem.runecombatitem.armorrunecombatitem;

import java.util.*;
import com.proyectdss.Rarity;

/**
 * @author JoseCorrero
 * 
 * Class ReflectArmorRuneCombatItem represents any ArmorRuneCombatItem that can be added 
 * to an ArmorEquipableCombatItemDecorator to create a ReflectArmorEquipableCombatItem.
 */
public class ReflectArmorRuneCombatItem extends ArmorRuneCombatItem {

    private int reflect;

    public ReflectArmorRuneCombatItem(int id, String name, Rarity rarity, String description, 
                                    int reflect) {
        super(id, name, rarity, description);
        this.reflect = reflect;
    }

    @override
    public int use() {
        return reflect;
    }

}