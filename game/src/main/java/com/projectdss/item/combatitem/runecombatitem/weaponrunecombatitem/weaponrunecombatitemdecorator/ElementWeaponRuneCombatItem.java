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

    private final ElementType type;

    public ElementWeaponRuneCombatItem(int id, String name, Rarity rarity, String description, 
                                       WeaponRuneCombatItem rune, ElementType type) {
        super(id, name, rarity, description, rune);
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