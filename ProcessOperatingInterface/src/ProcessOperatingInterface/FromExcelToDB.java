/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProcessOperatingInterface;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author itfraerr
 */
public class FromExcelToDB 
{

    public static boolean fromTABseparatedTxtDumpTo_PostgreSql()
    {
        boolean res = false;
        String textDumpFullpath = "somewhereInFileSys";
        //----follows the sequence to be used:
        Common.FileSys.FileManipulation fm = new Common.FileSys.FileManipulation();
        ArrayList<ArrayList<String>> stringMatrix = fm.laboratory(textDumpFullpath);
        ArrayList<ArrayList<String>> cleanStringMatrix = fm.RemoveEmptyEntries( stringMatrix);
        // TODO inserire in un doppio ciclo for -per righe e per colonne e scandire ArrayList<ArrayList<String>> facendo le giuste
        // conversioni ed istanziando una classe per ogni riga di ArrayList<ArrayList<String>> e quindi chiamando il Proxy una volta per ogni riga
        // della db-table.
        Entity.Table.ReportAuto reportAuto = new Entity.Table.ReportAuto(
                textDumpFullpath, 
                LocalDate.MIN, 
                0, 
                textDumpFullpath,
                0, 
                0,
                0,
                textDumpFullpath, 
                0,
                textDumpFullpath,
                0,
                textDumpFullpath,
                LocalDate.EPOCH,
                LocalDate.MIN, 
                0, 
                textDumpFullpath, 
                0,
                textDumpFullpath,
                textDumpFullpath,
                textDumpFullpath, 
                0,
                0
        );
        // TODO:
        // new Entity::fromExcelToDB
        // Entity::fromExcelToDB::ProxyToProcedure()
        //
        return res;
    }// fromTABseparatedTxtDumpTo_PostgreSql
    
    public static boolean fromTABseparatedTxtDumpTo_MsSql()
    {
        boolean res = false;
        //
        return res;        
    }// fromTABseparatedTxtDumpTo_MsSql    
    
} //  class FromExcelToDB 
