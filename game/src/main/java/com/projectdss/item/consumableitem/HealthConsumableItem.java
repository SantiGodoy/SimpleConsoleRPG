package com.projectdss.item.consumableitem;

import com.projectdss.Rarity;
import com.projectdss.ElementType;
import com.projectdss.CharacterStats;
import com.projectdss.item.ConsumableItem;

/**
 * @author JoseCorrero
 * 
 * Class HealthConsumableItem represents any ConsumableItem 
 * that can be used to recover only health from inventory.
 */
public class HealthConsumableItem extends ConsumableItem {

    private final int recoveryHealth;

    public HealthConsumableItem(String name, Rarity rarity, String description, int recoveryHealth) {
        super(name, rarity, description);
        this.recoveryHealth = recoveryHealth;
    }

    @Override
    public void use(CharacterStats characterStats) {
        if(characterStats.getDefensiveType() == ElementType.DAMNED)
            characterStats.setCurrentHealth(characterStats.getCurrentHealth() + 
                (int)(recoveryHealth * ElementType.getElementDamage(ElementType.PURE, ElementType.DAMNED)));
        else
            characterStats.setCurrentHealth(characterStats.getCurrentHealth() + recoveryHealth);
    }

}