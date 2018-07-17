package testconsoleui;

import Common.db.DbService;
import Common.FileSys.TokenReader;

public class TestConsoleUI
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
//        Common.db.DbService dbSrv = new Common.db.DbService();
//        dbSrv.testDbFeatures();
        
        Common.FileSys.TokenReader configRader = new Common.FileSys.TokenReader("./configSample.txt");
        String curTok = "";
        for( int tokOrd=1 ; null!=curTok; tokOrd++)
        {
            curTok = configRader.getToken();
            if( null== curTok)
            {
                break;
            }// else continue.
            System.out.println("token ordinal "+Integer.toString(tokOrd)+" = "+curTok);
        }// for
    }// main
    
}// class
