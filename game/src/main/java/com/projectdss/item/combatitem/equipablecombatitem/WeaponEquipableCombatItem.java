package com.projectdss.item.combatitem.equipablecombatitem;

import java.util.Set;
import com.projectdss.Rarity;
import com.projectdss.CharacterStats;
import com.projectdss.item.combatitem.RuneCombatItem;
import com.projectdss.item.combatitem.EquipableCombatItem;

/**
 * @author JoseCorrero
 * 
 * Class WeaponEquipableCombatItem represents any EquipableCombatItem 
 * that can be equipped as weapon.
 */
public class WeaponEquipableCombatItem extends EquipableCombatItem {
    
    private final int baseDamage;

    public WeaponEquipableCombatItem(int id, String name, Rarity rarity, String description, int maxRunes,
                                     Set<RuneCombatItem> runes, int baseDamage) {
        super(id, name, rarity, description, maxRunes, runes);
        this.baseDamage = baseDamage;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    @Override
    public void use(CharacterStats characterStats) {
        characterStats.setBaseDamage(characterStats.getStrength() + baseDamage);

        for(RuneCombatItem rune : runes) {
            rune.use(characterStats);
        }
    }

}