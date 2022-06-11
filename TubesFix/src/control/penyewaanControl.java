
package Control;

import java.util.List;
import dao.penyewaanDAO;
import model.Penyewaan;
import model.Customer;
import model.Guide;
import model.Kendaraan;
import model.Kendaraan_Mobil;
import model.Kendaraan_Motor;
import model.Transaksi;
import java.sql.ResultSet;
import table.TablePenyewaan;

public class penyewaanControl {
    private penyewaanDAO PDao = new penyewaanDAO(); 
    public void insertDataPenyewaan(Penyewaan p){
        PDao.insertPenyewaan(p);
    }
    
    public List<Penyewaan> showDataPenyewaan(String query, String jenis){
        List<Penyewaan> dataPenyewaan = PDao.showListPenyewaan(query, jenis);
        return dataPenyewaan;
    }
    
    public TablePenyewaan showPenyewaan(String query) {
        
        List<Penyewaan> dataPenyewaanMb = PDao.showListPenyewaan(query, "Mobil");
        List<Penyewaan> dataPenyewaanMt = PDao.showListPenyewaan(query, "Motor");
        
        for(int i=0; i<dataPenyewaanMb.size(); i++){
            dataPenyewaanMb.add(dataPenyewaanMt.get(i));
        }
        
        TablePenyewaan tablePenyewaan = new TablePenyewaan(dataPenyewaanMb);
        
        return tablePenyewaan;
    }
    
    public void updateCustomer(Penyewaan p){
        PDao.updatePenyewaan(p);
    }
    public void deletePenyewaan(String id){
        PDao.deletePenyewaan(id);
    }
}
