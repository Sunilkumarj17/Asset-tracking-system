/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Vishva
 */

package asset_module.assign_1;
import java.sql.*;
import Database.Database;
import asset_module.assign_display.Display;
import asset_module.assign_update.update;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import main.loading;


public class updateasset extends javax.swing.JFrame {

    public static String other_softwares="";
    /**
     * Creates new form assign
     */
    public static String getsoftware="";
    public updateasset() {
        initComponents();
        update1();
        Display.f1.setEnabled(false);
         
        try {
            Database db = loading.db;
            Connection con1 = db.connection;
            stmt1 = con1.createStatement();

            pst1 = con1.prepareStatement("Select software from asset where asset_tag=?");
            pst1.setString(1, update.n);
            ResultSet rs = pst1.executeQuery();
            
            if(rs.next())
            {
                getsoftware=rs.getString("software");
            }
             String splitsoft[] = getsoftware.split(",");
             for(int i=0; i<16;i++)
             {
             if(splitsoft[i].equalsIgnoreCase("Adobe Acrobat DC"))
             {
                 adobe.setSelected(true);
             }
             if(splitsoft[i].equalsIgnoreCase("Visual Studio license"))
             {
                 vslicense.setSelected(true);
             }
             if(splitsoft[i].equalsIgnoreCase("Godaddy Domain"))
             {
                 godaddy.setSelected(true);
             }
             if(splitsoft[i].equalsIgnoreCase("Zoho Books India"))
             {
                 zohoindia.setSelected(true);
             }
             if(splitsoft[i].equalsIgnoreCase("Zoho Books Ireland"))
             {
                 zohoire.setSelected(true);
             }
             if(splitsoft[i].equalsIgnoreCase("Zoho Books NZ"))
             {
                 zohonz.setSelected(true);
             }
             if(splitsoft[i].equalsIgnoreCase("Zoho Books US"))
             {
                 zohous.setSelected(true);
             }
             if(splitsoft[i].equalsIgnoreCase("CVS Server Maintanence"))
             {
                 cvs.setSelected(true);
             }
             if(splitsoft[i].equalsIgnoreCase("Iron Mountain"))
             {
                 iron.setSelected(true);
             }
             if(splitsoft[i].equalsIgnoreCase("TN3270 Support"))
             {
                 support.setSelected(true);
             }
             if(splitsoft[i].equalsIgnoreCase("Install Shield Pro"))
             {
                 installshield.setSelected(true);
             }
             if(splitsoft[i].equalsIgnoreCase("Office 365 Standard"))
             {
                 office365.setSelected(true);
             }
             if(splitsoft[i].equalsIgnoreCase("Fortigate Firewall"))
             {
                 firewall.setSelected(true);
             }
             if(splitsoft[i].equalsIgnoreCase("Trend Micro Security"))
             {
                 trendmicro.setSelected(true);
             }
             if(splitsoft[i].equalsIgnoreCase("Delphi Maintanence Renewal"))
             {
                 delphi.setSelected(true);
             }
             if(splitsoft[i].equalsIgnoreCase("IPPBX AMC"))
             {
                 ippbx.setSelected(true);
             }
             if(!splitsoft[i].equalsIgnoreCase("Adobe Acrobat DC") && !splitsoft[i].equalsIgnoreCase("Visual Studio license") && !splitsoft[i].equalsIgnoreCase("Godaddy Domain")
                && !splitsoft[i].equalsIgnoreCase("Zoho Books India") &&  !splitsoft[i].equalsIgnoreCase("Zoho Books Ireland") && !splitsoft[i].equalsIgnoreCase("Zoho Books NZ")
                && !splitsoft[i].equalsIgnoreCase("Zoho Books US") &&  !splitsoft[i].equalsIgnoreCase("CVS Server Maintanence") && !splitsoft[i].equalsIgnoreCase("Iron Mountain")
                && !splitsoft[i].equalsIgnoreCase("TN3270 Support") && !splitsoft[i].equalsIgnoreCase("Install Shield Pro") &&  !splitsoft[i].equalsIgnoreCase("Office 365 Standard")
                && !splitsoft[i].equalsIgnoreCase("Fortigate Firewall") && !splitsoft[i].equalsIgnoreCase("Trend Micro Security") && !splitsoft[i].equalsIgnoreCase("Delphi Maintanence Renewal")
                && !splitsoft[i].equalsIgnoreCase("IPPBX AMC"))
             {
                 other_softwares = other_softwares+splitsoft[i]+",";
             }
             }
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
        atag.setText(update.n);
        atag.setEnabled(false);
        category.setText(update.n1);
        category.setEnabled(false);
        brand.setText(update.n2);
        brand.setEnabled(false);
        model.setText(update.n3);
        model.setEnabled(false);
        status.setText(update.n5);
        status.setEnabled(false);
        os.setSelectedItem(update.n6);
        office.setSelectedItem(update.n7);
        comments.setText(update.n8);
        eid.setText(update.eid);
        eid.setEnabled(false);
        ename.setText(update.ename);
        ename.setEnabled(false);
        location.setSelectedItem(update.loc);
        os.setEnabled(false);
        office.setEnabled(false);
        dateofassign.setEnabled(false);
        others.setText(other_softwares);
    }
    public static Connection con1;
    public static PreparedStatement pst1;
    public static Statement stmt1;
    public void update1() 
    {
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        eid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        ename = new javax.swing.JTextField();
        atag = new javax.swing.JTextField();
        brand = new javax.swing.JTextField();
        model = new javax.swing.JTextField();
        status = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        location = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        category = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        account = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        comments = new javax.swing.JTextArea();
        dateofassign = new com.toedter.calendar.JDateChooser();
        os = new javax.swing.JComboBox<>();
        office = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        iron = new javax.swing.JCheckBox();
        zohous = new javax.swing.JCheckBox();
        adobe = new javax.swing.JCheckBox();
        support = new javax.swing.JCheckBox();
        zohoindia = new javax.swing.JCheckBox();
        vslicense = new javax.swing.JCheckBox();
        cvs = new javax.swing.JCheckBox();
        jLabel31 = new javax.swing.JLabel();
        zohonz = new javax.swing.JCheckBox();
        godaddy = new javax.swing.JCheckBox();
        delphi = new javax.swing.JCheckBox();
        firewall = new javax.swing.JCheckBox();
        installshield = new javax.swing.JCheckBox();
        ippbx = new javax.swing.JCheckBox();
        trendmicro = new javax.swing.JCheckBox();
        office365 = new javax.swing.JCheckBox();
        others = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        zohoire = new javax.swing.JCheckBox();

        jLabel4.setText("jLabel4");

        jLabel34.setText("jLabel34");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 161, 225));
        jPanel1.setPreferredSize(new java.awt.Dimension(520, 760));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        eid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eidActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Employee ID ");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Asset Tag");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Brand");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Model");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Account");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Status");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("OS");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("MS Office");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText(":");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText(":");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText(":");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText(":");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText(":");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setText(":");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setText(":");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText(":");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel18.setText("Employee Name ");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setText(":");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel20.setText(":");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel21.setText("Date");

        ename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enameActionPerformed(evt);
            }
        });

        atag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atagActionPerformed(evt);
            }
        });

        brand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brandActionPerformed(evt);
            }
        });

        model.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelActionPerformed(evt);
            }
        });

        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel22.setText("User location");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel23.setText(":");

        location.setEditable(true);
        location.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select User Location", "Chennai", "US", "Australia", "Others" }));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("x");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });

        jButton1.setText("Assign");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel25.setText("Category");

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel26.setText(":");

        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel27.setText("Update Asset");

        jPanel3.setBackground(new java.awt.Color(0, 161, 225));
        jPanel3.setPreferredSize(new java.awt.Dimension(0, 3));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 135, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        account.setEditable(true);
        account.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Account", "Products Team", "Supporting Team", "Amex", "Citibank", "AirNZ", "AerLingus", "Bench-PS", "Sabre-Infosys", "Travelport", "DevOPS", "others" }));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel28.setText("Comments");

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel29.setText(":");

        comments.setColumns(20);
        comments.setRows(5);
        jScrollPane1.setViewportView(comments);

        os.setEditable(true);
        os.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select OS", "Windows 8", "Windows 10", "Windows 11", " " }));

        office.setEditable(true);
        office.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select MS Office", "Office 2008", "Office 2010", "Office 2022", " " }));

        jLabel30.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel30.setText("Softwares");

        iron.setBackground(new java.awt.Color(255, 255, 255));
        iron.setText("Iron Mountain");

        zohous.setBackground(new java.awt.Color(255, 255, 255));
        zohous.setText("Zoho Books US");

        adobe.setBackground(new java.awt.Color(255, 255, 255));
        adobe.setText("Adobe Acrobat DC");

        support.setBackground(new java.awt.Color(255, 255, 255));
        support.setText("TN3270 Support");

        zohoindia.setBackground(new java.awt.Color(255, 255, 255));
        zohoindia.setText("Zoho Books India");

        vslicense.setBackground(new java.awt.Color(255, 255, 255));
        vslicense.setText("Visual Studio license");

        cvs.setBackground(new java.awt.Color(255, 255, 255));
        cvs.setText("CVS Server Maintanence");

        jLabel31.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel31.setText(":");

        zohonz.setBackground(new java.awt.Color(255, 255, 255));
        zohonz.setText("Zoho Books NZ");

        godaddy.setBackground(new java.awt.Color(255, 255, 255));
        godaddy.setText("Godaddy Domain");
        godaddy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                godaddyActionPerformed(evt);
            }
        });

        delphi.setBackground(new java.awt.Color(255, 255, 255));
        delphi.setText("Delphi Maintanence Renewal");

        firewall.setBackground(new java.awt.Color(255, 255, 255));
        firewall.setText("Fortigate Firewall");
        firewall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firewallActionPerformed(evt);
            }
        });

        installshield.setBackground(new java.awt.Color(255, 255, 255));
        installshield.setText("Install Shield Pro");

        ippbx.setBackground(new java.awt.Color(255, 255, 255));
        ippbx.setText("IPPBX AMC");
        ippbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ippbxActionPerformed(evt);
            }
        });

        trendmicro.setBackground(new java.awt.Color(255, 255, 255));
        trendmicro.setText("Trend Micro Security");
        trendmicro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trendmicroActionPerformed(evt);
            }
        });

        office365.setBackground(new java.awt.Color(255, 255, 255));
        office365.setText("Office 365 Standard");
        office365.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                office365ActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel32.setText("Other Softwares");

        jLabel33.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel33.setText(":");

        zohoire.setBackground(new java.awt.Color(255, 255, 255));
        zohoire.setText("Zoho Books Ireland");
        zohoire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zohoireActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel28))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(location, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(dateofassign, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(os, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(status))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(account, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(model))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(atag))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(ename))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(category)
                                            .addComponent(brand)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(17, 17, 17)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel27)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(eid, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane1))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(office, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel30))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(adobe)
                                            .addComponent(vslicense, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(godaddy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(zohoindia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(zohonz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(zohous, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cvs)
                                            .addComponent(zohoire, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(support, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(installshield, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(office365, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(firewall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(trendmicro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(delphi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ippbx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(iron, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(others)
                                        .addGap(27, 27, 27))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jButton1)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel24))
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eid, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel18)
                    .addComponent(ename, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel2)
                    .addComponent(atag, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25)
                    .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel3)
                    .addComponent(brand, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel5)
                    .addComponent(model, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel6)
                    .addComponent(account, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel7)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(jLabel8))
                    .addComponent(os, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel19)
                    .addComponent(office, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adobe)
                    .addComponent(jLabel31)
                    .addComponent(jLabel30)
                    .addComponent(iron))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(vslicense)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(godaddy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(zohoindia)
                        .addGap(29, 29, 29)
                        .addComponent(zohonz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(zohous)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cvs))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(support)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(installshield)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(office365)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firewall)
                            .addComponent(zohoire))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(trendmicro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delphi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ippbx)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel32)
                    .addComponent(others, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(jLabel21))
                    .addComponent(dateofassign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void eidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eidActionPerformed
        // TODO add your handling code here:
         eid.setText(update.n1);
         
    }//GEN-LAST:event_eidActionPerformed

    private void enameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enameActionPerformed

    private void atagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_atagActionPerformed

    private void brandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brandActionPerformed

    private void modelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modelActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        // TODO add your handling code here:
       Display.f1.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        String num=eid.getText();
        String name=ename.getText();

        if(account.getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(null, "Choose Account");
            return;
        }

        if (location.getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(null, "Choose Employee Location");
            return;
        }

        try {
            Database db = loading.db;
            Connection con1 = db.connection;
            stmt1 = con1.createStatement();
            String software="";
            pst1 = con1.prepareStatement("Update asset set account=?,user_location=?,comment=?,software=?,availability='no' where asset_tag = ? ");
            if(adobe.isSelected())
            {
                software=software+adobe.getText()+",";
            }
            if(vslicense.isSelected())
            {
                software=software+vslicense.getText()+",";
            }
            if(godaddy.isSelected())
            {
                software=software+godaddy.getText()+",";
            }
            if(zohoindia.isSelected())
            {
                software=software+zohoindia.getText()+",";
            }
            if(zohoire.isSelected())
            {
                software=software+zohoire.getText()+",";
            }
            if(zohonz.isSelected())
            {
                software=software+zohonz.getText()+",";
            }
            if(zohous.isSelected())
            {
                software=software+zohous.getText()+",";
            }
            if(cvs.isSelected())
            {
                software=software+cvs.getText()+",";
            }
            if(iron.isSelected())
            {
                software=software+iron.getText()+",";
            }
            if(support.isSelected())
            {
                software=software+support.getText()+",";
            }
            if(installshield.isSelected())
            {
                software=software+installshield.getText()+",";
            }
            if(office365.isSelected())
            {
                software=software+office365.getText()+",";
            }
            if(firewall.isSelected())
            {
                software=software+firewall.getText()+",";
            }
            if(trendmicro.isSelected())
            {
                software=software+trendmicro.getText()+",";
            }
            if(delphi.isSelected())
            {
                software=software+delphi.getText()+",";
            }
            if(ippbx.isSelected())
            {
                software=software+ippbx.getText()+",";
            }

            software = software+others.getText();
            pst1.setString(1, account.getSelectedItem().toString());
            pst1.setString(2, location.getSelectedItem().toString());
            pst1.setString(3, comments.getText());
            pst1.setString(4, software);
            pst1.setString(5, atag.getText());
            pst1.executeUpdate();
            
            
        }
        catch(SQLException e){ 
            JOptionPane.showMessageDialog(null, e);
            return;
            }

            
    int input = JOptionPane.showConfirmDialog(null,"Would you like to update the asset"+atag.getText()+"?", "Assigner",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
    if(input==0)
    {
        JOptionPane.showMessageDialog(null, "Asset " +atag.getText()+ " assigned to user " +ename.getText());
        this.dispose();
        Display d2 = new Display();
        d2.setVisible(true);
        Display.f1.dispose();
        Display.f1.setEnabled(true);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryActionPerformed

    private void godaddyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_godaddyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_godaddyActionPerformed

    private void firewallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firewallActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firewallActionPerformed

    private void ippbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ippbxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ippbxActionPerformed

    private void trendmicroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trendmicroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trendmicroActionPerformed

    private void office365ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_office365ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_office365ActionPerformed

    private void zohoireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zohoireActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zohoireActionPerformed

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
            java.util.logging.Logger.getLogger(updateasset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateasset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateasset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateasset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateasset().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> account;
    private javax.swing.JCheckBox adobe;
    private javax.swing.JTextField atag;
    private javax.swing.JTextField brand;
    private javax.swing.JTextField category;
    private javax.swing.JTextArea comments;
    private javax.swing.JCheckBox cvs;
    private com.toedter.calendar.JDateChooser dateofassign;
    private javax.swing.JCheckBox delphi;
    private javax.swing.JTextField eid;
    private javax.swing.JTextField ename;
    private javax.swing.JCheckBox firewall;
    private javax.swing.JCheckBox godaddy;
    private javax.swing.JCheckBox installshield;
    private javax.swing.JCheckBox ippbx;
    private javax.swing.JCheckBox iron;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> location;
    private javax.swing.JTextField model;
    private javax.swing.JComboBox<String> office;
    private javax.swing.JCheckBox office365;
    private javax.swing.JComboBox<String> os;
    private javax.swing.JTextField others;
    private javax.swing.JTextField status;
    private javax.swing.JCheckBox support;
    private javax.swing.JCheckBox trendmicro;
    private javax.swing.JCheckBox vslicense;
    private javax.swing.JCheckBox zohoindia;
    private javax.swing.JCheckBox zohoire;
    private javax.swing.JCheckBox zohonz;
    private javax.swing.JCheckBox zohous;
    // End of variables declaration//GEN-END:variables
}
//if(updateasset.n1==null)
//        {
//            JOptionPane.showMessageDialog(null,"Please select an asset to assign");
//        }
//        else{
//            assign assign = new assign();
//            assign.setVisible(true);}
//    }