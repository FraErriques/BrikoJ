/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common.DBservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProviderPostgres {
    private Connection connection;
    private final String serverName;

    public ConnectionProviderPostgres(String serverName, String dbUrl, String user, String password) {
        this.serverName = serverName;
        try {
            // Explicitly load the PostgreSQL JDBC driver for Ant classloader compatibility
            Class.forName("org.postgresql.Driver");

            // Establish the PostgreSQL JDBC connection (ensure URL starts with jdbc:postgresql://)
            this.connection = DriverManager.getConnection(dbUrl, user, password);
            System.out.println("Connection to database " + serverName + " opened successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found in classpath: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("Failed to connect to " + serverName + ": " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection to database " + serverName + " closed successfully");
            }
        } catch (SQLException e) {
            System.out.println("\nError closing connection for " + serverName + ": " + e.getMessage());
        }
    }
}