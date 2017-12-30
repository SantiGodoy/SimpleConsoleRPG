package Item.CombatItem.RuneCombatItem.ArmorRuneCombatItem;
import java.util.*;

/**
 * @author JoseCorrero
 * 
 * Class ElementalArmorRuneCombatItem represents any ArmorRuneCombatItem that can be added 
 * to an ArmorEquipableCombatItemDecorator to create an ElementalArmorEquipableCombatItem.
 */
public class ElementalArmorRuneCombatItem extends ArmorRuneCombatItem {

    private ElementType type;

    public ElementalArmorRuneCombatItem(int id, String name, Rarity rarity, String description, 
                                        ElementType type) {
        super(id, name, rarity, description);
        this.type = type;
    }

    @override
    public int use() {
        return type;
    }

}