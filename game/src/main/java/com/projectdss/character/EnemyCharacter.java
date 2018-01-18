package com.projectdss.character;

import java.util.Set;
import java.util.Map;
import com.projectdss.Item;
import com.projectdss.Ability;
import com.projectdss.Character;
import com.projectdss.CharacterStats;

/**
 * 
 */
public abstract class EnemyCharacter extends Character {

    protected final int xpDrop;
    protected final String message;
    protected final Map<Item, Integer> itemsDrop;
    
    public EnemyCharacter(String name, int level, CharacterStats characterStats, Set<Ability> abilities, int xpDrop, String message, Map<Item, Integer> itemsDrop) {
        super(name, level, characterStats, abilities);   
        this.xpDrop = xpDrop;
        this.itemsDrop = itemsDrop;
        this.message = message;
    }

    public int getXPDrop() {
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

}