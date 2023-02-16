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
public class jpMasterBarang extends javax.swing.JPanel {

    /**
     * Creates new form jpMasterSales
     */
    
    Statement stm;
    DefaultTableModel model, modelInsertSales, modelInsertKategori, modelFilterSales, modelFilterKategori ;
    String filterSales = "";
    String filterKategori = "";
    
    public jpMasterBarang() {
        initComponents();
        //System.out.println("test");
        dataTable("","","","");
        dataTableInsertSales("","");
        dataTableInsertKategori("","");
        dataTableFilterSales("","");
        dataTableFilterKategori("","");
        jTxtKode.setText(idGenerate());
        jBtnUbah.setEnabled(false);
        jBtnHapus.setEnabled(false);
    }
    
    public void dataTable(String id_barang, String id_kategori, String id_sales, String nama_barang){
        ((DefaultTableModel)jTblBarang.getModel()).setRowCount(0);
        model = (DefaultTableModel)jTblBarang.getModel() ;
     
        NumberFormat formatNum = NumberFormat.getInstance();
        String query = "SELECT * FROM barang b, sales s, kategori k "
                + "WHERE b.id_sales = s.id_sales "
                + "AND   b.id_kategori = k.id_kategori ";
        
        if(!id_kategori.equals("")){
           query += "AND b.id_kategori = '" + id_kategori + "' ";
        }
        if(!id_sales.equals("")){
           query +=  "AND   b.id_sales = '" + id_sales + "' ";
        }
        query += "AND   b.nama_barang LIKE '%" + nama_barang + "%' ";
        
        try{
            Connection con = koneksi.getConnection();
            stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);
            while (res.next()){
                String res_id_barang = res.getString("b.id_barang");
                String res_nama_sales = res.getString("s.nama_sales");
                String res_nama_kategori = res.getString("k.nama_kategori");
                String res_nama_barang = res.getString("b.nama_barang");
                String res_harga_pokok = formatNum.format(res.getInt("b.harga_pokok"));
                String res_harga_jual = formatNum.format(res.getInt("b.harga_jual"));
                String res_created_at = res.getString("b.created_at");
                String res_updated_at = res.getString("b.updated_at");
                
                String[] data = {res_id_barang, res_nama_barang, res_nama_kategori, res_nama_sales, 
                    res_harga_pokok, res_harga_jual, res_created_at, res_updated_at};
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
    
    public void dataTableInsertKategori(String id_kategori, String nama_kategori){
        ((DefaultTableModel)jTblInsKategori.getModel()).setRowCount(0);
        modelInsertKategori = (DefaultTableModel)jTblInsKategori.getModel() ;
  
        String query = "SELECT * FROM kategori " 
              + "WHERE id_kategori LIKE '%" + id_kategori + "%' "
              + "AND nama_kategori LIKE '%" + nama_kategori + "%'";
        
        try{
            Connection con = koneksi.getConnection();
            stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);
            while (res.next()){
                String res_id_kategori = res.getString("id_kategori");
                String res_nama_kategori = res.getString("nama_kategori");
                
                String[] data = {res_id_kategori,res_nama_kategori};
                modelInsertKategori.addRow(data);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void dataTableFilterSales(String id_sales, String nama_sales){
        ((DefaultTableModel)jTblFilSales.getModel()).setRowCount(0);
        modelFilterSales = (DefaultTableModel)jTblFilSales.getModel() ;
  
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
                modelFilterSales.addRow(data);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void dataTableFilterKategori(String id_kategori, String nama_kategori){
        ((DefaultTableModel)jTblFilKategori.getModel()).setRowCount(0);
        modelFilterKategori = (DefaultTableModel)jTblFilKategori.getModel() ;
  
        String query = "SELECT * FROM kategori " 
              + "WHERE id_kategori LIKE '%" + id_kategori + "%' "
              + "AND nama_kategori LIKE '%" + nama_kategori + "%'";
        
        try{
            Connection con = koneksi.getConnection();
            stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);
            while (res.next()){
                String res_id_kategori = res.getString("id_kategori");
                String res_nama_kategori = res.getString("nama_kategori");
                
                String[] data = {res_id_kategori,res_nama_kategori};
                modelFilterKategori.addRow(data);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    
    public void clearTxt(){
        jTxtNamaBarang.setText(null);
        jTxtHargaPokok.setText(null);
        jTxtHargaJual.setText(null);
    }

     public String idGenerate(){
        String query = "SELECT COUNT(*) as ctr FROM barang";
        
        try{
            Connection con = koneksi.getConnection();
            stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);
            res.next();
            int ctr = res.getInt("ctr") + 1;
            
            if(ctr < 10){
                return "BA0000" + Integer.toString(ctr);
            }else if(ctr < 100){
                return "BA000" + Integer.toString(ctr);
            }else if(ctr < 1000){
                return "BA00" + Integer.toString(ctr);
            }else if(ctr < 10000){
                return "BA0" + Integer.toString(ctr);
            }else{
               return "BA" + Integer.toString(ctr);
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

        jLabel4 = new javax.swing.JLabel();
        jCbbKeyInsKategori = new javax.swing.JComboBox<>();
        jTxtKeyword = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblBarang = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTblInsSales = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTblInsKategori = new javax.swing.JTable();
        jBtnTambah = new javax.swing.JButton();
        jBtnUbah = new javax.swing.JButton();
        jBtnHapus = new javax.swing.JButton();
        jTxtHargaJual = new javax.swing.JTextField();
        jTxtNamaKategori = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTxtKode = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTxtNamaBarang = new javax.swing.JTextField();
        jTxtKeyInsKategori = new javax.swing.JTextField();
        jTxtNamaSales = new javax.swing.JTextField();
        jTxtKeyInsSales = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jCbbFilterKeyword = new javax.swing.JComboBox<>();
        jCbbKeyInsSales = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTxtHargaPokok = new javax.swing.JTextField();
        jCbbKeyFilSales = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTblFilSales = new javax.swing.JTable();
        jTxtKeyFilSales = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTblFilKategori = new javax.swing.JTable();
        jTxtKeyFilKategori = new javax.swing.JTextField();
        jCbbKeyFilKategori = new javax.swing.JComboBox<>();
        jBtnResetFilter = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1920, 597));
        setPreferredSize(new java.awt.Dimension(1459, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Cari berdasarkan :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, 20));

        jCbbKeyInsKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Kategori", "Id Kategori", " " }));
        add(jCbbKeyInsKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 100, -1));

        jTxtKeyword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxtKeywordKeyReleased(evt);
            }
        });
        add(jTxtKeyword, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 660, -1));

        jTblBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Barang", "Nama Barang", "Nama Kategori", "Nama Sales", "Harga Pokok", "Harga Jual", "created_at", "updated_at"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblBarang.getTableHeader().setReorderingAllowed(false);
        jTblBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTblBarangMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTblBarang);
        if (jTblBarang.getColumnModel().getColumnCount() > 0) {
            jTblBarang.getColumnModel().getColumn(0).setMinWidth(0);
            jTblBarang.getColumnModel().getColumn(0).setMaxWidth(200);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 990, 740));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Filter Barang");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

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

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 220, 170));

        jTblInsKategori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Kategori", "Nama Kategori"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblInsKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTblInsKategoriMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTblInsKategori);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 220, 170));

        jBtnTambah.setText("Tambah");
        jBtnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTambahActionPerformed(evt);
            }
        });
        add(jBtnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 460, 100, -1));

        jBtnUbah.setText("Ubah");
        jBtnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnUbahActionPerformed(evt);
            }
        });
        add(jBtnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, 100, -1));

        jBtnHapus.setText("Hapus");
        jBtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHapusActionPerformed(evt);
            }
        });
        add(jBtnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 100, -1));
        add(jTxtHargaJual, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 340, -1));

        jTxtNamaKategori.setEnabled(false);
        jTxtNamaKategori.setNextFocusableComponent(jTxtHargaJual);
        add(jTxtNamaKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 340, -1));

        jLabel3.setText("Nama Sales");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        jTxtKode.setEnabled(false);
        jTxtKode.setNextFocusableComponent(this);
        add(jTxtKode, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 57, 340, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("BARANG");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel1.setText("Harga Jual");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        jLabel8.setText("Nama Kategori");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        jLabel9.setText("Nama Barang");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        jTxtNamaBarang.setNextFocusableComponent(jTxtHargaJual);
        add(jTxtNamaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 340, -1));

        jTxtKeyInsKategori.setNextFocusableComponent(jTxtHargaJual);
        jTxtKeyInsKategori.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxtKeyInsKategoriKeyReleased(evt);
            }
        });
        add(jTxtKeyInsKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 110, -1));

        jTxtNamaSales.setEnabled(false);
        jTxtNamaSales.setNextFocusableComponent(jTxtHargaJual);
        add(jTxtNamaSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 340, -1));

        jTxtKeyInsSales.setNextFocusableComponent(jTxtHargaJual);
        jTxtKeyInsSales.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxtKeyInsSalesKeyReleased(evt);
            }
        });
        add(jTxtKeyInsSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 110, -1));

        jLabel10.setText("Id Barang");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jCbbFilterKeyword.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Barang", "Id Barang" }));
        add(jCbbFilterKeyword, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 210, -1));

        jCbbKeyInsSales.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Sales", "Id Sales" }));
        add(jCbbKeyInsSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 100, -1));

        jLabel2.setText("Harga Pokok");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));
        add(jTxtHargaPokok, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 340, -1));

        jCbbKeyFilSales.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Sales", "Id Sales" }));
        add(jCbbKeyFilSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 540, 100, -1));

        jTblFilSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Sales", "Nama Sales"
            }
        ));
        jTblFilSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTblFilSalesMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jTblFilSales);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 570, 220, 170));

        jTxtKeyFilSales.setNextFocusableComponent(jTxtHargaJual);
        jTxtKeyFilSales.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxtKeyFilSalesKeyReleased(evt);
            }
        });
        add(jTxtKeyFilSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 540, 110, -1));

        jTblFilKategori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Kategori", "Nama Kategori"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblFilKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTblFilKategoriMouseReleased(evt);
            }
        });
        jScrollPane5.setViewportView(jTblFilKategori);

        add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 220, 170));

        jTxtKeyFilKategori.setNextFocusableComponent(jTxtHargaJual);
        jTxtKeyFilKategori.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxtKeyFilKategoriKeyReleased(evt);
            }
        });
        add(jTxtKeyFilKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 110, -1));

        jCbbKeyFilKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Kategori", "Id Kategori" }));
        add(jCbbKeyFilKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 100, -1));

        jBtnResetFilter.setText("Reset Filter");
        jBtnResetFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnResetFilterActionPerformed(evt);
            }
        });
        add(jBtnResetFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 750, 100, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnHapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog (null," Apakah Anda Yakin Ingin "
            + "Menghapus Data","Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok==0){
            Connection con = koneksi.getConnection();
            try {
                stm = con.createStatement();
                String query = "UPDATE barang SET status=-1 "
                        + "WHERE id_barang='" + jTxtKode.getText() + "'";

                stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Berhasil Hapus Data");

                dataTable("","","","");
                dataTableInsertSales("","");
                dataTableInsertKategori("","");
                jTxtKode.setText(idGenerate());
                jTxtNamaKategori.setText("");
                jTxtNamaSales.setText("");
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
             if(jTxtNamaBarang.getText().equals("")||
                jTxtNamaSales.getText().equals("")||
                jTxtNamaKategori.getText().equals("")||
                jTxtHargaPokok.getText().equals("")||
                jTxtHargaJual.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Data ada yang Kosong", "Pesan", JOptionPane.ERROR_MESSAGE);
             }
             else{
                int idx = jTblInsSales.getSelectedRow();
                String id_sales = modelInsertSales.getValueAt(idx, 0).toString();
                idx = jTblInsKategori.getSelectedRow();
                String id_kategori = modelInsertKategori.getValueAt(idx, 0).toString();
                
                stm = con.createStatement();
                String query = "INSERT INTO barang(id_barang, id_kategori, id_sales, nama_barang, harga_pokok, harga_jual, status) "
                        + "VALUES('" + idGenerate() + "', "
                        + "'" + id_kategori + "', "
                        + "'" + id_sales + "', "
                         + "'" + jTxtNamaBarang.getText() + "', "
                        + "'" + jTxtHargaPokok.getText() + "', "
                        + "'" + jTxtHargaJual.getText() + "',0)";   
                stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Berhasil Tambah Data");
                    
                dataTable("","","","");
                jTxtKode.setText(idGenerate());
                clearTxt();
             }
            }
             catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal Tambah Data", "Pesan", JOptionPane.WARNING_MESSAGE);
                e.getStackTrace();
            }
        }else{
            jBtnTambah.setText("Tambah");
            jBtnUbah.setEnabled(false);
            jBtnHapus.setEnabled(false);
            clearTxt();
            jTxtKode.setText(idGenerate());
            dataTableInsertSales("","");
            dataTableInsertKategori("","");
            jTxtNamaKategori.setText("");
            jTxtNamaSales.setText("");
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
             if(jTxtNamaKategori.getText().equals("")||
                jTxtHargaJual.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Data ada yang Kosong", "Pesan", JOptionPane.ERROR_MESSAGE);
             }
             else{
                 
                int idxSales = jTblInsSales.getSelectedRow();
                int idxKategori = jTblInsKategori.getSelectedRow();
                stm = con.createStatement();
                String query = "UPDATE barang SET nama_barang='" + jTxtNamaKategori.getText() + "', ";
                
                if(idxKategori != -1){
                    query += "id_kategori='" +  modelInsertKategori.getValueAt(idxKategori, 0).toString() +"', ";
                }
                if(idxSales != -1){
                    query += "id_sales='" +  modelInsertSales.getValueAt(idxSales, 0).toString() +"', ";
                }
               
                
                query +=  "nama_barang='" +  jTxtNamaBarang.getText() +"', "
                        + "harga_pokok=" +  jTxtHargaPokok.getText() + ", "
                        + "harga_jual=" +  jTxtHargaJual.getText() + ", "
                        + "updated_at='" +  formatDate.format(date) + "' "
                        + "WHERE id_barang='" + jTxtKode.getText() + "'";
                
                stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Berhasil Ubah Data");

                dataTable("","","","");
                dataTableInsertSales("","");
                dataTableInsertKategori("","");
                dataTableFilterSales("","");
                dataTableFilterKategori("","");
                jTxtKode.setText(idGenerate());
                jTxtNamaKategori.setText("");
                jTxtNamaSales.setText("");
                clearTxt();
                
             }
            }
             catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal Ubah Data", "Pesan", JOptionPane.WARNING_MESSAGE);
                System.out.println(e.getMessage());
                e.getStackTrace();
            }
        }
    }//GEN-LAST:event_jBtnUbahActionPerformed

    
    private void jTxtKeywordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtKeywordKeyReleased
        // TODO add your handling code here:
//        String id_sales = "";
//        if(!jTblFilSales.getSelectionModel().isSelectionEmpty()){
//            int idx = jTblFilSales.getSelectedRow();
//            id_sales = modelFilterSales.getValueAt(idx, 0).toString(); 
//        }
        
        if(jCbbFilterKeyword.getItemAt(jCbbFilterKeyword.getSelectedIndex()).equals("Id Barang")){
            dataTable(jTxtKeyword.getText(),filterKategori,filterSales, "");
        }else{
            dataTable("",filterKategori,filterSales, jTxtKeyword.getText());
        }
    }//GEN-LAST:event_jTxtKeywordKeyReleased

    private void jTblInsSalesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblInsSalesMouseReleased
        // TODO add your handling code here:
        int idx = jTblInsSales.getSelectedRow();
        try {
            String nama_sales = modelInsertSales.getValueAt(idx, 1).toString();
            jTxtNamaSales.setText(nama_sales);
            
        } catch (Exception e) {
            e.getStackTrace();
        }
    }//GEN-LAST:event_jTblInsSalesMouseReleased

    private void jTblInsKategoriMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblInsKategoriMouseReleased
        // TODO add your handling code here:
       int idx = jTblInsKategori.getSelectedRow();
        try {
            String nama_kategori = modelInsertKategori.getValueAt(idx, 1).toString();
            jTxtNamaKategori.setText(nama_kategori);
            
        } catch (Exception e) {
            e.getStackTrace();
        }
    }//GEN-LAST:event_jTblInsKategoriMouseReleased

    private void jTblBarangMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblBarangMouseReleased
        // TODO add your handling code here:
        int idx = jTblBarang.getSelectedRow();
        try {
            
            //GET ID SALES & ID KATEGORI
            String id_barang = model.getValueAt(idx, 0).toString();
            String query = "SELECT * FROM barang "
                + "WHERE id_barang ='" + id_barang +"'";
            
            Connection con = koneksi.getConnection();
            stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);
            res.next();

            String id_kategori = res.getString("id_kategori");
            String id_sales = res.getString("id_sales");
            
          
            String nama_barang = model.getValueAt(idx, 1).toString();
            String nama_kategori = model.getValueAt(idx, 2).toString();
            String nama_sales = model.getValueAt(idx, 3).toString();
            String harga_pokok = model.getValueAt(idx, 4).toString();
            String harga_jual = model.getValueAt(idx, 5).toString();
            
            //SET jTXT
            jTxtKode.setText(id_barang);
            jTxtNamaKategori.setText(nama_kategori);
            jTxtNamaSales.setText(nama_sales);
            jTxtNamaBarang.setText(nama_barang);
            jTxtHargaPokok.setText(harga_pokok.replace(",", ""));
            jTxtHargaJual.setText(harga_jual.replace(",", ""));
            
            jBtnTambah.setText("Batal");
            jBtnUbah.setEnabled(true);
            jBtnHapus.setEnabled(true);
            
        } catch (Exception e) {
            e.getStackTrace();
        }
    }//GEN-LAST:event_jTblBarangMouseReleased

    private void jTblFilSalesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblFilSalesMouseReleased
        // TODO add your handling code here:
        int idx = jTblFilSales.getSelectedRow();
        try {
            String id_sales = modelFilterSales.getValueAt(idx, 0).toString();
            dataTable("",filterKategori,id_sales,"");
            
            filterSales = id_sales;
        } catch (Exception e) {
            e.getStackTrace();
        }
    }//GEN-LAST:event_jTblFilSalesMouseReleased

    private void jTblFilKategoriMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblFilKategoriMouseReleased
        // TODO add your handling code here:
        int idx = jTblFilKategori.getSelectedRow();
        try {
            String id_kategori = modelFilterKategori.getValueAt(idx, 0).toString();
            dataTable("",id_kategori,filterSales,"");
           
            filterKategori= id_kategori;
        } catch (Exception e) {
            e.getStackTrace();
        }
    }//GEN-LAST:event_jTblFilKategoriMouseReleased

    private void jTxtKeyInsKategoriKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtKeyInsKategoriKeyReleased
        // TODO add your handling code here:
        if( jCbbKeyInsKategori.getItemAt(jCbbKeyInsKategori.getSelectedIndex()).equals("Id Kategori")){
            dataTableInsertKategori(jTxtKeyInsKategori.getText(), "");
        }else{
            dataTableInsertKategori("",jTxtKeyInsKategori.getText() );
        }
    }//GEN-LAST:event_jTxtKeyInsKategoriKeyReleased

    private void jTxtKeyInsSalesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtKeyInsSalesKeyReleased
        // TODO add your handling code here:
        if( jCbbKeyInsSales.getItemAt(jCbbKeyInsSales.getSelectedIndex()).equals("Id Sales")){
            dataTableInsertSales(jTxtKeyInsSales.getText(), "");
        }else{
            dataTableInsertSales("",jTxtKeyInsSales.getText() );
        }
    }//GEN-LAST:event_jTxtKeyInsSalesKeyReleased

    private void jBtnResetFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnResetFilterActionPerformed
        // TODO add your handling code here:
        jTxtKeyFilSales.setText("");
        jTxtKeyFilKategori.setText("");
        dataTable("","","","");
        dataTableFilterSales("","");
        dataTableFilterKategori("","");
        filterSales = "";
        filterKategori = "";
    }//GEN-LAST:event_jBtnResetFilterActionPerformed

    private void jTxtKeyFilKategoriKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtKeyFilKategoriKeyReleased
        // TODO add your handling code here:
        if(jCbbKeyFilKategori.getItemAt(jCbbKeyFilKategori.getSelectedIndex()).equals("Id Kategori")){
            dataTableInsertKategori(jTxtKeyFilKategori.getText(), "");
        }else{
            dataTableFilterKategori("",jTxtKeyFilKategori.getText() );
        }
    }//GEN-LAST:event_jTxtKeyFilKategoriKeyReleased

    private void jTxtKeyFilSalesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtKeyFilSalesKeyReleased
        // TODO add your handling code here:
        if( jCbbKeyFilSales.getItemAt(jCbbKeyFilSales.getSelectedIndex()).equals("Id Sales")){
            dataTableFilterSales(jTxtKeyFilSales.getText(), "");
        }else{
            dataTableFilterSales("",jTxtKeyFilSales.getText() );
        }
    }//GEN-LAST:event_jTxtKeyFilSalesKeyReleased

     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnHapus;
    private javax.swing.JButton jBtnResetFilter;
    private javax.swing.JButton jBtnTambah;
    private javax.swing.JButton jBtnUbah;
    private javax.swing.JComboBox<String> jCbbFilterKeyword;
    private javax.swing.JComboBox<String> jCbbKeyFilKategori;
    private javax.swing.JComboBox<String> jCbbKeyFilSales;
    private javax.swing.JComboBox<String> jCbbKeyInsKategori;
    private javax.swing.JComboBox<String> jCbbKeyInsSales;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTblBarang;
    private javax.swing.JTable jTblFilKategori;
    private javax.swing.JTable jTblFilSales;
    private javax.swing.JTable jTblInsKategori;
    private javax.swing.JTable jTblInsSales;
    private javax.swing.JTextField jTxtHargaJual;
    private javax.swing.JTextField jTxtHargaPokok;
    private javax.swing.JTextField jTxtKeyFilKategori;
    private javax.swing.JTextField jTxtKeyFilSales;
    private javax.swing.JTextField jTxtKeyInsKategori;
    private javax.swing.JTextField jTxtKeyInsSales;
    private javax.swing.JTextField jTxtKeyword;
    private javax.swing.JTextField jTxtKode;
    private javax.swing.JTextField jTxtNamaBarang;
    private javax.swing.JTextField jTxtNamaKategori;
    private javax.swing.JTextField jTxtNamaSales;
    // End of variables declaration//GEN-END:variables
}
