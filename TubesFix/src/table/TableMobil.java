package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Kendaraan;
import model.Kendaraan_Mobil;


public class TableMobil extends AbstractTableModel{
 
    private List<Kendaraan_Mobil> list;
    
    public TableMobil (List<Kendaraan_Mobil> list)
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
        return 6;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        switch(columnIndex)
        {
            case 0 :
                return list.get(rowIndex).getId_Kendaraan();
            case 1:
                return list.get(rowIndex).getNama_Kendaraan();
            case 2: 
                return list.get(rowIndex).getMerk();
            case 3:
                return list.get(rowIndex).getPlatNo();
            case 4:
                return list.get(rowIndex).getCC();
            case 5:
                return list.get(rowIndex).getTarif();
            case 6:
                return list.get(rowIndex).getJenis();
            default:
                return null;
        }
    }
    
    public String getColumnName(int column)
    {
        switch(column)
        {
            case 0:
                return "id_mobil";
            case 1:
                return "nama";
            case 2:
                return "merk";
            case 3:
                return "plat_nomer";
            case 4:
                return "cc";  
            case 5:
                return "tarif";
            default:
                return null;
        }
    }
    
}
