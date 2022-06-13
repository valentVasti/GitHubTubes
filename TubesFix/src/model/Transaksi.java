/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Transaksi {
    private String id_Transaksi;
    private String status_Pembayaran;
    private String jenis_Pembayaran;
    private String tanggal_Transaksi;
    
    public Transaksi(String id_Transaksi, String status_Pembayaran, String jenis_Pembayaran, String tanggal_Transaksi){
        this.id_Transaksi = id_Transaksi;
        this.status_Pembayaran = status_Pembayaran;
        this.jenis_Pembayaran = jenis_Pembayaran;
        this.tanggal_Transaksi = tanggal_Transaksi;
    }
    
    public String getId_Transaksi(){
        return id_Transaksi;
    }
    
    public void setId_Transaksi(String id_Transaksi){
        this.id_Transaksi = id_Transaksi;
    }
    
    public String getStatus_Pembayaran(){
        return status_Pembayaran;
    }
    
    public void setStatus_Pembayaran(String status_Pembayaran){
        this.status_Pembayaran = status_Pembayaran;
    }
    
    public String getJenis_Pembayaran(){
        return jenis_Pembayaran;
    }
    
    public void setJenis_Pembayaran(String jenis_Pembayaran){
        this.jenis_Pembayaran = jenis_Pembayaran;
    }
    
    public String getTanggal_Transaksi(){
        return tanggal_Transaksi;
    }
    
    public void setTanggal_Transaksi(String tanggal_Transaksi){
        this.tanggal_Transaksi = tanggal_Transaksi;
    }
    
    @Override
    public String toString(){
        return id_Transaksi;
    } 
}
