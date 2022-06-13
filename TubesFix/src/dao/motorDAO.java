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
import model.Customer;
import model.Kendaraan_Motor;
import model.Kendaraan;

public class motorDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertMotor(Kendaraan_Motor m) {
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO kendaraan(id_Kendaraan, jenis, nama_Kendaraan, platNo, merk, cc, tarif, jenis_Seat)" // gausa diisi kapasitas_Mobil berharap bisa NULL
                + "VALUES ('" +m.getId_Kendaraan()+ "', '" + m.getJenis() + "', '" + m.getNama_Kendaraan() 
                + "', '" + m.getPlatNo() + "', '" + m.getMerk() + 
                "', '" + m.getCC() + "', '" + m.getTarif() + "', '" + m.getJenis_Seat()+ "')";
        
        System.out.println("Adding Motor...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " +result + " Motor");
            statement.close();
        } catch (Exception e) {
            System.out.println("Errror adding Motor...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void updateMotor(Kendaraan_Motor m){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE kendaraan SET jenis = '" + m.getJenis()
                + "', nama_Kendaraan = '" + m.getNamaKendaraan()
                + "', platNo = '" + m.getPlatNo()
                + "', merk = '" + m.getMerk()
                + "', cc = '" + m.getCC()
                + "', tarif = '" + m.getTarif()
                + "', jenis_Seat = '" + m.getJenis_Seat()
                + "' WHERE id_Kendaraan = '" + m.getId_Kendaraan() + "'";
        System.out.println("Editing Motor...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Motor " + m.getId_Kendaraan());
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Updating Motor...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }
    
    public List<Kendaraan> showMotorBySearch(String query){
        con = dbCon.makeConnection();
        
        String sql = "SELECT mt.* FROM kendaraan as mt WHERE (mt.id_Kendaraan LIKE"
                + "'" + query + "'"
                + "OR mt.jenis LIKE '" + query + "'"
                + "OR mt.nama_Kendaraan LIKE '" + query + "'"
                + "OR mt.platNo LIKE '" + query + "'"
                + "OR mt.merk LIKE '" + query + "'"
                + "OR mt.cc LIKE '" + query + "'"
                + "OR mt.tarif LIKE '" + query
                + "OR mt.jenis_Seat LIKE '" + query + "')";

        System.out.println("Mengambil data Motor...");
        
        List<Kendaraan> list = new ArrayList();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null){
                while (rs.next()){
                        Kendaraan k = new Kendaraan_Motor(
                            rs.getString("mt.id_Kendaraan"),    
                            rs.getString("mt.jenis"),
                            rs.getString("mt.nama_Kendaraan"),
                            rs.getString("mt.platNo"),
                            rs.getString("mt.merk"),
                            rs.getString("mt.cc"),
                            Double.parseDouble(rs.getString("mt.tarif")),
                            rs.getString("mt.jenis_Seat")
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
        
        String sql = "DELETE FROM kendaraan WHERE id_Kendaraan = '" + id + "'";
                
        System.out.println("Deleting Motor...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " + result + " Motor" + id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Deleting Motor...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }  
    
    public List<Kendaraan> showMotor(){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM kendaraan WHERE id_Kendaraan LIKE '%MOT%'";
        System.out.println("Mengambil data Motor...");
        
        List<Kendaraan> list = new ArrayList();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null){
                while (rs.next()){
                        Kendaraan k = new Kendaraan_Motor(
                            rs.getString("mt.id_Kendaraan"),    
                            rs.getString("mt.jenis"),
                            rs.getString("mt.nama_Kendaraan"),
                            rs.getString("mt.platNo"),
                            rs.getString("mt.merk"),
                            rs.getString("mt.cc"),
                            Double.parseDouble(rs.getString("mt.tarif")),
                            rs.getString("mt.jenis_Seat")    
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
