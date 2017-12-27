package Item.CombatItem.EquipableCombatItem.WeaponEquipableCombatItem.WeaponEquipableCombatItemDecorator;
import java.util.*;

/**
 * @author JoseCorrero
 *
 * Class LifestealWeaponEquipableCombatItem represents any WeaponEquipableCombatItemDecorator 
 * that has a LifestealWeaponRuneCombatItem added.
 */
public class LifestealWeaponEquipableCombatItem extends WeaponEquipableCombatItemDecorator {

    public LifestealWeaponEquipableCombatItem(int id, 
                                              WeaponEquipableCombatItem weapon,
                                              LifestealWeaponRuneCombatItem rune) {
        super(id, weapon, rune);
    }

    @override
    public int use(Character player1, Character player2) {
        int damageApplied = super.use(player1, player2),
            stolenHealth  = damageApplied * rune.use() / 100;

        player1.setCurrentHealth(player1.getCurrentHealth() + stolenHealth);

        return damageApplied;
    }

}