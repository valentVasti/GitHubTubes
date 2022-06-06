/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Kendaraan_Mobil extends Kendaraan{
    private String kapasitas_Mobil;

    public Kendaraan_Mobil(String kapasitas_Mobil, String id_Kendaraan, String jenis, String nama_Kendaraan, String platNo, String merk, double tarif) {
        super(id_Kendaraan, jenis, nama_Kendaraan, platNo, merk, tarif);
        this.kapasitas_Mobil = kapasitas_Mobil;
    }

    public String getKapasitas_Mobil() {
        return kapasitas_Mobil;
    }

    public void setKapasitas_Mobil(String kapasitas_Mobil) {
        this.kapasitas_Mobil = kapasitas_Mobil;
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
