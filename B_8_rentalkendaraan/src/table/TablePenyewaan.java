/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Penyewaan;
import model.Kendaraan;

public class TablePenyewaan extends AbstractTableModel{
     private List<Penyewaan> list;
    
    public TablePenyewaan(List<Penyewaan> list){
        this.list = list;
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }
    
    @Override
    public int getColumnCount(){
        return 13;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0 :
                return list.get(rowIndex).getId_Penyewaan();
            case 1:
                return list.get(rowIndex).getCustomer().getId_Customer();
            case 2: 
                return list.get(rowIndex).getCustomer().getNama_Customer();
            case 3:
                return list.get(rowIndex).getKendaraan().getId();
            case 4:
                return list.get(rowIndex).getKendaraan().getNamaKendaraan();
            case 5:
                return list.get(rowIndex).getKendaraan().getMerkKendaraan();
            case 6:
                return list.get(rowIndex).getTransaksi().getId_Transaksi();
            case 7:
                return list.get(rowIndex).getTotal_Sewa();
            case 8:
                return list.get(rowIndex).getTransaksi().getJenis_Pembayaran();
            case 9:
                return list.get(rowIndex).getTransaksi().getStatus_Pembayaran();
            case 10:
                return list.get(rowIndex).getDurasi();
            case 11:
                return list.get(rowIndex).getGuide().getId_Guide();
            case 12 :
                return list.get(rowIndex).getGuide().getNama_Guide();
            default:
                return null;
        }
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID Penyewaan";
            case 1:
                return "ID Costumer";
            case 2:
                return "Nama Costumer";
            case 3:
                return "ID Kendaraan";
            case 4:
                return "Nama Kendaraan";  
            case 5:
                return "Merk Kendaraan"; 
            case 6:
                return "ID Transaksi"; 
            case 7:
                return "Total Sewa";
            case 8:
                return "Jenis Pembayaran"; 
            case 9:
                return "Status Pembayaran"; 
            case 10:
                return "Durasi Penyewaan"; 
            case 11:
                return "ID Guide";
            case 12:
                return "Nama Guide";  
            default:
                return null;
        }
    }
}
