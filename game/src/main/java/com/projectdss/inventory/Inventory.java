package com.projectdss.inventory;

import java.util.List;
import com.projectdss.Item;

/**
 * @author JoseCorrero
 * 
 * Class Inventory.
 */
public class Inventory {

    private List<Item> items;
    private InventoryManager inventoryManager;

    public Inventory(List<Item> items, InventoryManager inventoryManager) {
        this.items = items;
        this.inventoryManager = inventoryManager;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }
    
    public int size() {
        return items.size();
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

}