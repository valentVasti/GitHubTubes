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
    
    public void insertCustomer(Transaksi t) {
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
            System.out.println("Errror adding Customer...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void updateCustomer(Customer c){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE customer SET nama_Customer = '" + c.getNama_Customer()
                + "', alamat = '" + c.getAlamat_Customer()
                + "', umur = '" + c.getUmur_Customer()
                + "' WHERE id = '" + c.getId_Customer() + "'";
        System.out.println("Editing Customer...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Customer " + c.getId_Customer());
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Updating Customer...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }
    
    public List<Customer> showCustomerBySearch(String query){
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
    
    public void deleteCustomer(int id){
        
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
}
