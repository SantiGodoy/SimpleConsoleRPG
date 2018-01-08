package com.projectdss.ability;

import com.projectdss.Ability;
import com.projectdss.ElementType;
import com.projectdss.CharacterStats;

/**
 * @author JoseCorrero
 * 
 * Class HealthAbility represents any Ability that has an impact on health.
 */
public class HealthAbility extends Ability {

    private final int power;

    public HealthAbility(int id, String name, String description, int necessaryMana,
                          int power, ElementType type) {
        super(id, name, description, necessaryMana, type);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    @Override
    public int use(CharacterStats player1, CharacterStats player2) {
        int appliedPower;

        if(type == ElementType.BASIC)
            appliedPower = player1.getStrength() + power - player2.getBaseDefense();
        else if(type == ElementType.PURE)
            appliedPower = player1.getMagicalPower() + power;
        else
            appliedPower = player1.getMagicalPower() + power - player2.getBaseDefense();

        if(appliedPower > 0) {
            appliedPower *= ElementType.getElementDamage(type, player2.getDefensiveType());
            player2.setCurrentHealth(player2.getCurrentHealth() - appliedPower);
        }

        return appliedPower;
    }

}