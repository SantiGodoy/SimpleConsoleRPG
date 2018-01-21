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
    protected String initMessage, endMessage;
    protected Map<Item, Integer> itemsDrop;

    public EnemyCharacter() {}
    
    public EnemyCharacter(String name, int level, CharacterStats characterStats, Set<Ability> abilities, int xpDrop, String initMessage, String endMessage, Map<Item, Integer> itemsDrop) {
        super(name, level, characterStats, abilities);   
        this.xpDrop = xpDrop;
        this.itemsDrop = itemsDrop;
        this.initMessage = initMessage;
        this.endMessage = endMessage;
    }

    public int getxpDrop() {
        return xpDrop;
    }
 
    public String getInitMessage() {
        return initMessage;
    }

    public String getEndMessage() {
        return endMessage;
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

    public void setInitMessage(String initMessage) {
        this.initMessage = initMessage;
    }

    public void setEndMessage(String endMessage) {
        this.endMessage = endMessage;
    }

    public void setItemsDrop(Map<Item, Integer> itemsDrop) {
        this.itemsDrop = itemsDrop;
    }

}