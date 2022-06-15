/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Control.transaksiControl;
import Exception.InputId;
import Exception.InputKosongException;
import Exception.belumBayarException;
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
    
    String action = "Tambah";
    String selectedId = null;
    List<Transaksi> listTransaksi;
    
    public TransaksiView() {
        initComponents();
        setAddSearchComp(true);
        addBtn.setEnabled(false);
        searchBtn.setEnabled(true);
        setOthComp(false);
        transaksiControl = new transaksiControl();
        hitungPembayaranBtn.setEnabled(false);
        setEnabled(false);
        setSelectedRadio(false);
        showTransaksi();
        delBtn.setEnabled(false);
    }
    
    public TransaksiView(Penyewaan p, String status) {
        initComponents();
        setAddSearchComp(false);
        setOthComp(true);
        transaksiControl = new transaksiControl();
        showTransaksi();
        totalSewaField.setText(Double.toString(p.getTotal_Sewa()));
        this.p = p;
        setEnabledRadio(true);
        setSelectedRadio(false);
                
        if(status.equalsIgnoreCase("Unpaid")){
            idTransaksiInput.setText(p.getTransaksi().getId_Transaksi());
            tanggalTransaksiInput.setText(p.getTransaksi().getTanggal_Transaksi());
            idTransaksiInput.setEnabled(false); tanggalTransaksiInput.setEnabled(false);
            action = "Ubah";
        }else if(status.equalsIgnoreCase("-")){
            action = "Tambah";            
        }
    }
    
    public void setAddSearchComp(boolean value){
        addBtn.setEnabled(value);
        searchBtn.setEnabled(value);
        searchInput.setEnabled(value);
    }
    public void setOthComp(boolean value){
        idTransaksiInput.setEnabled(value);
        tanggalTransaksiInput.setEnabled(value);
        jumlahPembayaranInput.setEnabled(value);
        kembalianField.setEnabled(value);
        
        saveBtn.setEnabled(value);
        cancelBtn.setEnabled(value);
    }
    
       
    public void setEnabledRadio(boolean value){
        radioSudahBayar.setEnabled(value);radioBelumBayar.setEnabled(value);
        radioCash.setEnabled(value);radioDebit.setEnabled(value);        
    }
    
    public void setSelectedRadio(boolean value){
        radioCash.setSelected(value);radioDebit.setSelected(value);
        radioCash.setSelected(value);radioDebit.setSelected(value);       
    }

    public void clearText(){
        idTransaksiInput.setText("");
        tanggalTransaksiInput.setText("");
        jumlahPembayaranInput.setText("");
    }
    public void showTransaksi(){
        transaksiTable.setModel((TableModel) transaksiControl.showTransaksi(""));
    }
    
    public void inputKosongException() throws InputKosongException{
        if(idTransaksiInput.getText().isEmpty() || tanggalTransaksiInput.getText().isEmpty()
                || (!radioBelumBayar.isSelected() && !radioSudahBayar.isSelected())
                || (!radioCash.isSelected() && !radioDebit.isSelected() && radioSudahBayar.isSelected())){
            throw new InputKosongException();
        }
    }
    
    public void inputId() throws InputId{
        if(!idTransaksiInput.getText().contains("TR-")){
            throw new InputId();
        }
    }
    
    public void belumBayarException() throws belumBayarException{
        if(radioSudahBayar.isSelected() && jumlahPembayaranInput.getText().isEmpty()){
            throw new belumBayarException();
        }
    }
    
    public int checkDel(String idDel){
        listTransaksi = transaksiControl.showDataTransaksi();
        for(Transaksi tr: listTransaksi){
            if(tr.getId_Transaksi().equals(idDel)){
                return 0;
            }
        }
        return 1;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioStatusPembayaran = new javax.swing.ButtonGroup();
        radioJenisPembayaran = new javax.swing.ButtonGroup();
        jToggleButton1 = new javax.swing.JToggleButton();
        commandPanel = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        delBtn = new javax.swing.JButton();
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
        searchBtn = new javax.swing.JButton();
        searchInput = new javax.swing.JTextField();
        headerPanel3 = new javax.swing.JPanel();
        logoDalamPanel3 = new javax.swing.JPanel();
        logoLuarPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        menuPanel = new javax.swing.JPanel();
        penyewaanMenu = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        guideMenu = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        kendaraanMenu = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        customerMenu = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        menu5Panel = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        homeBtn = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

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

        saveBtn.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        saveBtn.setText("BAYAR/SIMPAN");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        cancelBtn.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        cancelBtn.setText("BATAL");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        delBtn.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        delBtn.setText("HAPUS");
        delBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout commandPanelLayout = new javax.swing.GroupLayout(commandPanel);
        commandPanel.setLayout(commandPanelLayout);
        commandPanelLayout.setHorizontalGroup(
            commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commandPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        commandPanelLayout.setVerticalGroup(
            commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commandPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(addBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(delBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jumlahPembayaranInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jumlahPembayaranInputKeyTyped(evt);
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
        radioSudahBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSudahBayarActionPerformed(evt);
            }
        });

        radioBelumBayar.setBackground(new java.awt.Color(255, 255, 255));
        radioStatusPembayaran.add(radioBelumBayar);
        radioBelumBayar.setText("Belum Bayar");
        radioBelumBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBelumBayarActionPerformed(evt);
            }
        });

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
                    .addComponent(radioBelumBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(statusPembayaranPanelLayout.createSequentialGroup()
                .addComponent(statusPembayaranLabel1)
                .addGap(0, 193, Short.MAX_VALUE))
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
                    .addComponent(radioCash, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioDebit, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jenisPembayaranPanelLayout.createSequentialGroup()
                .addComponent(jenisPembayaranLabel)
                .addGap(0, 0, Short.MAX_VALUE))
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
        transaksiTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transaksiTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(transaksiTable);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(totalSewaField, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addComponent(totalSewaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        hitungPembayaranBtn.setBackground(new java.awt.Color(250, 250, 250));
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

        searchBtn.setText("Cari");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(penyewaanPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(transaksiPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tanggalPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contentPanelLayout.createSequentialGroup()
                                .addComponent(hitungPembayaranBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kembalianField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jenisPembayaranPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(statusPembayaranPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                        .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(19, 19, 19)
                                        .addComponent(searchBtn)))))
                        .addContainerGap())))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(transaksiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(penyewaanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tanggalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hitungPembayaranBtn)
                            .addComponent(kembalianField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(statusPembayaranPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jenisPembayaranPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        headerPanel3.setBackground(new java.awt.Color(204, 0, 0));
        headerPanel3.setPreferredSize(new java.awt.Dimension(800, 150));

        logoDalamPanel3.setBackground(new java.awt.Color(255, 102, 0));

        logoLuarPanel3.setBackground(new java.awt.Color(255, 204, 204));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Logo Rental Atma.png"))); // NOI18N

        javax.swing.GroupLayout logoLuarPanel3Layout = new javax.swing.GroupLayout(logoLuarPanel3);
        logoLuarPanel3.setLayout(logoLuarPanel3Layout);
        logoLuarPanel3Layout.setHorizontalGroup(
            logoLuarPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoLuarPanel3Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        logoLuarPanel3Layout.setVerticalGroup(
            logoLuarPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoLuarPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

        penyewaanMenu.setBackground(new java.awt.Color(255, 255, 255));
        penyewaanMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                penyewaanMenuMouseClicked(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/car rent.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel17.setText("Penyewaan");

        javax.swing.GroupLayout penyewaanMenuLayout = new javax.swing.GroupLayout(penyewaanMenu);
        penyewaanMenu.setLayout(penyewaanMenuLayout);
        penyewaanMenuLayout.setHorizontalGroup(
            penyewaanMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(penyewaanMenuLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(penyewaanMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, penyewaanMenuLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, penyewaanMenuLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addContainerGap())))
        );
        penyewaanMenuLayout.setVerticalGroup(
            penyewaanMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(penyewaanMenuLayout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        guideMenu.setBackground(new java.awt.Color(255, 255, 255));
        guideMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guideMenuMouseClicked(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/customer.png"))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel20.setText("Guide");

        javax.swing.GroupLayout guideMenuLayout = new javax.swing.GroupLayout(guideMenu);
        guideMenu.setLayout(guideMenuLayout);
        guideMenuLayout.setHorizontalGroup(
            guideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guideMenuLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(guideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, guideMenuLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, guideMenuLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(28, 28, 28))))
        );
        guideMenuLayout.setVerticalGroup(
            guideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guideMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addContainerGap())
        );

        kendaraanMenu.setBackground(new java.awt.Color(255, 255, 255));
        kendaraanMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kendaraanMenuMouseClicked(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/car.png"))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel19.setText("Kendaraan");

        javax.swing.GroupLayout kendaraanMenuLayout = new javax.swing.GroupLayout(kendaraanMenu);
        kendaraanMenu.setLayout(kendaraanMenuLayout);
        kendaraanMenuLayout.setHorizontalGroup(
            kendaraanMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kendaraanMenuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(kendaraanMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel13))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        kendaraanMenuLayout.setVerticalGroup(
            kendaraanMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kendaraanMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addContainerGap())
        );

        customerMenu.setBackground(new java.awt.Color(255, 255, 255));
        customerMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerMenuMouseClicked(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/tour guide.png"))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel18.setText("Customer");

        javax.swing.GroupLayout customerMenuLayout = new javax.swing.GroupLayout(customerMenu);
        customerMenu.setLayout(customerMenuLayout);
        customerMenuLayout.setHorizontalGroup(
            customerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerMenuLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(customerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(10, 10, 10))
        );
        customerMenuLayout.setVerticalGroup(
            customerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerMenuLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menu5Panel.setBackground(new java.awt.Color(204, 204, 204));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/transaction.png"))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel21.setText("Transaksi");

        javax.swing.GroupLayout menu5PanelLayout = new javax.swing.GroupLayout(menu5Panel);
        menu5Panel.setLayout(menu5PanelLayout);
        menu5PanelLayout.setHorizontalGroup(
            menu5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu5PanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(menu5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel21))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        menu5PanelLayout.setVerticalGroup(
            menu5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu5PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21)
                .addContainerGap())
        );

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(penyewaanMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(guideMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kendaraanMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(customerMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menu5Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu5Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(customerMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(kendaraanMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(guideMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(penyewaanMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        titlePanel.setBackground(new java.awt.Color(255, 204, 204));
        titlePanel.setForeground(new java.awt.Color(255, 255, 255));

        titleLabel.setBackground(new java.awt.Color(0, 0, 0));
        titleLabel.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("FORM TRANSAKSI ");
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
                .addComponent(homeBtn))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(titleLabel))
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
                    .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        headerPanel3Layout.setVerticalGroup(
            headerPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanel3Layout.createSequentialGroup()
                        .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(logoDalamPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
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
                    .addComponent(headerPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(commandPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idTransaksiInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTransaksiInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTransaksiInputActionPerformed

    private void jumlahPembayaranInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahPembayaranInputActionPerformed

    }//GEN-LAST:event_jumlahPembayaranInputActionPerformed

    private void tanggalTransaksiInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggalTransaksiInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggalTransaksiInputActionPerformed

    private void radioDebitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDebitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioDebitActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
    try{
        inputKosongException();
        inputId();
        String status = "", jenis = "";
        
        if(radioSudahBayar.isSelected()){
            status = "Paid";
        }else if (radioBelumBayar.isSelected()){
            status = "Unpaid";
        }
        
        if(radioCash.isSelected()){
            jenis = "Cash";
        }else if(radioDebit.isSelected()){
            jenis = "Debit";
        }
        
        if(radioBelumBayar.isSelected()){
            jenis = "Belum bayar";
        }
        
        belumBayarException();
        
        if(action == "Tambah"){
            Transaksi transaksi = new Transaksi(idTransaksiInput.getText(), status, jenis,
                    tanggalTransaksiInput.getText());
            transaksiControl.insertDataTransaksi(transaksi);

            PenyewaanView pv = new PenyewaanView(transaksi, p);
            this.dispose();
            pv.setVisible(true);             
        }else{
            Transaksi transaksi = new Transaksi(idTransaksiInput.getText(), status, jenis,
                    tanggalTransaksiInput.getText());
            transaksiControl.updateTransaksi(transaksi);
            showTransaksi();
            PenyewaanView pv = new PenyewaanView();
            this.dispose();
            pv.setVisible(true);
        }
       
    }catch (InputKosongException e){
        JOptionPane.showMessageDialog(this, e.message());        
    }catch (InputId e){
        JOptionPane.showMessageDialog(this, e.message("TR-"));     
    }catch(belumBayarException e){
        JOptionPane.showMessageDialog(this, e.message());
    }
            
    }//GEN-LAST:event_saveBtnActionPerformed

    private void hitungPembayaranBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungPembayaranBtnActionPerformed
    try{
        double kembalian;
           
        do{
            kembalian = Double.parseDouble(jumlahPembayaranInput.getText()) - Double.parseDouble(totalSewaField.getText());

            if(kembalian < 0){
                JOptionPane.showMessageDialog(this, "Uang Kurang!");
                jumlahPembayaranInput.setText("");
                hitungPembayaranBtn.setEnabled(false);
            }else if(kembalian >= 0){
                kembalianField.setText(Double.toString(kembalian));
                radioSudahBayar.setSelected(true);
                radioBelumBayar.setEnabled(false);
                radioSudahBayar.setEnabled(false);
            }            
        }while(kembalian < 0);
    }catch (NumberFormatException e){
        JOptionPane.showMessageDialog(this, "Umur harus inputan angka!");             
    }

    }//GEN-LAST:event_hitungPembayaranBtnActionPerformed

    private void totalSewaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalSewaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalSewaFieldActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed

        setOthComp(false);
        setAddSearchComp(true);
        
        try {
            TableTransaksi transaksi = transaksiControl.showTransaksi(searchInput.getText());
            if(transaksi.getRowCount()==0){
                clearText();
                JOptionPane.showConfirmDialog(null, "Data Tidak Ditemukan", "Konfirmasi", JOptionPane.DEFAULT_OPTION);
            }else{
                transaksiTable.setModel(transaksi);
            }
            clearText();
        } catch (Exception e) {
            System.out.println("Error : "+e.getMessage());
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void jumlahPembayaranInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jumlahPembayaranInputKeyTyped
        hitungPembayaranBtn.setEnabled(true);        
    }//GEN-LAST:event_jumlahPembayaranInputKeyTyped

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        Home h = new Home();
        this.dispose();
        h.setVisible(true);
    }//GEN-LAST:event_homeBtnActionPerformed

    private void radioBelumBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBelumBayarActionPerformed
        jumlahPembayaranInput.setEnabled(false);
        hitungPembayaranBtn.setEnabled(false);
        kembalianField.setEnabled(false);
        radioCash.setSelected(false); radioDebit.setSelected(false);
        radioCash.setEnabled(false); radioDebit.setEnabled(false);        
    }//GEN-LAST:event_radioBelumBayarActionPerformed

    private void kembalianFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembalianFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kembalianFieldActionPerformed

    private void radioSudahBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSudahBayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioSudahBayarActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed

    }//GEN-LAST:event_addBtnActionPerformed

    private void transaksiTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transaksiTableMouseClicked
        setOthComp(false);
        delBtn.setEnabled(true);
                
        int clickedRow = transaksiTable.getSelectedRow();
        TableModel tableModel = transaksiTable.getModel();

        idTransaksiInput.setText(tableModel.getValueAt(clickedRow, 0).toString());
        tanggalTransaksiInput.setText(tableModel.getValueAt(clickedRow, 3).toString());
        
        if(tableModel.getValueAt(clickedRow, 2).toString().equalsIgnoreCase("Paid")){
            radioSudahBayar.setSelected(true);
            radioBelumBayar.setSelected(false);
            radioSudahBayar.setEnabled(false);
            radioBelumBayar.setEnabled(false);
        }else{
            radioSudahBayar.setSelected(false);
            radioBelumBayar.setSelected(true);
            radioSudahBayar.setEnabled(false);
            radioBelumBayar.setEnabled(false);            
        }
        
        if(tableModel.getValueAt(clickedRow, 1).toString().equalsIgnoreCase("Cash")){
            radioCash.setSelected(true);
            radioDebit.setSelected(false);
            radioCash.setEnabled(false);
            radioDebit.setEnabled(false);
        }else{
            radioCash.setSelected(false);
            radioDebit.setSelected(true);
            radioCash.setEnabled(false);
            radioDebit.setEnabled(false);            
        }        
    }//GEN-LAST:event_transaksiTableMouseClicked

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void penyewaanMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_penyewaanMenuMouseClicked
        PenyewaanView pv = new PenyewaanView();
        this.dispose();
        pv.setVisible(true);
    }//GEN-LAST:event_penyewaanMenuMouseClicked

    private void guideMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guideMenuMouseClicked
        GuideView gv = new GuideView();
        this.dispose();
        gv.setVisible(true);
    }//GEN-LAST:event_guideMenuMouseClicked

    private void kendaraanMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kendaraanMenuMouseClicked
        KendaraanView kv = new KendaraanView();
        this.dispose();
        kv.setVisible(true);
    }//GEN-LAST:event_kendaraanMenuMouseClicked

    private void customerMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerMenuMouseClicked
        CustomerView cv = new CustomerView();
        this.dispose();
        cv.setVisible(true);
    }//GEN-LAST:event_customerMenuMouseClicked

    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed
        int getAnswer = JOptionPane.showConfirmDialog(rootPane, "Apakah yakin ingin menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        selectedId = idTransaksiInput.getText();
        switch(getAnswer){
            case 0:
                try {
                transaksiControl.deleteTransaksi(selectedId);
                if(checkDel(selectedId)==0){
                    JOptionPane.showMessageDialog(this, "Gagal menghapus\n note: Data transaksi masih menjadi FK data Penyewaan");                    
                }else{
                    clearText();
                    showTransaksi();
                    setOthComp(false);
                    setAddSearchComp(true);
                    JOptionPane.showMessageDialog(this, "Berhasil menghapus data!");                    
                }

            } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Gagal menghapus transaksi");
                    System.out.println("Error : "+e.getMessage());
            }
                break;
            
            case 1:
                break;
        }
    }//GEN-LAST:event_delBtnActionPerformed

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
    private javax.swing.JPanel customerMenu;
    private javax.swing.JButton delBtn;
    private javax.swing.JPanel guideMenu;
    private javax.swing.JPanel headerPanel3;
    private javax.swing.JButton hitungPembayaranBtn;
    private javax.swing.JButton homeBtn;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel jenisPembayaranLabel;
    private javax.swing.JPanel jenisPembayaranPanel;
    private javax.swing.JTextField jumlahPembayaranInput;
    private javax.swing.JTextField kembalianField;
    private javax.swing.JPanel kendaraanMenu;
    private javax.swing.JPanel logoDalamPanel3;
    private javax.swing.JPanel logoLuarPanel3;
    private javax.swing.JPanel menu5Panel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel penyewaanLabel;
    private javax.swing.JPanel penyewaanMenu;
    private javax.swing.JPanel penyewaanPanel;
    private javax.swing.JRadioButton radioBelumBayar;
    private javax.swing.JRadioButton radioCash;
    private javax.swing.JRadioButton radioDebit;
    private javax.swing.ButtonGroup radioJenisPembayaran;
    private javax.swing.ButtonGroup radioStatusPembayaran;
    private javax.swing.JRadioButton radioSudahBayar;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchInput;
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
