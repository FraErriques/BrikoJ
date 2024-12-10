 
package ProcessOperatingInterface;

/**
 *
 * Process : from GUI to Entity::Proxy with NO-sticky connection---
 */
public class postgres_primedata_LOAD_MULTI_ {
    
    public static java.util.ArrayList<Entity.Proxy.PrimedataRiga> postgres_primedata_LOAD_MULTI_SERVICE_(
            java.sql.Connection con
            ,long from
            ,long to
    )
    {
         java.util.ArrayList<Entity.Proxy.PrimedataRiga> resultset = null;
         try
         {
             resultset = Entity.Proxy.Postgres_PrimeData_LOAD_MULTI_.Postgres_PrimeData_LOAD_MULTI_SERVICE_(con, from, to);
             con.close();// throws.
             if( 0==resultset.size())
             {
                 throw new Exception("resultset is empty : no such range.");
             }// else continue.
         }// try
         catch(Exception ex)
         {
            System.out.println(ex.getMessage());
            return null;             
         }
         finally
         {
             con = null;// gc.
         }// finally
         return resultset;
    }// service
    
    
}// class
