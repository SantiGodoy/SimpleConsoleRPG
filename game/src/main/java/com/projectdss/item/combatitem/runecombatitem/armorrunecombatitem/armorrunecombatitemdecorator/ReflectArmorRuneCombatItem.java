package com.proyectdss.item.combatitem.runecombatitem.armorrunecombatitem;

import java.util.*;
import com.proyectdss.Rarity;
import com.proyectdss.item.combatitem.equipablecombatitem.ArmorEquipableCombatItem;

/**
 * @author JoseCorrero
 * 
 * Class ReflectArmorRuneCombatItem represents any ArmorRuneCombatItemDecorator that 
 * can be added to a ArmorEquipableCombatItem to enhance its reflect.
 */
public class ReflectArmorRuneCombatItem extends ArmorRuneCombatItemDecorator {

    private int reflect;

    public ReflectArmorRuneCombatItem(int id, String name, Rarity rarity, String description,  
                                      ArmorRuneCombatItem rune, int reflect) {
        super(id, name, rarity, description, rune);
        this.reflect = reflect;
    }

    @override
    public void use(ArmorEquipableCombatItem armor) {
        super.use(armor);
        armor.setReflect(armor.getReflect() + reflect);
    }

    @override
    public void disuse(ArmorEquipableCombatItem armor) {
        super.disuse(armor);
        armor.setReflect(armor.getReflect() - reflect);
    }

}