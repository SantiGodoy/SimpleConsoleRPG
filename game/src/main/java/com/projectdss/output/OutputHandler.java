package com.projectdss.output;

import com.projectdss.Item;
import com.projectdss.character.EnemyCharacter;
import com.projectdss.inventory.Inventory;
import com.projectdss.character.MainCharacter;
import com.projectdss.Event;
import com.projectdss.Ability;
import com.projectdss.Character;

import com.projectdss.item.ConsumableItem;
import com.projectdss.item.combatitem.EquipableCombatItem;
import com.projectdss.item.combatitem.RuneCombatItem;
import com.projectdss.map.Minizone;
import com.projectdss.map.World;
import com.projectdss.map.Zone;
import java.util.Set;

/**
 * OutputHandler.java
 * 
 * @author Santiago Godoy Poce
 */
public interface OutputHandler {
    void showInventory(Inventory inventory);
    void showAbilities(Set<Ability> abilities);
    void showStartingMessage(String message);
    void showGameOverMessage(String message);
    void showWinMessage(String message);
    int showEvents(Event[] events);
    int showItemOptions(ConsumableItem item);
    int showItemOptions(EquipableCombatItem item);
    int showItemOptions(RuneCombatItem item);
    void showGlobalMenu();
    void showGlobalSettings();
    void showGameInformation();
    int showAdjacentMinizones(Minizone minizone);
    int showAdjacentZones(Zone zone);
    void showStartBattleMessage(EnemyCharacter enemy);
    void showBattleState(MainCharacter player, EnemyCharacter enemy);
    void showCombatOptions();
    int showAbilitiesCombat(MainCharacter player);
    void showTargetOptions(MainCharacter player, EnemyCharacter enemy);
    void showUseAbility(Character player1, Character player2, 
        Ability ability, int abilityPower);
    void showRunAway();
    void showWinnerBattleMessage(EnemyCharacter enemy);
    void showLoserBattleMessage(EnemyCharacter enemy);
    void showUseAttack(Character player1, Character player2, int appliedDamage);
    void showXPGain(int xpDrop, int levelUp);
    void showLevelUpOptions(MainCharacter player);
    void showItemGain(Item item);
    void showMessage(String message);
    void showWorldInformation(MainCharacter player, World world);
    void showSaveLoadExitOptions();

}