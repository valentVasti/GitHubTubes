/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Kendaraan_Motor extends Kendaraan{
    private String jenis_Helm;
    private String jenis_Stang;

    public Kendaraan_Motor(String jenis_Helm, String jenis_Stang, String id_Kendaraan, String jenis, String nama_Kendaraan, String platNo, String merk, String cc, double tarif) {
        super(id_Kendaraan, jenis, nama_Kendaraan, platNo, merk, cc, tarif);
        this.jenis_Helm = jenis_Helm;
        this.jenis_Stang = jenis_Stang;
    }

    public String getJenis_Helm() {
        return jenis_Helm;
    }

    public void setJenis_Helm(String jenis_Helm) {
        this.jenis_Helm = jenis_Helm;
    }

    public String getJenis_Stang() {
        return jenis_Stang;
    }

    public void setJenis_Stang(String jenis_Stang) {
        this.jenis_Stang = jenis_Stang;
    }

    public String getId_Kendaraan() {
        return id_Kendaraan;
    }

    public void setId_Kendaraan(String id_Kendaraan) {
        this.id_Kendaraan = id_Kendaraan;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getNama_Kendaraan() {
        return nama_Kendaraan;
    }

    public void setNama_Kendaraan(String nama_Kendaraan) {
        this.nama_Kendaraan = nama_Kendaraan;
    }

    public String getPlatNo() {
        return platNo;
    }

    public void setPlatNo(String platNo) {
        this.platNo = platNo;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }
    
    public String getCC() {
        return cc;
    }

    public void setCC(String cc) {
        this.cc = cc;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }
    
    
    
    
    public String getId(){
        return id_Kendaraan;
    }
    
    @Override
    public String toString(){
        return nama_Kendaraan;
    }
}
