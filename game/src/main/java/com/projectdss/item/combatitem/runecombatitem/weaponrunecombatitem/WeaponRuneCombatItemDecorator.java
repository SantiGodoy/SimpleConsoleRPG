package com.projectdss.item.combatitem.runecombatitem.weaponrunecombatitem;

import com.projectdss.Rarity;
import com.projectdss.CharacterStats;
import com.projectdss.item.combatitem.runecombatitem.WeaponRuneCombatItem;

/**
 * @author JoseCorrero
 * 
 * Class WeaponRuneCombatItemDecorator represents any WeaponRuneCombatItem that 
 * can be added to a WeaponEquipableCombatItem to enhance its base damage and something else.
 */
public abstract class WeaponRuneCombatItemDecorator extends WeaponRuneCombatItem {

    protected WeaponRuneCombatItem rune;

    public WeaponRuneCombatItemDecorator(){}

    public WeaponRuneCombatItemDecorator(String name, Rarity rarity, String description, 
                                         WeaponRuneCombatItem rune) {
        super(name, rarity, description);
        this.rune = rune;
    }

    @Override
    public int getSharpness() {
        return rune.getSharpness();
    }

    public WeaponRuneCombatItem getRune() {
        return rune;
    }

    public void setRune(WeaponRuneCombatItem rune) {
        this.rune = rune;
    }

    @Override
    public void use(CharacterStats characterStats) {
        rune.use(characterStats);
    }

    @Override
    public void disuse(CharacterStats characterStats) {
        rune.disuse(characterStats);
    }

}