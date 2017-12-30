package Item.CombatItem.EquipableCombatItem.WeaponEquipableCombatItem;
import java.util.*;

/**
 * @author JoseCorrero
 *
 * Class SimpleWeaponEquipableCombatItem represents any WeaponEquipableCombatItem
 * that has not been enhanced with any WeaponRuneCombatItem.
 */
public class SimpleWeaponEquipableCombatItem extends WeaponEquipableCombatItem {

    public SimpleWeaponEquipableCombatItem(int id, String name, Rarity rarity, String description, 
                                           int baseDamage) {
        super(id, name, rarity, description, baseDamage);
    }

    @override
    public int use(Character player1, Character player2) {
        int damagePlayer1  = player1.getStrength() + baseDamage,
            defensePlayer2 = player2.getDefense();

        if(defensePlayer2 < damagePlayer1)
            return damagePlayer1 - defensePlayer2;
        else
            return 0;
    }

}