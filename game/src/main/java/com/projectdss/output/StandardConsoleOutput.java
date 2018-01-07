package com.projectdss.output;

import com.projectdss.Ability;
import com.projectdss.character.EnemyCharacter;
import com.projectdss.output.ConsoleOutput;
import com.projectdss.character.MainCharacter;
import java.util.Set;


/**
 * StandardConsoleOutput.java
 * 
 * @author Santiago Godoy Poce
 */
public class StandardConsoleOutput extends ConsoleOutput {

    @Override
    public void showHUD(MainCharacter player) {
        System.out.println();
    }

    @Override
    public void showStartingMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showGameOverMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showWinMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showGlobalMenu() {
        System.out.println("Main Menu" + 
        "\n\t1- New Game" +
        "\n\t2- Option" +
        "\n\t3- Credits");
    }

    @Override
    public void showGameInformation() {
        System.out.println("Developers:" + 
        "\n\tJosé Correro Barquín" +
        "\n\tSantiago Godoy Poce" +
        "\n\tAntonio García Velatta");
    }

    @Override
    public void showBattleState(MainCharacter player, EnemyCharacter enemy) {
        System.out.println("\n\tENEMY" +
        "\nName: " + enemy.getName() +
        "\nLevel: " + enemy.getLevel() +
        "\nHealth: " + enemy.getStats().getCurrentHealth() + "/" + enemy.getStats().getMaxHealth() +
        "\nMana: " + enemy.getStats().getCurrentMana() + "/" + enemy.getStats().getMaxMana() +
        "\nElement Type: " + enemy.getStats().getDefensiveType());

        System.out.println("\n\tYOU" +
        "\nName: " + player.getName() +
        "\nLevel: " + player.getLevel() +
        "\nHealth: " + player.getStats().getCurrentHealth() + "/" + player.getStats().getMaxHealth() +
        "\nMana: " + player.getStats().getCurrentMana() + "/" + player.getStats().getMaxMana());
    }

    @Override
    public void showWinnerBattleMessage(EnemyCharacter enemy) {
        System.out.println("You won against " + enemy.getName() + "!!!");
    }

    @Override
    public void showLoserBattleMessage(EnemyCharacter enemy) {
        System.out.println("You lost against " + enemy.getName() + " :((");
    }

    @Override
    public int showAbilitiesCombat(MainCharacter player) {
        int i = 1;
        for(Ability ability : player.getAbilities()) {
            if(player.getStats().getCurrentMana() < ability.getNecessaryMana()) {
                System.out.println(i + ". " + ability.getName());
                ++i;
            } else 
                System.out.println(ability.getName() + " (Not enough mana)");
        }
    }
}