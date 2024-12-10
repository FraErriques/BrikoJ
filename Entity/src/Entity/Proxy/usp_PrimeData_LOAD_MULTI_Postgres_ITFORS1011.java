/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity.Proxy;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




/**
 *
 * @author fra
 */
public class usp_PrimeData_LOAD_MULTI_Postgres_ITFORS1011 {
    
 
    public static long usp_PrimeData_LOAD_MULTI_Postgres_ITFORS1011_SERVICE_ (
        long from
        ,long to
    ) throws SQLException 
    {
        
        Common.DBservice.connectionProvider_postgreSql_ITFORS1011 pgITFORS = new Common.DBservice.connectionProvider_postgreSql_ITFORS1011();        
        Connection con = pgITFORS.getConnection();
        //Call to postgresql function   
        String query="select * from primedata_LOAD_MULTI( "+" start_ordinal=>"+
                from +", end_ordinal=>"+to  +")";
        CallableStatement ps=con.prepareCall(query);//<------------------------------------------------NB----------
        //ps.setInt(1,5); ???? // it means we are setting value 5 at first index.
        ResultSet rs = ps.executeQuery();//<------------------------------------------------NB----------

        ArrayList<Entity.Proxy.PrimedataRiga> listOf_Riga = new ArrayList<Entity.Proxy.PrimedataRiga>();
        Entity.Proxy.PrimedataRiga data = null;
        while( rs.next() )// fetch the DB-cursor.
        {
            data = new Entity.Proxy.PrimedataRiga();// a record(i.e. class) for each table-row.
            //
            long tmp_ordinal = rs.getLong("ordinal");// get db field by column name, specifying the data type.
            data.setOrdinal( tmp_ordinal);
            //
            long tmp_prime = rs.getLong("prime");// get db field by column name, specifying the data type.
            data.setPrime( tmp_prime);
            //
            listOf_Riga.add(data);// add current row to the Java-resultset.
            // 
            // dbg
            System.out.println( data.ord + "_____"+data.prime);
        }
        // dbg System.out.println(" Resultset row cardinality == "+listOf_Riga.size());
        pgITFORS.closeConnection();
        return data.prime;
    }// LOAD_MULTI    
    
}// class
