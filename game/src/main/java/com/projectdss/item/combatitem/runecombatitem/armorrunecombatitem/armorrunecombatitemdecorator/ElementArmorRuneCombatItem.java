package com.projectdss.item.combatitem.runecombatitem.armorrunecombatitem.armorrunecombatitemdecorator;

import com.projectdss.Rarity;
import com.projectdss.ElementType;
import com.projectdss.CharacterStats;
import com.projectdss.item.combatitem.runecombatitem.ArmorRuneCombatItem;
import com.projectdss.item.combatitem.runecombatitem.armorrunecombatitem.ArmorRuneCombatItemDecorator;

/**
 * @author JoseCorrero
 * 
 * Class ElementArmorRuneCombatItem represents any ArmorRuneCombatItemDecorator that 
 * can be added to a ArmorEquipableCombatItem to give it an elemental type.
 */
public class ElementArmorRuneCombatItem extends ArmorRuneCombatItemDecorator {

    private final ElementType type;

    public ElementArmorRuneCombatItem(int id, String name, Rarity rarity, String description, 
                                      ArmorRuneCombatItem rune, ElementType type) {
        super(id, name, rarity, description, rune);
        this.type = type;
    }

    @Override
    public void use(CharacterStats characterStats) {
        super.use(characterStats);
        characterStats.setDefensiveType(type);
    }

    @Override
    public void disuse(CharacterStats characterStats) {
        super.disuse(characterStats);
        characterStats.setDefensiveType(ElementType.BASIC);
    }

}