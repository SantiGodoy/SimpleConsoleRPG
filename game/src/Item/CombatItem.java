package Item;
import java.util.*;

/**
 * @author JoseCorrero
 * 
 * Class CombatItem represents any Item that can be used in combat.
 */
public class CombatItem extends Item {

    protected boolean merged;

    public CombatItem() {}

    public CombatItem(int id, String name, Rarity rarity, String description) {
        super(id, name, rarity, description);
        this.merged = false;
    }

    public boolean isMerged() {
        return merged;
    }

    public abstract void use(Character player1, Character player2);

}