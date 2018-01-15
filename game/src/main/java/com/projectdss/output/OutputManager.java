package com.projectdss.output;

import com.projectdss.Item;
import com.projectdss.item.ConsumableItem;
import com.projectdss.item.combatitem.EquipableCombatItem;
import com.projectdss.item.combatitem.RuneCombatItem;
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

/**
 * OutputManager.java
 * 
 * @author Santiago Godoy Poce
 */
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

    public void showEvents(Event[] events) {
        outputHandler.showEvents(events);
    }

    public void showItemOptions(ConsumableItem item) {
        outputHandler.showItemOptions(item);
    }

    public void showItemOptions(EquipableCombatItem item) {
        outputHandler.showItemOptions(item);
    }

    public void showItemOptions(RuneCombatItem item) {
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

    public void showStartBattleMessage(EnemyCharacter enemy) {
        outputHandler.showStartBattleMessage(enemy);
    }

    public void showBattleState(MainCharacter player, EnemyCharacter enemy) {
        outputHandler.showBattleState(player, enemy);
    }

    public void showCombatOptions() {
        outputHandler.showCombatOptions();
    }

    public int showAbilitiesCombat(MainCharacter player) {
        return outputHandler.showAbilitiesCombat(player);
    }

    public void showTargetOptions(MainCharacter player, EnemyCharacter enemy) {
        outputHandler.showTargetOptions(player, enemy);
    }

    public void showUseAbility(Character player1, Character player2, 
        Ability ability, int abilityPower) {
            outputHandler.showUseAbility(player1, player2, ability, abilityPower);
        }

    public void showRunAway() {
        outputHandler.showRunAway();
    }

    public void showWinnerBattleMessage(MainCharacter player, EnemyCharacter enemy) {
        outputHandler.showWinnerBattleMessage(enemy);
    }

    public void showLoserBattleMessage(MainCharacter player, EnemyCharacter enemy) {
        outputHandler.showLoserBattleMessage(enemy);
    }

    public void showUseAttack(Character player1, Character player2, int appliedDamage) {
        outputHandler.showUseAttack(player1, player2, appliedDamage);
    }

    public void showXPGain(int xpDrop, int levelUp) {
        outputHandler.showXPGain(xpDrop, levelUp);
    }

    public void showLevelUpOptions(MainCharacter player) {
        outputHandler.showLevelUpOptions(player);
    }

    public void showItemGain(Item item) {
        outputHandler.showItemGain(item);
    }

    public void showJoke(String message) {
        outputHandler.showJoke(message);
    }
}