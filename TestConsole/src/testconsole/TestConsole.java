
package testconsole;

import Common.EncryptStore.*;
import Common.DBservice.*;
import Entity.*;
import ProcessOperatingInterface.*;
import Common.FileSys.TokenReader;
import java.util.Enumeration;
import java.util.Hashtable;
import java.lang.System;
import Common.ConfigurationService.*;
import Common.MonteCarlo.*;
import java.util.Set;



public class TestConsole
{


    
    /******************* EntryPoint ****************************/
    public static void main(String[] args)
    {
        for(int c=0; c<50; c++)
        {            
            System.out.println( Common.MonteCarlo.MonteCarloGenerator.nextInteger(5, 16) );
        }
        
        
        java.util.Hashtable< String, java.util.Stack<String> > threadLoggingStack =
            new java.util.Hashtable< String, java.util.Stack<String> >();
        
        for(int c=0; c<50; c++)
        {
            ThreadForker theForker = new ThreadForker();
            String threadName = Common.MonteCarlo.MonteCarloGenerator.UID();
            Thread t = new Thread( theForker, threadName );            
            threadLoggingStack.putIfAbsent( threadName, new java.util.Stack<String>() );
            //
            t.start();// run asynchronously.
            //
            if( threadLoggingStack.containsKey( threadName) )
            {
                System.out.println("key representing thread named : "+threadName+" found.");
                long cardThreadStack = 0;
                cardThreadStack = Common.MonteCarlo.MonteCarloGenerator.nextInteger(1, 16);
                for(int d=0; d<cardThreadStack; d++)
                {
                    threadLoggingStack.get( threadName).addElement("stack level "+d+" on "+ threadName);
                }
            }
            else
            {
                System.out.println("key representing thread named : "+threadName+" NOT found.");
                threadLoggingStack.putIfAbsent( threadName, new java.util.Stack<String>() );
            }
            
        }// for 50 forks
        
        Set<String> theKeys = threadLoggingStack.keySet();
        Object[] theKeysArray = theKeys.toArray();
        for( int c=0; c<theKeysArray.length; c++)
        {
            System.out.println( (String)(theKeysArray[c]) );
            int cardCurThreadStack = threadLoggingStack.get( (String)(theKeysArray[c]) ).size();
            for( int d=0; d<cardCurThreadStack; d++)
            {
                System.out.println( threadLoggingStack.get( (String)(theKeysArray[c]) ).get(d) );
            }// for cardCurThreadStack
            System.out.println( );
        }// for each thread.
        // done
    }// main
    
    
}// end class TestConsole




/*  ------------------------------- cantina ------------------------------------------
//        //
//        Common.ConfigurationService.scalarConfig configReader = new Common.ConfigurationService.scalarConfig("./configSample.txt");
//        configReader.getTokensFromConfigStream();
        
//        String curTok = "init to something not empty and not null.";
//        for( int tokOrd=1 ; null!=curTok && !curTok.equals(""); tokOrd++)
//        {
//            curTok = configRader.getToken();
//            if( null==curTok || curTok.equals("") )// curTok.equals("") means EOF.
//            {
//                break;
//            }// else continue.
//            System.out.println("token ordinal "+Integer.toString(tokOrd)+" = "+curTok);
//            System.out.println("tokens read until now "+ configRader.get_tokensReadUntilNow());
//            System.out.println("characters Read In Last Token (comprehensive of separators) "+ configRader.get_charactersInTokenWithSeparators() );
//            System.out.println("characters Read In Last Token (NO separators) "+ configRader.get_charactersInTokenNoSeparators() );
//            System.out.println("separators before "+ configRader.get_separatorsBefore() );
//            System.out.println("separators after "+ configRader.get_separatorsAfter() );
//            System.out.println();
//        }// for
//        configRader.close();// remember to close() the Stream.
		        
        
        
        
//        //Properties prop = System.getProperties();
//        System.getProperties();
//        //
//        String Jhome = System.getProperty( "java.home");
//        System.out.println(Jhome);        
//        //        
//        String Jversion = System.getProperty( "java.version");
//        System.out.println(Jversion);
//        //
//        String Jvendor = System.getProperty( "java.vendor");
//        System.out.println(Jvendor);
//        //        
//        String JvendorURL = System.getProperty( "java.vendor.url");
//        System.out.println(JvendorURL);
//        //        
//        String JvmSpecVersion = System.getProperty( "java.vm.specification.version");
//        System.out.println(JvmSpecVersion);
//        //        
//        String JvmSpecVendor = System.getProperty( "java.vm.specification.vendor");
//        System.out.println(JvmSpecVendor);
//        //        
//        String JvmSpecName = System.getProperty( "java.vm.specification.name");
//        System.out.println(JvmSpecName);        
//        //
//        String JvmVersion = System.getProperty( "java.vm.version");
//        System.out.println(JvmVersion);
//        //        
//        String JvmVendor = System.getProperty( "java.vm.vendor");
//        System.out.println(JvmVendor);
//        //        
//        String JvmName = System.getProperty( "java.vm.name");
//        System.out.println(JvmName);        
//        //        
//        String JSpecVendor = System.getProperty( "java.specification.vendor");
//        System.out.println(JSpecVendor);
//        //        
//        String JSpecName = System.getProperty( "java.specification.name");
//        System.out.println(JSpecName);        
//        //
//        String JVersion = System.getProperty( "java.version");
//        System.out.println(JVersion);
//        //                
//        String osName = System.getProperty( "os.name");
//        System.out.println(osName);
//        //
//        java.util.Hashtable<String, String> x = new java.util.Hashtable<String, String>();
//        x.put("key_1", "val_1");
//        x.put("key_2", "val_2");
//        x.put("key_3", "val_3");
//        //--
//        int sz = x.size();
//        Enumeration k = x.keys();
//        //
                
        
       
		
		
        // int primoOperando = 56;
        // int secondoOperando = 3;
        // int result = primoOperando^secondoOperando;// bitwise XOR operator.
        // int back = result^secondoOperando;// ont the second step, we're back where we started.
        // //
        // Common.EncryptStore.XorSimple xorSimpleInstance = new Common.EncryptStore.XorSimple();
        // int res = xorSimpleInstance.getEncryptedIntByXorSimple( 4);
        // //
        // Common.DBservice.JDbService dbManager = new Common.DBservice.JDbService();
        // dbManager.dbConnectorTemplate();
        //
//        Common.ConfigurationService CommonCall = new Common.ConfigurationService();
//        int i = 93 + CommonCall.fromLibrary();
//        String fromCommon = "fromCommon:" + Integer.toString( i );
//        fromCommon += returnLayerSeparator();
//        //
//        Entity.SomeEntity EntityCall = new Entity.SomeEntity();
//        fromCommon += EntityCall.getEntityName();
//        fromCommon += returnLayerSeparator();
//        //
//        ProcessOperatingInterface.SomeProcessOperatingInterfaceClass process = new ProcessOperatingInterface.SomeProcessOperatingInterfaceClass();
//        fromCommon += process.someProcessMethod();
//        fromCommon += returnLayerSeparator();
//        fromCommon += "The fardest caller is me: testconsole::main() ";
//        //
//        Common.Calendar.CalendarService cs = new Common.Calendar.CalendarService();
//        String tm = cs.getCurrentTimeStamp();
//        System.out.println( tm );
//        
//        Common.FileSys.FileManipulation fm = new Common.FileSys.FileManipulation();
//        fm.txtFileWriter("./esempio.txt");
//        fm.txtFileReader("./esempio.txt");
*/
