/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package testgui;

import java.util.Set;
import testgui.PrimesThreadForker;
//import Common.MonteCarlo.*;  

/**
 *
 * @author fra
 */
public class Jprimes extends javax.swing.JFrame {

    /**
     * Creates new form Jprimes
     */
    public Jprimes() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        mnb_MenuBar = new javax.swing.JMenuBar();
        mnu_FileSys = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnu_FSproduction = new javax.swing.JMenu();
        mnu_Calc = new javax.swing.JMenu();
        mnu_DB = new javax.swing.JMenu();
        mnu_enrichDB = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(50);
        jScrollPane1.setViewportView(jTextArea1);

        mnu_FileSys.setText("FileSystem");
        mnu_FileSys.setToolTipText("Prime data on File System");
        mnu_FileSys.setVerifyInputWhenFocusTarget(false);

        jMenuItem2.setText("available FS threshold");
        mnu_FileSys.add(jMenuItem2);

        jMenuItem1.setText("Exit");
        jMenuItem1.setToolTipText("close the application");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseReleased(evt);
            }
        });
        mnu_FileSys.add(jMenuItem1);

        mnb_MenuBar.add(mnu_FileSys);

        mnu_FSproduction.setText("FileSystem data production");
        mnu_FSproduction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_FSproductionActionPerformed(evt);
            }
        });
        mnb_MenuBar.add(mnu_FSproduction);

        mnu_Calc.setText("Calculation");
        mnu_Calc.setToolTipText("");
        mnb_MenuBar.add(mnu_Calc);

        mnu_DB.setText("db");
        mnu_DB.setToolTipText("");

        mnu_enrichDB.setText("enrich db collection");
        mnu_enrichDB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mnu_enrichDBMouseReleased(evt);
            }
        });
        mnu_DB.add(mnu_enrichDB);
        mnu_enrichDB.getAccessibleContext().setAccessibleName("mnu_enrichDB");

        mnb_MenuBar.add(mnu_DB);

        setJMenuBar(mnb_MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnu_FSproductionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_FSproductionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnu_FSproductionActionPerformed

    private void jMenuItem1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseReleased
        // TODO add your handling code here:
        System.exit(0);// normal exit
    }//GEN-LAST:event_jMenuItem1MouseReleased

    private void mnu_enrichDBMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnu_enrichDBMouseReleased
        // TODO add your handling code here:
        this.jTextArea1.insert("TEST \n", 0);
        java.util.Hashtable< String, java.util.Stack<String> > threadLoggingStack =
            new java.util.Hashtable< String, java.util.Stack<String> >();
        
        for(int c=0; c<50; c++)
        {
            PrimesThreadForker theForker = new PrimesThreadForker();
            String threadName = Common.MonteCarlo.MonteCarloGenerator.UID();
            Thread t = new Thread( theForker, threadName );            
            threadLoggingStack.putIfAbsent( threadName, new java.util.Stack<String>() );
            //
            t.start();// run asynchronously.
            //
            if( threadLoggingStack.containsKey( threadName) )
            {
                this.jTextArea1.insert("key representing thread named : "+threadName+" found.",0);
                long cardThreadStack = 0;
                cardThreadStack = Common.MonteCarlo.MonteCarloGenerator.nextInteger(1, 16);
                for(int d=0; d<cardThreadStack; d++)
                {
                    threadLoggingStack.get( threadName).addElement("stack level "+d+" on "+ threadName);
                }
            }
            else
            {
                this.jTextArea1.insert("key representing thread named : "+threadName+" NOT found.",0);
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
        //
        // done : enrich db collection - delegate
    }//GEN-LAST:event_mnu_enrichDBMouseReleased

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
            java.util.logging.Logger.getLogger(Jprimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jprimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jprimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jprimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jprimes().setVisible(true);
            }
        });
    }// main
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JMenuBar mnb_MenuBar;
    private javax.swing.JMenu mnu_Calc;
    private javax.swing.JMenu mnu_DB;
    private javax.swing.JMenu mnu_FSproduction;
    private javax.swing.JMenu mnu_FileSys;
    private javax.swing.JMenuItem mnu_enrichDB;
    // End of variables declaration//GEN-END:variables
}
