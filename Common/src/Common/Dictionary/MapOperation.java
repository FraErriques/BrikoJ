/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common.Dictionary;
import java.util.ArrayList;
import java.util.Map;
import java.util.*;
import java.util.Set;

/**
 *
 * @author fra
 */
public class MapOperation 
{
    private Hashtable<String, TheNode> dictionary;// =  new HashMap<String, String>();
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
            this.dictionary = new Hashtable<String, TheNode>();
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
                    //-------------
                    this.prune_recordLayout(lineTokens);
                    //-------------
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
            if(null!=rr)
            {
                // ? actions needed : deletion ?
            }
        }
        return associated_array;
    }// end Prototype_txtFileReader
    
    public boolean prune_recordLayout( String[] columns)
    {
        boolean res = false;// init to invalid
        if(true)//NB add here the pruning criteria
        {
            TheNode curRow = new TheNode( 
                    columns[1], 
                    columns[2],
                    columns[4], 
                    columns[5]            
            );
            this.dictionary.put(columns[1], curRow);
            res = true;
        }// else res stays false
        // ready
        return res;
    }// prune_recordLayout
    
    public void traverseDirect()
    {
        // Getting keySets of Hashtable and
        // storing it into Set
        Set<String> setOfKeys = this.dictionary.keySet();
        
        // Iterating through the Hashtable
        // object using for-Each loop
        for (String key : setOfKeys) 
        {
            // Print and display the Rank and Name
            System.out.print("\n------Rank : " + key
                               + "\t\t Name : "
                               + this.dictionary.get(key));
            this.dictionary.get(key).internalPrint();
        }// print
    }// traverseDirect

    public void NodeGarbageCollection()
    {
        // Getting keySets of Hashtable and
        // storing it into Set
        Set<String> setOfKeys = this.dictionary.keySet();
        
        // Iterating through the Hashtable
        // object using for-Each loop
        for (String key : setOfKeys) 
        {
            // Print and display the Rank and Name
            System.out.println("Preparing Garbage Collection for : " + key);
            this.dictionary.get(key).prepareGarbageCollection();
        }// foreach Key
    }// NodeGarbageCollection    
    
    
}// class
