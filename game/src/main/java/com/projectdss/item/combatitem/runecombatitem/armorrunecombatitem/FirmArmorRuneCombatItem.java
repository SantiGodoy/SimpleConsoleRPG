package com.proyectdss.item.combatitem.runecombatitem.armorrunecombatitem;

import java.util.*;
import com.proyectdss.Rarity;
import com.proyectdss.item.combatitem.equipablecombatitem.ArmorEquipableCombatItem;

/**
 * @author JoseCorrero
 * 
 * Class FirmArmorRuneCombatItem represents any ArmorRuneCombatItem that 
 * can be added to an ArmorEquipableCombatItem to enhance its base defense.
 */
public class FirmArmorRuneCombatItem extends ArmorRuneCombatItem {

    private int firm;

    public FirmArmorRuneCombatItemDecorator(int id, String name, Rarity rarity, String description, 
                                            int firm) {
        super(id, name, rarity, description);
        this.firm = firm;
    }

    @override
    public int getFirm() {
        return firm;
    }

    @override
    public void use(ArmorEquipableCombatItem armor) {
        armor.setBaseDefense(armor.getBaseDefense() + firm);
    }

    @override
    public void disuse(ArmorEquipableCombatItem armor) {
        armor.setBaseDefense(armor.getBaseDefense() - firm);
    }

}