package com.proyectdss.item.combatitem.equipablecombatitem.armorequipablecombatitem.armorequipablecombatitemdecorator;

import java.util.*;
import com.proyectdss.Rarity;
import com.proyectdss.Character;

/**
 * @author JoseCorrero
 *
 * Class ReflectArmorEquipableCombatItem represents any ArmorEquipableCombatItemDecorator 
 * that has a ReflectArmorRuneCombatItem added.
 */
public class ReflectArmorEquipableCombatItem extends ArmorEquipableCombatItemDecorator {

    public ReflectArmorEquipableCombatItem(int id, 
                                         ArmorEquipableCombatItem armor,
                                         ReflectArmorRuneCombatItem rune) {
        super(id, armor, rune);
    }

    @override
    public int use(Character player1, Character player2) {
        int damageApplied  = super.use(player1, player2),
            damageTaken    = (damageApplied * rune.use() / 100) - player1.getDefense();

        player1.setCurrentHealth(player1.getCurrentHealth() - damageTaken);

        return damageApplied;
    }

}