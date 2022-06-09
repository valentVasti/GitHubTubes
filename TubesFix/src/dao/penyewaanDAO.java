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
import model.Customer;
import model.Guide;
import model.Kendaraan;
import model.Kendaraan_Mobil;
import model.Kendaraan_Motor;
import model.Transaksi;

public class penyewaanDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertPenyewaan(Penyewaan p) {
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO penyewaan(id_Penyewaan, id_Customer, id_Kendaraan, id_Transaksi, id_Guide, durasi, total_Sewa)" // bakal dicek dulu
                + "VALUES ('" +p.getId_Penyewaan()+ "', '" + p.getCustomer().getId_Customer()+ "','" + p.getKendaraan().getId()+ "', '"
                + p.getTransaksi().getId_Transaksi() + "', '" + p.getGuide().getId_Guide() + "', '" 
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
        
        String sql = "UPDATE penyewaan SET id_Penyewaan = '" + p.getId_Penyewaan()
                + "', id_Customer = '" + p.getCustomer().getId_Customer()
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
    
    
    public List<Penyewaan> showListPenyewaan(String query, String jenis){
        con = dbCon.makeConnection(); 
        String sql;
        
        if(jenis.equalsIgnoreCase("Mobil")){
                sql = "SELECT p.*, m.*, c.*, t.*, g.* FROM penyewaan as p JOIN mobil as m ON m.id_kendaraan = p.id_kendaraan"
                        + "JOIN customer c ON p.id_Customer = p.id_Customer"
                        + "JOIN transaksi t ON p.id_Transaksi = t.id_Transaksi"
                        + "JOIN guide g ON p.id_Guide = g.id_Guide";
                sql+= "WHERE p.id_Penyewaan LIKE '%" + query  + "%' "
                + "OR p.jenis LIKE '%" + query + "%' "
                + "OR m.nama LIKE '%" + query + "%' "
                + "OR m.kapasitas_Mobil LIKE '%" + query + "%' "
                + "OR m.cc '%" + query + "%' "
                + "OR t.id_Transaksi LIKE '%" + query + "%' "
                + "OR c.status_Pembayaran LIKE '%" + query + "%' "
                + "OR g.nama_Guide LIKE '%" + query + "%' "
                + "OR p.total_Sewa LIKE '%" + query + "%' ";
        }else{
                sql = "SELECT p.*, m.*, c.*, t.*, g.* FROM penyewaan as p JOIN motor as mt ON mt.id_kendaraan = p.id_kendaraan"
                        + "JOIN customer c ON p.id_Customer = p.id_Customer"
                        + "JOIN transaksi t ON p.id_Transaksi = t.id_Transaksi"
                        + "JOIN guide g ON p.id_Guide = g.id_Guide";
                sql+= "WHERE p.id_Penyewaan LIKE '%" + query  + "%' "
                + "OR p.jenis LIKE '%" + query + "%' "
                + "OR mt.nama LIKE '%" + query + "%' "
                + "OR mt.jenis_helm LIKE '%" + query + "%' "
                + "OR mt.jenis_stang LIKE '%" + query + "%' "
                + "OR mt.cc '%" + query + "%' "
                + "OR t.id_Transaksi LIKE '%" + query + "%' "
                + "OR c.status_Pembayaran LIKE '%" + query + "%' "
                + "OR g.nama_Guide LIKE '%" + query + "%' "
                + "OR p.total_Sewa LIKE '%" + query + "%' ";
        }
        
        System.out.println("Mengambil data Penyewaan...");
        
        List<Penyewaan> list = new ArrayList();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null){
                if(jenis.equalsIgnoreCase("Mobil")){
                while (rs.next()){
                    Customer c = new Customer(
                                    rs.getString("c.id_Customer"),
                                    rs.getString("c.nama_Customer"),
                                    rs.getString("c.alamat_Customer"),
                                    Integer.parseInt(rs.getString("c.umur_Customer")),
                                    rs.getString("c.telp_Customer")
                                );
                    
                    Transaksi t = new Transaksi(
                                    rs.getString("t.id_Transaksi"),
                                    rs.getString("t.status_Pembayaran"),
                                    rs.getString("t.jenis_Pembayaran"),
                                    rs.getString("t.tanggal_Transaksi")
                                );
                    
                    Guide g = new Guide(
                                    rs.getString("g.id_Guide"),
                                    rs.getString("g.nama_Guide"),
                                    rs.getString("g.alamat_Guide"),
                                    Integer.parseInt(rs.getString("g.umur_Guide")),
                                    rs.getString("g.telp_Guide")
                                );
                    
                    Kendaraan km = new Kendaraan_Mobil(
                                            rs.getString("m.id_Kendaraan"),
                                            rs.getString("m.kapasitas_Mobil"),
                                            rs.getString("m.jenis"),
                                            rs.getString("m.nama"),
                                            rs.getString("m.plat"),
                                            rs.getString("m.merk"),
                                            rs.getString("m.cc"),
                                            Double.parseDouble(rs.getString("m.tarif"))
                                );
                    
                        Penyewaan p = new Penyewaan(
                            rs.getString("p.id_Penyewaan"),
                                c,
                                t,
                                g,
                                km,
                        Integer.parseInt(rs.getString("p.durasi")),
                        rs.getString("p.jenis"),
                        Double.parseDouble(rs.getString("p.total_Sewa"))
                    );  
                    list.add(p);
                   }
                }
                rs.close();
                statement.close();
                
                }else{
                
                while (rs.next()){
                    Customer c = new Customer(
                                    rs.getString("c.id_Customer"),
                                    rs.getString("c.nama_Customer"),
                                    rs.getString("c.alamat_Customer"),
                                    Integer.parseInt(rs.getString("c.umur_Customer")),
                                    rs.getString("c.telp_Customer")
                                );
                    
                    Transaksi t = new Transaksi(
                                    rs.getString("t.id_Transaksi"),
                                    rs.getString("t.status_Pembayaran"),
                                    rs.getString("t.jenis_Pembayaran"),
                                    rs.getString("t.tanggal_Transaksi")
                                );
                    
                    Guide g = new Guide(
                                    rs.getString("g.id_Guide"),
                                    rs.getString("g.nama_Guide"),
                                    rs.getString("g.alamat_Guide"),
                                    Integer.parseInt(rs.getString("g.umur_Guide")),
                                    rs.getString("g.telp_Guide")
                                );
                    
                    Kendaraan kt = new Kendaraan_Motor(
                                            rs.getString("mt.jenis_Helm"),
                                            rs.getString("mt.jenis_Stang"),
                                            rs.getString("mt.id_Kendaraan"),
                                            rs.getString("mt.jenis"),
                                            rs.getString("mt.nama"),
                                            rs.getString("mt.plat"),
                                            rs.getString("mt.merk"),
                                            rs.getString("mt.cc"),
                                            Double.parseDouble(rs.getString("mt.tarif"))
                                );
                    
                        Penyewaan p = new Penyewaan(
                            rs.getString("p.id_Penyewaan"),
                                c,
                                t,
                                g,
                                kt,
                        Integer.parseInt(rs.getString("p.durasi")),
                        rs.getString("p.jenis"),
                        Double.parseDouble(rs.getString("p.total_Sewa"))
                    );  
                    list.add(p);
                   }
                }
                
                } catch (Exception e){
                    System.out.println("Error reading database ...");
                    System.out.println(e);
            }
        
            dbCon.closeConnection();
            
            return list;
            
    }
    
    public void deletePenyewaan(String id){
        
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM penyewaan WHERE id_Penyewaan = " + id + "";
                
        System.out.println("Deleting Penyewaan...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " + result + " Penyewaan" + id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Deleting Penyewaan...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }  
}
