
package ProcessOperatingInterface;

import java.util.ArrayList;

/**
 *
 * @author itfraerr
 */
public class FromExcelToDB 
{

    public static boolean ReportAuto_fromTABseparatedTxtDumpTo_MsSql_SERVICE(
            String textDumpFullpath,
            String targaAutovettura
    )
    {
        boolean res = false;
        // String connUrl_ITBZ_Delta = "jdbc:sqlserver://ITBZOW1422;instanceName=Delta;databaseName=Numerics;user=applicationuser;password=curricula";
        // String connUrl_ITBZ_ExpressLie = "jdbc:sqlserver://ITBZOW1422;instanceName=ExpressLie;databaseName=Numerics;user=applicationuser;password=curricula";
        // DB connection. Close it after bulk insertion loop.        
        String connUrl_ITFORS1011_SUZE = "jdbc:sqlserver://ITFORS1011;instanceName=SUZE;databaseName=dotazioni2022;user=applicationuser;password=curricula";
        Common.DBservice.MsSql msSql = new Common.DBservice.MsSql( connUrl_ITFORS1011_SUZE);
        //----follows the sequence to be used:
        Common.FileSys.FileManipulation fm = new Common.FileSys.FileManipulation();
        ArrayList<ArrayList<String>> stringMatrix = fm.laboratory(textDumpFullpath);
        // ReportAuto has strategical empty-entries -> NO : ArrayList<ArrayList<String>> afterPruneEmptyEntries = fm.RemoveEmptyEntries( stringMatrix);
        ArrayList<ArrayList<String>> afterPruneEmptyEntries = stringMatrix;// invariata.
        // Segue:  un ciclo for per righe, istanziando una classe per ogni riga di ArrayList<ArrayList<String>> 
        // e quindi chiamando il Proxy una volta per ogni riga della db-table.
        //--@@@@@
        Entity.Table.ReportAuto reportAutoRiga = null;
        for( int row=0; row<afterPruneEmptyEntries.size(); row++)
        {
            // generic row( with all its columns) id afterPruneEmptyEntries.get(row)
            ArrayList<String> curRow = afterPruneEmptyEntries.get(row);
            if( curRow.size()<21 )
            {
                continue;// skip inadequate row.
            }// else treat it.
            //
            reportAutoRiga = new Entity.Table.ReportAuto(
                // id IDENTITY
                targaAutovettura, // NB. la tabella e' multivettura.
                curRow.get(0),  // registrationDate
                curRow.get(1), // km
                curRow.get(2),  // rifornimento_luogo
                curRow.get(3), // rifornimento_litri
                curRow.get(4),  // costo_gasolio_euro_litro
                curRow.get(5),  // spesa_gasolio_euro 
                curRow.get(6),  // accessori_descriz
                curRow.get(7),  // accessori_euro
                curRow.get(8),  // lavaggio_descr 
                curRow.get(9),  // lavaggio_euro 
                curRow.get(10), // manutenzione_descr 
                curRow.get(11), // data_ingresso_officina 
                curRow.get(12), // data_uscita_officina 
                curRow.get(13), // manutenzione_euro 
                curRow.get(14), // altro_descriz 
                curRow.get(15), // altro_euro 
                curRow.get(16), // sinistro_descriz 
                curRow.get(17), // conducente 
                curRow.get(18), // riga_descriz 
                curRow.get(19), // costo_totale_riga_euro 
                curRow.get(20)  // franchigia_assicurazione_euro
            );
            // Proxy  for each row:
            reportAutoRiga.MsSql_ProxyWrapper_( msSql);
        }// end forEach row: all rows in the String-Matrix have been sent to DB.
        // only after last row: close the DB connection.
        msSql.closeConnection();
        // ready.
        return res;
    }// fromTABseparatedTxtDumpTo_MsSql
    
    

    public static boolean ReportAuto_fromTABseparatedTxtDumpTo_PostgreSql_SERVICE(
            String textDumpFullpath,
            String targaAutovettura
    ) throws Exception
    {
        boolean res = false;
        //connection string set on ITBZOW1422::PostgreSql::Numerics. Hard coded, by now.
        Common.DBservice.connectionProvider_postgreSql_ITFORS1011 postgreSql = new Common.DBservice.connectionProvider_postgreSql_ITFORS1011();
        //----follows the sequence to be used:
        Common.FileSys.FileManipulation fm = new Common.FileSys.FileManipulation();
        ArrayList<ArrayList<String>> stringMatrix = fm.laboratory(textDumpFullpath);
        // ReportAuto has strategical empty-entries -> NO : ArrayList<ArrayList<String>> afterPruneEmptyEntries = fm.RemoveEmptyEntries( stringMatrix);
        ArrayList<ArrayList<String>> afterPruneEmptyEntries = stringMatrix;// invariata.
        // Segue:  un ciclo for per righe, istanziando una classe per ogni riga di ArrayList<ArrayList<String>> 
        // e quindi chiamando il Proxy una volta per ogni riga della db-table.
        //--@@@@@
        Entity.Table.ReportAuto reportAutoRiga = null;
        for( int row=0; row<afterPruneEmptyEntries.size(); row++)
        {
            // generic row( with all its columns) id afterPruneEmptyEntries.get(row)
            ArrayList<String> curRow = afterPruneEmptyEntries.get(row);
            if( curRow.size()<21 )
            {
                continue;// skip inadequate row.
            }// else treat it.
            //
            reportAutoRiga = new Entity.Table.ReportAuto(
                // id IDENTITY
                targaAutovettura, // NB. la tabella e' multivettura.
                curRow.get(0),  // registrationDate
                curRow.get(1), // km
                curRow.get(2),  // rifornimento_luogo
                curRow.get(3), // rifornimento_litri
                curRow.get(4),  // costo_gasolio_euro_litro
                curRow.get(5),  // spesa_gasolio_euro 
                curRow.get(6),  // accessori_descriz
                curRow.get(7),  // accessori_euro
                curRow.get(8),  // lavaggio_descr 
                curRow.get(9),  // lavaggio_euro 
                curRow.get(10), // manutenzione_descr 
                curRow.get(11), // data_ingresso_officina 
                curRow.get(12), // data_uscita_officina 
                curRow.get(13), // manutenzione_euro 
                curRow.get(14), // altro_descriz 
                curRow.get(15), // altro_euro 
                curRow.get(16), // sinistro_descriz 
                curRow.get(17), // conducente 
                curRow.get(18), // riga_descriz 
                curRow.get(19), // costo_totale_riga_euro 
                curRow.get(20)  // franchigia_assicurazione_euro
            );
            // Proxy  for each row:
            reportAutoRiga.Postgres_ProxyWrapper_( postgreSql);// the DB-object which contains the connection.
        }// end forEach row: all rows in the String-Matrix have been sent to DB.
        // only after last row: close the DB connection.
        postgreSql.closeConnection();
        // ready.
        return res;
    }// fromTABseparatedTxtDumpTo_PostgreSql    
    
    public static boolean ZetaDump_fromTABseparatedTxtDumpTo_PostgreSql_SERVICE(
            String textDumpFullpath
    )
    {
        boolean res = false;
        //connection string set on ITBZOW1422::PostgreSql::Numerics. Hard coded, by now.
        Common.DBservice.PostgreSql_ postgreSql = new Common.DBservice.PostgreSql_();//connection string set on ITBZOW1422::PostgreSql::Numerics. Hard coded, by now.
        //----follows the sequence to be used:
        Common.FileSys.FileManipulation fm = new Common.FileSys.FileManipulation();
        ArrayList<ArrayList<String>> stringMatrix = fm.laboratory(textDumpFullpath);
        // ReportAuto has strategical empty-entries -> NO : ArrayList<ArrayList<String>> afterPruneEmptyEntries = fm.RemoveEmptyEntries( stringMatrix);
        ArrayList<ArrayList<String>> afterPruneEmptyEntries = stringMatrix;// invariata.
        // Segue:  un ciclo for per righe, istanziando una classe per ogni riga di ArrayList<ArrayList<String>> 
        // e quindi chiamando il Proxy una volta per ogni riga della db-table.
        //--@@@@@
        Entity.Table.ZetaDump ZetaDump_Riga = null;
        for( int row=0; row<afterPruneEmptyEntries.size(); row++)
        {
            // generic row( with all its columns) id afterPruneEmptyEntries.get(row)
            ArrayList<String> curRow = afterPruneEmptyEntries.get(row);
            if( curRow.size()<6 )// todo
            {
                continue;// skip inadequate row.
            }// else treat it.
            //
            ZetaDump_Riga = new Entity.Table.ZetaDump(
                // id IDENTITY
                curRow.get(0), // s_re
                curRow.get(1), // s_im
                curRow.get(2), // z_re
                curRow.get(3), // z_im
                curRow.get(4), // image_re
                curRow.get(5)  // image_im
            );
            // Proxy  for each row:
            ZetaDump_Riga.Postgres_ProxyWrapper_( postgreSql);// the DB-object which contains the connection.
        }// end forEach row: all rows in the String-Matrix have been sent to DB.
        // only after last row: close the DB connection.
        postgreSql.closeConnection();
        // ready.
        return res;
    }// ZetaDump_fromTABseparatedTxtDumpTo_PostgreSql_SERVICE

} //  class FromExcelToDB 
