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
import java.io.FileInputStream;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;


public class Loader {

    public World loadWorld(String filePath) {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource(filePath));
        World world = (World)factory.getBean("world");
        
        Zone zone0 = (Zone)factory.getBean("zone0");
        Zone zone1 = (Zone)factory.getBean("zone1");
        Zone zone2 = (Zone)factory.getBean("zone2");
        Zone zone3 = (Zone)factory.getBean("zone3");

        Minizone minizone00 = (Minizone)factory.getBean("minizone00");
        Minizone minizone01 = (Minizone)factory.getBean("minizone01");
        Minizone minizone10 = (Minizone)factory.getBean("minizone10");
        Minizone minizone11 = (Minizone)factory.getBean("minizone11");
        Minizone minizone12 = (Minizone)factory.getBean("minizone12");
        Minizone minizone20 = (Minizone)factory.getBean("minizone20");
        Minizone minizone21 = (Minizone)factory.getBean("minizone21");
        Minizone minizone22 = (Minizone)factory.getBean("minizone22");
        Minizone minizone30 = (Minizone)factory.getBean("minizone30");
        Minizone minizone31 = (Minizone)factory.getBean("minizone31");
        Minizone minizone32 = (Minizone)factory.getBean("minizone32");

        Event enterZoneEvent = (Event)factory.getBean("eventz0");
        Event travelZoneEvent = (Event)factory.getBean("eventz1");
        Event combatEvent = (Event)factory.getBean("event0");
        Event exitMinizoneEvent = (Event)factory.getBean("event1");
        Event travelMinizoneEvent = (Event)factory.getBean("event2");
        Event messageMinizoneEvent = (Event)factory.getBean("event3");
        Event inventoryEvent = (Event)factory.getBean("event4");

        CharacterStats characterStats0 = (CharacterStats)factory.getBean("characterStats0");
        CharacterStats characterStats1 = (CharacterStats)factory.getBean("characterStats1");
        CharacterStats characterStats2 = (CharacterStats)factory.getBean("characterStats2");
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