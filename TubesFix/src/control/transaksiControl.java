
package Control;

import java.util.List;
import dao.transaksiDAO;
import model.Transaksi;
import java.sql.ResultSet;
import table.TableTransaksi;

public class transaksiControl {
    private transaksiDAO TDao = new transaksiDAO();
    public void insertDataTransaksi(Transaksi t){
        TDao.insertTransaksi(t);
    }
    
    public List<Transaksi> showDataTransaksi(String jenis){
        List<Transaksi> dataTransaksi = TDao.showTransaksi();
        return dataTransaksi;
    }
    
    public TableTransaksi showTransaksi(String query) {
        
        List<Transaksi> dataTransaksi = TDao.showTransaksiBySearch(query);
        TableTransaksi tableTransaksi = new TableTransaksi(dataTransaksi);
        
        return tableTransaksi;
    }
    
    public void updateCustomer(Transaksi t){
        TDao.updateTransaksi(t);
    }
    public void deleteTransaksi(String id){
        TDao.deleteTransaksi(id);
    }
}
