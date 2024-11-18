/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity.Proxy;

import Common.DBservice.PostgreSql_ITFORS1011_;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


class Riga
        {
            long ord;
            long prime;
            //
            public void setOrdinal(long the_ordinal)
            {this.ord = the_ordinal;}
            
            public void setPrime(long the_prime)
            {this.prime = the_prime;}
        };

/**
 *
 * @author admin
 */
public class Postgres_PrimeData_LOAD_MULTI_ 
{
 
    public static void Postgres_PrimeData_LOAD_MULTI_SERVICE_ (
        long from
        ,long to
    ) throws SQLException 
    {        
        PostgreSql_ITFORS1011_ pgITFORS = new Common.DBservice.PostgreSql_ITFORS1011_();
        
        Connection con = pgITFORS.connectionProvider();
        
        Statement statement = con.createStatement();
    //Call to postgresql function   
        String query="select * from primedata_LOAD_MULTI( "+" start_ordinal=>"+
                from +", end_ordinal=>"+to  +")";
        CallableStatement ps=con.prepareCall(query);//<------------------------------------------------NB----------
//ps.setInt(1,5);  // it means we are setting value 5 at first index.
        ResultSet rs = ps.executeQuery();//<------------------------------------------------NB----------

        ArrayList<Riga> listOf_Riga = new ArrayList<Riga>();

        while( rs.next() )
        {
            Riga data = new Riga();
            long tmp_ordinal = rs.getLong("ordinal");
            data.setOrdinal( tmp_ordinal);
            long tmp_prime = rs.getLong("prime");
            data.setPrime( tmp_prime);
            listOf_Riga.add(data);
            // 
            // dbg
            System.out.println( data.ord + "_____"+data.prime);
        }
        //system.out.println("Total emp"+listOfEmp.size());
        pgITFORS.closeConnection();
    }// LOAD_MULTI
        
}// class
