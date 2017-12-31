package com.proyectdss.item.combatitem.runecombatitem.armorrunecombatitem;

import java.util.*;
import com.proyectdss.Rarity;
import com.proyectdss.item.combatitem.equipablecombatitem.ArmorEquipableCombatItem;
import com.proyectdss.ElementType;

/**
 * @author JoseCorrero
 * 
 * Class ElementalArmorRuneCombatItem represents any ArmorRuneCombatItemDecorator that 
 * can be added to a ArmorEquipableCombatItem to give it an elemental type.
 */
public class ElementalArmorRuneCombatItem extends ArmorRuneCombatItemDecorator {

    private ElementType type;

    public ElementalArmorRuneCombatItem(int id, String name, Rarity rarity, String description, 
                                        ArmorRuneCombatItem rune, ElementType type) {
        super(id, name, rarity, description, rune);
        this.type = type;
    }

    @override
    public void use(ArmorEquipableCombatItem armor) {
        super.use(armor);
        armor.setType(type);
    }

    @override
    public void disuse(ArmorEquipableCombatItem armor) {
        super.disuse(armor);
        armor.setType(BASIC);
    }

}