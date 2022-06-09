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
        
        String sql = "INSERT INTO motor(id_Kendaraan, jenis_Helm, jenis_Stang, jenis, nama_Kendaraan, platNo, merk, cc, tarif)" // bakal dicek dulu
                + "VALUES ('" +m.getId_Kendaraan()+ "', '" + m.getJenis_Helm()+ "','" + m.getJenis_Stang()+ "', '"
                + m.getJenis() + "', '" + m.getNama_Kendaraan() + "', '" + m.getPlatNo() + "', '" + m.getMerk() + 
                "', '" + m.getCC() + "', '" + m.getTarif() + "')";
        
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
        
        String sql = "UPDATE motor SET jenis_Helm = '" + m.getJenis_Helm()
                + "', jenis_Stang = '" + m.getJenis_Stang()
                + "', jenis = '" + m.getJenis()
                + "', nama_Kendaraan = '" + m.getNamaKendaraan()
                + "', platNo = '" + m.getPlatNo()
                + "', merk = '" + m.getMerk()
                + "', cc = '" + m.getCC()
                + "', tarif = '" + m.getTarif()
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
    
    public List<Kendaraan_Motor> showMotorBySearch(String query){
        con = dbCon.makeConnection();
        
        String sql = "SELECT m.* FROM motor as m WHERE (m.id_Kendaraan LIKE"
                + "'%" + query + "%'"
                + "OR m.jenis_Helm LIKE '%" + query + "%'"
                + "OR m.jenis_Stang LIKE '%" + query +"%'"
                + "OR m.jenis LIKE '%" + query + "%'"
                + "OR m.nama_Kendaraan LIKE '%" + query + "%'"
                + "OR m.platNo LIKE '%" + query + "%'"
                + "OR m.merk LIKE '%" + query + "%'"
                + "OR m.cc LIKE '%" + query + "%'"
                + "OR m.tarif LIKE '%" + query + "%')";

        System.out.println("Mengambil data Motor...");
        
        List<Kendaraan_Motor> list = new ArrayList();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null){
                while (rs.next()){
                        Kendaraan_Motor k = new Kendaraan_Motor(
                            rs.getString("mt.jenis_Helm"),
                            rs.getString("mt.jenis_Stang"),
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
        
        String sql = "DELETE FROM motor WHERE id_Kendaraan = " + id + "";
                
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
        
        String sql = "SELECT * FROM motor";
        System.out.println("Mengambil data Motor...");
        
        List<Kendaraan> list = new ArrayList();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null){
                while (rs.next()){
                        Kendaraan k = new Kendaraan_Motor(
                            rs.getString("mt.jenis_Helm"),
                            rs.getString("mt.jenis_Stang"),
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
