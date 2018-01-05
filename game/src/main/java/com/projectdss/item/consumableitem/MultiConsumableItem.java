package com.projectdss.item.consumableitem;

import com.projectdss.Rarity;
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

    public MultiConsumableItem(int id, String name, Rarity rarity, String description, int recoveryHealth, int recoveryMana) {
        super(id, name, rarity, description);
        this.recoveryHealth = recoveryHealth;
        this.recoveryMana = recoveryMana;
    }

    @Override
    public void use(CharacterStats characterStats) {
        characterStats.setCurrentHealth(characterStats.getCurrentHealth() + recoveryHealth);
        characterStats.setCurrentMana(characterStats.getCurrentMana() + recoveryHealth);
    }

}