package Item.CombatItem.RuneCombatItem.WeaponRuneCombatItem;
import java.util.*;

/**
 * @author JoseCorrero
 * 
 * Class ElementalWeaponRuneCombatItem represents any WeaponRuneCombatItem that can be added 
 * to a WeaponEquipableCombatItemDecorator to create a ElementalWeaponEquipableCombatItem.
 */
public class ElementalWeaponRuneCombatItem extends WeaponRuneCombatItem {

    private ElementType type;

    public ElementalWeaponRuneCombatItem(int id, String name, Rarity rarity, String description, 
                                         ElementType type) {
        super(id, name, rarity, description);
        this.type = type;
    }

    @override
    public int use() {
        return type;
    }

}