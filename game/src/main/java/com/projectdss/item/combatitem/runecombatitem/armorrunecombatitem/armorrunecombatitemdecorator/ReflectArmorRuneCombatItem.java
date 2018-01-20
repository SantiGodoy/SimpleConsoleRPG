package com.projectdss.item.combatitem.runecombatitem.armorrunecombatitem.armorrunecombatitemdecorator;

import com.projectdss.Rarity;
import com.projectdss.CharacterStats;
import com.projectdss.item.combatitem.runecombatitem.ArmorRuneCombatItem;
import com.projectdss.item.combatitem.runecombatitem.armorrunecombatitem.ArmorRuneCombatItemDecorator;

/**
 * @author JoseCorrero
 * 
 * Class ReflectArmorRuneCombatItem represents any ArmorRuneCombatItemDecorator that 
 * can be added to a ArmorEquipableCombatItem to enhance its reflect.
 */
public class ReflectArmorRuneCombatItem extends ArmorRuneCombatItemDecorator {

    private int reflect;

    public ReflectArmorRuneCombatItem(){}

    public ReflectArmorRuneCombatItem(String name, Rarity rarity, String description,  
                                      ArmorRuneCombatItem rune, int reflect) {
        super(name, rarity, description, rune);
        this.reflect = reflect;
    }

    public int getReflect() {
        return reflect;
    }

    public void setReflect(int reflect) {
        this.reflect = reflect;
    }

    @Override
    public void use(CharacterStats characterStats) {
        super.use(characterStats);
        characterStats.setReflect(characterStats.getReflect() + reflect);
    }

    @Override
    public void disuse(CharacterStats characterStats) {
        super.disuse(characterStats);
        characterStats.setReflect(characterStats.getReflect() - reflect);
    }

}