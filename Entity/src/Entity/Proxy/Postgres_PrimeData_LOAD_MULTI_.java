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
      //  List<Emp> listOfEmp=new ArrayList<Emp>();

        while(rs.next()){

        //Emp data=new Emp();
        //data.setEmpno(rs.getInt("empid"));
        //data.setEmpName(rs.getString("empid"));
        //listOfEmp.add(data);

        }
        //system.out.println("Total emp"+listOfEmp.size());
        pgITFORS.closeConnection();
    }// LOAD_MULTI
        
}// class
