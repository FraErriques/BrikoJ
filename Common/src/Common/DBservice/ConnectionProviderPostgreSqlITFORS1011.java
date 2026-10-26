
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

    // Ctor
    public ConnectionProviderPostgreSqlITFORS1011() throws SQLException, IOException {
        Properties props = new Properties();
        
        // Load properties from the config folder (bundled into classpath root)
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

        try {
            // ==========================================
            // Selecting a specific host dynamically
            // ==========================================
            String targetHost = "ITFORS1011"; // Could be passed as an argument: "host1" or "host2"

            String url = props.getProperty("db." + targetHost + ".url");
            String user = props.getProperty("db." + targetHost + ".user");
            String password = props.getProperty("db." + targetHost + ".password");            
            
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection to database ITFORS1011::logging opened successfully");
        } catch (SQLException e) {
            System.out.println("Failed to connect: " + e.getMessage());
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
    
