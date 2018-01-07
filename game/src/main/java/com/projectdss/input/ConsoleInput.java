package com.projectdss.input;

import com.projectdss.CharacterStats;
import com.projectdss.Item;
import com.projectdss.inventory.Inventory;
import com.projectdss.item.CombatItem;
import com.projectdss.item.ConsumableItem;
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
    public void getItemInput(Item item, Inventory inventory, CharacterStats characterStats, int option) {
        if(item instanceof CombatItem) {
            switch(option) {
                case 1: item.getDescription();
                    break;
                case 2: inventory.removeItem(item);
                    break;
                case 3:
                    break;
                default: 
            }
        } else if(item instanceof ConsumableItem) {
            switch(option) {
                case 1: item.use(characterStats);
                    break;
                case 2: item.getDescription();
                    break;
                case 3: inventory.removeItem(item);
                    break;
                case 4: 
                    break;
                default:
            }
        }
    }
}