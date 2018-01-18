package com.projectdss.output;

import com.projectdss.event.InventoryEvent;
import com.projectdss.inventory.Inventory;
import com.projectdss.character.MainCharacter;
import com.projectdss.item.CombatItem;
import com.projectdss.item.ConsumableItem;
import com.projectdss.item.combatitem.EquipableCombatItem;
import com.projectdss.item.combatitem.RuneCombatItem;
import com.projectdss.item.combatitem.equipablecombatitem.ArmorEquipableCombatItem;
import com.projectdss.item.combatitem.equipablecombatitem.WeaponEquipableCombatItem;
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
            System.out.println(counter + ". " + i.getName() + " (" + i.getRarity() + "): " + i.getDescription());
            if(i instanceof WeaponEquipableCombatItem) {
                WeaponEquipableCombatItem weapon = (WeaponEquipableCombatItem) i;
                System.out.println(weapon.getBaseDamage() + " damage.\n" +
                                   weapon.getRunes().size() + "/" + weapon.getRunes().size() + " runes.");
            } else if(i instanceof ArmorEquipableCombatItem) {
                ArmorEquipableCombatItem armor = (ArmorEquipableCombatItem) i;
                System.out.println(armor.getBaseDefense() + " defense.\n" +
                                   armor.getRunes().size() + "/" + armor.getRunes().size() + " runes.");
            }
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
    public int showItemOptions(ConsumableItem item) {
        System.out.println("1. Use" +
        "\n2. Remove" +
        "\n0. Return");
        return 3;
    }

    @Override
    public int showItemOptions(EquipableCombatItem item) {
        if(item.isEquipped())
            System.out.println("1. Take off");
        else
            System.out.println("1. Equip");
        System.out.println("2. Remove item" +
        "\n0. Return");
        return 3;
    }

    @Override
    public int showItemOptions(RuneCombatItem item) {
        System.out.println("1. Merge\n" +
                           "2. Remove item\n" +
                           "0. Return");
        return 3;
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
        "\n1. Attack\t\t2. Ability" + 
        "\n3. Run away");
    }

    @Override
    public void showTargetOptions(MainCharacter player, EnemyCharacter enemy) {
        System.out.println("Select the target:" + 
        "\n1. " + player.getName() +
        "\n2. " + enemy.getName());
    }

    @Override
    public void showUseAbility(Character player1, Character player2, 
                               Ability ability, int abilityPower) {
            String message = player1.getName() + " used the ability '" + ability.getName() + "' on ";
            
            if(player1.equals(player2))
                if(player1.getGender().equals("Man"))
                    message += "himself, ";
                else
                    message += "herself, ";
            else
                message += player2.getName() + ", ";

            if(abilityPower >= 0)
                message += "dealing " + abilityPower + " damage!";
            else
                message += "restoring " + (abilityPower * -1) + " health!";

            System.out.println(message);
        }

    @Override
    public void showRunAway() {
        System.out.println("Wow! You got out of that battle!");
    }

    @Override
    public void showUseAttack(Character player1, Character player2, int appliedDamage) {
        String message = player1.getName() + " attacked to ";
            
        if(player1.equals(player2))
            if(player1.getGender().equals("Man"))
                message += "himself, ";
            else
                message += "herself, ";
        else
            message += player2.getName() + ", ";

        message += "dealing " + appliedDamage + " damage!";

        System.out.println(message);
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
    public void showLevelUpOptions(MainCharacter player) {
        System.out.println("Select the stats you want to level:\t\tLevel " + player.getLevel() +
                           "\n1. Maximum health\t\t(" + player.getStats().getMaxHealth() + ")" +
                           "\n2. Maximum mana\t\t(" + player.getStats().getMaxMana() + ")" +
                           "\n3. Strength\t\t(" + player.getStats().getStrength() + ")" +
                           "\n4. Magical power\t\t(" + player.getStats().getMagicalPower() + ")" +
                           "\n5. Resistance\t\t(" + player.getStats().getResistance() + ")" +
                           "\n6. Agility\t\t(" + player.getStats().getAgility() + ")");
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