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

    private static final double AGILITY_MULTIPLIER = 1.5;
    private static final int LEVELING_UP_STATS = 6;

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
        boolean runAway = false;
        Ability ability;

        output.showBattleState(player, enemy);

        while((player.isAlive() && enemy.isAlive()) && !runAway) {
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

            if(player.getStats().getAgility() >= enemy.getStats().getAgility()) {
                switch(option) {
                    case 1: attack(player.getStats(), enemy.getStats(), output);
                        break;
                    case 2: int abilityDamage;
                            if(target == 1) {
                                abilityDamage = ability.use(player.getStats(), player.getStats());
                                output.showAbilityUse(player, enemy, ability, abilityDamage);
                            } else {
                                abilityDamage = ability.use(player.getStats(), enemy.getStats());
                                output.showAbilityUse(player, player, ability, abilityDamage);
                            }
                            player.getStats().setCurrentMana(
                                player.getStats().getCurrentMana() - ability.getNecessaryMana());
                        break;
                    case 3: //Inventory
                        break;
                    case 4: if(player.getStats().getAgility() * AGILITY_MULTIPLIER > enemy.getStats().getAgility())
                                runAway = true;
                        break;
                    default: 
                }

                if(!runAway) {
                    output.showBattleState(player, enemy);

                    if(enemy.isAlive()) {
                        enemyAttack(enemy, player, output);
                        output.showBattleState(player, enemy);
                    }
                }
                

            } else {
                enemyAttack(enemy, player, output);

                output.showBattleState(player, enemy);

                if(player.isAlive()) {
                    switch(option) {
                        case 1: attack(player.getStats(), enemy.getStats(), output);
                            break;
                        case 2: int abilityDamage;
                                if(target == 1) {
                                    abilityDamage = ability.use(player.getStats(), player.getStats());
                                    output.showAbilityUse(player, enemy, ability, abilityDamage);
                                } else {
                                    abilityDamage = ability.use(player.getStats(), enemy.getStats());
                                    output.showAbilityUse(player, player, ability, abilityDamage);
                                }
                                player.getStats().setCurrentMana(
                                    player.getStats().getCurrentMana() - ability.getNecessaryMana());
                            break;
                        case 3: //Inventory
                            break;
                        case 4: if(player.getStats().getAgility() * AGILITY_MULTIPLIER > enemy.getStats().getAgility())
                                    runAway = true;
                            break;
                        default: 
                    }
                    
                    output.showBattleState(player, enemy);
                }
            }
        }

        if(!enemy.isAlive()) {
            output.showWinnerBattleMessage(player, enemy);
            getRewards(eventParameter);
            ///////////// Remove enemy from its minizone.
        } else {
            output.showLosserBattleMessage(player, enemy);
            ///////////// Consequences?
        }
    }

    private void attack(CharacterStats player1, CharacterStats player2, OutputManager output) {
        int appliedDamage = player1.getBaseDamage() - player2.getBaseDefense();

        if(appliedDamage > 0) {
            appliedDamage *= ElementType.getElementDamage(player1.getOffensiveType(), player2.getDefensiveType());
            
            if(player1.getLifesteal() > 0)
                player1.setCurrentHealth(player1.getCurrentHealth() + (appliedDamage * player1.getLifesteal() / 100));
        }

        if(player1.getTrueDamage() > 0)
            appliedDamage += player1.getTrueDamage();

        if(appliedDamage > 0)
            player2.setCurrentHealth(player2.getCurrentHealth() - appliedDamage);

        output.showAttackUse(player1, player2, appliedDamage);
    }

    private void enemyAttack(EnemyCharacter enemy, MainCharacter player, OutputManager output) {
        int abilitiesSize = enemy.getAbilities().size();
        if(abilitiesSize > 0) {
            Random random = new Random();
            int action = random.nextInt(abilitiesSize + 1);
            if(action != 0) {
                Ability ability = enemy.searchAvailableAbility(action);
                int abilityDamage = ability.use(enemy.getStats(), player.getStats());
                output.showAbilityUse(enemy, player, ability, abilityDamage);
                enemy.getStats().setCurrentMana(enemy.getStats().getCurrentMana() - ability.getNecessaryMana());
                return;
            }
        }

        attack(enemy.getStats(), player.getStats(), output);
    }

    private void getRewards(EventParameter eventParameter) {
        MainCharacter player = eventParameter.getPlayer();
        EnemyCharacter enemy = eventParameter.getEnemy();
        OutputManager output = eventParameter.getOutput();

        int levelUp = player.addXP(enemy.getXPDrop());
        output.showXPGain(enemy.getXPDrop(), levelUp);
        while(levelUp > 0) {
            output.showLevelUpOptions(player);
            int option1 = eventParameter.getInput(1, LEVELING_UP_STATS),
                option2 = eventParameter.getInput(1, LEVELING_UP_STATS),
                option3 = eventParameter.getInput(1, LEVELING_UP_STATS);
            player.incrementLevel(option1, option2, option3);
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