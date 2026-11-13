/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common.ConfigurationService;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;

public class ConfigReader {

    public static void agentFetchSingleConnection() {
        try {
            // 1. Load and parse the XML document
            File xmlFile = new File("config.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // 2. Set up XPath query
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            
            // Exact same XPath query used in your C++ function
            String expression = "//database/server[@name='Cantor' and db-model='PostgreSql']";
            Node serverNode = (Node) xpath.evaluate(expression, doc, XPathConstants.NODE);

            if (serverNode != null && serverNode.getNodeType() == Node.ELEMENT_NODE) {
                Element srv = (Element) serverNode;

                // 3. Read attributes and child elements directly from the targeted node
                String serverName = srv.getAttribute("name");
                String dbModel  = srv.getElementsByTagName("db-model").item(0).getTextContent();
                String port     = srv.getElementsByTagName("port").item(0).getTextContent();
                String dbName   = srv.getElementsByTagName("db_name").item(0).getTextContent();
                String user     = srv.getElementsByTagName("user").item(0).getTextContent();
                String password = srv.getElementsByTagName("password").item(0).getTextContent();
                String schema   = srv.getElementsByTagName("schema").item(0).getTextContent();

                // 4. Build the PostgreSQL connection string
                String connStr = "host=" + serverName +
                                 " port=" + port +
                                 " dbname=" + dbName +
                                 " user=" + user +
                                 " password=" + password +
                                 " options=-csearch_path=" + schema;

                System.out.println("Loaded connection for target server: " + connStr);

                // LogSinkDb logger = new LogSinkDb("mercurio", serverName, connStr);
                for (int c = 0; c < 3; c++) {
                    // logger.trace("Java", "1", "main", "Java : specific connection via XPath.");
                }
                // logger.dispose();
                System.out.println("Connection string: " + connStr);

            } else {
                System.err.println("Error: Specified server configuration not found in XML.");
            }

        } catch (Exception e) {
            System.err.println("XML parse error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}