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
import model.Kendaraan;
import model.Kendaraan_Mobil;

public class mobilDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertMobil(Kendaraan m) {
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO kendaraan(id_Kendaraan, jenis, nama_Kendaraan, platNo, merk, cc, tarif, kapasitas_Mobil)" // jenis_Seat gaada berharap bisa NULL
                + "VALUES ('" +m.getId()+ "', '" + m.getData("jenis") + "', '" + m.getData("nama_Kendaraan")
                + "', '" + m.getData("platNo")+ "', '" + m.getData("merk") + 
                "', '" + m.getData("cc") + "', '" + Double.parseDouble(m.getData("tarif")) + "', '" + m.getData("kapasitas_Mobil") + "')";
        
        System.out.println("Adding Mobil...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " +result + " Mobil");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding Mobil...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void updateMobil(Kendaraan m){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE kendaraan SET jenis = '" + m.getData("jenis")
                + "', nama_Kendaraan = '" + m.getData("nama_Kendaraan")
                + "', platNo = '" + m.getData("platNo")
                + "', merk = '" + m.getData("merk")
                + "', cc = '" + m.getData("cc")
                + "', tarif = '" + m.getData("tarif")
                + "', kapasitas_Mobil = '" + m.getData("kapasitas_Mobil")
                + "' WHERE id_Kendaraan = '" + m.getId() + "'";
        System.out.println("Editing Mobil...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Mobil " + m.getId());
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Updating Mobil...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }
    
    public List<Kendaraan> showMobilBySearch(String query){
        con = dbCon.makeConnection();
        
        String sql = "SELECT mb.* FROM kendaraan as mb WHERE (mb.id_Kendaraan LIKE"
                + "'" + query + "'"
                + "OR mb.jenis LIKE '" + query + "'"
                + "OR mb.nama_Kendaraan LIKE '" + query + "'"
                + "OR mb.platNo LIKE '" + query + "'"
                + "OR mb.merk LIKE '" + query + "'"
                + "OR mb.cc LIKE '" + query + "'"
                + "OR mb.tarif LIKE '" + query + "'"
                + "OR mb.kapasitas_Mobil LIKE '" + query + "')";

        System.out.println("Mengambil data Mobil...");
        
        List<Kendaraan> list = new ArrayList();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null){
                while (rs.next()){
                        Kendaraan k = new Kendaraan_Mobil(
                            rs.getString("mb.id_Kendaraan"),
                            rs.getString("mb.jenis"),
                            rs.getString("mb.nama_Kendaraan"),
                            rs.getString("mb.platNo"),
                            rs.getString("mb.merk"),
                            rs.getString("mb.cc"),
                            Double.parseDouble(rs.getString("mb.tarif")),
                            rs.getString("mb.kapasitas_Mobil")
                        );
                    if(k.getId().contains("MOB")){
                        list.add(k);
                    }
                                 
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
    
    public void deleteMobil(String id){
        
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM kendaraan WHERE id_Kendaraan = '" + id + "'";
                
        System.out.println("Deleting Mobil...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " + result + " Mobil" + id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Deleting Mobil...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }  
    
    public List<Kendaraan> showMobil(){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM kendaraan WHERE id_Kendaraan LIKE '%MOB%'";
        System.out.println("Mengambil data Mobil...");
        
        List<Kendaraan> list = new ArrayList();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null){
                while (rs.next()){
                        Kendaraan k = new Kendaraan_Mobil(
                            rs.getString("id_Kendaraan"),
                            rs.getString("jenis"),
                            rs.getString("nama_Kendaraan"),
                            rs.getString("platNo"),
                            rs.getString("merk"),
                            rs.getString("cc"),
                            Double.parseDouble(rs.getString("tarif")),
                            rs.getString("kapasitas_Mobil")    
                        );
                    
                    list.add(k);
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
