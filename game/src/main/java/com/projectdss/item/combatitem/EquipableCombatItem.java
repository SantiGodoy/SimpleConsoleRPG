package com.proyectdss.item.combatitem;

import java.util.*;
import com.proyectdss.Rarity;
import com.proyectdss.Character;

/**
 * @author JoseCorrero
 * 
 * Class EquipableCombatItem represents any CombatItem that can be equipped.
 */
public abstract class EquipableCombatItem extends CombatItem {

    protected boolean equipped;

    public EquipableCombatItem() {}

    public EquipableCombatItem(int id, String name, Rarity rarity, String description) {
        super(id, name, rarity, description);
        equipped = false;
    }

    public void setEquipped(bool equipped) {
        this.equipped = equipped;
    }

    public boolean isEquipped() {
        return equipped;
    }

    public abstract int use(Character player1, Character player2);

}