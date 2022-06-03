/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Penyewaan {
    public String id_Penyewaan;
    public Customer customer;
    public Kendaraan kendaraan;
    public Transaksi transaksi;
    public String id_Guide;
    public int durasi;
    public double total_Sewa;
    
    public Penyewaan(String id_Penyewaan, Customer customer, Kendaraan kendaraan, Transaksi transaksi, String id_Guide, int durasi, double total_Sewa){
        this.id_Penyewaan = id_Penyewaan;
        this.customer = customer;
        this.kendaraan = kendaraan;
        this.transaksi = transaksi;
        this.id_Guide = id_Guide;
        this.durasi = durasi;
        this.total_Sewa = total_Sewa;
    }
    
    public String getId_Penyewaan(){
        return id_Penyewaan;
    }
    
    public void setId_Penyewaan(){
        this.id_Penyewaan = id_Penyewaan;
    }
    
    public Customer getCustomer(){
        return customer;
    }
    
    public Kendaraan getKendaraan(){
        return kendaraan;
    }
    
    public Transaksi getTransaksi(){
        return transaksi;
    }
    
    //getter sm setter guide masi belom tau
    
    public int getDurasi(){
        return durasi;
    }
    
    public void setDurasi(int durasi){
        this.durasi = durasi;
    }
    
    public double getTotal_Sewa(){
        return total_Sewa;
    }
    
    public void setTotal_Sewa(double total_Sewa){
        this.total_Sewa = total_Sewa;
    }
                                                                          
}
