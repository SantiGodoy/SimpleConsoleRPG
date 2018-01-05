package com.projectdss.ability;

import com.projectdss.Ability;
import com.projectdss.ElementType;
import com.projectdss.CharacterStats;

/**
 * @author JoseCorrero
 * 
 * Class OffensiveAbility.
 */
public class OffensiveAbility extends Ability {

    private final int damage;
    private final ElementType type;

    public OffensiveAbility(int id, String name, String description, int necessaryMana,
                            int damage, ElementType type) {
        super(id, name, description, necessaryMana);
        this.damage = damage;
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public ElementType getType() {
        return type;
    }

    @Override
    public void use(CharacterStats player1, CharacterStats player2) {
        int appliedDamage;

        if(type == ElementType.BASIC)
            appliedDamage = player1.getStrength() + damage - player2.getBaseDefense();
        else
            appliedDamage = player1.getMagicalPower() + damage - player2.getBaseDefense();

        if(appliedDamage > 0) {
            appliedDamage *= ElementType.getElementDamage(type, player2.getDefensiveType());
            player2.setCurrentHealth(player2.getCurrentHealth() - appliedDamage);
        }
    }

}