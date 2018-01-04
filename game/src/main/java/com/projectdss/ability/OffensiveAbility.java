package com.projectdss.ability;

import com.projectdss.Ability;
import com.projectdss.Character;
import com.projectdss.ElementType;
import com.projectdss.item.combatitem.equipablecombatitem.ArmorEquipableCombatItem;

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
    public int use(Character player1, Character player2) {
        int appliedDamage = player1.getStrength() + damage - player2.getDefense();

        if(appliedDamage > 0) {
            if(player2.hasArmor()) {
                ArmorEquipableCombatItem armor = player2.getArmor();
                appliedDamage -= armor.getBaseDefense();
                appliedDamage *= ElementType.getElementDamage(type, armor.getType());
            } else {
                appliedDamage *= ElementType.getElementDamage(type, player2.getType());
            }
        }

        if(appliedDamage > 0)
            player2.setCurrentHealth(player2.getCurrentHealth() - appliedDamage);

        return appliedDamage;
    }

}