package com.projectdss.output;

import com.projectdss.output.OutputHandler;
import com.projectdss.Ability;
import com.projectdss.inventory.Inventory;
import com.projectdss.character.MainCharacter;
import com.projectdss.character.Enemy;
import com.projectdss.Character;
import com.projectdss.Event;
import com.projectdss.inventory.InventoryEvent;

public class OutputManager {
    private OutputHandler outputHandler;

    void showInventory(Inventory inventory) {
        outputHandler.showInventory(inventory);
    }

    void showAbilities(Ability abilities) {
        outputHandler.showAbilities(abilities);
    }

    void showHUD(MainCharacter player) {
        outputHandler.showHUD(player);
    }

    void showCharacterInformation(Character character) {
        outputHandler.showCharacterInformation(character);
    }

    void showMainCharacterInformation(MainCharacter player) {
        outputHandler.showMainCharacterInformation(player);
    }

    void showEnemyInformation(Enemy enemy) {
        outputHandler.showEnemyInformation(enemy);
    }

    void showStartingMessage(String message) {
        outputHandler.showStartingMessage(message);
    }

    void showGameOverMessage(String message) {
        outputHandler.showGameOverMessage(message);
    }

    void showWinMessage(String message) {
        outputHandler.showWinMessage(message);
    }

    void showEvents(Event events) {
        outputHandler.showEvents(events);
    }

    void showInventoryEvents(InventoryEvent inventoryEvent) {
        outputHandler.showInventoryEvents(inventoryEvent);
    }

    void showGlobalMenu() {
        outputHandler.showGlobalMenu();
    }

    void showGlobalSettings() {
        outputHandler.showGlobalSettings();
    }

    void showGameInformation() {
        outputHandler.showGameInformation();
    }
}