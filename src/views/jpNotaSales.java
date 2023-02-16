/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import koneksi.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ROBBY
 */
public class jpNotaSales extends javax.swing.JPanel {

    /**
     * Creates new form jpMasterSales
     */
    
    Statement stm;
    DefaultTableModel model,  modelInsertSales;
    
    public jpNotaSales() {
        initComponents();
        //System.out.println("test");
        dataTable("","");
        dataTableInsertSales("","");
        
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");  
        Date date = new Date();
        jDateNota.setDate(date);
        
        jTxtKode.setText(idGenerate(""));
        jBtnLunas.setEnabled(false);
        jBtnHapus.setEnabled(false);
    }
    
    public void dataTable(String id_nota, String id_sales){
        ((DefaultTableModel)jTblNotaSales.getModel()).setRowCount(0);
        model = (DefaultTableModel)jTblNotaSales.getModel() ;
  
        NumberFormat formatNum = NumberFormat.getInstance();
        String query = "SELECT * FROM notasales n, sales s "
                + "WHERE n.id_sales = s.id_sales ";       
//        if(!id_kategori.equals("")){
//            query += "WHERE id_kategori LIKE '%" + jTxtKeyword.getText() + "%'";
//        }
//        
//        if(!nama_kategori.equals("")){
//            query += "WHERE nama_kategori LIKE '%" + jTxtKeyword.getText() + "%'";
//        }
        try{
            Connection con = koneksi.getConnection();
            stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);
            while (res.next()){
                String res_id_nota = res.getString("n.id_nota");
                String res_nama_sales = res.getString("s.nama_sales");
                String res_total = formatNum.format(res.getInt("n.total"));
                String res_tgl_pelunasan = res.getString("n.tanggal_pelunasan"); 
                String res_remark= res.getString("n.remark");
                String res_created_at = res.getString("n.created_at");
                String res_updated_at = res.getString("n.updated_at");
                
                String[] data = {res_id_nota, res_nama_sales, res_total, res_tgl_pelunasan, res_remark, res_created_at,res_updated_at};
                model.addRow(data);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void dataTableInsertSales(String id_sales, String nama_sales){
        ((DefaultTableModel)jTblInsSales.getModel()).setRowCount(0);
        modelInsertSales = (DefaultTableModel)jTblInsSales.getModel() ;
  
        String query = "SELECT * FROM sales " 
              + "WHERE id_sales LIKE '%" + id_sales + "%' "
              + "AND nama_sales LIKE '%" + nama_sales + "%'";
        
        try{
            Connection con = koneksi.getConnection();
            stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);
            while (res.next()){
                String res_id_sales = res.getString("id_sales");
                String res_nama_sales = res.getString("nama_sales");
                
                String[] data = {res_id_sales,res_nama_sales};
                modelInsertSales.addRow(data);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void clearTxt(){
        jTxtKode.setText(idGenerate(""));
        jTxtKeyInsSales.setText("");
        jTxtNamaSales.setText("");
        jTxtTotalNota.setText("");
        jTxtAreaRemark.setText("");
        dataTableInsertSales("","");
    }

     public String idGenerate(String id_sales){
        String query = "SELECT COUNT(*) as ctr FROM notasales ";
       
        if (!id_sales.equals("")) {
            query += "WHERE id_sales='" + id_sales + "'";
        }else{
            return "XX";
        }
        
        try{
            Connection con = koneksi.getConnection();
            stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);
            res.next();
            int ctr = res.getInt("ctr") + 1;
//            
//            if(ctr < 10){
//                return "KA0000" + Integer.toString(ctr);
//            }else if(ctr < 100){
//                return "KA000" + Integer.toString(ctr);
//            }else if(ctr < 1000){
//                return "KA00" + Integer.toString(ctr);
//            }else if(ctr < 10000){
//                return "KA0" + Integer.toString(ctr);
//            }else{
//               return "KA" + Integer.toString(ctr);
//            }
//            
            SimpleDateFormat formatDate = new SimpleDateFormat("ddMMyyyy");
            String tangggal_nota1 = formatDate.format(jDateNota.getDate()).substring(0,4);
            String tangggal_nota2 = formatDate.format(jDateNota.getDate()).substring(6,8);
            
            if (ctr < 10) {
                 return tangggal_nota1 + tangggal_nota2 + "_0" + String.valueOf(ctr);
            }else{
                return tangggal_nota1 + tangggal_nota2 + "_" + String.valueOf(ctr);
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
        jTxtNamaSales = new javax.swing.JTextField();
        jBtnTambah = new javax.swing.JButton();
        jBtnLunas = new javax.swing.JButton();
        jBtnHapus = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jCbbFilterKeyword = new javax.swing.JComboBox<>();
        jTxtKeyword = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblNotaSales = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTblInsSales = new javax.swing.JTable();
        jTxtKeyInsSales = new javax.swing.JTextField();
        jCbbKeyInsSales = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jDateLunas = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTxtAreaRemark = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jDateNota = new com.toedter.calendar.JDateChooser();
        jTxtKode = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTxtTotalNota = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1459, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Tanggal Pelunasan");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        jLabel3.setText("Total");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jTxtNamaSales.setEnabled(false);
        jTxtNamaSales.setNextFocusableComponent(this);
        add(jTxtNamaSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 330, -1));

        jBtnTambah.setText("Tambah");
        jBtnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTambahActionPerformed(evt);
            }
        });
        add(jBtnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 530, 90, -1));

        jBtnLunas.setText("Lunas");
        jBtnLunas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLunasActionPerformed(evt);
            }
        });
        add(jBtnLunas, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 530, 90, -1));

        jBtnHapus.setText("Hapus");
        jBtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHapusActionPerformed(evt);
            }
        });
        add(jBtnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 530, 90, -1));

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

        jTblNotaSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Nota", "Nama Sales", "Total", "Tanggal Pelunasan", "Remark", "created_at", "updated_at"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblNotaSales.getTableHeader().setReorderingAllowed(false);
        jTblNotaSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTblNotaSalesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTblNotaSales);
        if (jTblNotaSales.getColumnModel().getColumnCount() > 0) {
            jTblNotaSales.getColumnModel().getColumn(0).setMinWidth(0);
            jTblNotaSales.getColumnModel().getColumn(0).setMaxWidth(200);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 67, 950, 650));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("NOTA SALES");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 17, -1, -1));

        jTblInsSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Sales", "Nama Sales"
            }
        ));
        jTblInsSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTblInsSalesMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTblInsSales);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 440, 170));

        jTxtKeyInsSales.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxtKeyInsSalesKeyReleased(evt);
            }
        });
        add(jTxtKeyInsSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 220, -1));

        jCbbKeyInsSales.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Sales", "Id Sales" }));
        add(jCbbKeyInsSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 210, -1));

        jLabel6.setText("Remark");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, -1));

        jLabel7.setText("Id Nota");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jDateLunas.setEnabled(false);
        add(jDateLunas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 330, -1));

        jTxtAreaRemark.setColumns(20);
        jTxtAreaRemark.setRows(5);
        jScrollPane2.setViewportView(jTxtAreaRemark);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 330, -1));

        jLabel8.setText("Tanggal Nota");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel9.setText("Tanggal Nota");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jDateNota.setDateFormatString("dd/MM/yyyy");
        jDateNota.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateNotaPropertyChange(evt);
            }
        });
        add(jDateNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 330, -1));

        jTxtKode.setEnabled(false);
        jTxtKode.setNextFocusableComponent(this);
        add(jTxtKode, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 330, -1));

        jLabel10.setText("Nama Sales");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));
        add(jTxtTotalNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 330, -1));
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
                        + "WHERE id_kategori='" + jTxtNamaSales.getText() + "'";

                stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Berhasil Hapus Data");

                dataTable("","");
                jTxtNamaSales.setText(idGenerate(""));
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
             if(jTxtNamaSales.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Data ada yang Kosong", "Pesan", JOptionPane.ERROR_MESSAGE);
             }
             else{
                int idx = jTblInsSales.getSelectedRow();
                String id_sales = modelInsertSales.getValueAt(idx, 0).toString();
                
                stm = con.createStatement();
                String query = "INSERT INTO notasales(id_nota, id_sales, total, remark, status) "
                        + "VALUES('" + jTxtKode.getText() + "', "
                        + "'" + id_sales + "', "
                        + "'" + jTxtTotalNota.getText()+ "', "
                        + "'" + jTxtAreaRemark.getText() + "', 0)";   
                stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Berhasil Tambah Data");
                    
                dataTable("","");
                clearTxt();
             }
            }
             catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal Tambah Data", "Pesan", JOptionPane.WARNING_MESSAGE);
                e.getStackTrace();
                 System.out.println(e.getMessage());
            }
            
        }else{
            jBtnTambah.setText("Tambah");
            jBtnLunas.setEnabled(false);
            jBtnHapus.setEnabled(false);
            
            jDateNota.setEnabled(true);
            jTxtKeyInsSales.setEnabled(true);
            jTblInsSales.setEnabled(true);
            
            clearTxt();
        }
    }//GEN-LAST:event_jBtnTambahActionPerformed

    private void jBtnLunasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLunasActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog (null," Apakah Anda Yakin Ingin "
        + "Mengubah Data","Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok==0){
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
            Date date = new Date();
            
            Connection con = koneksi.getConnection();
            try {
                
                stm = con.createStatement();
                String query = "UPDATE notasales SET tanggal_pelunasan='" + formatDate.format(jDateLunas.getDate()) + "', ";
                query +=  "remark=" +  jTxtAreaRemark.getText() + ", "
                        + "updated_at='" +  formatDate.format(date) + "' "
                        + "WHERE id_barang='" + jTxtKode.getText() + "'";
                
                stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Berhasil Ubah Data");
                
                dataTable("", "");
                clearTxt();
                
                jDateNota.setEnabled(true);
                jTxtKeyInsSales.setEnabled(true);
                jTblInsSales.setEnabled(true);
            }
             catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal Ubah Data", "Pesan", JOptionPane.WARNING_MESSAGE);
                 System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_jBtnLunasActionPerformed

    private void jTxtKeywordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtKeywordKeyReleased
        // TODO add your handling code here:

        if( jCbbFilterKeyword.getItemAt(jCbbFilterKeyword.getSelectedIndex()).equals("Id Kategori")){
            dataTable(jTxtKeyword.getText(), "");
        }else{
            dataTable("",jTxtKeyword.getText());
        }
    }//GEN-LAST:event_jTxtKeywordKeyReleased

    private void jTblInsSalesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblInsSalesMouseReleased
        // TODO add your handling code here:
        int idx = jTblInsSales.getSelectedRow();
        try {
            String id_sales = modelInsertSales.getValueAt(idx, 0).toString();
            String nama_sales = modelInsertSales.getValueAt(idx, 1).toString();
            jTxtNamaSales.setText(nama_sales);
            jTxtKode.setText(idGenerate(id_sales));
        } catch (Exception e) {
            e.getStackTrace();
        }
    }//GEN-LAST:event_jTblInsSalesMouseReleased

    private void jTxtKeyInsSalesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtKeyInsSalesKeyReleased
        // TODO add your handling code here:
        if( jCbbKeyInsSales.getItemAt(jCbbKeyInsSales.getSelectedIndex()).equals("Id Sales")){
            dataTableInsertSales(jTxtKeyInsSales.getText(), "");
        }else{
            dataTableInsertSales("",jTxtKeyInsSales.getText() );
        }
    }//GEN-LAST:event_jTxtKeyInsSalesKeyReleased

    private void jTblNotaSalesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblNotaSalesMouseReleased
        // TODO add your handling code here:
        
        int idx = jTblNotaSales.getSelectedRow();
        try {
            
            String kode_nota = model.getValueAt(idx, 0).toString();
            String nama_sales = model.getValueAt(idx, 1).toString();
            String total = model.getValueAt(idx, 2).toString();
            
            if (model.getValueAt(idx, 3) != null){
                Date dateLunas = new SimpleDateFormat("dd/MM/yyyy").parse(model.getValueAt(idx, 3).toString());
                 jDateLunas.setDate(dateLunas);
            }
            
            if (model.getValueAt(idx, 4) != null){
                 String remark = model.getValueAt(idx, 4).toString();
                jTxtAreaRemark.setText(remark);
            }
            
            //SET jTXT
            jTxtKode.setText(kode_nota);
            jTxtNamaSales.setText(nama_sales);
            jTxtTotalNota.setText(total.replace(",", ""));
            
            jBtnTambah.setText("Batal");
            jBtnLunas.setEnabled(true);
            jBtnHapus.setEnabled(true);
            
            //SET DISABLE FALSE
            jDateNota.setEnabled(false);
            jTxtKeyInsSales.setEnabled(false);
            jTblInsSales.setEnabled(false); //MASIH BISA DI KLIK
            
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jTblNotaSalesMouseReleased

    private void jDateNotaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateNotaPropertyChange
        // TODO add your handling code here: 
        if ("calendar".equals(evt.getPropertyName())|| "date".equals(evt.getPropertyName())) {
            if (!jTxtNamaSales.getText().equals("")) {
                int idx = jTblInsSales.getSelectedRow();
                String id_sales = modelInsertSales.getValueAt(idx, 0).toString();
                jTxtKode.setText(idGenerate(id_sales));
            }else{
                jTxtKode.setText(idGenerate(""));
            }
         }
    }//GEN-LAST:event_jDateNotaPropertyChange

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnHapus;
    private javax.swing.JButton jBtnLunas;
    private javax.swing.JButton jBtnTambah;
    private javax.swing.JComboBox<String> jCbbFilterKeyword;
    private javax.swing.JComboBox<String> jCbbKeyInsSales;
    private com.toedter.calendar.JDateChooser jDateLunas;
    private com.toedter.calendar.JDateChooser jDateNota;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTblInsSales;
    private javax.swing.JTable jTblNotaSales;
    private javax.swing.JTextArea jTxtAreaRemark;
    private javax.swing.JTextField jTxtKeyInsSales;
    private javax.swing.JTextField jTxtKeyword;
    private javax.swing.JTextField jTxtKode;
    private javax.swing.JTextField jTxtNamaSales;
    private javax.swing.JTextField jTxtTotalNota;
    // End of variables declaration//GEN-END:variables
}
