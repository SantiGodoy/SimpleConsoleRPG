package Item.CombatItem;
import java.util.*;

/**
 * @author JoseCorrero
 * 
 * Class EquipableCombatItem represents any CombatItem that can be equipped.
 */
public abstract class EquipableCombatItem extends Item {

    protected boolean equipped;

    public EquipableCombatItem() {}

    public EquipableCombatItem(int id, String name, int rarity, String description) {
        super(id, name, rarity, description);
        equipped = false;
    }

    public void setEquipped(bool equipped) {
        this.equipped = equipped;
    }

    public boolean isEquipped() {
        return equipped;
    }

}