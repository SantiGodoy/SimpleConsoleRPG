package com.projectdss.output;

import com.projectdss.Item;
import com.projectdss.character.EnemyCharacter;
import com.projectdss.inventory.Inventory;
import com.projectdss.character.MainCharacter;
import com.projectdss.character.EnemyCharacter;
import com.projectdss.Event;
import com.projectdss.Ability;
import com.projectdss.Character;

import com.projectdss.map.Minizone;
import com.projectdss.map.Zone;
import java.util.Set;

public interface OutputHandler {
    void showInventory(Inventory inventory);
    void showAbilities(Set<Ability> abilities);
    void showHUD(MainCharacter player);
    void showCharacterInformation(Character character);
    void showMainCharacterInformation(MainCharacter player);
    void showEnemyInformation(EnemyCharacter enemy);
    void showStartingMessage(String message);
    void showGameOverMessage(String message);
    void showWinMessage(String message);
    void showEvents(Set<Event> events);
    void showItemOptions(Item item);
    void showGlobalMenu();
    void showGlobalSettings();
    void showGameInformation();
    void showZoneEvents();
    void showMinizoneEvents(Minizone minizone);
    void showAdjacentMinizones(Minizone minizone);
    void showAdjacentZones(Zone zone);
}