/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Guide {
    
    private String id_Guide;
    private String nama_Guide;
    private String alamat_Guide;
    private int umur_Guide;
    private String telp_Guide;
    
    public Guide(String id_Guide, String nama_Guide, String alamat_Guide, int umur_Guide, String telp_Guide){
        this.id_Guide = id_Guide;
        this.nama_Guide = nama_Guide;
        this.alamat_Guide = alamat_Guide;
        this.umur_Guide = umur_Guide;
        this.telp_Guide = telp_Guide;
    }
    
    public String getId_Guide(){
        return id_Guide;
    }
    
    public void setId_Guide(String id_Guide){
        this.id_Guide = id_Guide;
    }
    
    public String getNama_Guide(){
        return nama_Guide;
    }
    
    public void setNama_Guide(String nama_Guide){
        this.nama_Guide = nama_Guide;
    }
    
    public String getAlamat_Guide(){
        return alamat_Guide;
    }
    
    public void setAlamat_Guide(String alamat_Guide){
        this.alamat_Guide = alamat_Guide;
    }
    
    public int getUmur_Guide(){
        return umur_Guide;
    }
    
    public void setUmur_Guide(int umur_Guide){
        this.umur_Guide = umur_Guide;
    }
    
    public String getTelp_Guide(){
        return telp_Guide;
    }
    
    public void setTelp_Guide(String telp_Guide){
        this.telp_Guide = telp_Guide;
    }
    
    //mau Id atau nama aja?
    @Override
    public String toString(){
        String temp;
        temp = nama_Guide;
        return temp;
    }     
}
