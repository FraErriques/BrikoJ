/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProcessOperatingInterface;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author itfraerr
 */
public class FromExcelToDB 
{

    public static boolean fromTABseparatedTxtDumpTo_PostgreSql(
            String textDumpFullpath
    )
    {
        boolean res = false;
        //----follows the sequence to be used:
        Common.FileSys.FileManipulation fm = new Common.FileSys.FileManipulation();
        ArrayList<ArrayList<String>> stringMatrix = fm.laboratory(textDumpFullpath);
        ArrayList<ArrayList<String>> afterPruneEmptyEntries = fm.RemoveEmptyEntries( stringMatrix);
        
        // Segue:  un doppio ciclo for -per righe e per colonne a scandire ArrayList<ArrayList<String>> facendo le giuste
        // conversioni ed istanziando una classe per ogni riga di ArrayList<ArrayList<String>> e quindi chiamando il Proxy una volta per ogni riga
        // della db-table.
        //--@@@@@
        Entity.Table.ReportAuto reportAutoRiga = null;
        for( int row=0; row<afterPruneEmptyEntries.size(); row++)
        {
            for( int col=0; col<afterPruneEmptyEntries.get(row).size(); col++)
            {
                // NB. generic column access is: afterPruneEmptyEntries.get(row).get(col)
                // generic row( with all its columns) id afterPruneEmptyEntries.get(row)
                // ---------------------parameter legenda:
//        // autovettura_id,             // [int] IDENTITY(1,1) NOT NULL,
//        this.targa_autovettura = par_targa_autovettura;
//afterPruneEmptyEntries.get(row).get(0); //        par_km;
//afterPruneEmptyEntries.get(row).get(1);//      rifornimento_luogo   
//        this.rifornimento_litri             =      par_rifornimento_litri;
//        this.costo_gasolio_euro_litro       =      par_costo_gasolio_euro_litro;
//        this.spesa_gasolio_euro             =      par_spesa_gasolio_euro;
//        this.accessori_descriz              =      par_accessori_descriz;
//        this.accessori_euro                 =      par_accessori_euro;
//        this.lavaggio_descr                 =      par_lavaggio_descr;
//        this.lavaggio_euro                  =      par_lavaggio_euro;
//        this.manutenzione_descr             =      par_manutenzione_descr;
//        this.data_ingresso_officina         =      par_data_ingresso_officina;
//        this.data_uscita_officina           =      par_data_uscita_officina;
//        this.manutenzione_euro              =      par_manutenzione_euro;
//        this.altro_descriz                  =      par_altro_descriz;
//        this.altro_euro                     =      par_altro_euro;
//        this.sinistro_descriz               =      par_sinistro_descriz;
//        this.conducente                     =      par_conducente;
//        this.riga_descriz                   =      par_riga_descriz;
//        this.costo_totale_riga_euro         =      par_costo_totale_riga_euro;
//        this.franchigia_assicurazione_euro  =      par_franchigia_assicurazione_euro;                
                //--@@@
//    String      par_targa_autovettura,       //, NB. deve essere utilizzata solo quando  la tabella e' multivettura. Altrimenti scegliere la tabella e non passare il parametro.
//    LocalDate   par_registration_date,    //] [date] NULL,
//    float       par_km,                       //] [float] NULL,
//    String      par_rifornimento_luogo,      //] [varchar](255) NOT NULL,
//    float       par_rifornimento_litri,       //  [float] NULL,
//    float       par_costo_gasolio_euro_litro, //  [float] NULL,
//    float       par_spesa_gasolio_euro,       //  [float] NULL,
//    String      par_accessori_descriz,       //  [varchar](255) NULL,
//    float       par_accessori_euro,           //  [float] NULL,
//    String      par_lavaggio_descr,          //] [varchar](255) NULL,
//    float       par_lavaggio_euro,            //] [float] NULL,
//    String      par_manutenzione_descr,      //] [varchar](255) NULL,
//    LocalDate   par_data_ingresso_officina,   //] [date] NULL,
//    LocalDate   par_data_uscita_officina,     //] [date] NULL,
//    float       par_manutenzione_euro,         // [float] NULL,
//    String      par_altro_descriz,               // ] [varchar](255) NULL,
//    float       par_altro_euro,                  // ] [float] NULL,
//    String      par_sinistro_descriz,            // ] [varchar](255) NULL,
//    String      par_conducente,                  // ] [varchar](255) NULL,
//    String      par_riga_descriz,                // ] [varchar](255) NOT NULL,
//    float       par_costo_totale_riga_euro,      //] [float] NOT NULL,
//    float       par_franchigia_assicurazione_euro                
                //--@@@
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//                reportAutoRiga = new Entity.Table.ReportAuto(
//                        // id IDENTITY
//                    "targa autovettura",     //, NB. deve essere utilizzata solo quando  la tabella e' multivettura. Altrimenti scegliere la tabella e non passare il parametro.
//                        
//                    LocalDate.parse( afterPruneEmptyEntries.get(row).get(0), formatter),  //     par_registrationDate
//                    Float.parseFloat(afterPruneEmptyEntries.get(row).get(1)),    //    float       par_km,                       //] [float] NULL,
//                    afterPruneEmptyEntries.get(row).get(2),  //     rifornimento_luogo
//Float.parseFloat(afterPruneEmptyEntries.get(row).get(3)), //    float       par_rifornimento_litri,       //  [float] NULL,
//afterPruneEmptyEntries.get(row).get(4), //    float       par_costo_gasolio_euro_litro, //  [float] NULL,
//afterPruneEmptyEntries.get(row).get(5), //    float       par_spesa_gasolio_euro,       //  [float] NULL,
//afterPruneEmptyEntries.get(row).get(6),//    String      par_accessori_descriz,       //  [varchar](255) NULL,
//afterPruneEmptyEntries.get(row).get(7),//    float       par_accessori_euro,           //  [float] NULL,
//afterPruneEmptyEntries.get(row).get(8),//   String      par_lavaggio_descr,          //] [varchar](255) NULL,
//afterPruneEmptyEntries.get(row).get(9),//   float       par_lavaggio_euro,            //] [float] NULL,
//afterPruneEmptyEntries.get(row).get(10),//  String      par_manutenzione_descr,      //] [varchar](255) NULL,
//afterPruneEmptyEntries.get(row).get(11),//   LocalDate   par_data_ingresso_officina,   //] [date] NULL,
//afterPruneEmptyEntries.get(row).get(12),//   LocalDate   par_data_uscita_officina,     //] [date] NULL,
//afterPruneEmptyEntries.get(row).get(13),//   float       par_manutenzione_euro,         // [float] NULL,
//afterPruneEmptyEntries.get(row).get(14),//   String      par_altro_descriz,               // ] [varchar](255) NULL,
//afterPruneEmptyEntries.get(row).get(15),//   float       par_altro_euro,                  // ] [float] NULL,
//afterPruneEmptyEntries.get(row).get(16),//   String      par_sinistro_descriz,            // ] [varchar](255) NULL,
//afterPruneEmptyEntries.get(row).get(17),//   String      par_conducente,                  // ] [varchar](255) NULL,
//afterPruneEmptyEntries.get(row).get(18),//   String      par_riga_descriz,                // ] [varchar](255) NOT NULL,
//afterPruneEmptyEntries.get(row).get(19),  //  float       par_costo_totale_riga_euro,      //] [float] NOT NULL,
//afterPruneEmptyEntries.get(row).get(20)  //    float       par_franchigia_assicurazione_euro                
//                );
            }// end forEach column 
//            // TODO:  Proxy  for each row.
//            reportAutoRiga.Postgres_ProxyWrapper_();
        }// end forEach row
        //
        return res;
    }// fromTABseparatedTxtDumpTo_PostgreSql
    
    /**
     *classWise utility, to wrap strings, as required from the databases.
     * @return
     */
    public static boolean fromTABseparatedTxtDumpTo_MsSql()
    {
        boolean res = false;
        //
        return res;        
    }// fromTABseparatedTxtDumpTo_MsSql    
    
} //  class FromExcelToDB 
