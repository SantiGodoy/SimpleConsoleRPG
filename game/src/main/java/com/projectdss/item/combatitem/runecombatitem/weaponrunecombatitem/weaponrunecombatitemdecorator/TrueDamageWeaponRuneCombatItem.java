package com.projectdss.item.combatitem.runecombatitem.weaponrunecombatitem.weaponrunecombatitemdecorator;

import com.projectdss.Rarity;
import com.projectdss.CharacterStats;
import com.projectdss.item.combatitem.runecombatitem.WeaponRuneCombatItem;
import com.projectdss.item.combatitem.runecombatitem.weaponrunecombatitem.WeaponRuneCombatItemDecorator;

/**
 * @author JoseCorrero
 * 
 * Class TrueDamageWeaponRuneCombatItem represents any WeaponRuneCombatItemDecorator that 
 * can be added to a WeaponEquipableCombatItem to enhance its true damage.
 */
public class TrueDamageWeaponRuneCombatItem extends WeaponRuneCombatItemDecorator {

    private int trueDamage;

    public TrueDamageWeaponRuneCombatItem(){}

    public TrueDamageWeaponRuneCombatItem(String name, Rarity rarity, String description, 
                                          WeaponRuneCombatItem rune, int trueDamage) {
        super(name, rarity, description, rune);
        this.trueDamage = trueDamage;
    }

    public int getTrueDamage() {
        return trueDamage;
    }

    public void setTrueDamage(int trueDamage) {
        this.trueDamage = trueDamage;
    }

    @Override
    public void use(CharacterStats characterStats) {
        super.use(characterStats);
        characterStats.setTrueDamage(characterStats.getTrueDamage() + trueDamage);
    }

    @Override
    public void disuse(CharacterStats characterStats) {
        super.disuse(characterStats);
        characterStats.setTrueDamage(characterStats.getTrueDamage() - trueDamage);
    }

}