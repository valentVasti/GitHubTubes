package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Transaksi;


public class TabelTransaksi extends AbstractTableModel{
 
    private List<Transaksi> list;
    
    public TabelTransaksi (List<Transaksi> list)
    {
        this.list = list;
    }
    
    @Override
    public int getRowCount()
    {
        return list.size();
    }
    
    @Override
    public int getColumnCount()
    {
        return 4;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        switch(columnIndex)
        {
            case 0 :
                return list.get(rowIndex).getId_Transaksi();
            case 1:
                return list.get(rowIndex).getJenis_Pembayaran();
            case 2: 
                return list.get(rowIndex).getStatus_Pembayaran();
            case 3:
                return list.get(rowIndex).getTanggal_Transaksi();
            default:
                return null;
        }
    }
    
    public String getColumnName(int column)
    {
        switch(column)
        {
            case 0:
                return "id_transaksi";
            case 1:
                return "jenis_pembayaran";
            case 2:
                return "status_pembayaran";
            case 3:
                return "tanggal_transaksi";
            default:
                return null;
        }
    }
    
}
