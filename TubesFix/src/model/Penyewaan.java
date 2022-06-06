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
    private Guide guide;
    private Kendaraan_Mobil kendaraan_mobil;
    private Kendaraan_Motor kendaraan_motor;
    private int durasi;
    private String jenis;
    private double total_Sewa;

    public Penyewaan(String id_Penyewaan, Customer customer, Transaksi transaksi, Guide guide, Kendaraan kendaraan, int durasi, String jenis, double total_Sewa) {
        this.id_Penyewaan = id_Penyewaan;
        this.customer = customer;
        this.transaksi = transaksi;
        this.guide = guide;
        this.kendaraan_mobil = kendaraan_mobil;
        this.durasi = durasi;
        this.jenis = jenis;
        this.total_Sewa = total_Sewa;
    }
    
    
    
    
    
}                                

