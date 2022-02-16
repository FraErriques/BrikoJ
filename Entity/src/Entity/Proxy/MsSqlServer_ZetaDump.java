/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity.Proxy;

import java.sql.Statement;

/**
 *
 * @author itfraerr
 */
public class MsSqlServer_ZetaDump 
{
//    MsSqlServer exec procedure template
//EXEC [dbo].[usp_genericaAuto_INSERT]
//		@Vettura = 'coccinella',
//		@data = '20900101',
//		@km = 16000,
//		@intervento = N'manutenzione',
//		@litri = 15.6,
//		@euro = 32,
//		@gasolio_euro_litro = 1.753


  
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
            sqlStatement="EXEC [dbo].[usp_ZetaDump_INSERT] ";
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
            // no parenthesis in MsSql sqlStatement += " );";
            // insert the data
            statement.executeUpdate( sqlStatement);
            connection.commit(); //NB.  Cannot commit when autoCommit is enabled, on PostgreSql
        }
        catch( Exception e)
        {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }        
    }// usp_Numerics_ZetaDump

    
    
    
}// class
