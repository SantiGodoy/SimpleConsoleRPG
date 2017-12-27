package Item.CombatItem.RuneCombatItem;
import java.util.*;

/**
 * @author JoseCorrero
 * 
 * Class WeaponRuneCombatItem represents any RuneCombatItem that can be added to 
 * an WeaponEquipableCombatItem to enhance it.
 */
public abstract class WeaponRuneCombatItem extends RuneCombatItem {

    public WeaponRuneCombatItem() {}

    public WeaponRuneCombatItem(int id, String name, Rarity rarity, String description) {
        super(id, name, rarity, description);
    }

}