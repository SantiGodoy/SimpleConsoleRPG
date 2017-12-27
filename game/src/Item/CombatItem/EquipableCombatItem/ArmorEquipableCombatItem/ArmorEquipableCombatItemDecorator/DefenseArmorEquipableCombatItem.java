package Item.CombatItem.EquipableCombatItem.ArmorEquipableCombatItem.ArmorEquipableCombatItemDecorator;
import java.util.*;

/**
 * @author JoseCorrero
 *
 * Class DefenseArmorEquipableCombatItem represents any ArmorEquipableCombatItemDecorator 
 * that has a DefenseArmorRuneCombatItem added.
 */
public class DefenseArmorEquipableCombatItem extends ArmorEquipableCombatItemDecorator {

    public DefenseArmorEquipableCombatItem(int id, 
                                           ArmorEquipableCombatItem armor,
                                           DefenseArmorRuneCombatItem rune) {
        super(id, armor, rune);
    }

    @override
    public int use(Character player1, Character player2) {
        int damageApplied   = super.use(player1, player2),
            damageMitigated = rune.use();

        if(damageMitigated >= damageApplied)
            return 0;
        else
            return damageApplied - damageMitigated;
    }

}