package com.projectdss.ability;

import com.projectdss.Ability;
import com.projectdss.CharacterStats;

/**
 * @author JoseCorrero
 * 
 * Class HealingAbility.
 */
public class HealingAbility extends Ability {

    private final int healing;

    public HealingAbility(int id, String name, String description, int necessaryMana,
                          int healing) {
        super(id, name, description, necessaryMana);
        this.healing = healing;
    }

    public int getHealing() {
        return healing;
    }

    @Override
    public void use(CharacterStats player1, CharacterStats player2) {
        player2.setCurrentHealth(player2.getCurrentHealth() + player1.getMagicalPower() + healing);
    }

}