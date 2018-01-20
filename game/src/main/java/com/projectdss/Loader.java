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

        CharacterStats characterStats0 = (CharacterStats)factory.getBean("characterStats0");
        CharacterStats characterStats1 = (CharacterStats)factory.getBean("characterStats1");
        CharacterStats characterStats2 = (CharacterStats)factory.getBean("characterStats2");
        EnemyCharacter minionEnemyCharacter0 = (EnemyCharacter)factory.getBean("minionEnemyCharacter0");
        EnemyCharacter minionEnemyCharacter1 = (EnemyCharacter)factory.getBean("minionEnemyCharacter1");
        EnemyCharacter minionEnemyCharacter2 = (EnemyCharacter)factory.getBean("minionEnemyCharacter2");
        Ability ability0 = (Ability)factory.getBean("ability0");
        Item item9 = (Item)factory.getBean("item9");
        Item item10 = (Item)factory.getBean("item10");
        Item item11 = (Item)factory.getBean("item11");

        Event enterZoneEvent = (Event)factory.getBean("eventz0");
        Event travelZoneEvent = (Event)factory.getBean("eventz1");
        Event combatEvent = (Event)factory.getBean("event0");
        Event exitMinizoneEvent = (Event)factory.getBean("event1");
        Event travelMinizoneEvent = (Event)factory.getBean("event2");
        Event messageMinizoneEvent = (Event)factory.getBean("event3");
        Event inventoryEvent = (Event)factory.getBean("event4");

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

        Zone zone0 = (Zone)factory.getBean("zone0");
        Zone zone1 = (Zone)factory.getBean("zone1");
        Zone zone2 = (Zone)factory.getBean("zone2");
        Zone zone3 = (Zone)factory.getBean("zone3");

        World world = (World)factory.getBean("world");

        return world;
    }

    public MainCharacter loadMainCharacter(String filePath) {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource(filePath));
        Ability ability1 = (Ability)factory.getBean("ability1");
        Ability ability2 = (Ability)factory.getBean("ability2");
        Ability ability3 = (Ability)factory.getBean("ability3");

        Item item0 = (Item)factory.getBean("item0");
        Item item1 = (Item)factory.getBean("item1");
        Item item2 = (Item)factory.getBean("item2");
        Item item3 = (Item)factory.getBean("item3");
        Item item4 = (Item)factory.getBean("item4");
        Item item5 = (Item)factory.getBean("item5");
        Item item6 = (Item)factory.getBean("item6");
        Item item7 = (Item)factory.getBean("item7");
        Item item8 = (Item)factory.getBean("item8");
        Inventory inventory = (Inventory)factory.getBean("inventory");

        CharacterStats characterStatsMain = (CharacterStats)factory.getBean("characterStatsMain");

        MainCharacter mainCharacter = (MainCharacter)factory.getBean("mainCharacter");

        return mainCharacter;
    }
}