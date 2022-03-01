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

    public static boolean fromTABseparatedTxtDumpTo_MsSql(
            String textDumpFullpath,
            String targaAutovettura
    )
    {
        boolean res = false;
        //----follows the sequence to be used:
        Common.FileSys.FileManipulation fm = new Common.FileSys.FileManipulation();
        ArrayList<ArrayList<String>> stringMatrix = fm.laboratory(textDumpFullpath);
        // ReportAuto has strategical empty-entries -> NO : ArrayList<ArrayList<String>> afterPruneEmptyEntries = fm.RemoveEmptyEntries( stringMatrix);
        ArrayList<ArrayList<String>> afterPruneEmptyEntries = stringMatrix;// invariata.
        // Segue:  un ciclo for per righe, istanziando una classe per ogni riga di ArrayList<ArrayList<String>> 
        // e quindi chiamando il Proxy una volta per ogni riga della db-table.
        //--@@@@@
        Entity.Table.ReportAuto reportAutoRiga = null;
        for( int row=0; row<afterPruneEmptyEntries.size(); row++)
        {
            // generic row( with all its columns) id afterPruneEmptyEntries.get(row)
            ArrayList<String> curRow = afterPruneEmptyEntries.get(row);
            if( curRow.size()<21 )
            {
                continue;// skip inadequate row.
            }// else treat it.
            //
            reportAutoRiga = new Entity.Table.ReportAuto(
                // id IDENTITY
                targaAutovettura, // NB. la tabella e' multivettura.
                afterPruneEmptyEntries.get(row).get(0),  // registrationDate
                afterPruneEmptyEntries.get(row).get(1), // km
                afterPruneEmptyEntries.get(row).get(2),  // rifornimento_luogo
                afterPruneEmptyEntries.get(row).get(3), // rifornimento_litri
                afterPruneEmptyEntries.get(row).get(4),  // costo_gasolio_euro_litro
                afterPruneEmptyEntries.get(row).get(5),  // spesa_gasolio_euro 
                afterPruneEmptyEntries.get(row).get(6),  // accessori_descriz
                afterPruneEmptyEntries.get(row).get(7),  // accessori_euro
                afterPruneEmptyEntries.get(row).get(8),  // lavaggio_descr 
                afterPruneEmptyEntries.get(row).get(9),  // lavaggio_euro 
                afterPruneEmptyEntries.get(row).get(10), // manutenzione_descr 
                afterPruneEmptyEntries.get(row).get(11), // data_ingresso_officina 
                afterPruneEmptyEntries.get(row).get(12), // data_uscita_officina 
                afterPruneEmptyEntries.get(row).get(13), // manutenzione_euro 
                afterPruneEmptyEntries.get(row).get(14), // altro_descriz 
                afterPruneEmptyEntries.get(row).get(15), // altro_euro 
                afterPruneEmptyEntries.get(row).get(16), // sinistro_descriz 
                afterPruneEmptyEntries.get(row).get(17), // conducente 
                afterPruneEmptyEntries.get(row).get(18), // riga_descriz 
                afterPruneEmptyEntries.get(row).get(19), // costo_totale_riga_euro 
                afterPruneEmptyEntries.get(row).get(20)  // franchigia_assicurazione_euro
            );
            // Proxy  for each row:
            reportAutoRiga.MsSql_ProxyWrapper_();
        }// end forEach row: all rows in the String-Matrix have been sent to DB.
        // ready.
        return res;
    }// fromTABseparatedTxtDumpTo_MsSql
    

} //  class FromExcelToDB 
