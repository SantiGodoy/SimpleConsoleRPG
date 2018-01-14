package com.projectdss.inventory;

import java.util.List;
import com.projectdss.Item;
import com.projectdss.item.ConsumableItem;
import com.projectdss.item.combatitem.RuneCombatItem;
import com.projectdss.item.combatitem.EquipableCombatItem;
import com.projectdss.item.combatitem.runecombatitem.ArmorRuneCombatItem;
import com.projectdss.item.combatitem.runecombatitem.WeaponRuneCombatItem;
import com.projectdss.item.combatitem.equipablecombatitem.ArmorEquipableCombatItem;
import com.projectdss.item.combatitem.equipablecombatitem.WeaponEquipableCombatItem;
import com.projectdss.Character;

public class InventoryManager {

    private WeaponEquipableCombatItem equippedWeapon;
    private ArmorEquipableCombatItem equippedArmor;

    public InventoryManager(WeaponEquipableCombatItem weapon, ArmorEquipableCombatItem armor) {
        this.equippedWeapon = weapon;
        this.equippedArmor = armor;
    }
    
    public void equipWeapon(WeaponEquipableCombatItem weapon, Character player) {
        if(equippedWeapon != null)
            discardWeapon(player);

        equippedWeapon = weapon;
        weapon.setEquipped(true);
        weapon.use(player.getStats());
    }

    public void equipArmor(ArmorEquipableCombatItem armor, Character player) {
        if(equippedArmor != null)
            discardArmor(player);

        equippedArmor = armor;
        armor.setEquipped(true);
        armor.use(player.getStats());
    }

    public void discardWeapon(Character player) {
        if(equippedWeapon != null) {
            equippedWeapon.disuse(player.getStats());
            equippedWeapon.setEquipped(false);
        }
    }

    public void discardArmor(Character player) {
        if(equippedArmor != null) {
            equippedArmor.disuse(player.getStats());
            equippedArmor.setEquipped(false);
        }
    }

    public boolean mergeWeaponRune(WeaponEquipableCombatItem weapon, WeaponRuneCombatItem rune,
                                Character player) {
        if(weapon.getMaxRunes() == weapon.getRunes().size())
            return false;

        weapon.addRune(rune);
        rune.setMerged(true);

        if(weapon.isEquipped())
            rune.use(player.getStats());

        return true;
    }

    public boolean mergeArmorRune(ArmorEquipableCombatItem armor, ArmorRuneCombatItem rune,
                               Character player) {
        if(armor.getMaxRunes() == armor.getRunes().size())
            return false;

        armor.addRune(rune);
        rune.setMerged(true);

        if(armor.isEquipped())
            rune.use(player.getStats());

        return true;
    }

    public boolean hasEquippedWeapon() {
        return equippedWeapon != null;
    }

    public boolean hasEquippedArmor() {
        return equippedArmor != null;
    }

    public void getConsumables(Inventory inventory, List<ConsumableItem> consumables) {
        for(Item item : inventory)
            if(item instanceof ConsumableItem)
                consumables.add((ConsumableItem) item);
    }

    public void getEquipables(Inventory inventory, List<EquipableCombatItem> equipables) {
        for(Item item : inventory)
            if(item instanceof EquipableCombatItem)
                equipables.add((EquipableCombatItem) item);
    }

    public void getRunes(Inventory inventory, List<RuneCombatItem> runes) {
        for(Item item : inventory)
            if(item instanceof RuneCombatItem)
                runes.add((RuneCombatItem) item);
    }

    public WeaponEquipableCombatItem getEquippedWeapon() {
        return equippedWeapon;
    }

    public ArmorEquipableCombatItem getEquippedArmor() {
        return equippedArmor;
    }
    
}