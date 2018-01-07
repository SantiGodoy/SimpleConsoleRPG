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
import com.projectdss.ability.HealingAbility;
import com.projectdss.ability.OffensiveAbility;
import com.projectdss.Event;
import com.projectdss.event.MinizoneEvent;
import com.projectdss.event.EventParameter;
import com.projectdss.output.OutputManager;

/**
 * @author JoseCorrero
 * 
 * 
 */
public class CombatEvent extends MinizoneEvent {

    private static final double AGILITY_RUN = 1.5;
    private static final int NUM_STATS = 6;
    private static final int NUM_OPTIONS_STATS = 3;

    public CombatEvent(int id, String description) {
        super(id, description);
    }

    public void run(EventParameter eventParameter) {
        OutputManager output = eventParameter.getOutput();
        output.showStartBattleMessage(eventParameter.getEnemy());

        MainCharacter player = eventParameter.getPlayer();
        EnemyCharacter enemy = eventParameter.getEnemy();

        int option = 0,
            target = 0;
        Ability ability;

        output.showBattleState(player, enemy);

        while(player.isAlive() && enemy.isAlive()) {
            do {
                output.showCombatOptions();

                option = eventParameter.getInput(1, 4);

                switch(option) {
                    case 2: int numAbilities = 0,
                                selectedAbility = 0;
                            do {
                                numAbilities = output.showAbilitiesCombat(player.getAbilities());
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
                    case 3: //Inventory
                        break;
                    default:
                }
            } while(option < 1 || option > 4);

            output.showBattleState(player, enemy);
            
            boolean turn = enemy.getStats().getAgility() > player.getStats().getAgility();

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
                                abilityDamage = ability.use(player.getStats(), player.getStats());
                                output.showUseAbility(player, enemy, ability, abilityDamage);
                            } else {
                                abilityDamage = ability.use(player.getStats(), enemy.getStats());
                                output.showUseAbility(player, player, ability, abilityDamage);
                            }
                            player.getStats().setCurrentMana(
                                player.getStats().getCurrentMana() - ability.getNecessaryMana());
                        break;
                    case 3: //Inventory
                        break;
                    case 4: if(player.getStats().getAgility() * AGILITY_RUN > enemy.getStats().getAgility()) {
                                output.showRunAway();
                                //////////// Restore enemy stats.
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
            getRewards(eventParameter);
            ///////////// Remove enemy from its minizone.
        } else {
            output.showLosserBattleMessage(player, enemy);
            ///////////// Consequences?
            ///////////// Restore enemy stats.
        }
    }

    private void attack(Character player1, Character player2, OutputManager output) {
        CharacterStats statsPlayer1 = player1.getStats(),
                       statsPlayer2 = player2.getStats();
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
                Ability ability = enemy.searchAvailableAbility(action);
                int abilityDamage = ability.use(enemy.getStats(), player.getStats());
                output.showUseAbility(enemy, player, ability, abilityDamage);
                enemy.getStats().setCurrentMana(enemy.getStats().getCurrentMana() - ability.getNecessaryMana());
                return;
            }
        }

        attack(enemy, player, output);
    }

    private void getRewards(EventParameter eventParameter) {
        MainCharacter player = eventParameter.getPlayer();
        EnemyCharacter enemy = eventParameter.getEnemy();
        OutputManager output = eventParameter.getOutput();

        int levelUp = player.addXP(enemy.getXPDrop());
        output.showXPGain(enemy.getXPDrop(), levelUp);

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