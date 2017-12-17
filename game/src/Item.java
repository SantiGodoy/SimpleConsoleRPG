
import java.util.*;

/**
 * 
 */
public abstract class Item {

    /**
     * Default constructor
     */
    public Item() {
    }

    /**
     * 
     */
    protected int id;

    /**
     * 
     */
    protected String name;

    /**
     * 
     */
    protected int rarity;

    /**
     * 
     */
    protected String description;

    /**
     * 
     */
    protected int price;




    /**
     * @param id 
     * @param name 
     * @param rarity 
     * @param description 
     * @param price
     */
    public void Item(int id, String name, int rarity, String description, int price) {
        // TODO implement here
    }

    /**
     * @param id
     */
    public void setId(int id) {
        // TODO implement here
    }

    /**
     * @param name
     */
    public void setName(String name) {
        // TODO implement here
    }

    /**
     * @param rarity
     */
    public void setRarity(int rarity) {
        // TODO implement here
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        // TODO implement here
    }

    /**
     * @param price
     */
    public void setPrice(int price) {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getId() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public String getName() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public int getRarity() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public String getDescription() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public int getPrice() {
        // TODO implement here
        return 0;
    }

}