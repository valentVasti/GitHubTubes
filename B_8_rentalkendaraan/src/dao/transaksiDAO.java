/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Transaksi;

public class transaksiDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertTransaksi(Transaksi t) {
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO transaksi(id_Transaksi, status_Pembayaran, jenis_Pembayaran, tanggal_Transaksi)"
                + "VALUES ('" +t.getId_Transaksi()+ "', '" + t.getStatus_Pembayaran()+ "','" + t.getJenis_Pembayaran()+ "', '"
                + t.getTanggal_Transaksi() + "')";
        
        System.out.println("Adding Transaksi...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " +result + " Transaksi");
            statement.close();
        } catch (Exception e) {
            System.out.println("Errror adding Transaksi...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void updateTransaksi(Transaksi t){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE transaksi SET status_Pembayaran = '" + t.getStatus_Pembayaran()
                + "',jenis_Pembayaran = '" + t.getJenis_Pembayaran()
                + "', tanggal_Transaksi = '" + t.getTanggal_Transaksi()
                + "' WHERE id_Transaksi = '" + t.getId_Transaksi() + "'";
        System.out.println("Editing Transaksi...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Transaksi " + t.getId_Transaksi());
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Updating Transaksi...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }
 
    public void deleteTransaksi(String id){
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM transaksi WHERE id_Transaksi = '" + id + "'";
                
        System.out.println("Deleting Transaksi...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " + result + " Transaksi" + id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Deleting Transaksi...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }  
    
    public List<Transaksi> showTransaksi(){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM transaksi";
        System.out.println("Mengambil data transaksi...");
        
        List<Transaksi> list = new ArrayList();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null){
                while (rs.next()){
                        Transaksi t = new Transaksi(
                            rs.getString("id_Transaksi"),
                            rs.getString("status_Pembayaran"),
                            rs.getString("jenis_Pembayaran"),
                            rs.getString("tanggal_Transaksi")
                    );
                    
                    list.add(t);
                    }
                }
                rs.close();
                statement.close();
            } catch (Exception e){
                    System.out.println("Error reading database...");
                    System.out.println(e);
                    }
        
            dbCon.closeConnection();
            
            return list;
        }
    public List<Transaksi> showTransaksiBySearch(String query){
        con = dbCon.makeConnection();
        
        String sql = "SELECT t.* FROM transaksi as t WHERE (t.id_Transaksi LIKE"
                + "'%" + query + "%'"
                + "OR t.status_Pembayaran LIKE '%" + query + "%'"
                + "OR t.jenis_Pembayaran LIKE '%" + query +"%'"
                + "OR t.tanggal_Transaksi LIKE '%" + query + "%')";

        System.out.println("Mengambil data Transaksi...");
        
        List<Transaksi> list = new ArrayList();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null){
                while (rs.next()){
                        Transaksi t = new Transaksi(
                            rs.getString("t.id_Transaksi"),
                            rs.getString("t.status_Pembayaran"),
                            rs.getString("t.jenis_Pembayaran"),
                            rs.getString("t.tanggal_Transaksi")                         
                    );  
                    list.add(t);
                   }
                }
                rs.close();
                statement.close();
            } catch (Exception e){
                    System.out.println("Error reading database ...");
                    System.out.println(e);
                    }
            dbCon.closeConnection();
            
            return list;
    }
}
