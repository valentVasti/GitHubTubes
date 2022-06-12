
package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Guide;

public class guideDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertGuide(Guide g) {
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO guide(id_Guide, nama_Guide, alamat_Guide, umur_Guide, telp_Guide)" // bakal dicek dulu
                + "VALUES ('" +g.getId_Guide()+ "', '" + g.getNama_Guide()+ "','" + g.getAlamat_Guide()+ "', '"
                + g.getUmur_Guide() + "', '" + g.getTelp_Guide() + "')";
        
        System.out.println("Adding Guide...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " +result + " Guide");
            statement.close();
        } catch (Exception e) {
            System.out.println("Errror adding Guide...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void updateGuide(Guide g){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE guide SET nama_Guide = '" + g.getNama_Guide()
                + "', alamat_Guide = '" + g.getAlamat_Guide()
                + "', umur_Guide = '" + g.getUmur_Guide()
                + "', telp_Guide = '" + g.getTelp_Guide()
                + "' WHERE id_Guide = '" + g.getId_Guide() + "'";
        System.out.println("Editing Guide...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Guide " + g.getId_Guide());
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Updating Guide...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }
    
    public List<Guide> showGuideBySearch(String query){
        con = dbCon.makeConnection();
        
        String sql = "SELECT g.* FROM guide as g WHERE (g.id_Guide LIKE"
                + "'" + query + "'"
                + "OR g.nama_Guide LIKE '" + query + "'"
                + "OR g.alamat_Guide LIKE '" + query +"'"
                + "OR g.umur_guide LIKE '" + query + "'"
                + "OR g.telp_Guide LIKE '" + query + "')";

        System.out.println("Mengambil data Guide...");
        
        List<Guide> list = new ArrayList();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null){
                while (rs.next()){
                        Guide g = new Guide(
                            rs.getString("g.id_Guide"),
                            rs.getString("g.nama_Guide"),
                            rs.getString("g.alamat_Guide"),
                            Integer.parseInt(rs.getString("g.umur_Guide")),
                            rs.getString("g.telp_Guide")
                    );  
                    list.add(g);
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
    
    public void deleteGuide(String id){
        
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM guide WHERE id_Guide = '" + id + "'";
                
        System.out.println("Deleting Guide...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " + result + " Guide " + id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Deleting Guide...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }  
    
    public List<Guide> showGuide(){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM guide";
        System.out.println("Mengambil data guide...");
        
        List<Guide> list = new ArrayList();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null){
                while (rs.next()){
                        Guide g = new Guide(
                            rs.getString("id_Guide"),
                            rs.getString("nama_Guide"),
                            rs.getString("alamat_Guide"),
                            Integer.parseInt(rs.getString("umur_Guide")),
                            rs.getString("telp_Guide")
                    );
                    
                    list.add(g);
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
