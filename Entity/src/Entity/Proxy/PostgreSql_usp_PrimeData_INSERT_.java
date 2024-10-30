/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity.Proxy;

import java.sql.Statement;

/**
 *
 * @author admin
 */
public class PostgreSql_usp_PrimeData_INSERT_ {

  
    public static void usp_PrimeData_INSERT_(
            java.sql.Connection connection,
            //
            long Prime
    )
    {
        try
        {
            if(null==connection ||  !connection.isValid(0) )
            {
                return;
            }// else continue.
            // create a Statement from the connection
            Statement statement = connection.createStatement();                
            String sqlStatement;
            //
            sqlStatement="CALL public.usp_primedata_insert(  ";
            sqlStatement += String.valueOf( Prime);
            sqlStatement += " );";
            // insert the data
            statement.executeUpdate( sqlStatement);
            //  connection.commit(); NB.  Cannot commit when autoCommit is enabled. 
        }
        catch( Exception e)
        {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }        
    }// db Numerics usp_primedata_insert

    
}// class
