/*
one to one correspondence, between key-token and value-token.
 */
package Common.ConfigurationService;

import java.util.Enumeration;
import java.util.Set;

 
public class scalarConfig extends KeyTokenRecognizer
{
    private Common.FileSys.TokenReader theConfigStream;
    private java.util.Hashtable<String, String> keyValueTokenMap;
    private int tokOrd;

    // Ctor
    public scalarConfig( String fullPath)
    {
        this.theConfigStream = new Common.FileSys.TokenReader( fullPath);
        this.keyValueTokenMap = new java.util.Hashtable<String, String>();
        this.tokOrd = 0;// init.
    }// Ctor
    

    
    public Enumeration getAllKeys()
    {
        //        java.util.Hashtable<String, String> x = new java.util.Hashtable<String, String>();
        //        x.put("key_1", "val_1");
        //        //--
        //        int sz = x.size();
        //        Enumeration k = x.keys();
        //        //
        return this.keyValueTokenMap.keys();
    }// public Enumeration getAllKeys()
    
    
    public String[] getAllKeys( boolean wantStringArray)
    {
        int keyCardinality = this.keyValueTokenMap.size();
        String[] res = new String[keyCardinality];
        Set keySet = this.keyValueTokenMap.keySet();
        Object keyVector[] = keySet.toArray();
        for( int c=0; c<keyVector.length; c++)
        {
            res[c] = (String)(keyVector[c]);
        }
        return res;
    }//public String[] getAllKeys()
    
    
    public String getValue( String key)
    {
        String res = null;
        if( this.keyValueTokenMap.containsKey(key))
        {
            res = this.keyValueTokenMap.get( key);
        }// else keep init val.
        return res;
    }// getValue
    
    
    private boolean isOdd( int index)
    {
        double delta = (double)index/+2.0 - index/2;
        return( Math.abs(delta)>+1.0E-80);
    }//private bool isOdd( int index)
    
    
    public int getParsedCouples() throws Exception
    {
        if( this.isOdd( this.tokOrd))
        {
            throw new Exception("NB. serious parsing error: token cardinality cannot be odd, since they are couples!");
        }// else it's ok, if tokens are even.
        return( this.tokOrd/2);
    }//
    
    
    public void buildKeyValMap()
    {
        String stagingKey = "";// valorized each TWO steps; i.e. only at odd index-steps.
        String curTok = "init to something not empty and not null.";//re-read at each step.
        //---------------main loop------------------------------------- 
        for( ; null!=curTok && !curTok.equals(""); )
        {
            curTok = this.theConfigStream.getToken();// read_token.
            //
            if( null==curTok || curTok.equals("") )// curTok.equals("") means EOF.
            {
                if( this.isKeyToken(stagingKey) )
                {// reuse last token, in case it's key, orphaned of its value.
                    this.keyValueTokenMap.put( stagingKey, "nop");// here "nop" has the meaning "NULL" has on DBs.
                    this.tokOrd++;// add a spurious token.
                }// else if last token is a value, oprphaned of its key, we throw it away.
                else if( this.isOdd(tokOrd))
                {
                    this.tokOrd--;// eliminate a spurious token.
                }// else ok.
                break;// from parsing, without counting the last token, which is an empty one, indicating EOF.
            }// else go on parsing.
            else
            {
                this.tokOrd++;// annotate each token read.
            }
            //---------------------------
            if( this.isOdd(tokOrd))// at odd indexes there are keys; at even ones, values.
            {
                if(this.isKeyToken(curTok))
                {// a key-token, at an odd index, is appropriate.
                    stagingKey = curTok;
                }
                else
                {// if the token, at odd index, has no key-attributes, it's not acceptable.
                    stagingKey = "@InvalidKey";
                }
            }// endif is odd index.
            else
            {// even index
                if( ! this.isKeyToken(curTok))// must not be a key, since current index is even; it has to be a value.
                {
                    if( null!=stagingKey && !stagingKey.equals("") && !stagingKey.equals("@InvalidKey") )
                    {// if the preceding key is valid
                        // insert in map
                        this.keyValueTokenMap.put( stagingKey, curTok);
                        stagingKey = "";// re-init, after usage.
                    }// if the preceding key is valid
                    else // if the preceding key is INVALID.
                    {
                        // skip a value whose key is not present.
                        stagingKey = "";// re-init, after usage.
                        --tokOrd;// rewind of the index of the skipped val( orphaned for no key).
                        continue;
                    }//else // if the preceding key is INVALID.
                }// if( ! this.isKeyToken(curTok))
                else // two subsequent key-tokens.
                {
                    if( null!=stagingKey && !stagingKey.equals("") && !stagingKey.equals("@InvalidKey") )
                    {// if the preceding key is valid
                        // insert "nop" , as the missing value of previous key-token.
                        this.keyValueTokenMap.put( stagingKey, "nop");// here "nop" has the meaning "NULL" has on DBs.
                        ++tokOrd;// forward of the index of the added val( which is "nop", since it was absent).
                        stagingKey = curTok;// recuperare la chiave successiva, causa chiavi consecutive, per missing values.
                    }
                    else
                    {// case of orphaned value, i.e. without key.
                        stagingKey = curTok;// recuperare la chiave successiva al valore orfano.
                        --tokOrd;// rewind of the index of the skipped val( orphaned for no key).
                        // continue;unnecessary here, since it's last for' statement.
                    }
                }//else // two subsequent key-tokens.
            }// end if token is value.
        }// for
        this.theConfigStream.close();// remember to close() the Stream.
    }// buildKeyValMap()
    
    
    // just a Test method, for example & debugging needs.
    public void getTokensFromConfigStream()
    {
        String curTok = "init to something not empty and not null.";
        for( int tokOrd=1 ; null!=curTok && !curTok.equals(""); tokOrd++)
        {
            curTok = this.theConfigStream.getToken();
            if( null==curTok || curTok.equals("") )// curTok.equals("") means EOF.
            {
                break;
            }// else continue.
            System.out.println("token ordinal "+Integer.toString(tokOrd)+" = "+curTok);
            System.out.println("tokens read until now "+ this.theConfigStream.get_tokensReadUntilNow());
            System.out.println("characters Read In Last Token (comprehensive of separators) "+ this.theConfigStream.get_charactersInTokenWithSeparators() );
            System.out.println("characters Read In Last Token (NO separators) "+ this.theConfigStream.get_charactersInTokenNoSeparators() );
            System.out.println("separators before "+ this.theConfigStream.get_separatorsBefore() );
            System.out.println("separators after "+ this.theConfigStream.get_separatorsAfter() );
            System.out.println();
        }// for
        this.theConfigStream.close();// remember to close() the Stream.
    }
    
    
}// class
