package com.projectdss.item.combatitem.runecombatitem.weaponrunecombatitem.weaponrunecombatitemdecorator;

import com.projectdss.Rarity;
import com.projectdss.CharacterStats;
import com.projectdss.item.combatitem.runecombatitem.WeaponRuneCombatItem;
import com.projectdss.item.combatitem.runecombatitem.weaponrunecombatitem.WeaponRuneCombatItemDecorator;

/**
 * @author JoseCorrero
 * 
 * Class LifestealWeaponRuneCombatItem represents any WeaponRuneCombatItemDecorator that 
 * can be added to a WeaponEquipableCombatItem to enhance its lifesteal.
 */
public class LifestealWeaponRuneCombatItem extends WeaponRuneCombatItemDecorator {

    private final int lifesteal;

    public LifestealWeaponRuneCombatItem(String name, Rarity rarity, String description, 
                                         WeaponRuneCombatItem rune, int lifesteal) {
        super(name, rarity, description, rune);
        this.lifesteal = lifesteal;
    }

    @Override
    public void use(CharacterStats characterStats) {
        super.use(characterStats);
        characterStats.setLifesteal(characterStats.getLifesteal() + lifesteal);
    }

    @Override
    public void disuse(CharacterStats characterStats) {
        super.disuse(characterStats);
        characterStats.setLifesteal(characterStats.getLifesteal() - lifesteal);
    }

}