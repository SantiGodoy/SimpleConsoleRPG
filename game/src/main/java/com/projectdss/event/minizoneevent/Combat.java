package com.projectdss.event.minizoneevent;

import com.projectdss.Ability;
import com.projectdss.Character;
import com.projectdss.CharacterStats;
import com.projectdss.ElementType;
import com.projectdss.Event;
import com.projectdss.ability.HealingAbility;
import com.projectdss.ability.OffensiveAbility;
import com.projectdss.event.MinizoneEvent;
import com.projectdss.event.EventParameter;

/**
 * 
 */
public class Combat extends MinizoneEvent {

    public Combat(int id, String description) {
        super(id, description);
    }

    public void run(EventParameter eventParameter) {
        eventParameter.getOutput().showStartBattleMessage(eventParameter.getEnemy());

        Character player = eventParameter.getPlayer(),
                  enemy  = eventParameter.getEnemy();

        boolean run = false;
        int option;
        Ability ability;
        int target;

        while((player.isAlive() && enemy.isAlive()) && !run) {
            do {
                eventParameter.getOutput().showBattleState(player, enemy);
                eventParameter.getOutput().showCombatOptions();

                option = eventParameter.getInput();

                switch(option) {
                    case 2: eventParameter.getOutput().showAbilities(player.getAbilities());
                            int selectedAbility = eventParameter.getInput();
                            if(selectedAbility == 0)
                                option = 0;
                            else {
                                ability = eventParameter.getPlayer().searchAbility(selectedAbility);
                                eventParameter.getOutput().showTargetOptions(player, enemy);
                                target = eventParameter.getInput();
                            }
                        break;
                    case 3: //Inventory
                        break;
                    default:
                }
            } while(option < 1 || option > 4);

            if(player.getStats().getAgility() >= enemy.getStats().getAgility()) {
                switch(option) {
                    case 1: attack(player.getStats(), enemy.getStats());
                        break;
                    case 2: if(target == 1)
                                ability.use(player.getStats(), player.getStats());
                            else
                                ability.use(player.getStats(), enemy.getStats());
                        break;
                    case 3: //Inventory
                        break;
                    case 4: if(player.getStats().getAgility() * 2 > enemy.getStats().getAgility())
                                run = true;
                        break;
                    default: 
                }
                
                if(enemy.isAlive())
                    enemyAttack(enemy, player);
            } else {
                enemyAttack(enemy, player);

                if(player.isAlive())
                    switch(option) {
                        case 1: attack(player.getStats(), enemy.getStats());
                            break;
                        case 2: if(target == 1)
                                    ability.use(player.getStats(), player.getStats());
                                else
                                    ability.use(player.getStats(), enemy.getStats());
                            break;
                        case 3: //Inventory
                            break;
                        case 4: if(player.getStats().getAgility() * 2 > enemy.getStats().getAgility())
                                    run = true;
                            break;
                        default: 
                    }
            }
        }

        if(!enemy.isAlive()) {
            eventParameter.getOutput().showWinnerBattleMessage(player, enemy);
            getRewards(eventParameter);
        }
        else {
            eventParameter.getOutput().showLosserBattleMessage(player, enemy);
            /////////////
        }
    }

    private void attack(CharacterStats player1, CharacterStats player2) {
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
    }

    private Ability selectAbility(EventParameter eventParameter) {
        eventParameter.getOutput().showAbilities(player.getAbilities());
        int selectedAbility = eventParameter.getInput();
        if(selectedAbility == 0)
            return null;
        else
            return eventParameter.getPlayer().searchAbility(selectedAbility);
    }

    private void enemyAttack(Character enemy, Character player) {
        /////////////////////
    }

    private void getRewards(EventParameter eventParameter) {
        eventParameter.getPlayer().addXP(eventParameter.getEnemy().getXPDrop());
        // getItemsDrop.
    }

}