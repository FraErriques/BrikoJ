 
package Common.ConfigurationService;

import java.util.ArrayList;
import java.util.Set;

 
public class vectorialConfig extends KeyTokenRecognizer
{
    private Common.FileSys.TokenReader theConfigStream;
    java.util.Hashtable< String, java.util.ArrayList<String> >  keyVectorMap;
    private int keyOrd;
    private int valOrd;

    // Ctor
    public vectorialConfig( String fullPath)
    {
        this.theConfigStream = new Common.FileSys.TokenReader( fullPath);
        this.keyVectorMap = new java.util.Hashtable< String, java.util.ArrayList<String> >();
        this.keyOrd = 0;// init.
        this.valOrd = 0;// init.
    }// Ctor    
    
    
    public int getKeyOrd()
    {
        return this.keyOrd;
    }// getKeyOrd()
    
    public int getValOrd()
    {
        return this.valOrd;
    }// getValOrd()
    
    
 
    public void buildKeyVectorMap()
    {
        String stagingKey = "";// no odd-even management, since there's no rule about how many tokens form a vector value.
        String curTok = "init to something not empty and not null.";//re-read at each step.
        //---------------main loop------------------------------------- 
        for( ; null!=curTok && !curTok.equals(""); )
        {
            curTok = this.theConfigStream.getToken();// read_token.
            //
            if( null==curTok || curTok.equals("") )// curTok.equals("") means EOF.
            {
                break;// from parsing, without counting the last token, which is an empty one, indicating EOF.
            }// else go on parsing.
            //
            if( this.isKeyToken(curTok) )
            {
                this.keyVectorMap.put(  curTok, new java.util.ArrayList<String>() );
                stagingKey = curTok;// stagingKey will be used for all the vector-value components of current key.
                this.keyOrd++;
            }
            else // one of the components of the vector-value, associated with current key.
            {
                this.keyVectorMap.get( stagingKey).add( curTok);
                this.valOrd++;
            }// else // one of the components of the vector-value, associated with current key.
        }// for
    }// buildKeyValMap()
    
    
    //---- querying method for a single vector-value, associated with the required key---------------------
    public String[] getVectorValuesOnKey( String key)
    {
        Object associated_value = null;
        ArrayList<String> associated_array = null;        
        String outVec[] = null;
        if( this.keyVectorMap.containsKey( key) )
        {
            associated_value = this.keyVectorMap.get( key);
            if( null != associated_value)
            {
                associated_array = (ArrayList<String>)associated_value;
                outVec = new String[ associated_array.size()];
                associated_array.toArray(outVec);// outVec here is a reference, which works as an output param.
            }
        }
        else
        {
            associated_value = null;
        }
        return outVec;
    } //---end-- querying method for a single vector-value, associated with the required key---------------------

    
    //----- querying method for ALL keys -----------------------------------
    public String[] getAllKeys()
    {
        Set<String> keySet = this.keyVectorMap.keySet();
        String keys[] = new String[keySet.size()];
        keys = keySet.toArray( keys);
        return keys;
    }//---end---- querying method for ALL keys -----------------------------------
        
 
        //---- querying method for a single vector-value, associated with the required key---------------------
    public int[] tryGetIntVectorValuesOnKey( String key) throws Exception
    {
        Object associated_value = null;
        ArrayList<String> associated_array = null;// this is the original second member in the data structure.
        String outVec[] = null;
        int outIntVec[] = null;
        if( this.keyVectorMap.containsKey( key) )
        {
            associated_value = this.keyVectorMap.get( key);
            if( null != associated_value)
            {
                associated_array = (ArrayList<String>)associated_value;
                outVec = new String[ associated_array.size()];
                associated_array.toArray(outVec);// outVec here is a reference, which works as an output param.                
                outIntVec = new int[ associated_array.size()];
                for( int c=0; c<outVec.length; c++)
                {
                    outIntVec[c] = Integer.parseInt( outVec[c]);
                }
            }// else no chance to get the value from null.
        }
        else
        {
            associated_value = null;
        }
        return outIntVec;        
    }// public int[] tryGetIntVectorValuesOnKey( String key)


    //---- querying method for a single vector-value, associated with the required key---------------------
    public double[] tryGettDoubleVectorValuesOnKey( String key) throws Exception
    {
        Object associated_value = null;
        ArrayList<String> associated_array = null;// this is the original second member in the data structure.
        String outVec[] = null;
        double outDoubleVec[] = null;
        if( this.keyVectorMap.containsKey( key) )
        {
            associated_value = this.keyVectorMap.get( key);
            if( null != associated_value)
            {
                associated_array = (ArrayList<String>)associated_value;
                outVec = new String[ associated_array.size()];
                associated_array.toArray(outVec);// outVec here is a reference, which works as an output param.                
                outDoubleVec = new double[ associated_array.size()];
                for( int c=0; c<outVec.length; c++)
                {
                    outDoubleVec[c] = Double.parseDouble( outVec[c]);
                }
            }// else no chance to get the value from null.
        }
        else
        {
            associated_value = null;
        }
        return outDoubleVec;        
    }// public double[] tryGetIntVectorValuesOnKey( String key)

    
}// class
