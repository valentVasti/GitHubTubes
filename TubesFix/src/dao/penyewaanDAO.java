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
import model.Penyewaan;

public class penyewaanDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertPenyewaan(Penyewaan p) {
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO penyewaan(id_Penyewaan, id_Customer, id_Kendaraan, id_Transaksi, id_Driver, durasi, total_Sewa)" // bakal dicek dulu
                + "VALUES ('" +p.getId_Penyewaan()+ "', '" + p.getCustomer().getId_Customer()+ "','" + p.getKendaraan().getId()+ "', '"
                + p.getTransaksi().getId_Transaksi() + "', '" + p.getId_Guide() + "', '" 
                + p.getDurasi() + "', '" + p.getTotal_Sewa() + "')";
        
        System.out.println("Adding Penyewaan...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " +result + " Penyewaan");
            statement.close();
        } catch (Exception e) {
            System.out.println("Errror adding Penyewaan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void updatePenyewaan(Penyewaan p){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE penyewaan SET id_Customer = '" + p.getCustomer().getId_Customer()
                + "', id_Kendaraan = '" + p.getKendaraan().getId()
                + "', id_Transaksi = '" + p.getTransaksi().getId_Transaksi()
                + "', id_Guide = '" + p.getGuide().getId_Guide()
                + "', durasi = '" + p.getDurasi()
                + "', totalSewa = '" + p.getTotal_Sewa()
                + "' WHERE id_Penyewaan = '" + p.getId_Penyewaan() + "'";
        System.out.println("Editing Penyewaan...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Penyewaan " + p.getId_Penyewaan());
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Updating Penyewaan...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }
    
    public List<Penyewaan> showPenyewaanBySearch(String query){
        con = dbCon.makeConnection();
        
        String sql = "SELECT c.* FROM customer as c WHERE (c.id_Customer LIKE"
                + "'%" + query + "%'"
                + "OR c.nama_Customer LIKE '%" + query + "%'"
                + "OR c.alamat LIKE '%" + query +"%'"
                + "OR c.umur LIKE '%" + query + "%'"
                + "OR c.no_Telp LIKE '%" + query + "%')";

        System.out.println("Mengambil data Customer...");
        
        List<Customer> list = new ArrayList();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null){
                while (rs.next()){
                        Customer c = new Customer(
                            rs.getString("c.id_Customer"),
                            rs.getString("c.nama_Customer"),
                            rs.getString("c.alamat"),
                            Integer.parseInt(rs.getString("c.umur")),
                            rs.getString("c.no_Telp")
                    );  
                    list.add(c);
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
    
    public void deleteCustomer(String id){
        
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM customer WHERE id_Customer = " + id + "";
                
        System.out.println("Deleting Customer...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " + result + " customer" + id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Deleting Customer...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }  
    
    public List<Customer> showPembeli(){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM customer";
        System.out.println("Mengambil data customer...");
        
        List<Customer> list = new ArrayList();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null){
                while (rs.next()){
                        Customer c = new Customer(
                            rs.getString("c.id_Customer"),
                            rs.getString("c.nama_Customer"),
                            rs.getString("c.alamat"),
                            Integer.parseInt(rs.getString("c.umur")),
                            rs.getString("c.no_Telp")
                    );
                    
                    list.add(c);
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
//jfhjfhfjfhfhfh
    
}
