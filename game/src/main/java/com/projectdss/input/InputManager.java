package com.projectdss.input;

import com.projectdss.CharacterStats;
import com.projectdss.Item;
import com.projectdss.inventory.Inventory;

public class InputManager {
    private InputHandler inputHandler;

    public InputManager(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void setInputHandler(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public int getInput() {
        return inputHandler.getInput();
    }

    public void getItemInput(Item item, Inventory inventory, CharacterStats characterStats, int option) {
        inputHandler.getItemInput(item, inventory, characterStats, option);
    }
}