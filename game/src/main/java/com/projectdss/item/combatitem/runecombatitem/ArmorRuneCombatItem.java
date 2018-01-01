package com.proyectdss.item.combatitem.runecombatitem;

import com.proyectdss.Rarity;
import com.proyectdss.item.combatitem.equipablecombatitem.ArmorEquipableCombatItem;

/**
 * @author JoseCorrero
 * 
 * Class ArmorRuneCombatItem represents any RuneCombatItem that can be added to 
 * an ArmorEquipableCombatItem to enhace it.
 */
public abstract class ArmorRuneCombatItem extends RuneCombatItem {

    public ArmorRuneCombatItem() {}

    public ArmorRuneCombatItem(int id, String name, Rarity rarity, String description) {
        super(id, name, rarity, description);
    }

    public abstract int getFirm();

    public abstract void use(ArmorEquipableCombatItem weapon);

    public abstract void disuse(ArmorEquipableCombatItem weapon);

}