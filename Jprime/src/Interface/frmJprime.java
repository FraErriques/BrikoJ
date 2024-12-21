/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class frmJprime extends javax.swing.JFrame {
    //----data member--------
    private Thread t;// calculation thread for db-enrichment.
    // connection provider instances, to open and close the sticky connection, which is a local variable.
    private static Common.DBservice.connectionProvider_postgreSql_Frechet pgFrechet;
    private static Common.DBservice.connectionProvider_postgreSql_ITFORS1011 pgITFORS1011;
    private static java.sql.Connection stickyConnection = null;// for the calculation thread.
    public long theOrdinalLongLow = -1L;// init to invalid.
    public long theOrdinalLongHigh = -1L;


    
    /**
     * Creates new form frmJprime
     */
    public frmJprime() {
        initComponents();
        this.t = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtClipboard = new javax.swing.JTextArea();
        mnuStripTop = new javax.swing.JMenuBar();
        mnuTitle_FileSystem = new javax.swing.JMenu();
        mnuItem_exit = new javax.swing.JMenuItem();
        mnuTitle_Calculation = new javax.swing.JMenu();
        mnuStrip_DB_Frechet = new javax.swing.JMenu();
        mnu_Item_DB_Frechet_AvailableThresh = new javax.swing.JMenuItem();
        mnuItem_Frechet_ReadSingle = new javax.swing.JMenuItem();
        mnu_Item_DBfrechet_ReadRange = new javax.swing.JMenuItem();
        mnuItem_DBfrechet_enrich = new javax.swing.JMenuItem();
        mnuItem_DBfrechet_stopEnriching = new javax.swing.JMenuItem();
        mnuStrip_DB_ITFORS = new javax.swing.JMenu();
        mnu_DBITFORS_AvailThresh = new javax.swing.JMenuItem();
        mnuItem_ITFORS1011_ReadSingle = new javax.swing.JMenuItem();
        mnu_Item_DBITFORS_ReadRange = new javax.swing.JMenuItem();
        mnuItem_DBITFORS_enrich = new javax.swing.JMenuItem();
        mnuItem_DBITFORS_stopEnriching = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtClipboard.setColumns(20);
        txtClipboard.setRows(5);
        jScrollPane1.setViewportView(txtClipboard);

        mnuTitle_FileSystem.setText("FileSystem");

        mnuItem_exit.setText("Exit");
        mnuItem_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mnuItem_exitMouseReleased(evt);
            }
        });
        mnuTitle_FileSystem.add(mnuItem_exit);

        mnuStripTop.add(mnuTitle_FileSystem);

        mnuTitle_Calculation.setText("Calculation");
        mnuStripTop.add(mnuTitle_Calculation);

        mnuStrip_DB_Frechet.setText("- DB Frechet -");
        mnuStrip_DB_Frechet.setName(""); // NOI18N

        mnu_Item_DB_Frechet_AvailableThresh.setText("Available Threshold");
        mnu_Item_DB_Frechet_AvailableThresh.setToolTipText("");
        mnu_Item_DB_Frechet_AvailableThresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mnu_Item_DB_Frechet_AvailableThreshMouseReleased(evt);
            }
        });
        mnuStrip_DB_Frechet.add(mnu_Item_DB_Frechet_AvailableThresh);

        mnuItem_Frechet_ReadSingle.setText("Read Single");
        mnuItem_Frechet_ReadSingle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mnuItem_Frechet_ReadSingleMouseReleased(evt);
            }
        });
        mnuStrip_DB_Frechet.add(mnuItem_Frechet_ReadSingle);

        mnu_Item_DBfrechet_ReadRange.setText("Read Range");
        mnu_Item_DBfrechet_ReadRange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mnu_Item_DBfrechet_ReadRangeMouseReleased(evt);
            }
        });
        mnuStrip_DB_Frechet.add(mnu_Item_DBfrechet_ReadRange);

        mnuItem_DBfrechet_enrich.setText("Enrich DB");
        mnuItem_DBfrechet_enrich.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mnuItem_DBfrechet_enrichMouseReleased(evt);
            }
        });
        mnuStrip_DB_Frechet.add(mnuItem_DBfrechet_enrich);

        mnuItem_DBfrechet_stopEnriching.setText("stop enriching");
        mnuItem_DBfrechet_stopEnriching.setToolTipText("");
        mnuItem_DBfrechet_stopEnriching.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mnuItem_DBfrechet_stopEnrichingMouseReleased(evt);
            }
        });
        mnuStrip_DB_Frechet.add(mnuItem_DBfrechet_stopEnriching);

        mnuStripTop.add(mnuStrip_DB_Frechet);

        mnuStrip_DB_ITFORS.setText("- DB  BBT::ITFORS1011 -");
        mnuStrip_DB_ITFORS.setToolTipText("");

        mnu_DBITFORS_AvailThresh.setText("Available Threshold");
        mnu_DBITFORS_AvailThresh.setToolTipText("");
        mnu_DBITFORS_AvailThresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mnu_DBITFORS_AvailThreshMouseReleased(evt);
            }
        });
        mnuStrip_DB_ITFORS.add(mnu_DBITFORS_AvailThresh);

        mnuItem_ITFORS1011_ReadSingle.setText("Read Single");
        mnuItem_ITFORS1011_ReadSingle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mnuItem_ITFORS1011_ReadSingleMouseReleased(evt);
            }
        });
        mnuStrip_DB_ITFORS.add(mnuItem_ITFORS1011_ReadSingle);

        mnu_Item_DBITFORS_ReadRange.setText("Read Range");
        mnu_Item_DBITFORS_ReadRange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mnu_Item_DBITFORS_ReadRangeMouseReleased(evt);
            }
        });
        mnuStrip_DB_ITFORS.add(mnu_Item_DBITFORS_ReadRange);

        mnuItem_DBITFORS_enrich.setText("Enrich DB");
        mnuItem_DBITFORS_enrich.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mnuItem_DBITFORS_enrichMouseReleased(evt);
            }
        });
        mnuStrip_DB_ITFORS.add(mnuItem_DBITFORS_enrich);

        mnuItem_DBITFORS_stopEnriching.setText("stop enriching");
        mnuItem_DBITFORS_stopEnriching.setToolTipText("");
        mnuItem_DBITFORS_stopEnriching.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mnuItem_DBITFORS_stopEnrichingMouseReleased(evt);
            }
        });
        mnuStrip_DB_ITFORS.add(mnuItem_DBITFORS_stopEnriching);

        mnuStripTop.add(mnuStrip_DB_ITFORS);

        setJMenuBar(mnuStripTop);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuItem_exitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuItem_exitMouseReleased
        if(null!=this.pgFrechet)
        {
            this.pgFrechet.closeConnection();
            this.pgFrechet = null;       
        }
        if(null!=this.pgITFORS1011 )
        {
            this.pgITFORS1011.closeConnection();
            this.pgITFORS1011 = null;       
        }        
        System.exit(0);// normal exit
    }//GEN-LAST:event_mnuItem_exitMouseReleased



    private void mnuItem_DB_AvailableThresholdMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuItem_DB_AvailableThresholdMouseReleased

    }//GEN-LAST:event_mnuItem_DB_AvailableThresholdMouseReleased




    private void mnuItem_DB_AvailableThresholdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItem_DB_AvailableThresholdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuItem_DB_AvailableThresholdActionPerformed

    private void mnuItem_Frechet_ReadSingleMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuItem_Frechet_ReadSingleMouseReleased
            // case : Lower
            dlgOrdinalAcquirer dlgLow = null;
            try
            {
                Common.DBservice.connectionProvider_postgreSql_Frechet volatileconnFrechet = 
                        new Common.DBservice.connectionProvider_postgreSql_Frechet();
                java.sql.Connection connFrechet = volatileconnFrechet.getConnection();
                if(null==connFrechet || !connFrechet.isValid(0))
                {
                    throw new Exception("no valid db connection.\n");
                }
                dlgLow = new dlgOrdinalAcquirer(this,true,false);
                dlgLow.setTitle("supply the Ordinal for the LOWER Prime");
                dlgLow.setAlwaysOnTop(true);
                dlgLow.setVisible(true);
                //------------on re-entry-------thread join from modal form-------------
                dlgLow.dispose();//---gc------
                //---READ-SINGLE: i.e. Postgres_PrimeData_LOAD_MULTI_SERVICE_(theOrdinalLongLow,theOrdinalLongLow);---
                
                ArrayList<Entity.Proxy.PrimedataRiga> resultSet =
                        Entity.Proxy.Postgres_PrimeData_LOAD_MULTI_.Postgres_PrimeData_LOAD_MULTI_SERVICE_(
                                connFrechet
                                ,this.theOrdinalLongLow,  this.theOrdinalLongLow );
                if( resultSet.isEmpty() || 1!=resultSet.size())
                {
                    throw new Exception("\n\n the resultset is supposed to have cardinality==+1 in this case. \n");
                }
                //             
                System.out.println( "\n"+resultSet.get(0).getOrdinal() + "____"+resultSet.get(0).getPrime() );
                this.txtClipboard.append( "\n"+resultSet.get(0).getOrdinal() + "____"+resultSet.get(0).getPrime()+ "\n" );
            }
            catch (Exception ex)
            {
                this.txtClipboard.append( ex.getMessage()+"\n" );
                this.txtClipboard.append( " no valid db connection \n" );
                System.out.println(ex.getMessage() );
            }
            finally
            {
                dlgLow = null;//---gc------
            }
    }//GEN-LAST:event_mnuItem_Frechet_ReadSingleMouseReleased

    private void mnuItem_DBfrechet_enrichMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuItem_DBfrechet_enrichMouseReleased
        try 
        {
            if(null==this.pgFrechet || null==stickyConnection || !stickyConnection.isValid(0) ) 
            {
                try
                {
                    if(null==this.pgFrechet)
                    {
                        this.pgFrechet = new Common.DBservice.connectionProvider_postgreSql_Frechet();
                    }
                    if(null==stickyConnection || !stickyConnection.isValid(0))
                    {
                        stickyConnection = pgFrechet.getConnection();
                    }
                    if(null==stickyConnection || !stickyConnection.isValid(0))
                    {
                        throw new Exception("no valid db connection.\n");
                    }
                }
                catch (Exception ex)
                {
                    System.out.println(ex.getMessage() );    
                    this.txtClipboard.append( ex.getMessage()+"\n" );
                    this.txtClipboard.append( " no valid db connection \n" );
                    return;// cannot continue.
                }
            }// else sticky connection already on:
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(frmJprime.class.getName()).log(Level.SEVERE, null, ex);
        }
        // if we get here : conn is valid.
        DB_thread.PostgreSql_anyInstance_Prime_INSERT_ postgresPrimedata =//instance of the worker thread.
                new DB_thread.PostgreSql_anyInstance_Prime_INSERT_(txtClipboard, stickyConnection);
        this.t = new Thread( postgresPrimedata, "Frechet_prime_insert" );// Fork
        synchronized (t) 
        {
            t.start();// thread start; the interrupt() will arrive either from menu or for job completion.
        }// synchro        
    }//GEN-LAST:event_mnuItem_DBfrechet_enrichMouseReleased

    private void mnuItem_DBfrechet_stopEnrichingMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuItem_DBfrechet_stopEnrichingMouseReleased
        if(null != this.t )    
        {
            if( this.t.isAlive())
            {
                if( null != this.pgFrechet)
                {
                    try 
                    {
                        this.t.wait();
                        if( this.pgFrechet.getConnection().isValid(0))
                        {
                            this.pgFrechet.getConnection().notify();
                        }// else connection is invalid.
                    } 
                    catch (Exception ex)
                    {
                        System.out.println(ex.getMessage() );
                        this.txtClipboard.append( ex.getMessage()+"\n" );
                    }
                    finally
                    {
                        this.t.interrupt();
                        this.txtClipboard.append("\n thread nr. "+ this.t.getId() +" isAlive at the stop-request time___" +this.t.isAlive() );
                        this.t = null;//gc
                    }
                }// else the sticky connection has already been invalidated.
                this.txtClipboard.append("\n  calculation thread  isAlive but connection invalidated, at the stop-request time___"  );
            }//
            else
            {
                this.txtClipboard.append("\n calculation thread  is already dead." );
            }
        }// 
        else
        {
            this.txtClipboard.append("\n calculation thread is already NULL." );
        } 
        //--- NO: thread-stop must not imply DB-socket-closure.
        //        if( null != this.pgFrechet)
        //        {
        //            this.pgFrechet.closeConnection();
        //        }
    }//GEN-LAST:event_mnuItem_DBfrechet_stopEnrichingMouseReleased

    private void mnuItem_ITFORS1011_ReadSingleMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuItem_ITFORS1011_ReadSingleMouseReleased
        // an instance specific to each of the cases: {lower,upper}.
        dlgOrdinalAcquirer dlgLow = null;
        Common.DBservice.connectionProvider_postgreSql_ITFORS1011 volatileConnITFORS1011 = null;
        java.sql.Connection connITFORS = null;
        try
        {
            volatileConnITFORS1011 = 
                    new Common.DBservice.connectionProvider_postgreSql_ITFORS1011();
            connITFORS = volatileConnITFORS1011.getConnection();
            if(null==connITFORS || !connITFORS.isValid(0) )
            {
                throw new Exception("no valid db connection.\n");
            }
        }
        catch (Exception ex) 
        {
            System.out.println(ex.getMessage() );
            this.txtClipboard.append( ex.getMessage()+"\n" );
            this.txtClipboard.append( " no valid db connection \n" );
            return;// cannot continue.
        }
        // if we get here : conn is valid.
        // case : Lower
        dlgLow = new dlgOrdinalAcquirer(this,true,false);
        dlgLow.setTitle("supply the Ordinal for the required Prime");
        dlgLow.setAlwaysOnTop(true);
        dlgLow.setVisible(true);
        //------------on re-entry-------thread join from modal form-------------
        dlgLow.dispose();//---gc------
        //---when here, we should have both boundaries, which in this case are {low,low}.
        //---READ-SINGLE: i.e. Postgres_PrimeData_LOAD_MULTI_SERVICE_(theOrdinalLongLow,theOrdinalLongLow);---
        ArrayList<Entity.Proxy.PrimedataRiga> resultSet = null;
        try 
        {
            resultSet = Entity.Proxy.Postgres_PrimeData_LOAD_MULTI_.Postgres_PrimeData_LOAD_MULTI_SERVICE_(
                    connITFORS
                    ,this.theOrdinalLongLow,  this.theOrdinalLongLow ); // (low,low)
            if( resultSet.isEmpty() || 1!=resultSet.size()  )// one and only one record required.
            {
                throw new Exception("\n\n the resultset is supposed to have cardinality>0. \n");
            }
            this.txtClipboard.append("\n Prime["+resultSet.get(0).getOrdinal()+"]== "+resultSet.get(0).getPrime());
        } 
        catch (Exception ex) 
        {
            this.txtClipboard.append("\n "+ex.getMessage() );
        }
        finally
        {
            dlgLow = null;//---gc------
            volatileConnITFORS1011.closeConnection();
            volatileConnITFORS1011 = null;// gc
        }
    }//GEN-LAST:event_mnuItem_ITFORS1011_ReadSingleMouseReleased

    private void mnuItem_DBITFORS_enrichMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuItem_DBITFORS_enrichMouseReleased
        try 
        {
            if(null== frmJprime.pgITFORS1011 )
            {
                frmJprime.pgITFORS1011 = new Common.DBservice.connectionProvider_postgreSql_ITFORS1011();
            }// else already initialized.            
            if( null==frmJprime.stickyConnection || !frmJprime.stickyConnection.isValid(0) )
            {
                frmJprime.stickyConnection = frmJprime.pgITFORS1011.getConnection();
            }// else already initialized.
        }
        catch (Exception ex) 
        {
            System.out.println(ex.getMessage() );
            this.txtClipboard.append( ex.getMessage()+"\n" );
            this.txtClipboard.append( " no valid db connection \n" );
            return;// cannot continue.
        }
        // else sticky connection already on:
        // if we get here : conn is valid.
        DB_thread.PostgreSql_anyInstance_Prime_INSERT_ postgresPrimedata =//instance of the worker thread.
                new DB_thread.PostgreSql_anyInstance_Prime_INSERT_(txtClipboard, frmJprime.stickyConnection);
        // Fork
        this.t = new Thread( postgresPrimedata, "ITFORS1011_prime_insert" );// Fork
        synchronized (t)
        {
            t.start();// thread start; the interrupt() will arrive either from menu or for job completion.
        }// synchro
    }//GEN-LAST:event_mnuItem_DBITFORS_enrichMouseReleased

    private void mnu_DBITFORS_AvailThreshMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnu_DBITFORS_AvailThreshMouseReleased
        // available threshold on ITFORS1011
        java.util.ArrayList<Entity.Proxy.PrimedataRiga> resultSet = null;
        Common.DBservice.connectionProvider_postgreSql_ITFORS1011 volatileConnITFORS1011 = null;
        Connection connITFORS = null;
        try
        {
            volatileConnITFORS1011 = 
                    new Common.DBservice.connectionProvider_postgreSql_ITFORS1011();
            connITFORS = volatileConnITFORS1011.getConnection();
            if(null==connITFORS || !connITFORS.isValid(0) )
            {
                throw new Exception("no valid db connection.\n");
            }
            if( null!=connITFORS && connITFORS.isValid(0) )
            {
                resultSet =
                    Entity.Proxy.usp_PrimeData_LOAD_atMaxOrdinal_Postgres_.usp_PrimeData_LOAD_atMaxOrdinal_Postgres_SERVICE_(
                            connITFORS );
            }// else don't query.
        }
        catch (Exception ex) 
        {
            System.out.println(ex.getMessage() );
            this.txtClipboard.append( ex.getMessage()+"\n" );
            this.txtClipboard.append( " no valid db connection \n" );
            return;// cannot continue.
        }
        finally
        {
            volatileConnITFORS1011.closeConnection();
            volatileConnITFORS1011 = null;
        }
        if(null==resultSet || resultSet.isEmpty()) 
        {
            this.txtClipboard.append("\n the resultset is empty. \n" );
        }
        else
        {
            Entity.Proxy.PrimedataRiga lastRow = resultSet.get(0);
            this.txtClipboard.append("\n last Ordinal= "+ lastRow.getOrdinal() +" \t last Prime= " +lastRow.getPrime() );
        }//else
    }//GEN-LAST:event_mnu_DBITFORS_AvailThreshMouseReleased

    private void mnu_Item_DBITFORS_ReadRangeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnu_Item_DBITFORS_ReadRangeMouseReleased
            // an instance specific to each of the cases: {lower,upper}.
            dlgOrdinalAcquirer dlgLow = new dlgOrdinalAcquirer(this,true,false);
            dlgOrdinalAcquirer dlgHigh = new dlgOrdinalAcquirer(this,true, true);
            Common.DBservice.connectionProvider_postgreSql_ITFORS1011 volatileConnITFORS1011 = null;
            Connection connITFORS = null;
            try
            {
                volatileConnITFORS1011 = 
                        new Common.DBservice.connectionProvider_postgreSql_ITFORS1011();
                connITFORS = volatileConnITFORS1011.getConnection();
                if(null==connITFORS || !connITFORS.isValid(0) )
                {
                    throw new Exception("no valid db connection.\n");
                }
            }
            catch (Exception ex) 
            {
                System.out.println(ex.getMessage() );
                this.txtClipboard.append( ex.getMessage()+"\n" );
                this.txtClipboard.append( " no valid db connection \n" );
                return;// cannot continue.
            }            
            // if we get here : conn is valid.            
            // case : Lower
            dlgLow.setTitle("supply the Ordinal for the LOWER Prime");
            dlgLow.setAlwaysOnTop(true);
            dlgLow.setVisible(true);
            //------------on re-entry-------thread join from modal form-------------
            dlgLow.dispose();//---gc------
            // case : Upper
            dlgHigh.setTitle("supply the Ordinal for the UPPER Prime");
            dlgHigh.setAlwaysOnTop(true);
            dlgHigh.setVisible(true);
            //------------on re-entry-------thread join from modal form-------------
            dlgHigh.dispose();//---gc------                
            //---when here, we should have both boundaries {low,up}.
            ArrayList<Entity.Proxy.PrimedataRiga> resultSet = null;
            try
            {
                //---READ-MULTI: i.e. Postgres_PrimeData_LOAD_MULTI_SERVICE_(theOrdinalLongLow,theOrdinalLongHigh);---
                resultSet =
                        Entity.Proxy.Postgres_PrimeData_LOAD_MULTI_.Postgres_PrimeData_LOAD_MULTI_SERVICE_(
                                connITFORS 
                                , this.theOrdinalLongLow
                                , this.theOrdinalLongHigh ); // (low,high)
                if( resultSet.isEmpty() )// no check for single-record, on multi-case. was... || 1!=resultSet.size()
                {
                    throw new Exception("\n\n The resultset is supposed to have cardinality>0. \n");
                }            
                //
                System.out.println( "\n" );
                this.txtClipboard.append( "\n" );
                for(int c=0; c<resultSet.size(); c++)
                {
                    System.out.println("\n"+ resultSet.get(c).getOrdinal() + "____"+resultSet.get(c).getPrime() );
                    this.txtClipboard.append("\n"+ resultSet.get(c).getOrdinal() + "____"+resultSet.get(c).getPrime() );
                }
            }
            catch (Exception ex)
            {
                this.txtClipboard.append( ex.getMessage()+"\n" );
                System.out.println(ex.getMessage() );
            }
            finally
            {
                dlgLow = null;//---gc------
                dlgHigh = null;//---gc------
                volatileConnITFORS1011.closeConnection();
                volatileConnITFORS1011 = null;//gc
            }
    }//GEN-LAST:event_mnu_Item_DBITFORS_ReadRangeMouseReleased

    private void mnu_Item_DBfrechet_ReadRangeMouseReleased(java.awt.event.MouseEvent evt) {                                                           
        // an instance specific to each of the cases: {lower,upper}.
        Common.DBservice.connectionProvider_postgreSql_Frechet volatileConnFrechet = null;
        java.sql.Connection connFrechet = null;            
        //
        try
        {
            volatileConnFrechet = 
                    new Common.DBservice.connectionProvider_postgreSql_Frechet();
            connFrechet = volatileConnFrechet.getConnection();
            if(null==connFrechet || !connFrechet.isValid(0) )
            {
                throw new Exception("no valid db connection.\n");
            }
        }
        catch (Exception ex) 
        {
            System.out.println(ex.getMessage() );
            this.txtClipboard.append( ex.getMessage()+"\n" );
            this.txtClipboard.append( " no valid db connection \n" );
            return;// cannot continue.
        }
        // if we get here : conn is valid.
        // case : Lower
        dlgOrdinalAcquirer dlgLow = new dlgOrdinalAcquirer(this,true,false);        
        dlgLow.setTitle("supply the Ordinal for the LOWER Prime");
        dlgLow.setAlwaysOnTop(true);
        dlgLow.setVisible(true);
        //------------on re-entry-------thread join from modal form-------------
        dlgLow.dispose();//---gc------
        // case : Upper
        dlgOrdinalAcquirer dlgHigh = new dlgOrdinalAcquirer(this,true, true);        
        dlgHigh.setTitle("supply the Ordinal for the UPPER Prime");
        dlgHigh.setAlwaysOnTop(true);
        dlgHigh.setVisible(true);
        //------------on re-entry-------thread join from modal form-------------
        dlgHigh.dispose();//---gc------                
        //---when here, we should have both boundaries {low,up}.
        try
        {
            ArrayList<Entity.Proxy.PrimedataRiga> resultSet =
                    Entity.Proxy.Postgres_PrimeData_LOAD_MULTI_.Postgres_PrimeData_LOAD_MULTI_SERVICE_(
                            connFrechet,
                            this.theOrdinalLongLow,  this.theOrdinalLongHigh ); // (low,high)
            if( resultSet.isEmpty() )// no check for single-record, on multi-case. was... || 1!=resultSet.size()
            {
                throw new Exception("the resultset is supposed to have cardinality>0.");
            }
            //
            System.out.println( "\n\n" );
            this.txtClipboard.append( "\n\n" );
            for(int c=0; c<resultSet.size(); c++)
            {
                System.out.println( resultSet.get(c).getOrdinal() + "____"+resultSet.get(c).getPrime() );
                this.txtClipboard.append( resultSet.get(c).getOrdinal() + "____"+resultSet.get(c).getPrime()+ "\n" );
            }
        }
        catch (Exception ex)
        {
            this.txtClipboard.append( ex.getMessage()+"\n" );
            System.out.println("\n " + ex.getMessage() );
        }
        finally
        {
            dlgLow = null;//---gc------
            dlgHigh = null;//---gc------
            volatileConnFrechet.closeConnection();
            volatileConnFrechet = null;
        }
    }


    private void mnu_Item_DB_Frechet_AvailableThreshMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnu_Item_DB_Frechet_AvailableThreshMouseReleased
        // available threshold on Frechet : NO sticky connection.
        Common.DBservice.connectionProvider_postgreSql_Frechet localFrechetConnProvider = null;
        java.util.ArrayList<Entity.Proxy.PrimedataRiga> resultSet = null;
        Connection connLocal = null;
        try 
        {
            localFrechetConnProvider = new Common.DBservice.connectionProvider_postgreSql_Frechet();
            connLocal = localFrechetConnProvider.getConnection();
            if( null != connLocal && connLocal.isValid(0) )
            {
                resultSet =
                    Entity.Proxy.usp_PrimeData_LOAD_atMaxOrdinal_Postgres_.usp_PrimeData_LOAD_atMaxOrdinal_Postgres_SERVICE_(connLocal);
                localFrechetConnProvider.closeConnection();// no sticky
            }// else skip.
        } 
        catch ( Exception ex) 
        {
            System.out.println(ex.getMessage() );
            this.txtClipboard.append( ex.getMessage()+"\n" );
            this.txtClipboard.append( " no valid db connection \n" );
            return;// cannot continue.
        }
        finally
        {
            connLocal = null;// gc.
        }
        if(null==resultSet || resultSet.isEmpty()) 
        {
            this.txtClipboard.append("\n the table -primedata- is empty or the primary key has been desrupted, due to partial deletion. \n");
        }
        else
        {
            Entity.Proxy.PrimedataRiga lastRow = resultSet.get(0);
            this.txtClipboard.append("\n last Ordinal= "+ lastRow.getOrdinal() +" \t last Prime= " +lastRow.getPrime() );
        }//else
    }//GEN-LAST:event_mnu_Item_DB_Frechet_AvailableThreshMouseReleased

    private void mnuItem_DBITFORS_stopEnrichingMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuItem_DBITFORS_stopEnrichingMouseReleased
        if(null != this.t )    
        {
            if( this.t.isAlive())
            {
                if( null != this.pgITFORS1011)
                {
                    try 
                    {
                        this.t.wait();
                        if( this.pgITFORS1011.getConnection().isValid(0))
                        {
                            this.pgITFORS1011.getConnection().notify();
                        }// else connection is invalid.
                    } catch (Exception ex)
                    {
                        System.out.println(ex.getMessage() );
                        this.txtClipboard.append( ex.getMessage()+"\n" );
                    }
                    finally
                    {
                        this.t.interrupt();
                        this.txtClipboard.append("\n thread nr. "+ this.t.getId() +" isAlive at the stop-request time___" +this.t.isAlive() );
                        this.t = null;//gc
                    }
                }// else the sticky connection has already been invalidated.
                this.txtClipboard.append("\n thread nr. "+ this.t.getId() +" isAlive but connection invalidated, at the stop-request time___" +this.t.isAlive() );
            }//
            else
            {
                this.txtClipboard.append("\n thread nr. "+ this.t.getId() +" is already dead." );
            }
        }// 
        else
        {
            this.txtClipboard.append("\n calculation thread is already NULL." );
        } 
        //--- NO: thread-stop must not imply DB-socket-closure.
        //        if( null != this.pgITFORS1011)
        //        {
        //            this.pgITFORS1011.closeConnection();
        //        }
    }//GEN-LAST:event_mnuItem_DBITFORS_stopEnrichingMouseReleased


    // Entry Point
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmJprime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmJprime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmJprime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmJprime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmJprime().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mnuItem_DBITFORS_enrich;
    private javax.swing.JMenuItem mnuItem_DBITFORS_stopEnriching;
    private javax.swing.JMenuItem mnuItem_DBfrechet_enrich;
    private javax.swing.JMenuItem mnuItem_DBfrechet_stopEnriching;
    private javax.swing.JMenuItem mnuItem_Frechet_ReadSingle;
    private javax.swing.JMenuItem mnuItem_ITFORS1011_ReadSingle;
    private javax.swing.JMenuItem mnuItem_exit;
    private javax.swing.JMenuBar mnuStripTop;
    private javax.swing.JMenu mnuStrip_DB_Frechet;
    private javax.swing.JMenu mnuStrip_DB_ITFORS;
    private javax.swing.JMenu mnuTitle_Calculation;
    private javax.swing.JMenu mnuTitle_FileSystem;
    private javax.swing.JMenuItem mnu_DBITFORS_AvailThresh;
    private javax.swing.JMenuItem mnu_Item_DBITFORS_ReadRange;
    private javax.swing.JMenuItem mnu_Item_DB_Frechet_AvailableThresh;
    private javax.swing.JMenuItem mnu_Item_DBfrechet_ReadRange;
    public javax.swing.JTextArea txtClipboard;
    // End of variables declaration//GEN-END:variables
}
