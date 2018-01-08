package com.projectdss.ability;

import com.projectdss.Ability;
import com.projectdss.ElementType;
import com.projectdss.CharacterStats;

/**
 * @author JoseCorrero
 * 
 * Class ElementAbility represents any Ability that has an elemental type.
 */
public class ElementAbility extends Ability {

    private final int power;
    private final ElementType type;

    public ElementAbility(int id, String name, String description, int necessaryMana,
                            int power, ElementType type) {
        super(id, name, description, necessaryMana);
        this.power = power;
        this.type = type;
    }

    public int getPower() {
        return power;
    }

    @Override
    public ElementType getType() {
        return type;
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