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
            System.out.println(counter + ". " + a.getName() + " (" + a.getDescription() + ")" + 
                " [" + a.getNecessaryMana() + "]");
            ++counter;
        }
    }
    
    @Override
    public abstract void showHUD(MainCharacter player);

    @Override
    public void showCharacterInformation(Character character) {
        System.out.println("Name: " + character.getName() +
        "\nLevel: " + character.getLevel() +
        "\nHealth: " + character.getCurrentHealth() + "/" + character.getMaxHealth() +
        "\nMana: " + character.getCurrentMana() + "/" + character.getMaxMana() +
        "\nStrength: " + character.getStrength() +
        "\nDefense: " + character.getDefense() +
        "\nAgility: " + character.getAgility() +
        "\nElement Type: " + character.getType());
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
    public void showEvents(Set<Event> events) {
        int counter = 1;
        for(Event e : events) {   
            System.out.println(counter + ". " + e.getDescription());
            ++counter;
        }
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
}