package com.projectdss.item.combatitem.equipablecombatitem;

import java.util.Set;
import com.projectdss.Rarity;
import com.projectdss.Character;
import com.projectdss.ElementType;
import com.projectdss.item.combatitem.EquipableCombatItem;
import com.projectdss.item.combatitem.runecombatitem.WeaponRuneCombatItem;

/**
 * @author JoseCorrero
 * 
 * Class WeaponEquipableCombatItem represents any EquipableCombatItem 
 * that can be equipped as weapon.
 */
public class WeaponEquipableCombatItem extends EquipableCombatItem {
    
    private int baseDamage;
    private int trueDamage;
    private int lifesteal;
    private Set<WeaponRuneCombatItem> runes;

    public WeaponEquipableCombatItem() {}
    
    public WeaponEquipableCombatItem(int id, String name, Rarity rarity, String description, int maxRunes,
                                     ElementType type, int baseDamage, int trueDamage, int lifesteal,
                                     Set<WeaponRuneCombatItem> runes) {
        super(id, name, rarity, description, maxRunes, type);
        this.baseDamage = baseDamage;
        this.trueDamage = trueDamage;
        this.lifesteal = lifesteal;
        this.runes = runes;
    }


    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public void setTrueDamage(int trueDamage) {
        this.trueDamage = trueDamage;
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

    public int getLifesteal() {
        return lifesteal;
    }

    public Set<WeaponRuneCombatItem> getRunes() {
        return runes;
    }


    @Override
    public int use(Character player1, Character player2) {
        int appliedDamage = player1.getStrength() + baseDamage - player2.getDefense();

        if(appliedDamage > 0) {
            appliedDamage *= ElementType.getElementDamage(type, player2.getType());
            
            if(lifesteal > 0)
                player1.setCurrentHealth(player1.getCurrentHealth() + (appliedDamage * lifesteal / 100));
        }

        if(trueDamage > 0)
            appliedDamage += trueDamage;

        if(appliedDamage > 0)
            player2.setCurrentHealth(player2.getCurrentHealth() - appliedDamage);

        return appliedDamage;
    }

}