/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Control.transaksiControl;
import model.Transaksi;
import table.TableTransaksi;
import dao.transaksiDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class TransaksiView extends javax.swing.JFrame {

    private transaksiControl transaksiControl;
    
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
    public void setAddSearchComp(boolean value){
        addBtn.setEnabled(value);
        searchBtn.setEnabled(value);
        searchInput.setEnabled(value);
    }
    public void setOthComp(boolean value){
        idInput.setEnabled(value);
        namaInput.setEnabled(value);
        alamatInput.setEnabled(value);
        umurInput.setEnabled(value);
        teleponInput.setEnabled(value);
        
        saveBtn.setEnabled(value);
        cancelBtn.setEnabled(value);
    }
    public void setEditDelComp(boolean value){
        editBtn.setEnabled(value);
        deleteBtn.setEnabled(value);
    }
    public void clearText(){
        idInput.setText("");
        namaInput.setText("");
        alamatInput.setText("");
        umurInput.setText("");
        teleponInput.setText("");
    }
    public void showTransaksi(){
        transaksiTabel.setModel((TableModel) transaksiControl.showTransaksi(""));
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
        headerPanel = new javax.swing.JPanel();
        logoDalamPanel = new javax.swing.JPanel();
        logoLuarPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        menuPanel = new javax.swing.JPanel();
        menu1Panel = new javax.swing.JPanel();
        penyewaanIcon = new javax.swing.JLabel();
        menu2Panel = new javax.swing.JPanel();
        customerIcon = new javax.swing.JLabel();
        menu3Panel = new javax.swing.JPanel();
        kendaraanIcon = new javax.swing.JLabel();
        menu4Panel = new javax.swing.JPanel();
        tourGuideIcon = new javax.swing.JLabel();
        menu5Panel = new javax.swing.JPanel();
        transaksiIcon = new javax.swing.JLabel();
        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        transaksiPanel = new javax.swing.JPanel();
        transaksiLabel = new javax.swing.JLabel();
        transaksiInput = new javax.swing.JTextField();
        tanggalPanel = new javax.swing.JPanel();
        tanggalLabel = new javax.swing.JLabel();
        tanggalInput = new javax.swing.JTextField();
        penyewaanPanel = new javax.swing.JPanel();
        penyewaanLabel = new javax.swing.JLabel();
        penyewaanInput = new javax.swing.JTextField();
        statusPembayaranPanel = new javax.swing.JPanel();
        sudahRbtn = new javax.swing.JRadioButton();
        belumRbtn = new javax.swing.JRadioButton();
        statusPembayaranLabel1 = new javax.swing.JLabel();
        jenisPembayaranPanel = new javax.swing.JPanel();
        jenisPembayaranLabel = new javax.swing.JLabel();
        cashRbtn = new javax.swing.JRadioButton();
        debitRbtn = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        transaksiTabel = new javax.swing.JTable();

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

        headerPanel.setBackground(new java.awt.Color(204, 0, 0));
        headerPanel.setPreferredSize(new java.awt.Dimension(800, 150));

        logoDalamPanel.setBackground(new java.awt.Color(255, 102, 0));

        logoLuarPanel.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/main.png"))); // NOI18N

        javax.swing.GroupLayout logoLuarPanelLayout = new javax.swing.GroupLayout(logoLuarPanel);
        logoLuarPanel.setLayout(logoLuarPanelLayout);
        logoLuarPanelLayout.setHorizontalGroup(
            logoLuarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoLuarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addContainerGap())
        );
        logoLuarPanelLayout.setVerticalGroup(
            logoLuarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoLuarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout logoDalamPanelLayout = new javax.swing.GroupLayout(logoDalamPanel);
        logoDalamPanel.setLayout(logoDalamPanelLayout);
        logoDalamPanelLayout.setHorizontalGroup(
            logoDalamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoDalamPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoLuarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        logoDalamPanelLayout.setVerticalGroup(
            logoDalamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoDalamPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoLuarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuPanel.setBackground(new java.awt.Color(255, 204, 204));
        menuPanel.setForeground(new java.awt.Color(255, 255, 255));

        menu1Panel.setBackground(new java.awt.Color(255, 255, 255));

        penyewaanIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/car rent.png"))); // NOI18N

        javax.swing.GroupLayout menu1PanelLayout = new javax.swing.GroupLayout(menu1Panel);
        menu1Panel.setLayout(menu1PanelLayout);
        menu1PanelLayout.setHorizontalGroup(
            menu1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(penyewaanIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        menu1PanelLayout.setVerticalGroup(
            menu1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu1PanelLayout.createSequentialGroup()
                .addComponent(penyewaanIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        menu2Panel.setBackground(new java.awt.Color(255, 255, 255));

        customerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/customer.png"))); // NOI18N

        javax.swing.GroupLayout menu2PanelLayout = new javax.swing.GroupLayout(menu2Panel);
        menu2Panel.setLayout(menu2PanelLayout);
        menu2PanelLayout.setHorizontalGroup(
            menu2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customerIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        menu2PanelLayout.setVerticalGroup(
            menu2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customerIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menu3Panel.setBackground(new java.awt.Color(255, 255, 255));

        kendaraanIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/car.png"))); // NOI18N

        javax.swing.GroupLayout menu3PanelLayout = new javax.swing.GroupLayout(menu3Panel);
        menu3Panel.setLayout(menu3PanelLayout);
        menu3PanelLayout.setHorizontalGroup(
            menu3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu3PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kendaraanIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        menu3PanelLayout.setVerticalGroup(
            menu3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu3PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kendaraanIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        menu4Panel.setBackground(new java.awt.Color(255, 255, 255));

        tourGuideIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/tour guide.png"))); // NOI18N

        javax.swing.GroupLayout menu4PanelLayout = new javax.swing.GroupLayout(menu4Panel);
        menu4Panel.setLayout(menu4PanelLayout);
        menu4PanelLayout.setHorizontalGroup(
            menu4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu4PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tourGuideIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        menu4PanelLayout.setVerticalGroup(
            menu4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu4PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tourGuideIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        menu5Panel.setBackground(new java.awt.Color(255, 255, 255));

        transaksiIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/transaction.png"))); // NOI18N

        javax.swing.GroupLayout menu5PanelLayout = new javax.swing.GroupLayout(menu5Panel);
        menu5Panel.setLayout(menu5PanelLayout);
        menu5PanelLayout.setHorizontalGroup(
            menu5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu5PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(transaksiIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        menu5PanelLayout.setVerticalGroup(
            menu5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu5PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(transaksiIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu4Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu5Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(menu5Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menu4Panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(menu3Panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(menu2Panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menu1Panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        titlePanel.setBackground(new java.awt.Color(255, 204, 204));
        titlePanel.setForeground(new java.awt.Color(255, 255, 255));

        titleLabel.setBackground(new java.awt.Color(0, 0, 0));
        titleLabel.setFont(new java.awt.Font("AdLib WGL4 BT", 0, 36)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 0, 0));
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

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addComponent(logoDalamPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoDalamPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));

        transaksiPanel.setBackground(new java.awt.Color(255, 255, 255));

        transaksiLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        transaksiLabel.setForeground(new java.awt.Color(0, 0, 0));
        transaksiLabel.setText("ID Transaksi");

        transaksiInput.setBackground(new java.awt.Color(255, 255, 255));
        transaksiInput.setForeground(new java.awt.Color(0, 0, 0));
        transaksiInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transaksiInputActionPerformed(evt);
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
                    .addComponent(transaksiInput))
                .addContainerGap())
        );
        transaksiPanelLayout.setVerticalGroup(
            transaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(transaksiLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(transaksiInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tanggalPanel.setBackground(new java.awt.Color(255, 255, 255));

        tanggalLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        tanggalLabel.setForeground(new java.awt.Color(0, 0, 0));
        tanggalLabel.setText("Tanggal Pembayaran");

        tanggalInput.setBackground(new java.awt.Color(255, 255, 255));
        tanggalInput.setForeground(new java.awt.Color(0, 0, 0));
        tanggalInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggalInputActionPerformed(evt);
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
                    .addComponent(tanggalInput))
                .addContainerGap())
        );
        tanggalPanelLayout.setVerticalGroup(
            tanggalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tanggalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tanggalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tanggalInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        penyewaanPanel.setBackground(new java.awt.Color(255, 255, 255));

        penyewaanLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        penyewaanLabel.setForeground(new java.awt.Color(0, 0, 0));
        penyewaanLabel.setText("ID Penyewaan");

        penyewaanInput.setBackground(new java.awt.Color(255, 255, 255));
        penyewaanInput.setForeground(new java.awt.Color(0, 0, 0));
        penyewaanInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penyewaanInputActionPerformed(evt);
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
                    .addComponent(penyewaanInput))
                .addContainerGap())
        );
        penyewaanPanelLayout.setVerticalGroup(
            penyewaanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(penyewaanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(penyewaanLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(penyewaanInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        statusPembayaranPanel.setBackground(new java.awt.Color(255, 255, 255));

        sudahRbtn.setBackground(new java.awt.Color(255, 255, 255));
        radioStatusPembayaran.add(sudahRbtn);
        sudahRbtn.setForeground(new java.awt.Color(0, 0, 0));
        sudahRbtn.setText("Sudah Bayar");

        belumRbtn.setBackground(new java.awt.Color(255, 255, 255));
        radioStatusPembayaran.add(belumRbtn);
        belumRbtn.setForeground(new java.awt.Color(0, 0, 0));
        belumRbtn.setText("Belum Bayar");

        statusPembayaranLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        statusPembayaranLabel1.setForeground(new java.awt.Color(0, 0, 0));
        statusPembayaranLabel1.setText("Status Pembayaran");

        javax.swing.GroupLayout statusPembayaranPanelLayout = new javax.swing.GroupLayout(statusPembayaranPanel);
        statusPembayaranPanel.setLayout(statusPembayaranPanelLayout);
        statusPembayaranPanelLayout.setHorizontalGroup(
            statusPembayaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPembayaranPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statusPembayaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sudahRbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(belumRbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusPembayaranLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        statusPembayaranPanelLayout.setVerticalGroup(
            statusPembayaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPembayaranPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusPembayaranLabel1)
                .addGap(12, 12, 12)
                .addComponent(sudahRbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(belumRbtn)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jenisPembayaranPanel.setBackground(new java.awt.Color(255, 255, 255));

        jenisPembayaranLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jenisPembayaranLabel.setForeground(new java.awt.Color(0, 0, 0));
        jenisPembayaranLabel.setText("Jenis Pembayaran");

        cashRbtn.setBackground(new java.awt.Color(255, 255, 255));
        radioJenisPembayaran.add(cashRbtn);
        cashRbtn.setForeground(new java.awt.Color(0, 0, 0));
        cashRbtn.setText("Cash");

        debitRbtn.setBackground(new java.awt.Color(255, 255, 255));
        radioJenisPembayaran.add(debitRbtn);
        debitRbtn.setForeground(new java.awt.Color(0, 0, 0));
        debitRbtn.setText("Debit");
        debitRbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debitRbtnActionPerformed(evt);
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
                    .addComponent(cashRbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(debitRbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jenisPembayaranPanelLayout.setVerticalGroup(
            jenisPembayaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jenisPembayaranPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jenisPembayaranLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cashRbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(debitRbtn)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        transaksiTabel.setBackground(new java.awt.Color(255, 255, 255));
        transaksiTabel.setForeground(new java.awt.Color(0, 0, 0));
        transaksiTabel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(transaksiTabel);

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(penyewaanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(transaksiPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tanggalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(42, 42, 42)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jenisPembayaranPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(statusPembayaranPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(transaksiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(penyewaanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tanggalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(statusPembayaranPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jenisPembayaranPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
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
                        .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(9, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(commandPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 535, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void transaksiInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transaksiInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transaksiInputActionPerformed

    private void tanggalInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggalInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggalInputActionPerformed

    private void penyewaanInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penyewaanInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_penyewaanInputActionPerformed

    private void debitRbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debitRbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_debitRbtnActionPerformed

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
    private javax.swing.JRadioButton belumRbtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JRadioButton cashRbtn;
    private javax.swing.JPanel commandPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel customerIcon;
    private javax.swing.JRadioButton debitRbtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jenisPembayaranLabel;
    private javax.swing.JPanel jenisPembayaranPanel;
    private javax.swing.JLabel kendaraanIcon;
    private javax.swing.JPanel logoDalamPanel;
    private javax.swing.JPanel logoLuarPanel;
    private javax.swing.JPanel menu1Panel;
    private javax.swing.JPanel menu2Panel;
    private javax.swing.JPanel menu3Panel;
    private javax.swing.JPanel menu4Panel;
    private javax.swing.JPanel menu5Panel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel penyewaanIcon;
    private javax.swing.JTextField penyewaanInput;
    private javax.swing.JLabel penyewaanLabel;
    private javax.swing.JPanel penyewaanPanel;
    private javax.swing.ButtonGroup radioJenisPembayaran;
    private javax.swing.ButtonGroup radioStatusPembayaran;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel statusPembayaranLabel1;
    private javax.swing.JPanel statusPembayaranPanel;
    private javax.swing.JRadioButton sudahRbtn;
    private javax.swing.JTextField tanggalInput;
    private javax.swing.JLabel tanggalLabel;
    private javax.swing.JPanel tanggalPanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JLabel tourGuideIcon;
    private javax.swing.JLabel transaksiIcon;
    private javax.swing.JTextField transaksiInput;
    private javax.swing.JLabel transaksiLabel;
    private javax.swing.JPanel transaksiPanel;
    private javax.swing.JTable transaksiTabel;
    // End of variables declaration//GEN-END:variables
}
