/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

/**
 *
 * @author admin
 */
public class frmOrdinalAcquirer extends javax.swing.JFrame {
    public long theOrdinalL;
    public String theOrdinalStr = null;
    public frmJprime theMainFrm = null;

    // Ctor default
    public frmOrdinalAcquirer( ) {
        initComponents();
    }// Ctor default
    
    // Ctor
    public frmOrdinalAcquirer(frmJprime theMainFrm) {
        initComponents();
        //
        this.theMainFrm = theMainFrm;
        this.theOrdinalStr = this.theMainFrm.theOrdinalStr;
        this.theOrdinalL =  this.theMainFrm.theOrdinalLong = -1L;// init to invalid
    }// Ctor

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtOrdinal = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtOrdinal.setText("the Ordinal in <ordinal,prime> sequence.");
        txtOrdinal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtOrdinalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtOrdinalMouseEntered(evt);
            }
        });

        btnSubmit.setText("Submit");
        btnSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSubmitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSubmitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSubmitMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSubmitMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSubmitMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtOrdinal, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSubmit)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtOrdinal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSubmit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseReleased
        // event not fired : String theOrdinal = this.txtOrdinal.getText();
    }//GEN-LAST:event_btnSubmitMouseReleased

    private void txtOrdinalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtOrdinalMouseEntered
        // do nothing.
    }//GEN-LAST:event_txtOrdinalMouseEntered

    private void txtOrdinalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtOrdinalMouseClicked
        this.txtOrdinal.setText("");
    }//GEN-LAST:event_txtOrdinalMouseClicked

    private void btnSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseClicked
        this.theOrdinalStr = this.txtOrdinal.getText();        
        try
        {
            this.theOrdinalL = Long.parseLong(this.theOrdinalStr);
        }
        catch( NumberFormatException ex)
        {// this way theOrdinalL stays to invalid value==-1;
            this.txtOrdinal.setText("wrong integer");
        }
        this.setVisible(false);
        // this.dispose();// destroy. NOT before 
        // on-reEntry-----------------------------
        long localOrdinal = this.theOrdinalL;
        long prime = -1;
        try
        {
            prime = Entity.Proxy.usp_PrimeData_LOAD_MULTI_Postgres_ITFORS1011.usp_PrimeData_LOAD_MULTI_Postgres_ITFORS1011_SERVICE_(localOrdinal,localOrdinal);
        }
        catch( Exception ex)
        {
          theMainFrm.txtClipboard.append(ex.getMessage() );
        }
        theMainFrm.txtClipboard.append("Prime["+localOrdinal+"]== "+prime+"\n");
    }//GEN-LAST:event_btnSubmitMouseClicked

    private void btnSubmitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMousePressed
        //String theOrdinal = this.txtOrdinal.getText();
    }//GEN-LAST:event_btnSubmitMousePressed

    private void btnSubmitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseEntered
        // int i = 2+3;
    }//GEN-LAST:event_btnSubmitMouseEntered

    private void btnSubmitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseExited
      // int i = 2+3;
    }//GEN-LAST:event_btnSubmitMouseExited

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
            java.util.logging.Logger.getLogger(frmOrdinalAcquirer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmOrdinalAcquirer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmOrdinalAcquirer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmOrdinalAcquirer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        String theOrdinalStr = null;
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmOrdinalAcquirer f = new frmOrdinalAcquirer();
                f.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JTextField txtOrdinal;
    // End of variables declaration//GEN-END:variables
}
