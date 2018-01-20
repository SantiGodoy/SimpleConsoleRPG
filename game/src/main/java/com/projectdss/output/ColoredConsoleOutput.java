package com.projectdss.output;

import com.projectdss.Ability;
import com.projectdss.character.EnemyCharacter;
import com.projectdss.output.ConsoleOutput;
import com.projectdss.character.MainCharacter;
import com.projectdss.ElementType;
import java.util.Set;

/**
 * ColoredConsoleOutput.java
 * 
 * @author Santiago Godoy Poce
 */
public class ColoredConsoleOutput extends ConsoleOutput {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    @Override
    public void showStartingMessage(String message) {
        System.out.println(ANSI_CYAN + message + ANSI_RESET);
    }

    @Override
    public void showGameOverMessage(String message) {
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }

    @Override
    public void showWinMessage(String message) {
        System.out.println(ANSI_GREEN + message + ANSI_RESET);
    }

    @Override
    public void showGlobalMenu() {
        System.out.println(ANSI_WHITE + "Main Menu" + ANSI_RESET + 
        ANSI_GREEN + "\n\t1- New Game" +
        "\n\t2- Option" +
        "\n\t3- Credits" + ANSI_RESET);
    }

    @Override
    public void showGameInformation() {
        System.out.println(ANSI_PURPLE + "Developers:" + 
        "\n\tJosé Correro Barquín" +
        "\n\tSantiago Godoy Poce" + ANSI_RESET);
    }

    private String showElementType(ElementType elementType) {
        switch(elementType.toString()) {
            case "Basic": return ANSI_WHITE + "Basic" + ANSI_RESET;
            case "Fire": return ANSI_RED + "Fire" + ANSI_RESET;
            case "Air": return ANSI_CYAN + "Air" + ANSI_RESET;
            case "Electric": return ANSI_YELLOW + "Electric" + ANSI_RESET;
            case "Water": return ANSI_BLUE + "Water" + ANSI_RESET;
            case "Pure": return ANSI_GREEN + "Pure" + ANSI_RESET;
            case "Damned": return ANSI_PURPLE + "Damned" + ANSI_RESET;
            default: return "";
        }
    }

    @Override
    public void showBattleState(MainCharacter player, EnemyCharacter enemy) {
        System.out.println("\n\tENEMY" +
        "\nName: " + enemy.getName() +
        "\nLevel: " + enemy.getLevel() +
        "\nHealth: " + ANSI_GREEN + enemy.getCharacterStats().getCurrentHealth() + "/" + 
            enemy.getCharacterStats().getMaxHealth() + ANSI_RESET +
        "\nMana: " + ANSI_BLUE + enemy.getCharacterStats().getCurrentMana() + "/" + 
            enemy.getCharacterStats().getMaxMana() + ANSI_RESET +
        "\nElement Type: " + showElementType(enemy.getCharacterStats().getDefensiveType()));

        System.out.println("\n\tYOU" +
        "\nName: " + player.getName() +
        "\nLevel: " + player.getLevel() +
        "\nHealth: " + ANSI_GREEN + player.getCharacterStats().getCurrentHealth() + "/" + 
            player.getCharacterStats().getMaxHealth() + ANSI_RESET +
        "\nMana: " + ANSI_BLUE + player.getCharacterStats().getCurrentMana() + "/" + 
            player.getCharacterStats().getMaxMana() + ANSI_RESET +
        "\nElement Type (Offensive): " + player.getCharacterStats().getOffensiveType() + 
        "\nElement Type (Defensive): " + player.getCharacterStats().getDefensiveType());
    }

    @Override
    public void showWinnerBattleMessage(EnemyCharacter enemy) {
        System.out.println(ANSI_GREEN + "You won against " + enemy.getName() + "!!!" + ANSI_RESET);
    }

    @Override
    public void showLoserBattleMessage(EnemyCharacter enemy) {
        System.out.println(ANSI_RED + "You lost against " + enemy.getName() + " :((" + ANSI_RESET);
    }
    
    private String showAbilityType(ElementType elementType) {
        switch(elementType.toString()) {
            case "Basic": return ANSI_WHITE;
            case "Fire": return ANSI_RED;
            case "Air": return ANSI_CYAN;
            case "Electric": return ANSI_YELLOW;
            case "Water": return ANSI_BLUE;
            case "Pure": return ANSI_GREEN;
            case "Damned": return ANSI_PURPLE;
            default: return "";
        }
    }

    @Override
    public int showAbilitiesCombat(MainCharacter player) {
        int counter = 0;
        for(Ability ability : player.getAbilities()) {
            if(player.getCharacterStats().getCurrentMana() < ability.getNecessaryMana()) {
                System.out.println(++counter + ". " + ability.getName() + " " + showAbilityType(ability.getType()) + ability.getType() + ANSI_RESET);
            } else 
                System.out.println(ability.getName() + " (Not enough mana)");
        }
        return counter;
    }
}