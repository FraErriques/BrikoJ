/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common.DBservice;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
 



public class ConnectionProviderPostgreSqlCantor {
    
    // Data
    private Connection connection = null;

    // Ctor
    public ConnectionProviderPostgreSqlCantor() throws SQLException, IOException {
        Properties props = new Properties();
        
        // Load properties from the config folder (bundled into classpath root)
        try (InputStream input = ConnectionProviderPostgreSqlCantor.class
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
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");
            
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection to database Cantor::logging opened successfully");
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
            System.out.println("Connection to database Cantor::logging closed successfully");
        } catch (SQLException e) {
            System.out.println("\n " + e.getMessage());
        }
    }// closeConnection
    
    
}// class    
