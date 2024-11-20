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
public class postgres_Frechet_LoadAtMaxOrdinal 
{
    public static Entity.Proxy.PrimedataRiga postgres_Frechet_LoadAtMaxOrdinal_SERVICE_()
    {
        java.util.ArrayList<Entity.Proxy.PrimedataRiga> lastRecord = null;
        try 
        {
            lastRecord = 
                    Entity.Proxy.usp_PrimeData_LOAD_atMaxOrdinal_Postgres_Frechet.usp_PrimeData_LOAD_atMaxOrdinal_Postgres_Frechet_SERVICE_();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(postgres_Frechet_LoadAtMaxOrdinal.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        //        
        return ((Entity.Proxy.PrimedataRiga)(lastRecord.get(0)));
    }// service
    
}// class
