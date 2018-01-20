package com.projectdss.item.combatitem.runecombatitem.weaponrunecombatitem.weaponrunecombatitemdecorator;


import com.projectdss.Rarity;
import com.projectdss.ElementType;
import com.projectdss.CharacterStats;
import com.projectdss.item.combatitem.runecombatitem.WeaponRuneCombatItem;
import com.projectdss.item.combatitem.runecombatitem.weaponrunecombatitem.WeaponRuneCombatItemDecorator;

/**
 * @author JoseCorrero
 * 
 * Class ElementWeaponRuneCombatItem represents any WeaponRuneCombatItemDecorator that 
 * can be added to a WeaponEquipableCombatItem to give it an elemental type.
 */
public class ElementWeaponRuneCombatItem extends WeaponRuneCombatItemDecorator {

    private ElementType type;

    public ElementWeaponRuneCombatItem(){}

    public ElementWeaponRuneCombatItem(String name, Rarity rarity, String description, 
                                       WeaponRuneCombatItem rune, ElementType type) {
        super(name, rarity, description, rune);
        this.type = type;
    }

    public ElementType getType() {
        return type;
    }

    public void setType(ElementType type) {
        this.type = type;
    }

    @Override
    public void use(CharacterStats characterStats) {
        super.use(characterStats);
        characterStats.setOffensiveType(type);
    }

    @Override
    public void disuse(CharacterStats characterStats) {
        super.disuse(characterStats);
        characterStats.setOffensiveType(ElementType.BASIC);
    }

}