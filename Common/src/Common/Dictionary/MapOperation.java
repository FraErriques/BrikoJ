/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common.Dictionary;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            // DBG System.out.println("Preparing Garbage Collection for : " + key);
            this.dictionary.get(key).prepareGarbageCollection();
        }// foreach Key
    }// NodeGarbageCollection    
    
    public void nodeFinder( String requiredkey)
    {
        if( null!=this.dictionary)
        {
            if( this.dictionary.containsKey(requiredkey))
            {
                this.dictionary.get(requiredkey).internalPrint();
            }
            else
            {
                System.out.println("\n\t key:"+requiredkey+" NOT FOUND.");
            }
        }
        else
        {
            System.out.println("The map is empty.");
        }
    }// nodeFinder
    
    public void mapListener()
    {
        String acquiredString = "init";
        // NB. technique to acquire a string from Console.
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for(;;)
        {
            try
            {
                System.out.print("\n\t Enter FFWD to Traverse Forward the Map");
                //System.out.print("\n\t Enter BKWD to Traverse Backward the Map");
                System.out.print("\n\t Enter Required Map-key: ");
                System.out.print("\n\t Enter \"Exit loop\" to abandon the application\n\n\t");                
                //
                acquiredString = bufferedReader.readLine();
                if("Exit loop".equals(acquiredString))
                {
                    System.out.println("\n\t Exiting...Good bye\t");
                    break;
                }// else continue.
                else if("FFWD".equals(acquiredString))
                {
                    this.traverseDirect();
                }
//                else if("BKWD".equals(acquiredString))
//                {
//                    this.mapTraverseReverse();
//                }
                else
                {
                    // DBG System.out.print(" required record: "+acquiredString);
                    this.nodeFinder( acquiredString);
                }
            }// try
            catch(IOException IOspecificEx) 
            {
                System.err.println("IOspecificEx: "+IOspecificEx.getMessage());
            }
            catch(Exception genericEx) 
            {
                System.err.println("genericEx: "+genericEx.getMessage());
            }            
        }// for Listener core
    }// mapListener
    
}// class
