///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package Common.DBservice;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.ResultSet;
//
//
///**
// *
// * @author fra
// */
//public class MySql 
//{
//    // Data
//    Connection connection=null;    
//    //"jdbc:postgresql://Eulero:5432/numerics", "postgres", "Riemann0");
//    //String connectionUrl_Eulero_MySql = "jdbc:mysql://localhost:3306/cantiere?  user=root&password=Riemann0";
//    
//    
//    // Ctor
//    public MySql()
//    {
//        try
//        {
//            Class.forName("com.mysql.jdbc.Driver");
//            //connection = DriverManager.getConnection("jdbc:mysql://Eulero:3306/cantiere", "user=root", "password=Riemann0");
//            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cantiere?", "user=root&", "password=Riemann0");
//            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cantiere", "user=root", "password=Riemann0");
//               DriverManager.getConnection("jdbc:mysql://localhost:3306/cantiere?" +
//                               "user=root&password=Riemann0");
//        }
//        catch( Exception e)
//        {
//            e.printStackTrace();
//            System.err.println(e.getClass().getName()+": "+e.getMessage());
//            System.exit(0);
//        }
//        System.out.println(" Connection to database opened successfully");         
//    }// Ctor    
//    
//    
//    public void insertionLoop_template()
//    {
//        try
//        {
//            // create a Statement from the connection
//            Statement statement = connection.createStatement();                
//            //-----
//            String sqlStatement;
//
//            double x = +3.0;
//            double Dx = 0.01;
//            for( ; x<+6.0; x+=Dx)
//            {
//                // call  `usp_cantiere_Dump2021Dez31_INSERT` ( 0.7 , sin(0.7) );
//                sqlStatement=" call  `usp_cantiere_Dump2021Dez31_INSERT` ( ";
//                sqlStatement += String.valueOf(x);
//                sqlStatement += " , ";// separation between parameters.
//                sqlStatement += String.valueOf( Math.sin(x) );
//                sqlStatement += " );";
//                // insert the data
//                statement.executeUpdate( sqlStatement);
//            }
//            connection.commit();// NB.  Cannot commit when autoCommit is enabled. 
//        }
//        catch( Exception e)
//        {
//            e.printStackTrace();
//            System.err.println(e.getClass().getName()+": "+e.getMessage());
//            System.exit(0);
//        }        
//    }// insertionLoop_template
//    
//    
//    
//    // like Dtor
//    public void closeConnection()
//    {
//        try
//        {
//            if(null!=connection)
//            {
//                if( connection.isValid(0))
//                {
//                    connection.close();
//                }
//            }
//        }
//        catch( Exception e)
//        {
//            e.printStackTrace();
//            System.err.println(e.getClass().getName()+": "+e.getMessage());
//            System.exit(0);
//        }        
//        System.out.println(" Connection to database closed successfully");        
//    }// like Dtor    
//
//
//    
//    
//    
//    
//public void MySql_dbConnectorTemplate( ) 
//{
//Connection conn = null;
//Statement stmt = null;
//ResultSet rs = null;
//
//try
//{
//conn =
//   DriverManager.getConnection("jdbc:mysql://localhost:3306/cantiere?" +
//                               "user=root&password=Riemann0");
//
////conn =
////       DriverManager.getConnection("jdbc:mysql://localhost/test?" +
////                                   "user=minty&password=greatsqldb");
//
//stmt = conn.createStatement();
////    stmt.execute("create database cantiere");
////    stmt.execute("create table cantiere.sede( nome varchar(50) )");
////    stmt.execute("insert into cantiere.sede( nome)  values( 'Mules')");  
////stmt.execute("insert into cantiere.lotto( lotto)  values( 'Wolf')");  
//rs = stmt.executeQuery("SELECT * from cantiere.lotto");
//int columnCard = 3;
//String[] fromResultSet = null;
//for(;;)
//{
//    fromResultSet = new String[columnCard];
//    if( rs.next() )
//    {
//        fromResultSet[0] = rs.getString( 1);
//        fromResultSet[1] = rs.getString( 2);
//        fromResultSet[2] = rs.getString( 3);
//    }
//    else
//    {
//        break;
//    }
//    System.out.println("Row fetched : " + fromResultSet[0]+" # " + fromResultSet[1]+" # " + fromResultSet[2]+" # \n");
//}// end for fetch.
//// or alternatively, if you don't know ahead of time that
//// the query will be a SELECT...
////
////    if (stmt.execute("SELECT foo FROM bar")) {
////        rs = stmt.getResultSet();
////    }
//// Do something with the Connection
//}// end try 
//catch( SQLException ex) 
//{
//    // handle any errors
//    System.out.println("SQLException: " + ex.getMessage());
//    System.out.println("SQLState: " + ex.getSQLState());
//    System.out.println("VendorError: " + ex.getErrorCode());
//}// end catch
//finally 
//{
//// it is a good idea to release
//// resources in a finally{} block
//// in reverse-order of their creation
//// if they are no-longer needed
//
//if( rs != null)
//{
//try
//{
//    rs.close();
//}
//catch( SQLException ex) 
//{
//    // handle any errors
//    System.out.println("SQLException: " + ex.getMessage());
//    System.out.println("SQLState: " + ex.getSQLState());
//    System.out.println("VendorError: " + ex.getErrorCode());
//}// end catch
//rs = null;
//}// else the ResultSet (i.e. "rs") is already null.
//
//if (stmt != null)
//{
//try 
//{
//    stmt.close();
//}
//catch( SQLException ex) 
//{
//    // handle any errors
//    System.out.println("SQLException: " + ex.getMessage());
//    System.out.println("SQLState: " + ex.getSQLState());
//    System.out.println("VendorError: " + ex.getErrorCode());
//}// end catch
//stmt = null;
//}
//
//if( null != conn)
//{
//try 
//{
//if( ! conn.isClosed() )
//{
//conn.close();
//}
//}
//catch( SQLException ex) 
//{
//    // handle any errors
//    System.out.println("SQLException: " + ex.getMessage());
//    System.out.println("SQLState: " + ex.getSQLState());
//    System.out.println("VendorError: " + ex.getErrorCode());
//}// end catch
//}// end if( null != conn)
//
//}// end finally
//}// end method dbConnectorTemplate
//    
//    
//}// class
