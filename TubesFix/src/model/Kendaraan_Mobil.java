/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Kendaraan_Mobil extends Kendaraan{
    private String kapasitas_Mobil;

    public Kendaraan_Mobil(String id_Kendaraan, String jenis, String nama_Kendaraan, String platNo, String merk, String cc, double tarif, String kapasitas_Mobil) {
        super(id_Kendaraan, jenis, nama_Kendaraan, platNo, merk, cc, tarif);
        this.kapasitas_Mobil = kapasitas_Mobil;
    }
    
    public String getData(String data){
        switch(data){
            case "Id":
                return id_Kendaraan;
            case "jenis":
                return jenis;
            case "nama_Kendaraan":
                return nama_Kendaraan;
            case "platNo":
                return platNo;
            case "merk":
                return merk;
            case "cc":
                return cc;
            case "tarif":
                return Double.toString(tarif);
            case "kapasitas_Mobil":
                return kapasitas_Mobil;
            default:
                return null;
        }
    }

    public String getKapasitas_Mobil() {
        return kapasitas_Mobil;
    }

    public void setKapasitas_Mobil(String kapasitas_Mobil) {
        this.kapasitas_Mobil = kapasitas_Mobil;
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
    
    public String getNamaKendaraan(){
        return nama_Kendaraan;
    }
    
    public String getMerkKendaraan(){
        return merk;
    }
    
    @Override
    public String toString(){
        return nama_Kendaraan;
    }    
}
