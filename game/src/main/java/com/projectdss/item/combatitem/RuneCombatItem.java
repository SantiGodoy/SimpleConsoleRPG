package Item.CombatItem;
import java.util.*;

/**
 * @author JoseCorrero
 * 
 * Class RuneCombatItem represents any CombatItem that can be added to 
 * an EquipableCombatItem to enhance it.
 */
public abstract class RuneCombatItem extends CombatItem {

    public RuneCombatItem() {}

    public RuneCombatItem(int id, String name, Rarity rarity, String description) {
        super(id, name, rarity, description);
    }

    public abstract int use();

}