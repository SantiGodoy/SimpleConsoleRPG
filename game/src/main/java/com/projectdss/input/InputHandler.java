package com.projectdss.input;

import com.projectdss.Item;
import com.projectdss.inventory.Inventory;

public interface InputHandler {
    int getInput();
    void getItemInput(Item item, Inventory inventory, int option);
}