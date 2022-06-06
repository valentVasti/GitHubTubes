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

    public Penyewaan(String id_Penyewaan, Customer customer, Transaksi transaksi, Guide guide, Kendaraan_Mobil kendaraan_mobil, int durasi, String jenis, double total_Sewa) {
        this.id_Penyewaan = id_Penyewaan;
        this.customer = customer;
        this.transaksi = transaksi;
        this.guide = guide;
        this.kendaraan_mobil = kendaraan_mobil;
        this.durasi = durasi;
        this.jenis = jenis;
        this.total_Sewa = total_Sewa;
    }
    
    public Penyewaan(String id_Penyewaan, Customer customer, Transaksi transaksi, Guide guide, Kendaraan_Motor kendaraan_motor, int durasi, String jenis, double total_Sewa) {
        this.id_Penyewaan = id_Penyewaan;
        this.customer = customer;
        this.transaksi = transaksi;
        this.guide = guide;
        this.kendaraan_motor = kendaraan_motor;
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

    public Kendaraan_Mobil getKendaraan_mobil() {
        return kendaraan_mobil;
    }

    public void setKendaraan_mobil(Kendaraan_Mobil kendaraan_mobil) {
        this.kendaraan_mobil = kendaraan_mobil;
    }

    public Kendaraan_Motor getKendaraan_motor() {
        return kendaraan_motor;
    }

    public void setKendaraan_motor(Kendaraan_Motor kendaraan_motor) {
        this.kendaraan_motor = kendaraan_motor;
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

    
    public void setTotal_Sewa(double total_Sewa) {
        this.total_Sewa = total_Sewa;
    }
    
    
}                                

