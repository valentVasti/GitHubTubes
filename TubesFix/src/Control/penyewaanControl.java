
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
    
    public List<Penyewaan> showDataPenyewaan(String jenis){
        List<Penyewaan> dataPenyewaan = PDao.showPenyewaan();
        return dataPenyewaan+;
    }
    
    public TablePenyewaan showPenyewaan(String query, String Jenis) {
        
        List<Penyewaan> dataPenyewaan = PDao.showListPenyewaan(query, Jenis);
        TablePenyewaan tablePenyewaan = new TablePenyewaan(dataPenyewaan);
        
        return tablePenyewaan;
    }
    
    public void updateCustomer(Penyewaan p){
        PDao.updatePenyewaan(p);
    }
    public void deleteTransaksi(String id){
        PDao.deletePenyewaan(id);
    }
}
