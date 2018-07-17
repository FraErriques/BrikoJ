package Common.FileSys;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TokenReader
{
    private java.io.RandomAccessFile inStream;
    private byte[] separators;
    long curPosition; 
    
    public TokenReader(String fullPath)
    {
//        for( int c=32; c<=126; c++)
//        {
//            System.out.println( "carattere codice "+ Integer.toString(c)+" ha simbolo: " + Character.toString((char)c) );
//        }// end ASCII test block.
//        //
        curPosition = 0;
        this.separators = new byte[]{7,32,10,13};//i.e.{TAB,blank,newLine,carriageReturn}.
        //
        try
        {
            this.inStream = new java.io.RandomAccessFile(fullPath, "r");// open in read mode.
        }
        catch( FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
        
    }// end Ctor
    
    
    private boolean isSeparator( byte ch)
    {
        boolean res = false;
        for( int c=0; c<4; c++)
        {
            if( ch == this.separators[c])
            {
                res = true;
                break;
            }// else continue.
        }// for
        return res;
    }// isSeparator
    
    
    
    public String getToken()
    {
		enum parsingPhase
		{
			separatorsPreToken,
			insideToken,
			separatorsPostToken;
		}
		parsingPhase currentPhase;
		currentPhase = parsingPhase.separatorsPreToken;// init
        StringBuilder sb = new StringBuilder();
        String res = null;
        boolean isInSeparatorPhase = false;
        //
        for( int c=0; ;c++)
        {
            byte ASCIIcode = 0;
            try
            {
                ASCIIcode = this.inStream.readByte();
                this.curPosition++;
            }
            catch( IOException ex)
            {
                if( null!=ex && null!=ex.getMessage())
                {
                    System.out.println(ex.getMessage());
                }// else don't write.
                break;
            }
            //
			if( currentPhase == parsingPhase.separatorsPreToken)
			{
				if( this.isSeparator(ASCIIcode) )
				{
					continue;
				}
				else// not a separator
				{
					sb.append( (char)ASCIIcode);
					currentPhase = parsingPhase.insideToken;
				}
			}
			else if( currentPhase == parsingPhase.insideToken )
			{
				if( this.isSeparator(ASCIIcode) )
				{
					currentPhase = parsingPhase.separatorsPostToken;
				}
				else// not a separator
				{
					sb.append( (char)ASCIIcode);
				}				
			}// end else if( currentPhase == parsingPhase.insideToken )
			else if( currentPhase == parsingPhase.separatorsPostToken )
			{
				if( this.isSeparator(ASCIIcode) )
				{
					continue;
				}
				else// not a separator
				{
					this.inStream.seek( this.curPosition-1);// go back, just the one byte of the next recognized token.
					break;// stop parsing.
				}				
			}// end else if( currentPhase == parsingPhase.insideToken )				
				
			
			
			
			
            // if( ! this.isSeparator(ASCIIcode))
            // {
                // if( ! isInSeparatorPhase)
                // {
                    // sb.append( (char)ASCIIcode);
                // }
                // else
                // {
                    // try
                    // {
                        // this.inStream.seek( this.curPosition-1);// go back, just the one byte of the next recognized token.
                    // }
                    // catch( IOException ex)
                    // {
                        // if( null!=ex && null!=ex.getMessage())
                        // {
                            // System.out.println(ex.getMessage());
                        // }// else don't write.
                    // }// catch
                // }
            // }
            // else// keep reading & skipping until next non-separator.
            // {
                // isInSeparatorPhase = true;
                // continue;
            // }
			
        }// for
        //
        res  = sb.toString();// when read until next non-separator.
        // ready
        return res;
    }// end getToken()
    
    
    public void close()
    {        
        try
        {
            this.inStream.close();
        }
        catch( IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }// end close
    
}
