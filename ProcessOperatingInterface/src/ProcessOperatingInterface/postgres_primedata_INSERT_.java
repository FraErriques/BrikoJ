// Process : between GUI and Entity::Proxy
package ProcessOperatingInterface;

import DB_thread.PostgreSql_anyInstance_Prime_INSERT_;
import javax.swing.JTextArea;


// Process : between GUI and Entity::Proxy
public class postgres_primedata_INSERT_ {

    public static void postgres_primedata_INSERT_SERVICE_(
            java.sql.Connection con
            , long thePrime
            , JTextArea txtClipboard
    )
    {
        DB_thread.PostgreSql_anyInstance_Prime_INSERT_ primeInertionThread = new PostgreSql_anyInstance_Prime_INSERT_(
            txtClipboard
            , con);
        
    }// service

    
}// class
