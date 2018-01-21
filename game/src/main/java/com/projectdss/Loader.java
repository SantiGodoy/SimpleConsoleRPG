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
       
        return mainCharacter;
    }
}