/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import koneksi.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ROBBY
 */
public class jpMasterSales extends javax.swing.JPanel {

    /**
     * Creates new form jpMasterSales
     */
    
    Statement stm;
    DefaultTableModel model;
    
    public jpMasterSales() {
        initComponents();
        //System.out.println("test");
        dataTable("","");
        jTxtKode.setText(idGenerate());
        jBtnUbah.setEnabled(false);
        jBtnHapus.setEnabled(false);
        
        //VALUE CHANGE TABLE
        jTblSales.getSelectionModel().addListSelectionListener(new ListSelectionListener() {  
            public void valueChanged(ListSelectionEvent e) {  
                //I want something to happen before the row change is triggered on the UI.  
                int idx = jTblSales.getSelectedRow();
                try {
                    String id_sales = model.getValueAt(idx, 0).toString();
                    String nama_sales = model.getValueAt(idx, 1).toString();
                    String alamat_sales = model.getValueAt(idx, 2).toString();
                    String nohp_sales = model.getValueAt(idx, 3).toString();

                    jTxtKode.setText(id_sales);
                    jTxtNama.setText(nama_sales);
                    jTxtAlamat.setText(alamat_sales);
                    jTxtNohp.setText(nohp_sales);

                    jBtnTambah.setText("Batal");
                    jBtnUbah.setEnabled(true);
                    jBtnHapus.setEnabled(true);
                } catch (Exception ex) {
                    ex.getStackTrace();
                }
            }  
        }); 
    }
    
    public void dataTable(String id_sales, String nama_sales){
        ((DefaultTableModel)jTblSales.getModel()).setRowCount(0);
        model = (DefaultTableModel)jTblSales.getModel() ;
   
        String query = "SELECT * FROM sales ";
        
        if(!id_sales.equals("")){
            query += "WHERE id_sales LIKE '%" + jTxtKeyword.getText() + "%'";
        }
        
        if(!nama_sales.equals("")){
            query += "WHERE nama_sales LIKE '%" + jTxtKeyword.getText() + "%'";
        }
        try{
            Connection con = koneksi.getConnection();
            stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);
            while (res.next()){
                String res_id_sales = res.getString("id_sales");
                String res_nama_sales = res.getString("nama_sales");
                String res_alamat_sales = res.getString("alamat_sales");
                String res_nohp_sales = res.getString("nohp_sales");
                String res_created_at = res.getString("created_at");
                String res_updated_at = res.getString("updated_at");
                
                String[] data = {res_id_sales,res_nama_sales,res_alamat_sales,res_nohp_sales,res_created_at,res_updated_at};
                model.addRow(data);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void clearTxt(){
        jTxtNama.setText(null);
        jTxtAlamat.setText(null);
        jTxtNohp.setText(null);
    }

     public String idGenerate(){
        String query = "SELECT COUNT(*) as ctr FROM sales";
        
        try{
            Connection con = koneksi.getConnection();
            stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);
            res.next();
            int ctr = res.getInt("ctr") + 1;
            
            if(ctr < 10){
                return "SA0000" + Integer.toString(ctr);
            }else if(ctr < 100){
                return "SA000" + Integer.toString(ctr);
            }else if(ctr < 1000){
                return "SA00" + Integer.toString(ctr);
            }else if(ctr < 10000){
                return "SA0" + Integer.toString(ctr);
            }else{
               return "SA" + Integer.toString(ctr);
            }
            
        } catch (Exception e){
            return e.getMessage();
        }
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
        jLabel5 = new javax.swing.JLabel();
        jTxtKode = new javax.swing.JTextField();
        jTxtNama = new javax.swing.JTextField();
        jTxtAlamat = new javax.swing.JTextField();
        jTxtNohp = new javax.swing.JTextField();
        jBtnTambah = new javax.swing.JButton();
        jBtnUbah = new javax.swing.JButton();
        jBtnHapus = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jCbbFilterKeyword = new javax.swing.JComboBox<>();
        jTxtKeyword = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblSales = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1459, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Alamat");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel2.setText("Id Sales");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel3.setText("Nama Sales");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel5.setText("No HP");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jTxtKode.setEnabled(false);
        jTxtKode.setNextFocusableComponent(this);
        add(jTxtKode, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 340, -1));

        jTxtNama.setNextFocusableComponent(jTxtAlamat);
        add(jTxtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 340, -1));

        jTxtAlamat.setNextFocusableComponent(jTxtNohp);
        add(jTxtAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 340, -1));

        jTxtNohp.setNextFocusableComponent(jBtnHapus);
        add(jTxtNohp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 340, -1));

        jBtnTambah.setText("Tambah");
        jBtnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTambahActionPerformed(evt);
            }
        });
        add(jBtnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 100, -1));

        jBtnUbah.setText("Ubah");
        jBtnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnUbahActionPerformed(evt);
            }
        });
        add(jBtnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 100, -1));

        jBtnHapus.setText("Hapus");
        jBtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHapusActionPerformed(evt);
            }
        });
        add(jBtnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 100, -1));

        jLabel4.setText("Cari berdasarkan :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, -1, -1));

        jCbbFilterKeyword.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id Sales", "Nama Sales" }));
        add(jCbbFilterKeyword, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 170, -1));

        jTxtKeyword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxtKeywordKeyReleased(evt);
            }
        });
        add(jTxtKeyword, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 680, -1));

        jTblSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Sales", "Nama Sales", "Alamat", "No HP", "created_at", "updated_at"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblSales.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTblSales);
        if (jTblSales.getColumnModel().getColumnCount() > 0) {
            jTblSales.getColumnModel().getColumn(0).setMinWidth(0);
            jTblSales.getColumnModel().getColumn(0).setMaxWidth(200);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 960, 690));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("SALES");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnHapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog (null," Apakah Anda Yakin Ingin "
            + "Menghapus Data","Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok==0){
            Connection con = koneksi.getConnection();
            try {
                stm = con.createStatement();
                String query = "UPDATE sales SET status=-1 "
                        + "WHERE id_sales='" + jTxtKode.getText() + "'";

                stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Berhasil Hapus Data");

                dataTable("","");
                jTxtKode.setText(idGenerate());
                clearTxt();
            }
             catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal Hapus Data", "Pesan", JOptionPane.WARNING_MESSAGE);
                 System.out.println(e.getMessage());
            }
        }
        
    }//GEN-LAST:event_jBtnHapusActionPerformed
    
    private void jBtnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTambahActionPerformed
        // TODO add your handling code here:
        if(jBtnTambah.getText().equals("Tambah")){
            Connection con = koneksi.getConnection();
            try {
             if(jTxtNama.getText().equals("")||
                jTxtAlamat.getText().equals("")||
                jTxtNohp.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Data ada yang Kosong", "Pesan", JOptionPane.ERROR_MESSAGE);
             }
             else{
                stm = con.createStatement();
                String query = "INSERT INTO sales(id_sales, nama_sales, alamat_sales, nohp_sales, status) "
                        + "VALUES('" + idGenerate() + "', "
                        + "'" + jTxtNama.getText() + "', "
                        + "'" + jTxtAlamat.getText() + "', "
                        + "'" + jTxtNohp.getText() + "',0)";   
                stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Berhasil Tambah Data");
                    
                dataTable("","");
                jTxtKode.setText(idGenerate());
                clearTxt();
             }
            }
             catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal Tambah Data", "Pesan", JOptionPane.WARNING_MESSAGE);
                 System.out.println(e.getMessage());
            }
        }else{
            jBtnTambah.setText("Tambah");
            jBtnUbah.setEnabled(false);
            jBtnHapus.setEnabled(false);
            clearTxt();
            jTxtKode.setText(idGenerate());
            dataTable("","");
        }
    }//GEN-LAST:event_jBtnTambahActionPerformed

    private void jBtnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnUbahActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog (null," Apakah Anda Yakin Ingin "
        + "Mengubah Data","Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok==0){
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
            Date date = new Date();
            Connection con = koneksi.getConnection();
            try {
             if(jTxtNama.getText().equals("")||
                jTxtAlamat.getText().equals("")||
                jTxtNohp.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Data ada yang Kosong", "Pesan", JOptionPane.ERROR_MESSAGE);
             }
             else{
                stm = con.createStatement();
                String query = "UPDATE sales SET nama_sales='" + jTxtNama.getText() + "', "
                                            + "alamat_sales='" +  jTxtAlamat.getText() +"', "
                                            + "nohp_sales='" + jTxtNohp.getText()  + "', "
                                            + "updated_at='" +  formatDate.format(date) + "' "
                        + "WHERE id_sales='" + jTxtKode.getText() + "'";

                stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Berhasil Ubah Data");

                dataTable("","");
                jTxtKode.setText(idGenerate());
                clearTxt();

             }
            }
             catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal Ubah Data", "Pesan", JOptionPane.WARNING_MESSAGE);
                 System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_jBtnUbahActionPerformed

    private void jTxtKeywordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtKeywordKeyReleased
        // TODO add your handling code here:
        if( jCbbFilterKeyword.getItemAt(jCbbFilterKeyword.getSelectedIndex()).equals("Id Sales")){
            dataTable(jTxtKeyword.getText(), "");
        }else{
            dataTable("",jTxtKeyword.getText());
        }
    }//GEN-LAST:event_jTxtKeywordKeyReleased

     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnHapus;
    private javax.swing.JButton jBtnTambah;
    private javax.swing.JButton jBtnUbah;
    private javax.swing.JComboBox<String> jCbbFilterKeyword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblSales;
    private javax.swing.JTextField jTxtAlamat;
    private javax.swing.JTextField jTxtKeyword;
    private javax.swing.JTextField jTxtKode;
    private javax.swing.JTextField jTxtNama;
    private javax.swing.JTextField jTxtNohp;
    // End of variables declaration//GEN-END:variables
}
