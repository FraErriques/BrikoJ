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
public class PostgreSql_usp_genericaautovettura_INSERT_ 
{

    // Proxy ------ to [usp_genericaautovettura_INSERT]
    public static void PostgreSql_usp_genericaautovettura_INSERT_SERVICE_(
        java.sql.Connection connection,
        //
        //  [autovettura_id] IDENTITY
        String  targa_autovettura,
	String  registration_date,
	String  km,
	String  rifornimento_luogo,
	String  rifornimento_litri,
	String  costo_gasolio_euro_litro,
	String  spesa_gasolio_euro,
	String  accessori_descriz,
	String  accessori_euro,
	String  lavaggio_descr,
	String  lavaggio_euro,
	String  manutenzione_descr,
	String  data_ingresso_officina,
	String  data_uscita_officina,
	String  manutenzione_euro,
	String  altro_descriz,
	String  altro_euro,
	String  sinistro_descriz,
	String  conducente,
	String  riga_descriz,
	String  costo_totale_riga_euro,
	String  franchigia_assicurazione_euro
    )
    {
        String sqlStatement;// let it debuggable outside the "try"
        try
        {
            if(null==connection ||  !connection.isValid(0) )
            {
                return;
            }// else continue.
            // create a Statement from the connection
            Statement statement = connection.createStatement();
            //
            sqlStatement = " CALL public.usp_genericaautovettura_INSERT(  ";
            sqlStatement += targa_autovettura;
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += registration_date;
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += km;
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += rifornimento_luogo;
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += rifornimento_litri;
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += costo_gasolio_euro_litro;
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += spesa_gasolio_euro;
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += accessori_descriz;
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += accessori_euro;
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += lavaggio_descr;
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += lavaggio_euro;
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += manutenzione_descr;
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += data_ingresso_officina;
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += data_uscita_officina;
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += manutenzione_euro;
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += altro_descriz;
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += altro_euro;
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += sinistro_descriz;
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += conducente;
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += riga_descriz;
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += costo_totale_riga_euro;
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += franchigia_assicurazione_euro;
            sqlStatement += "   );";// ending
            // insert the data
            // ?? choose : statement.executeUpdate( sqlStatement);
            //  NB.  Cannot commit since in PostgreSql autoCommit is enabled. 
            // insert the data
            statement.execute( sqlStatement);
        }
        catch( Exception e)
        {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }        
    }// end Proxy ------ to PostgreSql [usp_genericaautovettura_INSERT]
    
    
}// PostgreSql_usp_genericaautovettura_INSERT_
