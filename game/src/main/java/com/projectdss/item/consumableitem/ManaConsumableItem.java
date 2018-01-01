package com.proyectdss.item.consumableitem;

import com.proyectdss.Rarity;
import com.proyectdss.MainCharacter;

/**
 * @author JoseCorrero
 * 
 * Class ManaConsumableItem represents any ConsumableItem 
 * that can be used to recover only mana from inventory.
 */
public class ManaConsumableItem extends ConsumableItem {

    private int recoveryMana;

    public ManaConsumableItem(int id, String name, Rarity rarity, String description, int recoveryMana) {
        super(id, name, rarity, description);
        this.recoveryMana = recoveryMana;
    }

    @Override
    public void use(MainCharacter player) {
        player.setCurrentMana(player.getCurrentMana() + recoveryMana);
    }
    
}