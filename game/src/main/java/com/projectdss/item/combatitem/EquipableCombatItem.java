package com.projectdss.item.combatitem;

import com.projectdss.Rarity;
import com.projectdss.Character;
import com.projectdss.ElementType;
import com.projectdss.item.CombatItem;

/**
 * @author JoseCorrero
 * 
 * Class EquipableCombatItem represents any CombatItem that can be equipped.
 */
public abstract class EquipableCombatItem extends CombatItem {

    protected boolean equipped;
    protected final int maxRunes;
    protected ElementType type;

    public EquipableCombatItem() {}

    public EquipableCombatItem(int id, String name, Rarity rarity, String description, int maxRunes,
                               ElementType type) {
        super(id, name, rarity, description);
        equipped = false;
        this.maxRunes = maxRunes;
        this.type = type;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }

    public void setType(ElementType type) {
        this.type = type;
    }

    public boolean isEquipped() {
        return equipped;
    }

    public int getMaxRunes() {
        return maxRunes;
    }

    public ElementType getType() {
        return type;
    }

    public boolean hasType() {
        return type != ElementType.BASIC;
    }

    public abstract int use(Character player1, Character player2);

}