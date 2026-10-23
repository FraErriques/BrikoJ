/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity.Proxy;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author admin
 */
public class Postgres_PrimeData_LOAD_MULTI_ 
{
 
    public static ArrayList<Entity.Proxy.PrimedataRiga>  Postgres_PrimeData_LOAD_MULTI_SERVICE_ (
        java.sql.Connection conn
        ,long from
        ,long to
    ) throws SQLException 
    {
        if(null==conn || ! conn.isValid(0)) 
            {return null;}//else continue.
        //Call to postgresql function   
        String query="select * from primedata_LOAD_MULTI( "+" start_ordinal=>"+from +", end_ordinal=>"+to  +")";
        CallableStatement ps=conn.prepareCall(query);//<------------------------------------------------NB----------
        //ps.setInt(1,5);  // it means we are setting value 5 at first index.  ??
        ResultSet rs = ps.executeQuery();//<------------------------------------------------NB----------
        // prepare to fetch the DB-cursor into a Java-resultset.
        ArrayList<Entity.Proxy.PrimedataRiga> listOf_Riga = new ArrayList<Entity.Proxy.PrimedataRiga>();
        int rowCount=0;
        while( rs.next() )// cursor fetch
        {
            Entity.Proxy.PrimedataRiga data = new Entity.Proxy.PrimedataRiga();// next row.
            //
            long tmp_ordinal = rs.getLong("ordinal");// get field by column name. Data-type has to be specified.
            data.setOrdinal( tmp_ordinal);
            //
            long tmp_prime = rs.getLong("prime");// get field by column name. Data-type has to be specified.
            data.setPrime( tmp_prime);
            //
            listOf_Riga.add(data);// add the row in the ArrayList that will contain the resultset.
            // dbg
            System.out.println( data.ord + "_____"+data.prime);
            rowCount++;
        }// cursor fetch
        //
        System.out.println("Total resultset="+listOf_Riga.size() );
        // DON'T : the caller must close the sticky connection.  conn.close();
        if(0==rowCount)
        {
            listOf_Riga = null;// gc & signal the empty resultset.
        }        
        //
        return listOf_Riga;
    }// LOAD_MULTI

}// class
