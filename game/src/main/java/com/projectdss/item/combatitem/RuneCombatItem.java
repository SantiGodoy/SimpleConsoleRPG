package com.proyectdss.item.combatitem;

import java.util.*;
import com.proyectdss.Rarity;

/**
 * @author JoseCorrero
 * 
 * Class RuneCombatItem represents any CombatItem that can be added to 
 * an EquipableCombatItem to enhance it.
 */
public abstract class RuneCombatItem extends CombatItem {

    public RuneCombatItem() {}

    public RuneCombatItem(int id, String name, Rarity rarity, String description) {
        super(id, name, rarity, description);
    }

    public abstract int use();

}