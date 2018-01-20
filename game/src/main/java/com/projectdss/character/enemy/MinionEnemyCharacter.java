package com.projectdss.character.enemy;

import com.projectdss.Ability;
import com.projectdss.CharacterStats;
import com.projectdss.ElementType;
import com.projectdss.Item;
import java.util.Map;
import java.util.Set;

import com.projectdss.character.EnemyCharacter;

/**
 * @author JoseCorrero
 * 
 * Class MinionEnemyCharacter.
 */
public class MinionEnemyCharacter extends EnemyCharacter {

    public MinionEnemyCharacter() {}

    public MinionEnemyCharacter(String name, int level, CharacterStats characterStats, Set<Ability> abilities, int xpDrop, String message, Map<Item, Integer> itemsDrop) {
        super(name, level, characterStats, abilities, xpDrop, message, itemsDrop);
    }

}