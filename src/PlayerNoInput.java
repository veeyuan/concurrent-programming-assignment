/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Liow Jing Wen
 */
public class PlayerNoInput extends javax.swing.JFrame {

    /**
     * Creates new form PlayerNoInput
     */
    public PlayerNoInput() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        noOfPlayerText = new javax.swing.JTextField();
        noOfPlayersButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        noOfPointText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        executionTimeText = new javax.swing.JTextField();
        noPlayerError = new javax.swing.JLabel();
        noPointsError = new javax.swing.JLabel();
        timeError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("CONQUERING THE NODES");

        jLabel2.setText("Number of players: ");

        noOfPlayerText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                noOfPlayerTextKeyReleased(evt);
            }
        });

        noOfPlayersButton.setText("OK");
        noOfPlayersButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noOfPlayersButtonMouseClicked(evt);
            }
        });
        noOfPlayersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noOfPlayersButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Number of points: ");

        noOfPointText.setToolTipText("");
        noOfPointText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noOfPointTextActionPerformed(evt);
            }
        });
        noOfPointText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                noOfPointTextKeyReleased(evt);
            }
        });

        jLabel4.setText("Execution time (ms): ");

        executionTimeText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                executionTimeTextKeyReleased(evt);
            }
        });

        noPlayerError.setForeground(new java.awt.Color(204, 0, 0));
        noPlayerError.setText("     ");

        noPointsError.setForeground(new java.awt.Color(204, 0, 0));
        noPointsError.setText("       ");

        timeError.setForeground(new java.awt.Color(204, 0, 0));
        timeError.setText("       ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noOfPlayerText)
                            .addComponent(noOfPointText)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(noPlayerError)
                                    .addComponent(noPointsError))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timeError)
                            .addComponent(executionTimeText))))
                .addContainerGap(124, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(noOfPlayersButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(noOfPlayerText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(noPlayerError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(noOfPointText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(noPointsError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(executionTimeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeError)
                .addGap(8, 8, 8)
                .addComponent(noOfPlayersButton)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void noOfPlayersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noOfPlayersButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noOfPlayersButtonActionPerformed

    private void noOfPlayersButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noOfPlayersButtonMouseClicked
        // TODO add your handling code here:
        
        //if one of the fields are empty
        //prompt an error message
        if(noOfPlayerText.getText().isEmpty()){
            noPlayerError.setText("Number of players cannot be blank");         
        }
        else if(noOfPointText.getText().isEmpty()){
            noPointsError.setText("Number of points cannot be blank");
        }
        else if(executionTimeText.getText().isEmpty()){
            timeError.setText("Execution time cannot be blank");
        }
        //if fields are not empty        
        else{                
            //get the value from each field
            int noOfPlayer = Integer.parseInt(noOfPlayerText.getText());
            int noOfPoints = Integer.parseInt(noOfPointText.getText());
            int executionTime = Integer.parseInt(executionTimeText.getText());

            //initialise PlayerNameInput JFrame
            PlayerNameInput playerNameInput = null;
            try {
                playerNameInput = new PlayerNameInput(noOfPlayer, noOfPoints, executionTime);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PlayerNoInput.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(PlayerNoInput.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(PlayerNoInput.class.getName()).log(Level.SEVERE, null, ex);
            }
            playerNameInput.setVisible(true);
        }

    }//GEN-LAST:event_noOfPlayersButtonMouseClicked

    private void noOfPointTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noOfPointTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noOfPointTextActionPerformed

    private void noOfPlayerTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noOfPlayerTextKeyReleased
        // TODO add your handling code here:
        //to ensure textfield accepts numbers only
        try {
            long number = Long.parseLong(noOfPlayerText.getText());
            noPlayerError.setText("  ");
        } catch (Exception e) {
            noPlayerError.setText("Only numbers are allowed");
            noOfPlayerText.setText("");
        }
    }//GEN-LAST:event_noOfPlayerTextKeyReleased

    private void noOfPointTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noOfPointTextKeyReleased
        // TODO add your handling code here:
        //to ensure textfield accepts numbers only
        try {
            long number = Long.parseLong(noOfPointText.getText());
            noPointsError.setText("  ");
        } catch (Exception e) {
            noPointsError.setText("Only numbers are allowed");
            noOfPointText.setText("");
        }
    }//GEN-LAST:event_noOfPointTextKeyReleased

    private void executionTimeTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_executionTimeTextKeyReleased
        // TODO add your handling code here:
        //to ensure textfield accepts numbers only
        try {
            long number = Long.parseLong(executionTimeText.getText());
            timeError.setText("  ");
        } catch (Exception e) {
            timeError.setText("Only numbers are allowed");
            executionTimeText.setText("");
        }
    }//GEN-LAST:event_executionTimeTextKeyReleased

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
            java.util.logging.Logger.getLogger(PlayerNoInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayerNoInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayerNoInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayerNoInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlayerNoInput().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField executionTimeText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField noOfPlayerText;
    private javax.swing.JButton noOfPlayersButton;
    private javax.swing.JTextField noOfPointText;
    private javax.swing.JLabel noPlayerError;
    private javax.swing.JLabel noPointsError;
    private javax.swing.JLabel timeError;
    // End of variables declaration//GEN-END:variables
}
