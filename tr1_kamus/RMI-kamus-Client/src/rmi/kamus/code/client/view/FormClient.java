/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.kamus.code.client.view;

import java.rmi.RemoteException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;
import rmi.kamus.code.client.table.TableModelKamus;
import rmi.kamus.code.entity.Kamus;
import rmi.kamus.code.service.KamusService;

/**
 *
 * @author ACER
 */
public class FormClient extends javax.swing.JFrame {
    
    private TableModelKamus tableModelKamus = new TableModelKamus();
    
    
    private KamusService service;

    /**
     * Creates new form FormClient
     */
    public FormClient(KamusService service) {
        this.service = service;
        
        try {
            tableModelKamus.setData(service.getAllKamus());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        initComponents();
        
        tableKamus.setModel(tableModelKamus);
        tableKamus.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = tableKamus.getSelectedRow();
                if (row != -1) {
                    Kamus Kamus = tableModelKamus.get(row);
                    
                    txtNomor.setText(Kamus.getNomor());
                    txtKataIndo.setText(Kamus.getKata_indonesia());
                    comboJenis.setSelectedItem(Kamus.getJenis());
                    txtKataInggris.setText(Kamus.getKata_inggris());
                    
                }
            }
        });
    }
    
    private FormClient() {
        throw new UnsupportedOperationException("not supported yet.");
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        buttonInsert = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonRefresh = new javax.swing.JButton();
        buttonSearch = new javax.swing.JButton();
        txtNomor = new javax.swing.JTextField();
        txtKataIndo = new javax.swing.JTextField();
        txtKataInggris = new javax.swing.JTextField();
        comboJenis = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableKamus = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("kamus");

        jLabel2.setText("nomor");

        jLabel3.setText("kata(indonesia)");

        jLabel4.setText("jenis");

        jLabel5.setText("kata(inggris)");

        buttonInsert.setText("Insert");
        buttonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInsertActionPerformed(evt);
            }
        });

        buttonUpdate.setText("Update");
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });

        buttonDelete.setText("Delete");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        buttonRefresh.setText("Refresh");
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });

        buttonSearch.setText("Search");
        buttonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchActionPerformed(evt);
            }
        });

        comboJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "kata kerja", "kata benda", "kata ganti", "kata bilangan", "kata sifat", "kata penghubung" }));

        tableKamus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableKamus);

        jLabel6.setText("by: derryl-mikael-alfendio-gilang");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtKataIndo))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonInsert)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(buttonSearch))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKataInggris)
                            .addComponent(txtSearch)
                            .addComponent(txtNomor)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buttonUpdate)
                                        .addGap(33, 33, 33)
                                        .addComponent(buttonDelete)
                                        .addGap(31, 31, 31)
                                        .addComponent(buttonRefresh)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtKataIndo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtKataInggris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonInsert)
                    .addComponent(buttonUpdate)
                    .addComponent(buttonDelete)
                    .addComponent(buttonRefresh))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
        // TODO add your handling code here:
        refresh();
        JOptionPane.showMessageDialog(null, "refresh...");
    }//GEN-LAST:event_buttonRefreshActionPerformed

    private void buttonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsertActionPerformed
        // TODO add your handling code here:
        try {
            Kamus kamus = new Kamus();
        
        
            kamus.setNomor(txtNomor.getText());
            kamus.setKata_indonesia(txtKataIndo.getText());
            kamus.setJenis((String) comboJenis.getSelectedItem());
            kamus.setKata_inggris(txtKataInggris.getText());
        
            Kamus kamus1 = service.insertKamus(kamus);
        
            //JOptionPane.showMessageDialog(null, kamus1.getLaporan());
            refresh();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        
       
    }//GEN-LAST:event_buttonInsertActionPerformed

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        // TODO add your handling code here:
        try {
            
            Kamus kamus = new Kamus();
            
            kamus.setNomor(txtNomor.getText());
            kamus.setKata_indonesia(txtKataIndo.getText());
            kamus.setJenis((String) comboJenis.getSelectedItem());
            kamus.setKata_inggris(txtKataInggris.getText());
            
            
            Kamus kamus1 = service.updateKamus(kamus);
            
            //JOptionPane.showMessageDialog(null, kamus1.getLaporan());
            refresh();
            
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        // TODO add your handling code here:
        try {
            
            Kamus kamus = new Kamus();
            
            kamus.setNomor(txtNomor.getText());
            
            Kamus kamus1 = service.deleteKamus(kamus);
            
            //JOptionPane.showMessageDialog(null, kamus1.getLaporan());
            refresh();
            
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchActionPerformed
        // TODO add your handling code here:
        TableRowSorter rowSorter = new TableRowSorter(tableModelKamus);
        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            
            public void insertUpdate(DocumentEvent e) {
                tableKamus.setRowSorter(rowSorter);
                rowSorter.setRowFilter(RowFilter.regexFilter(txtSearch.getText()));
            }
            
            public void removeUpdate(DocumentEvent e) {
                tableKamus.setRowSorter(rowSorter);
                rowSorter.setRowFilter(RowFilter.regexFilter(txtSearch.getText()));
            }
            
            public void changedUpdate(DocumentEvent e) {
                tableKamus.setRowSorter(rowSorter);
                rowSorter.setRowFilter(RowFilter.regexFilter(txtSearch.getText()));
            }
        });
    }//GEN-LAST:event_buttonSearchActionPerformed

    
    public void refresh() {
        txtNomor.setText("");
        txtKataIndo.setText("");
        txtKataInggris.setText("");
        
        try {
           
            List<Kamus> list = service.getAllKamus();
            tableModelKamus.setData(list);
            return; 
            
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
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
            java.util.logging.Logger.getLogger(FormClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonInsert;
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JButton buttonSearch;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JComboBox<String> comboJenis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableKamus;
    private javax.swing.JTextField txtKataIndo;
    private javax.swing.JTextField txtKataInggris;
    private javax.swing.JTextField txtNomor;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
