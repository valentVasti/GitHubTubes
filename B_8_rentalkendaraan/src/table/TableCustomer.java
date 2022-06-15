
package table;

import java.util.List;
import model.Customer;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Thomas Dany H
 */
public class TableCustomer extends AbstractTableModel{

    public static void setModel(List<Customer> showDataCustomer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private List<Customer> list;
    
    public TableCustomer(List<Customer> list){
        this.list = list;
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }
    
    @Override
    public int getColumnCount(){
        return 5;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0 :
                return list.get(rowIndex).getId_Customer();
            case 1:
                return list.get(rowIndex).getNama_Customer();
            case 2: 
                return list.get(rowIndex).getAlamat_Customer();
            case 3:
                return list.get(rowIndex).getUmur_Customer();
            case 4:
                return list.get(rowIndex).getTelp_Customer();
            default:
                return null;
        }
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Id_Customer";
            case 1:
                return "Nama_Customer";
            case 2:
                return "Alamat_Customer";
            case 3:
                return "Umur_Customer";
            case 4:
                return "NomorTelp_Customer";   
            default:
                return null;
        }
    }
}
