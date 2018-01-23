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
import com.projectdss.CharacterStats;

public class InventoryManager {

    private static final InventoryManager INSTANCE = new InventoryManager();
    private static Inventory inventory;

    private InventoryManager() {}

    public static InventoryManager getInstance(Inventory playerInventory) {
        if(inventory == null)
            inventory = playerInventory;
        return INSTANCE;
    }
    
    public void equipWeapon(WeaponEquipableCombatItem weapon, CharacterStats player) {
        if(inventory.hasWeaponEquipped())
            discardWeapon(player);

        inventory.setEquippedWeapon(weapon);
        weapon.setEquipped(true);
        weapon.use(player);
    }

    public void equipArmor(ArmorEquipableCombatItem armor, CharacterStats player) {
        if(inventory.hasArmorEquipped())
            discardArmor(player);

        inventory.setEquippedArmor(armor);
        armor.setEquipped(true);
        armor.use(player);
    }

    public void discardWeapon(CharacterStats player) {
        if(inventory.hasWeaponEquipped()) {
            inventory.getEquippedWeapon().disuse(player);
            inventory.getEquippedWeapon().setEquipped(false);
            inventory.setEquippedWeapon(null);
        }
    }

    public void discardArmor(CharacterStats player) {
        if(inventory.hasArmorEquipped()) {
            inventory.getEquippedArmor().disuse(player);
            inventory.getEquippedArmor().setEquipped(false);
            inventory.setEquippedArmor(null);
        }
    }

    public boolean mergeWeaponRune(WeaponRuneCombatItem rune, CharacterStats player) {
        if(!inventory.hasWeaponEquipped())
            return false;

        WeaponEquipableCombatItem weapon = inventory.getEquippedWeapon();

        if(weapon.getMaxRunes() == weapon.getRunes().size())
            return false;

        weapon.addRune(rune);

        rune.use(player);

        inventory.removeItem(rune);

        return true;
    }

    public boolean mergeArmorRune(ArmorRuneCombatItem rune, CharacterStats player) {
        if(!inventory.hasArmorEquipped())
            return false;

        ArmorEquipableCombatItem armor = inventory.getEquippedArmor();

        if(armor.getMaxRunes() == armor.getRunes().size())
            return false;

        armor.addRune(rune);

        rune.use(player);

        inventory.removeItem(rune);

        return true;
    }

    public void getConsumables(List<ConsumableItem> consumables) {
        for(Item item : inventory)
            if(item instanceof ConsumableItem)
                consumables.add((ConsumableItem) item);
    }

    public void getEquipables(List<EquipableCombatItem> equipables) {
        for(Item item : inventory)
            if(item instanceof EquipableCombatItem)
                equipables.add((EquipableCombatItem) item);
    }

    public void getRunes(List<RuneCombatItem> runes) {
        for(Item item : inventory)
            if(item instanceof RuneCombatItem)
                runes.add((RuneCombatItem) item);
    }
    
}