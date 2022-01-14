
package testconsole;

import Common.EncryptStore.*;
import Common.DBservice.*;
import Common.FileSys.TokenReader;     
import Common.ConfigurationService.*;
import Common.MonteCarlo.*;        
import Entity.*;
import Entity.ComplexField.Complex;
import ProcessOperatingInterface.*;
//
import java.util.Enumeration;
import java.util.Hashtable;
import java.lang.System;
import com.mysql.jdbc.DatabaseMetaData;
import java.util.Set;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;










public class TestConsole
{



    
    /******************* EntryPoint ****************************/
    public static void main(String[] args)
    {
        Entity.ComplexField.Complex z = new Complex( +3.0 , +2.0);
        for( double immPart=0.0; immPart<+6.0; immPart+=0.1)
        {
            Complex other = new Complex( +3.0, immPart);
            System.out.println(" performing: "+z.ToString()+" / "+ other.ToString()+" = "+ 
                    Complex.operator_div(z, other).ToString() );
        }// for
        Complex.Argument arg = z.argument();
        
//        
//        Common.DBservice.PostgreSql postgSql = new Common.DBservice.PostgreSql();
//        postgSql.insertionLoop_template();
//        postgSql.closeConnection();        
                
//        String connUrl_ITBZ_Delta = "jdbc:sqlserver://ITBZOW1422;instanceName=Delta;databaseName=Numerics;user=applicationuser;password=curricula";
//        String connUrl_ITBZ_ExpressLie = "jdbc:sqlserver://ITBZOW1422;instanceName=ExpressLie;databaseName=Numerics;user=applicationuser;password=curricula";        
//        String connUrl_ITFORS1011_SUZE = "jdbc:sqlserver://ITFORS1011;instanceName=SUZE;databaseName=dotazioni2021;user=applicationuser;password=curricula";
//        Common.DBservice.MsSql msSql = new Common.DBservice.MsSql( connUrl_ITFORS1011_SUZE);
//        msSql.insertionLoop_template();
//        msSql.closeConnection();
//        //
//        msSql = null;
//        msSql = new Common.DBservice.MsSql( connUrl_ITBZ_ExpressLie);
//        msSql.insertionLoop_template();
//        msSql.closeConnection();        
//        //
    }// main
    
    
}// end class TestConsole

        


//
///*  ------------------------------- cantina ------------------------------------------
////        //




  /*  
    public static void mssqlserver_conn()
    {
		// for named-instances the syntax seems to be "jdbc:sqlserver://vvv;instanceName=iii"
		// where vvv is the hostname (xor IP) and instanceName is the instance name. NB. the separator is a semicolon ';' and there's an'=' sign
		// between the token instanceName and the actual instance-name.
        //Update the username and password below
        // String connectionUrl = "jdbc:sqlserver://ITBZOW1422;instanceName=SqlExpress:1433;databaseName=dotazioni2021;user=sa;password=M1 Sxpdx";
        // String connectionUrl = "jdbc:sqlserver://ITBZOW1422;instanceName=SqlExpress;databaseName=dotazioni2021;user=sa;password=M1 Sxpdx";
        // String connectionUrl   = "jdbc:sqlserver://Cantor;databaseName=PrimeData;user=sa;password=Riemann0"; TODO Cantor
        //String connectionUrl   = "jdbc:sqlserver://Kronecker;instanceName=Delta;databaseName=PrimeData;user=sa;password=Riemann0";
        // String connectionUrl = "jdbc:sqlserver://ITBZOW1422;instanceName=SqlExpress:1433;databaseName=dotazioni2021;user=sa;password=M1 Sxpdx";
        //String connectionUrl = "jdbc:sqlserver://ITBZOW1422;instanceName=SqlExpress:1434;databaseName=dotazioni2021;user=sa;password=M1 Sxpdx";        
        //String connectionUrl = "jdbc:sqlserver://ITBZOW1422;instanceName=SqlExpress;databaseName=dotazioni2021;user=sa;password=M1 Sxpdx";
        //String connectionUrl = "jdbc:sqlserver://192.168.30.63;instanceName=SqlExpress:1434;databaseName=dotazioni2021;user=sa;password=M1 Sxpdx";
        //String connectionUrl = "jdbc:sqlserver://192.168.30.63;instanceName=ExpressLie:1434;databaseName=dotazioni2021;user=sa;password=M1 Sxpdx";
        //String connectionUrl = "jdbc:sqlserver://192.168.30.63;instanceName=ExpressLie:1434;databaseName=PrimeData;user=applicationuser;password=curricula";
        //String connectionUrl = "jdbc:sqlserver://192.168.30.63;instanceName=ExpressLie:1433;databaseName=PrimeData;user=applicationuser;password=curricula";
        //String connectionUrl = "jdbc:sqlserver://ITBZOW1422.BBT.INT;instanceName=ExpressLie;databaseName=PrimeData;user=applicationuser;password=curricula";
        String connectionUrl = "jdbc:sqlserver://Cantor;databaseName=PrimeData;user=sa;password=Riemann0";
        

        try
        {
            // Load SQL Server JDBC driver and establish connection.
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                System.out.println("Done.");
                connection.close();
                System.out.println("All done.");
            }
        }
        catch( Exception e)
        {
            System.out.println();
            e.printStackTrace();
        }
    }// 
*/    
        
        
//        try
//        {
//        Connection connection = null;
//        connection = // test failed
////            DriverManager.getConnection("jdbc:mysql://localhost:3306/cantiere?" +
////                                        "user=root&password=Riemann0");
//            DriverManager.getConnection("jdbc:mysql://localhost:3306/cantiere;user=root;password=Riemann0");
//        //---
//            // create a Statement from the connection
//            Statement statement = connection.createStatement();                
//            //-----
//            String sqlStatement;
//
//            double x = +3.0;
//            double Dx = 0.01;
//            for( ; x<+6.0; x+=Dx)
//            {
//                // call  `usp_cantiere_Dump2021Dez31_INSERT` ( 0.7 , sin(0.7) );
//                sqlStatement=" call  `usp_cantiere_Dump2021Dez31_INSERT` ( ";
//                sqlStatement += String.valueOf(x);
//                sqlStatement += " , ";// separation between parameters.
//                sqlStatement += String.valueOf( Math.sin(x) );
//                sqlStatement += " );";
//                // insert the data
//                statement.executeUpdate( sqlStatement);
//            }
//            connection.commit();// NB.  Cannot commit when autoCommit is enabled.         
//        }
//        catch( Exception e)
//        {
//            e.printStackTrace();
//            System.err.println(e.getClass().getName()+": "+e.getMessage());
//            System.exit(0);
//        }
//        
//        //Common.DBservice.MySql mySql = new Common.DBservice.MySql();
//        //mySql.insertionLoop_template();
//        //mySql.closeConnection();                
        

//    public static void mssqlserver_conn()
//    {
        // for named-instances the syntax seems to be "jdbc:sqlserver://vvv;instanceName=iii"
        // where vvv is the hostname (xor IP) and instanceName is the instance name. NB. the separator is a semicolon ';' and there's an'=' sign
        // between the token instanceName and the actual instance-name.
        //Update the username and password below
        // String connectionUrl = "jdbc:sqlserver://ITBZOW1422;instanceName=SqlExpress:1433;databaseName=dotazioni2021;user=sa;password=M1 Sxpdx";
        // String connectionUrl = "jdbc:sqlserver://ITBZOW1422;instanceName=SqlExpress;databaseName=dotazioni2021;user=sa;password=M1 Sxpdx";
        // String connectionUrl   = "jdbc:sqlserver://Cantor;databaseName=PrimeData;user=sa;password=Riemann0"; TODO Cantor
        //String connectionUrl   = "jdbc:sqlserver://Kronecker;instanceName=Delta;databaseName=PrimeData;user=sa;password=Riemann0";
        // String connectionUrl = "jdbc:sqlserver://ITBZOW1422;instanceName=SqlExpress:1433;databaseName=dotazioni2021;user=sa;password=M1 Sxpdx";
        //String connectionUrl = "jdbc:sqlserver://ITBZOW1422;instanceName=SqlExpress:1434;databaseName=dotazioni2021;user=sa;password=M1 Sxpdx";        
        //String connectionUrl = "jdbc:sqlserver://ITBZOW1422;instanceName=SqlExpress;databaseName=dotazioni2021;user=sa;password=M1 Sxpdx";
        //String connectionUrl = "jdbc:sqlserver://192.168.30.63;instanceName=SqlExpress:1434;databaseName=dotazioni2021;user=sa;password=M1 Sxpdx";
        //String connectionUrl = "jdbc:sqlserver://192.168.30.63;instanceName=ExpressLie:1434;databaseName=dotazioni2021;user=sa;password=M1 Sxpdx";
        //String connectionUrl = "jdbc:sqlserver://192.168.30.63;instanceName=ExpressLie:1434;databaseName=PrimeData;user=applicationuser;password=curricula";
        //String connectionUrl = "jdbc:sqlserver://192.168.30.63;instanceName=ExpressLie:1433;databaseName=PrimeData;user=applicationuser;password=curricula";
        //String connectionUrl = "jdbc:sqlserver://ITBZOW1422.BBT.INT;instanceName=ExpressLie;databaseName=PrimeData;user=applicationuser;password=curricula";
        // String connectionUrl = "jdbc:sqlserver://Cantor;databaseName=PrimeData;user=sa;password=Riemann0";
        //String connectionUrl_Eulero = "jdbc:sqlserver://Eulero;databaseName=TestDb;user=sa;password=Riemann0";
        //"jdbc:microsoft:sqlserver://Cantor:1433;DatabaseName=PrimeData", "sa", "sa");
        
//        Connection connection=null;
//        try
//        {
//		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		connection = DriverManager.getConnection(connectionUrl_Eulero);
//                //---
//                // create a Statement from the connection
//                Statement statement = connection.createStatement();                
//                //-----
//                String sqlStatement;
//                
//                double x = 0.0;
//                double Dx = 0.01;
//                for( ; x<+3.0; x+=Dx)
//                {
//                    sqlStatement="exec usp_NumDump2021_INSERT  ";
//                    sqlStatement += String.valueOf(x);
//                    sqlStatement += " , ";// separation between parameters.
//                    sqlStatement += String.valueOf( Math.sin(x) );
//                    // insert the data
//                    statement.executeUpdate( sqlStatement);
//                }
//                connection.commit();// NB.  Cannot commit when autoCommit is enabled.
//        }
//        catch( Exception e)
//        {
//            e.printStackTrace();
//            System.err.println(e.getClass().getName()+": "+e.getMessage());
//            System.exit(0);
//        }
//        System.out.println(" Connection to database opened successfully"); 
//        try
//        {
//            if(null!=connection)
//            {
//                if( connection.isValid(0))
//                {
//                    connection.close();
//                }
//            }
//        }
//        catch( Exception e)
//        {
//            e.printStackTrace();
//            System.err.println(e.getClass().getName()+": "+e.getMessage());
//            System.exit(0);
//        }        
//        System.out.println(" Connection to database closed successfully");
//    }// end mssqlserver_conn
//
    
    
// 
//    // first connection to Jdbc::postgreSQL
//    // the binary is in TestConsole::Libraries::
//    public static void postgreSQLconn()
//    {        
//        Connection c = null;
//        try
//        {
//            Class.forName("org.postgresql.Driver");
//            //c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mendola", "sa", "sa");
//            //c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/numerics", "postgres", "Riemann0");
//            c = DriverManager.getConnection("jdbc:postgresql://Eulero:5432/numerics", "postgres", "Riemann0");
//        }
//        catch( Exception e)
//        {
//            e.printStackTrace();
//            System.err.println(e.getClass().getName()+": "+e.getMessage());
//            System.exit(0);
//        }
//        System.out.println(" Connection to database opened successfully"); 
//        try
//        {
//            // c.commit();  Cannot commit when autoCommit is enabled.
//            c.close();
//        }
//        catch( Exception e)
//        {
//            e.printStackTrace();
//            System.err.println(e.getClass().getName()+": "+e.getMessage());
//            System.exit(0);
//        }        
//        System.out.println(" Connection to database closed successfully");
//    }// public static void postgreSQLconn()
//        
        
//        for(int c=0; c<50; c++)
//        {            
//            System.out.println( Common.MonteCarlo.MonteCarloGenerator.nextInteger(5, 16) );
//        }
//        
//        
//        java.util.Hashtable< String, java.util.Stack<String> > threadLoggingStack =
//            new java.util.Hashtable< String, java.util.Stack<String> >();
//        
//        for(int c=0; c<50; c++)
//        {
//            ThreadForker theForker = new ThreadForker();
//            String threadName = Common.MonteCarlo.MonteCarloGenerator.UID();
//            Thread t = new Thread( theForker, threadName );            
//            threadLoggingStack.putIfAbsent( threadName, new java.util.Stack<String>() );
//            //
//            t.start();// run asynchronously.
//            //
//            if( threadLoggingStack.containsKey( threadName) )
//            {
//                System.out.println("key representing thread named : "+threadName+" found.");
//                long cardThreadStack = 0;
//                cardThreadStack = Common.MonteCarlo.MonteCarloGenerator.nextInteger(1, 16);
//                for(int d=0; d<cardThreadStack; d++)
//                {
//                    threadLoggingStack.get( threadName).addElement("stack level "+d+" on "+ threadName);
//                }
//            }
//            else
//            {
//                System.out.println("key representing thread named : "+threadName+" NOT found.");
//                threadLoggingStack.putIfAbsent( threadName, new java.util.Stack<String>() );
//            }
//            
//        }// for 50 forks
//        
//        Set<String> theKeys = threadLoggingStack.keySet();
//        Object[] theKeysArray = theKeys.toArray();
//        for( int c=0; c<theKeysArray.length; c++)
//        {
//            System.out.println( (String)(theKeysArray[c]) );
//            int cardCurThreadStack = threadLoggingStack.get( (String)(theKeysArray[c]) ).size();
//            for( int d=0; d<cardCurThreadStack; d++)
//            {
//                System.out.println( threadLoggingStack.get( (String)(theKeysArray[c]) ).get(d) );
//            }// for cardCurThreadStack
//            System.out.println( );
//        }// for each thread.
        
        //
        // done
////        Common.ConfigurationService.scalarConfig configReader = new Common.ConfigurationService.scalarConfig("./configSample.txt");
////        configReader.getTokensFromConfigStream();
//        
////        String curTok = "init to something not empty and not null.";
////        for( int tokOrd=1 ; null!=curTok && !curTok.equals(""); tokOrd++)
////        {
////            curTok = configRader.getToken();
////            if( null==curTok || curTok.equals("") )// curTok.equals("") means EOF.
////            {
////                break;
////            }// else continue.
////            System.out.println("token ordinal "+Integer.toString(tokOrd)+" = "+curTok);
////            System.out.println("tokens read until now "+ configRader.get_tokensReadUntilNow());
////            System.out.println("characters Read In Last Token (comprehensive of separators) "+ configRader.get_charactersInTokenWithSeparators() );
////            System.out.println("characters Read In Last Token (NO separators) "+ configRader.get_charactersInTokenNoSeparators() );
////            System.out.println("separators before "+ configRader.get_separatorsBefore() );
////            System.out.println("separators after "+ configRader.get_separatorsAfter() );
////            System.out.println();
////        }// for
////        configRader.close();// remember to close() the Stream.
//		        
//        
//        
//        
////        //Properties prop = System.getProperties();
////        System.getProperties();
////        //
////        String Jhome = System.getProperty( "java.home");
////        System.out.println(Jhome);        
////        //        
////        String Jversion = System.getProperty( "java.version");
////        System.out.println(Jversion);
////        //
////        String Jvendor = System.getProperty( "java.vendor");
////        System.out.println(Jvendor);
////        //        
////        String JvendorURL = System.getProperty( "java.vendor.url");
////        System.out.println(JvendorURL);
////        //        
////        String JvmSpecVersion = System.getProperty( "java.vm.specification.version");
////        System.out.println(JvmSpecVersion);
////        //        
////        String JvmSpecVendor = System.getProperty( "java.vm.specification.vendor");
////        System.out.println(JvmSpecVendor);
////        //        
////        String JvmSpecName = System.getProperty( "java.vm.specification.name");
////        System.out.println(JvmSpecName);        
////        //
////        String JvmVersion = System.getProperty( "java.vm.version");
////        System.out.println(JvmVersion);
////        //        
////        String JvmVendor = System.getProperty( "java.vm.vendor");
////        System.out.println(JvmVendor);
////        //        
////        String JvmName = System.getProperty( "java.vm.name");
////        System.out.println(JvmName);        
////        //        
////        String JSpecVendor = System.getProperty( "java.specification.vendor");
////        System.out.println(JSpecVendor);
////        //        
////        String JSpecName = System.getProperty( "java.specification.name");
////        System.out.println(JSpecName);        
////        //
////        String JVersion = System.getProperty( "java.version");
////        System.out.println(JVersion);
////        //                
////        String osName = System.getProperty( "os.name");
////        System.out.println(osName);
////        //
////        java.util.Hashtable<String, String> x = new java.util.Hashtable<String, String>();
////        x.put("key_1", "val_1");
////        x.put("key_2", "val_2");
////        x.put("key_3", "val_3");
////        //--
////        int sz = x.size();
////        Enumeration k = x.keys();
////        //
//                
//        
//       
//		
//		
//        // int primoOperando = 56;
//        // int secondoOperando = 3;
//        // int result = primoOperando^secondoOperando;// bitwise XOR operator.
//        // int back = result^secondoOperando;// ont the second step, we're back where we started.
//        // //
//        // Common.EncryptStore.XorSimple xorSimpleInstance = new Common.EncryptStore.XorSimple();
//        // int res = xorSimpleInstance.getEncryptedIntByXorSimple( 4);
//        // //
//        // Common.DBservice.JDbService dbManager = new Common.DBservice.JDbService();
//        // dbManager.dbConnectorTemplate();
//        //
////        Common.ConfigurationService CommonCall = new Common.ConfigurationService();
////        int i = 93 + CommonCall.fromLibrary();
////        String fromCommon = "fromCommon:" + Integer.toString( i );
////        fromCommon += returnLayerSeparator();
////        //
////        Entity.SomeEntity EntityCall = new Entity.SomeEntity();
////        fromCommon += EntityCall.getEntityName();
////        fromCommon += returnLayerSeparator();
////        //
////        ProcessOperatingInterface.SomeProcessOperatingInterfaceClass process = new ProcessOperatingInterface.SomeProcessOperatingInterfaceClass();
////        fromCommon += process.someProcessMethod();
////        fromCommon += returnLayerSeparator();
////        fromCommon += "The fardest caller is me: testconsole::main() ";
////        //
////        Common.Calendar.CalendarService cs = new Common.Calendar.CalendarService();
////        String tm = cs.getCurrentTimeStamp();
////        System.out.println( tm );
////        
////        Common.FileSys.FileManipulation fm = new Common.FileSys.FileManipulation();
////        fm.txtFileWriter("./esempio.txt");
////        fm.txtFileReader("./esempio.txt");
//*/
