/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Customer {
    
    private String id_Customer;
    private String nama_Customer;
    private String alamat_Customer;
    private int umur_Customer;
    private String telp_Customer;
    
    public Customer(String id_Customer, String nama_Customer, String alamat_Customer, int umur_Customer, String telp_Customer){
        this.id_Customer = id_Customer;
        this.nama_Customer = nama_Customer;
        this.alamat_Customer = alamat_Customer;
        this.umur_Customer = umur_Customer;
        this.telp_Customer = telp_Customer;
    }
    
    public String getId_Customer(){
        return id_Customer;
    }
    
    public void setId_Customer(String id_Customer){
        this.id_Customer = id_Customer;
    }
    
    public String getNama_Customer(){
        return nama_Customer;
    }
    
    public void setNama_Customer(String nama_Customer){
        this.nama_Customer = nama_Customer;
    }
    
    public String getAlamat_Customer(){
        return alamat_Customer;
    }
    
    public void setAlamat_Customer(String alamat_Customer){
        this.alamat_Customer = alamat_Customer;
    }
    
    public int getUmur_Customer(){
        return umur_Customer;
    }
    
    public void setUmur_Customer(int umur_Customer){
        this.umur_Customer = umur_Customer;
    }
    
    //mau Id atau nama aja?
    @Override
    public String toString(){
        return nama_Customer;
    }    
}
