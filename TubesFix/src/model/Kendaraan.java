/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public abstract class Kendaraan {
    protected String id_Kendaraan;
    protected String jenis;
    protected String nama_Kendaraan;
    protected String platNo;
    protected String merk;
    protected String cc;
    protected double tarif;
    
    public Kendaraan(String id_Kendaraan, String jenis, String nama_Kendaraan, String platNo, String merk, String cc, double tarif){
        this.id_Kendaraan = id_Kendaraan;
        this.jenis = jenis;
        this.nama_Kendaraan = nama_Kendaraan;
        this.platNo = platNo;
        this.merk = merk;
        this.tarif = tarif;
        this.cc = cc;
    }
    
    public abstract String getId();
    public abstract String getNamaKendaraan();
    public abstract String getMerkKendaraan();
} 
