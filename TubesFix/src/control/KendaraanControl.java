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
    
    public void insertDataKendaraan(Kendaraan k, String jenis){
        if(jenis.equalsIgnoreCase("Mobil")){
            MbDao.insertMobil(k);
        }else{
            MtDao.insertMotor(k);
        }
    }
    
    public List<Kendaraan> showListMobil(){
        
            List<Kendaraan> listMobil = MbDao.showMobil();
            return listMobil;
               
    }
    
    public List<Kendaraan> showListMotor(){
                
            List<Kendaraan> listMotor = MtDao.showMotor();
            return listMotor;
            
    }
    
    public TableMobil showMobil(){
        
        List<Kendaraan> dataMobil = MbDao.showMobil();
        TableMobil tableMobil = new TableMobil(dataMobil);
        
        return tableMobil;
    }
    
    public TableMotor showMotor(){
        
        List<Kendaraan> dataMotor = MtDao.showMotor();
        TableMotor tableMotor = new TableMotor(dataMotor);
        
        return tableMotor;
    }

    public TableMobil showMobilBySearch(String query){
        
        List<Kendaraan> dataMobil = MbDao.showMobilBySearch(query);
        TableMobil tableMobil = new TableMobil(dataMobil);
        
        return tableMobil;
    }
    
    public TableMotor showMotorBySearch(String query){
        
        List<Kendaraan> dataMotor = MtDao.showMotorBySearch(query);
        TableMotor tableMotor = new TableMotor(dataMotor);
        
        return tableMotor;
    }
    
    public void updateKendaraan(Kendaraan k, String jenis){
        if(jenis.equalsIgnoreCase("Mobil")){
            MbDao.updateMobil(k);
        }else{
            MtDao.updateMotor(k);
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
