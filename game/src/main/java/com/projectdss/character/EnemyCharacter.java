package com.projectdss.character;

import java.util.Set;
import java.util.Map;
import com.projectdss.Item;
import com.projectdss.Ability;
import com.projectdss.Character;
import com.projectdss.CharacterStats;

/**
 * @author JoseCorrero
 * 
 * Class EnemyCharacter.
 */
public abstract class EnemyCharacter extends Character {

    protected int xpDrop;
    protected String message;
    protected Map<Item, Integer> itemsDrop;

    public EnemyCharacter() {}
    
    public EnemyCharacter(String name, int level, CharacterStats characterStats, Set<Ability> abilities, int xpDrop, String message, Map<Item, Integer> itemsDrop) {
        super(name, level, characterStats, abilities);   
        this.xpDrop = xpDrop;
        this.itemsDrop = itemsDrop;
        this.message = message;
    }

    public int getxpDrop() {
        return xpDrop;
    }
 
    public String getMessage() {
        return message;
    }
 
    public Map<Item, Integer> getItemsDrop() {
        return itemsDrop;
    }

    @Override
    public String getGender() {
        return "Monster";
    }

    public void setxpDrop(int xpDrop) {
        this.xpDrop = xpDrop;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setItemsDrop(Map<Item, Integer> itemsDrop) {
        this.itemsDrop = itemsDrop;
    }

}