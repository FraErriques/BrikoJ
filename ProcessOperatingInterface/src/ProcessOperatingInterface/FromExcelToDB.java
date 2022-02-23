/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProcessOperatingInterface;

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
