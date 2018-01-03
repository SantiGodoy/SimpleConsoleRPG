package com.projectdss.item.consumableitem;

import com.projectdss.Rarity;
import com.projectdss.Character;
import com.projectdss.item.ConsumableItem;

/**
 * @author JoseCorrero
 * 
 * Class HealthConsumableItem represents any ConsumableItem 
 * that can be used to recover only health from inventory.
 */
public class HealthConsumableItem extends ConsumableItem {

    private final int recoveryHealth;

    public HealthConsumableItem(int id, String name, Rarity rarity, String description, int recoveryHealth) {
        super(id, name, rarity, description);
        this.recoveryHealth = recoveryHealth;
    }

    @Override
    public void use(Character player) {
        player.setCurrentHealth(player.getCurrentHealth() + recoveryHealth);
    }

}