/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity.Proxy;

import java.sql.Statement;
import java.time.LocalDate;

/**
 *
 * @author itfraerr
 */
public class Pg_usp_ge135zj_insert 
{
    
    
    /*
	IN par_data date,
	IN par_km real,
	IN par_rifornimento_luogo character varying,
	IN par_litri real,
	IN par_gasolio_euro_litro real,
	IN par_gasolio_euro real,
	IN par_accessori_descr character varying,
	IN par_accessori_euro real,
	IN par_lavaggio_descr character varying,
	IN par_lavaggio_euro real,
	IN par_manutenzione_descr character varying,
	IN par_data_ingresso_officina date,
	IN par_data_uscita_officina date,
	IN par_manutenzione_euro real,
	IN par_altro_descriz character varying,
	IN par_altro_euro real,
	IN par_sinistro_descriz character varying,
	IN par_conducente character varying,
	IN par_descrizione_riga character varying,
	IN par_costo_totale_riga real,
	IN par_franchigia_assicurazione real)
    
    */
  
    public static void Pg_usp_ge135zj_insert_SERVICE(
        java.sql.Connection connection,
        //
	LocalDate  par_data,
	float par_km,
	String par_rifornimento_luogo,
	float par_litri,
	float par_gasolio_euro_litro,
	float par_gasolio_euro,
	String par_accessori_descr,
	float par_accessori_euro,
	String par_lavaggio_descr,
	float par_lavaggio_euro,
	String par_manutenzione_descr,
	LocalDate par_data_ingresso_officina,
	LocalDate par_data_uscita_officina,
	float par_manutenzione_euro,
	String par_altro_descriz,
	float par_altro_euro,
	String par_sinistro_descriz,
	String par_conducente,
	String par_descrizione_riga,
	float par_costo_totale_riga,
	float par_franchigia_assicurazione
    )
    {
        String sqlStatement;
        try
        {
            if(null==connection ||  !connection.isValid(0) )
            {
                return;
            }// else continue.
            // create a Statement from the connection
            Statement statement = connection.createStatement();                
            //
            sqlStatement= " CALL public.usp_ge135zj_insert(  ";
            sqlStatement += String.valueOf( "'"+par_data+"'");
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += String.valueOf( par_km);
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += String.valueOf( "'"+par_rifornimento_luogo+"'");
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += String.valueOf( par_litri);
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += String.valueOf( par_gasolio_euro_litro);
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += String.valueOf( par_gasolio_euro);
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += String.valueOf( "'"+par_accessori_descr+"'");
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += String.valueOf( par_accessori_euro);
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += String.valueOf( "'"+par_lavaggio_descr+"'");
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += String.valueOf( par_lavaggio_euro);
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += String.valueOf( "'"+par_manutenzione_descr+"'");
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += String.valueOf( "'"+par_data_ingresso_officina+"'");
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += String.valueOf( "'"+par_data_uscita_officina+"'");
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += String.valueOf( par_manutenzione_euro);
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += String.valueOf( "'"+par_altro_descriz+"'");
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += String.valueOf( par_altro_euro);
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += String.valueOf( "'"+par_sinistro_descriz+"'");
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += String.valueOf( "'"+par_conducente+"'");
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += String.valueOf( "'"+par_descrizione_riga+"'");
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += String.valueOf( par_costo_totale_riga);
            sqlStatement += " , ";// separation between parameters.
            sqlStatement += String.valueOf( par_franchigia_assicurazione);
            //
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
    }// Pg_usp_ge135zj_insert
    
    
}// class Proxy::Pg_usp_ge135zj_insert
