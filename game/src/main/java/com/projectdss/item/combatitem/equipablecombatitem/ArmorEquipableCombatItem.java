package com.projectdss.item.combatitem.equipablecombatitem;

import java.util.Set;
import com.projectdss.Rarity;
import com.projectdss.Character;
import com.projectdss.ElementType;
import com.projectdss.item.combatitem.EquipableCombatItem;
import com.projectdss.item.combatitem.runecombatitem.ArmorRuneCombatItem;

/**
 * @author JoseCorrero
 * 
 * Class ArmorEquipableCombatItem represents any EquipableCombatItem 
 * that can be equipped as armor.
 */
public class ArmorEquipableCombatItem extends EquipableCombatItem {
    
    private int baseDefense;
    private int reflect;
    private Set<ArmorRuneCombatItem> runes;
    
    public ArmorEquipableCombatItem() {}

    public ArmorEquipableCombatItem(int id, String name, Rarity rarity, String description, int maxRunes,
                                    ElementType type, int baseDefense, int reflect,
                                    Set<ArmorRuneCombatItem> runes) {
        super(id, name, rarity, description, maxRunes, type);
        this.baseDefense = baseDefense;
        this.reflect = reflect;
        this.runes = runes;
    }


    public void setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }

    public void setReflect(int reflect) {
        this.reflect = reflect;
    }

    public void addRune(ArmorRuneCombatItem rune) {
        if(runes.size() < maxRunes)
            runes.add(rune);
    }

    public void removeRune(ArmorRuneCombatItem rune) {
        runes.remove(rune);
    }


    public int getBaseDefense() {
        return baseDefense;
    }

    public int getReflect() {
        return reflect;
    }

    public Set<ArmorRuneCombatItem> getRunes() {
        return runes;
    }


    @Override
    public int use(Character player1, Character player2) {
        int appliedDamage = player1.getStrength() - (player2.getDefense() + baseDefense);

        if(appliedDamage > 0) {
            appliedDamage *= ElementType.getElementDamage(player2.getType(), type);
            
            player2.setCurrentHealth(player2.getCurrentHealth() - appliedDamage);

            if(reflect > 0)
                player1.setCurrentHealth(player1.getCurrentHealth() - (appliedDamage * reflect / 100));
        }

        return appliedDamage;
    }

}