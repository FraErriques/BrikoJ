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
    int autovettura_id;  // [int] IDENTITY(1,1) NOT NULL,
    String targa_autovettura;//, NB. deve essere utilizzata solo quando  la tabella e' multivettura. Altrimenti scegliere la tabella e non passare il parametro.
    LocalDate registration_date;//] [date] NULL,
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
    LocalDate data_ingresso_officina; //] [date] NULL,
    LocalDate data_uscita_officina;//] [date] NULL,
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
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        /* examples of cast : every parameter needs to be cast and format-checked; this activity
        is centralized here. Ctor callers pass Strings from the String-matrix as-is.
        The callers are multiple; the casting is centralized here.
        ------------*/
        // autovettura_id,             // [int] IDENTITY(1,1) NOT NULL,
        this.targa_autovettura = this.wrapSqlStrings( par_targa_autovettura);
        this.registration_date              = LocalDate.parse( par_registration_date, dateFormatter);
        this.km                             = Float.parseFloat( par_km);
        this.rifornimento_luogo             =  this.wrapSqlStrings( par_rifornimento_luogo);
        this.rifornimento_litri             = Float.parseFloat( par_rifornimento_litri);
        this.costo_gasolio_euro_litro       = Float.parseFloat( par_costo_gasolio_euro_litro);
        this.spesa_gasolio_euro             = Float.parseFloat( par_spesa_gasolio_euro);
        this.accessori_descriz              = this.wrapSqlStrings( par_accessori_descriz);
        this.accessori_euro                 = Float.parseFloat( par_accessori_euro);
        this.lavaggio_descr                 = this.wrapSqlStrings( par_lavaggio_descr);
        this.lavaggio_euro                  = Float.parseFloat( par_lavaggio_euro);
        this.manutenzione_descr             = this.wrapSqlStrings( par_manutenzione_descr);
        this.data_ingresso_officina         = LocalDate.parse( par_data_ingresso_officina);
        this.data_uscita_officina           = LocalDate.parse( par_data_uscita_officina);
        this.manutenzione_euro              = Float.parseFloat( par_manutenzione_euro);
        this.altro_descriz                  = this.wrapSqlStrings( par_altro_descriz);
        this.altro_euro                     = Float.parseFloat( par_altro_euro);
        this.sinistro_descriz               = this.wrapSqlStrings( par_sinistro_descriz);
        this.conducente                     = this.wrapSqlStrings( par_conducente);
        this.riga_descriz                   = this.wrapSqlStrings( par_riga_descriz);
        this.costo_totale_riga_euro         = Float.parseFloat( par_costo_totale_riga_euro);
        this.franchigia_assicurazione_euro  = Float.parseFloat( par_franchigia_assicurazione_euro);
    }// Ctor
    
    public void Postgres_ProxyWrapper_()
    {}//params will let understandable if the insertion has to be on a named table xor in the "all-car" one.
    
    public void MsSql_ProxyWrapper_()
    {}//params will let understandable if the insertion has to be on a named table xor in the "all-car" one.    
    
    private String wrapSqlStrings( String par)// both dates and actual strings
    {
        String res = "'" + par + "'";
        return res;
    }// wrapSqlStrings
    
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
