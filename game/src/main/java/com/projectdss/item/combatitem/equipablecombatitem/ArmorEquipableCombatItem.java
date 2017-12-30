package Item.CombatItem.EquipableCombatItem;
import java.util.*;

/**
 * @author JoseCorrero
 * 
 * Class ArmorEquipableCombatItem represents any EquipableCombatItem 
 * that can be equipped as armor.
 */
public abstract class ArmorEquipableCombatItem extends EquipableCombatItem {
    
    protected int baseDefense;
    
    public ArmorEquipableCombatItem() {}
    
    public ArmorEquipableCombatItem(int id, String name, Rarity rarity, String description, 
                                    int baseDefense) {
        super(id, name, rarity, description);
        this.baseDefense = baseDefense;
    }

    public void setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

}