package com.projectdss.output;

import com.projectdss.Item;
import com.projectdss.map.Minizone;
import com.projectdss.map.Zone;
import com.projectdss.output.OutputHandler;
import com.projectdss.Ability;
import com.projectdss.inventory.Inventory;
import com.projectdss.character.MainCharacter;
import com.projectdss.character.EnemyCharacter;
import com.projectdss.Character;
import com.projectdss.Event;
import java.util.Set;

public class OutputManager {
    private OutputHandler outputHandler;

    public OutputManager(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    public void setOutputHandler(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    public void showInventory(Inventory inventory) {
        outputHandler.showInventory(inventory);
    }

    public void showAbilities(Set<Ability> abilities) {
        outputHandler.showAbilities(abilities);
    }

    public void showHUD(MainCharacter player) {
        outputHandler.showHUD(player);
    }

    public void showCharacterInformation(Character character) {
        outputHandler.showCharacterInformation(character);
    }

    public void showMainCharacterInformation(MainCharacter player) {
        outputHandler.showMainCharacterInformation(player);
    }

    public void showEnemyInformation(EnemyCharacter enemy) {
        outputHandler.showEnemyInformation(enemy);
    }

    public void showStartingMessage(String message) {
        outputHandler.showStartingMessage(message);
    }

    public void showGameOverMessage(String message) {
        outputHandler.showGameOverMessage(message);
    }

    public void showWinMessage(String message) {
        outputHandler.showWinMessage(message);
    }

    public void showEvents(Set<Event> events) {
        outputHandler.showEvents(events);
    }

    public void showItemOptions(Item item) {
        outputHandler.showItemOptions(item);
    }

    public void showGlobalMenu() {
        outputHandler.showGlobalMenu();
    }

    public void showGlobalSettings() {
        outputHandler.showGlobalSettings();
    }

    public void showGameInformation() {
        outputHandler.showGameInformation();
    }

    public void showZoneEvents() {
        outputHandler.showZoneEvents();
    }

    public void showMinizoneEvents(Minizone minizone) {
        outputHandler.showMinizoneEvents(minizone);
    }

    public void showAdjacentMinizones(Minizone minizone) {
        outputHandler.showAdjacentMinizones(minizone);
    }

    public void showAdjacentZones(Zone zone) {
        outputHandler.showAdjacentZones(zone);
    }
}