package com.projectdss.item.consumableitem;

import com.projectdss.Rarity;
import com.projectdss.CharacterStats;
import com.projectdss.item.ConsumableItem;

/**
 * @author JoseCorrero
 * 
 * Class ManaConsumableItem represents any ConsumableItem 
 * that can be used to recover only mana from inventory.
 */
public class ManaConsumableItem extends ConsumableItem {

    private final int recoveryMana;

    public ManaConsumableItem(int id, String name, Rarity rarity, String description, int recoveryMana) {
        super(id, name, rarity, description);
        this.recoveryMana = recoveryMana;
    }

    @Override
    public void use(CharacterStats characterStats) {
        characterStats.setCurrentMana(characterStats.getCurrentMana() + recoveryMana);
    }
    
}