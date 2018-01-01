package com.proyectdss.item.consumableitem;

import com.proyectdss.Rarity;
import com.proyectdss.MainCharacter;

/**
 * @author JoseCorrero
 * 
 * Class HealthConsumableItem represents any ConsumableItem 
 * that can be used to recover only health from inventory.
 */
public class HealthConsumableItem extends ConsumableItem {

    private int recoveryHealth;

    public HealthConsumableItem(int id, String name, Rarity rarity, String description, int recoveryHealth) {
        super(id, name, rarity, description);
        this.recoveryHealth = recoveryHealth;
    }

    @Override
    public void use(MainCharacter player) {
        player.setCurrentHealth(player.getCurrentHealth() + recoveryHealth);
    }

}