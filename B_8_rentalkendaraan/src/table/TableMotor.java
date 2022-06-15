package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Kendaraan;
import model.Kendaraan_Motor;


public class TableMotor extends AbstractTableModel{
 
    private List<Kendaraan> list;
    
    public TableMotor (List<Kendaraan> list)
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
                return list.get(rowIndex).getData("Id");
            case 1:
                return list.get(rowIndex).getData("nama_Kendaraan");
            case 2: 
                return list.get(rowIndex).getData("merk");
            case 3:
                return list.get(rowIndex).getData("platNo");
            case 4:
                return list.get(rowIndex).getData("cc");
            case 5:
                return list.get(rowIndex).getData("tarif");
            case 6:
                return list.get(rowIndex).getData("jenis");
            case 7:
                return list.get(rowIndex).getData("jenis_Seat");
            default:
                return null;
        }
    }
    
    public String getColumnName(int column)
    {
        switch(column)
        {
            case 0:
                return "id_motor";
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
