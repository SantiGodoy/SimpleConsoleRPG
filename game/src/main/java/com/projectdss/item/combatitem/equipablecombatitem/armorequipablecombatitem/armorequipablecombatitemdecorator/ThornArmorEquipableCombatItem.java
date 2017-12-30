package Item.CombatItem.EquipableCombatItem.ArmorEquipableCombatItem.ArmorEquipableCombatItemDecorator;
import java.util.*;

/**
 * @author JoseCorrero
 *
 * Class ThornArmorEquipableCombatItem represents any ArmorEquipableCombatItemDecorator 
 * that has a ThornArmorRuneCombatItem added.
 */
public class ThornArmorEquipableCombatItem extends ArmorEquipableCombatItemDecorator {

    public ThornArmorEquipableCombatItem(int id, 
                                         ArmorEquipableCombatItem armor,
                                         ThornArmorRuneCombatItem rune) {
        super(id, armor, rune);
    }

    @override
    public int use(Character player1, Character player2) {
        int damageApplied  = super.use(player1, player2),
            damageTaken    = (damageApplied * rune.use() / 100) - player1.getDefense();

        player1.setCurrentHealth(player1.getCurrentHealth() - damageTaken);

        return damageApplied;
    }

}