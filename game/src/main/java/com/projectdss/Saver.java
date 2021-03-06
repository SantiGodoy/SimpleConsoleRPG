package com.projectdss;

import com.projectdss.character.MainCharacter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.channels.FileChannel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
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

            File loadedFile = new File("../src/main/resources/newGame.xml");
            File savedFile = new File("../src/main/resources/save.xml");

            copyFile(loadedFile, savedFile);

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse("../src/main/resources/map.xml");

            //Node minizone00 = doc.getElementsByTagName("bean").item(0);
            //Node attribute = minizone00.getAttributes().getNamedItem("name");

            //write the content into xml file
            Transformer xformer = TransformerFactory.newInstance().newTransformer();
            xformer.setOutputProperty(OutputKeys.INDENT, "yes");
            xformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            xformer.setOutputProperty(OutputKeys.METHOD, "xml");

            DOMImplementation domImpl = docBuilder.getDOMImplementation();
            DocumentType docType = domImpl.createDocumentType("doctype", "-//SPRING//DTD BEAN//EN",
            "http://www.springframework.org/dtd/spring-beans.dtd");
            xformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, docType.getPublicId());
            xformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, docType.getSystemId());

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            xformer.transform(source, result);

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