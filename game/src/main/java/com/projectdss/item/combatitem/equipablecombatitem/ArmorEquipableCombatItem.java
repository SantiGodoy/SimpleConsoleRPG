package com.projectdss.item.combatitem.equipablecombatitem;

import java.util.Set;
import com.projectdss.Rarity;
import com.projectdss.CharacterStats;
import com.projectdss.item.combatitem.RuneCombatItem;
import com.projectdss.item.combatitem.EquipableCombatItem;

/**
 * @author JoseCorrero
 * 
 * Class ArmorEquipableCombatItem represents any EquipableCombatItem 
 * that can be equipped as armor.
 */
public class ArmorEquipableCombatItem extends EquipableCombatItem {
    
    private final int baseDefense;
    
    public ArmorEquipableCombatItem(String name, Rarity rarity, String description, int maxRunes,
                                    Set<RuneCombatItem> runes, int baseDefense) {
        super(name, rarity, description, maxRunes, runes);
        this.baseDefense = baseDefense;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    @Override
    public void use(CharacterStats characterStats) {
        characterStats.setBaseDefense(characterStats.getBaseDefense() + baseDefense);

        for(RuneCombatItem rune : runes) {
            rune.use(characterStats);
        }
    }

    @Override
    public void disuse(CharacterStats characterStats) {
        characterStats.setBaseDefense(characterStats.getBaseDefense() - baseDefense);

        for(RuneCombatItem rune : runes) {
            rune.disuse(characterStats);
        }
    }

}