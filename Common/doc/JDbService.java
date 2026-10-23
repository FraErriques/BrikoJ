///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Common.DBservice;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.ResultSet;
//
//public class JDbService 
//{
//
//public void dbConnectorTemplate( ) 
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
//}// end class
