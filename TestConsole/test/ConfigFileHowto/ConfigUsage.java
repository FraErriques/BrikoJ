
package ConfigFileHowto;


/**
 *
 * @author fra
 * a unit-test package, devoted to inform about the capabilities of the Common.ConfigurationService package.
 */
public class ConfigUsage {
    
    public void howto()
    {
        Common.ConfigurationService.scalarConfig configReader = new Common.ConfigurationService.scalarConfig("./configSample.txt");
        configReader.getTokensFromConfigStream();
//        //

        // vc as in 
        Common.ConfigurationService.vectorialConfig vcReader = new Common.ConfigurationService.vectorialConfig("./configSample.txt");
        
        // vcReader.
       
	


        
    }
    
}


/*
        Common.ConfigurationService CommonCall = new Common.ConfigurationService();
        int i = 93 + CommonCall.fromLibrary();
        String fromCommon = "fromCommon:" + Integer.toString( i );
        fromCommon += returnLayerSeparator();
        //
        Entity.SomeEntity EntityCall = new Entity.SomeEntity();
        fromCommon += EntityCall.getEntityName();
        fromCommon += returnLayerSeparator();
        //
        ProcessOperatingInterface.SomeProcessOperatingInterfaceClass process = new ProcessOperatingInterface.SomeProcessOperatingInterfaceClass();
        fromCommon += process.someProcessMethod();
        fromCommon += returnLayerSeparator();
        fromCommon += "The fardest caller is me: testconsole::main() ";
        //
        Common.Calendar.CalendarService cs = new Common.Calendar.CalendarService();
        String tm = cs.getCurrentTimeStamp();
        System.out.println( tm );
        
        Common.FileSys.FileManipulation fm = new Common.FileSys.FileManipulation();
        fm.txtFileWriter("./esempio.txt");
        fm.txtFileReader("./esempio.txt");


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

        
//        String curTok = "init to something not empty and not null.";
//        for( int tokOrd=1 ; null!=curTok && !curTok.equals(""); tokOrd++)
//        {
//            curTok = configReader.getToken();
//            if( null==curTok || curTok.equals("") )// curTok.equals("") means EOF.
//            {
//                break;
//            }// else continue.
//            System.out.println("token ordinal "+Integer.toString(tokOrd)+" = "+curTok);
//            System.out.println("tokens read until now "+ configReader.get_tokensReadUntilNow());
//            System.out.println("characters Read In Last Token (comprehensive of separators) "+ configReader.get_charactersInTokenWithSeparators() );
//            System.out.println("characters Read In Last Token (NO separators) "+ configReader.get_charactersInTokenNoSeparators() );
//            System.out.println("separators before "+ configReader.get_separatorsBefore() );
//            System.out.println("separators after "+ configReader.get_separatorsAfter() );
//            System.out.println();
//        }// for
//        configReader.close();// remember to close() the Stream.
////		        
////        
////        
//////        
//        //
//        java.util.Hashtable<String, String> x = new java.util.Hashtable<String, String>();
//        x.put("key_1", "val_1");
//        x.put("key_2", "val_2");
//        x.put("key_3", "val_3");
//        //--
//        int sz = x.size();
//        Enumeration k = x.keys();


*/
