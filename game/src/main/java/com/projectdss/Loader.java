package com.projectdss;

import com.projectdss.character.MainCharacter;
import com.projectdss.map.World;
import java.io.FileInputStream;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;


public class Loader {

    public World loadWorld(String filePath) {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource(filePath));

        World world = (World)factory.getBean("world");
        
        boolean adjacencyMatrixZone[][] = { {false, true, false, false},
                                            {true, false, true, false},
                                            {false, true, false, true},
                                            {false, false, true, false}};

        boolean adjacencyMatrixMinizone0[][] = {{false, true},
                                                {true, false}};

        boolean adjacencyMatrixMinizone1[][] = {{false, true, true},
                                                {true, false, true},
                                                {true, true, false}};
        
        boolean adjacencyMatrixMinizone2[][] = {{false, true, true},
                                                {true, false, true},
                                                {true, true, false}};

        boolean adjacencyMatrixMinizone3[][] = {{false, true, false},
                                                {true, false, true},
                                                {false, true, false}};

        world.setAdjacencyMatrixZone(adjacencyMatrixZone);
        world.getZones()[0].setAdjacencyMatrixMinizone(adjacencyMatrixMinizone0);
        world.getZones()[1].setAdjacencyMatrixMinizone(adjacencyMatrixMinizone1);
        world.getZones()[2].setAdjacencyMatrixMinizone(adjacencyMatrixMinizone2);
        world.getZones()[3].setAdjacencyMatrixMinizone(adjacencyMatrixMinizone3);

        return world;
    }

    public MainCharacter loadMainCharacter(String filePath) {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource(filePath));
        
        MainCharacter mainCharacter = (MainCharacter)factory.getBean("mainCharacter");

        return mainCharacter;
    }
}