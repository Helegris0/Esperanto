/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.esperanto.gui;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import parser.esperanto.query.CommandBuilder;

/**
 *
 * @author Timi
 */
public class SentenceInputPanel extends javax.swing.JPanel {
    
    private Action action = new AbstractAction() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            doIt();
        }
    };

    /**
     * Creates new form ParserPanel
     */
    public SentenceInputPanel() {
        initComponents();
        txtInput.addActionListener(action);
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
        txtInput = new javax.swing.JTextField();
        btnParse = new javax.swing.JButton();
        btnLetterC = new javax.swing.JButton();
        btnLetterG = new javax.swing.JButton();
        btnLetterH = new javax.swing.JButton();
        btnLetterJ = new javax.swing.JButton();
        btnLetterS = new javax.swing.JButton();
        btnLetterU = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOutput = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(0, 153, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Az elemezendő mondat eszperantóul:");

        btnParse.setText("Elemzés");
        btnParse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParseActionPerformed(evt);
            }
        });

        btnLetterC.setText("ĉ");
        btnLetterC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetterCActionPerformed(evt);
            }
        });

        btnLetterG.setText("ĝ");
        btnLetterG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetterGActionPerformed(evt);
            }
        });

        btnLetterH.setText("ĥ");
        btnLetterH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetterHActionPerformed(evt);
            }
        });

        btnLetterJ.setText("ĵ");
        btnLetterJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetterJActionPerformed(evt);
            }
        });

        btnLetterS.setText("ŝ");
        btnLetterS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetterSActionPerformed(evt);
            }
        });

        btnLetterU.setText("ŭ");
        btnLetterU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetterUActionPerformed(evt);
            }
        });

        txtOutput.setColumns(20);
        txtOutput.setRows(5);
        jScrollPane1.setViewportView(txtOutput);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1)
                    .addComponent(txtInput)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLetterC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLetterG, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLetterH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLetterJ)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLetterS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLetterU)
                        .addGap(43, 43, 43)
                        .addComponent(btnParse)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnParse)
                    .addComponent(btnLetterC)
                    .addComponent(btnLetterU)
                    .addComponent(btnLetterS)
                    .addComponent(btnLetterJ)
                    .addComponent(btnLetterH)
                    .addComponent(btnLetterG))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnParseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParseActionPerformed
        doIt();
    }//GEN-LAST:event_btnParseActionPerformed

    private void btnLetterCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterCActionPerformed
        insertLetter("ĉ");
    }//GEN-LAST:event_btnLetterCActionPerformed

    private void btnLetterGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterGActionPerformed
        insertLetter("ĝ");
    }//GEN-LAST:event_btnLetterGActionPerformed

    private void btnLetterHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterHActionPerformed
        insertLetter("ĥ");
    }//GEN-LAST:event_btnLetterHActionPerformed

    private void btnLetterJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterJActionPerformed
        insertLetter("ĵ");
    }//GEN-LAST:event_btnLetterJActionPerformed

    private void btnLetterSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterSActionPerformed
        insertLetter("ŝ");
    }//GEN-LAST:event_btnLetterSActionPerformed

    private void btnLetterUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetterUActionPerformed
        insertLetter("ŭ");
    }//GEN-LAST:event_btnLetterUActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLetterC;
    private javax.swing.JButton btnLetterG;
    private javax.swing.JButton btnLetterH;
    private javax.swing.JButton btnLetterJ;
    private javax.swing.JButton btnLetterS;
    private javax.swing.JButton btnLetterU;
    private javax.swing.JButton btnParse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtInput;
    private javax.swing.JTextArea txtOutput;
    // End of variables declaration//GEN-END:variables

    private void doIt() {
        txtOutput.setText("");
        
        try {
            txtOutput.append(CommandBuilder.getResult(txtInput.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void insertLetter(String letter) {
        String formerText = txtInput.getText();
        int position = txtInput.getCaretPosition();
        txtInput.setText(formerText.substring(0, position) + letter + formerText.substring(position));
        txtInput.setCaretPosition(position + letter.length());
    }
    
}
