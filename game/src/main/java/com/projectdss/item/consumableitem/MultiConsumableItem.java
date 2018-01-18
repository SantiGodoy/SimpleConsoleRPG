package com.projectdss.item.consumableitem;

import com.projectdss.Rarity;
import com.projectdss.ElementType;
import com.projectdss.CharacterStats;
import com.projectdss.item.ConsumableItem;

/**
 * @author JoseCorrero
 * 
 * Class MultiConsumableItem represents any ConsumableItem 
 * that can be used to recover health and mana, at the same item, from inventory.
 */
public class MultiConsumableItem extends ConsumableItem {

    private final int recoveryHealth;
    private final int recoveryMana;

    public MultiConsumableItem(String name, Rarity rarity, String description, int recoveryHealth, int recoveryMana) {
        super(name, rarity, description);
        this.recoveryHealth = recoveryHealth;
        this.recoveryMana = recoveryMana;
    }

    @Override
    public void use(CharacterStats characterStats) {
        if(characterStats.getDefensiveType() == ElementType.DAMNED)
            characterStats.setCurrentHealth(characterStats.getCurrentHealth() + 
                (int)(recoveryHealth * ElementType.getElementDamage(ElementType.PURE, ElementType.DAMNED)));
        else
            characterStats.setCurrentHealth(characterStats.getCurrentHealth() + recoveryHealth);
        characterStats.setCurrentMana(characterStats.getCurrentMana() + recoveryMana);
    }

}