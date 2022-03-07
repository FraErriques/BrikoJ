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
public abstract class TxtParser 
{
    DateTimeFormatter dateFormatter;// Ctor will init it.
    //-----end data ------------- 

    //Ctor
    public TxtParser()
    {
    // follows DateFormatter for every date field: check Excel, LibreOffice,..output for the present case.
        this.dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        /* examples of cast : every parameter needs to be cast and format-checked; this activity
        has to be centralized in the sons of this class. Ctor callers(i.e. Process::) pass Strings from the String-matrix as-are.
        The callers are multiple; the casting is centralized in the sons of this abstract class. */
    }// Ctor

    public String wrapSqlStrings( String par)// both dates and actual strings
    {
        String res = "NULL";// default for a DB String.
        if(null==par){return res;}
        if(par.trim().equals("NULL")){return res;}
        else if(par.trim().length()>0)
        {
            res = "'" + par + "'";
        }// else Default is aapropriate.
        if(res.trim().equals("'_placeholder_'")){return "NULL";}// a NULL field.
        return res;
    }// wrapSqlStrings
    
    public float tryParseFloat( String par)
    {
        float res = (float)0.0;// init to default empty entry in a data sheet.
        if(null==par){return res;}
        if(par.trim().equals("_placeholder_")){return res;}// a zero field.
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
    
    public final double tryParseDouble( String par)
    {
        double res = 0.0;// init to default zero entry in a data sheet.
        if(null==par){return res;}
        if(par.trim().equals("_placeholder_")){return res;}// a zero field.
        if(par.trim().length()>0)
        {
            try
            {            
                res = Double.parseDouble(par);
            }
            catch(Exception ex)
            {
                String dbg = ex.getMessage();
                // in this case "dbDate" is not suitable, and so the default for invalid date will be returned.
                res = 0.0;// reset the return value, since it has been dirtied in the conversione.
            }
            finally
            {
                int dbg_i = 12;
            }            
        }// else Default is aapropriate.
        return res;
    }// double    
    
    public String fromItalianDate_to_AmericanDate( String par )
    {
        String res = "";
        if(par.trim().length()<10){return res;}// NO dd/MM/yyyy can be contained.
        // else continue.
        res = "'";// start DB string
        res += par.substring(6, 10);// yyyy
        res += "/";
        res += par.substring(3,5);// MM
        res += "/";
        res += par.substring(0,2);// dd
        res += "'";// end DB string
        return res;
    }
    
	// A note about the string "_placeholder_" :
	// Excel and other spreadsheets cannot consider empty cells, while saving TAB-separated files.
	// Such empty cells will then be ignored, taking the place of adjacent cells.
	// To avoid such behaviour one has to insert a conventional string (here "_placeholder_") to signal that the field
	// exists but it has intentionally not been valorized. This application supplies NULL parameters to the DB.
    public String tryParseLocalDate( String par )
    {
        String dbDate = "NULL";// an adequate default for an empty date-field in the txt.
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
            dbDate = "NULL";// reset the return value, since it has been dirtied in the conversion.
        }
        finally
        {
            int dbg_i = 12;
        }
        //
        return dbDate;
    }// tryParseLocalDate

}// class TxtParser
