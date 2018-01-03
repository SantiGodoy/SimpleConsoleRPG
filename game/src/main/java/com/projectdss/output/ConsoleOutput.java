package com.projectdss.output;

import com.projectdss.event.InventoryEvent;
import com.projectdss.inventory.Inventory;
import com.projectdss.character.MainCharacter;
import com.projectdss.map.Minizone;
import com.projectdss.character.Enemy;
import com.projectdss.Character;
import com.projectdss.Event;
import com.projectdss.inventory.InventoryEvent;
import com.proyectdss.Item;
import com.projectdss.Ability;
import java.util.Set;

public abstract class ConsoleOutput implements OutputHandler {
    @Override
    public void showInventory(Inventory inventory) {
        for(Item i: inventory)
            System.out.println(i.getId() + "- " + i.getName() + " (" + i.getRarity() + ")");
        showInventoryEvents(inventory.getInventoryEvents());
    }

    @Override
    public void showAbilities(Ability abilities) {
        for(Ability a: abilities)
            System.out.println(a.getId() + "- " + a.getName() + " (" + a.getDescription() + ")" + 
        " [" + a.getNecessaryMana() + "]");
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
    public void showEnemyInformation(Enemy enemy) {
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
    public void showEvents(Event events) {
        for(Event e : events)    
            System.out.println(e.getId() + "- " + e.getDescription());
    }

    @Override
    public void showInventoryEvents(InventoryEvent inventoryEvent) {
        for(InventoryEvent ie : inventoryEvent)
            System.out.println(ie.getId() + "- " + ie.getDescription());
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
}