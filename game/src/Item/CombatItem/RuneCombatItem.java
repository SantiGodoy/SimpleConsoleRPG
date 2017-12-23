package Item.CombatItem;
import java.util.*;

/**
 * @author JoseCorrero
 * 
 * Class RuneCombatItem represents any CombatItem that can be added to an EquipableCombatItem
 * to create a decorated EquipableCombatItem.
 */
public class RuneCombatItem extends CombatItem {

    public RuneCombatItem(int id, String name, int rarity, String description) {
        super(id, name, rarity, description);
    }

}