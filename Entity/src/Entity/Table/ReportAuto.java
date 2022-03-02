/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity.Table;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author itfraerr
 */
public class ReportAuto 
{
    // all data fields are common to both MsSql-server and PostgreSql
    //....
    /* 

    *** Object:  Table [dbo].[ge135zj]    Script Date: 02/23/2022 10:54:57 ***

    CREATE TABLE [dbo].[ge135zj](
    [ge135zj_id] [int] IDENTITY(1,1) NOT NULL,
    String targaVettura, NB. deve essere utilizzata solo quando  la tabella e' multivettura. Altrimenti scegliere la tabella e non passare il parametro.
    [data] [date] NULL,
    [km] [float] NULL,
    [rifornimento_luogo] [varchar](255) NOT NULL,
    [litri] [float] NULL,
    [gasolio_euro_litro] [float] NULL,
    [gasolio_euro] [float] NULL,
    [accessori_descr] [varchar](255) NULL,
    [accessori_euro] [float] NULL,
    [lavaggio_descr] [varchar](255) NULL,
    [lavaggio_euro] [float] NULL,
    [manutenzione_descr] [varchar](255) NULL,
    [data_ingresso_officina] [date] NULL,
    [data_uscita_officina] [date] NULL,
    [manutenzione_euro real] [float] NULL,
    [altro_descriz] [varchar](255) NULL,
    [altro_euro] [float] NULL,
    [sinistro_descriz] [varchar](255) NULL,
    [conducente] [varchar](255) NULL,
    [descrizione_riga] [varchar](255) NOT NULL,
    [costo_totale_riga] [float] NOT NULL,
    [franchigia_assicurazione] [float] NULL,
    ---------------------------------------------------------------end DB original  */
    DateTimeFormatter dateFormatter;// Ctor will init it.
    //
    int autovettura_id;  // [int] IDENTITY(1,1) NOT NULL,
    String targa_autovettura;//, NB. deve essere utilizzata solo quando  la tabella e' multivettura. Altrimenti scegliere la tabella e non passare il parametro.
    String registration_date;//] [date] NULL,
    float km; //] [float] NULL,
    String rifornimento_luogo;//] [varchar](255) NOT NULL,
    float rifornimento_litri;//  [float] NULL,
    float costo_gasolio_euro_litro; //  [float] NULL,
    float spesa_gasolio_euro;//  [float] NULL,
    String accessori_descriz;//  [varchar](255) NULL,
    float accessori_euro;//  [float] NULL,
    String lavaggio_descr; //] [varchar](255) NULL,
    float lavaggio_euro; //] [float] NULL,
    String manutenzione_descr;//] [varchar](255) NULL,
    String data_ingresso_officina; //] [date] NULL,
    String data_uscita_officina;//] [date] NULL,
    float    manutenzione_euro; // [float] NULL,
    String altro_descriz; // ] [varchar](255) NULL,
    float  altro_euro; // ] [float] NULL,
    String sinistro_descriz; // ] [varchar](255) NULL,
    String conducente; // ] [varchar](255) NULL,
    String riga_descriz; // ] [varchar](255) NOT NULL,
    float  costo_totale_riga_euro; //] [float] NOT NULL,
    float  franchigia_assicurazione_euro; // ] [float] NULL,    
    

    //-----end data ------------- 

    
    // Ctor
    public ReportAuto( //params.....
        // autovettura_id,             // [int] IDENTITY(1,1) NOT NULL,
    String   par_targa_autovettura,       //, NB. deve essere utilizzata solo quando  la tabella e' multivettura. Altrimenti scegliere la tabella e non passare il parametro.
    String   par_registration_date,    //] [date] NULL,
    String   par_km,                       //] [float] NULL,
    String   par_rifornimento_luogo,      //] [varchar](255) NOT NULL,
    String   par_rifornimento_litri,       //  [float] NULL,
    String   par_costo_gasolio_euro_litro, //  [float] NULL,
    String   par_spesa_gasolio_euro,       //  [float] NULL,
    String   par_accessori_descriz,       //  [varchar](255) NULL,
    String   par_accessori_euro,           //  [float] NULL,
    String   par_lavaggio_descr,          //] [varchar](255) NULL,
    String   par_lavaggio_euro,            //] [float] NULL,
    String   par_manutenzione_descr,      //] [varchar](255) NULL,
    String   par_data_ingresso_officina,   //] [date] NULL,
    String   par_data_uscita_officina,     //] [date] NULL,
    String   par_manutenzione_euro,         // [float] NULL,
    String   par_altro_descriz,               // ] [varchar](255) NULL,
    String   par_altro_euro,                  // ] [float] NULL,
    String   par_sinistro_descriz,            // ] [varchar](255) NULL,
    String   par_conducente,                  // ] [varchar](255) NULL,
    String   par_riga_descriz,                // ] [varchar](255) NOT NULL,
    String   par_costo_totale_riga_euro,      //] [float] NOT NULL,
    String   par_franchigia_assicurazione_euro
    )
    {// follows DateFormatter for every date field: check Excel, LibreOffice,..output for the present case.
        this.dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        /* examples of cast : every parameter needs to be cast and format-checked; this activity
        is centralized here. Ctor callers(i.e. Process::) pass Strings from the String-matrix as-are.
        The callers are multiple; the casting is centralized here.
        ------------*/
        // autovettura_id,             // [int] IDENTITY(1,1) NOT NULL,
        this.targa_autovettura              = this.wrapSqlStrings( par_targa_autovettura);
        this.registration_date              = tryParseLocalDate( par_registration_date );
        this.km                             = tryParseFloat( par_km);
        this.rifornimento_luogo             = this.wrapSqlStrings( par_rifornimento_luogo);
        this.rifornimento_litri             = tryParseFloat( par_rifornimento_litri);
        this.costo_gasolio_euro_litro       = tryParseFloat( par_costo_gasolio_euro_litro);
        this.spesa_gasolio_euro             = tryParseFloat( par_spesa_gasolio_euro);
        this.accessori_descriz              = this.wrapSqlStrings( par_accessori_descriz);
        this.accessori_euro                 = tryParseFloat( par_accessori_euro);
        this.lavaggio_descr                 = this.wrapSqlStrings( par_lavaggio_descr);
        this.lavaggio_euro                  = tryParseFloat( par_lavaggio_euro);
        this.manutenzione_descr             = this.wrapSqlStrings( par_manutenzione_descr);
        this.data_ingresso_officina         = tryParseLocalDate( par_data_ingresso_officina );
        this.data_uscita_officina           = tryParseLocalDate( par_data_uscita_officina );
        this.manutenzione_euro              = tryParseFloat( par_manutenzione_euro);
        this.altro_descriz                  = this.wrapSqlStrings( par_altro_descriz);
        this.altro_euro                     = tryParseFloat( par_altro_euro);
        this.sinistro_descriz               = this.wrapSqlStrings( par_sinistro_descriz);
        this.conducente                     = this.wrapSqlStrings( par_conducente);
        this.riga_descriz                   = this.wrapSqlStrings( par_riga_descriz);
        this.costo_totale_riga_euro         = tryParseFloat( par_costo_totale_riga_euro);
        this.franchigia_assicurazione_euro  = tryParseFloat( par_franchigia_assicurazione_euro);
    }// Ctor
    
    public void Postgres_ProxyWrapper_()
    {}//params will let understandable if the insertion has to be on a named table xor in the "all-car" one.
    
    public void MsSql_ProxyWrapper_(
        Common.DBservice.MsSql msSql
    )
    {// Proxy-caller:
        Entity.Proxy.MsSql_usp_genericaautovettura_INSERT_.usp_genericaautovettura_INSERT(
                msSql.connection,
                // [id] IDENTITY
                this.targa_autovettura,
                this.registration_date,
                String.valueOf( this.km ),
                this.rifornimento_luogo,
                String.valueOf( this.rifornimento_litri ),
                String.valueOf( this.costo_gasolio_euro_litro ),
                String.valueOf( this.spesa_gasolio_euro ),
                this.accessori_descriz, 
                String.valueOf( this.accessori_euro ) ,
                this.lavaggio_descr,
                String.valueOf( this.lavaggio_euro ) ,
                this.manutenzione_descr,
                this.data_ingresso_officina,
                this.data_uscita_officina,
                String.valueOf( this.manutenzione_euro ) ,
                this.altro_descriz,
                String.valueOf( this.altro_euro ) ,
                this.sinistro_descriz,
                this.conducente,
                this.riga_descriz,
                String.valueOf( this.costo_totale_riga_euro ) ,
                String.valueOf( this.franchigia_assicurazione_euro )
        );
    }//MsSql
    
    private String wrapSqlStrings( String par)// both dates and actual strings
    {
        String res = "''";// a DB String.
        if(null==par){return res;}
        if(par.trim().length()>0)
        {        
            res = "'" + par + "'";
        }// else Default is aapropriate.
        return res;
    }// wrapSqlStrings
    
    private float tryParseFloat( String par)
    {
        float res = (float)0.0;// init to default empty entry in a data sheet.
        if(null==par){return res;}
        if(par.trim().equals("_placeholder_")){return res;}// a NULL field.
        if(par.trim().length()>0)
        {
            try
            {            
                res = Float.parseFloat( par);
            }
            catch(Exception ex)
            {
                String dbg = ex.getMessage();
                // in this case "dbDate" is not suitable, and so the default for invalid date will be returned.
                res = (float)0.0;// reset the return value, since it has been dirtied in the conversione.
            }
            finally
            {
                int dbg_i = 12;
            }            
        }// else Default is aapropriate.
        return res;
    }// float
    
    private String fromItalianDate_to_AmericanDate( String par )
    {
        String res = "";
        if(par.trim().length()<10){return res;}// NO dd/MM/yyyy can be contained.
        // else continue.
        res = "'";// start DB string
        res = par.substring(6, 10);// yyyy
        res += "/";
        res += par.substring(3,5);// MM
        res += "/";
        res += par.substring(0,2);// dd
        res += "'";// end DB string
        return res;
    }
    
    private String tryParseLocalDate( String par )
    {
        String dbDate = "'1970/01/31'";// TODO find an adequate default... init to default empty entry in a data sheet.
        if(null==par){return dbDate;}
        if(par.trim().length()<10){return dbDate;}// NO dd/MM/yyyy can be contained.
        if(par.trim().equals("_placeholder_")){return dbDate;}// a NULL field.
        // now chech date appropriateness
        LocalDate res = LocalDate.EPOCH;// ? (1970 , 01 , 31 );
        try
        {
            dbDate = this.fromItalianDate_to_AmericanDate(par);
            res = LocalDate.parse( dbDate, this.dateFormatter );
        }
        catch(Exception ex)
        {
            String dbg = ex.getMessage();
            // in this case "dbDate" is not suitable, and so the default for invalid date will be returned.
            dbDate = "'1970/01/31'";// reset the return value, since it has been dirtied in the conversione.
        }
        finally
        {
            int dbg_i = 12;
        }
        //
        return dbDate;
    }// tryParseLocalDate

}// class ReportAuto


/***** cantina ***********************************
 * 
 // example of how in Java a Ctor can throw: the instance will then be in an invalid state and garbage-collected soon.
 * a valid alternative to throwing inside a Ctor is using a boolean data member like "isHealtlyConstructed" and check it
 * after the Ctor-execution. In case of false let the object null, so that it gets garbage-collected sooner.
public class ConstructorExceptionTest {
   public ConstructorExceptionTest() throws InterruptedException {
      System.out.println("Preparing an Object");
      Thread.sleep(1000);
      System.out.println("Object is ready");
   }
   public static void main(String args[]) {
      try {
         ConstructorExceptionTest test = new ConstructorExceptionTest();
      } catch (InterruptedException e) {
         System.out.println("Got interrupted...");
      }
   }
}
* 
* * @author itfraerr
 */
