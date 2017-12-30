package com.proyectdss.item.combatitem.equipablecombatitem;

import java.util.*;
import com.proyectdss.Rarity;
import com.proyectdss.Character;

/**
 * @author JoseCorrero
 * 
 * Class WeaponEquipableCombatItem represents any EquipableCombatItem 
 * that can be equipped as weapon.
 */
public abstract class WeaponEquipableCombatItem extends EquipableCombatItem {
    
    protected int baseDamage;
    
    public WeaponEquipableCombatItem() {}
    
    public WeaponEquipableCombatItem(int id, String name, Rarity rarity, String description, 
                                     int baseDamage) {
        super(id, name, rarity, description);
        this.baseDamage = baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

}