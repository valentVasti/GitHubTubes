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
    private Kendaraan kendaraan;
    private int durasi;
    private String jenis;
    private double total_Sewa;

    public Penyewaan(String id_Penyewaan, Customer customer, Transaksi transaksi, Guide guide, Kendaraan kendaraan, int durasi, String jenis, double total_Sewa) {
        this.id_Penyewaan = id_Penyewaan;
        this.customer = customer;
        this.transaksi = transaksi;
        this.guide = guide;
        this.kendaraan = kendaraan;
        this.durasi = durasi;
        this.jenis = jenis;
        this.total_Sewa = total_Sewa;
    }

    public String getId_Penyewaan() {
        return id_Penyewaan;
    }

    public void setId_Penyewaan(String id_Penyewaan) {
        this.id_Penyewaan = id_Penyewaan;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Transaksi getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }

    public int getDurasi() {
        return durasi;
    }

    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public double getTotal_Sewa() {
        return total_Sewa;
    }

    public void setTotal_Sewa(double total_Sewa) {
        this.total_Sewa = total_Sewa;
    }
    
    
    
    
    
    
}                                

