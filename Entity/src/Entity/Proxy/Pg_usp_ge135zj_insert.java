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
            sqlStatement="CALL public.usp_ge135zj_insert(  ";
//            sqlStatement += String.valueOf( Re_s);
//            sqlStatement += " , ";// separation between parameters.
//            sqlStatement += String.valueOf( Im_s);
//            sqlStatement += " , ";// separation between parameters.
//            sqlStatement += String.valueOf( Re_z);
//            sqlStatement += " , ";// separation between parameters.
//            sqlStatement += String.valueOf( Im_z);
//            sqlStatement += " , ";// separation between parameters.
//            sqlStatement += String.valueOf( Re_image);
//            sqlStatement += " , ";// separation between parameters.
//            sqlStatement += String.valueOf( Im_image);
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
