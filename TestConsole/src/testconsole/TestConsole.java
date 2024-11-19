
package testconsole;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;




public class TestConsole
{

    

    /******************* EntryPoint ****************************/
    public static void main(String[] args) throws IOException 
    {
        java.util.ArrayList<Entity.Proxy.PrimedataRiga> resultset = null;
        java.util.ArrayList<Entity.Proxy.PrimedataRiga> lastRecord = null;
        try 
        {
            resultset = 
                    Entity.Proxy.usp_PrimeData_LOAD_MULTI_Postgres_Frechet.usp_PrimeData_LOAD_MULTI_Postgres_Frechet_SERVICE_(5, 8);
            lastRecord = 
                    Entity.Proxy.usp_PrimeData_LOAD_atMaxOrdinal_Postgres_Frechet.usp_PrimeData_LOAD_atMaxOrdinal_Postgres_Frechet_SERVICE_();

        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(TestConsole.class.getName()).log(Level.SEVERE, null, ex);
        }
        //
        for(int c=0; c<resultset.size(); c++)
        {
            // resultset.get(c) eccess ArrayList element
            System.out.println( 
                    ((Entity.Proxy.PrimedataRiga)(resultset.get(c))).getOrdinal() +"__"+
                    ((Entity.Proxy.PrimedataRiga)(resultset.get(c))).getPrime()             );
        }
        System.out.println( "Last Record : " +
                ((Entity.Proxy.PrimedataRiga)(lastRecord.get(0))).getOrdinal() +"__"+
                ((Entity.Proxy.PrimedataRiga)(lastRecord.get(0))).getPrime()             );
        
        //----- Process::
        Entity.Proxy.PrimedataRiga processLastRecord = 
                ProcessOperatingInterface.postgres_Frechet_LoadAtMaxOrdinal.postgres_Frechet_LoadAtMaxOrdinal_SERVICE_();
        System.out.println( "Process:: Last Record : " +
                processLastRecord.getOrdinal() +"__"+
                processLastRecord.getPrime()             );        
        //---process
        java.util.ArrayList<Entity.Proxy.PrimedataRiga> oneRow =  
                ProcessOperatingInterface.postgres_Frechet_primedata_LOAD_MULTI_.postgres_Frechet_primedata_LOAD_MULTI_SERVICE_(5,5);
        java.util.ArrayList<Entity.Proxy.PrimedataRiga> multiRow =  
                ProcessOperatingInterface.postgres_Frechet_primedata_LOAD_MULTI_.postgres_Frechet_primedata_LOAD_MULTI_SERVICE_(5,15);
        //
        for(int c=0; c<multiRow.size(); c++)
        {
            // resultset.get(c) eccess ArrayList element
            System.out.println( 
                    ((Entity.Proxy.PrimedataRiga)(multiRow.get(c))).getOrdinal() +"__"+
                    ((Entity.Proxy.PrimedataRiga)(multiRow.get(c))).getPrime()             );
        }        
        //
        for(int c=0; c<oneRow.size(); c++)
        {
            // resultset.get(c) eccess ArrayList element
            System.out.println( 
                    ((Entity.Proxy.PrimedataRiga)(oneRow.get(c))).getOrdinal() +"__"+
                    ((Entity.Proxy.PrimedataRiga)(oneRow.get(c))).getPrime()             );
        }           
    }// main

            
    
    
}// end class TestConsole

        


//
///*  ------------------------------- cantina ------------------------------------------
////
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
//        //
//        // done        
//        
//        
        //----
//        Common.DBservice.PostgreSql postgSql = new Common.DBservice.PostgreSql();
////        for( double c=+1.0; c<10; c+= +0.1)
//        for( long P=1; P<10; P++)
//        {
//            Entity.Proxy.PostgreSql_usp_PrimeData_INSERT_.usp_PrimeData_INSERT_(postgSql.connection, P);
////            Entity.Table.SomeEntity.usp_Numerics_ZetaDump(postgSql.connection,
////                    c,
////                    c+1,
////                    c+2,
////                    c+3,
////                    c+4,
////                    c+5 
////            );
//        }// for
//        //postgSql.insertionLoop_template();
//        postgSql.closeConnection();
//    
//    public static void rubrica_Parser(String[] args) throws IOException 
//    { 
//        File dir;
//        dir = new File(System.getProperty("user.dir"));
//        String absolutePath = dir.getAbsolutePath();
//        System.out.println("\n\t The present working dir (pwd) is "+ absolutePath);
//    
//        Common.Dictionary.MapOperation dictionary = new Common.Dictionary.MapOperation();
//        String fullpath = "data/telExport_Excel_TAB_.txt";
//        ArrayList<String[]> tokenizedFile =
//            dictionary.txtStringMatrix(fullpath);
//        //dictionary.traverseDirect();
//        dictionary.mapListener();
//        dictionary.NodeGarbageCollection();
//        dictionary = null;// gc
//        //ready
//    }// rubrica_Parser
//    

        //--test file tokenization
//        for( int row=0; row<tokenizedFile.size(); row++)
//        {
//            for( int column=0; column<tokenizedFile.get(row).length; column++)
//            {            
//                System.out.println( tokenizedFile.get(row)[column]);
//            }
//        }
        // NB. technique to acquire a string from Console.
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.print("Enter String: ");
//        String acquiredString = bufferedReader.readLine();
//        System.out.print("Enter Integer:");
//        int acquiredInteger = -1;
//        try 
//        {            
//            acquiredInteger = Integer.parseInt(bufferedReader.readLine());
//            // riscontro feedback
//            System.out.println("acquiredString = "+acquiredString );
//            System.out.println("acquiredInteger = "+acquiredInteger );
//        } 
//        catch(NumberFormatException nfe) 
//        {
//            System.err.println("Invalid Format!");
//        }
//            
//    
        //-----listener prototype-------------
//        System.out.print("Enter something:  ");
//        java.lang.System.console debuggingConsole = new java.lang.System.console();
//        String listenerCaughtString = debuggingConsole.readLine();
//        System.out.println( listenerCaughtString);
        //-------listener prototype-----------

//        ProcessOperatingInterface.FromExcelToDB.fromTABseparatedTxtDumpTo_PostgreSql(
//                "data/reportAuto_tryNULL_.txt",
//                "tryNULL"
//        );
//        
//        ProcessOperatingInterface.FromExcelToDB.fromTABseparatedTxtDumpTo_MsSql(
//                "data/reportAuto_tryNULL_.txt",
//                "tryNULL"
//        );

//public static void similADO()
//{
//ProcedureCall procedure = getSession().createStoredProcedureCall("my_procedure");

//procedure.registerParameter("my_nullable_param", String.class, ParameterMode.IN) .bindValue(null);    
//StoredProcedureQuery q = em.createStoredProcedureQuery(Globals.SPROC_PROBLEM_COMMENT2, ProblemCommentVO.class);
//q.registerStoredProcedureParameter("Patient_ID", Long.class, ParameterMode.IN);
//q.registerStoredProcedureParameter("Param2", Long.class, ParameterMode.IN);
//q.registerStoredProcedureParameter("Param3", Long.class, ParameterMode.IN);
//q.registerStoredProcedureParameter("Param4", Integer.class, ParameterMode.OUT);
//q.setParameter("Patient_ID", patientId);
//q.setParameter("Param2", null);//passing null value to Param2
//q.setParameter("Param3", null);
//
//List<ProblemCommentVO> pComments = q.getResultList();
//Integer a = (Integer) q.getOutputParameterValue("Param4");    
    //---
//StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("get_item", Item.class);
//storedProcedure.registerStoredProcedureParameter(0, String.class, ParameterMode.IN);
//storedProcedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
//storedProcedure.registerStoredProcedureParameter(2, Timestamp.class, ParameterMode.IN);
//
//storedProcedure.setParameter(0, a);
//storedProcedure.setParameter(1, b);
//storedProcedure.setParameter(2, c);
//
//storedProcedure.execute();    


////--@
//         StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("sales_tax");
//// set parameters
//storedProcedure.registerStoredProcedureParameter("subtotal", Double.class, ParameterMode.IN);
//storedProcedure.registerStoredProcedureParameter("tax", Double.class, ParameterMode.OUT);
//storedProcedure.setParameter("subtotal", 1f);
//// execute SP
//storedProcedure.execute();
//// get result
//Double tax = (Double)storedProcedure.getOutputParameterValue("tax");
//}
//    
// 
//
//  public static void someFunc(String a[])throws Exception {
//  Class.forName("com.mysql.jdbc.Driver").newInstance();
//  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
//  CallableStatement calstat=conn.prepareCall("{call empproc(?,?,?)}");
//  calstat.setString(1,a[0]);
//  calstat.setString(2,a[1]);
//  calstat.setString(3,a[2]);
//  ResultSet rs = calstat.executeQuery();
//  conn.close();
//  calstat.close();
//  System.out.println("Your data has been inserted into table.");
//  }// someFunc
//    

////        //
//        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        String exmplDate = "28/02/2022";
//        LocalDate res = LocalDate.parse( exmplDate, formatter);  // test
                
//        Common.DBservice.PostgreSql postgSql = new Common.DBservice.PostgreSql();
//        Entity.Proxy.Pg_usp_ge135zj_insert.Pg_usp_ge135zj_insert_SERVICE(
//                postgSql.connection,// the db- connection
//                //
//                LocalDate.now(),
//                (float)3612,//km
//                "ENI Vipiteno",// par_rifornimento_luogo,
//                (float)31.4,// litri gasolio
//                (float)1.654,// gasolio euro/litro
//                (float)45,// euro spesa carburante
//                "par_accessori_descr",// "par_accessori_descr"
//                (float)0,// accessori_costo
//                "par_lavaggio_descr",//"par_lavaggio_descr"
//                (float)0,// lavaggio costo
//                "par_manutenzione_descr",// "par_manutenzione_descr"
//                LocalDate.EPOCH, // par_data_ingresso_officina
//                LocalDate.ofYearDay(1999, 300), // par_data_uscita_officina
//                (float)0, // manutenzione_costo
//                "par_altro_descriz",// "par_altro_descriz"
//                (float)0,// par_altro_euro
//                "par_sinistro_descriz",// "par_sinistro_descriz"
//                "par_conducente",//"par_conducente"
//                "par_descrizione_riga",//"par_descrizione_riga"
//                (float)0,// par_costo_totale_riga
//                (float)0 // par_franchigia_assicurazione
//        );
//        //postgSql.connection 3
        //
//        ArrayList<String[]> associated_array = null;// this is the original second member in the data structure.

//        associated_array = fm.txtStringMatrix( "./esempio_matB_.txt");
//        //
//        for(int row=0; row<associated_array.size(); row++)
//        {
//            for(int col=0; col<associated_array.get(row).length ; col++)
//            {
//                System.out.print(associated_array.get(row)[col]);
//                System.out.print(" ");
//            }
//            System.out.println("\n\tEOL\n");
//        }
//        //
//        Common.FileSys.FileManipulation fm = new Common.FileSys.FileManipulation();        
//        ArrayList<ArrayList<String>> res = fm.laboratory( "./esempio_matC_.txt");
//        for( int row=0; row<res.size(); row++)
//        {
//            for( int col=0; col<res.get(row).size(); col++)
//            {
//                System.out.print( res.get(row).get(col) );
//                System.out.print(" ");// space between columns
//            }
//            System.out.println("\n\tEOL\n");
//        }// end print matrix WITH empty entries
//        //
//        ArrayList<ArrayList<String>> afterPruneEmptyEntries = fm.RemoveEmptyEntries(res);
//        //
//        for( int row=0; row<afterPruneEmptyEntries.size(); row++)
//        {
//            for( int col=0; col<afterPruneEmptyEntries.get(row).size(); col++)
//            {
//                System.out.print( afterPruneEmptyEntries.get(row).get(col) );
//                System.out.print(" ");// space between columns
//            }
//            System.out.println("\n\tEOL\n");
//        }// end print matrix WITH empty entries
//        //        
//        int x=0;
//        Common.FileSys.FileManipulation fm = new Common.FileSys.FileManipulation();
//        fm.Prototype_txtFileReader("./esempio.txt");        
//        NumericalAnalysis.ComplexField.Complex z = new Complex( +3.0 , +2.0);
//        for( double immPart=0.0; immPart<+6.0; immPart+=0.1)
//        {
//            Complex other = new Complex( +3.0, immPart);
//            System.out.println(" performing: "+z.ToString()+" / "+ other.ToString()+" = "+ 
//                    Complex.operator_div(z, other).ToString() );
//        }// for
//        Complex.Argument arg = z.argument();
        
//        Complex cosZ =
//            NumericalAnalysis.ComplexField.Functions.Cos( new Complex(+3.1,+1.5));
        
//        Common.DBservice.PostgreSql postgSql = new Common.DBservice.PostgreSql();
//        for( double c=+1.0; c<10; c+= +0.1)
//        {
//            Entity.SomeEntity.usp_Numerics_ZetaDump(postgSql.connection,
//                    c,
//                    c+1,
//                    c+2,
//                    c+3,
//                    c+4,
//                    c+5 
//            );
//        }
//        //postgSql.insertionLoop_template();
//        postgSql.closeConnection();        
                
//        String connUrl_ITBZ_Delta = "jdbc:sqlserver://ITBZOW1422;instanceName=Delta;databaseName=Numerics;user=applicationuser;password=curricula";
//        String connUrl_ITBZ_ExpressLie = "jdbc:sqlserver://ITBZOW1422;instanceName=ExpressLie;databaseName=Numerics;user=applicationuser;password=curricula";        
//        String connUrl_ITFORS1011_SUZE = "jdbc:sqlserver://ITFORS1011;instanceName=SUZE;databaseName=dotazioni2021;user=applicationuser;password=curricula";
//        Common.DBservice.MsSql msSql = new Common.DBservice.MsSql( connUrl_ITBZ_Delta);
//        for( double c=+1.0; c<10; c+= +0.1)
//        {
//            Entity.Proxy.MsSqlServer_ZetaDump.usp_Numerics_ZetaDump( msSql.connection,
//                    c,
//                    c+1,
//                    c+2,
//                    c+3,
//                    c+4,
//                    c+5 
//            );
//        }
//        msSql.insertionLoop_template();
//        msSql.closeConnection();
//        //
//        msSql = null;
//        msSql = new Common.DBservice.MsSql( connUrl_ITBZ_ExpressLie);
//        msSql.insertionLoop_template();
//        msSql.closeConnection();        
//        //



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
        //String connectionUrl   = "jdbc:sqlserver://Cantor;databaseName=PrimeData;user=sa;password=Riemann0";
        //String connectionUrl   = "jdbc:sqlserver://Kronecker;instanceName=SqlExpress:1433;databaseName=cv_db;user=sa;password=Riemann0";
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
