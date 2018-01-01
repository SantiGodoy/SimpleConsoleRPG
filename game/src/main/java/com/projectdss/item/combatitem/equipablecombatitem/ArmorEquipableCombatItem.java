package com.proyectdss.item.combatitem.equipablecombatitem;

import java.util.Set;
import com.proyectdss.Rarity;
import com.proyectdss.Character;
import com.proyectdss.ElementType;

/**
 * @author JoseCorrero
 * 
 * Class ArmorEquipableCombatItem represents any EquipableCombatItem 
 * that can be equipped as armor.
 */
public class ArmorEquipableCombatItem extends EquipableCombatItem {
    
    private int baseDefense;
    private ElementType type;
    private int reflect;
    private Set<ArmorRuneCombatItem> runes;
    
    public ArmorEquipableCombatItem() {}

    public ArmorEquipableCombatItem(int id, String name, Rarity rarity, String description, int maxRunes,
                                    int baseDefense, Set<ArmorRuneCombatItem> runes) {
        super(id, name, rarity, description, maxRunes);
        this.baseDefense = baseDefense;
        type = BASIC;
        reflect = 0;
        this.runes = runes;
    }


    public void setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }

    public void setType(ElementType type) {
        this.type = type;
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

    public ElementType getType() {
        return type;
    }

    public int getReflect() {
        return reflect;
    }

    public Set<ArmorRuneCombatItem> getRunes() {
        return runes;
    }


    @Override
    public void use(Character player1, Character player 2) {
        int damage = player1.getStrength() - (player2.getDefense() + baseDefense);

        if(damage > 0) {
            damage *= ElementType.elementalMatrix[player2.getType()][type];
            
            player2.setCurrentHealth(player2.getCurrentHealth() - damage);

            if(reflect > 0)
                player1.setCurrentHealth(player1.getCurrentHealth() - (damage * reflect / 100));
        }
    }

}