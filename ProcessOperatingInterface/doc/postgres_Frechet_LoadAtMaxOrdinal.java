/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProcessOperatingInterface;

/**
 *
 * @author fra
 */
public class postgres_Frechet_LoadAtMaxOrdinal 
{
    public static Entity.Proxy.PrimedataRiga postgres_Frechet_LoadAtMaxOrdinal_SERVICE_()
    {
        java.util.ArrayList<Entity.Proxy.PrimedataRiga> lastRecord = null;
        Common.DBservice.connectionProvider_postgreSql_Frechet conFrechet = new Common.DBservice.connectionProvider_postgreSql_Frechet();
        java.sql.Connection con = null;
        try
        {
            con = (java.sql.Connection) conFrechet.getConnection();
            lastRecord = 
                    Entity.Proxy.usp_PrimeData_LOAD_atMaxOrdinal_Postgres_.usp_PrimeData_LOAD_atMaxOrdinal_Postgres_SERVICE_(
                            con );
        } 
        catch ( Exception ex) 
        {
            System.out.println(ex.getMessage());
            return null;
        }
        finally
        {
            conFrechet.closeConnection();
        }
        //        
        return ((Entity.Proxy.PrimedataRiga)(lastRecord.get(0)));
    }// service
    
}// class
