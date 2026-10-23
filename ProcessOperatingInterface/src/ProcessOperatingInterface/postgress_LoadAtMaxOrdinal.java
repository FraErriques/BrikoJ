
package ProcessOperatingInterface;

/**
 *
 Process: from GUI to Entity with non-sticky connection.
 */
public class postgress_LoadAtMaxOrdinal 
{
    
    public static Entity.Proxy.PrimedataRiga postgress_LoadAtMaxOrdinal_SERVICE_(
            java.sql.Connection con
    )
    {
        java.util.ArrayList<Entity.Proxy.PrimedataRiga> lastRecord = null;
        //
        try
        {
            lastRecord = 
                    Entity.Proxy.usp_PrimeData_LOAD_atMaxOrdinal_Postgres_.usp_PrimeData_LOAD_atMaxOrdinal_Postgres_SERVICE_(
                            con );
            con.close();// throws
            if( +1!=lastRecord.size() )
            {
                throw new Exception("resultset cardinality has to be ONE here.");
            }// else continue.
        }// try
        catch ( Exception ex) 
        {
            System.out.println(ex.getMessage());
            return null;
        }
        finally
        {
            con = null; // gc.
        }
        //        
        return ((Entity.Proxy.PrimedataRiga)(lastRecord.get(0)));
    }// service
    
}// class
