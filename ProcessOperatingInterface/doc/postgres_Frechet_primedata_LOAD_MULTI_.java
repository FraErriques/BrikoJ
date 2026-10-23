/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProcessOperatingInterface;

/**
 *
 * @author fra
 */
public class postgres_usp_primedata_LOAD_atMaxOrdinal_
{
    public static java.util.ArrayList<Entity.Proxy.PrimedataRiga> postgres_usp_primedata_LOAD_atMaxOrdinal_SERVICE_(
        java.sql.Connection conn
        ,long from
        ,long to    )
    {    
        java.util.ArrayList<Entity.Proxy.PrimedataRiga> resultset = null;
        try 
        {
            resultset = 
                    Entity.Proxy.usp_PrimeData_LOAD_atMaxOrdinal_Postgres_._LOAD_atMaxOrdinal_Postgres_SERVICE_(
                            conn
                            , from
                            , to);
        } 
        catch ( Exception ex) 
        {
            System.out.println(ex.getMessage());
            return null;
        }
        finally
        {
            conn.close();
        }
        //
        return resultset;
    }// service
    
}//class
