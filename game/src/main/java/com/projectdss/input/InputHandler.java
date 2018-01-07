package com.projectdss.input;

import com.projectdss.CharacterStats;
import com.projectdss.Item;
import com.projectdss.inventory.Inventory;

/**
 * InputHandler.java
 * 
 * @author Santiago Godoy Poce
 */
public interface InputHandler {
    int getInput(int firstOption, int lastOption);
    void getItemInput(Item item, Inventory inventory, CharacterStats characterStats, int option);
}