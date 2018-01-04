package com.projectdss.inventory;

import java.util.Set;
import java.util.Iterator;
import com.projectdss.Item;
import com.projectdss.item.combatitem.equipablecombatitem.ArmorEquipableCombatItem;
import com.projectdss.item.combatitem.equipablecombatitem.WeaponEquipableCombatItem;

/**
 * @author JoseCorrero
 * 
 * Class Inventory.
 */
public class Inventory implements Iterable<Item> {

    private Set<Item> items;
    private WeaponEquipableCombatItem equippedWeapon;
    private ArmorEquipableCombatItem equippedArmor;

    public Inventory(Set<Item> items, WeaponEquipableCombatItem weapon, ArmorEquipableCombatItem armor) {
        this.items = items;
        equippedWeapon = weapon;
        equippedArmor = armor;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void setEquippedWeapon(WeaponEquipableCombatItem weapon) {
        equippedWeapon = weapon;
    }

    public void setEquippedArmor(ArmorEquipableCombatItem armor) {
        equippedArmor = armor;
    }

    public boolean hasWeaponEquipped() {
        return equippedWeapon != null;
    }

    public boolean hasArmorEquipped() {
        return equippedArmor != null;
    }

    public WeaponEquipableCombatItem getEquippedWeapon() {
        return equippedWeapon;
    }

    public ArmorEquipableCombatItem getEquippedArmor() {
        return equippedArmor;
    }

    @Override
    public Iterator<Item> iterator() {
        return items.iterator();
    }

}