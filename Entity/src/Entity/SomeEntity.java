
package Entity;

import Common.ConfigurationService.*;
import java.sql.Connection;
import java.sql.Statement;


public class SomeEntity
{
    public String getEntityName()
    {
        Common.ConfigurationService.scalarConfig cs = new Common.ConfigurationService.scalarConfig("./someFile.txt");
        cs.getTokensFromConfigStream();
        return "SomeEntity";
    }
    
    
    
  
    public static void usp_Numerics_ZetaDump(
            java.sql.Connection connection,
            //
            double Re_s,
            double Im_s,
            double Re_z,
            double Im_z,
            double Re_image,
            double Im_image
    )
    {
        try
        {
            if(null==connection ||  !connection.isValid(0) )
            {
                return;
            }// else continue.
            // create a Statement from the connection
            Statement statement = connection.createStatement();                
            String sqlStatement;
            //
            sqlStatement="CALL public.usp_zetadump_insert(  ";
            sqlStatement += String.valueOf( Re_s);
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += String.valueOf( Im_s);
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += String.valueOf( Re_z);
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += String.valueOf( Im_z);
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += String.valueOf( Re_image);
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += String.valueOf( Im_image);
            sqlStatement += " );";
            // insert the data
            statement.executeUpdate( sqlStatement);
            //  connection.commit(); NB.  Cannot commit when autoCommit is enabled. 
        }
        catch( Exception e)
        {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }        
    }// usp_Numerics_ZetaDump    
    
    
    
}// class
