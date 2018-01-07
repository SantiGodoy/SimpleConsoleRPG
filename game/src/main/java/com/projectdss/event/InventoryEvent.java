package com.projectdss.event;

import com.projectdss.Event;
import com.projectdss.Item;
import com.projectdss.inventory.Inventory;

/**
 * InventoryEvent.java
 * 
 * @author Santiago Godoy Poce
 */
public class InventoryEvent extends Event {
    public InventoryEvent(int id, String description) {
        super(id, description);
    }

    public void run(EventParameter eventParameter) {
        int itemSelected;

        do {
            Inventory inventory = eventParameter.getPlayerInventory();
            eventParameter.getOutput().showInventory(inventory);
            System.out.println("Selecciona un objeto del inventario ó 0 para salir: ");
            itemSelected = eventParameter.getInput(1, eventParameter.getPlayerInventory().size());
            if(itemSelected != 0) {
                Item item = inventory.searchItem(itemSelected - 1);
                eventParameter.getOutput().showItemOptions(item);
                int optionSelected = eventParameter.getInput(1, 4);
                eventParameter.getItemInput(item, inventory, eventParameter.getPlayer().getStats(), 
                    optionSelected);
            }
        } while(itemSelected != 0);
    }
}