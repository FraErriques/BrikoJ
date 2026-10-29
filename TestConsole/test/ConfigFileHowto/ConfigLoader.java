/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.ConfigFileHowto;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;

public class ConfigLoader {
    
    public void read_AppConfig(String[] args) {
        try {
            File xmlFile = new File("AppConfig.xml");
            
            // 1. Create a factory and builder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            // 2. Parse the entire file into memory as a DOM tree
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            
            // 3. Extract configuration values safely
            String serverIp = doc.getElementsByTagName("ip").item(0).getTextContent();
            int port = Integer.parseInt(doc.getElementsByTagName("port").item(0).getTextContent());
            
            System.out.println("Server IP: " + serverIp);
            System.out.println("Server Port: " + port);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}// class
