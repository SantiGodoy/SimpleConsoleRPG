package com.projectdss.event.minizoneevent;

import java.util.Map;
import java.util.Random;
import com.projectdss.Item;
import com.projectdss.ElementType;
import com.projectdss.Character;
import com.projectdss.CharacterStats;
import com.projectdss.character.MainCharacter;
import com.projectdss.character.EnemyCharacter;
import com.projectdss.inventory.Inventory;
import com.projectdss.Ability;
import com.projectdss.Event;
import com.projectdss.event.MinizoneEvent;
import com.projectdss.event.EventParameter;
import com.projectdss.output.OutputManager;

/**
 * @author JoseCorrero
 * 
 * 
 */
public class CombatMinizoneEvent extends MinizoneEvent {

    private static final double AGILITY_RUN = 1.5;
    private static final int NUM_STATS = 6;
    private static final int NUM_OPTIONS_STATS = 3;
    private static final int NUM_OPTIONS_COMBAT = 3;

    public CombatMinizoneEvent(){}

    public CombatMinizoneEvent(String description) {
        super(description);
    }

    public void run(EventParameter eventParameter) {
        OutputManager output = eventParameter.getOutput();

        MainCharacter player = eventParameter.getPlayer();
        EnemyCharacter enemy = player.getMinizone().getEnemy();

        output.showStartBattleMessage(enemy);

        int option = 0,
            target = 0;
        Ability ability = null;

        output.showBattleState(player, enemy);

        while(player.isAlive() && enemy.isAlive()) {
            do {
                output.showCombatOptions();

                option = eventParameter.getInput(1, NUM_OPTIONS_COMBAT);

                switch(option) {
                    case 2: int numAbilities = 0,
                                selectedAbility = 0;
                            do {
                                numAbilities = output.showAbilitiesCombat(player);
                                selectedAbility = eventParameter.getInput(0, numAbilities);
                                if(selectedAbility == 0)
                                    option = 0;
                                else {
                                    output.showTargetOptions(player, enemy);
                                    target = eventParameter.getInput(0, 2);
                                }
                            } while(option != 0 && target == 0);
                            
                            if(option != 0)
                                ability = player.searchAvailableAbility(selectedAbility);
                        break;
                    default:
                }
            } while(option < 1 || option > NUM_OPTIONS_COMBAT);

            output.showBattleState(player, enemy);
            
            boolean turn = enemy.getCharacterStats().getAgility() > player.getCharacterStats().getAgility();

            if(turn) {
                enemyAttack(enemy, player, output);
                output.showBattleState(player, enemy);
            }

            if(player.isAlive()) {
                switch(option) {
                    case 1: attack(player, enemy, output);
                        break;
                    case 2: int abilityDamage;
                            if(target == 1) {
                                abilityDamage = ability.use(player.getCharacterStats(), player.getCharacterStats());
                                output.showUseAbility(player, enemy, ability, abilityDamage);
                            } else {
                                abilityDamage = ability.use(player.getCharacterStats(), enemy.getCharacterStats());
                                output.showUseAbility(player, player, ability, abilityDamage);
                            }
                            player.getCharacterStats().setCurrentMana(
                                player.getCharacterStats().getCurrentMana() - ability.getNecessaryMana());
                        break;
                    case 3: if(player.getCharacterStats().getAgility() * AGILITY_RUN > enemy.getCharacterStats().getAgility()) {
                                output.showRunAway();
                                restoreEnemyStats(enemy);
                                return;
                            }
                        break;
                    default: 
                }
            }

            output.showBattleState(player, enemy);

            if(!turn && enemy.isAlive()) {
                enemyAttack(enemy, player, output);
                output.showBattleState(player, enemy);
            }
        }

        if(!enemy.isAlive()) {
            output.showWinnerBattleMessage(player, enemy);
            getRewards(eventParameter, enemy);
            restoreEnemyStats(enemy);
        } else {
            output.showLoserBattleMessage(player, enemy);
        }
    }

    private void attack(Character player1, Character player2, OutputManager output) {
        CharacterStats statsPlayer1 = player1.getCharacterStats(),
                       statsPlayer2 = player2.getCharacterStats();
        int appliedDamage = statsPlayer1.getBaseDamage() - statsPlayer2.getBaseDefense();

        if(appliedDamage > 0) {
            appliedDamage *= ElementType.getElementDamage(statsPlayer1.getOffensiveType(), statsPlayer2.getDefensiveType());
            
            if(statsPlayer1.getLifesteal() > 0)
                statsPlayer1.setCurrentHealth(statsPlayer1.getCurrentHealth() + (appliedDamage * statsPlayer1.getLifesteal() / 100));
        }

        if(statsPlayer1.getTrueDamage() > 0)
            appliedDamage += statsPlayer1.getTrueDamage();

        if(appliedDamage > 0)
            statsPlayer2.setCurrentHealth(statsPlayer2.getCurrentHealth() - appliedDamage);

        output.showUseAttack(player1, player2, appliedDamage);
    }

    private void enemyAttack(EnemyCharacter enemy, MainCharacter player, OutputManager output) {
        int abilitiesSize = enemy.getAbilities().size();
        if(abilitiesSize > 0) {
            Random random = new Random();
            int action = random.nextInt(abilitiesSize + 1);
            if(action != 0) {
                Ability ability = enemy.searchAbility(action);
                int abilityDamage = ability.use(enemy.getCharacterStats(), player.getCharacterStats());
                output.showUseAbility(enemy, player, ability, abilityDamage);
                enemy.getCharacterStats().setCurrentMana(enemy.getCharacterStats().getCurrentMana() - ability.getNecessaryMana());
                return;
            }
        }

        attack(enemy, player, output);
    }

    private void restoreEnemyStats(EnemyCharacter enemy) {
        CharacterStats enemyStats = enemy.getCharacterStats();
        enemyStats.setCurrentHealth(enemyStats.getMaxHealth());
        enemyStats.setCurrentMana(enemyStats.getMaxMana());
    }

    private void getRewards(EventParameter eventParameter, EnemyCharacter enemy) {
        MainCharacter player = eventParameter.getPlayer();
        OutputManager output = eventParameter.getOutput();

        int levelUp = player.addXP(enemy.getxpDrop());
        output.showXPGain(enemy.getxpDrop(), levelUp);

        while(levelUp > 0) {
            int option;
            int[] options = new int[NUM_OPTIONS_STATS];
            do {
                option = -1;
                output.showLevelUpOptions(player);
                for(int i = 0; i < NUM_OPTIONS_STATS && option != 0; ++i)
                    options[i] = option = eventParameter.getInput(0, NUM_STATS);

            } while(option != 0);
            
            player.incrementLevel(options);
            --levelUp;
        }

        if(enemy.getItemsDrop().size() > 0) {
            Random random = new Random();
            int dropProb = random.nextInt(100);
            Map<Item, Integer> items = enemy.getItemsDrop();
            Inventory inventory = player.getInventory();
            for(Item item : items.keySet()) {
                if(dropProb < items.get(item).intValue()) {
                    inventory.addItem(item);
                    output.showItemGain(item);
                }
            }
        }
    }

}