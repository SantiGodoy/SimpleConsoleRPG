package com.projectdss;

import com.projectdss.Ability;
import com.projectdss.CharacterStats;
import com.projectdss.Event;
import com.projectdss.Item;
import com.projectdss.character.EnemyCharacter;
import com.projectdss.character.MainCharacter;
import com.projectdss.inventory.Inventory;
import com.projectdss.map.Minizone;
import com.projectdss.map.World;
import com.projectdss.map.Zone;

public class Loader {

    public World loadWorld(String filePath) {
        Zone zone0, zone1, zone2, zone3; 
        Minizone minizone00, minizone01, minizone10, minizone11, minizone12, minizone20,
        minizone21, minizone22, minizone30, minizone31, minizone32;

        Event combatEvent, exitMinizoneEvent, messageMinizoneEvent, travelMinizoneEvent,
        travelZoneEvent, enterZoneEvent, inventoryEvent;

        CharacterStats characterStats0, characterStats1, characterStats2;
        EnemyCharacter minionEnemyCharacter0, minionEnemyCharacter1, minionEnemyCharacter2;
        Ability ability0;
        Item item9, item10, item11;

        return null;
    }

    public MainCharacter loadMainCharacter(String filePath) {
        Ability ability1, ability2, ability3;
        Inventory inventory;

        CharacterStats characterStatsMain;
        
        Item item0, item1, item2,
            item3, item4,
            item5, item6,
            item7, item8;
        return null;
    }
}