package com.projectdss.output;

import com.projectdss.output.OutputHandler;
import com.projectdss.Ability;
import com.projectdss.inventory.Inventory;
import com.projectdss.character.MainCharacter;
import com.projectdss.character.EnemyCharacter;
import com.projectdss.Character;
import com.projectdss.Event;
import com.projectdss.inventory.InventoryAction;
import java.util.Set;

public class OutputManager {
    private OutputHandler outputHandler;

    public OutputManager(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    public void setOutputHandler(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    void showInventory(Inventory inventory) {
        outputHandler.showInventory(inventory);
    }

    void showAbilities(Set<Ability> abilities) {
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

    void showEnemyInformation(EnemyCharacter enemy) {
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

    void showEvents(Set<Event> events) {
        outputHandler.showEvents(events);
    }

    void showInventoryActions(Set<InventoryAction> inventoryAction) {
        outputHandler.showInventoryEvents(inventoryAction);
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