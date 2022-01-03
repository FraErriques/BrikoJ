/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common.DBservice;

import java.sql.Connection;
import java.sql.DriverManager;// mssql i.e. Microsoft SqlServer
import java.sql.Statement;


/**
 *
 * @author fra
 */
public class MsSql 
{
    // Data
    Connection connection=null;
    // for named-instances the syntax seems to be "jdbc:sqlserver://vvv;instanceName=iii"
    // where vvv is the hostname (xor IP) and instanceName is the instance name. NB. the separator is a semicolon ';' and there's an'=' sign
    // between the token instanceName and the actual instance-name.
    //Update the username and password below
    // String connectionUrl = "jdbc:sqlserver://ITBZOW1422;instanceName=SqlExpress:1433;databaseName=dotazioni2021;user=sa;password=M1 Sxpdx";
    // String connectionUrl = "jdbc:sqlserver://ITBZOW1422;instanceName=SqlExpress;databaseName=dotazioni2021;user=sa;password=M1 Sxpdx";
    // String connectionUrl   = "jdbc:sqlserver://Cantor;databaseName=PrimeData;user=sa;password=Riemann0"; TODO Cantor
    //String connectionUrl   = "jdbc:sqlserver://Kronecker;instanceName=Delta;databaseName=PrimeData;user=sa;password=Riemann0";
    // String connectionUrl = "jdbc:sqlserver://ITBZOW1422;instanceName=SqlExpress:1433;databaseName=dotazioni2021;user=sa;password=M1 Sxpdx";
    //String connectionUrl = "jdbc:sqlserver://ITBZOW1422;instanceName=SqlExpress:1434;databaseName=dotazioni2021;user=sa;password=M1 Sxpdx";        
    //String connectionUrl = "jdbc:sqlserver://ITBZOW1422;instanceName=SqlExpress;databaseName=dotazioni2021;user=sa;password=M1 Sxpdx";
    //String connectionUrl = "jdbc:sqlserver://192.168.30.63;instanceName=SqlExpress:1434;databaseName=dotazioni2021;user=sa;password=M1 Sxpdx";
    //String connectionUrl = "jdbc:sqlserver://192.168.30.63;instanceName=ExpressLie:1434;databaseName=dotazioni2021;user=sa;password=M1 Sxpdx";
    //String connectionUrl = "jdbc:sqlserver://192.168.30.63;instanceName=ExpressLie:1434;databaseName=PrimeData;user=applicationuser;password=curricula";
    //String connectionUrl = "jdbc:sqlserver://192.168.30.63;instanceName=ExpressLie:1433;databaseName=PrimeData;user=applicationuser;password=curricula";
    //String connectionUrl = "jdbc:sqlserver://ITBZOW1422.BBT.INT;instanceName=ExpressLie;databaseName=PrimeData;user=applicationuser;password=curricula";
    // String connectionUrl = "jdbc:sqlserver://Cantor;databaseName=PrimeData;user=sa;password=Riemann0";
    //String connectionUrl_Eulero = "jdbc:sqlserver://Eulero;databaseName=TestDb;user=sa;password=Riemann0";    
    //"jdbc:microsoft:sqlserver://Cantor:1433;DatabaseName=PrimeData", "sa", "sa");    
    String connectionUrl_ITBZ = "jdbc:sqlserver://ITBZOW1422;instanceName=Delta;databaseName=dotazioni2021;user=sa;password=M1 Sxpdx";
    
    
    // Ctor
    public MsSql()
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(connectionUrl_ITBZ);
        }
        catch( Exception e)
        {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
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
                sqlStatement="exec usp_NumDump2021_INSERT  ";
                sqlStatement += String.valueOf(x);
                sqlStatement += " , ";// separation between parameters.
                sqlStatement += String.valueOf( Math.sin(x) );
                // insert the data
                statement.executeUpdate( sqlStatement);
            }
            connection.commit();// NB.  Cannot commit when autoCommit is enabled. 
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

    
}// class MsSql
