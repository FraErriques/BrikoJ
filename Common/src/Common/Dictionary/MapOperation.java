/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common.Dictionary;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author fra
 */
public class MapOperation {
    private Map<String, TheNode> dictionary;// =  new HashMap<String, String>();
    public MapOperation()
    {
        this.dictionary = null;
    }// Ctor
    

    /// parses a txtFile to get into memory a String matrix, in form of an ArrayList<String[]>
    public ArrayList<String[]> txtStringMatrix(String fullPath )
    {
        ArrayList<String[]> associated_array = null;
        associated_array = new ArrayList<String[]>();
        //--##
        java.io.FileReader rr = null;
        boolean hasReadSuccessfully = false;
        StringBuilder sb;
        String curLine;
        try
        {
            rr = new java.io.FileReader( fullPath);
            sb = new StringBuilder();
            //curLine NO new(): it will get StringBuilder's memory content.
            for (int ch=0; -1!= ch; )
            {
                ch = rr.read();
                if( -1 == ch)// means reached EOF.
                {
                    break;// due EOF==EndOfFile
                }// else still has to read
                else if(10==ch || 13==ch)
                {
                    curLine = sb.toString();
                    String[] lineTokens = curLine.split("\t");// split on blank XOR TAB
                    associated_array.add(lineTokens);
                    sb = null;//gc
                    curLine = null;//gc
                    lineTokens = null;//gc and then re-assigned by curLine.split("\t")
                    sb = new StringBuilder();// a brand new sb for next line
                    continue;// due EOL==EndOfLine
                }// else still has to read
                else
                {// on regular chars, append to the StringBuolder sb.
                    sb.append((char)ch);
                }
            }// end for "each char in stream".
            hasReadSuccessfully = true;
            rr.close();// txtFile close().
        }// end try-read
        catch( java.io.IOException e)//NB. the kind of exception
        {
            System.out.println("error while trying manipulate filestream : " + e.getMessage());
            hasReadSuccessfully = false;
        }
        finally 
        {
            //?
        }
        return associated_array;
    }// end Prototype_txtFileReader    
    

    
}
