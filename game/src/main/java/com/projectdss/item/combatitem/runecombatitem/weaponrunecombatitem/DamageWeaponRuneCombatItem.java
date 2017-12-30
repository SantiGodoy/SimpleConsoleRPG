package Item.CombatItem.RuneCombatItem.WeaponRuneCombatItem;
import java.util.*;

/**
 * @author JoseCorrero
 * 
 * Class DamageWeaponRuneCombatItem represents any WeaponRuneCombatItem that can be added 
 * to a WeaponEquipableCombatItemDecorator to create a DamageWeaponEquipableCombatItem.
 */
public class DamageWeaponRuneCombatItem extends WeaponRuneCombatItem {

    private int extraDamage;

    public DamageWeaponRuneCombatItem(int id, String name, Rarity rarity, String description, 
                                      int extraDamage) {
        super(id, name, rarity, description);
        this.extraDamage = extraDamage;
    }

    @override
    public int use() {
        return extraDamage;
    }

}