/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import model.Guide;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUS
 */
public class TableGuide extends AbstractTableModel{
    private List<Guide> list;
    
    public TableGuide(List<Guide> list){
        this.list = list;
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }
    
    @Override
    public int getColumnCount(){
        return 4;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0 :
                return list.get(rowIndex).getId_Guide();
            case 1:
                return list.get(rowIndex).getNama_Guide();
            case 2: 
                return list.get(rowIndex).getAlamat_Guide();
            case 3:
                return list.get(rowIndex).getUmur_Guide();
            case 4:
                return list.get(rowIndex).getTelp_Guide();
            default:
                return null;
        }
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Id_Guide";
            case 1:
                return "Nama_Guide";
            case 2:
                return "Alamat_Guide";
            case 3:
                return "Umur_Guide";
            case 4:
                return "NomorTelp_Guide";   
            default:
                return null;
        }
    }
    
}
