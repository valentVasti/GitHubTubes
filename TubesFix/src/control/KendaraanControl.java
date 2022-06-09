/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.List;
import dao.mobilDAO;
import dao.motorDAO;
import java.util.List;
import model.Kendaraan;
import model.Kendaraan_Mobil;
import model.Kendaraan_Motor;
import java.sql.ResultSet;
import table.TableMobil;
import table.TableMotor;

public class KendaraanControl {
    private mobilDAO MbDao = new mobilDAO();
    private motorDAO MtDao = new motorDAO();
    
    public void insertDataKendaraan(Kendaraan_Mobil kmb, Kendaraan_Motor kmt, String jenis){
        if(jenis.equalsIgnoreCase("Mobil")){
            MbDao.insertMobil(kmb);
        }else{
            MtDao.insertMotor(kmt);
        }
    }
    
    public List<Kendaraan> showDataKendaraan(String jenis){
        if(jenis.equalsIgnoreCase("Mobil")){
            List<Kendaraan> listMobil = MbDao.showMobil();
            return listMobil;
        }else{
            List<Kendaraan> listMotor = MtDao.showMotor();
            return listMotor;
        }
                
    }
    
    public TableMobil showMobil(String query) {
        
        List<Kendaraan_Mobil> dataMobil = MbDao.showMobilBySearch(query);
        TableMobil tableMobil = new TableMobil(dataMobil);
        
        return tableMobil;
    }
    
    public TableMotor showMotor(String query) {
        
        List<Kendaraan_Motor> dataMotor = MtDao.showMotorBySearch(query);
        TableMotor tableMotor = new TableMotor(dataMotor);
        
        return tableMotor;
    }
    
    public void updateKendaraan(Kendaraan_Mobil kmb, Kendaraan_Motor kmt, String jenis){
        if(jenis.equalsIgnoreCase("Mobil")){
            MbDao.updateMobil(kmb);
        }else{
            MtDao.updateMotor(kmt);
        }
    }
    
    public void deleteKendaraan(String id, String jenis){
        if(jenis.equalsIgnoreCase("Mobil")){
            MbDao.deleteMobil(id);
        }else{
            MtDao.deleteMotor(id);
        }
    }    
}
