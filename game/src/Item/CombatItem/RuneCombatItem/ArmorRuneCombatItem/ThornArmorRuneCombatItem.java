package Item.CombatItem.RuneCombatItem.ArmorRuneCombatItem;
import java.util.*;

/**
 * @author JoseCorrero
 * 
 * Class ThornArmorRuneCombatItem represents any ArmorRuneCombatItem that can be added 
 * to an ArmorEquipableCombatItemDecorator to create a ThornArmorEquipableCombatItem.
 */
public class ThornArmorRuneCombatItem extends ArmorRuneCombatItem {

    private int thorn;

    public ThornArmorRuneCombatItem(int id, String name, Rarity rarity, String description, 
                                    int thorn) {
        super(id, name, rarity, description);
        this.thorn = thorn;
    }

    @override
    public int use() {
        return thorn;
    }

}