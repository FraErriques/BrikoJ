package Common.FileSys;

import java.io.RandomAccessFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.EOFException;


public class TokenReader
{
    private java.io.RandomAccessFile inStream;
    private byte[] separators;
    private long curPosition;
    private enum parsingPhase
    {
        separatorsPreToken,
        insideToken,
        separatorsPostToken;
    }
    private int tokensReadUntilNow;
    private int separatorsBefore;
    private int charactersInTokenWithSeparators;
    private int charactersInTokenNoSeparators;
    private int separatorsAfter;
    
    
    public static void showASCIItextSymbols()
    {// an utility.
        for( int c=32; c<=126; c++)
        {
            System.out.println( "carattere codice "+ Integer.toString(c)+" ha simbolo: " + Character.toString((char)c) );
        }// end ASCII test block.
    }//public static void showASCIItextSymbols()
    
    public int get_tokensReadUntilNow()
    {
        return this.tokensReadUntilNow;
    }//public int get_tokensReadUntilNow()
    
    public int get_charactersInTokenWithSeparators()
    {
        return this.charactersInTokenWithSeparators;
    }//public int get_charactersInTokenWithSeparators()
    
    public int get_charactersInTokenNoSeparators()
    {
        return this.charactersInTokenNoSeparators;
    }//public int get_charactersInTokenNoSeparators()
    
    public int get_separatorsBefore()
    {
        return this.separatorsBefore;
    }//public int get_separatorsBefore()
    
    public int get_separatorsAfter()
    {
        return this.separatorsAfter;
    }//public int get_separatorsAfter()
      
    
    // Ctor
    public TokenReader(String fullPath)
    {
        this.curPosition = 0;
        this.tokensReadUntilNow = 0;
        this.separatorsBefore = 0;
        this.charactersInTokenWithSeparators = 0;
        this.separatorsAfter = 0;
        this.separators = new byte[]{9,32,10,13};//i.e.{TAB,blank,newLine,carriageReturn}.
        //
        try
        {// try-Open the Stream.
            this.inStream = new java.io.RandomAccessFile(fullPath, "r");// open in read mode.
        }
        catch( FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch( Exception  ex)
        {// it's the catchAll==catch(...)Cpp.
            if( null!=ex && null!=ex.getMessage())
            {
                System.out.println(ex.getMessage());
            }// else don't write.
        }// it's the catchAll==catch(...)Cpp.        
    }// end Ctor
    
    
    public void close()
    {// closes the RandomAccessFile, amnaged by the instance.
        try
        {
            this.inStream.close();
        }
        catch( IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch( Exception  ex)
        {// it's the catchAll==catch(...)Cpp.
            if( null!=ex && null!=ex.getMessage())
            {
                System.out.println(ex.getMessage());
            }// else don't write.
        }// it's the catchAll==catch(...)Cpp.
    }// end close FILE
    
    
    //------------------- crucial criterion ----------------
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
    
    
    
    // ----------- main algorithm ----------------------------------------------
    public String getToken()
    {
        parsingPhase currentPhase;
        currentPhase = parsingPhase.separatorsPreToken;// init
        StringBuilder sb = new StringBuilder();
        String res = null;
        int locSeparatorsBefore = 0;
        int locCharactersInTokenWithSeparators = 0;
        int locSeparatorsAfter = 0;
        //---start looping for readByte : each step gets an ASCII-code, not the symbol.
        for( ; ;locCharactersInTokenWithSeparators++ )
        {
            byte ASCIIcode = 0;
            try
            {//------ character acquisition -------------
                ASCIIcode = this.inStream.readByte();
                this.curPosition++;//NB. must be instance-wide variable, since the game is to call this method, until the tokens are over.
            }// the instance must know the seeking-position, and start parsing just from there.
            catch( EOFException ex)
            {
                if( null!=ex && null!=ex.getMessage())
                {
                    System.out.println(ex.getMessage());
                }// else don't write.
                break;
            }
            catch( IOException ex)
            {
                if( null!=ex && null!=ex.getMessage())
                {
                    System.out.println(ex.getMessage());
                }// else don't write.
                break;
            }
            catch( Exception  ex)
            {// it's the catchAll==catch(...)Cpp.
                if( null!=ex && null!=ex.getMessage())
                {
                    System.out.println(ex.getMessage());
                }// else don't write.
                break;
            }
            //
            //----here starts the parsing loop----------------------
            if( currentPhase == parsingPhase.separatorsPreToken)
            {
                if( this.isSeparator(ASCIIcode) )
                {// step through separators, while in "parsingPhase.separatorsPreToken"
                    locSeparatorsBefore++;
                    continue;
                }
                else// not a separator
                {// if not a separator, get it
                    sb.append( (char)ASCIIcode);
                    currentPhase = parsingPhase.insideToken;// set "token" phase.
                }
            }// end if( currentPhase == parsingPhase.separatorsPreToken)
            else if( currentPhase == parsingPhase.insideToken )
            {// when a separator is reached, during the "insideToken" phase
                if( this.isSeparator(ASCIIcode) )
                {// currentPhase is changed to separatorsPostToken;
                    currentPhase = parsingPhase.separatorsPostToken;
                    locSeparatorsAfter++;
                }// such separators will be read, until the next non-separator figure.
                else// not a separator
                {// if !separator, we're still in insideToken phase.
                    sb.append( (char)ASCIIcode);
                }
            }// end else if( currentPhase == parsingPhase.insideToken )
            else if( currentPhase == parsingPhase.separatorsPostToken )
            {
                if( this.isSeparator(ASCIIcode) )
                {
                    locSeparatorsAfter++;
                    continue;
                }
                else// not a separator
                {
                    try
                    {
                        this.inStream.seek( --this.curPosition );// go back, just the one byte of the next recognized token.
                    }// try
                    catch( IOException ex)
                    {
                        if( null!=ex && null!=ex.getMessage())
                        {
                            System.out.println(ex.getMessage());
                        }// else don't write.
                    }// catch
                    catch( Exception ex)
                    {// catch all (...)Cpp
                        if( null!=ex && null!=ex.getMessage())
                        {
                            System.out.println(ex.getMessage());
                        }// else don't write.
                    }// catch all (...)Cpp                    
                    break;// stop parsing.
                }// else// not a separator
            }// end else if( currentPhase == parsingPhase.separatorsPostToken )
        }// end for
        //
        res  = sb.toString();// when it's been read until next non-separator( and went back 1 byte).
        this.charactersInTokenWithSeparators = locCharactersInTokenWithSeparators;// update instance-wide member, for all figures read, separators included.
        this.charactersInTokenNoSeparators = locCharactersInTokenWithSeparators-locSeparatorsBefore-locSeparatorsAfter;// update instance-wide member.
        this.tokensReadUntilNow++;// update instance-wide member.
        this.separatorsBefore = locSeparatorsBefore;// update instance-wide member.
        this.separatorsAfter = locSeparatorsAfter;// update instance-wide member.
        // ready
        return res;
    }// end getToken()



    
}// class
