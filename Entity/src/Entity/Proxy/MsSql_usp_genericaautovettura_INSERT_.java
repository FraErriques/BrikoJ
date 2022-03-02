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
public class MsSql_usp_genericaautovettura_INSERT_ 
{
/*
USE [dotazioni2022]
GO
**** Object:  StoredProcedure [dbo].[usp_genericaautovettura_INSERT]    Script Date: 03/01/2022 15:38:00 ***

create procedure [dbo].[usp_genericaautovettura_INSERT]
	--@autovettura_id [int] IDENTITY(1,1) NOT NULL,
    @targa_autovettura [varchar](255),
	@registration_date  [date],
	@km [float],
	@rifornimento_luogo [varchar](255),
	@rifornimento_litri  [float],
	@costo_gasolio_euro_litro [float],
	@spesa_gasolio_euro [float],
	@accessori_descriz [varchar](255),
	@accessori_euro [float],
	@lavaggio_descr [varchar](255),
	@lavaggio_euro [float],
	@manutenzione_descr [varchar](255),
	@data_ingresso_officina [date],
	@data_uscita_officina [date],
	@manutenzione_euro [float],
	@altro_descriz [varchar](255),
	@altro_euro [float],
	@sinistro_descriz [varchar](255),
	@conducente [varchar](255),
	@riga_descriz [varchar](255),
	@costo_totale_riga_euro [float],
	@franchigia_assicurazione_euro [float]
as
--
insert into [dotazioni2022].[dbo].[generica_autovettura]
(
--  [autovettura_id]  [int] IDENTITY(1,1) NOT NULL,
[targa_autovettura],
[registration_date] ,
[km],
[rifornimento_luogo],
[rifornimento_litri] ,
[costo_gasolio_euro_litro] ,
[spesa_gasolio_euro] ,
[accessori_descriz] ,
[accessori_euro],
[lavaggio_descr],
[lavaggio_euro],
[manutenzione_descr],
[data_ingresso_officina],
[data_uscita_officina],
[manutenzione_euro],
[altro_descriz],
[altro_euro],
[sinistro_descriz],
[conducente],
[riga_descriz] ,
[costo_totale_riga_euro] ,
[franchigia_assicurazione_euro] 
		)values(
	--@autovettura_id  [int] IDENTITY(1,1) NOT NULL,
	@targa_autovettura,
	@registration_date ,
	@km,
	@rifornimento_luogo,
	@rifornimento_litri  ,
	@costo_gasolio_euro_litro ,
	@spesa_gasolio_euro ,
	@accessori_descriz ,
	@accessori_euro,
	@lavaggio_descr,
	@lavaggio_euro,
	@manutenzione_descr,
	@data_ingresso_officina,
	@data_uscita_officina,
	@manutenzione_euro,
	@altro_descriz,
	@altro_euro,
	@sinistro_descriz,
	@conducente,
	@riga_descriz ,
	@costo_totale_riga_euro ,
	@franchigia_assicurazione_euro 
)
GO  */

    
    // Proxy ------ to [usp_genericaautovettura_INSERT]
    public static void usp_genericaautovettura_INSERT(
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
            sqlStatement=" EXEC [dbo].[usp_genericaautovettura_INSERT]  ";
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
            sqlStatement += "   ";// ending spaces
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
    }// end Proxy ------ to [usp_genericaautovettura_INSERT]
    
    
    
}//class
