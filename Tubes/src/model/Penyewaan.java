/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

public class Penyewaan {
    private String id_Penyewaan;
    private Customer customer;
    private Transaksi transaksi;
    private String id_Guide;
    private int durasi;
    private double total_Sewa;
    
    ArrayList<Kendaraan> listKendaraan = new ArrayList<>();
    
    public Penyewaan(String id_Penyewaan, Customer customer, Transaksi transaksi, String id_Guide, int durasi, double total_Sewa){
        this.id_Penyewaan = id_Penyewaan;
        this.customer = customer;
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
    
    public void addKendaraan(Kendaraan k){
        listKendaraan.add(k);
    }
}                                

