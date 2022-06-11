/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Control.penyewaanControl;
import model.Penyewaan;
import model.Customer;
import table.TablePenyewaan;
import dao.penyewaanDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class PenyewaanView extends javax.swing.JFrame {
private penyewaanControl penyewaanControl;
    
    String action = null;
    String selectedId = null;
    List<Penyewaan> listPenyewaan;
    
    public PenyewaanView() {
        initComponents();
        setAddSearchComp(true);
        setOthComp(false);
        setEditDelComp(false);
        penyewaanControl = new penyewaanControl();
        showPenyewaan();
    }
    
    public void setAddSearchComp(boolean value){
        addBtn.setEnabled(value);
        editBtn.setEnabled(value);
        searchBtn.setEnabled(value);
    }
    
    public void setOthComp(boolean value){
        penyewaanInput.setEnabled(value);
        pilihDropDown.setEnabled(value);
        mobilRb.setEnabled(value);
        motorRb.setEnabled(value);
        durasiInput.setEnabled(value);
        mobilBox.setEnabled(value);
        motorBox.setEnabled(value);
        
        saveBtn.setEnabled(value);
        cancelBtn.setEnabled(value);
    }
    
    public void setEditDelComp(boolean value){
        editBtn.setEnabled(value);
        deleteBtn.setEnabled(value);
    }
    
    public void clearText(){
        pilihDropDown.setSelectedItem(ABORT);
        motorBox.setSelectedItem(ABORT);
        mobilBox.setSelectedItem(ABORT);
        penyewaanInput.setText("");
        durasiInput.setText("");
        mobilRb.setSelected(false);
        motorRb.setSelected(false);
    }
    
    public void showPenyewaan(){
        penyewaanTabel1.setModel(penyewaanControl.showPenyewaan(""));
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioStatusPembayaran = new javax.swing.ButtonGroup();
        radioJenisPembayaran = new javax.swing.ButtonGroup();
        commandPanel = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        transaksiPanel = new javax.swing.JPanel();
        transaksiLabel = new javax.swing.JLabel();
        penyewaanInput = new javax.swing.JTextField();
        tanggalPanel = new javax.swing.JPanel();
        durasiLabel = new javax.swing.JLabel();
        durasiInput = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        penyewaanTabel1 = new javax.swing.JTable();
        tanggalPanel1 = new javax.swing.JPanel();
        pilihLabel = new javax.swing.JLabel();
        pilihDropDown = new javax.swing.JComboBox<>();
        tanggalPanel2 = new javax.swing.JPanel();
        pilihLabel1 = new javax.swing.JLabel();
        mobilRb = new javax.swing.JRadioButton();
        motorRb = new javax.swing.JRadioButton();
        mobilBox = new javax.swing.JComboBox<>();
        motorBox = new javax.swing.JComboBox<>();
        searchBtn = new javax.swing.JButton();
        searchInput = new javax.swing.JTextField();
        tanggalPanel3 = new javax.swing.JPanel();
        durasiLabel1 = new javax.swing.JLabel();
        jumlahPembayaranInput1 = new javax.swing.JTextField();
        headerPanel3 = new javax.swing.JPanel();
        logoDalamPanel3 = new javax.swing.JPanel();
        logoLuarPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        menuPanel = new javax.swing.JPanel();
        menu1Panel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        menu2Panel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        menu3Panel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        menu4Panel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        menu5Panel = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        commandPanel.setBackground(new java.awt.Color(255, 255, 255));
        commandPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 51, 51), new java.awt.Color(255, 102, 102), new java.awt.Color(255, 102, 102), new java.awt.Color(255, 51, 51)), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 4)), "COMMAND", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Berlin Sans FB Demi", 1, 18), new java.awt.Color(51, 51, 51))); // NOI18N

        addBtn.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        addBtn.setText("TAMBAH");

        editBtn.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        editBtn.setText("UBAH");

        deleteBtn.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        deleteBtn.setText("HAPUS");

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
                        .addComponent(editBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(editBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelBtn)
                .addGap(48, 48, 48))
        );

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.red, java.awt.Color.red, java.awt.Color.red, java.awt.Color.red), new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true)), "INPUT", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tw Cen MT", 1, 18))); // NOI18N

        transaksiPanel.setBackground(new java.awt.Color(255, 255, 255));

        transaksiLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        transaksiLabel.setText("ID Transaksi");

        penyewaanInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penyewaanInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout transaksiPanelLayout = new javax.swing.GroupLayout(transaksiPanel);
        transaksiPanel.setLayout(transaksiPanelLayout);
        transaksiPanelLayout.setHorizontalGroup(
            transaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(transaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(transaksiPanelLayout.createSequentialGroup()
                        .addComponent(transaksiLabel)
                        .addGap(0, 197, Short.MAX_VALUE))
                    .addComponent(penyewaanInput))
                .addContainerGap())
        );
        transaksiPanelLayout.setVerticalGroup(
            transaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(transaksiLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(penyewaanInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
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
                    .addGroup(tanggalPanelLayout.createSequentialGroup()
                        .addComponent(durasiLabel)
                        .addGap(0, 195, Short.MAX_VALUE))
                    .addComponent(durasiInput))
                .addContainerGap())
        );
        tanggalPanelLayout.setVerticalGroup(
            tanggalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tanggalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(durasiLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(durasiInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        penyewaanTabel1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(penyewaanTabel1);

        tanggalPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pilihLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        pilihLabel.setText("Pilih Nama Customer");

        pilihDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihDropDownActionPerformed(evt);
            }
        });

        tanggalPanel2.setBackground(new java.awt.Color(255, 255, 255));

        pilihLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        pilihLabel1.setText("Pilih Kendaraan");

        mobilRb.setText("Mobil");

        motorRb.setText("Motor");

        javax.swing.GroupLayout tanggalPanel2Layout = new javax.swing.GroupLayout(tanggalPanel2);
        tanggalPanel2.setLayout(tanggalPanel2Layout);
        tanggalPanel2Layout.setHorizontalGroup(
            tanggalPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tanggalPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tanggalPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tanggalPanel2Layout.createSequentialGroup()
                        .addGroup(tanggalPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pilihLabel1)
                            .addGroup(tanggalPanel2Layout.createSequentialGroup()
                                .addComponent(mobilRb, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(motorRb, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(tanggalPanel2Layout.createSequentialGroup()
                        .addComponent(mobilBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(motorBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
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
                    .addGroup(tanggalPanel1Layout.createSequentialGroup()
                        .addComponent(pilihLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pilihDropDown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tanggalPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        tanggalPanel1Layout.setVerticalGroup(
            tanggalPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tanggalPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pilihLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pilihDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tanggalPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        searchBtn.setText("Cari");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        tanggalPanel3.setBackground(new java.awt.Color(255, 255, 255));

        durasiLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        durasiLabel1.setText("Durasi Penyewaan");

        jumlahPembayaranInput1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahPembayaranInput1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tanggalPanel3Layout = new javax.swing.GroupLayout(tanggalPanel3);
        tanggalPanel3.setLayout(tanggalPanel3Layout);
        tanggalPanel3Layout.setHorizontalGroup(
            tanggalPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tanggalPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tanggalPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tanggalPanel3Layout.createSequentialGroup()
                        .addComponent(durasiLabel1)
                        .addGap(0, 175, Short.MAX_VALUE))
                    .addComponent(jumlahPembayaranInput1))
                .addContainerGap())
        );
        tanggalPanel3Layout.setVerticalGroup(
            tanggalPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tanggalPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(durasiLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jumlahPembayaranInput1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tanggalPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(transaksiPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(tanggalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                        .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(searchBtn)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                        .addComponent(tanggalPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contentPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(transaksiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBtn))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(tanggalPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tanggalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(tanggalPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(257, Short.MAX_VALUE))))
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                    .addContainerGap(406, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(25, 25, 25)))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoLuarPanel3Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        logoLuarPanel3Layout.setVerticalGroup(
            logoLuarPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoLuarPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoLuarPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menuPanel.setBackground(new java.awt.Color(255, 204, 204));
        menuPanel.setForeground(new java.awt.Color(255, 255, 255));

        menu1Panel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/car rent.png"))); // NOI18N

        javax.swing.GroupLayout menu1PanelLayout = new javax.swing.GroupLayout(menu1Panel);
        menu1Panel.setLayout(menu1PanelLayout);
        menu1PanelLayout.setHorizontalGroup(
            menu1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        menu1PanelLayout.setVerticalGroup(
            menu1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu1PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
        );

        menu2Panel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/customer.png"))); // NOI18N

        javax.swing.GroupLayout menu2PanelLayout = new javax.swing.GroupLayout(menu2Panel);
        menu2Panel.setLayout(menu2PanelLayout);
        menu2PanelLayout.setHorizontalGroup(
            menu2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        menu2PanelLayout.setVerticalGroup(
            menu2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
        );

        menu3Panel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/car.png"))); // NOI18N

        javax.swing.GroupLayout menu3PanelLayout = new javax.swing.GroupLayout(menu3Panel);
        menu3Panel.setLayout(menu3PanelLayout);
        menu3PanelLayout.setHorizontalGroup(
            menu3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu3PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        menu3PanelLayout.setVerticalGroup(
            menu3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu3PanelLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menu4Panel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/tour guide.png"))); // NOI18N

        javax.swing.GroupLayout menu4PanelLayout = new javax.swing.GroupLayout(menu4Panel);
        menu4Panel.setLayout(menu4PanelLayout);
        menu4PanelLayout.setHorizontalGroup(
            menu4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu4PanelLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addContainerGap())
        );
        menu4PanelLayout.setVerticalGroup(
            menu4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu4PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        menu5Panel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/transaction.png"))); // NOI18N

        javax.swing.GroupLayout menu5PanelLayout = new javax.swing.GroupLayout(menu5Panel);
        menu5Panel.setLayout(menu5PanelLayout);
        menu5PanelLayout.setHorizontalGroup(
            menu5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu5PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        menu5PanelLayout.setVerticalGroup(
            menu5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu5PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(menu1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menu2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menu3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menu4Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menu5Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu5Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu4Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        titlePanel.setBackground(new java.awt.Color(255, 204, 204));
        titlePanel.setForeground(new java.awt.Color(255, 255, 255));

        titleLabel.setBackground(new java.awt.Color(0, 0, 0));
        titleLabel.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("FORM ");
        titleLabel.setToolTipText("");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout headerPanel3Layout = new javax.swing.GroupLayout(headerPanel3);
        headerPanel3.setLayout(headerPanel3Layout);
        headerPanel3Layout.setHorizontalGroup(
            headerPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanel3Layout.createSequentialGroup()
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
                        .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(commandPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(headerPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(commandPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void penyewaanInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penyewaanInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_penyewaanInputActionPerformed

    private void durasiInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_durasiInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_durasiInputActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        
    }//GEN-LAST:event_saveBtnActionPerformed

    private void pilihDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihDropDownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pilihDropDownActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
       
    }//GEN-LAST:event_searchBtnActionPerformed

    private void jumlahPembayaranInput1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahPembayaranInput1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahPembayaranInput1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPanel commandPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField durasiInput;
    private javax.swing.JLabel durasiLabel;
    private javax.swing.JLabel durasiLabel1;
    private javax.swing.JButton editBtn;
    private javax.swing.JPanel headerPanel3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jumlahPembayaranInput1;
    private javax.swing.JPanel logoDalamPanel3;
    private javax.swing.JPanel logoLuarPanel3;
    private javax.swing.JPanel menu1Panel;
    private javax.swing.JPanel menu2Panel;
    private javax.swing.JPanel menu3Panel;
    private javax.swing.JPanel menu4Panel;
    private javax.swing.JPanel menu5Panel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JComboBox<String> mobilBox;
    private javax.swing.JRadioButton mobilRb;
    private javax.swing.JComboBox<String> motorBox;
    private javax.swing.JRadioButton motorRb;
    private javax.swing.JTextField penyewaanInput;
    private javax.swing.JTable penyewaanTabel1;
    private javax.swing.JComboBox<Customer> pilihDropDown;
    private javax.swing.JLabel pilihLabel;
    private javax.swing.JLabel pilihLabel1;
    private javax.swing.ButtonGroup radioJenisPembayaran;
    private javax.swing.ButtonGroup radioStatusPembayaran;
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
