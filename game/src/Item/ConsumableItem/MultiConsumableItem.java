package Item.ConsumableItem;
import java.util.*;

/**
 * @author JoseCorrero
 * 
 * Class MultiConsumableItem represents any ConsumableItem that can be used to recover health and mana, 
 * at the same item, from inventory.
 */
public class MultiConsumableItem extends ConsumableItem {

    private int recoveryHealth;
    private int recoveryMana;

    public MultiConsumableItem(int id, String name, Rarity rarity, String description, int recoveryHealth, int recoveryMana) {
        super(id, name, rarity, description);
        this.recoveryHealth = recoveryHealth;
        this.recoveryMana = recoveryMana;
    }

    @override
    public void use(MainCharacter player) {
        player.setCurrentHealth(player.getCurrentHealth + recoveryHealth);
        player.setCurrentMana(player.getCurrentMana + recoveryMana);
    }

}