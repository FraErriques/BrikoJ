/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProcessOperatingInterface;

import java.sql.Connection;
import java.sql.SQLException;


/**
 *
 * @author fra
 */
public class postgres_LoadAtMaxOrdinal 
{
    public static Entity.Proxy.PrimedataRiga postgres_LoadAtMaxOrdinal_SERVICE_(
            javax.swing.JTextArea txtClipboard,
            Connection con )
    {
        java.util.ArrayList<Entity.Proxy.PrimedataRiga> lastRecord = null;
        try 
        {
            lastRecord = 
                    Entity.Proxy.usp_PrimeData_LOAD_atMaxOrdinal_Postgres_.usp_PrimeData_LOAD_atMaxOrdinal_Postgres_SERVICE_(con);
        } 
        catch (SQLException ex) 
        {
            System.out.println("ProcessOperatingInterface.postgres_LoadAtMaxOrdinal.postgres_LoadAtMaxOrdinal_SERVICE_() exception: "+ex.getMessage());
            return null;
        }
        //        
        // dbg
        // dbg   txtClipboard.append(lastRecord.get(0).toString());
        return ((Entity.Proxy.PrimedataRiga)(lastRecord.get(0)));
    }// service
    
}// class
