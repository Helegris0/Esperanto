/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.esperanto.gui;

import static java.lang.String.join;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.io.IOUtils;
import parser.esperanto.query.CommandBuilder;

/**
 *
 * @author Timi
 */
public class FileInputPanel extends javax.swing.JPanel {

    /**
     * Creates new form FileInputPanel
     */
    public FileInputPanel() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        txtText = new javax.swing.JTextArea();
        btnOpen = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtOutput = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(0, 153, 0));

        txtText.setColumns(20);
        txtText.setRows(5);
        jScrollPane1.setViewportView(txtText);

        btnOpen.setText("Szövegfájl betöltése");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        txtOutput.setColumns(20);
        txtOutput.setRows(5);
        jScrollPane2.setViewportView(txtOutput);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnOpen)
                        .addGap(0, 247, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOpen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Szövegfájl (*.txt)", "txt");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setCurrentDirectory(new File("./src/main/resources/text/"));

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String path = fileChooser.getSelectedFile().getAbsolutePath();
            try {
                readFile(path);
                setOutput();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "A fájl nem található");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Beolvasási hiba");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnOpenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOpen;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtOutput;
    private javax.swing.JTextArea txtText;
    // End of variables declaration//GEN-END:variables

    private void readFile(String path) throws FileNotFoundException, IOException {
        try (FileInputStream inputStream = new FileInputStream(path)) {
            String text = IOUtils.toString(inputStream, "UTF-8");
            txtText.setText(text);
        }
    }

    private void setOutput() {
        List<String> subResults = new ArrayList<>();

        for (String sentence : getSentences()) {
            try {
                subResults.add(CommandBuilder.getResult(sentence));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }

        txtOutput.setText(join("\n\n", subResults));
    }

    private String[] getSentences() {
        return txtText.getText().split("[.!?]");
    }
}
