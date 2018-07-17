/*
the key-token recognize algorithm is common to both scalar and vector config files.
 */
package Common.ConfigurationService;


public abstract class KeyTokenRecognizer
{
    // nothing to do for Ctor

    protected boolean isKeyToken( String theToken)
    {// sons use the method as this.isKeyT. With private it does not work.
        int tokenLength = theToken.length();
        if(tokenLength >= +2)
        {// key-tokens need at least "[]", otherwise they are ill-formed.
            return ( theToken.charAt(0)=='[' &&
                     theToken.charAt(tokenLength-1)==']' );
        }// else
        return false;
    }// private boolean isKeyToken( String theToken)
    
    
}// class
