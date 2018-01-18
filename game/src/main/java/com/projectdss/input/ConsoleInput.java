package com.projectdss.input;

import com.projectdss.CharacterStats;
import com.projectdss.Item;
import com.projectdss.inventory.Inventory;
import com.projectdss.item.CombatItem;
import com.projectdss.item.ConsumableItem;
import com.projectdss.item.combatitem.EquipableCombatItem;
import com.projectdss.item.combatitem.RuneCombatItem;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.IIOException;

/**
 * ConsoleInput.java
 * 
 * @author Santiago Godoy Poce
 */
public class ConsoleInput implements InputHandler {
    @Override
    public int getInput(int firstOption, int lastOption) {
        Scanner input = new Scanner(System.in);
        int inputValue = input.nextInt();
        try {
        if(inputValue < firstOption || inputValue > lastOption) 
            throw new IOException();
        else
            return inputValue;
        } catch(IOException ioe) {
            System.out.println("Incorrect option");
            return 0;
        }
    }

    @Override
    public void getItemInput(EquipableCombatItem item, Inventory inventory, CharacterStats characterStats, int option) {
        switch(option) {
            case 1:
                if(item.isEquipped())
                    item.setEquipped(false);
                else
                    item.setEquipped(true);
                break;
            case 2: inventory.removeItem(item);
                break;
            case 0:
                break;
            default: 
        }
    }

    @Override
    public void getItemInput(ConsumableItem item, Inventory inventory, CharacterStats characterStats, int option) {
        switch(option) {
            case 1: item.use(characterStats);
                break;
            case 2: inventory.removeItem(item);
                break;
            case 0:
                break;
            default: 
        }
    }

    @Override
    public void getItemInput(RuneCombatItem item, Inventory inventory, CharacterStats characterStats, int option) {
        switch(option){
            case 1: 
                if(item.isMerged())
                    item.setMerged(false);
                else
                    item.setMerged(true);
                break;
            case 2: inventory.removeItem(item);
                break;
            case 0:
                break;
            default: 
        }
    }
}