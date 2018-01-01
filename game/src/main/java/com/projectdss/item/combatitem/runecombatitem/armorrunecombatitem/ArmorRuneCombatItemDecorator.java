package com.proyectdss.item.combatitem.runecombatitem.armorrunecombatitem;

import com.proyectdss.Rarity;
import com.proyectdss.item.combatitem.equipablecombatitem.ArmorEquipableCombatItem;

/**
 * @author JoseCorrero
 * 
 * Class ArmorRuneCombatItemDecorator represents any ArmorRuneCombatItem that 
 * can be added to a ArmorEquipableCombatItem to enhance its base defense and something else.
 */
public abstract class ArmorRuneCombatItemDecorator extends ArmorRuneCombatItem {

    protected ArmorRuneCombatItem rune;

    public ArmorRuneCombatItemDecorator(int id, String name, Rarity rarity, String description, 
                                         ArmorRuneCombatItem rune) {
        super(id, name, rarity, description);
        this.rune = rune;
    }

    @Override
    public int getFirm() {
        return rune.getFirm();
    }

    @Override
    public void use(ArmorEquipableCombatItem armor) {
        rune.use(armor);
    }

    @Override
    public void disuse(ArmorEquipableCombatItem armor) {
        rune.disuse(armor);
    }

}