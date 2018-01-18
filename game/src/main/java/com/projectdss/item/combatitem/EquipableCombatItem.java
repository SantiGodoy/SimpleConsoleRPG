package com.projectdss.item.combatitem;

import java.util.Set;
import com.projectdss.Rarity;
import com.projectdss.item.CombatItem;
import com.projectdss.item.combatitem.RuneCombatItem;

/**
 * @author JoseCorrero
 * 
 * Class EquipableCombatItem represents any CombatItem that can be equipped.
 */
public abstract class EquipableCombatItem extends CombatItem {

    protected boolean equipped;
    protected final int maxRunes;
    protected Set<RuneCombatItem> runes;

    public EquipableCombatItem(String name, Rarity rarity, String description, int maxRunes,
                               Set<RuneCombatItem> runes) {
        super(name, rarity, description);
        equipped = false;
        this.maxRunes = maxRunes;
        this.runes = runes;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }

    public void addRune(RuneCombatItem rune) {
        if(runes.size() < maxRunes)
            runes.add(rune);
    }

    public void removeRune(RuneCombatItem rune) {
        runes.remove(rune);
    }

    public boolean isEquipped() {
        return equipped;
    }

    public int getMaxRunes() {
        return maxRunes;
    }

    public Set<RuneCombatItem> getRunes() {
        return runes;
    }

}