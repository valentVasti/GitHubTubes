/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Control.transaksiControl;
import model.Transaksi;
import model.Penyewaan;
import table.TableTransaksi;
import dao.transaksiDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class TransaksiView extends javax.swing.JFrame {

    private transaksiControl transaksiControl;
    private Penyewaan p;
    
    String action = null;
    String selectedId = null;
    List<Transaksi> listGuide;
    
    public TransaksiView() {
        initComponents();
        setAddSearchComp(true);
        setOthComp(false);
        setEditDelComp(false);
        transaksiControl = new transaksiControl();
        showTransaksi();
    }
    
    public TransaksiView(Penyewaan p) {
        initComponents();
        setAddSearchComp(false);
        setOthComp(true);
        setEditDelComp(false);
        transaksiControl = new transaksiControl();
        this.p = p;
        action = "Tambah";
        showTransaksi();
    }
    public void setAddSearchComp(boolean value){
        addBtn.setEnabled(value);
        //searchBtn.setEnabled(value);
        //searchInput.setEnabled(value);
    }
    public void setOthComp(boolean value){
        idTransaksiInput.setEnabled(value);
        tanggalTransaksiInput.setEnabled(value);
        jumlahPembayaranInput.setEnabled(value);
        
        saveBtn.setEnabled(value);
        cancelBtn.setEnabled(value);
    }
    public void setEditDelComp(boolean value){
        editBtn.setEnabled(value);
        deleteBtn.setEnabled(value);
    }
    public void clearText(){
        idTransaksiInput.setText("");
        tanggalTransaksiInput.setText("");
        jumlahPembayaranInput.setText("");
    }
    public void showTransaksi(){
        transaksiTable.setModel((TableModel) transaksiControl.showTransaksi(""));
    }
    @SuppressWarnings("unchecked")
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
        idTransaksiInput = new javax.swing.JTextField();
        tanggalPanel = new javax.swing.JPanel();
        tanggalLabel = new javax.swing.JLabel();
        jumlahPembayaranInput = new javax.swing.JTextField();
        penyewaanPanel = new javax.swing.JPanel();
        penyewaanLabel = new javax.swing.JLabel();
        tanggalTransaksiInput = new javax.swing.JTextField();
        statusPembayaranPanel = new javax.swing.JPanel();
        radioSudahBayar = new javax.swing.JRadioButton();
        radioBelumBayar = new javax.swing.JRadioButton();
        statusPembayaranLabel1 = new javax.swing.JLabel();
        jenisPembayaranPanel = new javax.swing.JPanel();
        jenisPembayaranLabel = new javax.swing.JLabel();
        radioCash = new javax.swing.JRadioButton();
        radioDebit = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        transaksiTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        totalSewaField = new javax.swing.JTextField();
        hitungPembayaranBtn = new javax.swing.JButton();
        kembalianField = new javax.swing.JTextField();
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
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
                    .addGroup(transaksiPanelLayout.createSequentialGroup()
                        .addComponent(transaksiLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(idTransaksiInput))
                .addContainerGap())
        );
        transaksiPanelLayout.setVerticalGroup(
            transaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(transaksiLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idTransaksiInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tanggalPanel.setBackground(new java.awt.Color(255, 255, 255));

        tanggalLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        tanggalLabel.setText("Jumlah Pembayaran");

        jumlahPembayaranInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahPembayaranInputActionPerformed(evt);
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
                        .addComponent(tanggalLabel)
                        .addGap(0, 155, Short.MAX_VALUE))
                    .addComponent(jumlahPembayaranInput))
                .addContainerGap())
        );
        tanggalPanelLayout.setVerticalGroup(
            tanggalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tanggalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tanggalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jumlahPembayaranInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        penyewaanPanel.setBackground(new java.awt.Color(255, 255, 255));

        penyewaanLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        penyewaanLabel.setText("Tanggal Transaksi");

        tanggalTransaksiInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggalTransaksiInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout penyewaanPanelLayout = new javax.swing.GroupLayout(penyewaanPanel);
        penyewaanPanel.setLayout(penyewaanPanelLayout);
        penyewaanPanelLayout.setHorizontalGroup(
            penyewaanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(penyewaanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(penyewaanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(penyewaanPanelLayout.createSequentialGroup()
                        .addComponent(penyewaanLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tanggalTransaksiInput))
                .addContainerGap())
        );
        penyewaanPanelLayout.setVerticalGroup(
            penyewaanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(penyewaanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(penyewaanLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tanggalTransaksiInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        statusPembayaranPanel.setBackground(new java.awt.Color(255, 255, 255));

        radioSudahBayar.setBackground(new java.awt.Color(255, 255, 255));
        radioStatusPembayaran.add(radioSudahBayar);
        radioSudahBayar.setText("Sudah Bayar");

        radioBelumBayar.setBackground(new java.awt.Color(255, 255, 255));
        radioStatusPembayaran.add(radioBelumBayar);
        radioBelumBayar.setText("Belum Bayar");

        statusPembayaranLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        statusPembayaranLabel1.setText("Status Pembayaran");

        javax.swing.GroupLayout statusPembayaranPanelLayout = new javax.swing.GroupLayout(statusPembayaranPanel);
        statusPembayaranPanel.setLayout(statusPembayaranPanelLayout);
        statusPembayaranPanelLayout.setHorizontalGroup(
            statusPembayaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPembayaranPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statusPembayaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioSudahBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioBelumBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusPembayaranLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        statusPembayaranPanelLayout.setVerticalGroup(
            statusPembayaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPembayaranPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusPembayaranLabel1)
                .addGap(12, 12, 12)
                .addComponent(radioSudahBayar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioBelumBayar)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jenisPembayaranPanel.setBackground(new java.awt.Color(255, 255, 255));

        jenisPembayaranLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jenisPembayaranLabel.setText("Jenis Pembayaran");

        radioCash.setBackground(new java.awt.Color(255, 255, 255));
        radioJenisPembayaran.add(radioCash);
        radioCash.setText("Cash");

        radioDebit.setBackground(new java.awt.Color(255, 255, 255));
        radioJenisPembayaran.add(radioDebit);
        radioDebit.setText("Debit");
        radioDebit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDebitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jenisPembayaranPanelLayout = new javax.swing.GroupLayout(jenisPembayaranPanel);
        jenisPembayaranPanel.setLayout(jenisPembayaranPanelLayout);
        jenisPembayaranPanelLayout.setHorizontalGroup(
            jenisPembayaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jenisPembayaranPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jenisPembayaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jenisPembayaranLabel)
                    .addComponent(radioCash, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioDebit, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jenisPembayaranPanelLayout.setVerticalGroup(
            jenisPembayaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jenisPembayaranPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jenisPembayaranLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioCash)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioDebit)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        transaksiTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(transaksiTable);

        totalSewaField.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 24)); // NOI18N
        totalSewaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalSewaFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalSewaField, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalSewaField, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        hitungPembayaranBtn.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        hitungPembayaranBtn.setText("Hitung Pembayaran");
        hitungPembayaranBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungPembayaranBtnActionPerformed(evt);
            }
        });

        kembalianField.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 12)); // NOI18N
        kembalianField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembalianFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contentPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(hitungPembayaranBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kembalianField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(penyewaanPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(transaksiPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tanggalPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(42, 42, 42)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jenisPembayaranPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(statusPembayaranPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(transaksiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(penyewaanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tanggalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(statusPembayaranPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jenisPembayaranPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hitungPembayaranBtn)
                    .addComponent(kembalianField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
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
                .addContainerGap(28, Short.MAX_VALUE)
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
            .addGroup(menu1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap()
                .addComponent(menu1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menu2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menu3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menu4Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menu5Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(menu5Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menu4Panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(menu2Panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menu1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menu3Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
                .addGroup(headerPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        headerPanel3Layout.setVerticalGroup(
            headerPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logoDalamPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(headerPanel3Layout.createSequentialGroup()
                        .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                    .addComponent(headerPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(commandPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 517, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idTransaksiInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTransaksiInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTransaksiInputActionPerformed

    private void jumlahPembayaranInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahPembayaranInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahPembayaranInputActionPerformed

    private void tanggalTransaksiInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggalTransaksiInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggalTransaksiInputActionPerformed

    private void radioDebitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDebitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioDebitActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        int clickedRow = transaksiTable.getSelectedRow();
        TableModel tableModel = transaksiTable.getModel();
        String status = null, jenis = null;
        //(String id_Transaksi, String status_Pembayaran, String jenis_Pembayaran, String tanggal_Transaksi)

        if(radioSudahBayar.isSelected()){
            status = "Sudah Bayar";
        }else if (radioBelumBayar.isSelected()){
            status = "Belum Bayar";
        }
        
        if(radioCash.isSelected()){
            jenis = "Cash";
        }else if(radioDebit.isSelected()){
            jenis = "Debit";
        }
        
        if(action.equals("Tambah")){
            Transaksi transaksi = new Transaksi(idTransaksiInput.getText(), status, jenis,
                    tanggalTransaksiInput.getText());
            transaksiControl.insertDataTransaksi(transaksi);
        } else{
            Transaksi transaksi = new Transaksi(idTransaksiInput.getText(), status, jenis,
                    tanggalTransaksiInput.getText());
            transaksiControl.insertDataTransaksi(transaksi);
        }

        clearText();
        //balik ke view Penyewaan bisa tambahin j
    }//GEN-LAST:event_saveBtnActionPerformed

    private void hitungPembayaranBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungPembayaranBtnActionPerformed
        double kembalian;
        
        do{
            kembalian = Double.parseDouble(jumlahPembayaranInput.getText()) - Double.parseDouble(totalSewaField.getText());

            if(kembalian < 0){
                JOptionPane.showMessageDialog(this, "Uang Kurang!");
                jumlahPembayaranInput.setText("");
            }else if(kembalian >= 0){
                kembalianField.setText(Double.toString(kembalian));
                radioSudahBayar.setSelected(true);
            }            
        }while(kembalian < 0);

    }//GEN-LAST:event_hitungPembayaranBtnActionPerformed

    private void kembalianFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembalianFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kembalianFieldActionPerformed

    private void totalSewaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalSewaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalSewaFieldActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPanel commandPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JPanel headerPanel3;
    private javax.swing.JButton hitungPembayaranBtn;
    private javax.swing.JTextField idTransaksiInput;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jenisPembayaranLabel;
    private javax.swing.JPanel jenisPembayaranPanel;
    private javax.swing.JTextField jumlahPembayaranInput;
    private javax.swing.JTextField kembalianField;
    private javax.swing.JPanel logoDalamPanel3;
    private javax.swing.JPanel logoLuarPanel3;
    private javax.swing.JPanel menu1Panel;
    private javax.swing.JPanel menu2Panel;
    private javax.swing.JPanel menu3Panel;
    private javax.swing.JPanel menu4Panel;
    private javax.swing.JPanel menu5Panel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel penyewaanLabel;
    private javax.swing.JPanel penyewaanPanel;
    private javax.swing.JRadioButton radioBelumBayar;
    private javax.swing.JRadioButton radioCash;
    private javax.swing.JRadioButton radioDebit;
    private javax.swing.ButtonGroup radioJenisPembayaran;
    private javax.swing.ButtonGroup radioStatusPembayaran;
    private javax.swing.JRadioButton radioSudahBayar;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel statusPembayaranLabel1;
    private javax.swing.JPanel statusPembayaranPanel;
    private javax.swing.JLabel tanggalLabel;
    private javax.swing.JPanel tanggalPanel;
    private javax.swing.JTextField tanggalTransaksiInput;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JTextField totalSewaField;
    private javax.swing.JLabel transaksiLabel;
    private javax.swing.JPanel transaksiPanel;
    private javax.swing.JTable transaksiTable;
    // End of variables declaration//GEN-END:variables
}
