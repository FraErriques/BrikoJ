/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class frmJprime extends javax.swing.JFrame {
    private Thread t;
    Connection con;
    Common.DBservice.connectionProvider_postgreSql_Frechet pgFrechet;
    Common.DBservice.connectionProvider_postgreSql_ITFORS1011 pgITFORS1011;

    
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
        mnuStrip_DB_ITFORS1011 = new javax.swing.JMenu();
        mnuItem_enrichDB = new javax.swing.JMenuItem();
        mnuItem_stopDB = new javax.swing.JMenuItem();
        mnuStrip_DB_Frechet = new javax.swing.JMenu();
        mnu_Item_DB_Frechet_AvailableThresh = new javax.swing.JMenuItem();
        mnuItem_Frechet_ReadSingle = new javax.swing.JMenuItem();
        mnu_Item_DBfrechet_ReadRange = new javax.swing.JMenuItem();
        mnuItem_DBfrechet_enrich = new javax.swing.JMenuItem();
        mnuItem_DBfrechet_stopEnriching = new javax.swing.JMenuItem();
        mnuStrip_DB_ITFORS = new javax.swing.JMenu();
        mnu_DBITFORS_AvailThresh = new javax.swing.JMenuItem();
        mnuItem_Frechet_ReadSingle1 = new javax.swing.JMenuItem();
        mnu_Item_DBfrechet_ReadRange1 = new javax.swing.JMenuItem();
        mnuItem_DBfrechet_enrich1 = new javax.swing.JMenuItem();
        mnuItem_DBfrechet_stopEnriching1 = new javax.swing.JMenuItem();

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

        mnuStrip_DB_ITFORS1011.setText("DB ITFORS1011");
        mnuStrip_DB_ITFORS1011.setAutoscrolls(true);

        mnuItem_enrichDB.setText("enrich DB");
        mnuItem_enrichDB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mnuItem_enrichDBMouseReleased(evt);
            }
        });
        mnuStrip_DB_ITFORS1011.add(mnuItem_enrichDB);

        mnuItem_stopDB.setText("stop enriching DB");
        mnuItem_stopDB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mnuItem_stopDBMouseReleased(evt);
            }
        });
        mnuStrip_DB_ITFORS1011.add(mnuItem_stopDB);

        mnuStripTop.add(mnuStrip_DB_ITFORS1011);

        mnuStrip_DB_Frechet.setText("DB Frechet");

        mnu_Item_DB_Frechet_AvailableThresh.setText("Available Threshold");
        mnu_Item_DB_Frechet_AvailableThresh.setToolTipText("");
        mnuStrip_DB_Frechet.add(mnu_Item_DB_Frechet_AvailableThresh);

        mnuItem_Frechet_ReadSingle.setText("Read Single");
        mnuItem_Frechet_ReadSingle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mnuItem_Frechet_ReadSingleMouseReleased(evt);
            }
        });
        mnuStrip_DB_Frechet.add(mnuItem_Frechet_ReadSingle);

        mnu_Item_DBfrechet_ReadRange.setText("Read Range");
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

        mnuStrip_DB_ITFORS.setText("DB  BBT::ITFORS1011");
        mnuStrip_DB_ITFORS.setToolTipText("");
        mnuStrip_DB_ITFORS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mnuStrip_DB_ITFORSMouseReleased(evt);
            }
        });

        mnu_DBITFORS_AvailThresh.setText("Available Threshold");
        mnu_DBITFORS_AvailThresh.setToolTipText("");
        mnu_DBITFORS_AvailThresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mnu_DBITFORS_AvailThreshMouseReleased(evt);
            }
        });
        mnu_DBITFORS_AvailThresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_DBITFORS_AvailThreshActionPerformed(evt);
            }
        });
        mnuStrip_DB_ITFORS.add(mnu_DBITFORS_AvailThresh);

        mnuItem_Frechet_ReadSingle1.setText("Read Single");
        mnuItem_Frechet_ReadSingle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mnuItem_Frechet_ReadSingle1MouseReleased(evt);
            }
        });
        mnuStrip_DB_ITFORS.add(mnuItem_Frechet_ReadSingle1);

        mnu_Item_DBfrechet_ReadRange1.setText("Read Range");
        mnuStrip_DB_ITFORS.add(mnu_Item_DBfrechet_ReadRange1);

        mnuItem_DBfrechet_enrich1.setText("Enrich DB");
        mnuItem_DBfrechet_enrich1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mnuItem_DBfrechet_enrich1MouseReleased(evt);
            }
        });
        mnuStrip_DB_ITFORS.add(mnuItem_DBfrechet_enrich1);

        mnuItem_DBfrechet_stopEnriching1.setText("stop enriching");
        mnuItem_DBfrechet_stopEnriching1.setToolTipText("");
        mnuItem_DBfrechet_stopEnriching1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mnuItem_DBfrechet_stopEnriching1MouseReleased(evt);
            }
        });
        mnuStrip_DB_ITFORS.add(mnuItem_DBfrechet_stopEnriching1);

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

    private void mnuItem_enrichDBMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuItem_enrichDBMouseReleased
        this.pgFrechet = new Common.DBservice.connectionProvider_postgreSql_Frechet();
        this.con = pgFrechet.getConnection();    
        DB_thread.PostgreSql_anyInstance_Prime_INSERT_ postgresPrimedata =
                new DB_thread.PostgreSql_anyInstance_Prime_INSERT_(txtClipboard, con);

        this.t = new Thread( postgresPrimedata, "ITFORS1011_prime_insert" );// Fork
        synchronized (t)
        {
            t.start();// thread start; the interrupt() will arrive either from menu or for job completion.
        }// synchro
    }//GEN-LAST:event_mnuItem_enrichDBMouseReleased

    private void mnuItem_stopDBMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuItem_stopDBMouseReleased
        this.t.interrupt();
        this.pgFrechet.closeConnection();
        this.txtClipboard.append("\n thread nr."+ this.t.getId() +" isAlive==" +this.t.isAlive() );
    }//GEN-LAST:event_mnuItem_stopDBMouseReleased

    private void mnuItem_exitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuItem_exitMouseReleased
        System.exit(0);// normal exit
    }//GEN-LAST:event_mnuItem_exitMouseReleased



    private void mnuItem_DB_AvailableThresholdMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuItem_DB_AvailableThresholdMouseReleased
        this.pgFrechet = new Common.DBservice.connectionProvider_postgreSql_Frechet();
        this.con = pgFrechet.getConnection();    
        //
        Entity.Proxy.PrimedataRiga res = 
        ProcessOperatingInterface.postgres_LoadAtMaxOrdinal.postgres_LoadAtMaxOrdinal_SERVICE_(txtClipboard, con);
        txtClipboard.append(res.getOrdinal()+"___"+res.getPrime());
    }//GEN-LAST:event_mnuItem_DB_AvailableThresholdMouseReleased

    private void mnuItem_DB_AvailableThresholdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItem_DB_AvailableThresholdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuItem_DB_AvailableThresholdActionPerformed

    private void mnuItem_Frechet_ReadSingleMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuItem_Frechet_ReadSingleMouseReleased
        Interface.frmOrdinalAcquirer frmAcquirer = new Interface.frmOrdinalAcquirer();
        frmAcquirer.show();
    }//GEN-LAST:event_mnuItem_Frechet_ReadSingleMouseReleased

    private void mnuItem_DBfrechet_enrichMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuItem_DBfrechet_enrichMouseReleased
        this.pgFrechet = new Common.DBservice.connectionProvider_postgreSql_Frechet();
        this.con = pgFrechet.getConnection();    
        DB_thread.PostgreSql_anyInstance_Prime_INSERT_ postgresPrimedata =
                new DB_thread.PostgreSql_anyInstance_Prime_INSERT_(txtClipboard, con);

        this.t = new Thread( postgresPrimedata, "ITFORS1011_prime_insert" );// Fork
        synchronized (t)
        {
            t.start();// thread start; the interrupt() will arrive either from menu or for job completion.
        }// synchro
    }//GEN-LAST:event_mnuItem_DBfrechet_enrichMouseReleased

    private void mnuItem_DBfrechet_stopEnrichingMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuItem_DBfrechet_stopEnrichingMouseReleased
        this.t.interrupt();
        this.pgFrechet.closeConnection();
        this.txtClipboard.append("\n thread nr."+ this.t.getId() +" isAlive==" +this.t.isAlive() );
    }//GEN-LAST:event_mnuItem_DBfrechet_stopEnrichingMouseReleased

    private void mnuItem_Frechet_ReadSingle1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuItem_Frechet_ReadSingle1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuItem_Frechet_ReadSingle1MouseReleased

    private void mnuItem_DBfrechet_enrich1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuItem_DBfrechet_enrich1MouseReleased
        this.pgFrechet = new Common.DBservice.connectionProvider_postgreSql_Frechet();
        this.con = pgFrechet.getConnection();    
        DB_thread.PostgreSql_anyInstance_Prime_INSERT_ postgresPrimedata =
                new DB_thread.PostgreSql_anyInstance_Prime_INSERT_(txtClipboard, con);

        this.t = new Thread( postgresPrimedata, "ITFORS1011_prime_insert" );// Fork
        synchronized (t)
        {
            t.start();// thread start; the interrupt() will arrive either from menu or for job completion.
        }// synchro
    }//GEN-LAST:event_mnuItem_DBfrechet_enrich1MouseReleased

    private void mnuItem_DBfrechet_stopEnriching1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuItem_DBfrechet_stopEnriching1MouseReleased
        this.t.interrupt();
        this.pgFrechet.closeConnection();
        this.txtClipboard.append("\n thread nr."+ this.t.getId() +" isAlive==" +this.t.isAlive() );
    }//GEN-LAST:event_mnuItem_DBfrechet_stopEnriching1MouseReleased

    private void mnuStrip_DB_ITFORSMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuStrip_DB_ITFORSMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuStrip_DB_ITFORSMouseReleased

    private void mnu_DBITFORS_AvailThreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_DBITFORS_AvailThreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnu_DBITFORS_AvailThreshActionPerformed

    private void mnu_DBITFORS_AvailThreshMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnu_DBITFORS_AvailThreshMouseReleased
        // available threshold on ITFORS1011
        this.pgITFORS1011 = new Common.DBservice.connectionProvider_postgreSql_ITFORS1011();
        Connection connLocal = this.pgITFORS1011.getConnection();
        java.util.ArrayList<Entity.Proxy.PrimedataRiga> resultSet = null;
        try {
            resultSet =
                Entity.Proxy.usp_PrimeData_LOAD_atMaxOrdinal_Postgres_.usp_PrimeData_LOAD_atMaxOrdinal_Postgres_SERVICE_(connLocal);
        } catch (SQLException ex) {
            Logger.getLogger(frmJprime.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(null==resultSet || resultSet.isEmpty()) {return;}
        else
        {
            Entity.Proxy.PrimedataRiga lastRow = resultSet.get(0);
            this.txtClipboard.append("\n last Ordinal= "+ lastRow.getOrdinal() +" \t last Prime= " +lastRow.getPrime() );
        }//else
    }//GEN-LAST:event_mnu_DBITFORS_AvailThreshMouseReleased

    /**
     * @param args the command line arguments
     */
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
    private javax.swing.JMenuItem mnuItem_DBfrechet_enrich;
    private javax.swing.JMenuItem mnuItem_DBfrechet_enrich1;
    private javax.swing.JMenuItem mnuItem_DBfrechet_stopEnriching;
    private javax.swing.JMenuItem mnuItem_DBfrechet_stopEnriching1;
    private javax.swing.JMenuItem mnuItem_Frechet_ReadSingle;
    private javax.swing.JMenuItem mnuItem_Frechet_ReadSingle1;
    private javax.swing.JMenuItem mnuItem_enrichDB;
    private javax.swing.JMenuItem mnuItem_exit;
    private javax.swing.JMenuItem mnuItem_stopDB;
    private javax.swing.JMenuBar mnuStripTop;
    private javax.swing.JMenu mnuStrip_DB_Frechet;
    private javax.swing.JMenu mnuStrip_DB_ITFORS;
    private javax.swing.JMenu mnuStrip_DB_ITFORS1011;
    private javax.swing.JMenu mnuTitle_Calculation;
    private javax.swing.JMenu mnuTitle_FileSystem;
    private javax.swing.JMenuItem mnu_DBITFORS_AvailThresh;
    private javax.swing.JMenuItem mnu_Item_DB_Frechet_AvailableThresh;
    private javax.swing.JMenuItem mnu_Item_DBfrechet_ReadRange;
    private javax.swing.JMenuItem mnu_Item_DBfrechet_ReadRange1;
    public javax.swing.JTextArea txtClipboard;
    // End of variables declaration//GEN-END:variables
}
