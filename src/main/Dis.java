package main;

import Database.Database;
import static asset_module.assign_display.Display.stmt;
import static java.lang.Integer.parseInt;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;


import com.itextpdf.text.BaseColor;
import java.awt.Color;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.BorderFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.Rectangle;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;
import static notification.NotifyTable.jnum;
import static org.apache.poi.hssf.usermodel.HeaderFooter.file;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import asset_module.assign_update.update2;
import invent.update.update_invent;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
/**
 *
 * @author vedasrinivas
 */

public class Dis extends javax.swing.JFrame {
Database db = loading.db;

    /**
     * Creates new form Display
     */

public static String clone_category = "";
    public static String clone_asset_tag = "";
    public static String clone_brand = "";
    public static String clone_model = "";
    public static String clone_os = "";
    public static String clone_ms = "";
    public static String clone_vendor = "";
    public static String clone_inum = "";
    public static String clone_serial = "";
    public static String clone_imei = "";
    Connection con1 = db.connection;
     public static PreparedStatement pst1;
      public static PreparedStatement pst2;
    public static Statement stmt1;
    public static Statement st;
    public static PreparedStatement pst;
    ResultSet rs1 = null;
    byte[] invoice_image=null;
    public static int clone_check = 0;
    public static String FILEPATH = "TPF";
    File file = new File(FILEPATH);
    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
    private Object rs;
    String asset_tag0;
     String category0;
        String brand0;
        String model0;
        String os0;
        String ms_office0;
        String vendor0;
        String invoice_image0;
        String purchase_date0;
        String warranty_date0;
        String serial0;
        String imei0;
        int price0;

    public Dis() {
        initComponents();
        Ap.setVisible(false);
        Dp.setVisible(false);
        Sp1.setVisible(false);
        Vp.setVisible(true);
    
       update2();
       update3();
       softintv();
        
  
        setExtendedState(Dis.MAXIMIZED_BOTH);
   
        
        DefaultTableModel dtm3 = (DefaultTableModel) showTable.getModel();
        int r3 = showTable.getRowCount();
        avail.setText(""+r3+"");
    }   
 
      
    public  void update(String category,String asset_tag, String brand, String model, String os, String msoffice, String vendor,String invoice_number,Date purchase_date,Date warranty_date,String serial_number,String imei_number,String price)
    {
       invent.update.update.n = category;
        invent.update.update.n1 = asset_tag;
        invent.update.update.n2 = brand;
        invent.update.update.n3 = model;
        invent.update.update.n4 = os;
        invent.update.update.n5 = msoffice;
        invent.update.update.n6 = vendor;
        invent.update.update.n7 = invoice_number;
        invent.update.update.n8 = purchase_date;
        invent.update.update.n9 = warranty_date;
        invent.update.update.n10 = serial_number;
        invent.update.update.n11 = imei_number;
        invent.update.update.n12 = price;
    }
    
    public void softintv()
    {
        DefaultTableCellRenderer centerRender11 = new DefaultTableCellRenderer();
        centerRender11.setHorizontalAlignment(JLabel.CENTER);
        STable.setFont(new Font("Segoe UI",Font.PLAIN,11));
        int r21 = STable.getRowCount();
        for(int i = 0; i<=7; i++)
        {
            STable.getColumnModel().getColumn(i).setCellRenderer(centerRender11);
        
        }       
        JTableHeader thead11 = STable.getTableHeader();        
        thead11.setForeground(Color.BLACK);
        thead11.setFont(new Font("Segoe UI",Font.BOLD,12));            
        ((DefaultTableCellRenderer)thead11.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
        
        TableColumn col2 = STable.getColumnModel().getColumn(0);
        col2.setPreferredWidth(180);
        col2 = STable.getColumnModel().getColumn(1);
        col2.setPreferredWidth(120);
        col2 = STable.getColumnModel().getColumn(2);
        col2.setPreferredWidth(150);
        col2 = STable.getColumnModel().getColumn(3);
        col2.setPreferredWidth(150);
        col2 = STable.getColumnModel().getColumn(4);
        col2.setPreferredWidth(120);
        col2 = STable.getColumnModel().getColumn(5);
        col2.setPreferredWidth(120);
        col2 = STable.getColumnModel().getColumn(6);
        col2.setPreferredWidth(120);
        col2 = STable.getColumnModel().getColumn(7);
        col2.setPreferredWidth(150);
    }
    
     public void update2()
    {
       try
        {
         pst = con1.prepareStatement("SELECT product_name,quantity,vendor_name,invoice_number,purchase_date,expiry_date,serial_number,price FROM soft_inventory");
            stmt1 = con1.createStatement();
             ResultSet rs = pst.executeQuery(); 
            DefaultTableModel model=(DefaultTableModel) STable.getModel();
            model.setRowCount(0);
         
            DefaultTableModel Model = new DefaultTableModel();
            STable.setModel(Model);
            Model.addColumn("Software Name");
            Model.addColumn("Quantity");
            Model.addColumn("Vendor Name");
            Model.addColumn("Invoice Number");
            Model.addColumn("Purchase Date");
            Model.addColumn("Expiry Date");
            Model.addColumn("Serial_Number");
            Model.addColumn("Price");
            
            while (rs.next()) 
            {
                Model.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4) , rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)});
            
        }
        }
        catch(Exception e)
        {
            System.err.println(e);
            
        }
        
        DefaultTableModel dtm3 = (DefaultTableModel) STable.getModel();
        int r3 = STable.getRowCount();
        avail1.setText(""+r3+"");
    }
     
      public void update3()
    {
     DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
        centerRender.setHorizontalAlignment(JLabel.CENTER);       
        showTable.setFont(new Font("Segoe UI",Font.PLAIN,11));
        for(int i = 0; i<=12; i++)
        {
            showTable.getColumnModel().getColumn(i).setCellRenderer(centerRender);
        }
        JTableHeader thead = showTable.getTableHeader();
        thead.setForeground(Color.BLACK);
        thead.setFont(new Font("Segoe UI",Font.BOLD,12));
        ((DefaultTableCellRenderer)thead.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);       
        //showTable.setAutoResizeMode(showTable.AUTO_RESIZE_OFF);
        TableColumn col = showTable.getColumnModel().getColumn(0);
        col.setPreferredWidth(100);
        col = showTable.getColumnModel().getColumn(1);
        col.setPreferredWidth(80);
        col = showTable.getColumnModel().getColumn(2);
        col.setPreferredWidth(80);
        col = showTable.getColumnModel().getColumn(3);
        col.setPreferredWidth(100);
        col = showTable.getColumnModel().getColumn(4);
        col.setPreferredWidth(100);
        col = showTable.getColumnModel().getColumn(5);
        col.setPreferredWidth(100);
        col = showTable.getColumnModel().getColumn(6);
        col.setPreferredWidth(100);
        col = showTable.getColumnModel().getColumn(7);
        col.setPreferredWidth(150);
        col = showTable.getColumnModel().getColumn(8);
        col.setPreferredWidth(150);
        col = showTable.getColumnModel().getColumn(9);
        col.setPreferredWidth(150);
        col = showTable.getColumnModel().getColumn(10);
        col.setPreferredWidth(100);
        col = showTable.getColumnModel().getColumn(11);
        col.setPreferredWidth(120);
        col = showTable.getColumnModel().getColumn(12);
        col.setPreferredWidth(120);
 
        try
        {
         pst = con1.prepareStatement("SELECT category,asset_tag,brand,model,os,ms_office,vendor,invoice_number,purchase_date,warranty_date,serial_number,imei_number,price FROM inventory");
            stmt1 = con1.createStatement();
             ResultSet rs = pst.executeQuery(); 
            DefaultTableModel model=(DefaultTableModel) showTable.getModel();
            model.setRowCount(0);
         
            DefaultTableModel Model = new DefaultTableModel();
            showTable.setModel(Model);
            Model.addColumn("Product");
            Model.addColumn("Asset Tag");
            Model.addColumn("Brand");
            Model.addColumn("Model");
            Model.addColumn("OS");
            Model.addColumn("MS Office");
            Model.addColumn("Vendor");
            Model.addColumn("Invoice Number");
            Model.addColumn("Purchase Date");
            Model.addColumn("Warranty Date");
            Model.addColumn("Serail Number");
            Model.addColumn("IMEI Number");
            Model.addColumn("Price");
            
            while (rs.next()) 
            {
                Model.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4) , rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12) , rs.getString(13)});
            
        }
        }
        catch(Exception e)
        {
            System.err.println(e);
            
        }
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
        jLabel26 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        loginpanel = new javax.swing.JPanel();
        logtext = new javax.swing.JLabel();
        logimg = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Apanel = new javax.swing.JPanel();
        add = new javax.swing.JLabel();
        Asset = new javax.swing.JPanel();
        update = new javax.swing.JLabel();
        User1 = new javax.swing.JPanel();
        display1 = new javax.swing.JLabel();
        User2 = new javax.swing.JPanel();
        display2 = new javax.swing.JLabel();
        logimg2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        Vp = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        add_asset = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        purchase_date = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        warranty_date = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        serial_number = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        imei_number = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        choose = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        filepath = new javax.swing.JTextField();
        asset_tag = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        vendor = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        invoice_number = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        category = new javax.swing.JComboBox<>();
        jLabel107 = new javax.swing.JLabel();
        model = new javax.swing.JTextField();
        brand = new javax.swing.JComboBox<>();
        jLabel108 = new javax.swing.JLabel();
        msoffice = new javax.swing.JComboBox<>();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        os = new javax.swing.JComboBox<>();
        add_asset4 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        add_asset5 = new javax.swing.JButton();
        add_asset6 = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        Ap = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        showTable = new javax.swing.JTable();
        asearch = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        avail = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        deleteasset_btn = new javax.swing.JButton();
        excel = new javax.swing.JButton();
        pdf = new javax.swing.JButton();
        year = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        expend = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        expend1 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        category1 = new javax.swing.JComboBox<>();
        update_asset = new javax.swing.JButton();
        Dp = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        add_asset1 = new javax.swing.JButton();
        Sfilepath = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        Spurchase_date = new com.toedter.calendar.JDateChooser();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        expiry_date = new com.toedter.calendar.JDateChooser();
        Sprice = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        choose1 = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        Scategory = new javax.swing.JComboBox<>();
        jLabel73 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        Svendor = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        Sinvoice_number = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        Sserial_number = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        Sp1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        STable = new javax.swing.JTable();
        p_search = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        avail1 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        deleteasset_btn1 = new javax.swing.JButton();
        excel1 = new javax.swing.JButton();
        pdf1 = new javax.swing.JButton();
        jLabel76 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 161, 225));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Inventory Management");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loginpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(loginpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(0, 161, 225));

        Apanel.setBackground(new java.awt.Color(0, 161, 225));
        Apanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 255, 255)));
        Apanel.setPreferredSize(new java.awt.Dimension(234, 46));
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

        add.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Add Inventory");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addMouseExited(evt);
            }
        });

        javax.swing.GroupLayout ApanelLayout = new javax.swing.GroupLayout(Apanel);
        Apanel.setLayout(ApanelLayout);
        ApanelLayout.setHorizontalGroup(
            ApanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ApanelLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(add)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ApanelLayout.setVerticalGroup(
            ApanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(add, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        Asset.setBackground(new java.awt.Color(0, 161, 225));
        Asset.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 255, 255)));
        Asset.setPreferredSize(new java.awt.Dimension(234, 46));
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

        update.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Display Inventory");
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateMouseExited(evt);
            }
        });

        javax.swing.GroupLayout AssetLayout = new javax.swing.GroupLayout(Asset);
        Asset.setLayout(AssetLayout);
        AssetLayout.setHorizontalGroup(
            AssetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AssetLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(update)
                .addGap(61, 61, 61))
        );
        AssetLayout.setVerticalGroup(
            AssetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(update, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        User1.setBackground(new java.awt.Color(0, 161, 225));
        User1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 255, 255)));
        User1.setPreferredSize(new java.awt.Dimension(234, 46));
        User1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                User1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                User1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                User1MouseExited(evt);
            }
        });

        display1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        display1.setForeground(new java.awt.Color(255, 255, 255));
        display1.setText("Add Software");
        display1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                display1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                display1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                display1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout User1Layout = new javax.swing.GroupLayout(User1);
        User1.setLayout(User1Layout);
        User1Layout.setHorizontalGroup(
            User1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(User1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(display1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        User1Layout.setVerticalGroup(
            User1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(display1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        User2.setBackground(new java.awt.Color(0, 161, 225));
        User2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 255, 255)));
        User2.setPreferredSize(new java.awt.Dimension(234, 46));
        User2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                User2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                User2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                User2MouseExited(evt);
            }
        });

        display2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        display2.setForeground(new java.awt.Color(255, 255, 255));
        display2.setText("Display Software");
        display2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                display2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                display2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                display2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout User2Layout = new javax.swing.GroupLayout(User2);
        User2.setLayout(User2Layout);
        User2Layout.setHorizontalGroup(
            User2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, User2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(display2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        User2Layout.setVerticalGroup(
            User2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(display2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        logimg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tpftool/images/Images/back_white1.png"))); // NOI18N
        logimg2.setText("jLabel23");
        logimg2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logimg2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logimg2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logimg2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Apanel, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
            .addComponent(Asset, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
            .addComponent(User1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
            .addComponent(User2, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(logimg2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logimg2)
                .addGap(22, 22, 22)
                .addComponent(Apanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(Asset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(User1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(User2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(797, Short.MAX_VALUE))
        );

        Vp.setBackground(new java.awt.Color(255, 255, 255));
        Vp.setPreferredSize(new java.awt.Dimension(978, 637));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel37.setText("Add Inventory");

        jPanel10.setBackground(new java.awt.Color(0, 161, 225));
        jPanel10.setForeground(new java.awt.Color(100, 0, 100));
        jPanel10.setPreferredSize(new java.awt.Dimension(184, 3));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 168, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        add_asset.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add_asset.setText("Add Asset");
        add_asset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_assetMouseClicked(evt);
            }
        });
        add_asset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_assetActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setText("Purchase date");

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel32.setText(":");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText("Warranty date");

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel33.setText(":");

        warranty_date.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                warranty_dateFocusLost(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setText("Serial Number");

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel34.setText(":");

        serial_number.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        serial_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serial_numberActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel20.setText("IMEI Number");

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel35.setText(":");

        imei_number.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        imei_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imei_numberActionPerformed(evt);
            }
        });
        imei_number.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                imei_numberKeyTyped(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel21.setText("Price");

        jLabel41.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel41.setText(":");

        price.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });
        price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                priceKeyTyped(evt);
            }
        });

        choose.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        choose.setText("Choose File");
        choose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel40.setText(":");

        filepath.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        filepath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filepathActionPerformed(evt);
            }
        });

        asset_tag.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        asset_tag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asset_tagActionPerformed(evt);
            }
        });
        asset_tag.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                asset_tagKeyReleased(evt);
            }
        });

        jLabel98.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel98.setText("MS Office");

        vendor.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel99.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel99.setText("Vendor");

        invoice_number.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel100.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel100.setText("Invoice Number");

        jLabel101.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel101.setText("Category");

        jLabel102.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel102.setText(":");

        jLabel103.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel103.setText("Asset Tag");

        jLabel104.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel104.setText(":");

        jLabel105.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel105.setText(":");

        jLabel106.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel106.setText("Brand");

        category.setEditable(true);
        category.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category", "Laptop", "Mouse", "Monitor", "Keyboard", "Hard Disk", "Laptop Battery", "Laptop Keypad", "Others" }));

        jLabel107.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel107.setText(":");

        model.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        brand.setEditable(true);
        brand.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        brand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Brand", "Lenovo", "Dell", "HP", "Asus", "Others" }));

        jLabel108.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel108.setText(":");

        msoffice.setEditable(true);
        msoffice.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        msoffice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select MS Office", "2022", "2010", "2007", "others" }));

        jLabel109.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel109.setText(":");

        jLabel110.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel110.setText("Model");

        jLabel111.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel111.setText(":");

        jLabel112.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel112.setText("OS");

        jLabel113.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel113.setText(":");

        os.setEditable(true);
        os.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        os.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select OS", "Windows 11", "Windows 10", "Others" }));
        os.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        os.setName(""); // NOI18N
        os.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                osActionPerformed(evt);
            }
        });

        add_asset4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add_asset4.setText("Previous Entry");
        add_asset4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_asset4MouseClicked(evt);
            }
        });
        add_asset4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_asset4ActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(204, 0, 51));
        jLabel42.setText("*");

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(204, 0, 51));
        jLabel43.setText("*");

        jLabel44.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(204, 0, 51));
        jLabel44.setText("*");

        jLabel53.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(204, 0, 51));
        jLabel53.setText("*");

        jLabel54.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(204, 0, 51));
        jLabel54.setText("*");

        jLabel56.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(204, 0, 51));
        jLabel56.setText("*");

        jLabel57.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(204, 0, 51));
        jLabel57.setText("*");

        add_asset5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add_asset5.setText("Import To Inventory");
        add_asset5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_asset5MouseClicked(evt);
            }
        });
        add_asset5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_asset5ActionPerformed(evt);
            }
        });

        add_asset6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add_asset6.setText("Import To Asset");
        add_asset6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_asset6MouseClicked(evt);
            }
        });
        add_asset6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_asset6ActionPerformed(evt);
            }
        });

        jLabel67.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(204, 0, 51));
        jLabel67.setText("*");

        javax.swing.GroupLayout VpLayout = new javax.swing.GroupLayout(Vp);
        Vp.setLayout(VpLayout);
        VpLayout.setHorizontalGroup(
            VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VpLayout.createSequentialGroup()
                .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(VpLayout.createSequentialGroup()
                            .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(252, 252, 252))
                        .addGroup(VpLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(VpLayout.createSequentialGroup()
                                    .addComponent(jLabel100)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(VpLayout.createSequentialGroup()
                                    .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel103)
                                        .addComponent(jLabel101)
                                        .addComponent(jLabel106)
                                        .addComponent(jLabel110)
                                        .addComponent(jLabel112)
                                        .addComponent(jLabel99))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(VpLayout.createSequentialGroup()
                                            .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(category, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(VpLayout.createSequentialGroup()
                                            .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(asset_tag, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(VpLayout.createSequentialGroup()
                                            .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(brand, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(VpLayout.createSequentialGroup()
                                        .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(model, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(VpLayout.createSequentialGroup()
                                        .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(os, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(VpLayout.createSequentialGroup()
                                        .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(vendor, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(VpLayout.createSequentialGroup()
                                    .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(invoice_number, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(VpLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(VpLayout.createSequentialGroup()
                                .addComponent(add_asset, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(add_asset4))
                            .addGroup(VpLayout.createSequentialGroup()
                                .addComponent(jLabel98)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(msoffice, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VpLayout.createSequentialGroup()
                        .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(VpLayout.createSequentialGroup()
                                .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(VpLayout.createSequentialGroup()
                                        .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(VpLayout.createSequentialGroup()
                                                .addGap(100, 100, 100)
                                                .addComponent(jLabel20))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VpLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(choose)))
                                        .addGap(30, 30, 30))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VpLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel21)
                                        .addGap(28, 28, 28)))
                                .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VpLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(add_asset5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filepath, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VpLayout.createSequentialGroup()
                                .addComponent(add_asset6)
                                .addGap(59, 59, 59))))
                    .addGroup(VpLayout.createSequentialGroup()
                        .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(VpLayout.createSequentialGroup()
                                    .addGap(100, 100, 100)
                                    .addComponent(jLabel17))
                                .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VpLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel19)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(warranty_date, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                            .addComponent(serial_number)
                            .addComponent(imei_number)
                            .addComponent(purchase_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        VpLayout.setVerticalGroup(
            VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VpLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(purchase_date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(jLabel32)
                        .addComponent(jLabel101)
                        .addComponent(jLabel113)
                        .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel42)
                        .addComponent(jLabel53)))
                .addGap(18, 18, 18)
                .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(warranty_date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel103)
                        .addComponent(jLabel111)
                        .addComponent(asset_tag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel43)
                        .addComponent(jLabel54)))
                .addGap(18, 18, 18)
                .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VpLayout.createSequentialGroup()
                        .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel106)
                            .addComponent(jLabel109)
                            .addComponent(brand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel110)
                            .addComponent(jLabel108)
                            .addComponent(model, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel112)
                            .addComponent(jLabel107)
                            .addComponent(os, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel98)
                            .addComponent(jLabel104)
                            .addComponent(msoffice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel99)
                            .addComponent(jLabel102)
                            .addComponent(vendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44))
                        .addGap(18, 18, 18)
                        .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel105)
                            .addComponent(invoice_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel100)
                            .addComponent(jLabel67)))
                    .addGroup(VpLayout.createSequentialGroup()
                        .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(serial_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel56))
                        .addGap(18, 18, 18)
                        .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imei_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel35)
                                .addComponent(jLabel20)))
                        .addGap(18, 18, 18)
                        .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(jLabel57)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(filepath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40)
                            .addComponent(choose))))
                .addGap(40, 40, 40)
                .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_asset)
                    .addComponent(add_asset4)
                    .addComponent(add_asset5)
                    .addComponent(add_asset6))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        Ap.setBackground(new java.awt.Color(255, 255, 255));
        Ap.setPreferredSize(new java.awt.Dimension(978, 637));
        Ap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ApMouseClicked(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(0, 161, 225));
        jPanel5.setPreferredSize(new java.awt.Dimension(184, 3));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setText("Search by Asset Category ");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setText("Search by Asset ID");

        showTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        showTable.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        showTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Asset Tag", "Brand", "Model", "OS", "MS Office", "Vendor", "Invoice Number", "Purchase date", "Warranty date", "Serial Number", "IMEI Number", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        showTable.setShowGrid(false);
        showTable.getTableHeader().setReorderingAllowed(false);
        showTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showTableMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                showTableMouseExited(evt);
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

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setText("Total Assets :");

        avail.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        avail.setText("1");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText(":");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText(":");

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton3.setText("View Invoice");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        deleteasset_btn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        deleteasset_btn.setText("Delete Asset");
        deleteasset_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteasset_btnActionPerformed(evt);
            }
        });

        excel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        excel.setText("Export To Excel");
        excel.setPreferredSize(new java.awt.Dimension(145, 29));
        excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelActionPerformed(evt);
            }
        });

        pdf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pdf.setText("Export To PDF");
        pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfActionPerformed(evt);
            }
        });

        year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearActionPerformed(evt);
            }
        });
        year.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                yearKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText(":");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setText("Search by Purchase Year");

        expend.setText("Total Expenditure\nof the Year");
        expend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expendActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText(":");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel38.setText("Display Inventory");

        jPanel11.setBackground(new java.awt.Color(0, 161, 225));
        jPanel11.setForeground(new java.awt.Color(100, 0, 100));
        jPanel11.setPreferredSize(new java.awt.Dimension(184, 3));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        category1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Laptop", "Keyboard", "Mouse", "Monitor", "Hard disk", "Laptop battery", "Laptop keypad" }));
        category1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                category1ActionPerformed(evt);
            }
        });

        update_asset.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        update_asset.setText("Update Asset");
        update_asset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_assetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ApLayout = new javax.swing.GroupLayout(Ap);
        Ap.setLayout(ApLayout);
        ApLayout.setHorizontalGroup(
            ApLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ApLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(ApLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ApLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ApLayout.createSequentialGroup()
                        .addGroup(ApLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ApLayout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(update_asset)
                                .addGap(10, 10, 10)
                                .addComponent(deleteasset_btn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(expend)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(expend1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ApLayout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(ApLayout.createSequentialGroup()
                                .addGroup(ApLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(ApLayout.createSequentialGroup()
                                        .addGroup(ApLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(avail)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(ApLayout.createSequentialGroup()
                                        .addGroup(ApLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel13))
                                        .addGap(18, 18, 18)
                                        .addGroup(ApLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ApLayout.createSequentialGroup()
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(category1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(ApLayout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(asearch, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(35, 35, 35)
                                .addGroup(ApLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ApLayout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ApLayout.createSequentialGroup()
                                        .addComponent(excel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(20, 20, 20))))
        );
        ApLayout.setVerticalGroup(
            ApLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ApLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ApLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(asearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(ApLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(category1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(excel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pdf))
                .addGap(26, 26, 26)
                .addGroup(ApLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(avail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ApLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(deleteasset_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(expend)
                    .addComponent(jLabel11)
                    .addComponent(expend1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_asset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(84, 84, 84))
        );

        Dp.setBackground(new java.awt.Color(255, 255, 255));
        Dp.setPreferredSize(new java.awt.Dimension(978, 637));

        jLabel72.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel72.setText("Add Software :");

        jPanel13.setBackground(new java.awt.Color(0, 161, 225));
        jPanel13.setForeground(new java.awt.Color(100, 0, 100));
        jPanel13.setPreferredSize(new java.awt.Dimension(184, 3));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        add_asset1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add_asset1.setText("ADD SOFTWARE");
        add_asset1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_asset1MouseClicked(evt);
            }
        });
        add_asset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_asset1ActionPerformed(evt);
            }
        });

        Sfilepath.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Sfilepath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SfilepathActionPerformed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel50.setText("Purchase date");

        jLabel51.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel51.setText("Expiry  date");

        jLabel45.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel45.setText(":");

        jLabel46.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel46.setText(":");

        Sprice.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Sprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpriceActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel55.setText("Price");

        jLabel49.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel49.setText(":");

        jLabel48.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel48.setText(":");

        choose1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        choose1.setText("choose File");
        choose1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choose1ActionPerformed(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel71.setText(":");

        Scategory.setEditable(true);
        Scategory.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Scategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Software", "Adobe Arobat DC.", "Visual Studio license", "Godaddy Domain", "Zoho Books India", "Zoho Books Ireland", "Zoho Books NZ", "Zoho Books US.", "CVS Server Maintanence.", "Iron Mountain", "TN3270 Support", "Install Shield Pro", "Office 365 Standard", "Fortigate Firewall", "Trend Micro Security.", "Delphi Mainenance renewal", "IPPBX AMC", "others" }));
        Scategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScategoryActionPerformed(evt);
            }
        });

        jLabel73.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel73.setText("Quantity");

        jLabel68.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel68.setText("Vendor");

        quantity.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });

        jLabel70.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel70.setText(":");

        Svendor.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel59.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel59.setText(":");

        jLabel61.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel61.setText(":");

        Sinvoice_number.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel62.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel62.setText("Software");

        jLabel69.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel69.setText("Invoice Number");

        jLabel74.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel74.setText(":");

        Sserial_number.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel75.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel75.setText("Serial Number");

        jLabel58.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(204, 0, 51));
        jLabel58.setText("*");

        jLabel60.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(204, 0, 51));
        jLabel60.setText("*");

        jLabel63.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(204, 0, 51));
        jLabel63.setText("*");

        jLabel64.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(204, 0, 51));
        jLabel64.setText("*");

        jLabel65.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(204, 0, 51));
        jLabel65.setText("*");

        jLabel66.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(204, 0, 51));
        jLabel66.setText("*");

        javax.swing.GroupLayout DpLayout = new javax.swing.GroupLayout(Dp);
        Dp.setLayout(DpLayout);
        DpLayout.setHorizontalGroup(
            DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DpLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DpLayout.createSequentialGroup()
                        .addGroup(DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(DpLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel73)
                            .addComponent(jLabel62)
                            .addComponent(jLabel68)
                            .addComponent(jLabel69)
                            .addComponent(choose1))
                        .addGap(41, 41, 41)
                        .addGroup(DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DpLayout.createSequentialGroup()
                                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Scategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(DpLayout.createSequentialGroup()
                                .addGroup(DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(Sinvoice_number)
                                        .addComponent(Sfilepath, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Svendor, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(quantity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(4, 4, 4)
                        .addGroup(DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(DpLayout.createSequentialGroup()
                                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel75))
                            .addComponent(jLabel51)
                            .addGroup(DpLayout.createSequentialGroup()
                                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel55))
                            .addGroup(DpLayout.createSequentialGroup()
                                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel50)))
                        .addGroup(DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DpLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DpLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DpLayout.createSequentialGroup()
                                .addComponent(expiry_date, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Sserial_number, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(DpLayout.createSequentialGroup()
                                .addComponent(Sprice, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DpLayout.createSequentialGroup()
                                .addComponent(Spurchase_date, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))))
            .addGroup(DpLayout.createSequentialGroup()
                .addGap(370, 370, 370)
                .addComponent(add_asset1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        DpLayout.setVerticalGroup(
            DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DpLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel72)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DpLayout.createSequentialGroup()
                        .addGroup(DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel61)
                            .addComponent(jLabel62)
                            .addComponent(Scategory, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel73)
                            .addComponent(jLabel59)
                            .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel68)
                            .addComponent(jLabel71)))
                    .addGroup(DpLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Svendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel60))
                        .addGap(18, 18, 18)
                        .addGroup(DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel69)
                            .addComponent(jLabel70)
                            .addComponent(Sinvoice_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel63)))
                    .addGroup(DpLayout.createSequentialGroup()
                        .addGroup(DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DpLayout.createSequentialGroup()
                                .addGroup(DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel50)
                                    .addComponent(jLabel45)
                                    .addComponent(jLabel58))
                                .addGap(18, 18, 18)
                                .addGroup(DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel51)
                                    .addComponent(jLabel49)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DpLayout.createSequentialGroup()
                                .addGroup(DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Spurchase_date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel64))
                                .addGap(18, 18, 18)
                                .addGroup(DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(expiry_date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel65))))
                        .addGap(18, 18, 18)
                        .addGroup(DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel75)
                            .addComponent(jLabel74)
                            .addComponent(Sserial_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel55)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Sprice, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel66))))
                .addGap(18, 18, 18)
                .addGroup(DpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(choose1)
                    .addComponent(jLabel48)
                    .addComponent(Sfilepath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(add_asset1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        Sp1.setBackground(new java.awt.Color(255, 255, 255));
        Sp1.setPreferredSize(new java.awt.Dimension(978, 637));
        Sp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Sp1MouseClicked(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(0, 161, 225));
        jPanel9.setPreferredSize(new java.awt.Dimension(184, 3));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 137, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel39.setText("Search by Software Name ");

        STable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        STable.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        STable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Quantity", "Vendor Name", "Invoice Number", "Purchase Date", "Expiry Date", "Serial Number", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        STable.setShowGrid(false);
        STable.getTableHeader().setReorderingAllowed(false);
        STable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                STableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(STable);
        if (STable.getColumnModel().getColumnCount() > 0) {
            STable.getColumnModel().getColumn(0).setResizable(false);
            STable.getColumnModel().getColumn(1).setResizable(false);
            STable.getColumnModel().getColumn(2).setResizable(false);
            STable.getColumnModel().getColumn(3).setResizable(false);
            STable.getColumnModel().getColumn(4).setResizable(false);
            STable.getColumnModel().getColumn(5).setResizable(false);
            STable.getColumnModel().getColumn(6).setResizable(false);
            STable.getColumnModel().getColumn(7).setResizable(false);
        }

        p_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_searchActionPerformed(evt);
            }
        });
        p_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                p_searchKeyReleased(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel47.setText("Total Assets :");

        avail1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        avail1.setText("1");

        jLabel52.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel52.setText(":");

        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton4.setText("Display Invoice");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        deleteasset_btn1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        deleteasset_btn1.setText("Delete Software");
        deleteasset_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteasset_btn1ActionPerformed(evt);
            }
        });

        excel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        excel1.setText("Export To Excel");
        excel1.setPreferredSize(new java.awt.Dimension(145, 29));
        excel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excel1ActionPerformed(evt);
            }
        });

        pdf1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        pdf1.setText("Export To PDF");
        pdf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdf1ActionPerformed(evt);
            }
        });

        jLabel76.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel76.setText("Display Software ");

        jPanel14.setBackground(new java.awt.Color(0, 161, 225));
        jPanel14.setForeground(new java.awt.Color(100, 0, 100));
        jPanel14.setPreferredSize(new java.awt.Dimension(184, 3));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Sp1Layout = new javax.swing.GroupLayout(Sp1);
        Sp1.setLayout(Sp1Layout);
        Sp1Layout.setHorizontalGroup(
            Sp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Sp1Layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(jButton4)
                .addGap(84, 84, 84)
                .addComponent(deleteasset_btn1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(Sp1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(Sp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Sp1Layout.createSequentialGroup()
                        .addGroup(Sp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Sp1Layout.createSequentialGroup()
                                .addComponent(jLabel47)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(avail1)
                                .addGap(74, 74, 74)
                                .addComponent(excel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(pdf1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Sp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                            .addGroup(Sp1Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(p_search, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 300, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        Sp1Layout.setVerticalGroup(
            Sp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Sp1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel76)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Sp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52)
                    .addComponent(p_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(Sp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(avail1)
                    .addComponent(excel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pdf1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(Sp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(deleteasset_btn1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Vp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Ap, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE)
                .addComponent(Sp1, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Dp, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Vp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1158, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addComponent(Ap, javax.swing.GroupLayout.PREFERRED_SIZE, 595, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(Sp1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Dp, javax.swing.GroupLayout.DEFAULT_SIZE, 1158, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void ApanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ApanelMouseEntered
        // TODO add your handling code here:
        Apanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.WHITE));
        Apanel.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_ApanelMouseEntered

    private void ApanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ApanelMouseExited
        // TODO add your handling code here:
//        All.setBorder(BorderFactory.createEmptyBorder());
        Apanel.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.white));
        Apanel.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_ApanelMouseExited

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
        // TODO add your handling code here:
        Apanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.WHITE));
        Apanel.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_addMouseEntered

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
        // TODO add your handling code here:
        Apanel.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.white));
        Apanel.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_addMouseExited

    private void updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseEntered
        // TODO add your handling code here:
        Asset.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.WHITE));
        Asset.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_updateMouseEntered

    private void updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseExited
        // TODO add your handling code here:
        Asset.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.white));
        Asset.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_updateMouseExited

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
        Ap.setVisible(false);
        Vp.setVisible(true);
        Dp.setVisible(false);
        Sp1.setVisible(false);
    }//GEN-LAST:event_ApanelMouseClicked

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        // TODO add your handling code here:
        Ap.setVisible(false);   
        Vp.setVisible(true);
        Dp.setVisible(false);
        Sp1.setVisible(false);
    }//GEN-LAST:event_addMouseClicked

    private void AssetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AssetMouseClicked
        // TODO add your handling code here:
        Ap.setVisible(true);
        Vp.setVisible(false);
        Dp.setVisible(false);
        Sp1.setVisible(false);
    }//GEN-LAST:event_AssetMouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        // TODO add your handling code here:
        Ap.setVisible(true);
        Vp.setVisible(false);
        Dp.setVisible(false);
        Sp1.setVisible(false);
    }//GEN-LAST:event_updateMouseClicked

    private void asearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_asearchKeyReleased
        // TODO add your handling code here:
        String name = asearch.getText();
        DefaultTableModel dtm = (DefaultTableModel) showTable.getModel();
        int r = showTable.getRowCount();
        
        while(r-->0)
        {
            dtm.removeRow(r);
        }
        
        try
        {
            st = con1.createStatement();
                pst = con1.prepareStatement("SELECT category,asset_tag,brand,model,os,ms_office,vendor,invoice_number,purchase_date,warranty_date,serial_number,imei_number,price FROM inventory where asset_tag like ?");
                pst.setString(1,"%"+name+"%");
                ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                java.util.Vector v = new java.util.Vector();
                v.add(rs.getString("category"));
                v.add(rs.getString("asset_tag"));
                v.add(rs.getString("brand"));
                v.add(rs.getString("model"));
                v.add(rs.getString("os"));
                v.add(rs.getString("ms_office"));
                v.add(rs.getString("vendor"));
                v.add(rs.getString("invoice_number"));
                v.add(rs.getString("purchase_date"));
                v.add(rs.getString("warranty_date"));
                v.add(rs.getString("serial_number"));
                v.add(rs.getString("imei_number"));
                v.add(rs.getString("price"));
//                v.add(rs.getString("invoice"));
                
                
                
                dtm.addRow(v);
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Database error");
            System.out.println(ex);
        }
    }//GEN-LAST:event_asearchKeyReleased

    private void showTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showTableMouseClicked
        //TODO add your handling code here: 
      
    }//GEN-LAST:event_showTableMouseClicked

    private void add_assetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_assetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add_assetActionPerformed

    private void add_assetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_assetMouseClicked
        int jnum1 = 0;
        String w_date = fmt.format(warranty_date.getDate());
        String p_date = fmt.format(purchase_date.getDate());
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        final LocalDate firstDate = LocalDate.parse(p_date, formatter);
        final LocalDate secondDate = LocalDate.parse(w_date, formatter);
        final long days = ChronoUnit.DAYS.between(firstDate, secondDate);
        jnum1 = (int) days;
        if( category.getSelectedIndex()==0 && asset_tag.getText().trim().isEmpty() && brand.getSelectedIndex()==0 && model.getText().trim().isEmpty() &&  vendor.getText().trim().isEmpty() && invoice_number.getText().trim().isEmpty() && serial_number.getText().trim().isEmpty() && price.getText().trim().isEmpty() && purchase_date.getDate()==null )
        {
        JOptionPane.showMessageDialog(null,"All fields are empty"); 
        return;
        }
        else if(category.getSelectedIndex()==0){
         JOptionPane.showMessageDialog(null,"Product field is empty");  
         return;
        }
        else if(asset_tag.getText().trim().isEmpty()){
         JOptionPane.showMessageDialog(null,"Asset_tag field is empty"); 
         return;
        }
        else if(vendor.getText().trim().isEmpty()){
         JOptionPane.showMessageDialog(null,"Vendor field is empty");
         return;
        }
        else if(invoice_number.getText().trim().isEmpty()){
         JOptionPane.showMessageDialog(null,"Invoice number field is empty");
         return;
        }
        else if(purchase_date.getDate()==null)
        {
            JOptionPane.showMessageDialog(null,"Select Purchase Date");
            return;
        }
        else if(serial_number.getText().trim().isEmpty()){
         JOptionPane.showMessageDialog(null,"Serial number field is empty");   
         return;
        }      
        else if(price.getText().trim().isEmpty()){
         JOptionPane.showMessageDialog(null,"Price field is empty");   
         return;
        }
        else if(jnum1<0)
        {
            JOptionPane.showMessageDialog(null, "Warranty date must be greater than purchase date");
            return;
        }
        else if(jnum1==0)
        {
            JOptionPane.showMessageDialog(null, "Warranty date must be greater than purchase date");
            return;
        }
        
        else{
        
        }
        try{
            PreparedStatement stm = con1.prepareStatement("Insert into inventory(category,asset_tag,brand,model,os,ms_office,vendor,invoice_number,purchase_date,warranty_date,serial_number,imei_number,price,invoice_image)values(?,?,?,?,?,?,?,?,?::date,?::date,?,?,?,?)");  
            PreparedStatement stm1=con1.prepareStatement("Insert into asset(asset_tag,category,brand,model,os,ms_office,availability,status)values(?,?,?,?,?,?,?,?)");
            SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
            
            Date date = new Date();
            String date1 = fmt.format(date.getDate());
            int a3 = parseInt(price.getText());          
            stm.setString(2,asset_tag.getText().toUpperCase());
            clone_asset_tag = asset_tag.getText();
            stm.setString(1,category.getSelectedItem().toString().toLowerCase());
            clone_category = category.getSelectedItem().toString();
            if(brand.getSelectedItem().toString() == "Select Brand")
            {
            stm.setString(3,null);
            }
            else{
                stm.setString(3,brand.getSelectedItem().toString().toLowerCase());
                clone_brand = brand.getSelectedItem().toString();
            }
            
            if(model.getText().isEmpty())
            {
            stm.setString(4,null);

            }
            else{
                stm.setString(4,model.getText().toLowerCase());
                clone_model = model.getText();
            }
            
            if(os.getSelectedItem().toString() == "Select OS")
            {
            stm.setString(5,null);
            }
            else{
                stm.setString(5,os.getSelectedItem().toString().toLowerCase());
                clone_os = os.getSelectedItem().toString();
            }
            
            if(msoffice.getSelectedItem().toString() == "Select MS Office")
            {
            stm.setString(6,null);
            }
            else{
                stm.setString(6,msoffice.getSelectedItem().toString().toLowerCase());
                clone_os = msoffice.getSelectedItem().toString();
            }
            stm.setString(7,vendor.getText());
            clone_vendor = vendor.getText();
            stm.setString(8,invoice_number.getText());
            clone_inum = invoice_number.getText();
            stm.setString(9,p_date);
            stm.setString(10,w_date);
            
            stm.setString(11,serial_number.getText());
            if(imei_number.getText().trim().isEmpty())
            {
            stm.setString(12,null);
            }
            else{
                stm.setString(12,imei_number.getText());
                clone_imei = imei_number.getText();
            }
            
            stm.setInt(13,a3);
            
            
            if(filepath.getText() == null || filepath.getText() ==""  || filepath.getText().isEmpty()){
                stm.setBytes(14,null);
            }else{
                 String image = filepath.getText();
            image = image.replace("\\", "\\\\");
            FileInputStream fis = new FileInputStream(image);
               stm.setBytes(14,invoice_image);
              
            }
            if(brand.getSelectedItem().toString() == "Select Brand")
            {
            stm1.setString(3,null);
            }
            else{
                stm1.setString(3,brand.getSelectedItem().toString());
            }
            
            if(model.getText().trim().isEmpty())
            {
            stm1.setString(4,null);
            }
            else{
                stm1.setString(4,model.getText());
            }
            
            if(os.getSelectedItem().toString() == "Select OS")
            {
            stm1.setString(5,null);
            }
            else{
                stm1.setString(5,os.getSelectedItem().toString());
            }
            
            if(msoffice.getSelectedItem().toString() == "Select MS Office")
            {
            stm1.setString(6,null);
            }
            else{
                stm1.setString(6,msoffice.getSelectedItem().toString());
            }
            stm1.setString(1, asset_tag.getText().toUpperCase());
            stm1.setString(2, category.getSelectedItem().toString().toLowerCase());
            stm1.setString(7,"free");
            stm1.setString(8,"working");
            stm.executeUpdate();
            stm1.executeUpdate();
            
            
            
            category.setSelectedItem("");
            asset_tag.setText("");
            brand.setSelectedItem("");
            model.setText("");
            os.setSelectedItem("");
            msoffice.setSelectedItem("");
            vendor.setText("");
            invoice_number.setText("");
            purchase_date.setDate(null);
            warranty_date.setDate(null);
            serial_number.setText("");
            imei_number.setText("");
            price.setText("");
            filepath.setText("");
            clone_check++;
            JOptionPane.showMessageDialog(null, "Data Added sucessfully");
            update3();
//            Dis d = new Dis();
//            d.setVisible(true);
//            this.dispose();
//update(date1, clone_asset_tag, date1, date1, date1, p_date, date1, clone_inum, date, date, clone_inum, p_date, p_date);
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Database error", "Error!", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e);
                        
        }           
    }//GEN-LAST:event_add_assetMouseClicked

    private void asearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asearchActionPerformed

    private void SpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SpriceActionPerformed

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityActionPerformed

    private void choose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choose1ActionPerformed
        // TODO add your handling code here:

        JFileChooser Chooser = new JFileChooser();
        Chooser.showOpenDialog(null);
        File f = Chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        Sfilepath.setText(filename);

        try{
            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum;(readNum = fis.read(buf))!=-1;){
                bos.write(buf,0,readNum);

            }

            invoice_image = bos.toByteArray();

        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_choose1ActionPerformed

    private void SfilepathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SfilepathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SfilepathActionPerformed

    private void add_asset1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_asset1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_add_asset1MouseClicked

    private void add_asset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_asset1ActionPerformed
        // TODO add your handling code here:

        int flag = 0;
        if( Scategory.getSelectedItem().toString().trim().isEmpty()  && quantity.getText().trim().isEmpty() && Svendor.getText().trim().isEmpty() && Sinvoice_number.getText().trim().isEmpty() && Sprice.getText().trim().isEmpty() && Sserial_number.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"All fields are empty"); flag +=1;
        }
        else if(Scategory.getSelectedItem().toString().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"Product field is empty"); flag +=1;
        }

        else if(quantity.getText().toString().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"Quantity field is empty"); flag +=1;
        }
        else if(Svendor.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"vendor field is empty"); flag +=1;
        }
        else if(Sinvoice_number.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"invoice_number field is empty"); flag +=1;
        }
        else if(Sserial_number.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"Serial_number field is empty"); flag +=1;
        }
        else if(Sprice.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"price field is empty"); flag +=1;
        }
        
        else{
            
        
        try{
            
            PreparedStatement stm = con1.prepareStatement("Insert into soft_inventory(product_name,quantity,vendor_name,invoice_number,purchase_date,expiry_date,serial_number,price,invoice_image)values(?,?,?,?,?::date,?::date,?,?,?)");

            SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
            String p_date = fmt.format(Spurchase_date.getDate());
            String e_date = fmt.format(expiry_date.getDate());
            
            Date date = new Date();
            String date1 = fmt.format(date.getDate());
            int a3 = parseInt(Sprice.getText());
            int a4 = parseInt(quantity.getText());

            stm.setString(1,Scategory.getSelectedItem().toString());
            stm.setInt(2,a4);
            stm.setString(3,Svendor.getText());
            stm.setString(4,Sinvoice_number.getText());
            stm.setString(5,p_date);
            stm.setString(6,e_date);
            stm.setString(7,Sserial_number.getText());
            stm.setInt(8,a3);
            
            String image = Sfilepath.getText();
            image = image.replace("\\", "\\\\");
                FileInputStream fis = new FileInputStream(image);

                stm.setBytes(9,invoice_image);
                
                stm.executeUpdate();

                  Scategory.setSelectedItem("");
                  quantity.setText("");
                Svendor.setText("");
                Sinvoice_number.setText("");
                Spurchase_date.setDate(null);
                expiry_date.setDate(null);
                Sserial_number.setText("");
                Sprice.setText("");
                Sfilepath.setText("");
                
                JOptionPane.showMessageDialog(null, "Data Added sucessfully");

            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Database error", "Error!", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(e);

            }
        update2();
//          this.dispose();
//           Dis d = new Dis();
//            d.setVisible(true);
        }
          
    }//GEN-LAST:event_add_asset1ActionPerformed

    private void display1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_display1MouseClicked
        // TODO add your handling code here:
        
        Vp.setVisible(false);
        Ap.setVisible(false);
        Dp.setVisible(true);
        Sp1.setVisible(false);
        
    }//GEN-LAST:event_display1MouseClicked

    private void display1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_display1MouseEntered
        // TODO add your handling code here:
        User1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.WHITE));
        User1.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_display1MouseEntered

    private void display1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_display1MouseExited
        // TODO add your handling code here:
        User1.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.white));
        User1.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_display1MouseExited

    private void User1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_User1MouseClicked
        // TODO add your handling code here:
         
        Vp.setVisible(false);
        Ap.setVisible(false);
        Dp.setVisible(true);
        Sp1.setVisible(false);
    }//GEN-LAST:event_User1MouseClicked

    private void User1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_User1MouseEntered
        // TODO add your handling code here:
        User1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.WHITE));
        User1.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_User1MouseEntered

    private void User1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_User1MouseExited
        // TODO add your handling code here:
        User1.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.white));
        User1.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_User1MouseExited

    private void display2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_display2MouseClicked
        // TODO add your handling code here:
        
        Vp.setVisible(false);
        Ap.setVisible(false);
        Dp.setVisible(false);
        Sp1.setVisible(true);
        
    }//GEN-LAST:event_display2MouseClicked

    private void display2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_display2MouseEntered
        // TODO add your handling code here:
        User2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.WHITE));
        User2.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_display2MouseEntered

    private void display2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_display2MouseExited
        // TODO add your handling code here:
        User2.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.white));
        User2.setBackground(new Color(0,161,225));
        
    }//GEN-LAST:event_display2MouseExited

    private void User2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_User2MouseClicked
        // TODO add your handling code here:
         
        Vp.setVisible(false);
        Ap.setVisible(false);
        Dp.setVisible(false);
        Sp1.setVisible(true);
        update2();
    }//GEN-LAST:event_User2MouseClicked

    private void User2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_User2MouseEntered
        // TODO add your handling code here:
        User2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.WHITE));
        User2.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_User2MouseEntered

    private void User2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_User2MouseExited
        // TODO add your handling code here:
        User2.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.white));
        User2.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_User2MouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        try
        {
        DefaultTableModel RecordTable=(DefaultTableModel) showTable.getModel();
        String AssetTag=RecordTable.getValueAt(showTable.getSelectedRow(),1).toString();
        try{
        pst = con1.prepareStatement("select invoice_image from inventory where asset_tag = ?" );
        pst.setString(1, AssetTag);
        byte[] imge = new byte[0];

        ResultSet rs1 = pst.executeQuery();
       
        if(rs1.next())
        {
            imge = rs1.getBytes("invoice_image");
        }
            byte[] encodedBytes = Base64.getEncoder().encode(imge);
                try
                {
                   String encodedString = new String(encodedBytes);
                   String dataURL = "data:INVOICE/pdf;base64," + encodedString;
                   System.out.println("data URL ---------------------->>>>>>>>" +dataURL.length());
                   String encodedURL = Base64.getUrlEncoder().encodeToString(encodedString.getBytes());
                   byte[] decodedBytes = Base64.getDecoder().decode(encodedString.getBytes());
                   
                   byte[] imagedata = DatatypeConverter.parseBase64Binary(dataURL.substring(dataURL.indexOf(",")+1));
                   //Image bufferedImage = ImageIO.read(new ByteArrayInputStream(imagedata));
                   OutputStream os = new FileOutputStream(file);
                   os.write(imagedata);
                   if(file.exists())
                   {
                       if(Desktop.isDesktopSupported()){
                           Desktop.getDesktop().open(file);
                           
                       }else{
                           JOptionPane.showMessageDialog(this, "not supported");
                       }
                   }else{
                       JOptionPane.showMessageDialog(this, "file not exist");
                   }os.close();
                   os.flush();
                   
//                   ImageIcon imageIcon = new ImageIcon(new ImageIcon(bufferedImage).getImage().getScaledInstance(invoiceImage.lbl_img1.getWidth(),invoiceImage.lbl_img1.getHeight(),bufferedImage.SCALE_SMOOTH));
//                   invoiceImage.lbl_img1.setIcon(imageIcon);
//                   invoice_image = decodedBytes;
                 }
                catch(Exception e)
                {
                System.out.println(e);
                }
        }catch(Exception e)
                {
                System.out.println(e);
                }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Please select an asset to display invoice");
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void deleteasset_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteasset_btnActionPerformed
        // TODO add your handling code here:

       
        DefaultTableModel RecordTable=(DefaultTableModel) showTable.getModel();
        int[] rows1 = showTable.getSelectedRows();
        if(rows1.length>0)
        {
        int flag = 0;
        int result=JOptionPane.showConfirmDialog(null,"Do you want to delete this asset(s)?", "Delete Asset",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(result==JOptionPane.YES_OPTION)
        for(int i=0; i<rows1.length;i++)
        {
        asset_tag0=RecordTable.getValueAt(showTable.getSelectedRow(),1).toString();
        invent.update.update.n16 = asset_tag0;
        try{System.out.println("selected");
        
            PreparedStatement select = con1.prepareStatement("Select category,brand,model,os,ms_office,vendor,invoice_number,purchase_date,warranty_date,serial_number,imei_number,price from inventory where asset_tag = ?");
            select.setString(1, asset_tag0);
            ResultSet rr = select.executeQuery();
            while (rr.next()){
                 category0 =rr.getString("category");
                 brand0 = rr.getString("brand");
                 model0 = rr.getString("model");
                 os0 = rr.getString("os");
                ms_office0 = rr.getString("ms_office");
                 vendor0 = rr.getString("vendor");
                 invoice_image0 = rr.getString("invoice_number");
                 purchase_date0 = rr.getString("purchase_date");
                 warranty_date0 = rr.getString("warranty_date");
                 serial0 = rr.getString("serial_number");
                 imei0 = rr.getString("imei_number");
                 price0 = rr.getInt("price");
            }
            PreparedStatement ps1 = con1.prepareStatement("Insert into inventory_deleted(category,asset_tag,brand,model,os,ms_office,vendor,invoice_number,purchase_date,warranty_date,serial_number,imei_number,price)values(?,?,?,?,?,?,?,?,?::date,?::date,?,?,?)");  
            ps1.setString(1, category0);
            ps1.setString(2, asset_tag0);
            ps1.setString(3, brand0);
            ps1.setString(4, model0);
            ps1.setString(5,os0);
            ps1.setString(6,ms_office0);
            ps1.setString(7,vendor0);
            ps1.setString(8,invoice_image0);
            ps1.setString(9,purchase_date0);
            ps1.setString(10, warranty_date0);
            ps1.setString(11, serial0);
            ps1.setString(12, imei0);
            ps1.setInt(13, price0);
            ps1.executeUpdate();
            ps1.executeUpdate();
         
             try {
            PreparedStatement pst2 = con1.prepareStatement("DELETE from inventory where asset_tag=?");
            PreparedStatement pst3 = con1.prepareStatement("DELETE from asset where asset_tag=? and provide_Date is null and handover_date is null");
            pst3.setString(1, asset_tag0);
            pst2.setString(1,asset_tag0);
            pst2.executeUpdate();
            pst3.executeUpdate();   
            flag++;
        }                 
            catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Delete failed");
        }
        }catch(Exception e)
        {
            System.out.println(e);
            
        }
       
        }
        if(flag>0)
        {
            JOptionPane.showMessageDialog(null, "Deleted Sucessfully");
        }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Select asset(s) to delete");
        }
        
        update3();
        DefaultTableModel dtm3 = (DefaultTableModel) showTable.getModel();
        int r3 = showTable.getRowCount();
        avail.setText(""+r3+"");
        
    }//GEN-LAST:event_deleteasset_btnActionPerformed

    private void ScategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ScategoryActionPerformed

    private void STableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_STableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_STableMouseClicked

    private void p_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p_searchActionPerformed

    private void p_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_p_searchKeyReleased
        // TODO add your handling code here:
        
        String name2 = p_search.getText();
        DefaultTableModel dtm2 = (DefaultTableModel) STable.getModel();
        int r2 = STable.getRowCount();

        while(r2-->0)
        {
            dtm2.removeRow(r2);
        }

        try
        {
            st = con1.createStatement();
                pst = con1.prepareStatement("SELECT product_name,quantity,vendor_name,invoice_number,purchase_date,expiry_date,serial_number,price FROM soft_inventory where product_name like ?" );
                pst.setString(1,"%"+name2+"%");
                ResultSet rs = pst.executeQuery();

            while(rs.next())
            {
                java.util.Vector v1 = new java.util.Vector();
                v1.add(rs.getString("product_name"));
                v1.add(rs.getString("quantity"));
                v1.add(rs.getString("vendor_name"));
                v1.add(rs.getString("invoice_number"));
                v1.add(rs.getString("purchase_date"));
                v1.add(rs.getString("expiry_date"));
                v1.add(rs.getString("serial_number"));
                v1.add(rs.getString("price"));
                

                dtm2.addRow(v1);
                softintv();
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Database error");
            System.out.println(ex);
        }
        
        
        
    }//GEN-LAST:event_p_searchKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try
        {
        DefaultTableModel RecordTable=(DefaultTableModel) STable.getModel();
        String Product_name=RecordTable.getValueAt(STable.getSelectedRow(),0).toString();
        try{
        pst = con1.prepareStatement("select invoice_image from soft_inventory where product_name = ?" );
        pst.setString(1, Product_name);
        byte[] imge = new byte[0];

        ResultSet rs1 = pst.executeQuery();
       
        if(rs1.next())
        {
            imge = rs1.getBytes("invoice_image");
        }
            byte[] encodedBytes = Base64.getEncoder().encode(imge);
                try
                {
                   String encodedString = new String(encodedBytes);
                   String dataURL = "data:INVOICE/pdf;base64," + encodedString;
                   System.out.println("data URL ---------------------->>>>>>>>" +dataURL.length());
                   String encodedURL = Base64.getUrlEncoder().encodeToString(encodedString.getBytes());
                   byte[] decodedBytes = Base64.getDecoder().decode(encodedString.getBytes());
                   
                   byte[] imagedata = DatatypeConverter.parseBase64Binary(dataURL.substring(dataURL.indexOf(",")+1));
                   //Image bufferedImage = ImageIO.read(new ByteArrayInputStream(imagedata));
                   OutputStream os = new FileOutputStream(file);
                   os.write(imagedata);
                   if(file.exists())
                   {
                       if(Desktop.isDesktopSupported()){
                           Desktop.getDesktop().open(file);
                           
                       }else{
                           JOptionPane.showMessageDialog(this, "not supported");
                       }
                   }else{
                       JOptionPane.showMessageDialog(this, "file not exist");
                   }os.close();
                   os.flush();
                   
//                   ImageIcon imageIcon = new ImageIcon(new ImageIcon(bufferedImage).getImage().getScaledInstance(invoiceImage.lbl_img1.getWidth(),invoiceImage.lbl_img1.getHeight(),bufferedImage.SCALE_SMOOTH));
//                   invoiceImage.lbl_img1.setIcon(imageIcon);
//                   invoice_image = decodedBytes;
                 }
                catch(Exception e)
                {
                System.out.println(e);
                }
        }catch(Exception e)
                {
                System.out.println(e);
                }
        }
        
     
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Please select an asset to display invoice");
        }
        
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void deleteasset_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteasset_btn1ActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel RecordTable=(DefaultTableModel) STable.getModel();
        String Productname=RecordTable.getValueAt(STable.getSelectedRow(),0).toString();
        invent.update.update.n15 = Productname;
              try {
            PreparedStatement pst2 = con1.prepareStatement("DELETE from soft_inventory where product_name=?");
            pst2.setString(1,Productname);
            pst2.executeUpdate();
            if(STable.getSelectedRowCount()==1) {
             RecordTable.removeRow(STable.getSelectedRow());
            JOptionPane.showMessageDialog(null, "Deleted Sucessfully");
        }   else {
             JOptionPane.showMessageDialog(null,"Select any row to delete");
         }
               }
            catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
              DefaultTableModel dtm3 = (DefaultTableModel) STable.getModel();
        int r3 = STable.getRowCount();
        avail1.setText(""+r3+"");
    }//GEN-LAST:event_deleteasset_btn1ActionPerformed

    private void filepathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filepathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filepathActionPerformed

    private void chooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseActionPerformed
        // TODO add your handling code here:

        JFileChooser Chooser = new JFileChooser();
        Chooser.showOpenDialog(null);
        File f = Chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        filepath.setText(filename);

        try{
            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum;(readNum = fis.read(buf))!=-1;){
                bos.write(buf,0,readNum);

            }

            invoice_image = bos.toByteArray();

        }catch(Exception e){
            System.out.println(e);
        }

    }//GEN-LAST:event_chooseActionPerformed

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void imei_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imei_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imei_numberActionPerformed

    private void serial_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serial_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serial_numberActionPerformed

    private void asset_tagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asset_tagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asset_tagActionPerformed

    private void osActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_osActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_osActionPerformed

    private void add_asset4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_asset4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_add_asset4MouseClicked

    private void add_asset4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_asset4ActionPerformed
        // TODO add your handling code here:
        
        if(clone_check==0)
        {
            JOptionPane.showMessageDialog(null,"There are no previous values");
            return;
        }
        else
        {
            category.setSelectedItem(clone_category);
            asset_tag.setText(clone_asset_tag);
            brand.setSelectedItem(clone_brand);
            model.setText(clone_model);
            os.setSelectedItem(clone_os);
            msoffice.setSelectedItem(clone_ms);
            vendor.setText(clone_vendor);
            invoice_number.setText(clone_inum);
            serial_number.setText(clone_serial);
        }
    }//GEN-LAST:event_add_asset4ActionPerformed

    private void showTableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showTableMouseExited
        // TODO add your handling code here:
        
        //showTable.clearSelection();
    }//GEN-LAST:event_showTableMouseExited

    private void ApMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ApMouseClicked
        // TODO add your handling code here:
        showTable.clearSelection();
    }//GEN-LAST:event_ApMouseClicked

    private void Sp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Sp1MouseClicked
        // TODO add your handling code here:
        STable.clearSelection();
    }//GEN-LAST:event_Sp1MouseClicked

    private void asset_tagKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_asset_tagKeyReleased
        // TODO add your handling code here:
        
        int position = asset_tag.getCaretPosition();
        asset_tag.setText(asset_tag.getText().toUpperCase());
        asset_tag.setCaretPosition(position);
    }//GEN-LAST:event_asset_tagKeyReleased

    private void excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelActionPerformed
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
        excelFileChooser.setSelectedFile(new File("Inventory_Report_"+java.time.LocalDate.now().toString().trim()+"_"+formatter.format(date).toString().trim()));
        int excelChooser = excelFileChooser.showSaveDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            try {
                wb = new XSSFWorkbook();
                XSSFSheet sheet = wb.createSheet("Data Sheet");
                XSSFRow excelRow = sheet.createRow(0);

                for (int c = 0; c < showTable.getColumnCount(); c++) {
                    excelCell = excelRow.createCell(c);
                    excelCell.setCellValue(showTable.getColumnName(c));  
                }

              

                for (int i = 0; i < showTable.getRowCount(); i++) {
                    System.out.println(i);
                    excelRow = sheet.createRow(i + 1);

                    for (int j = 0; j < showTable.getColumnCount(); j++) {
                        if (showTable.getValueAt(i, j) == "null") {
                            showTable.setValueAt(" ", i, j);
                        } else {
                            excelCell = excelRow.createCell(j);
                            Object o = showTable.getValueAt(i, j);
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
        } //-- end if condition
             
    }//GEN-LAST:event_excelActionPerformed

    private void pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel mod = (DefaultTableModel) showTable.getModel();
        FileOutputStream fo=null;
        String path = "";
        String nm = "";
        JFileChooser j = new JFileChooser();
        SimpleDateFormat formatter = new SimpleDateFormat("HH-mm-ss");  
        Date date = new Date();  
        j.setSelectedFile(new File("Inventory_Report_"+java.time.LocalDate.now().toString().trim()+"_"+formatter.format(date).toString().trim()));

        int y = showTable.getColumnCount();
        j.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
        int x = j.showSaveDialog(null);
        if(x==JFileChooser.APPROVE_OPTION)
        {

            Rectangle rect = new Rectangle(1000, 1000);
            Document doc = new Document(rect, 30, 30, 30, 30);

        try {
           
            PdfWriter writer = PdfWriter.getInstance(doc,new FileOutputStream(j.getSelectedFile()+".pdf"));
            
            doc.setMargins(20,20,20,20);
            doc.open();
            
            
            float cwidth[] = {11f,7f,7f,6f,8f,6f,8f,7f,10f,10f,7f,9f,8f};
            Font bold = new Font("Times New Roman",12,Font.BOLD);
            PdfPTable tb = new PdfPTable(13);
            
            PdfPCell c1=new PdfPCell(new Phrase("Category",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK)));
            c1.setBackgroundColor(new BaseColor(211,211,211));
            PdfPCell c2=new PdfPCell(new Phrase("Asset Tag",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK)));
            c2.setBackgroundColor(new BaseColor(211,211,211));
            PdfPCell c3=new PdfPCell(new Phrase("Brand",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK)));
            c3.setBackgroundColor(new BaseColor(211,211,211));
            PdfPCell c4=new PdfPCell(new Phrase("Model",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK)));
            c4.setBackgroundColor(new BaseColor(211,211,211));
            PdfPCell c5=new PdfPCell(new Phrase("Windows",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK)));
            c5.setBackgroundColor(new BaseColor(211,211,211));
            PdfPCell c6=new PdfPCell(new Phrase("MS Office",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK)));
            c6.setBackgroundColor(new BaseColor(211,211,211));
            PdfPCell c7=new PdfPCell(new Phrase("Vendor",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK)));
            c7.setBackgroundColor(new BaseColor(211,211,211));
            PdfPCell c8=new PdfPCell(new Phrase("Invoice Number",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK)));
            c8.setBackgroundColor(new BaseColor(211,211,211));
            PdfPCell c9=new PdfPCell(new Phrase("Purchase Date",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK)));
            c9.setBackgroundColor(new BaseColor(211,211,211));
            PdfPCell c10=new PdfPCell(new Phrase("Warranty Date",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK)));
            c10.setBackgroundColor(new BaseColor(211,211,211));
            PdfPCell c11=new PdfPCell(new Phrase("Serial Number",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK)));
            c11.setBackgroundColor(new BaseColor(211,211,211));
            PdfPCell c12=new PdfPCell(new Phrase("IMEI Number",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK)));
            c12.setBackgroundColor(new BaseColor(211,211,211));
            PdfPCell c13=new PdfPCell(new Phrase("Price",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK)));
            c13.setBackgroundColor(new BaseColor(211,211,211));
            
            
            
            
            
            
            tb.setWidths(cwidth);
            tb.setWidthPercentage(100);
            tb.setSpacingBefore(40f);
            tb.setSpacingAfter(40f);

            //Image image1 = Image.getInstance("C:\\Users\\vedasrinivas\\Documents\\NetBeansProjects\\TPFTool\\src\\tpftool\\images\\tpf.png");

            //image1.setAlignment(image1.ALIGN_CENTER);
 
            //image1.scaleAbsolute(73,39);
            Paragraph p1=new Paragraph("TPF Software",FontFactory.getFont(FontFactory.TIMES_ROMAN,22,Font.BOLD,BaseColor.BLACK));
            p1.setAlignment(p1.ALIGN_CENTER);
            Paragraph p2=new Paragraph("Date and Time: "+new Date(new java.util.Date().getTime()).toString(),FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.PLAIN,BaseColor.BLACK));

            //doc.add(image1);
            doc.add(p1);
            doc.add(p2);
            doc.addCreationDate();
            doc.addAuthor("TPF Software");
            doc.addTitle("Asset Tracking");
            

            //Add to document
         
            tb.addCell(c1);
            tb.addCell(c2);
            tb.addCell(c3);
            tb.addCell(c4);
            tb.addCell(c5);
            tb.addCell(c6);
            tb.addCell(c7);
            tb.addCell(c8);
            tb.addCell(c9);
            tb.addCell(c10);
            tb.addCell(c11);
            tb.addCell(c12);
            //tb.addCell(c13);
            tb.addCell(c13);
          
            for(int i=0;i<showTable.getRowCount();i++)
            {
                String a=(String) showTable.getValueAt(i, 0);
                Paragraph val = new Paragraph(a, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,Font.PLAIN, BaseColor.BLACK));
                tb.addCell(val);
                String b=(String) showTable.getValueAt(i, 1);
                Paragraph val1 = new Paragraph(b, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,Font.PLAIN, BaseColor.BLACK));
                tb.addCell(val1);
                String c=(String) showTable.getValueAt(i, 2);
                Paragraph val2 = new Paragraph(c, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,Font.PLAIN, BaseColor.BLACK));
                tb.addCell(val2);
                String d=(String) showTable.getValueAt(i, 3);
                Paragraph val3 = new Paragraph(d, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,Font.PLAIN, BaseColor.BLACK));
                tb.addCell(val3);
                String e=(String) showTable.getValueAt(i, 4);
                Paragraph val4 = new Paragraph(e, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,Font.PLAIN, BaseColor.BLACK));
                tb.addCell(val4);
                String f=(String) showTable.getValueAt(i, 5);
                Paragraph val5 = new Paragraph(f, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,Font.PLAIN, BaseColor.BLACK));
                tb.addCell(val5);
                String g=(String) showTable.getValueAt(i, 6);
                Paragraph val6 = new Paragraph(g, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,Font.PLAIN, BaseColor.BLACK));
                tb.addCell(val6);
                String h=(String) showTable.getValueAt(i, 7);
                Paragraph val7 = new Paragraph(h, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,Font.PLAIN, BaseColor.BLACK));
                tb.addCell(val7);
                String q=(String) showTable.getValueAt(i, 8);
                Paragraph val8 = new Paragraph(q, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,Font.PLAIN, BaseColor.BLACK));
                tb.addCell(val8);
                String s=(String) showTable.getValueAt(i, 9);
                Paragraph val9 = new Paragraph(s, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,Font.PLAIN, BaseColor.BLACK));
                tb.addCell(val9);
                String k=(String) showTable.getValueAt(i, 10);
                Paragraph val10 = new Paragraph(k, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,Font.PLAIN, BaseColor.BLACK));
                tb.addCell(val10);
                String l=(String) showTable.getValueAt(i, 11);
                Paragraph val11 = new Paragraph(l, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,Font.PLAIN, BaseColor.BLACK));
                tb.addCell(val11);
                String n=(String) showTable.getValueAt(i, 12);
                Paragraph val13 = new Paragraph(n, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,Font.PLAIN, BaseColor.BLACK));
                tb.addCell(val13);
                
                         
            }
            doc.add(tb);
            JOptionPane.showMessageDialog(null, "Exported to PDF");
        } catch (Exception e) {
            System.out.println(e);
        }
        doc.close();
        }
        
    }//GEN-LAST:event_pdfActionPerformed

    private void add_asset5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_asset5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_add_asset5MouseClicked

    private void add_asset5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_asset5ActionPerformed
        // TODO add your handling code here:
        try {
            Statement stmt1;
            PreparedStatement pst;
            int batchSize = 20;
            
            String atag="";
            String cat="";
            String brand = "";
            String model = "";
            String os = "";
            String msoffice = "";
            String vendor = "";
            String invoicenumber = "";
            java.util.Date purchaseDate = new java.util.Date();
            java.util.Date warrantyDate = new java.util.Date();
            String serial = "";
            Integer imei = null;
            Integer price=null;
            long start = System.currentTimeMillis();
             
            stmt1 = con1.createStatement();
            JFileChooser j = new JFileChooser();
            j.setDialogTitle("Choose");
            int n = j.showSaveDialog(null);
            String path = "";
            if(n==JFileChooser.APPROVE_OPTION)
            {
            path = j.getSelectedFile().toString();
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = new XSSFWorkbook(path);

            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = firstSheet.iterator();
            String sql = "Insert into inventory(category,asset_tag,brand,model,os,ms_office,vendor,invoice_number,purchase_date,warranty_date,serial_number,imei_number,price)values(?,?,?,?,?,?,?,?,?::date,?::date,?,?,?)";
            pst = con1.prepareStatement(sql);
            int count = 0;
             
            rowIterator.next(); // skip the header row

            while (rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                
                while (cellIterator.hasNext()) {
                    System.out.println("In WHile loop");
                    Cell nextCell = cellIterator.next();
                    int columnIndex = nextCell.getColumnIndex();
                    switch (columnIndex) {
                    case 0:
                        break;                  
                    case 1:
                        atag = nextCell.getStringCellValue();
                        pst.setString(2, atag); 
                       
                           break;
                    case 2:
                        cat = nextCell.getStringCellValue();
                        pst.setString(1, cat); 
                     
                        break;
                    case 3:
                        brand = nextCell.getStringCellValue();
                        pst.setString(3, brand);
                        
                        break;
                    case 4:
                        model = nextCell.getStringCellValue();
                        pst.setString(4, model); 
                        
                        break;
                    case 5:
                        os = nextCell.getStringCellValue();
                        pst.setString(5, os);  
                      
                        break;
                    case 6:
                        msoffice= nextCell.getStringCellValue();
                        pst.setString(6, msoffice);
                        
                        break;
                    case 7:

                        vendor = nextCell.getStringCellValue();
                        pst.setString(7, vendor);
                        
                        break;
                    case 8:

                        invoicenumber = nextCell.getStringCellValue();
                        pst.setString(8, invoicenumber);
                        
                        break;
                    case 9:

                        purchaseDate = (Date) nextCell.getDateCellValue();            
                        java.sql.Date sqlPackageDate = new java.sql.Date(purchaseDate.getTime());                      
                        pst.setDate(9, sqlPackageDate);
                       
                        break;
                    case 10:

                        warrantyDate = (Date) nextCell.getDateCellValue();            
                        java.sql.Date sqlPackageDate1 = new java.sql.Date(warrantyDate.getTime());                      
                        pst.setDate(10, sqlPackageDate1);
                        
                        break;
                    case 11:

                        serial = nextCell.getStringCellValue();
                        pst.setString(11, serial);
                        
                        break;
                    case 12:

                        imei = (int) nextCell.getNumericCellValue();
                        pst.setInt(12, imei);
                        
                        break;
                    case 13:

                        price = (int) nextCell.getNumericCellValue();
                        pst.setInt(13, price);
                        break;
  
                    }
                    
                }
                if(cat==null)
            {
                pst.setString(1, null);
            }
                if(atag==null)
            {
                pst.setString(2, null);
            }
                if(brand==null)
            {
                pst.setString(3, null);
            }
                if(model==null)
            {
                pst.setString(4, null);
            }
                if(os==null)
            {
                pst.setString(5, null);
            }
                if(msoffice==null)
            {
                pst.setString(6, null);
            }
                if(vendor==null)
            {
                pst.setString(7, null);
            }
                if(invoicenumber==null)
            {
                pst.setString(8, null);
            }
                if(purchaseDate==null)
            {
                pst.setDate(9, null);
            }
                
                if(warrantyDate==null)
            {
                pst.setDate(10, null);
            }
                if(serial==null)
            {
                pst.setString(11, null);
            }
                 
                 if(imei==null)
            {
                pst.setString(12, null);
            }
                
                if(price==null)
            {
                pst.setNull(13, 0);
            }               
           
                     pst.addBatch();
                 
                if (count % batchSize == 0) {
                    pst.executeBatch();
                }             
                      
            workbook.close();
            pst.executeBatch();
            
            cat = null;
            atag = null;
            brand = null;
            model = null;
            os = null;
            msoffice = null;
            vendor = null;
            invoicenumber = null;
            purchaseDate =null;
            warrantyDate = null;
            serial = null;
            imei = null;
            price= null;   
                        
            }
 long end = System.currentTimeMillis();
            System.out.printf("Import done in %d ms\n", (end - start));
            JOptionPane.showMessageDialog(null, "data added");
            }
           
        }
        
        catch (IOException ex1) {
            System.out.println("Error reading file");
             JOptionPane.showMessageDialog(null, "Please  close running excel file");
            ex1.printStackTrace();
        }catch (SQLException ex2) {
            JOptionPane.showMessageDialog(null, "Import failed. Asset Tags cannot be same");
            ex2.printStackTrace();
        }
            
            catch(Exception e)
                    {
                    System.out.println(e);
                    }
        
        
    }//GEN-LAST:event_add_asset5ActionPerformed

    private void add_asset6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_asset6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_add_asset6MouseClicked

    private void add_asset6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_asset6ActionPerformed
        // TODO add your handling code here:
        try {
            Statement stmt1;
            PreparedStatement pst;
            int batchSize = 20;
            
            String atag="";
            String cat="";
            String brand = "";
            String model = "";
            String eid="";
            String u1 = "";
            String loc = "";
            String acc = "";
            java.util.Date provideDate = new java.util.Date();
            java.util.Date handoverDate = new java.util.Date();
            String status = "";
            String os = "";
            String msoffice = "";
            Integer progress=null;
            long start = System.currentTimeMillis();
             
            stmt1 = con1.createStatement();
            JFileChooser j = new JFileChooser();
            j.setDialogTitle("Choose");
            int n = j.showSaveDialog(null);
            String path = "";
            if(n==JFileChooser.APPROVE_OPTION)
            {
            path = j.getSelectedFile().toString();
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = new XSSFWorkbook(path);

            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = firstSheet.iterator();
            String sql = "INSERT INTO asset(asset_tag,category,brand,model,eid,user_location,handling_user,account,provide_date,handover_date,status,os,ms_office,availability) values (?, ?, ?, ?, ?, ?, ?, ?, ?::date, ?::date, ?, ?, ?, ?)";
            pst = con1.prepareStatement(sql);
            int count = 0;
             
            rowIterator.next(); // skip the header row

            while (rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                
                while (cellIterator.hasNext()) {
    
                    Cell nextCell = cellIterator.next();
                    int columnIndex = nextCell.getColumnIndex();
                    switch (columnIndex) {
                    case 0:
                        break;
                    case 1:
                        atag = nextCell.getStringCellValue();
                        pst.setString(1, atag); 
                        System.out.println(atag);
                        break;
                    case 2:
                        cat = nextCell.getStringCellValue();
                        pst.setString(2, cat); 
                        System.out.println(cat);
                        break;
                    case 3:
                        brand = nextCell.getStringCellValue();
                        pst.setString(3, brand);
                        System.out.println(brand);
                        break;
                    case 4:
                        model = nextCell.getStringCellValue();
                        pst.setString(4, model); 
                        System.out.println(model);
                        break;
                    case 5:
                        eid = nextCell.getStringCellValue();
                        pst.setString(5, eid); 
                        System.out.println(eid);
                        break;
                    case 6:
                        u1 = nextCell.getStringCellValue();
                        pst.setString(7, u1);
                        System.out.println(u1);
                        break;
                    case 7:
                        loc = nextCell.getStringCellValue();
                        pst.setString(6, loc);  
                        System.out.println(loc);
                        
                        break;
                    case 8:
                        acc = nextCell.getStringCellValue();
                        pst.setString(8, acc);
                        System.out.println(acc);
                        
                        break;
                    case 9:
                        
                        provideDate = (Date) nextCell.getDateCellValue();            
                        if(provideDate==null)
                        {
                        pst.setDate(9, null);
                        }
                        else
                        {
                        java.sql.Date sqlPackageDate = new java.sql.Date(provideDate.getTime());                      
                        pst.setDate(9, sqlPackageDate);
                        System.out.println(sqlPackageDate);
                        }
                        break;
                    case 10:
                        handoverDate = (Date) nextCell.getDateCellValue();            
                        if(handoverDate==null)
                        {
                            pst.setDate(10, null);
                        }
                        else
                        {
                        java.sql.Date sqlPackageDate1 = new java.sql.Date(handoverDate.getTime());                      
                        pst.setDate(10, sqlPackageDate1);
                        System.out.println(sqlPackageDate1);
                        }
                        break;
                    case 11:
                        os = nextCell.getStringCellValue();
                        pst.setString(12, os);
                        System.out.println(os);
                        break;
                    case 12:
                        msoffice = nextCell.getStringCellValue();
                        pst.setString(13, msoffice);
                        System.out.println(msoffice);
                        break;

                    }
                    
                }
                if(atag==null)
            {
                pst.setString(1, null);
            }
                if(cat==null)
                {
                    pst.setString(2, null);
                }
                if(brand==null)
            {
                pst.setString(3, null);
            }
                if(model==null)
            {
                pst.setString(4, null);
            }
                if(eid==null)
            {
                pst.setString(5, null);
            }
                if(u1==null)
            {
                pst.setString(7, null);
            }
                if(loc==null)
            {
                pst.setString(6, null);
            }
                if(acc==null)
            {
                pst.setString(8, null);
            }
                if(provideDate==null)
            {
                pst.setDate(9, null);
            }
                if(handoverDate==null)
            {
                pst.setString(10, null);
            }
                 if(os==null)
            {
                pst.setString(12, null);
            }
                 if(msoffice==null)
            {
                pst.setString(13, null);
            }

                 if((provideDate==null) && (handoverDate==null) && (u1==null))
                 {
                     pst.setString(14, "free");
                 }
                 if(provideDate!=null && handoverDate == null)
                 {
                   pst.setString(14, "assigned");
                 }
                 if((provideDate!=null) && (handoverDate!=null) && (u1!=null))
                 {
                     pst.setString(14, "history");
                 }
                 pst.setString(11, "working");
                 
                     pst.addBatch();
                 
                if (count % batchSize == 0) {
                    pst.executeBatch();
                }             
                      
            workbook.close();
            pst.executeBatch();
            
            cat = null;
            atag = null;
            brand = null;
            model = null;
            eid = null;
            u1 = null;
            loc = null;
            acc=null;
           provideDate = null;
            handoverDate = null;
            status = null;
            os = null;
            msoffice = null;
            progress= null;   
            
            }
long end = System.currentTimeMillis();
            System.out.printf("Import done in %d ms\n", (end - start));
            JOptionPane.showMessageDialog(null, "Data Added");
            }
            
             
        }
        
        catch (IOException ex1) {
            System.out.println("Error reading file");
            JOptionPane.showMessageDialog(null, "Please  close running excel file");
            ex1.printStackTrace();
        }catch (SQLException ex2) {
            System.out.println("Database error");
            System.out.println(ex2);
            ex2.printStackTrace();
        }
            
            catch(Exception e)
                    {
                        System.out.println(e);
                    }
    }//GEN-LAST:event_add_asset6ActionPerformed

    private void pdf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdf1ActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel mod = (DefaultTableModel) STable.getModel();
        FileOutputStream fo=null;
        String path = "";
        String nm = "";
        JFileChooser j = new JFileChooser();
        SimpleDateFormat formatter = new SimpleDateFormat("HH-mm-ss");  
        Date date = new Date();  
        j.setSelectedFile(new File("Software_Inventory_Report_"+java.time.LocalDate.now().toString().trim()+"_"+formatter.format(date).toString().trim()));

        int y = STable.getColumnCount();
        j.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
        int x = j.showSaveDialog(null);
        if(x==JFileChooser.APPROVE_OPTION)
        {

            Rectangle rect = new Rectangle(1000, 1000);
            Document doc = new Document(rect, 30, 30, 30, 30);

        try {
           
            PdfWriter writer = PdfWriter.getInstance(doc,new FileOutputStream(j.getSelectedFile()+".pdf"));
            
            doc.setMargins(20,20,20,20);
            doc.open();
            
            
            float cwidth[] = {11f,7f,7f,6f,8f,6f,8f,7f};
            Font bold = new Font("Times New Roman",12,Font.BOLD);
            PdfPTable tb = new PdfPTable(8);
            
            PdfPCell c1=new PdfPCell(new Phrase("Software Name",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK)));
            c1.setBackgroundColor(new BaseColor(211,211,211));
            PdfPCell c2=new PdfPCell(new Phrase("Quantity",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK)));
            c2.setBackgroundColor(new BaseColor(211,211,211));
            PdfPCell c3=new PdfPCell(new Phrase("Vendor Name",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK)));
            c3.setBackgroundColor(new BaseColor(211,211,211));
            PdfPCell c4=new PdfPCell(new Phrase("Invoice Number",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK)));
            c4.setBackgroundColor(new BaseColor(211,211,211));
            PdfPCell c5=new PdfPCell(new Phrase("Purchase Date",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK)));
            c5.setBackgroundColor(new BaseColor(211,211,211));
            PdfPCell c6=new PdfPCell(new Phrase("Expiry Date",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK)));
            c6.setBackgroundColor(new BaseColor(211,211,211));
            PdfPCell c7=new PdfPCell(new Phrase("Serial Number",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK)));
            c7.setBackgroundColor(new BaseColor(211,211,211));
            PdfPCell c8=new PdfPCell(new Phrase("Price",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK)));
            c8.setBackgroundColor(new BaseColor(211,211,211));
           
            tb.setWidths(cwidth);
            tb.setWidthPercentage(100);
            tb.setSpacingBefore(40f);
            tb.setSpacingAfter(40f);

            //Image image1 = Image.getInstance("C:\\Users\\vedasrinivas\\Documents\\NetBeansProjects\\TPFTool\\src\\tpftool\\images\\tpf.png");

            //image1.setAlignment(image1.ALIGN_CENTER);
 
            //image1.scaleAbsolute(73,39);
            Paragraph p1=new Paragraph("TPF Software",FontFactory.getFont(FontFactory.TIMES_ROMAN,22,Font.BOLD,BaseColor.BLACK));
            p1.setAlignment(p1.ALIGN_CENTER);
            Paragraph p2=new Paragraph("Date and Time: "+new Date(new java.util.Date().getTime()).toString(),FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.PLAIN,BaseColor.BLACK));

            //doc.add(image1);
            doc.add(p1);
            doc.add(p2);
            doc.addCreationDate();
            doc.addAuthor("TPF Software");
            doc.addTitle("Asset Tracking");
            

            //Add to document
         
            tb.addCell(c1);
            tb.addCell(c2);
            tb.addCell(c3);
            tb.addCell(c4);
            tb.addCell(c5);
            tb.addCell(c6);
            tb.addCell(c7);
            tb.addCell(c8);
           
          
            for(int i=0;i<STable.getRowCount();i++)
            {
                String a=(String) STable.getValueAt(i, 0);
                Paragraph val = new Paragraph(a, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,Font.PLAIN, BaseColor.BLACK));
                tb.addCell(val);
                String b=(String) STable.getValueAt(i, 1);
                Paragraph val1 = new Paragraph(b, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,Font.PLAIN, BaseColor.BLACK));
                tb.addCell(val1);
                String c=(String) STable.getValueAt(i, 2);
                Paragraph val2 = new Paragraph(c, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,Font.PLAIN, BaseColor.BLACK));
                tb.addCell(val2);
                String d=(String) STable.getValueAt(i, 3);
                Paragraph val3 = new Paragraph(d, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,Font.PLAIN, BaseColor.BLACK));
                tb.addCell(val3);
                String e=(String) STable.getValueAt(i, 4);
                Paragraph val4 = new Paragraph(e, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,Font.PLAIN, BaseColor.BLACK));
                tb.addCell(val4);
                String f=(String) STable.getValueAt(i, 5);
                Paragraph val5 = new Paragraph(f, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,Font.PLAIN, BaseColor.BLACK));
                tb.addCell(val5);
                String g=(String) STable.getValueAt(i, 6);
                Paragraph val6 = new Paragraph(g, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,Font.PLAIN, BaseColor.BLACK));
                tb.addCell(val6);
                String h=(String) STable.getValueAt(i, 7);
                Paragraph val7 = new Paragraph(h, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,Font.PLAIN, BaseColor.BLACK));
                tb.addCell(val7);
                
                
                         
            }
            doc.add(tb);
            JOptionPane.showMessageDialog(null, "Exported to PDF");
        } catch (Exception e) {
            System.out.println(e);
        }
        doc.close();
        }
        
    }//GEN-LAST:event_pdf1ActionPerformed

    private void excel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excel1ActionPerformed
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
        excelFileChooser.setSelectedFile(new File("Software_Inventory_Report_"+java.time.LocalDate.now().toString().trim()+"_"+formatter.format(date).toString().trim()));
        int excelChooser = excelFileChooser.showSaveDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            try {
                wb = new XSSFWorkbook();
                XSSFSheet sheet = wb.createSheet("Data Sheet");
                XSSFRow excelRow = sheet.createRow(0);

                for (int c = 0; c < STable.getColumnCount(); c++) {
                    excelCell = excelRow.createCell(c);
                    excelCell.setCellValue(STable.getColumnName(c));  
                }


                for (int i = 0; i < STable.getRowCount(); i++) {
                    System.out.println(i);
                    excelRow = sheet.createRow(i + 1);

                    for (int j = 0; j < STable.getColumnCount(); j++) {
                        if (STable.getValueAt(i, j) == "null") {
                            STable.setValueAt(" ", i, j);
                        } else {
                            excelCell = excelRow.createCell(j);
                            Object o = STable.getValueAt(i, j);
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
        } //-- end if condition
        
        
        
    }//GEN-LAST:event_excel1ActionPerformed

    private void yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearActionPerformed

    private void yearKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearKeyReleased
        // TODO add your handling code here:
        String name = year.getText();
        DefaultTableModel dtm = (DefaultTableModel) showTable.getModel();
        int r = showTable.getRowCount();
        
        while(r-->0)
        {
            dtm.removeRow(r);
        }
        
        try
        {
            st = con1.createStatement();
                pst = con1.prepareStatement("SELECT category,asset_tag,brand,model,os,ms_office,vendor,invoice_number,purchase_date,warranty_date,serial_number,imei_number,price FROM inventory where purchase_date::varchar like ?");
                pst.setString(1,"%"+name+"%");
                ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                java.util.Vector v = new java.util.Vector();
                v.add(rs.getString("category"));
                v.add(rs.getString("asset_tag"));
                v.add(rs.getString("brand"));
                v.add(rs.getString("model"));
                v.add(rs.getString("os"));
                v.add(rs.getString("ms_office"));
                v.add(rs.getString("vendor"));
                v.add(rs.getString("invoice_number"));
                v.add(rs.getString("purchase_date"));
                v.add(rs.getString("warranty_date"));
                v.add(rs.getString("serial_number"));
                v.add(rs.getString("imei_number"));
                v.add(rs.getString("price"));
//                v.add(rs.getString("invoice"));
                
                
                
                dtm.addRow(v);
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Database error");
            System.out.println(ex);
        }
        
    }//GEN-LAST:event_yearKeyReleased

    private void expendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expendActionPerformed
        // TODO add your handling code here:
        int a=showTable.getRowCount();
          double s=0;
          for (int i=0;i<a;i++)
          {
              double a1=Double.valueOf(showTable.getValueAt(i,12).toString());
              s+=a1;
          }
          expend1.setText(Double.toString(s));
        
    }//GEN-LAST:event_expendActionPerformed

    private void logimg2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logimg2MouseClicked
        // TODO add your handling code here:
        if(Global.user.User == "superadmin"){
            Homescreen3 a = new Homescreen3();
            a.setVisible(true);}
        else{Homescreen31 f = new Homescreen31(); f.setVisible(true);}
        this.dispose();
        //new Homescreen3().setVisible(true);
    }//GEN-LAST:event_logimg2MouseClicked

    private void logimg2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logimg2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_logimg2MouseEntered

    private void logimg2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logimg2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_logimg2MouseExited

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
                                
public void disall(){
     try {
         
            Database db = loading.db;
            Connection con = db.connection;
             
        String assetname= asearch.getText();
        String cat = category1.getSelectedItem().toString().toLowerCase();
        if( "all".equals(cat) ){
            stmt = con.prepareStatement("SELECT category,asset_tag,brand,model,os,ms_office,vendor,invoice_number,purchase_date,warranty_date,serial_number,imei_number,price FROM inventory where asset_tag like ?");
            stmt.setString(1, "%"+assetname+"%");
        }
        if( !"all".equals(cat)){
             stmt = con.prepareStatement("Select category,asset_tag,brand,model,os,ms_office,vendor,invoice_number,purchase_date,warranty_date,serial_number,imei_number,price FROM inventory "
                    + "where asset_tag like ? AND category like ? ");
            stmt.setString(1, "%"+assetname+"%");
            stmt.setString(2, cat);
        }
            ResultSet rs = stmt.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            showTable.setModel(model);     
            model.addColumn("Category");
            model.addColumn("Asset Tag");
            model.addColumn("Brand");
            model.addColumn("Model");
            model.addColumn("OS");
            model.addColumn("MS Office");
            model.addColumn("Vendor");
            model.addColumn("Invoice_Number");
            model.addColumn("Purchase_Date");
            model.addColumn("Warranty_Date");
            model.addColumn("Serial_Number");
            model.addColumn("IMEI_Number");
            model.addColumn("price");

            while (rs.next()) {
                model.addRow(new String[]{rs.getString(1), Capitalize.capitalize.capitalize(rs.getString(2)),Capitalize.capitalize.capitalize(rs.getString(3)), Capitalize.capitalize.capitalize(rs.getString(4)), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13)});
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
}
    private void category1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_category1ActionPerformed
        disall();
    }//GEN-LAST:event_category1ActionPerformed

    private void imei_numberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_imei_numberKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE))
        {
            evt.consume();
            JOptionPane.showMessageDialog(this,"You can enter only Numbers");
        }
    }//GEN-LAST:event_imei_numberKeyTyped

    private void priceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE))
        {
            evt.consume();
            JOptionPane.showMessageDialog(this,"You can enter only Numbers");
        }
    }//GEN-LAST:event_priceKeyTyped

    private void warranty_dateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_warranty_dateFocusLost
        // TODO add your handling code here:
        String w_date = fmt.format(warranty_date.getDate());
        String p_date = fmt.format(purchase_date.getDate());
        //compare(p_date, w_date);
    }//GEN-LAST:event_warranty_dateFocusLost

    private void update_assetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_assetActionPerformed
        // TODO add your handling code here:
        try
        {
            String Vendor;
            String Invoice_Number;
            String Pdate;
            String Wdate;
            String Model;
            String Os;
            String Office;
            String Brand;
            String Imei;
            DefaultTableModel RecordTable=(DefaultTableModel) showTable.getModel();
            String Product=RecordTable.getValueAt(showTable.getSelectedRow(),0).toString();
            String AssetTag=RecordTable.getValueAt(showTable.getSelectedRow(),1).toString();
            try
            {
                Brand=RecordTable.getValueAt(showTable.getSelectedRow(),2).toString();
            }
            catch(Exception e)
            {
                Brand="";
            }
            try
            {
                Model=RecordTable.getValueAt(showTable.getSelectedRow(),3).toString();
            }
            catch(Exception e)
            {
                Model="";
            }
            try {
                Os=RecordTable.getValueAt(showTable.getSelectedRow(),4).toString();
            } catch (Exception e) {
                Os="";
            }
            try {
                Office=RecordTable.getValueAt(showTable.getSelectedRow(),5).toString();
            } catch (Exception e) {
                Office="";
            }
            try {
                Vendor=RecordTable.getValueAt(showTable.getSelectedRow(),6).toString();
            } catch (Exception e) {
                Vendor="";
            }
            try {
                Invoice_Number=RecordTable.getValueAt(showTable.getSelectedRow(),7).toString();
            } catch (Exception e) {
                Invoice_Number="";
            }
            try {
                Pdate=RecordTable.getValueAt(showTable.getSelectedRow(),8).toString();
            } catch (Exception e) {
                Pdate="";
            }
            try {
                Wdate=RecordTable.getValueAt(showTable.getSelectedRow(),9).toString();
            } catch (Exception e) {
                Wdate="";
            }
            String Serialnum=RecordTable.getValueAt(showTable.getSelectedRow(),10).toString();
            try {
                Imei=RecordTable.getValueAt(showTable.getSelectedRow(),11).toString();
            } catch (Exception e) {
                Imei="";
            }
            
            String Price=RecordTable.getValueAt(showTable.getSelectedRow(),12).toString();

            update2.update_product=Product;
            update2.update_assettag=AssetTag;
            update2.update_brand=Brand;
            update2.update_model=Model;
            update2.update_os=Os;
            update2.update_office=Office;
            update2.update_vendor=Vendor;
            update2.update_invoice=Invoice_Number;
            update2.update_pdate=Pdate;
            update2.update_wdate=Wdate;
            update2.update_serial=Serialnum;
            update2.update_imei=Imei;
            update2.update_price=Price;

            update_invent u1 = new update_invent();
            u1.setVisible(true);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Select asset to update");
//            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_update_assetActionPerformed

    public static Dis update_f1;
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
            java.util.logging.Logger.getLogger(Dis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dis d1 = new Dis();
               d1.setVisible(true);
               update_f1 = d1;
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel Ap;
    private javax.swing.JPanel Apanel;
    private javax.swing.JPanel Asset;
    public static javax.swing.JPanel Dp;
    private javax.swing.JTable STable;
    private javax.swing.JComboBox<String> Scategory;
    private javax.swing.JTextField Sfilepath;
    private javax.swing.JTextField Sinvoice_number;
    public static javax.swing.JPanel Sp1;
    private javax.swing.JTextField Sprice;
    private com.toedter.calendar.JDateChooser Spurchase_date;
    private javax.swing.JTextField Sserial_number;
    private javax.swing.JTextField Svendor;
    private javax.swing.JPanel User1;
    private javax.swing.JPanel User2;
    public static javax.swing.JPanel Vp;
    private javax.swing.JLabel add;
    private javax.swing.JButton add_asset;
    private javax.swing.JButton add_asset1;
    private javax.swing.JButton add_asset4;
    private javax.swing.JButton add_asset5;
    private javax.swing.JButton add_asset6;
    private javax.swing.JTextField asearch;
    private javax.swing.JTextField asset_tag;
    private javax.swing.JLabel avail;
    private javax.swing.JLabel avail1;
    private javax.swing.JComboBox<String> brand;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JComboBox<String> category1;
    private javax.swing.JButton choose;
    private javax.swing.JButton choose1;
    private javax.swing.JButton deleteasset_btn;
    private javax.swing.JButton deleteasset_btn1;
    private javax.swing.JLabel display1;
    private javax.swing.JLabel display2;
    private javax.swing.JButton excel;
    private javax.swing.JButton excel1;
    private javax.swing.JButton expend;
    private javax.swing.JTextField expend1;
    private com.toedter.calendar.JDateChooser expiry_date;
    private javax.swing.JTextField filepath;
    private javax.swing.JTextField imei_number;
    private javax.swing.JTextField invoice_number;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logimg;
    private javax.swing.JLabel logimg2;
    private javax.swing.JPanel loginpanel;
    private javax.swing.JLabel logtext;
    private javax.swing.JTextField model;
    private javax.swing.JComboBox<String> msoffice;
    private javax.swing.JComboBox<String> os;
    private javax.swing.JTextField p_search;
    private javax.swing.JButton pdf;
    private javax.swing.JButton pdf1;
    private javax.swing.JTextField price;
    private com.toedter.calendar.JDateChooser purchase_date;
    private javax.swing.JTextField quantity;
    private javax.swing.JTextField serial_number;
    private javax.swing.JTable showTable;
    private javax.swing.JLabel update;
    private javax.swing.JButton update_asset;
    private javax.swing.JTextField vendor;
    private com.toedter.calendar.JDateChooser warranty_date;
    private javax.swing.JTextField year;
    // End of variables declaration//GEN-END:variables
}
