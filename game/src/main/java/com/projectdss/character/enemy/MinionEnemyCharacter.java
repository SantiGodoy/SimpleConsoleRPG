package com.projectdss.character.enemy;

import com.projectdss.Ability;
import com.projectdss.CharacterStats;
import com.projectdss.Item;
import com.projectdss.character.EnemyCharacter;

import java.util.*;
public class MinionEnemyCharacter extends EnemyCharacter {
  
    public MinionEnemyCharacter(String name, int level, CharacterStats characterStats, Set<Ability> abilities, int xpDrop, String message, Map<Item, Integer> itemsDrop) {
        super(name, level, characterStats, abilities, xpDrop, message, itemsDrop);
    }
}