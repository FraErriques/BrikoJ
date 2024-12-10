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
public class usp_PrimeData_LOAD_atMaxOrdinal_Postgres_ 
{

    public static java.util.ArrayList<Entity.Proxy.PrimedataRiga>  usp_PrimeData_LOAD_atMaxOrdinal_Postgres_SERVICE_ (
            java.sql.Connection con   )   throws SQLException 
    {
        if(null==con)
        {
            return null;
        }// else continue.  
        boolean connValidity = con.isValid(0); 
        if( ! connValidity)
        {
            return null;
        }// else continue.              
        //Call to postgresql function:
        String query="select * from public.primedata_LOAD_AtMaxOrdinal()";
        CallableStatement ps = con.prepareCall(query);//<------------------------------------------------NB----------
        //ps.setInt(1,5); ???? // it means we are setting value 5 at first index.
        ResultSet rs = ps.executeQuery();//<------------------------------------------------NB----------
        ArrayList<Entity.Proxy.PrimedataRiga> listOf_Riga = new ArrayList<Entity.Proxy.PrimedataRiga>();
        while( rs.next() )// fetch the DB-cursor.
        {
            Entity.Proxy.PrimedataRiga data = new Entity.Proxy.PrimedataRiga();// a record(i.e. class) for each table-row.
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
        System.out.println(" Resultset row cardinality == "+listOf_Riga.size());
        // DON'T caller must do it : con.close();
        //
        return listOf_Riga;
    }// LOAD_MULTI    
    
}// class
