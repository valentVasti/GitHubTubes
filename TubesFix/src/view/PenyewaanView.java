/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Control.penyewaanControl;
import Control.transaksiControl;
import Control.CustomerControl;
import control.KendaraanControl;
import Control.guideControl;
import dao.mobilDAO;
import model.Penyewaan;
import model.Customer;
import table.TablePenyewaan;
import dao.penyewaanDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.Kendaraan;
import model.Kendaraan_Mobil;
import model.Kendaraan_Motor;
import model.Transaksi;
import model.Guide;

public class PenyewaanView extends javax.swing.JFrame {
    private penyewaanControl penyewaanControl;
    private transaksiControl transaksiControl;
    private CustomerControl customerControl;
    private KendaraanControl kendaraanControl;
    private guideControl guideControl;        
    
    String action = null;
    String jenis = null;
    String selectedId = null;
    double totalSewa = 0;
    List<Penyewaan> listPenyewaan;
    List<Kendaraan> listMobil;
    List<Kendaraan> listMotor;
    List<Customer> listCustomer;
    List<Transaksi> listTransaksi;
    List<Guide> listGuide;
    Transaksi t = new Transaksi("", "", "", "");
    Customer selectedCustomer;
    Guide selectedGuide;
    Kendaraan selectedKendaraan;
    Penyewaan p;
       
    public PenyewaanView() {
        initComponents();
        setAddSearchComp(true);
        setOthComp(false);
        setEditDelComp(false);
        penyewaanControl = new penyewaanControl();
        transaksiControl = new transaksiControl();
        guideControl = new guideControl();
        kendaraanControl = new KendaraanControl();
        customerControl = new CustomerControl();
        showPenyewaan();
        setGuideToDropDown();
        setMobilToDropDown();
        setMotorToDropDown();        
        setCustomerToDropDown();
    }
    
    public PenyewaanView(Transaksi t, Penyewaan p) {
        initComponents();
        setAddSearchComp(true);
        setOthComp(false);
        setEditDelComp(false);
        penyewaanControl = new penyewaanControl();
        transaksiControl = new transaksiControl();
        guideControl = new guideControl();
        kendaraanControl = new KendaraanControl();
        customerControl = new CustomerControl();
        setGuideToDropDown();
        setMobilToDropDown();
        setMotorToDropDown();        
        setCustomerToDropDown();
        idTransaksiInput.setText(t.getId_Transaksi());
        insertAfterTransaksi(p, t);
        showPenyewaan();
    }
    
    public void setAddSearchComp(boolean value){
        addBtn.setEnabled(value);
        rekapBtn.setEnabled(value);
        searchBtn.setEnabled(value);
    }
    
    public void setOthComp(boolean value){
        idTransaksiInput.setEnabled(value);
        idPenyewaanInput.setEnabled(value);
        customerDropDown.setEnabled(value);
        guideDropDown.setEnabled(value);
        mobilRb.setEnabled(value);
        motorRb.setEnabled(value);
        durasiInput.setEnabled(value);
        
        saveBtn.setEnabled(value);
        cancelBtn.setEnabled(value);
    }
    
    public void setEditDelComp(boolean value){
        rekapBtn.setEnabled(value);
        deleteBtn.setEnabled(value);
    }
    
    public void clearText(){
        customerDropDown.setSelectedItem(-1);
        motorBox.setSelectedItem(ABORT);
        mobilBox.setSelectedItem(ABORT);
        durasiInput.setText("");
        mobilRb.setSelected(false);
        motorRb.setSelected(false);
    }
    
    public void showPenyewaan(){
        penyewaanTabel.setModel(penyewaanControl.showPenyewaan(""));
    }
    
    public void setCustomerToDropDown(){
        listCustomer = customerControl.showDataCustomer();
             for(int i=0; i<listCustomer.size(); i++){
                    customerDropDown.addItem(listCustomer.get(i));    
            }
    }
    
    public void setMobilToDropDown(){
        listMobil = kendaraanControl.showListMobil();
             for(int i=0; i<listMobil.size(); i++){
                    mobilBox.addItem(listMobil.get(i));    
            }
    }

    public void setMotorToDropDown(){
        listMotor = kendaraanControl.showListMotor();
             for(int i=0; i<listMotor.size(); i++){
                    motorBox.addItem(listMotor.get(i));    
            }
    }
    
    public void setGuideToDropDown(){
        listGuide = guideControl.showDataGuide();
            for(int i=0; i<listGuide.size(); i++){
                    guideDropDown.addItem(listGuide.get(i));    
            }
             
    }
    
    public void insertAfterTransaksi(Penyewaan p, Transaksi t){
        Penyewaan pNew = new Penyewaan(p.getId_Penyewaan(), p.getCustomer(), t, p.getGuide(), 
                p.getKendaraan(), p.getDurasi(), p.getJenis(), p.getTotal_Sewa());
        penyewaanControl.insertDataPenyewaan(pNew);
    }
    
    public Penyewaan penyewaanGenerate(){
        int clickedRowPenyewaan = penyewaanTabel.getSelectedRow();
        Kendaraan selectedKendaraan = listMobil.get(0);
        String jenis = null;
        
        int selectedIndex = customerDropDown.getSelectedIndex();
        Customer selectedCustomer = listCustomer.get(selectedIndex);
        
        if(mobilRb.isSelected()){
            selectedIndex = mobilBox.getSelectedIndex();
            selectedKendaraan = listMobil.get(selectedIndex);
            jenis = "Mobil";
        }else if(motorRb.isSelected()){
            selectedIndex = motorBox.getSelectedIndex();
            selectedKendaraan = listMotor.get(selectedIndex);
            jenis = "Motor";
        }

        selectedIndex = guideDropDown.getSelectedIndex();
        Guide selectedGuide = listGuide.get(selectedIndex);
            
        double totalSewa = Integer.parseInt(durasiInput.getText()) * Double.parseDouble(selectedKendaraan.getData("tarif"));

        Penyewaan p = new Penyewaan(idPenyewaanInput.getText(),selectedCustomer, t, selectedGuide, 
                selectedKendaraan, Integer.parseInt(durasiInput.getText()), jenis, totalSewa 
                );
                
        return p;
    }
    
    public void showRekapan(Penyewaan p){
        String rekapan = "==== REKAPAN PENYEWAAN ====" 
                + "\nID Penyewaan    " + p.getId_Penyewaan() 
                + "\nCustomer        " + p.getCustomer().getNama_Customer()
                + "\nID Transaksi    " + p.getTransaksi().getId_Transaksi()
                + "\n---------------------------------------------------"
                + "\n" + p.getKendaraan().getData("jenis")
                + "\n" + p.getKendaraan().getData("merk") + " " +p.getKendaraan().getData("nama")
                + "\nTARIF         @" + p.getKendaraan().getData("tarif")
                + "\nDURASI PENYEAWAAN  " + p.getDurasi() + " HARI"
                + "\nTOTAL SEWA         " + p.getTotal_Sewa()
                + "\nStatus Bayar    " + p.getTransaksi().getStatus_Pembayaran()
                + "\n=====================================================\n";
        rekapanField.setText(rekapan);
    }
        
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioStatusPembayaran = new javax.swing.ButtonGroup();
        radioJenisPembayaran = new javax.swing.ButtonGroup();
        commandPanel = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        rekapBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        headerPanel3 = new javax.swing.JPanel();
        logoDalamPanel3 = new javax.swing.JPanel();
        logoLuarPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        menuPanel = new javax.swing.JPanel();
        menu1Panel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        menu2Panel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        menu3Panel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        menu4Panel = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        menu5Panel = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        homeBtn = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        searchBtn = new javax.swing.JButton();
        searchInput = new javax.swing.JTextField();
        tanggalPanel3 = new javax.swing.JPanel();
        durasiLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        penyewaanPanel = new javax.swing.JPanel();
        penyewaanInput = new javax.swing.JLabel();
        idPenyewaanInput = new javax.swing.JTextField();
        transaksiPanel = new javax.swing.JPanel();
        transaksiLabel = new javax.swing.JLabel();
        idTransaksiInput = new javax.swing.JTextField();
        tanggalPanel1 = new javax.swing.JPanel();
        pilihLabel = new javax.swing.JLabel();
        customerDropDown = new javax.swing.JComboBox<>();
        tanggalPanel2 = new javax.swing.JPanel();
        pilihLabel1 = new javax.swing.JLabel();
        mobilRb = new javax.swing.JRadioButton();
        motorRb = new javax.swing.JRadioButton();
        mobilBox = new javax.swing.JComboBox<>();
        motorBox = new javax.swing.JComboBox<>();
        tanggalPanel = new javax.swing.JPanel();
        durasiLabel = new javax.swing.JLabel();
        durasiInput = new javax.swing.JTextField();
        guidePanel = new javax.swing.JPanel();
        guideDropDown = new javax.swing.JComboBox<>();
        guideLabel = new javax.swing.JLabel();
        lanjutkanPembayaranBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        penyewaanTabel = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        commandPanel.setBackground(new java.awt.Color(255, 255, 255));
        commandPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 51, 51), new java.awt.Color(255, 102, 102), new java.awt.Color(255, 102, 102), new java.awt.Color(255, 51, 51)), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 4)), "COMMAND", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Berlin Sans FB Demi", 1, 18), new java.awt.Color(51, 51, 51))); // NOI18N

        addBtn.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        addBtn.setText("TAMBAH");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        rekapBtn.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        rekapBtn.setText("rekap");
        rekapBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rekapBtnActionPerformed(evt);
            }
        });

        deleteBtn.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        deleteBtn.setText("HAPUS");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        saveBtn.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        saveBtn.setText("SIMPAN");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        cancelBtn.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        cancelBtn.setText("BATAL");

        javax.swing.GroupLayout commandPanelLayout = new javax.swing.GroupLayout(commandPanel);
        commandPanel.setLayout(commandPanelLayout);
        commandPanelLayout.setHorizontalGroup(
            commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commandPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rekapBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        commandPanelLayout.setVerticalGroup(
            commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commandPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addBtn)
                .addGap(14, 14, 14)
                .addComponent(rekapBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelBtn)
                .addGap(48, 48, 48))
        );

        headerPanel3.setBackground(new java.awt.Color(204, 0, 0));
        headerPanel3.setPreferredSize(new java.awt.Dimension(800, 150));

        logoDalamPanel3.setBackground(new java.awt.Color(255, 102, 0));

        logoLuarPanel3.setBackground(new java.awt.Color(255, 204, 204));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/main.png"))); // NOI18N

        javax.swing.GroupLayout logoLuarPanel3Layout = new javax.swing.GroupLayout(logoLuarPanel3);
        logoLuarPanel3.setLayout(logoLuarPanel3Layout);
        logoLuarPanel3Layout.setHorizontalGroup(
            logoLuarPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoLuarPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        logoLuarPanel3Layout.setVerticalGroup(
            logoLuarPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoLuarPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout logoDalamPanel3Layout = new javax.swing.GroupLayout(logoDalamPanel3);
        logoDalamPanel3.setLayout(logoDalamPanel3Layout);
        logoDalamPanel3Layout.setHorizontalGroup(
            logoDalamPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoDalamPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoLuarPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        logoDalamPanel3Layout.setVerticalGroup(
            logoDalamPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoDalamPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoLuarPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuPanel.setBackground(new java.awt.Color(255, 204, 204));
        menuPanel.setForeground(new java.awt.Color(255, 255, 255));

        menu1Panel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/car rent.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel17.setText("Penyewaan");

        javax.swing.GroupLayout menu1PanelLayout = new javax.swing.GroupLayout(menu1Panel);
        menu1Panel.setLayout(menu1PanelLayout);
        menu1PanelLayout.setHorizontalGroup(
            menu1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu1PanelLayout.createSequentialGroup()
                .addGroup(menu1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menu1PanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel11))
                    .addGroup(menu1PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        menu1PanelLayout.setVerticalGroup(
            menu1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu1PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17))
        );

        menu2Panel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/customer.png"))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel18.setText("Customer");

        javax.swing.GroupLayout menu2PanelLayout = new javax.swing.GroupLayout(menu2Panel);
        menu2Panel.setLayout(menu2PanelLayout);
        menu2PanelLayout.setHorizontalGroup(
            menu2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu2PanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(menu2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addGroup(menu2PanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel18)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        menu2PanelLayout.setVerticalGroup(
            menu2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu2PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addContainerGap())
        );

        menu3Panel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/car.png"))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel19.setText("Kendaraan");

        javax.swing.GroupLayout menu3PanelLayout = new javax.swing.GroupLayout(menu3Panel);
        menu3Panel.setLayout(menu3PanelLayout);
        menu3PanelLayout.setHorizontalGroup(
            menu3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu3PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(menu3PanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addContainerGap())
        );
        menu3PanelLayout.setVerticalGroup(
            menu3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu3PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addContainerGap())
        );

        menu4Panel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel20.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel20.setText("Guide");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/tour guide.png"))); // NOI18N

        javax.swing.GroupLayout menu4PanelLayout = new javax.swing.GroupLayout(menu4Panel);
        menu4Panel.setLayout(menu4PanelLayout);
        menu4PanelLayout.setHorizontalGroup(
            menu4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu4PanelLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(menu4PanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menu4PanelLayout.setVerticalGroup(
            menu4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu4PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addContainerGap())
        );

        menu5Panel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/transaction.png"))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel21.setText("Transaksi");

        javax.swing.GroupLayout menu5PanelLayout = new javax.swing.GroupLayout(menu5Panel);
        menu5Panel.setLayout(menu5PanelLayout);
        menu5PanelLayout.setHorizontalGroup(
            menu5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu5PanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel21)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(menu5PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        menu5PanelLayout.setVerticalGroup(
            menu5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu5PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addContainerGap())
        );

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(menu1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menu2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menu3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menu4Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menu5Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu3Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu4Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(menu5Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        titlePanel.setBackground(new java.awt.Color(255, 204, 204));
        titlePanel.setForeground(new java.awt.Color(255, 255, 255));

        titleLabel.setBackground(new java.awt.Color(0, 0, 0));
        titleLabel.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("FORM PENYEWAAN");
        titleLabel.setToolTipText("");

        homeBtn.setFont(new java.awt.Font("Stencil Std", 0, 18)); // NOI18N
        homeBtn.setText("home");
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(homeBtn)
                .addGap(0, 0, 0))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout headerPanel3Layout = new javax.swing.GroupLayout(headerPanel3);
        headerPanel3.setLayout(headerPanel3Layout);
        headerPanel3Layout.setHorizontalGroup(
            headerPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoDalamPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(headerPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        headerPanel3Layout.setVerticalGroup(
            headerPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logoDalamPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(headerPanel3Layout.createSequentialGroup()
                        .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.red, java.awt.Color.red, java.awt.Color.red, java.awt.Color.red), new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true)), "INPUT", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tw Cen MT", 1, 18))); // NOI18N

        searchBtn.setText("Cari");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        tanggalPanel3.setBackground(new java.awt.Color(255, 255, 255));

        durasiLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        durasiLabel1.setText("Rekapan Penyewaan");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout tanggalPanel3Layout = new javax.swing.GroupLayout(tanggalPanel3);
        tanggalPanel3.setLayout(tanggalPanel3Layout);
        tanggalPanel3Layout.setHorizontalGroup(
            tanggalPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tanggalPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tanggalPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tanggalPanel3Layout.createSequentialGroup()
                        .addComponent(durasiLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
                .addContainerGap())
        );
        tanggalPanel3Layout.setVerticalGroup(
            tanggalPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tanggalPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(durasiLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addContainerGap())
        );

        penyewaanPanel.setBackground(new java.awt.Color(255, 255, 255));

        penyewaanInput.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        penyewaanInput.setText("ID Penyewaan");

        transaksiPanel.setBackground(new java.awt.Color(255, 255, 255));

        transaksiLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        transaksiLabel.setText("ID Transaksi");

        idTransaksiInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTransaksiInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout transaksiPanelLayout = new javax.swing.GroupLayout(transaksiPanel);
        transaksiPanel.setLayout(transaksiPanelLayout);
        transaksiPanelLayout.setHorizontalGroup(
            transaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(transaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idTransaksiInput)
                    .addGroup(transaksiPanelLayout.createSequentialGroup()
                        .addComponent(transaksiLabel)
                        .addContainerGap(223, Short.MAX_VALUE))))
        );
        transaksiPanelLayout.setVerticalGroup(
            transaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(transaksiLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idTransaksiInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tanggalPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pilihLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        pilihLabel.setText("Pilih Nama Customer");

        customerDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerDropDownActionPerformed(evt);
            }
        });

        tanggalPanel2.setBackground(new java.awt.Color(255, 255, 255));

        pilihLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        pilihLabel1.setText("Pilih Kendaraan");

        mobilRb.setText("Mobil");
        mobilRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobilRbActionPerformed(evt);
            }
        });

        motorRb.setText("Motor");
        motorRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motorRbActionPerformed(evt);
            }
        });

        mobilBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobilBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tanggalPanel2Layout = new javax.swing.GroupLayout(tanggalPanel2);
        tanggalPanel2.setLayout(tanggalPanel2Layout);
        tanggalPanel2Layout.setHorizontalGroup(
            tanggalPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tanggalPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tanggalPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mobilBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pilihLabel1)
                    .addComponent(mobilRb, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tanggalPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(motorBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(motorRb, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        tanggalPanel2Layout.setVerticalGroup(
            tanggalPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tanggalPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pilihLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tanggalPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobilRb)
                    .addComponent(motorRb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tanggalPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobilBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(motorBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tanggalPanel1Layout = new javax.swing.GroupLayout(tanggalPanel1);
        tanggalPanel1.setLayout(tanggalPanel1Layout);
        tanggalPanel1Layout.setHorizontalGroup(
            tanggalPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tanggalPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tanggalPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customerDropDown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(tanggalPanel1Layout.createSequentialGroup()
                        .addGroup(tanggalPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tanggalPanel1Layout.createSequentialGroup()
                                .addComponent(pilihLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tanggalPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        tanggalPanel1Layout.setVerticalGroup(
            tanggalPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tanggalPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pilihLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(customerDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tanggalPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tanggalPanel.setBackground(new java.awt.Color(255, 255, 255));

        durasiLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        durasiLabel.setText("Durasi Penyewaan");

        durasiInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                durasiInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tanggalPanelLayout = new javax.swing.GroupLayout(tanggalPanel);
        tanggalPanel.setLayout(tanggalPanelLayout);
        tanggalPanelLayout.setHorizontalGroup(
            tanggalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tanggalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tanggalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(durasiInput)
                    .addGroup(tanggalPanelLayout.createSequentialGroup()
                        .addComponent(durasiLabel)
                        .addGap(0, 195, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tanggalPanelLayout.setVerticalGroup(
            tanggalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tanggalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(durasiLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(durasiInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout penyewaanPanelLayout = new javax.swing.GroupLayout(penyewaanPanel);
        penyewaanPanel.setLayout(penyewaanPanelLayout);
        penyewaanPanelLayout.setHorizontalGroup(
            penyewaanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(penyewaanPanelLayout.createSequentialGroup()
                .addGroup(penyewaanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(penyewaanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tanggalPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(transaksiPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tanggalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(penyewaanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(penyewaanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idPenyewaanInput, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(penyewaanInput))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        penyewaanPanelLayout.setVerticalGroup(
            penyewaanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(penyewaanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(penyewaanInput)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idPenyewaanInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(transaksiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tanggalPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tanggalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        guidePanel.setBackground(new java.awt.Color(250, 250, 250));

        guideLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        guideLabel.setText("Guide");

        javax.swing.GroupLayout guidePanelLayout = new javax.swing.GroupLayout(guidePanel);
        guidePanel.setLayout(guidePanelLayout);
        guidePanelLayout.setHorizontalGroup(
            guidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(guidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(guidePanelLayout.createSequentialGroup()
                        .addComponent(guideLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(guideDropDown, 0, 297, Short.MAX_VALUE))
                .addContainerGap())
        );
        guidePanelLayout.setVerticalGroup(
            guidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(guideLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guideDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        lanjutkanPembayaranBtn.setText("Lanjutkan ke pembayaran");
        lanjutkanPembayaranBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lanjutkanPembayaranBtnActionPerformed(evt);
            }
        });

        penyewaanTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        penyewaanTabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                penyewaanTabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(penyewaanTabel);

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(penyewaanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(19, 19, 19)
                            .addComponent(searchBtn))
                        .addComponent(tanggalPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(lanjutkanPembayaranBtn))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(guidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBtn))
                        .addGap(18, 18, 18)
                        .addComponent(tanggalPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(guidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lanjutkanPembayaranBtn))
                    .addComponent(penyewaanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 993, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(commandPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(commandPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed

    }//GEN-LAST:event_saveBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        mobilBox.setEnabled(false);
        motorBox.setEnabled(false);
        rekapBtn.setEnabled(true);
        setOthComp(true);
        clearText();
        idTransaksiInput.setEnabled(false);
        action = "Tambah";        
    }//GEN-LAST:event_addBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int getAnswer = JOptionPane.showConfirmDialog(rootPane, "Apakah yakin ingin menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        switch(getAnswer){
            case 0:
                try {
                penyewaanControl.deletePenyewaan(selectedId);
                clearText();
                showPenyewaan();
                setOthComp(false);
                setAddSearchComp(true);
                JOptionPane.showMessageDialog(this, "Berhasil menghapus data!");
             
            } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Gagal menghapus pembeli");
                    System.out.println("Error : "+e.getMessage());
            }
                break;
            
            case 1:
                break;
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        Home h = new Home();
        this.dispose();
        h.setVisible(true);
    }//GEN-LAST:event_homeBtnActionPerformed

    private void lanjutkanPembayaranBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lanjutkanPembayaranBtnActionPerformed
        TransaksiView tv = new TransaksiView(penyewaanGenerate());
        this.dispose();
        tv.setVisible(true);
    }//GEN-LAST:event_lanjutkanPembayaranBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed

    }//GEN-LAST:event_searchBtnActionPerformed

    private void mobilBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobilBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobilBoxActionPerformed

    private void customerDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerDropDownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerDropDownActionPerformed

    private void durasiInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_durasiInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_durasiInputActionPerformed

    private void idTransaksiInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTransaksiInputActionPerformed

    }//GEN-LAST:event_idTransaksiInputActionPerformed

    private void penyewaanTabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_penyewaanTabelMouseClicked
        
        int indexTransaksi = -1;
        int indexCustomer = -1;
        int indexKendaraan = -1;
        int indexGuide = -1;
        setEditDelComp(true);
        setOthComp(false);

        int clickedRow = penyewaanTabel.getSelectedRow();
        TableModel tableModel = penyewaanTabel.getModel();

        selectedId = tableModel.getValueAt(clickedRow, 0).toString();
        idPenyewaanInput.setText(selectedId);

        String idTransaksi = tableModel.getValueAt(clickedRow, 6).toString();
        idTransaksiInput.setText(idTransaksi);

        String idCustomer = tableModel.getValueAt(clickedRow, 1).toString();

        for(Customer customer : listCustomer){
            if(customer.getId_Customer().equals(idCustomer)){
                indexCustomer = listCustomer.indexOf(idCustomer);
            }
        }

        customerDropDown.setSelectedIndex(indexCustomer);

        String idKendaraan = tableModel.getValueAt(clickedRow, 3).toString();

        if(idKendaraan.contains("MOB")){
            mobilRb.setSelected(true);
            for(Kendaraan kendaraan : listMobil){
                if(kendaraan.getId().equals(idKendaraan)){
                    indexKendaraan = listMobil.indexOf(idKendaraan);
                }
            }
            mobilBox.setSelectedIndex(indexKendaraan);
            motorBox.setSelectedIndex(-1);
        }else if(idKendaraan.contains("MOT")){
            motorRb.setSelected(true);
            for(Kendaraan kendaraan : listMotor){
                if(kendaraan.getId().equals(idKendaraan)){
                    indexKendaraan = listMobil.indexOf(idKendaraan);
                }
            }
            motorBox.setSelectedIndex(indexKendaraan);
            mobilBox.setSelectedIndex(-1);
        }

        durasiInput.setText(tableModel.getValueAt(clickedRow, 10).toString());

        String idGuide = tableModel.getValueAt(clickedRow, 11).toString();

        for(Guide guide : listGuide){
            if(guide.getId_Guide().equals(idGuide)){
                indexGuide = listGuide.indexOf(guide);
            }
        }

        guideDropDown.setSelectedIndex(indexGuide);
        
        
    }//GEN-LAST:event_penyewaanTabelMouseClicked

    private void mobilRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobilRbActionPerformed
        mobilBox.setEnabled(true);
        mobilBox.setSelectedIndex(-1);
        motorBox.setEnabled(false);
    }//GEN-LAST:event_mobilRbActionPerformed

    private void motorRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motorRbActionPerformed
        motorBox.setEnabled(true);
        motorBox.setSelectedIndex(-1);
        mobilBox.setEnabled(false);
    }//GEN-LAST:event_motorRbActionPerformed

    private void rekapBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rekapBtnActionPerformed
        showRekapan(penyewaanGenerate());
        setOthComp(false);
        
    }//GEN-LAST:event_rekapBtnActionPerformed
    
    public static void main(String args[]) {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
             * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
             */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(GuideView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(GuideView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(GuideView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(GuideView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new PenyewaanView().setVisible(true);
                }
            });
        }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPanel commandPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JComboBox<Customer> customerDropDown;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField durasiInput;
    private javax.swing.JLabel durasiLabel;
    private javax.swing.JLabel durasiLabel1;
    private javax.swing.JComboBox<Guide> guideDropDown;
    private javax.swing.JLabel guideLabel;
    private javax.swing.JPanel guidePanel;
    private javax.swing.JPanel headerPanel3;
    private javax.swing.JButton homeBtn;
    private javax.swing.JTextField idPenyewaanInput;
    private javax.swing.JTextField idTransaksiInput;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton lanjutkanPembayaranBtn;
    private javax.swing.JPanel logoDalamPanel3;
    private javax.swing.JPanel logoLuarPanel3;
    private javax.swing.JPanel menu1Panel;
    private javax.swing.JPanel menu2Panel;
    private javax.swing.JPanel menu3Panel;
    private javax.swing.JPanel menu4Panel;
    private javax.swing.JPanel menu5Panel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JComboBox<Kendaraan> mobilBox;
    private javax.swing.JRadioButton mobilRb;
    private javax.swing.JComboBox<Kendaraan> motorBox;
    private javax.swing.JRadioButton motorRb;
    private javax.swing.JLabel penyewaanInput;
    private javax.swing.JPanel penyewaanPanel;
    private javax.swing.JTable penyewaanTabel;
    private javax.swing.JLabel pilihLabel;
    private javax.swing.JLabel pilihLabel1;
    private javax.swing.ButtonGroup radioJenisPembayaran;
    private javax.swing.ButtonGroup radioStatusPembayaran;
    private javax.swing.JButton rekapBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchInput;
    private javax.swing.JPanel tanggalPanel;
    private javax.swing.JPanel tanggalPanel1;
    private javax.swing.JPanel tanggalPanel2;
    private javax.swing.JPanel tanggalPanel3;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JLabel transaksiLabel;
    private javax.swing.JPanel transaksiPanel;
    // End of variables declaration//GEN-END:variables
}
