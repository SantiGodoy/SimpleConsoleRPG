package Item.CombatItem.EquipableCombatItem.WeaponEquipableCombatItem.WeaponEquipableCombatItemDecorator;
import java.util.*;

/**
 * @author JoseCorrero
 *
 * Class ElementalWeaponEquipableCombatItem represents any WeaponEquipableCombatItemDecorator 
 * that has an ElementalWeaponRuneCombatItem added.
 */
public class ElementalWeaponEquipableCombatItem extends WeaponEquipableCombatItemDecorator {

    public ElementalWeaponEquipableCombatItem(int id, 
                                              WeaponEquipableCombatItem weapon,
                                              ElementalWeaponRuneCombatItem rune) {
        super(id, weapon, rune);
    }

    @override
    public void use(Character player1, Character player2) {
        return super.use(player1, player2) * ElementType.elementalMatrix[rune.use()][player2.getType()];
    }

}