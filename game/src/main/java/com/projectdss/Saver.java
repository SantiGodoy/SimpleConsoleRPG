package com.projectdss;

import com.projectdss.character.MainCharacter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Saver {

    private void copyFile(File sourceFile, File destFile) throws IOException {
        if(!destFile.exists()) {
            destFile.createNewFile();
        }
    
        FileChannel source = null;
        FileChannel destination = null;
    
        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            destination.transferFrom(source, 0, source.size());
        }
        finally {
            if(source != null) {
                source.close();
            }
            if(destination != null) {
                destination.close();
            }
        }
    }

    public MainCharacter saveMainCharacter(String filePath) {
        try {

            File loadedFile = new File("../src/main/resources/map.xml");
            File savedFile = new File("../src/main/resources/save.xml");

            copyFile(loadedFile, savedFile);

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filePath);

            Node minizone00 = doc.getElementsByTagName("bean").item(0);
            Node attribute = minizone00.getAttributes().getNamedItem("name");

            //write the content into xml file
            Transformer xformer = TransformerFactory.newInstance().newTransformer();
            xformer.transform(new DOMSource(doc), new StreamResult(new File(filePath)));

		    System.out.println("Game saved");

           } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
           } catch (TransformerException tfe) {
            tfe.printStackTrace();
           } catch (IOException ioe) {
            ioe.printStackTrace();
           } catch (SAXException sae) {
            sae.printStackTrace();
           }
           return null;
    }
}