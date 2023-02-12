/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Robby
 */
public class koneksi {
    private static Connection con;
    public koneksi(){
    }
    public static Connection getConnection(){
         try{
    con=DriverManager.getConnection("jdbc:mysql://localhost/db_tokomaju","root","");
    }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Gagal Koneksi");
    }
return con;
  }
}