package com.projectdss.item.combatitem.runecombatitem.armorrunecombatitem;

import com.projectdss.Rarity;
import com.projectdss.item.combatitem.runecombatitem.ArmorRuneCombatItem;
import com.projectdss.item.combatitem.equipablecombatitem.ArmorEquipableCombatItem;

/**
 * @author JoseCorrero
 * 
 * Class FirmnessArmorRuneCombatItem represents any ArmorRuneCombatItem that 
 * can be added to an ArmorEquipableCombatItem to enhance its base defense.
 */
public class FirmnessArmorRuneCombatItem extends ArmorRuneCombatItem {

    private final int firmness;

    public FirmnessArmorRuneCombatItem(int id, String name, Rarity rarity, String description, 
                                                int firmness) {
        super(id, name, rarity, description);
        this.firmness = firmness;
    }

    @Override
    public int getFirmness() {
        return firmness;
    }

    @Override
    public void use(ArmorEquipableCombatItem armor) {
        armor.setBaseDefense(armor.getBaseDefense() + firmness);
    }

    @Override
    public void disuse(ArmorEquipableCombatItem armor) {
        armor.setBaseDefense(armor.getBaseDefense() - firmness);
    }

}