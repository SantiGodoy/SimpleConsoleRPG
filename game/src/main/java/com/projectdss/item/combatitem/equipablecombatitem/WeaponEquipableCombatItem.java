package com.proyectdss.item.combatitem.equipablecombatitem;

import java.util.Set;
import com.proyectdss.Rarity;
import com.proyectdss.Character;
import com.proyectdss.ElementType;

/**
 * @author JoseCorrero
 * 
 * Class WeaponEquipableCombatItem represents any EquipableCombatItem 
 * that can be equipped as weapon.
 */
public class WeaponEquipableCombatItem extends EquipableCombatItem {
    
    private int baseDamage;
    private int trueDamage;
    private ElementType type;
    private int lifesteal;
    private Set<WeaponRuneCombatItem> runes;

    public WeaponEquipableCombatItem() {}
    
    public WeaponEquipableCombatItem(int id, String name, Rarity rarity, String description, int maxRunes,
                                     int baseDamage, List<WeaponRuneCombatItem> runes) {
        super(id, name, rarity, description, maxRunes);
        this.baseDamage = baseDamage;
        trueDamage = 0;
        type = BASIC;
        lifesteal = 0;
        this.runes = runes;
    }


    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public void setTrueDamage(int trueDamage) {
        this.trueDamage = trueDamage;
    }

    public void setType(ElementType type) {
        this.type = type;
    }

    public void setLifesteal(int lifesteal) {
        this.lifesteal = lifesteal;
    }
    
    public void addRune(WeaponRuneCombatItem rune) {
        if(runes.size() < maxRunes)
            runes.add(rune);
    }

    public void removeRune(WeaponRuneCombatItem rune) {
        runes.remove(rune);
    }


    public int getBaseDamage() {
        return baseDamage;
    }

    public int getTrueDamage() {
        return trueDamage;
    }

    public ElementType getType() {
        return type;
    }

    public int getLifesteal() {
        return lifesteal;
    }

    public Set<WeaponRuneCombatItem> getRunes() {
        return runes;
    }


    @Override
    public void use(Character player1, Character player 2) {
        int damage = player1.getStrength() + baseDamage - player2.getDefense();

        if(damage > 0) {
            damage *= ElementType.elementalMatrix[type][player2.getType()];
            
            if(trueDamage > 0)
                player2.setCurrentHealth(player2.getCurrentHealth() - (damage + trueDamage));
            else
                player2.setCurrentHealth(player2.getCurrentHealth() - damage);

            if(lifesteal > 0)
                player1.setCurrentHealth(player1.getCurrentHealth() + (damage * lifesteal / 100));
        }
        else
            if(trueDamage > 0)
                player2.setCurrentHealth(player2.getCurrentHealth() - trueDamage);
    }

}