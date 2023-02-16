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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ROBBY
 */
public class jpMasterKategori extends javax.swing.JPanel {

    /**
     * Creates new form jpMasterSales
     */
    
    Statement stm;
    DefaultTableModel model;
    
    public jpMasterKategori() {
        initComponents();
        //System.out.println("test");
        dataTable("","");
        jTxtKode.setText(idGenerate());
        jBtnUbah.setEnabled(false);
        jBtnHapus.setEnabled(false);
    }
    
    public void dataTable(String id_kategori, String nama_kategori){
        //Object[] row = {"Id Sales","Nama Sales","Alamat","No HP","Created_at","Updated_at"};
        //model = new DefaultTableModel(null, row);
        ((DefaultTableModel)jTblKategori.getModel()).setRowCount(0);
        model = (DefaultTableModel)jTblKategori.getModel() ;
        //jTblSales.setModel(model);
        String query = "SELECT * FROM kategori ";
        
        if(!id_kategori.equals("")){
            query += "WHERE id_kategori LIKE '%" + jTxtKeyword.getText() + "%'";
        }
        
        if(!nama_kategori.equals("")){
            query += "WHERE nama_kategori LIKE '%" + jTxtKeyword.getText() + "%'";
        }
        try{
            Connection con = koneksi.getConnection();
            stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);
            while (res.next()){
                String res_id_kategori = res.getString("id_kategori");
                String res_nama_kategori = res.getString("nama_kategori");
                String res_created_at = res.getString("created_at");
                String res_updated_at = res.getString("updated_at");
                
                String[] data = {res_id_kategori,res_nama_kategori,res_created_at,res_updated_at};
                model.addRow(data);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void noTable(){
        int row = model.getRowCount();
        for (int i = 0; i < row; i++)
        {
            String nomor = String.valueOf(i+1);
            model.setValueAt(nomor +".",i,0);
        }
    }
    
    public void clearTxt(){
        jTxtNama.setText(null);
    }

     public String idGenerate(){
        String query = "SELECT COUNT(*) as ctr FROM kategori";
        
        try{
            Connection con = koneksi.getConnection();
            stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);
            res.next();
            int ctr = res.getInt("ctr") + 1;
            
            if(ctr < 10){
                return "KA0000" + Integer.toString(ctr);
            }else if(ctr < 100){
                return "KA000" + Integer.toString(ctr);
            }else if(ctr < 1000){
                return "KA00" + Integer.toString(ctr);
            }else if(ctr < 10000){
                return "KA0" + Integer.toString(ctr);
            }else{
               return "KA" + Integer.toString(ctr);
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTxtKode = new javax.swing.JTextField();
        jTxtNama = new javax.swing.JTextField();
        jBtnTambah = new javax.swing.JButton();
        jBtnUbah = new javax.swing.JButton();
        jBtnHapus = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jCbbFilterKeyword = new javax.swing.JComboBox<>();
        jTxtKeyword = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblKategori = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1459, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Id Kategori");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 70, -1, -1));

        jLabel3.setText("Nama Kategori");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 104, -1, -1));

        jTxtKode.setEnabled(false);
        jTxtKode.setNextFocusableComponent(this);
        add(jTxtKode, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 340, -1));
        add(jTxtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 340, -1));

        jBtnTambah.setText("Tambah");
        jBtnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTambahActionPerformed(evt);
            }
        });
        add(jBtnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 100, -1));

        jBtnUbah.setText("Ubah");
        jBtnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnUbahActionPerformed(evt);
            }
        });
        add(jBtnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 100, -1));

        jBtnHapus.setText("Hapus");
        jBtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHapusActionPerformed(evt);
            }
        });
        add(jBtnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 100, -1));

        jLabel4.setText("Cari berdasarkan :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, -1, -1));

        jCbbFilterKeyword.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id Kategori", "Nama Kategori" }));
        add(jCbbFilterKeyword, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 150, -1));

        jTxtKeyword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxtKeywordKeyReleased(evt);
            }
        });
        add(jTxtKeyword, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 680, -1));

        jTblKategori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Kategori", "Nama Kategori", "created_at", "updated_at"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblKategori.getTableHeader().setReorderingAllowed(false);
        jTblKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblKategoriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblKategori);
        if (jTblKategori.getColumnModel().getColumnCount() > 0) {
            jTblKategori.getColumnModel().getColumn(0).setMinWidth(0);
            jTblKategori.getColumnModel().getColumn(0).setMaxWidth(200);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 67, 950, 720));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("KATEGORI BARANG");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 17, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnHapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog (null," Apakah Anda Yakin Ingin "
            + "Menghapus Data","Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok==0){
            Connection con = koneksi.getConnection();
            try {
                stm = con.createStatement();
                String query = "UPDATE kategori SET status=-1 "
                        + "WHERE id_kategori='" + jTxtKode.getText() + "'";

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
             if(jTxtNama.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Data ada yang Kosong", "Pesan", JOptionPane.ERROR_MESSAGE);
             }
             else{
                stm = con.createStatement();
                String query = "INSERT INTO kategori(id_kategori, nama_kategori, status) "
                        + "VALUES('" + idGenerate() + "', "
                        + "'" + jTxtNama.getText() + "',0)";   
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
             if(jTxtNama.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Data ada yang Kosong", "Pesan", JOptionPane.ERROR_MESSAGE);
             }
             else{
                stm = con.createStatement();
                String query = "UPDATE kategori SET nama_kategori='" + jTxtNama.getText() + "', "
                                            + "updated_at='" +  formatDate.format(date) + "' "
                        + "WHERE id_kategori='" + jTxtKode.getText() + "'";

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

    private void jTblKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblKategoriMouseClicked
        // TODO add your handling code here:
        int idx = jTblKategori.getSelectedRow();
        
        try {
            String id_kategori = model.getValueAt(idx, 0).toString();
            String nama_kategori = model.getValueAt(idx, 1).toString();
            
            jTxtKode.setText(id_kategori);
            jTxtNama.setText(nama_kategori);
            
            jBtnTambah.setText("Batal");
            jBtnUbah.setEnabled(true);
            jBtnHapus.setEnabled(true);
        } catch (Exception e) {
            
        }
    
    }//GEN-LAST:event_jTblKategoriMouseClicked

    private void jTxtKeywordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtKeywordKeyReleased
        // TODO add your handling code here:

        if( jCbbFilterKeyword.getItemAt(jCbbFilterKeyword.getSelectedIndex()).equals("Id Kategori")){
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblKategori;
    private javax.swing.JTextField jTxtKeyword;
    private javax.swing.JTextField jTxtKode;
    private javax.swing.JTextField jTxtNama;
    // End of variables declaration//GEN-END:variables
}
