package com.projectdss.event;

import com.projectdss.CharacterStats;
import com.projectdss.Item;
import com.projectdss.inventory.Inventory;
import com.projectdss.character.MainCharacter;
import com.projectdss.input.InputManager;
import com.projectdss.item.ConsumableItem;
import com.projectdss.item.combatitem.EquipableCombatItem;
import com.projectdss.item.combatitem.RuneCombatItem;
import com.projectdss.map.World;
import com.projectdss.output.OutputManager;

/**
 * EventParameter.java
 * 
 * @author Santiago Godoy Poce
 */
public class EventParameter {
    private OutputManager output;
    private InputManager input;
    private MainCharacter player;
    private World world;
    
    public EventParameter(OutputManager output, InputManager input, MainCharacter player, World world) {
        this.output = output;
        this.input = input;
        this.player = player;
        this.world = world;
    }

    public OutputManager getOutput() {
        return output;
    }

    public int getInput(int firstOption, int lastOption) {
        return input.getInput(firstOption, lastOption);
    }

    public void getItemInput(ConsumableItem item, Inventory inventory, CharacterStats characterStats, int option) {
        input.getItemInput(item, inventory, characterStats, option);
    }

    public void getItemInput(EquipableCombatItem item, Inventory inventory, CharacterStats characterStats, int option) {
        input.getItemInput(item, inventory, characterStats, option);
    }

    public void getItemInput(RuneCombatItem item, Inventory inventory, CharacterStats characterStats, int option) {
        input.getItemInput(item, inventory, characterStats, option);
    }

    public MainCharacter getPlayer() {
        return player;
    }

    public World getWorld() {
        return world;
    }

}