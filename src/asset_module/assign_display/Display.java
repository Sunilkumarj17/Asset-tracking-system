package asset_module.assign_display;

import Database.Database;
import asset_module.assign_1.assign;
import asset_module.assign_1.reassign;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import asset_module.assign_update.update;
import asset_module.assign_update.update2;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import main.Homescreen3;
import main.Homescreen31;
import main.loading;
import static main.loading.db;
import asset_module.assign_1.remove;
import asset_module.assign_1.updateasset;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import main.Logins;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template


import java.awt.Color;
import javax.swing.BorderFactory;

/**
 *
 * @author vedasrinivas
 */
public class Display extends javax.swing.JFrame {

    /**
     * Creates new form Display
     */
    
    public static Connection con1;
    public static PreparedStatement pst1;
    public static PreparedStatement stmt;
    public static Statement stmt1;
    public static Display f1;
    String cat = null;
    String availString = null;
    String assetname = null;
    
    
    public Display() {
        initComponents();
       
        
        Vp.setVisible(true);
        Ap.setVisible(false);
        Up.setVisible(false);
        //textKeyReleased(null);
        
        update();
        update2();
        update3();
        table_align();
        tablealign2();
        date();
        
        setExtendedState(Display.MAXIMIZED_BOTH);
        int r3 = showTable.getRowCount();
        avail.setText(""+r3+"");
        int r4 = showTable1.getRowCount();
        avail1.setText(""+r4+"");
       
    }
    
    public void table_align()
    {
        showTable.setEditingColumn(ABORT);
        showTable.setEditingRow(ABORT);
        showTable.clearSelection();
        showTable.setAutoResizeMode(showTable1.AUTO_RESIZE_OFF);
        showTable1.setAutoResizeMode(showTable1.AUTO_RESIZE_OFF);
        
         TableColumn colum = showTable.getColumnModel().getColumn(0);
        colum.setPreferredWidth(100);
        colum = showTable.getColumnModel().getColumn(1);
        colum.setPreferredWidth(100);
        colum = showTable.getColumnModel().getColumn(2);
        colum.setPreferredWidth(80);
        colum = showTable.getColumnModel().getColumn(3);
        colum.setPreferredWidth(100);
        colum = showTable.getColumnModel().getColumn(4);
        colum.setPreferredWidth(100);
        colum = showTable.getColumnModel().getColumn(5);
        colum.setPreferredWidth(150);
        colum = showTable.getColumnModel().getColumn(6);
        colum.setPreferredWidth(150);
        colum = showTable.getColumnModel().getColumn(7);
        colum.setPreferredWidth(100);
        colum = showTable.getColumnModel().getColumn(8);
        colum.setPreferredWidth(160);
        colum = showTable.getColumnModel().getColumn(9);
        colum.setPreferredWidth(100);
        colum = showTable.getColumnModel().getColumn(10);
        colum.setPreferredWidth(100);
        colum = showTable.getColumnModel().getColumn(11);
        colum.setPreferredWidth(100);
        colum = showTable.getColumnModel().getColumn(12);
        colum.setPreferredWidth(100);
        
        TableColumn col = showTable1.getColumnModel().getColumn(0);
        col.setPreferredWidth(100);
        col = showTable1.getColumnModel().getColumn(1);
        col.setPreferredWidth(100);
        col = showTable1.getColumnModel().getColumn(2);
        col.setPreferredWidth(80);
        col = showTable1.getColumnModel().getColumn(3);
        col.setPreferredWidth(100);
        col = showTable1.getColumnModel().getColumn(4);
        col.setPreferredWidth(100);
        col = showTable1.getColumnModel().getColumn(5);
        col.setPreferredWidth(150);
        col = showTable1.getColumnModel().getColumn(6);
        col.setPreferredWidth(150);
        col = showTable1.getColumnModel().getColumn(7);
        col.setPreferredWidth(100);
        col = showTable1.getColumnModel().getColumn(8);
        col.setPreferredWidth(160);
        col = showTable1.getColumnModel().getColumn(9);
        col.setPreferredWidth(100);
        col = showTable1.getColumnModel().getColumn(10);
        col.setPreferredWidth(100);
        col = showTable1.getColumnModel().getColumn(11);
        col.setPreferredWidth(100);
        col = showTable1.getColumnModel().getColumn(12);
        col.setPreferredWidth(100);

        ATable3.setAutoResizeMode(ATable3.AUTO_RESIZE_OFF);
        TableColumn col2 = ATable3.getColumnModel().getColumn(0);
        col.setPreferredWidth(100);
        col = ATable3.getColumnModel().getColumn(1);
        col.setPreferredWidth(80);
        col = ATable3.getColumnModel().getColumn(2);
        col.setPreferredWidth(80);
        col = ATable3.getColumnModel().getColumn(3);
        col.setPreferredWidth(100);
        col = ATable3.getColumnModel().getColumn(4);
        col.setPreferredWidth(100);
        col = ATable3.getColumnModel().getColumn(5);
        col.setPreferredWidth(100);
        col = ATable3.getColumnModel().getColumn(6);
        col.setPreferredWidth(100);
        col = ATable3.getColumnModel().getColumn(7);
        col.setPreferredWidth(100);
        col = ATable3.getColumnModel().getColumn(8);
        col.setPreferredWidth(100);
        col = ATable3.getColumnModel().getColumn(9);
        col.setPreferredWidth(100);
        col = ATable3.getColumnModel().getColumn(10);
        col.setPreferredWidth(90);
        col = ATable3.getColumnModel().getColumn(11);
        col.setPreferredWidth(150);
        col = ATable3.getColumnModel().getColumn(12);
        col.setPreferredWidth(80);
        col = ATable3.getColumnModel().getColumn(13);
        col.setPreferredWidth(90);
        col = ATable3.getColumnModel().getColumn(14);
        col.setPreferredWidth(80);
        col = ATable3.getColumnModel().getColumn(15);
        col.setPreferredWidth(100);
        col = ATable3.getColumnModel().getColumn(16);
        col.setPreferredWidth(150);

        

    }
    public void tablealign2()
    {
         DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
        centerRender.setHorizontalAlignment(JLabel.CENTER);
        
        showTable.setFont(new Font("Segoe UI",Font.PLAIN,11));
        

        for(int i = 0; i<=12; i++)
        {
            showTable.getColumnModel().getColumn(i).setCellRenderer(centerRender);
        }
        
        JTableHeader thead = showTable.getTableHeader();
        
        //thead.setBackground(Color.BLUE);
        thead.setForeground(Color.BLACK);
        thead.setFont(new Font("Segoe UI",Font.BOLD,12));
        
        ((DefaultTableCellRenderer)thead.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
        DefaultTableCellRenderer centerRender1 = new DefaultTableCellRenderer();
        centerRender1.setHorizontalAlignment(JLabel.CENTER);
        showTable1.setFont(new Font("Segoe UI",Font.PLAIN,11));
        

        for(int j = 0; j<=12; j++)
        {
            showTable1.getColumnModel().getColumn(j).setCellRenderer(centerRender1);
        }
        
        JTableHeader thead2 = showTable1.getTableHeader();
        
        //thead.setBackground(Color.BLUE);
        thead2.setForeground(Color.BLACK);
        thead2.setFont(new Font("Segoe UI",Font.BOLD,12));
        
        ((DefaultTableCellRenderer)thead2.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
        DefaultTableCellRenderer centerRender2 = new DefaultTableCellRenderer();
        centerRender2.setHorizontalAlignment(JLabel.CENTER);
        
         ATable3.setFont(new Font("Segoe UI",Font.PLAIN,11));
        
        for(int i=0;i<=15;i++)
        {
            ATable3.getColumnModel().getColumn(i).setCellRenderer(centerRender2);
        }
        
        JTableHeader thead3 = ATable3.getTableHeader();
        thead3.setForeground(Color.BLACK);
        thead3.setFont(new Font("Segoe UI",Font.BOLD,12));
        
        ((DefaultTableCellRenderer)thead3.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        

    }
    public void date()
    {
        String assettag = null;
        Date providedate = null;
       Statement stmt;
        
        int num = 0;
        try
        {
            Database db = loading.db;
            Connection con = db.connection;
            stmt = con.createStatement();
            PreparedStatement pst1=con.prepareStatement("Select COUNT(*) FROM asset WHERE handover_date IS NULL");
           
            ResultSet rs1 = pst1.executeQuery();
               while(rs1.next()){
                   num = rs1.getInt(1);
               }
            
                SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
               Date curdate = new Date();
               String cdate = fmt.format(curdate);
                PreparedStatement pst2 = con.prepareStatement("Select asset_tag, provide_date  FROM asset where handover_date IS NULL");
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                   assettag = rs2.getString("asset_tag");
                   providedate = rs2.getDate("provide_date");
                   String pdate = fmt.format(providedate);
                   final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    final LocalDate firstDate = LocalDate.parse(cdate, formatter);
                    final LocalDate secondDate = LocalDate.parse(pdate, formatter);
                    
                    final long days = ChronoUnit.DAYS.between(secondDate, firstDate);
                    int jnum=(int)days;
                    for(int i=0;i<num;i++)
                    {
                        PreparedStatement pst3=con.prepareStatement("UPDATE asset SET duration=? WHERE asset_tag=?");
                        pst3.setInt(1,jnum);
                        pst3.setString(2, assettag);
                        if(jnum>=0)
                        {
                        ATable3.setValueAt(days, i, 14);
                        pst3.executeUpdate();
                        }
                        update();
                    }
                }
           
        } catch (Exception e) {
            System.out.println(e);
        }


    }
    public void update() {
        try {
            Database db = loading.db;
            Connection con = db.connection;
            PreparedStatement stmt = con.prepareStatement("Select asset_tag,category,brand,model,eid,handling_user,user_location,account,provide_date,status,os,ms_office,software from asset where status='working' and provide_date is null and handover_date IS NULL and availability = 'free'");
            ResultSet rs = stmt.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            showTable.setModel(model);
            model.addColumn("Asset Tag");
            model.addColumn("Category");
            model.addColumn("Brand");
            model.addColumn("Model");
            model.addColumn("User ID");
            model.addColumn("Handling User");
            model.addColumn("User Location");
            model.addColumn("Account");
            model.addColumn("Provide Date");
            model.addColumn("Status");
            model.addColumn("OS");
            model.addColumn("MS Office");
            model.addColumn("Software");

            while (rs.next()) {
                model.addRow(new String[]{rs.getString(1), Capitalize.capitalize.capitalize(rs.getString(2)), Capitalize.capitalize.capitalize(rs.getString(3)), Capitalize.capitalize.capitalize(rs.getString(4)), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13)});
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public void update2()
    {
        try {
            Database db = loading.db;
            Connection con = db.connection;
            PreparedStatement stmt = con.prepareStatement("Select asset_tag,category,brand,model,eid,handling_user,user_location,account,provide_date,status,os,ms_office,software from asset where availability='assigned' and status='working' and handover_date IS NULL");
            ResultSet rs = stmt.executeQuery();

            DefaultTableModel model2 = new DefaultTableModel();
            showTable1.setModel(model2);
            model2.addColumn("Asset Tag");
            model2.addColumn("Category");
            model2.addColumn("Brand");
            model2.addColumn("Model");
            model2.addColumn("User ID");
            model2.addColumn("Handling User");
            model2.addColumn("User Location");
            model2.addColumn("Account");
            model2.addColumn("Provided Date");
            model2.addColumn("Status");
            model2.addColumn("OS");
            model2.addColumn("MS Office");
            model2.addColumn("Software");


            while (rs.next()) {
                model2.addRow(new String[]{rs.getString(1), Capitalize.capitalize.capitalize(rs.getString(2)), Capitalize.capitalize.capitalize(rs.getString(3)), Capitalize.capitalize.capitalize(rs.getString(4)), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13)});
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
     public void update3() {
        try {

            Database db = loading.db;
            Connection con = db.connection;
            PreparedStatement stmt = con.prepareStatement("select asset_tag,category,brand,model,eid,handling_user,user_location,account,provide_date,handover_date,status,comment,os,ms_office,duration,availability,software from asset");
            ResultSet rs = stmt.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            ATable3.setModel(model);
            model.addColumn("Asset Tag");
            model.addColumn("Category");
            model.addColumn("Brand");
            model.addColumn("Model");
            model.addColumn("User ID");
            model.addColumn("Handling User");
            model.addColumn("User Location");          
            model.addColumn("Account");
            model.addColumn("Provide Date");
            model.addColumn("HandOver Date");
            model.addColumn("Status");
            model.addColumn("Comment");
            model.addColumn("OS");
            model.addColumn("Office");
            model.addColumn("Duration");
            model.addColumn("Availability");
            model.addColumn("Software");
            //model.addColumn("");
            table_align();
            tablealign2();
            while (rs.next()) {
                model.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16),rs.getString(17)});
            }
            
        } catch (SQLException ex) {
            System.err.println(ex);
        }
     }
    public  void update(String a,String a1, String a2, String a3, String a4, String a5, String a6, String a7)
    {
        update.n = a;
        update.n1 = a1;
        update.n2 = a2;
        update.n3 = a3;
        update.n4 = a4;
        update.n5 = a5;
        update.n6 = a6;   
        update.n7 = a7;
        System.out.println(update.n);
       
    }
    public  void update(String b,String b1, String b2, String b3)
    {
        update2.a = b;
        update2.a1 = b1;
        update2.a2 = b2;
        update2.a3 = b3;        
    }
    
        public void remove_update(String a, String a1, String a2, String a3,String a4, String a5,String a6,String a7) {
        return_module.globalremove.update.n = a;//assettag
        return_module.globalremove.update.n1 = a1;//category
        return_module.globalremove.update.n2 = a2;//brand
        return_module.globalremove.update.n3 = a3;//model
        return_module.globalremove.update.n4 = a4;//eid
        return_module.globalremove.update.n5 = a5;//account
        return_module.globalremove.update.n6 = a6;//provide_date
        return_module.globalremove.update.n7 = a7;//comment
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        loginpanel = new javax.swing.JPanel();
        logtext = new javax.swing.JLabel();
        logimg = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Apanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Asset = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        logimg1 = new javax.swing.JLabel();
        view_asset = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        Vp = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        showTable = new javax.swing.JTable();
        asearch = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        avail = new javax.swing.JLabel();
        assign = new javax.swing.JButton();
        category = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        availability = new javax.swing.JComboBox<>();
        Ap = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        asearch1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        avail1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        showTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        category2 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        Up = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        search2 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        ATable3 = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        search4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 161, 225));
        jPanel2.setPreferredSize(new java.awt.Dimension(516, 79));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Asset Assignment");

        loginpanel.setBackground(new java.awt.Color(0, 161, 225));
        loginpanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        loginpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginpanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginpanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginpanelMouseExited(evt);
            }
        });

        logtext.setBackground(new java.awt.Color(9, 113, 206));
        logtext.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        logtext.setForeground(new java.awt.Color(255, 255, 255));
        logtext.setText("Logout");
        logtext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logtextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logtextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logtextMouseExited(evt);
            }
        });

        logimg.setBackground(new java.awt.Color(9, 113, 206));
        logimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tpftool/images/userwhite (1).png"))); // NOI18N
        logimg.setText("jLabel23");
        logimg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logimgMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logimgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logimgMouseExited(evt);
            }
        });

        javax.swing.GroupLayout loginpanelLayout = new javax.swing.GroupLayout(loginpanel);
        loginpanel.setLayout(loginpanelLayout);
        loginpanelLayout.setHorizontalGroup(
            loginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginpanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logimg, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logtext, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        loginpanelLayout.setVerticalGroup(
            loginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logimg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logtext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loginpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(loginpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(0, 161, 225));

        Apanel.setBackground(new java.awt.Color(0, 161, 225));
        Apanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 255, 255)));
        Apanel.setPreferredSize(new java.awt.Dimension(220, 46));
        Apanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ApanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ApanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ApanelMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Assign Asset");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout ApanelLayout = new javax.swing.GroupLayout(Apanel);
        Apanel.setLayout(ApanelLayout);
        ApanelLayout.setHorizontalGroup(
            ApanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ApanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        ApanelLayout.setVerticalGroup(
            ApanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ApanelLayout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Asset.setBackground(new java.awt.Color(0, 161, 225));
        Asset.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 255, 255)));
        Asset.setPreferredSize(new java.awt.Dimension(220, 46));
        Asset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AssetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AssetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AssetMouseExited(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(0, 161, 225));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Update Asset");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });

        javax.swing.GroupLayout AssetLayout = new javax.swing.GroupLayout(Asset);
        Asset.setLayout(AssetLayout);
        AssetLayout.setHorizontalGroup(
            AssetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AssetLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel18)
                .addGap(44, 44, 44)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        AssetLayout.setVerticalGroup(
            AssetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(AssetLayout.createSequentialGroup()
                .addGroup(AssetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AssetLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        logimg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tpftool/images/Images/back_white1.png"))); // NOI18N
        logimg1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logimg1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logimg1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logimg1MouseExited(evt);
            }
        });

        view_asset.setBackground(new java.awt.Color(0, 161, 225));
        view_asset.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 255, 255)));
        view_asset.setPreferredSize(new java.awt.Dimension(220, 46));
        view_asset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view_assetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                view_assetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                view_assetMouseExited(evt);
            }
        });

        jLabel29.setBackground(new java.awt.Color(0, 161, 225));
        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Display Asset");
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel29MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel29MouseExited(evt);
            }
        });

        javax.swing.GroupLayout view_assetLayout = new javax.swing.GroupLayout(view_asset);
        view_asset.setLayout(view_assetLayout);
        view_assetLayout.setHorizontalGroup(
            view_assetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(view_assetLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel31)
                .addGap(44, 44, 44)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addComponent(jLabel30)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        view_assetLayout.setVerticalGroup(
            view_assetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(view_assetLayout.createSequentialGroup()
                .addGroup(view_assetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(view_assetLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel29)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logimg1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(Apanel, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
            .addComponent(Asset, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
            .addComponent(view_asset, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logimg1)
                .addGap(36, 36, 36)
                .addComponent(Apanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(Asset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(view_asset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(373, Short.MAX_VALUE))
        );

        Vp.setBackground(new java.awt.Color(255, 255, 255));
        Vp.setPreferredSize(new java.awt.Dimension(978, 637));
        Vp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VpMouseClicked(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(0, 161, 225));
        jPanel5.setPreferredSize(new java.awt.Dimension(184, 3));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 184, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jLabel12.setFont(new java.awt.Font("Kievit Offc Pro", 0, 18)); // NOI18N
        jLabel12.setText("Search by Asset Category   :");

        jLabel13.setFont(new java.awt.Font("Kievit Offc Pro", 0, 18)); // NOI18N
        jLabel13.setText("Search by Asset ID              :");

        showTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Asset Tag", "Category", "Brand", "Model", "User ID", "Handling User", "User Location", "Account", "Provide Date", "Status", "OS", "MS Office", "Software"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        showTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        showTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        showTable.setGridColor(new java.awt.Color(204, 51, 0));
        showTable.getTableHeader().setReorderingAllowed(false);
        showTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(showTable);
        if (showTable.getColumnModel().getColumnCount() > 0) {
            showTable.getColumnModel().getColumn(0).setResizable(false);
            showTable.getColumnModel().getColumn(1).setResizable(false);
            showTable.getColumnModel().getColumn(2).setResizable(false);
            showTable.getColumnModel().getColumn(3).setResizable(false);
            showTable.getColumnModel().getColumn(4).setResizable(false);
            showTable.getColumnModel().getColumn(5).setResizable(false);
            showTable.getColumnModel().getColumn(6).setResizable(false);
            showTable.getColumnModel().getColumn(7).setResizable(false);
            showTable.getColumnModel().getColumn(8).setResizable(false);
            showTable.getColumnModel().getColumn(9).setResizable(false);
            showTable.getColumnModel().getColumn(10).setResizable(false);
            showTable.getColumnModel().getColumn(11).setResizable(false);
            showTable.getColumnModel().getColumn(12).setResizable(false);
        }

        asearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asearchActionPerformed(evt);
            }
        });
        asearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                asearchKeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setText("Available Assets :");

        avail.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        avail.setText("1");

        assign.setText("Assign");
        assign.setBorderPainted(false);
        assign.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        assign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignActionPerformed(evt);
            }
        });

        category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Laptop", "Keyboard", "Mouse", "Monitor", "Hard disk", "Laptop battery", "Laptop keypad" }));
        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Kievit Offc Pro", 0, 18)); // NOI18N
        jLabel21.setText("Search by Availability          :");

        availability.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Free", "Assigned", "History", " " }));
        availability.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availabilityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout VpLayout = new javax.swing.GroupLayout(Vp);
        Vp.setLayout(VpLayout);
        VpLayout.setHorizontalGroup(
            VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VpLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VpLayout.createSequentialGroup()
                        .addComponent(assign)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(VpLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addGroup(VpLayout.createSequentialGroup()
                        .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(VpLayout.createSequentialGroup()
                                .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(asearch)
                                    .addComponent(category, 0, 155, Short.MAX_VALUE))
                                .addGap(66, 66, 66)
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(availability, 0, 148, Short.MAX_VALUE))
                            .addGroup(VpLayout.createSequentialGroup()
                                .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(VpLayout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(avail, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(79, 79, 79))))
        );
        VpLayout.setVerticalGroup(
            VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VpLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(asearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(availability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(avail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(assign)
                .addGap(93, 93, 93))
        );

        Ap.setBackground(new java.awt.Color(255, 255, 255));
        Ap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ApMouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Kievit Offc Pro", 0, 18)); // NOI18N
        jLabel15.setText("Search by Asset ID              :");

        asearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                asearch1KeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Kievit Offc Pro", 0, 18)); // NOI18N
        jLabel16.setText("Search by Asset Category   :");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel17.setText("Engaged Assets :");

        avail1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        avail1.setText("1");

        jPanel8.setBackground(new java.awt.Color(0, 161, 225));
        jPanel8.setPreferredSize(new java.awt.Dimension(184, 3));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        showTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Asset Tag", "Category", "Brand", "Model", "User ID", "Handling User", "User Location", "Account", "Provided Date", "Status", "OS", "MS Office", "Software"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        showTable1.getTableHeader().setReorderingAllowed(false);
        showTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(showTable1);
        if (showTable1.getColumnModel().getColumnCount() > 0) {
            showTable1.getColumnModel().getColumn(0).setResizable(false);
            showTable1.getColumnModel().getColumn(1).setResizable(false);
            showTable1.getColumnModel().getColumn(2).setResizable(false);
            showTable1.getColumnModel().getColumn(3).setResizable(false);
            showTable1.getColumnModel().getColumn(4).setResizable(false);
            showTable1.getColumnModel().getColumn(5).setResizable(false);
            showTable1.getColumnModel().getColumn(6).setResizable(false);
            showTable1.getColumnModel().getColumn(7).setResizable(false);
            showTable1.getColumnModel().getColumn(8).setResizable(false);
            showTable1.getColumnModel().getColumn(9).setResizable(false);
            showTable1.getColumnModel().getColumn(10).setResizable(false);
            showTable1.getColumnModel().getColumn(11).setResizable(false);
            showTable1.getColumnModel().getColumn(12).setResizable(false);
        }

        jButton2.setText("Return Back");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        category2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Laptop", "Keyboard", "Mouse", "Monitor", "Hard disk", "Laptop battery", "Laptop keypad" }));
        category2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                category2ActionPerformed(evt);
            }
        });

        jButton3.setText("Update");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ApLayout = new javax.swing.GroupLayout(Ap);
        Ap.setLayout(ApLayout);
        ApLayout.setHorizontalGroup(
            ApLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ApLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(ApLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ApLayout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(46, 46, 46)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ApLayout.createSequentialGroup()
                        .addGroup(ApLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
                            .addGroup(ApLayout.createSequentialGroup()
                                .addGroup(ApLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ApLayout.createSequentialGroup()
                                        .addGroup(ApLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel16))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(ApLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(category2, 0, 155, Short.MAX_VALUE)
                                            .addComponent(asearch1)))
                                    .addGroup(ApLayout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(avail1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 522, Short.MAX_VALUE)))
                        .addGap(20, 20, 20))))
        );
        ApLayout.setVerticalGroup(
            ApLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ApLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(ApLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(asearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(ApLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(category2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ApLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(avail1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ApLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addGap(120, 120, 120))
        );

        Up.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Search by Asset Tag:");

        search2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                search2FocusGained(evt);
            }
        });
        search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search2ActionPerformed(evt);
            }
        });
        search2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search2KeyReleased(evt);
            }
        });

        ATable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "TPF Number", "Category", "Brand", "Model", "User Location", "User ID", "Handling User", "Account", "ProvideDate", "Hand Over Date", "Status", "Availability", "Comment", "Windows", "Office", "Duration"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ATable3.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        ATable3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane4.setViewportView(ATable3);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel20.setText("Filter Assets");

        jPanel9.setBackground(new java.awt.Color(0, 161, 225));
        jPanel9.setPreferredSize(new java.awt.Dimension(261, 5));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Status:");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select Status--", "Working", "Scrap", "In-Service" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setText("Availability:");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select Availability Status--", "Free", "Assigned", "History" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setText("Category:");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select Category--", "Laptop", "Keyboard", "Mouse", "Monitor", "Hard Disk", "Laptop Battery", "Laptop Keypad", " " }));
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setText("Search by User ID:");

        search4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                search4FocusGained(evt);
            }
        });
        search4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search4ActionPerformed(evt);
            }
        });
        search4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search4KeyReleased(evt);
            }
        });

        jButton1.setText("View All");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Eport to Excel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Export to PDF");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UpLayout = new javax.swing.GroupLayout(Up);
        Up.setLayout(UpLayout);
        UpLayout.setHorizontalGroup(
            UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpLayout.createSequentialGroup()
                .addGroup(UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4)
                            .addGroup(UpLayout.createSequentialGroup()
                                .addGroup(UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(UpLayout.createSequentialGroup()
                                        .addGap(128, 128, 128)
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel32)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel33)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                        .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)))
                                .addGap(0, 206, Short.MAX_VALUE))))
                    .addGroup(UpLayout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UpLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jButton1)
                                .addGap(28, 28, 28)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(UpLayout.createSequentialGroup()
                                .addComponent(search2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(119, 119, 119)
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(search4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20))
        );
        UpLayout.setVerticalGroup(
            UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel34)
                        .addComponent(search4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(search2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1004, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Ap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Vp, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Up, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Ap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Vp, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Up, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1231, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logimgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logimgMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new Logins().setVisible(true);
    }//GEN-LAST:event_logimgMouseClicked

    private void logimgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logimgMouseEntered
        // TODO add your handling code here:
        loginpanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.white));
    }//GEN-LAST:event_logimgMouseEntered

    private void logimgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logimgMouseExited
        // TODO add your handling code here:
        loginpanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }//GEN-LAST:event_logimgMouseExited

    private void logtextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logtextMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new Logins().setVisible(true);
    }//GEN-LAST:event_logtextMouseClicked

    private void logtextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logtextMouseEntered
        // TODO add your handling code here:
        loginpanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.white));
    }//GEN-LAST:event_logtextMouseEntered

    private void logtextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logtextMouseExited
        // TODO add your handling code here:
        loginpanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }//GEN-LAST:event_logtextMouseExited

    private void loginpanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginpanelMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new Logins().setVisible(true);
    }//GEN-LAST:event_loginpanelMouseClicked

    private void loginpanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginpanelMouseEntered
        // TODO add your handling code here:
        loginpanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.white));
    }//GEN-LAST:event_loginpanelMouseEntered

    private void loginpanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginpanelMouseExited
        // TODO add your handling code here:
        loginpanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }//GEN-LAST:event_loginpanelMouseExited

    private void ApanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ApanelMouseEntered
        // TODO add your handling code here:
        Apanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.WHITE));
        Apanel.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_ApanelMouseEntered

    private void ApanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ApanelMouseExited
        // TODO add your handling code here:
        //All.setBorder(BorderFactory.createEmptyBorder());
        Apanel.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.white));
        Apanel.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_ApanelMouseExited

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        // TODO add your handling code here:
        Apanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.WHITE));
        Apanel.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        // TODO add your handling code here:
        Apanel.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.white));
        Apanel.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        // TODO add your handling code here:
        Asset.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.WHITE));
        Asset.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        // TODO add your handling code here:
        Asset.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.white));
        Asset.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_jLabel10MouseExited

    private void AssetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AssetMouseEntered
        // TODO add your handling code here:
        Asset.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.WHITE));
        Asset.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_AssetMouseEntered

    private void AssetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AssetMouseExited
        // TODO add your handling code here:
        Asset.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.white));
        Asset.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_AssetMouseExited

    private void ApanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ApanelMouseClicked
        // TODO add your handling code here:
        Vp.setVisible(true);
        Ap.setVisible(false);
        Up.setVisible(false);
    }//GEN-LAST:event_ApanelMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        Vp.setVisible(true);
        Ap.setVisible(false);
        Up.setVisible(false);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void AssetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AssetMouseClicked
        // TODO add your handling code here:
        Vp.setVisible(false);
        Ap.setVisible(true);
        Up.setVisible(false);
    }//GEN-LAST:event_AssetMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        Vp.setVisible(false);
        Ap.setVisible(true);
        Up.setVisible(false);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void logimg1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logimg1MouseClicked
        // TODO add your handling code here:
        if(Global.user.User == "superadmin"){
        Homescreen3 a = new Homescreen3();
        a.setVisible(true);}
        else{Homescreen31 f = new Homescreen31(); f.setVisible(true);}
        this.dispose();
        //new Homescreen3().setVisible(true);
    }//GEN-LAST:event_logimg1MouseClicked

    private void logimg1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logimg1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_logimg1MouseEntered

    private void logimg1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logimg1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_logimg1MouseExited

    public static ResultSet getData(String name) throws SQLException
    {
        pst1.setString(1,"%"+name+"%");
        return pst1.executeQuery();
    }
    private void asearch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_asearch1KeyReleased
        // TODO add your handling code here:
        allupdate();
//        int position = asearch1.getCaretPosition();
//        asearch1.setText(asearch1.getText().toUpperCase());
//        asearch1.setCaretPosition(position);
//        String name = asearch1.getText();
//        DefaultTableModel dtm = (DefaultTableModel) showTable1.getModel();
//        int r = showTable1.getRowCount();
//        
//        while(r-->0)
//        {
//            dtm.removeRow(r);
//        }
//        
//        try
//        {
//            Database db = loading.db;
//            Connection con = db.connection;
//            stmt1 = con.createStatement();
//            pst1 = con.prepareStatement("Select asset_tag,category,brand,model,eid,handling_user,user_location,account,provide_date,status,os,ms_office,software from asset where asset_tag like ? and availability='no' and handover_date IS NULL");
// 
//            ResultSet rs = getData(name);
//            
//            while(rs.next())
//            {
//                java.util.Vector v = new java.util.Vector();
//                v.add(rs.getString("asset_tag"));
//                v.add(rs.getString("category"));
//                v.add(rs.getString("brand"));
//                v.add(rs.getString("model"));
//                v.add(rs.getString("eid"));
//                v.add(rs.getString("handling_user"));
//                v.add(rs.getString("user_location"));
//                v.add(rs.getString("account"));
//                v.add(rs.getString("provide_date"));
//                v.add(rs.getString("status"));
//                v.add(rs.getString("os"));
//                v.add(rs.getString("ms_office"));
//                v.add(rs.getString("software"));
//                
//                dtm.addRow(v);
//            }
//        }
//        catch (SQLException ex)
//        {
//            JOptionPane.showMessageDialog(null, "Database error");
//        }
    }//GEN-LAST:event_asearch1KeyReleased

    private void showTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showTable1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_showTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        try {
            String comments=null;
            System.out.println("Return back");
            DefaultTableModel RecordTable = (DefaultTableModel) showTable1.getModel();
            String AssetTag = RecordTable.getValueAt(showTable1.getSelectedRow(), 0).toString();
            String Category = RecordTable.getValueAt(showTable1.getSelectedRow(), 1).toString();
            String Model = RecordTable.getValueAt(showTable1.getSelectedRow(), 3).toString();
            String Eid = RecordTable.getValueAt(showTable1.getSelectedRow(), 4).toString();
            String Users = RecordTable.getValueAt(showTable1.getSelectedRow(), 5).toString();
            String Account = RecordTable.getValueAt(showTable1.getSelectedRow(), 7).toString();
            String provide_date = RecordTable.getValueAt(showTable1.getSelectedRow(), 8).toString();
             try {
                 Connection con1 = db.connection;
                    PreparedStatement pst3 = con1.prepareStatement("select comment from asset where asset_tag like ? and provide_date IS NOT NULL and handover_date IS NULL");
                    pst3.setString(1, AssetTag);
                    ResultSet rs = pst3.executeQuery();
                    while(rs.next()){
                        comments = rs.getString("comment");
                    }
             }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
            remove_update(AssetTag, Category, Model,Eid, Users,Account, provide_date,comments);
            
            remove assign = new remove();
            assign.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void assignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignActionPerformed
        // TODO add your handling code here:
        try {
            String User_id;
            String Handling_user;
            String User_location;
            String Account;
            String Os;
            String Office;
            DefaultTableModel RecordTable=(DefaultTableModel) showTable.getModel();
            String AssetTag=RecordTable.getValueAt(showTable.getSelectedRow(),0).toString();
            String Category=RecordTable.getValueAt(showTable.getSelectedRow(),1).toString();
            String Brand=RecordTable.getValueAt(showTable.getSelectedRow(),2).toString();
            String Model=RecordTable.getValueAt(showTable.getSelectedRow(),3).toString();
            try {
                User_id=RecordTable.getValueAt(showTable.getSelectedRow(),4).toString();
            } catch (Exception e) {
                User_id="";
            }
            try {
                Handling_user=RecordTable.getValueAt(showTable.getSelectedRow(),5).toString();
            } catch (Exception e) {
                Handling_user="";
            }
            try {
                User_location=RecordTable.getValueAt(showTable.getSelectedRow(),6).toString();
            } catch (Exception e) {
                User_location="";
            }
            try {
                Account=RecordTable.getValueAt(showTable.getSelectedRow(),7).toString();
            } catch (Exception e) {
                Account="";
            }
            String Status=RecordTable.getValueAt(showTable.getSelectedRow(),9).toString();
            try {
                Os=RecordTable.getValueAt(showTable.getSelectedRow(),10).toString();
            } catch (Exception e) {
                Os="";
            }
            try {
                Office=RecordTable.getValueAt(showTable.getSelectedRow(),11).toString();
            } catch (Exception e) {
                Office="";
            }
            
            //String Account = "";        System.out.println(AssetTag+"/");

            update(AssetTag,Category,Brand,Model,Account,Status,Os,Office);
            
            assign assign = new assign();
            assign.setVisible(true);
            


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Please select an asset to assign");
            //JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_assignActionPerformed
    
    private void asearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_asearchKeyReleased
        all();
    }//GEN-LAST:event_asearchKeyReleased

    private void showTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_showTableMouseClicked

    private void VpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VpMouseClicked
        // TODO add your handling code here:
        showTable.clearSelection();
    }//GEN-LAST:event_VpMouseClicked

    public void csearch(String name)
    {
        all();
    }
    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
            all();
    }//GEN-LAST:event_categoryActionPerformed
public void all(){
     try {
            Database db = loading.db;
            Connection con = db.connection;
             
        assetname= asearch.getText();
        cat = category.getSelectedItem().toString().toLowerCase();
        availString = availability.getSelectedItem().toString().toLowerCase();
        if( "all".equals(cat) && "all".equals(availString)){
            stmt = con.prepareStatement("Select asset_tag,category,brand,model,eid,handling_user,user_location,account,provide_date,status,os,ms_office,software from asset where  asset_tag like ? and  status = 'working' ");
            stmt.setString(1, "%"+assetname+"%");
        }
         if("all".equals(cat) && !"all".equals(availString)){
             stmt = con.prepareStatement("Select asset_tag,category,brand,model,eid,handling_user,user_location,account,provide_date,status,os,ms_office,software from asset where"
                    + " asset_tag like ? AND availability like ? and status = 'working'");
            stmt.setString(1, "%"+assetname+"%");
            stmt.setString(2, availString);
        }
        if( !"all".equals(cat) && "all".equals(availString)){
             stmt = con.prepareStatement("Select asset_tag,category,brand,model,eid,handling_user,user_location,account,provide_date,status,os,ms_office,software from asset where"
                    + " asset_tag like ? AND category like ? and status = 'working'");
            stmt.setString(1, "%"+assetname+"%");
            stmt.setString(2, cat);
        }
         if(!"all".equals(cat) && !"all".equals(availString)){
             stmt = con.prepareStatement("Select asset_tag,category,brand,model,eid,handling_user,user_location,account,provide_date,status,os,ms_office,software from asset where"
                    + " asset_tag like ? and(availability like ? and category like ? and status = 'working')");
            stmt.setString(1, "%"+assetname+"%");
            stmt.setString(2, availString);
            stmt.setString(3, cat);
        }
            ResultSet rs = stmt.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            showTable.setModel(model);     
            model.addColumn("Asset Tag");
            model.addColumn("Category");
            model.addColumn("Brand");
            model.addColumn("Model");
            model.addColumn("User ID");
            model.addColumn("Handling User");
            model.addColumn("User Location");
            model.addColumn("Account");
            model.addColumn("Provide Date");
            model.addColumn("Status");
            model.addColumn("OS");
            model.addColumn("MS Office");
            model.addColumn("Software");

            table_align();
            tablealign2();
            while (rs.next()) {
                model.addRow(new String[]{rs.getString(1), Capitalize.capitalize.capitalize(rs.getString(2)),Capitalize.capitalize.capitalize(rs.getString(3)), Capitalize.capitalize.capitalize(rs.getString(4)), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13)});
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
}
    
public void allupdate(){
     try {
            Database db = loading.db;
            Connection con = db.connection;
             
        assetname= asearch1.getText();
        cat = category2.getSelectedItem().toString().toLowerCase();
        if( "all".equals(cat)){
            stmt = con.prepareStatement("Select asset_tag,category,brand,model,eid,handling_user,user_location,account,provide_date,status,os,ms_office,software from asset where  asset_tag like ? and  status = 'working' and handover_date IS NULL and availability='assigned' and provide_date IS NOT NULL ");
            stmt.setString(1, "%"+assetname+"%");
        }
        if( !"all".equals(cat)){
             stmt = con.prepareStatement("Select asset_tag,category,brand,model,eid,handling_user,user_location,account,provide_date,status,os,ms_office,software from asset where"
                    + " asset_tag like ? AND category like ? and status = 'working' and handover_date IS NULL and availability='assigned' and provide_date IS NOT NULL");
            stmt.setString(1, "%"+assetname+"%");
            stmt.setString(2, cat);
        }
            ResultSet rs = stmt.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            showTable1.setModel(model);     
            model.addColumn("Asset Tag");
            model.addColumn("Category");
            model.addColumn("Brand");
            model.addColumn("Model");
            model.addColumn("User ID");
            model.addColumn("Handling User");
            model.addColumn("User Location");
            model.addColumn("Account");
            model.addColumn("Provide Date");
            model.addColumn("Status");
            model.addColumn("OS");
            model.addColumn("MS Office");
            model.addColumn("Software");

            table_align();
            tablealign2();
            while (rs.next()) {
                model.addRow(new String[]{rs.getString(1), Capitalize.capitalize.capitalize(rs.getString(2)),Capitalize.capitalize.capitalize(rs.getString(3)), Capitalize.capitalize.capitalize(rs.getString(4)), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13)});
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
}
    private void availabilityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availabilityActionPerformed
        // TODO add your handling code here:
          all();
//       
    }//GEN-LAST:event_availabilityActionPerformed

    private void category2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_category2ActionPerformed
        // TODO add your handling code here:
        allupdate();
    }//GEN-LAST:event_category2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton2MouseClicked

    private void asearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asearchActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String User_id;
            String Handling_user;
            String User_location;
            String Account;
            String Os;
            String Office;
            DefaultTableModel RecordTable=(DefaultTableModel) showTable1.getModel();
            String AssetTag=RecordTable.getValueAt(showTable1.getSelectedRow(),0).toString();
            String Category=RecordTable.getValueAt(showTable1.getSelectedRow(),1).toString();
            String Brand=RecordTable.getValueAt(showTable1.getSelectedRow(),2).toString();
            String Model=RecordTable.getValueAt(showTable1.getSelectedRow(),3).toString();
            try {
                User_id=RecordTable.getValueAt(showTable1.getSelectedRow(),4).toString();
            } catch (Exception e) {
                User_id="";
            }
            try {
                Handling_user=RecordTable.getValueAt(showTable1.getSelectedRow(),5).toString();
            } catch (Exception e) {
                Handling_user="";
            }
            try {
                User_location=RecordTable.getValueAt(showTable1.getSelectedRow(),6).toString();
            } catch (Exception e) {
                User_location="";
            }
            try {
                Account=RecordTable.getValueAt(showTable1.getSelectedRow(),7).toString();
            } catch (Exception e) {
                Account="";
            }
            String Status=RecordTable.getValueAt(showTable1.getSelectedRow(),9).toString();
            try {
                Os=RecordTable.getValueAt(showTable1.getSelectedRow(),10).toString();
            } catch (Exception e) {
                Os="";
            }
            try {
                Office=RecordTable.getValueAt(showTable1.getSelectedRow(),11).toString();
            } catch (Exception e) {
                Office="";
            }
            update(AssetTag,Category,Brand,Model,Account,Status,Os,Office);
            update.eid = User_id;
            update.ename=Handling_user;
            update.loc = User_location;
            
        updateasset u1 = new updateasset();
        u1.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        // TODO add your handling code here:
        Up.setVisible(true);
        Vp.setVisible(false);
        Ap.setVisible(false);
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel29MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseEntered
        // TODO add your handling code here:
        view_asset.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.WHITE));
        view_asset.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_jLabel29MouseEntered

    private void jLabel29MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseExited
        // TODO add your handling code here:
        view_asset.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.white));
        view_asset.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_jLabel29MouseExited

    private void view_assetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_assetMouseClicked
        // TODO add your handling code here:
        Up.setVisible(true);
        Vp.setVisible(false);
        Ap.setVisible(false);
    }//GEN-LAST:event_view_assetMouseClicked

    private void view_assetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_assetMouseEntered
        // TODO add your handling code here:
        view_asset.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.WHITE));
        view_asset.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_view_assetMouseEntered

    private void view_assetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_assetMouseExited
        // TODO add your handling code here:
        view_asset.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.white));
        view_asset.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_view_assetMouseExited

    private void ApMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ApMouseClicked
        // TODO add your handling code here:
        showTable1.clearSelection();
    }//GEN-LAST:event_ApMouseClicked

    private void search2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search2FocusGained
        // TODO add your handling code here:
        search2.setText("");
    }//GEN-LAST:event_search2FocusGained

    private void search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search2ActionPerformed

    private void search2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search2KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_search2KeyPressed

    private void search2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search2KeyReleased
        // TODO add your handling code here:
        String name = search2.getText();

        try {
            search(name);
            //        DefaultTableModel dtm = (DefaultTableModel) ATable3.getModel();
            //        int r = ATable3.getRowCount();
            //
            //        while(r-->0)
            //        {
                //            dtm.removeRow(r);
                //        }
            //
            //        try
            //        {
                //            con = DBConnection.getConnection();
                //            stmt = con.createStatement();
                //            pst = con.prepareStatement("Select AssetTag,Category,Brand,Model,UserLocation,UserID,HandlingUser,Account,ProvideDate,HandOverDate,Status,Availability,Comment,Windows,Office,Duration from asset1 where AssetTag like ?");
                //
                //            ResultSet rs = getData1(name);
                //
                //
                //            while(rs.next())
                //            {
                    //                java.util.Vector v = new java.util.Vector();
                    //                v.add(rs.getString("AssetTag"));
                    //                v.add(rs.getString("Category"));
                    //                v.add(rs.getString("Brand"));
                    //                v.add(rs.getString("Model"));
                    //                v.add(rs.getString("UserLocation"));
                    //                v.add(rs.getString("UserId"));
                    //                v.add(rs.getString("HandlingUser"));
                    //                v.add(rs.getString("Account"));
                    //                v.add(rs.getString("ProvideDate"));
                    //                v.add(rs.getString("HandOverDate"));
                    //                v.add(rs.getString("Status"));
                    //                v.add(rs.getString("Availability"));
                    //                v.add(rs.getString("Comment"));
                    //                v.add(rs.getString("Windows"));
                    //                v.add(rs.getString("Office"));
                    //                v.add(rs.getString("Duration"));
                    //                dtm.addRow(v);
                    //
                    //            }
                //        }
            //        catch (SQLException ex)
            //        {
                //            JOptionPane.showMessageDialog(null, "Database error");
                //            System.out.println(ex);
                //        }
        } catch (SQLException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_search2KeyReleased

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        try {
            // TODO add your handling code here:
            search(jComboBox4.getSelectedItem().toString());
            //        if(jCheckBox3.isSelected())
            //        {
                //        String name = (String) jComboBox1.getSelectedItem();
                //        DefaultTableModel dtm = (DefaultTableModel) ATable3.getModel();
                //        int r = ATable3.getRowCount();
                //
                //        while(r-->0)
                //        {
                    //            dtm.removeRow(r);
                    //        }
                //
                //        try
                //        {
                    //            con = DBConnection.getConnection();
                    //            stmt = con.createStatement();
                    //            pst = con.prepareStatement("Select AssetTag,Category,Brand,Model,UserLocation,UserID,HandlingUser,Account,ProvideDate,HandOverDate,Status,Availability,Comment,Windows,Office,Duration from asset1 where Status='working' ");
                    //
                    //            ResultSet rs = getData1(name);
                    //
                    //
                    //            while(rs.next())
                    //            {
                        //                java.util.Vector v = new java.util.Vector();
                        //                v.add(rs.getString("AssetTag"));
                        //                v.add(rs.getString("Category"));
                        //                v.add(rs.getString("Brand"));
                        //                v.add(rs.getString("Model"));
                        //                v.add(rs.getString("UserLocation"));
                        //                v.add(rs.getString("UserId"));
                        //                v.add(rs.getString("HandlingUser"));
                        //                v.add(rs.getString("Account"));
                        //                v.add(rs.getString("ProvideDate"));
                        //                v.add(rs.getString("HandOverDate"));
                        //                v.add(rs.getString("Status"));
                        //                v.add(rs.getString("Availability"));
                        //                v.add(rs.getString("Comment"));
                        //                v.add(rs.getString("Windows"));
                        //                v.add(rs.getString("Office"));
                        //                v.add(rs.getString("Duration"));
                        //                dtm.addRow(v);
                        //
                        //            }
                    //        }
                //        catch (SQLException ex)
                //        {
                    //            JOptionPane.showMessageDialog(null, "Database error");
                    //            System.out.println("JCombo11"+ex);
                    //        }}
            //        else{
                //         String name = (String) jComboBox1.getSelectedItem();
                //        DefaultTableModel dtm = (DefaultTableModel) ATable3.getModel();
                //        int r = ATable3.getRowCount();
                //
                //        while(r-->0)
                //        {
                    //            dtm.removeRow(r);
                    //        }
                //
                //        try
                //        {
                    //            con = DBConnection.getConnection();
                    //            stmt = con.createStatement();
                    //            pst = con.prepareStatement("Select AssetTag,Category,Brand,Model,UserLocation,UserID,HandlingUser,Account,ProvideDate,HandOverDate,Status,Availability,Comment,Windows,Office,Duration from asset1 where Status like ?");
                    //
                    //            ResultSet rs = getData1(name);
                    //
                    //
                    //            while(rs.next())
                    //            {
                        //                java.util.Vector v = new java.util.Vector();
                        //                v.add(rs.getString("AssetTag"));
                        //                v.add(rs.getString("Category"));
                        //                v.add(rs.getString("Brand"));
                        //                v.add(rs.getString("Model"));
                        //                v.add(rs.getString("UserLocation"));
                        //                v.add(rs.getString("UserId"));
                        //                v.add(rs.getString("HandlingUser"));
                        //                v.add(rs.getString("Account"));
                        //                v.add(rs.getString("ProvideDate"));
                        //                v.add(rs.getString("HandOverDate"));
                        //                v.add(rs.getString("Status"));
                        //                v.add(rs.getString("Availability"));
                        //                v.add(rs.getString("Comment"));
                        //                v.add(rs.getString("Windows"));
                        //                v.add(rs.getString("Office"));
                        //                v.add(rs.getString("Duration"));
                        //                dtm.addRow(v);
                        //
                        //            }
                    //        }
                //        catch (SQLException ex)
                //        {
                    //            JOptionPane.showMessageDialog(null, "Database error");
                    //            System.out.println("JCombo12"+ex);
                    //        }
                //        }
        } catch (SQLException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
        try{
            search(jComboBox5.getSelectedItem().toString());
        } catch (SQLException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
        //        if(jCheckBox3.isSelected())
        //        {
            //        String name = (String) jComboBox2.getSelectedItem();
            //        DefaultTableModel dtm = (DefaultTableModel) ATable3.getModel();
            //        int r = ATable3.getRowCount();
            //
            //        while(r-->0)
            //        {
                //            dtm.removeRow(r);
                //        }
            //
            //        try
            //        {
                //            con = DBConnection.getConnection();
                //            stmt = con.createStatement();
                //            pst = con.prepareStatement("Select AssetTag,Category,Brand,Model,UserLocation,UserID,HandlingUser,Account,ProvideDate,HandOverDate,Status,Availability,Comment,Windows,Office,Duration from asset1 where Status='working' AND Availability like ?");
                //
                //            ResultSet rs = getData1(name);
                //
                //
                //            while(rs.next())
                //            {
                    //                java.util.Vector v = new java.util.Vector();
                    //                v.add(rs.getString("AssetTag"));
                    //                v.add(rs.getString("Category"));
                    //                v.add(rs.getString("Brand"));
                    //                v.add(rs.getString("Model"));
                    //                v.add(rs.getString("UserLocation"));
                    //                v.add(rs.getString("UserId"));
                    //                v.add(rs.getString("HandlingUser"));
                    //                v.add(rs.getString("Account"));
                    //                v.add(rs.getString("ProvideDate"));
                    //                v.add(rs.getString("HandOverDate"));
                    //                v.add(rs.getString("Status"));
                    //                v.add(rs.getString("Availability"));
                    //                v.add(rs.getString("Comment"));
                    //                v.add(rs.getString("Windows"));
                    //                v.add(rs.getString("Office"));
                    //                v.add(rs.getString("Duration"));
                    //                dtm.addRow(v);
                    //
                    //            }
                //        }
            //        catch (SQLException ex)
            //        {
                //            JOptionPane.showMessageDialog(null, "Database error");
                //            System.out.println("JCombo21"+ex);
                //        }}
        //        else{
            //         String name = (String) jComboBox2.getSelectedItem();
            //        DefaultTableModel dtm = (DefaultTableModel) ATable3.getModel();
            //        int r = ATable3.getRowCount();
            //
            //        while(r-->0)
            //        {
                //            dtm.removeRow(r);
                //        }
            //
            //        try
            //        {
                //            con = DBConnection.getConnection();
                //            stmt = con.createStatement();
                //            pst = con.prepareStatement("Select AssetTag,Category,Brand,Model,UserLocation,UserID,HandlingUser,Account,ProvideDate,HandOverDate,Status,Availability,Comment,Windows,Office,Duration from asset1 where Availability like ?");
                //
                //            ResultSet rs = getData1(name);
                //
                //
                //            while(rs.next())
                //            {
                    //                java.util.Vector v = new java.util.Vector();
                    //                v.add(rs.getString("AssetTag"));
                    //                v.add(rs.getString("Category"));
                    //                v.add(rs.getString("Brand"));
                    //                v.add(rs.getString("Model"));
                    //                v.add(rs.getString("UserLocation"));
                    //                v.add(rs.getString("UserId"));
                    //                v.add(rs.getString("HandlingUser"));
                    //                v.add(rs.getString("Account"));
                    //                v.add(rs.getString("ProvideDate"));
                    //                v.add(rs.getString("HandOverDate"));
                    //                v.add(rs.getString("Status"));
                    //                v.add(rs.getString("Availability"));
                    //                v.add(rs.getString("Comment"));
                    //                v.add(rs.getString("Windows"));
                    //                v.add(rs.getString("Office"));
                    //                v.add(rs.getString("Duration"));
                    //                dtm.addRow(v);
                    //
                    //            }
                //        }
            //        catch (SQLException ex)
            //        {
                //            JOptionPane.showMessageDialog(null, "Database error");
                //            System.out.println("JCombo22"+ex);
                //        }
            //        }
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        // TODO add your handling code here:
        try{
            search(jComboBox6.getSelectedItem().toString());
        } catch (SQLException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
        //        if(jCheckBox3.isSelected())
        //        {
            //        String name = (String) jComboBox3.getSelectedItem();
            //        DefaultTableModel dtm = (DefaultTableModel) ATable3.getModel();
            //        int r = ATable3.getRowCount();
            //
            //        while(r-->0)
            //        {
                //            dtm.removeRow(r);
                //        }
            //
            //        try
            //        {
                //            con = DBConnection.getConnection();
                //            stmt = con.createStatement();
                //            pst = con.prepareStatement("Select AssetTag,Category,Brand,Model,UserLocation,UserID,HandlingUser,Account,ProvideDate,HandOverDate,Status,Availability,Comment,Windows,Office,Duration from asset1 where Status='working' AND Category like ?");
                //
                //            ResultSet rs = getData1(name);
                //
                //
                //            while(rs.next())
                //            {
                    //                java.util.Vector v = new java.util.Vector();
                    //                v.add(rs.getString("AssetTag"));
                    //                v.add(rs.getString("Category"));
                    //                v.add(rs.getString("Brand"));
                    //                v.add(rs.getString("Model"));
                    //                v.add(rs.getString("UserLocation"));
                    //                v.add(rs.getString("UserId"));
                    //                v.add(rs.getString("HandlingUser"));
                    //                v.add(rs.getString("Account"));
                    //                v.add(rs.getString("ProvideDate"));
                    //                v.add(rs.getString("HandOverDate"));
                    //                v.add(rs.getString("Status"));
                    //                v.add(rs.getString("Availability"));
                    //                v.add(rs.getString("Comment"));
                    //                v.add(rs.getString("Windows"));
                    //                v.add(rs.getString("Office"));
                    //                v.add(rs.getString("Duration"));
                    //                dtm.addRow(v);
                    //
                    //            }
                //        }
            //        catch (SQLException ex)
            //        {
                //            JOptionPane.showMessageDialog(null, "Database error");
                //            System.out.println("JCombo31"+ex);
                //        }}
        //        else{
            //         String name = (String) jComboBox3.getSelectedItem();
            //        DefaultTableModel dtm = (DefaultTableModel) ATable3.getModel();
            //        int r = ATable3.getRowCount();
            //
            //        while(r-->0)
            //        {
                //            dtm.removeRow(r);
                //        }
            //
            //        try
            //        {
                //            con = DBConnection.getConnection();
                //            stmt = con.createStatement();
                //            pst = con.prepareStatement("Select AssetTag,Category,Brand,Model,UserLocation,UserID,HandlingUser,Account,ProvideDate,HandOverDate,Status,Availability,Comment,Windows,Office,Duration from asset1 where Category like ?");
                //
                //            ResultSet rs = getData1(name);
                //
                //
                //            while(rs.next())
                //            {
                    //                java.util.Vector v = new java.util.Vector();
                    //                v.add(rs.getString("AssetTag"));
                    //                v.add(rs.getString("Category"));
                    //                v.add(rs.getString("Brand"));
                    //                v.add(rs.getString("Model"));
                    //                v.add(rs.getString("UserLocation"));
                    //                v.add(rs.getString("UserId"));
                    //                v.add(rs.getString("HandlingUser"));
                    //                v.add(rs.getString("Account"));
                    //                v.add(rs.getString("ProvideDate"));
                    //                v.add(rs.getString("HandOverDate"));
                    //                v.add(rs.getString("Status"));
                    //                v.add(rs.getString("Availability"));
                    //                v.add(rs.getString("Comment"));
                    //                v.add(rs.getString("Windows"));
                    //                v.add(rs.getString("Office"));
                    //                v.add(rs.getString("Duration"));
                    //                dtm.addRow(v);
                    //
                    //            }
                //        }
            //        catch (SQLException ex)
            //        {
                //            JOptionPane.showMessageDialog(null, "Database error");
                //            System.out.println("JCombo32"+ex);
                //        }
            //        }
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void search4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search4FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_search4FocusGained

    private void search4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search4ActionPerformed

    private void search4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search4KeyPressed

    private void search4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search4KeyReleased
        // TODO add your handling code here:

        String name = search4.getText();
        try {
            search(name);
            //        DefaultTableModel dtm = (DefaultTableModel) ATable3.getModel();
            //        int r = ATable3.getRowCount();
            //
            //        while(r-->0)
            //        {
                //            dtm.removeRow(r);
                //        }
            //
            //        try
            //        {
                //            con = DBConnection.getConnection();
                //            stmt = con.createStatement();
                //            pst = con.prepareStatement("Select AssetTag,Category,Brand,Model,UserLocation,UserID,HandlingUser,Account,ProvideDate,HandOverDate,Status,Availability,Comment,Windows,Office,Duration from asset1 where UserID like ?");
                //
                //            ResultSet rs = getData1(name);
                //
                //
                //            while(rs.next())
                //            {
                    //                java.util.Vector v = new java.util.Vector();
                    //                v.add(rs.getString("AssetTag"));
                    //                v.add(rs.getString("Category"));
                    //                v.add(rs.getString("Brand"));
                    //                v.add(rs.getString("Model"));
                    //                v.add(rs.getString("UserLocation"));
                    //                v.add(rs.getString("UserId"));
                    //                v.add(rs.getString("HandlingUser"));
                    //                v.add(rs.getString("Account"));
                    //                v.add(rs.getString("ProvideDate"));
                    //                v.add(rs.getString("HandOverDate"));
                    //                v.add(rs.getString("Status"));
                    //                v.add(rs.getString("Availability"));
                    //                v.add(rs.getString("Comment"));
                    //                v.add(rs.getString("Windows"));
                    //                v.add(rs.getString("Office"));
                    //                v.add(rs.getString("Duration"));
                    //                dtm.addRow(v);
                    //
                    //            }
                //        }
            //        catch (SQLException ex)
            //        {
                //            JOptionPane.showMessageDialog(null, "Database error");
                //            System.out.println(ex);
                //        }
        } catch (SQLException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_search4KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        update3();
        search2.setText("");
        search4.setText("");
        jComboBox4.setSelectedIndex(0);
        jComboBox5.setSelectedIndex(0);
        jComboBox6.setSelectedIndex(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        FileOutputStream excelFOS = null;
        BufferedOutputStream excelBOS = null;
        XSSFWorkbook wb = null;

        XSSFCell excelCell = null;

        JFileChooser excelFileChooser = new JFileChooser();
        excelFileChooser.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("Excel Files", "xls", "xlsx", "ods");
        excelFileChooser.setFileFilter(fnef);
        SimpleDateFormat formatter = new SimpleDateFormat("HH-mm-ss");  
        Date date = new Date();  
        excelFileChooser.setSelectedFile(new File("Detailed_Report_PDF"+java.time.LocalDate.now().toString().trim()+"_"+formatter.format(date).toString().trim()));
        int excelChooser = excelFileChooser.showSaveDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            try {
                wb = new XSSFWorkbook();
                XSSFSheet sheet = wb.createSheet("Data Sheet");
                XSSFRow excelRow = sheet.createRow(0);

                for (int c = 0; c < ATable3.getColumnCount(); c++) {
                    excelCell = excelRow.createCell(c);
                    excelCell.setCellValue(ATable3.getColumnName(c));
                }

                System.out.println("Display.LOGIN2ActionPerformed()");

                for (int i = 0; i < ATable3.getRowCount(); i++) {
                    System.out.println(i);
                    excelRow = sheet.createRow(i + 1);

                    for (int j = 0; j < ATable3.getColumnCount(); j++) {
                        if (ATable3.getValueAt(i, j) == "null") {
                            ATable3.setValueAt(" ", i, j);
                        } else {
                            excelCell = excelRow.createCell(j);
                            Object o = ATable3.getValueAt(i, j);
                            excelCell.setCellValue(o == null ? "" : o.toString());
                        }

                    }
                }

                excelFOS = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                excelBOS = new BufferedOutputStream(excelFOS);
                wb.write(excelBOS);
                JOptionPane.showMessageDialog(null, "Exported to Excel");

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (excelBOS != null) {
                        excelBOS.close();
                    }
                    if (excelFOS != null) {
                        excelFOS.close();
                    }
                    if (wb != null) {
                        wb.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } //---- end finally
        } //---- end if condition
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         DefaultTableModel mod = (DefaultTableModel) ATable3.getModel();
        FileOutputStream fo=null;
        String path = "";
        String nm = "";
        JFileChooser j = new JFileChooser();
        SimpleDateFormat formatter = new SimpleDateFormat("HH-mm-ss");  
        Date date = new Date();  
        j.setSelectedFile(new File("Detailed_Report_PDF"+java.time.LocalDate.now().toString().trim()+"_"+formatter.format(date).toString().trim()));

        int y = ATable3.getColumnCount();
        j.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
        int x = j.showSaveDialog(null);
        if(x==JFileChooser.APPROVE_OPTION)
        {
            Document doc = new Document(PageSize.A3.rotate(), 50,50,50,50);
            //String nm = JOptionPane.showInputDialog(null, "Enter PDF name");
            try {
                //String nm = j.getSelectedFile().toString();
                //fo = new FileOutputStream(JFileChooser.getSelectedFile() + ".xlsx");
                PdfWriter.getInstance(doc,new FileOutputStream(j.getSelectedFile()+".pdf"));
                doc.open();
                //Rectangle one = new Rectangle(60,60);
                float cwidth[] = {11f,7f,7f,6f,8f,6f,8f,7f,10f,10f,7f,7f,8f,8f,8f,6f};
                PdfPTable tb = new PdfPTable(16);
                tb.setWidths(cwidth);

                //tb.setPadding(3);
                tb.setWidthPercentage(100);
                //tb.setWidthPercentage(cwidth,one);
                tb.setSpacingBefore(40f);
                tb.setSpacingAfter(40f);
                //            tb.setHeaderRows(20);
                //            tb.setSplitRows(true);
                tb.addCell("Asset Tag");
                tb.addCell("Category");
                tb.addCell("Brand");
                tb.addCell("Model");
                tb.addCell("User Location");
                tb.addCell("User ID");
                tb.addCell("Handling User");
                tb.addCell("Account");
                tb.addCell("Provide Date");
                tb.addCell("HandOver Date");
                tb.addCell("Status");
                tb.addCell("Availability");
                tb.addCell("Comment");
                tb.addCell("OS");
                tb.addCell("MS Office");
                tb.addCell("Duration");
                for(int i=0;i<ATable3.getRowCount();i++)
                {
                    String a=(String) ATable3.getValueAt(i, 0);
                    String b=(String) ATable3.getValueAt(i, 1);
                    String c=(String) ATable3.getValueAt(i, 2);
                    String d=(String) ATable3.getValueAt(i, 3);
                    String e=(String) ATable3.getValueAt(i, 4);
                    String f=(String) ATable3.getValueAt(i, 5);
                    String g=(String) ATable3.getValueAt(i, 6);
                    String h=(String) ATable3.getValueAt(i, 7);
                    String q=(String) ATable3.getValueAt(i, 8);
                    String s=(String) ATable3.getValueAt(i, 9);
                    String k=(String) ATable3.getValueAt(i, 10);
                    String l=(String) ATable3.getValueAt(i, 11);
                    String m=(String) ATable3.getValueAt(i, 12);
                    String n=(String) ATable3.getValueAt(i, 13);
                    String o=(String) ATable3.getValueAt(i, 14);
                    String p=(String) ATable3.getValueAt(i, 15);

                    tb.addCell(a);
                    tb.addCell(b);
                    tb.addCell(c);
                    tb.addCell(d);
                    tb.addCell(e);
                    tb.addCell(f);
                    tb.addCell(g);
                    tb.addCell(h);
                    tb.addCell(q);
                    tb.addCell(s);
                    tb.addCell(k);
                    tb.addCell(l);
                    tb.addCell(m);
                    tb.addCell(n);
                    tb.addCell(o);
                    tb.addCell(p);
                }
                doc.add(tb);
                JOptionPane.showMessageDialog(null, "Exported to PDF");
            } catch (Exception e) {
                System.out.println(e);
            }
            doc.close();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    public void search(String searchtext) throws SQLException
    {
        try {
            Database db = loading.db;
            con1 = db.connection;
        String atag = search2.getText().toUpperCase();
        String uid = search4.getText().toUpperCase();
        String status = jComboBox4.getSelectedItem().toString().toLowerCase();
        String availability1 = jComboBox5.getSelectedItem().toString().toLowerCase();
        String cat1 = jComboBox6.getSelectedItem().toString().toLowerCase();
        
        con1 = db.connection;
        stmt1 = con1.createStatement();
        
        if( "--select status--".equals(status) && "--select availability status--".equals(availability1) && "--select category--".equals(cat1))
        {
             pst1 = con1.prepareStatement("Select asset_tag,category,brand,model,eid,handling_user,user_location,account,provide_date,handover_date,status,comment,os,ms_office,duration,availability,software from asset where (asset_tag like ? AND eid like ?)");
             pst1.setString(1, "%"+atag+"%");
             pst1.setString(2, "%"+uid+"%");
             
        }
        if("--select status--".equals(status) && "--select availability status--".equals(availability1) && !"--select category--".equals(cat1))
        {
            pst1 = con1.prepareStatement("Select asset_tag,category,brand,model,eid,handling_user,user_location,account,provide_date,handover_date,status,comment,os,ms_office,duration,availability,software from asset where (category like ?) AND  (asset_tag like ? AND eid like ?)");
             pst1.setString(1, cat1);
            pst1.setString(2, "%"+atag+"%");
             pst1.setString(3, "%"+uid+"%");
        }
        if("--select status--".equals(status) && !"--select availability status--".equals(availability1) && "--select category--".equals(cat1))
        {
            pst1 = con1.prepareStatement("Select asset_tag,category,brand,model,eid,handling_user,user_location,account,provide_date,handover_date,status,comment,os,ms_office,duration,availability,software from asset where (availability like ?) AND (asset_tag like ? AND eid like ?)");
            pst1.setString(1, availability1);
            pst1.setString(2, "%"+atag+"%");
             pst1.setString(3,"%"+uid+"%");
             System.out.println(availability1);
        }
        if("--select status--".equals(status) && !"--select availability status--".equals(availability1) && !"--select category--".equals(cat1))
        {
            pst1 = con1.prepareStatement("Select asset_tag,category,brand,model,eid,handling_user,user_location,account,provide_date,handover_date,status,comment,os,ms_office,duration,availability,software from asset  where (asset_tag like ? AND eid like ?)and (availability like ? AND category like ?)");
            pst1.setString(1,"%"+atag+"%");
             pst1.setString(2,"%"+uid+"%");
             pst1.setString(3, availability1);
             pst1.setString(4, cat1.toLowerCase());
        }
        if( !"--select status--".equals(status) && "--select availability status--".equals(availability1) && "--select category--".equals(cat1))
        {
            pst1 = con1.prepareStatement("Select asset_tag,category,brand,model,eid,handling_user,user_location,account,provide_date,handover_date,status,comment,os,ms_office,duration,availability,software from asset where  (asset_tag like ? AND eid like ?) and (status like ?)");
            pst1.setString(1, "%"+atag+"%");
             pst1.setString(2, "%"+uid+"%");
             pst1.setString(3, status.toLowerCase());
        }
        if( !"--select status--".equals(status) && "--select availability status--".equals(availability1) && !"--select category--".equals(cat1))
        {
            pst1 = con1.prepareStatement("Select asset_tag,category,brand,model,eid,handling_user,user_location,account,provide_date,handover_date,status,comment,os,ms_office,duration,availability,software from asset where (asset_tag like ? AND eid like ?) and status like ? and category like ?");
            pst1.setString(1, "%"+atag+"%");
             pst1.setString(2, "%"+uid+"%");
              pst1.setString(3,status.toLowerCase());
             pst1.setString(4, cat1.toLowerCase());
        }
        if(!"--select status--".equals(status) && !"--select availability status--".equals(availability1) && "--select category--".equals(cat1))
        {
            pst1 = con1.prepareStatement("Select asset_tag,category,brand,model,eid,handling_user,user_location,account,provide_date,handover_date,status,comment,os,ms_office,duration,availability,software from asset where (asset_tag like ? AND eid like ?) and status like ? and availability like ?");
            pst1.setString(1, "%"+atag+"%");
             pst1.setString(2, "%"+uid+"%");
             pst1.setString(3, status.toLowerCase());
             pst1.setString(4, availability1.toLowerCase());
        }
        if(!"--select status--".equals(status) && !"--select availability status--".equals(availability1) && !"--select category--".equals(cat1))
        {
             pst1 = con1.prepareStatement("Select asset_tag,category,brand,model,eid,handling_user,user_location,account,provide_date,handover_date,status,comment,os,ms_office,duration,availability,software from asset where (asset_tag like ? AND eid like ?) and status like ? and availability like ? and category like ? ");
             pst1.setString(1, "%"+atag+"%");
             pst1.setString(2, "%"+uid+"%");
             pst1.setString(3, status.toLowerCase());
             pst1.setString(4, availability1.toLowerCase());
             pst1.setString(5, cat1.toLowerCase());
        }
       
            
            ResultSet rs = pst1.executeQuery();
              DefaultTableModel model = new DefaultTableModel();
            ATable3.setModel(model);
            model.addColumn("Asset Tag");
            model.addColumn("Category");
            model.addColumn("Brand");
            model.addColumn("Model");
            model.addColumn("User ID");
            model.addColumn("Handling User");
            model.addColumn("User Location");          
            model.addColumn("Account");
            model.addColumn("Provide Date");
            model.addColumn("HandOver Date");
            model.addColumn("Status");
            model.addColumn("Comment");
            model.addColumn("OS");
            model.addColumn("Office");
            model.addColumn("Duration");
            model.addColumn("Availability");
            model.addColumn("Software");
            //model.addColumn("");
            table_align();
            tablealign2();
            while (rs.next()) {
                model.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16),rs.getString(17)});
            }
            
        
    }
    catch (Exception e) {
            System.out.println(e);
        }
}
    public static JPanel A;
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
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable(){
           public void run(){
               Display d1 = new Display();
               d1.setVisible(true);
               f1 = d1;
           }
       });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ATable3;
    public static javax.swing.JPanel Ap;
    private javax.swing.JPanel Apanel;
    private javax.swing.JPanel Asset;
    private javax.swing.JPanel Up;
    public static javax.swing.JPanel Vp;
    private javax.swing.JTextField asearch;
    private javax.swing.JTextField asearch1;
    private javax.swing.JButton assign;
    private javax.swing.JLabel avail;
    private javax.swing.JLabel avail1;
    private javax.swing.JComboBox<String> availability;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JComboBox<String> category2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logimg;
    private javax.swing.JLabel logimg1;
    private javax.swing.JPanel loginpanel;
    private javax.swing.JLabel logtext;
    private javax.swing.JTextField search2;
    private javax.swing.JTextField search4;
    private javax.swing.JTable showTable;
    private javax.swing.JTable showTable1;
    private javax.swing.JPanel view_asset;
    // End of variables declaration//GEN-END:variables
}
