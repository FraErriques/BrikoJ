/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProcessOperatingInterface;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fra
 */
public class postgres_Frechet_primedata_LOAD_MULTI_ 
{
    public static java.util.ArrayList<Entity.Proxy.PrimedataRiga> postgres_Frechet_primedata_LOAD_MULTI_SERVICE_(
        long from
        ,long to    ) throws Exception
    {    
        java.util.ArrayList<Entity.Proxy.PrimedataRiga> resultset = null;
        try 
        {
            resultset = 
                    Entity.Proxy.usp_PrimeData_LOAD_MULTI_Postgres_Frechet.usp_PrimeData_LOAD_MULTI_Postgres_Frechet_SERVICE_(from, to);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(postgres_Frechet_primedata_LOAD_MULTI_.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        //
        return resultset;
    }// service
    
}//class
