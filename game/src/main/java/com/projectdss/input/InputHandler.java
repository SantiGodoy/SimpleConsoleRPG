package com.projectdss.input;

import com.projectdss.CharacterStats;
import com.projectdss.Item;
import com.projectdss.inventory.Inventory;
import com.projectdss.item.ConsumableItem;
import com.projectdss.item.combatitem.EquipableCombatItem;
import com.projectdss.item.combatitem.RuneCombatItem;

/**
 * InputHandler.java
 * 
 * @author Santiago Godoy Poce
 */
public interface InputHandler {
    int getInput(int firstOption, int lastOption);
    void getItemInput(EquipableCombatItem item, Inventory inventory, CharacterStats characterStats, int option);
    void getItemInput(ConsumableItem item, Inventory inventory, CharacterStats characterStats, int option);
    void getItemInput(RuneCombatItem item, Inventory inventory, CharacterStats characterStats, int option);
}