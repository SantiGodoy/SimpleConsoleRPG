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

    protected final WeaponRuneCombatItem rune;

    public WeaponRuneCombatItemDecorator(int id, String name, Rarity rarity, String description, 
                                         WeaponRuneCombatItem rune) {
        super(id, name, rarity, description);
        this.rune = rune;
    }

    @Override
    public int getSharpness() {
        return rune.getSharpness();
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