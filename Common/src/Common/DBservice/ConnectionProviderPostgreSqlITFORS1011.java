
package Common.DBservice;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionProviderPostgreSqlITFORS1011 {
    
    // Data
    private Connection connection = null;

    
    /*
    for (String key : props.stringPropertyNames()) {
    String value = props.getProperty(key);
    System.out.println(key + " = " + value);
}
    props.list(System.out);
    
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class DatabaseConfigUtils {

    //
    // * Parses the properties object to dynamically find and return all unique host names.
    // * Looks for keys matching the pattern: db.<hostname>.<property>
     
    public static Set<String> getAvailableHosts(Properties props) {
        Set<String> hosts = new HashSet<>();
        
        for (String key : props.stringPropertyNames()) {
            // Split the key by dots: e.g., "db.Cantor.url" becomes ["db", "Cantor", "url"]
            String[] parts = key.split("\\.");
            
            // Check if it matches our expected pattern (at least 3 parts and starts with "db")
            if (parts.length >= 3 && parts[0].equals("db")) {
                hosts.add(parts[1]); // The second part is the host name
            }
        }
        
        return hosts;
    }
    
    
    Properties props = new Properties();
// ... load properties from input stream ...

// Get and print all discovered hosts
Set<String> hosts = DatabaseConfigUtils.getAvailableHosts(props);
System.out.println("Available database hosts configured: " + hosts);

// Output will be something like: [Cantor, ITFORS1011]
}    
    
    */
    
// Ctor    
public ConnectionProviderPostgreSqlITFORS1011(String targetHost) throws SQLException, IOException {
    Properties props = new Properties();
    
    // 1. Load the properties file
    try (InputStream input = ConnectionProviderPostgreSqlITFORS1011.class
            .getClassLoader()
            .getResourceAsStream("database.properties")) {
        
        if (input == null) {
            throw new IOException("Unable to find database.properties in classpath.");
        }
        props.load(input);
    } catch (IOException e) {
        System.out.println("Error reading configuration file: " + e.getMessage());
        throw e;
    }

    // 2. Build the property keys dynamically based on the passed parameter
    String urlKey = "db." + targetHost + ".url";
    String userKey = "db." + targetHost + ".user";
    String passKey = "db." + targetHost + ".password";

    // 3. Retrieve values and handle "host not found" / missing configuration gracefully
    String url = props.getProperty(urlKey);
    if (url == null) {
        throw new IllegalArgumentException("Configuration error: Host '" + targetHost + "' is not defined in database.properties (missing key: " + urlKey + ")");
    }
    
    String user = props.getProperty(userKey, "default_user"); // Optional fallback
    String password = props.getProperty(passKey, "");

    try {
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connection to database " + targetHost + "::logging opened successfully");
    } catch (SQLException e) {
        System.out.println("Failed to connect to " + targetHost + ": " + e.getMessage());
        throw e;
    }
}// Ctor

    public Connection getConnection() {
        return this.connection;
    }

    // Explicit manual close method
    
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                if (connection.isValid(2)) {
                    connection.close();
                }
            }
            System.out.println("Connection to database ITFORS1011::logging closed successfully");
        } catch (SQLException e) {
            System.out.println("\n " + e.getMessage());
        }
    }// closeConnection
    
    
}// class    
    
