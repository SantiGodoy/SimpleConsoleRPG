package com.projectdss.event;

import com.projectdss.inventory.InventoryManager;
import com.projectdss.item.ConsumableItem;
import com.projectdss.item.combatitem.EquipableCombatItem;
import com.projectdss.item.combatitem.RuneCombatItem;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public void run(EventParameter eventParameter) {
        Inventory inventory = eventParameter.getPlayerInventory();
        InventoryManager manager = inventory.getInventoryManager();

        ArrayList<ConsumableItem> consumables = new ArrayList<ConsumableItem>();
        ArrayList<EquipableCombatItem> equipables = new ArrayList<EquipableCombatItem>();
        ArrayList<RuneCombatItem> runes = new ArrayList<RuneCombatItem>();

        manager.getConsumables(inventory, consumables);
        manager.getEquipables(inventory, equipables);
        manager.getRunes(inventory, runes);

        int itemSelected = 0;

        do {
            eventParameter.getOutput().showInventory(inventory);
            System.out.println("Selecciona un objeto del inventario ó 0 para salir: ");
            itemSelected = eventParameter.getInput(1, inventory.size());
            if(itemSelected != 0) {
                int numOptions = 0,
                    optionSelected = 0;

                if(0 < itemSelected && itemSelected < consumables.size() + 1) {
                    ConsumableItem consumable = consumables.get(itemSelected - 1);
                    numOptions = eventParameter.getOutput().showItemOptions(consumable);
                    optionSelected = eventParameter.getInput(0, numOptions);
                    if(optionSelected != 0)
                        eventParameter.getItemInput(consumable, inventory, eventParameter.getPlayer().getStats(),
                                                    optionSelected);
                } else if(consumables.size() < itemSelected && itemSelected < equipables.size() + 1) {
                    EquipableCombatItem equipable = equipables.get(itemSelected - consumables.size() - 1);
                    numOptions = eventParameter.getOutput().showItemOptions(equipable);
                    optionSelected = eventParameter.getInput(0, numOptions);
                    if(optionSelected != 0)
                        eventParameter.getItemInput(equipable, inventory, eventParameter.getPlayer().getStats(),
                                                    optionSelected);
                } else if(consumables.size() + equipables.size() < itemSelected && 
                          itemSelected < consumables.size() + equipables.size() + 1) {
                    RuneCombatItem rune = runes.get(itemSelected - consumables.size() - equipables.size() - 1);
                    numOptions = eventParameter.getOutput().showItemOptions(rune);
                    optionSelected = eventParameter.getInput(0, numOptions);
                    if(optionSelected != 0)
                        eventParameter.getItemInput(rune, inventory, eventParameter.getPlayer().getStats(),
                                                    optionSelected);
                }
            }
        } while(itemSelected != 0);
    }
}