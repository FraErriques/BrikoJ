/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common.DBservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author fra
 */
public class PostgreSql 
{
    // Data
    Connection connection=null;    
    //String connectionUrl_Eulero = "jdbc:postgresql://Eulero:5432/numerics", "postgres", "Riemann0"
    
    
    // Ctor
    public PostgreSql()
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:postgresql://Eulero:5432/numerics", "postgres", "Riemann0");
        }
        catch( Exception e)
        {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println(" Connection to database opened successfully");         
    }// Ctor    
    
    
    public void insertionLoop_template()
    {
        try
        {
            // create a Statement from the connection
            Statement statement = connection.createStatement();                
            //-----
            String sqlStatement;

            double x = +3.0;
            double Dx = 0.01;
            for( ; x<+6.0; x+=Dx)
            {
                // call   usp_dump2021dez30_insert( 0.0 , 0.0);
                sqlStatement=" call   usp_dump2021dez30_insert( ";
                sqlStatement += String.valueOf(x);
                sqlStatement += " , ";// separation between parameters.
                sqlStatement += String.valueOf( Math.sin(x) );
                sqlStatement += " );";
                // insert the data
                statement.executeUpdate( sqlStatement);
            }
            // ! connection.commit();// NB.  Cannot commit when autoCommit is enabled. 
        }
        catch( Exception e)
        {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }        
    }// insertionLoop_template
    
    
    
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
                }
            }
        }
        catch( Exception e)
        {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }        
        System.out.println(" Connection to database closed successfully");        
    }// like Dtor    

    
    
    
}// class
