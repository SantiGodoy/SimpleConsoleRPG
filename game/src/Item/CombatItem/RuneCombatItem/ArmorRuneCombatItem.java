package Item.CombatItem.RuneCombatItem;
import java.util.*;

/**
 * @author JoseCorrero
 * 
 * Class ArmorRuneCombatItem represents any RuneCombatItem that can be added to 
 * an ArmorEquipableCombatItem to enhace it.
 */
public abstract class ArmorRuneCombatItem extends RuneCombatItem {

    public ArmorRuneCombatItem() {}

    public ArmorRuneCombatItem(int id, String name, Rarity rarity, String description) {
        super(id, name, rarity, description);
    }

}