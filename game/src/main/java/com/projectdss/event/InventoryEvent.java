package com.projectdss.event;

import com.projectdss.Event;
import com.projectdss.Item;
import com.projectdss.inventory.Inventory;

/**
 * 
 */
public class InventoryEvent extends Event {
    public InventoryEvent(int id, String description) {
        super(id, description);
    }

    public void run(EventParameter eventParameter) {
        int itemSelected;

        do {
            eventParameter.getOutput().showInventory(eventParameter.getPlayerInventory());
            System.out.println("Selecciona un objeto del inventario ó 0 para salir: ");
            itemSelected = eventParameter.getInput();
            if(itemSelected != 0) {
                Inventory inventory = eventParameter.getPlayerInventory();
                Item item = inventory.searchItem(itemSelected - 1);
                eventParameter.getOutput().showItemOptions(item);
                int optionSelected = eventParameter.getInput();
                eventParameter.getItemInput(item, inventory, optionSelected);
            }
        } while(itemSelected != 0);
    }
}