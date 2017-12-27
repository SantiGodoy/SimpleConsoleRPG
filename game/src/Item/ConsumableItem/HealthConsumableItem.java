package Item.ConsumableItem;
import java.util.*;

/**
 * @author JoseCorrero
 * 
 * Class HealthConsumableItem represents any ConsumableItem 
 * that can be used to recover only health from inventory.
 */
public class HealthConsumableItem extends ConsumableItem {

    private int recoveryHealth;

    public HealthConsumableItem(int id, String name, Rarity rarity, String description, int recoveryHealth) {
        super(id, name, rarity, description);
        this.recoveryHealth = recoveryHealth;
    }

    @override
    public void use(MainCharacter player) {
        player.setCurrentHealth(player.getCurrentHealth() + recoveryHealth);
    }

}