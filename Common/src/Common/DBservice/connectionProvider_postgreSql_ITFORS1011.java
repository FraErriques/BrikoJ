/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common.DBservice;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author fra
 */
public class connectionProvider_postgreSql_ITFORS1011 
{
    // Data
    private Connection connection=null;
    // config files:
    // in /var/lib/pgsql/data
    // file postgresql.conf
    /*
        listen_addresses = '*'	# what IP address(es) to listen on;
                                # comma-separated list of addresses;
                                # defaults to 'localhost'; use '*' for all
    */
    // file pg_hba.conf
    /*
        # IPv4 local connections:
        host    all             all             0.0.0.0/0            trust    
    */
    //
    //String connectionUrl_Eulero = "jdbc:postgresql://Eulero:5432/numerics", "postgres", "Riemann0"
    
    
    // Ctor
    public connectionProvider_postgreSql_ITFORS1011() throws Exception
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            //
            connection = DriverManager.getConnection("jdbc:postgresql://ITFORS1011:5432/Numerics", "postgres", "Riemann0");
            System.out.println(" Connection to database opened successfully");
        }
        catch( Exception e)
        {
            System.out.println(e.getMessage());
            // NO, stay in the app  : System.exit(0);
            throw e;
        }
    }// Ctor    
    
    
    public Connection getConnection()
    {
        return this.connection;
    }// getConnection()
    

    
    // like Dtor
    public void closeConnection()
    {
        try
        {
            if(null!=connection)
            {
                if( connection.isValid(0))
                {
                    connection.close();
                }// else connection already closed
            }// else connection already null
            System.out.println(" Connection to database closed successfully");            
        }
        catch( Exception e)
        {
            System.err.println( "\n "+e.getMessage() );
        }
    }// like Dtor

  
}// class
