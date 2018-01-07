package com.projectdss.output;

import com.projectdss.event.InventoryEvent;
import com.projectdss.inventory.Inventory;
import com.projectdss.character.MainCharacter;
import com.projectdss.item.CombatItem;
import com.projectdss.item.ConsumableItem;
import com.projectdss.map.Minizone;
import com.projectdss.character.EnemyCharacter;
import com.projectdss.Character;
import com.projectdss.Event;
import com.projectdss.Item;
import com.projectdss.Ability;
import com.projectdss.map.Zone;
import java.util.Set;

/**
 * ConsoleOutput.java
 * 
 * @author Santiago Godoy Poce
 */
public abstract class ConsoleOutput implements OutputHandler {
    @Override
    public void showInventory(Inventory inventory) {
        int counter = 1;
        for(Item i: inventory) {
            System.out.println(counter + ". " + i.getName() + " (" + i.getRarity() + ")");
            ++counter;
        }
    }

    @Override
    public void showAbilities(Set<Ability> abilities) {
        int counter = 1;
        for(Ability a: abilities) {
            System.out.println(counter++ + ". " + a.getName() + " (" + a.getDescription() + ")" + 
                " [" + a.getNecessaryMana() + "]");
        }
    }
    
    @Override
    public abstract void showHUD(MainCharacter player);

    @Override
    public void showCharacterInformation(Character character) {
        System.out.println("Name: " + character.getName() +
        "\nLevel: " + character.getLevel() +
        "\nHealth: " + character.getStats().getCurrentHealth() + "/" + character.getStats().getMaxHealth() +
        "\nMana: " + character.getStats().getCurrentMana() + "/" + character.getStats().getMaxMana() +
        "\nStrength: " + character.getStats().getStrength() +
        "\nDefense: " + character.getStats().getResistance() +
        "\nAgility: " + character.getStats().getAgility() +
        "\nElement Type (Offensive): " + character.getStats().getOffensiveType() + 
        "\nElement Type (Defensive): " + character.getStats().getDefensiveType());
    }

    @Override
    public void showMainCharacterInformation(MainCharacter player) {
        showCharacterInformation(player);
        System.out.println("Gender: " + player.getGender() +
        "\nExperience Points: " + player.getXP());
        showAbilities(player.getAbilities());
    }

    @Override
    public void showEnemyInformation(EnemyCharacter enemy) {
        System.out.println(enemy.getMessage());
        showCharacterInformation(enemy);
    }

    @Override
    public abstract void showStartingMessage(String message);

    @Override
    public abstract void showGameOverMessage(String message);

    @Override
    public abstract void showWinMessage(String message);

    @Override
    public void showEvents(Event[] events) {
        int counter = 0;
        for(int i = 0; i < events.length; ++i) 
            System.out.println(++counter + ". " + events[i].getDescription());
    }

    @Override
    public void showItemOptions(Item item) {
            if(item instanceof CombatItem) 
                System.out.println("1. Description\n2. Drop Item\n3. Return");
            else {
                if(item instanceof ConsumableItem)
                    System.out.println("1. Use\n2. Description\n3. Drop Item\n4. Return");
            }    
    }

    @Override
    public abstract void showGlobalMenu();

    @Override
    public void showGlobalSettings() {
        System.out.println("Settings" + 
        "\n\t1- Change to white/black screen" + 
        "\n\t2- Change to colored screen");
    }

    @Override
    public abstract void showGameInformation();

    @Override
    public void showZoneEvents() {
        System.out.println("1. Travel\n2. Return");
    }

    @Override
    public void showMinizoneEvents(Minizone minizone) {
        showEvents(minizone.getEvents());
    }

    @Override
    public void showAdjacentMinizones(Minizone minizone) {
        int counter = 1;
        for(Minizone mz : minizone.getAdjacentMinizones()) {
            System.out.println(counter + ". " + mz.getName());
            ++counter;
        }
    }

    @Override
    public void showAdjacentZones(Zone zone) {
        int counter = 1;
        for(Zone z : zone.getAdjacentZones()) {
            System.out.println(counter + ". " + z.getName());
            ++counter;
        }
    }

    @Override
    public abstract void showBattleState(MainCharacter player, EnemyCharacter enemy);

    @Override
    public abstract int showAbilitiesCombat(MainCharacter player);

    @Override
    public abstract void showWinnerBattleMessage(EnemyCharacter enemy);

    @Override
    public abstract void showLoserBattleMessage(EnemyCharacter enemy);

    @Override
    public void showStartBattleMessage(EnemyCharacter enemy) {
        System.out.println("The battle against " + enemy.getName() +  " has begun!");
    }

    @Override
    public void showCombatOptions() {
        System.out.println("What do you want to do?" +
        "\n1. Attack" + 
        "\n2. Select target" + 
        "\n3. Inventory" +
        "\n4. Run away");
    }

    @Override
    public void showTargetOptions(MainCharacter player, EnemyCharacter enemy) {
        System.out.println("1. " + player.getName() +
        "\n2. " + enemy.getName());
    }

    @Override
    public void showUseAbility(Character player1, Character player2, 
        Ability ability, int abilityDamage) {
            System.out.println(player1.getName() + " used the ability '" + ability.getName() + 
            "' on " + player2.getName() + " dealing " + abilityDamage + " damage");
        }

    @Override
    public void showRunAway() {
        System.out.println("Wow! You got out of that battle!");
    }

    @Override
    public void showUseAttack(Character player1, Character player2, int appliedDamage) {
        System.out.println(player1.getName() + " attacked to " + player2.getName() + " dealing " +
        appliedDamage + " damage!");
    }
    
    @Override
    public void showXPGain(int xpDrop, int levelUp) {
        System.out.print("You earned " + xpDrop + " experience points ");
        if(levelUp == 0)
            System.out.println("but you didn't reach the next level :(");
        else
            System.out.println("and you have got " + levelUp + " levels");
    }
    
    @Override
    public void showLevelUpOptions() {
        System.out.println("Select the stat which you want to level: " +
        "\n1. Maximum health" + 
        "\n2. Maximum mana" +
        "\n3. Strength" +
        "\n4. Magical power" +
        "\n5. Resistance" +
        "\n6. Agility");
    }
    
    @Override
    public void showItemGain(Item item) {
        System.out.println("You picked up a " + item.getName() + " (" + item.getRarity() + ")");
    }

    @Override
    public void showJoke(String message) {
        System.out.println(message);
    }
}