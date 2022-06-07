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
    
    public void insertMotor(Kendaraan_Mobil m) {
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO mobil(id_Kendaraan, kapasitas_Mobil, jenis, nama_Kendaraan, platNo, merk, cc, tarif)" // bakal dicek dulu
                + "VALUES ('" +m.getId_Kendaraan()+ "', '" + m.getKapasitas_Mobil() + "', '"
                + m.getJenis() + "', '" + m.getNama_Kendaraan() + "', '" + m.getPlatNo() + "', '" + m.getMerk() + 
                "', '" + m.getCC() + "', '" + m.getTarif() + "')";
        
        System.out.println("Adding Mobil...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " +result + " Mobil");
            statement.close();
        } catch (Exception e) {
            System.out.println("Errror adding Mobil...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void updateMobil(Kendaraan_Mobil m){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE mobil SET kapasitas_Mobil = '" + m.getKapasitas_Mobil()
                + "', jenis = '" + m.getJenis()
                + "', nama_Kendaraan = '" + m.getNamaKendaraan()
                + "', platNo = '" + m.getPlatNo()
                + "', merk = '" + m.getMerk()
                + "', cc = '" + m.getCC()
                + "', tarif = '" + m.getTarif()
                + "' WHERE id_Kendaraan = '" + m.getId_Kendaraan() + "'";
        System.out.println("Editing Mobil...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Mobil " + m.getId_Kendaraan());
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Updating Mobil...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }
    
    public List<Kendaraan> showMobilBySearch(String query){
        con = dbCon.makeConnection();
        
        String sql = "SELECT m.* FROM mobil as m WHERE (m.id_Kendaraan LIKE"
                + "'%" + query + "%'"
                + "OR m.kapasitas_Mobil LIKE '%" + query + "%'"
                + "OR m.jenis LIKE '%" + query + "%'"
                + "OR m.nama_Kendaraan LIKE '%" + query + "%'"
                + "OR m.platNo LIKE '%" + query + "%'"
                + "OR m.merk LIKE '%" + query + "%'"
                + "OR m.cc LIKE '%" + query + "%'"
                + "OR m.tarif LIKE '%" + query + "%')";

        System.out.println("Mengambil data Mobil...");
        
        List<Kendaraan> list = new ArrayList();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null){
                while (rs.next()){
                        Kendaraan k = new Kendaraan_Mobil(
                            rs.getString("mt.kapasitas_Mobil"),
                            rs.getString("mt.id_Kendaraan"),    
                            rs.getString("mt.jenis"),
                            rs.getString("mt.nama_Kendaraan"),
                            rs.getString("mt.platNo"),
                            rs.getString("mt.merk"),
                            rs.getString("mt.cc"),
                            Double.parseDouble(rs.getString("mt.tarif"))    
                        ); 
                    list.add(k);
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
    
    public void deleteMotor(String id){
        
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM mobil WHERE id_Kendaraan = " + id + "";
                
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
        
        String sql = "SELECT * FROM mobil";
        System.out.println("Mengambil data Motor...");
        
        List<Kendaraan> list = new ArrayList();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null){
                while (rs.next()){
                        Kendaraan k = new Kendaraan_Mobil(
                            rs.getString("mt.kapasitas_Mobil"),
                            rs.getString("mt.id_Kendaraan"),    
                            rs.getString("mt.jenis"),
                            rs.getString("mt.nama_Kendaraan"),
                            rs.getString("mt.platNo"),
                            rs.getString("mt.merk"),
                            rs.getString("mt.cc"),
                            Double.parseDouble(rs.getString("mt.tarif"))    
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
