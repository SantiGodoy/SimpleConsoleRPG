package com.projectdss.event;

import com.projectdss.character.EnemyCharacter;
import com.projectdss.character.MainCharacter;
import com.projectdss.input.InputManager;
import com.projectdss.inventory.Inventory;
import com.projectdss.output.OutputManager;
import java.util.Set;

public class EventParameter {
    private OutputManager output;
    private InputManager input;
    private MainCharacter player;
    private EnemyCharacter enemy;
    
    public EventParameter(OutputManager output, InputManager input, 
        MainCharacter player, EnemyCharacter enemy) {
            this.output = output;
            this.input = input;
            this.player = player;
            this.enemy = enemy;
        }

    public OutputManager getOutput() {
        return output;
    }

    public int getInput() {
        return input.getInput();
    }

    public MainCharacter getPlayer() {
        return player;
    }

    public Inventory getPlayerInventory() {
        return player.getInventory();
    }

    public EnemyCharacter getEnemy() {
        return enemy;
    }
}