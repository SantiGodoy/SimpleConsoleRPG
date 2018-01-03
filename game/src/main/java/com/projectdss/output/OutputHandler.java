package com.projectdss.output;

import com.projectdss.inventory.Inventory;
import com.projectdss.character.MainCharacter;
import com.projectdss.character.Enemy;
import com.projectdss.Event;
import com.projectdss.Ability;
import com.projectdss.inventory.InventoryEvent;
import com.projectdss.Character;

import java.util.Set;

public interface OutputHandler {
    void showInventory(Inventory inventory);
    void showAbilities(Ability abilities);
    void showHUD(MainCharacter player);
    void showCharacterInformation(Character character);
    void showMainCharacterInformation(MainCharacter player);
    void showEnemyInformation(Enemy enemy);
    void showStartingMessage(String message);
    void showGameOverMessage(String message);
    void showWinMessage(String message);
    void showEvents(Event events);
    void showInventoryEvents(InventoryEvent inventoryEvent);
    void showGlobalMenu();
    void showGlobalSettings();
    void showGameInformation();
}