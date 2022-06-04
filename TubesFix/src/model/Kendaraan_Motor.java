/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Kendaraan_Motor extends Kendaraan{
    public Kendaraan_Motor(String id_Kendaraan, String jenis, String nama_Kendaraan, String platNo, String merk, double tarif){
        super(id_Kendaraan, jenis, nama_Kendaraan, platNo, merk, tarif);
    }
    
    @Override
    public String toString(){
        return nama_Kendaraan;
    }
}
