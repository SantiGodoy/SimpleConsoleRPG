package com.projectdss;

import com.projectdss.character.MainCharacter;
import java.io.FileInputStream;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;


public class Loader {

    public MainCharacter loadMainCharacter(String filePath) {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource(filePath));
        
        MainCharacter mainCharacter = (MainCharacter)factory.getBean("mainCharacter");
        boolean adjacencyMatrixZone[][] = { {false, true, true, false},
                                            {true, false, false, true},
                                            {true, false, false, true},
                                            {false, true, true, false}};

        boolean adjacencyMatrixMinizone0[][] = {{false, true, true, false},
                                                {true, false, false, true},
                                                {true, false, false, true},
                                                {false, true, true, false}};

        boolean adjacencyMatrixMinizone1[][] = {{false, true, true, false},
                                                {true, false, false, true},
                                                {true, false, false, true},
                                                {false, true, true, false}};
        
        boolean adjacencyMatrixMinizone2[][] = {{false, true, true, false},
                                                {true, false, false, true},
                                                {true, false, false, true},
                                                {false, true, true, false}};

        boolean adjacencyMatrixMinizone3[][] = {{false, true, true, false},
                                                {true, false, false, true},
                                                {true, false, false, true},
                                                {false, true, true, false}};

        mainCharacter.getWorld().setAdjacencyMatrixZone(adjacencyMatrixZone);
        mainCharacter.getWorld().getZones()[0].setAdjacencyMatrixMinizone(adjacencyMatrixMinizone0);
        mainCharacter.getWorld().getZones()[1].setAdjacencyMatrixMinizone(adjacencyMatrixMinizone1);
        mainCharacter.getWorld().getZones()[2].setAdjacencyMatrixMinizone(adjacencyMatrixMinizone2);
        mainCharacter.getWorld().getZones()[3].setAdjacencyMatrixMinizone(adjacencyMatrixMinizone3);

        return mainCharacter;
    }
}