package asset_status_module.availability;
import Database.Database;
import asset_status_module.status_change.join;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;
import main.Homescreen3;
import main.Homescreen31;
import main.loading;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import return_module.globalremove.update;

public class Availability extends javax.swing.JFrame {
    public static Database db = new Database();
    Connection con1 = db.connection;
    public static PreparedStatement pst1;

    public static Statement stmt1;
    public static Statement st;
    public static PreparedStatement pst,inpst;
    public static int assigned = 0;
  public static int not_assigned = 0;
  public static int in_service = 0;
  public static int scrap = 0;
  public static int products_team = 0;
  public static int supporting_team = 0;
  public static int amex = 0;
  public static int citibank = 0;
  public static int airnz = 0;
  public static int aerlingus = 0;
  public static int bench_ps = 0;
  public static int sabre_infosys = 0;
  public static int travelport = 0;
  public static int devops = 0;
  public static  JFreeChart chart;
    public void piecall(){
        
  
    
          try{
        Database db = loading.db;
        Connection con = db.connection;
        PreparedStatement pst = con.prepareStatement("select count(*) from asset where status like ? "
                + "and provide_date IS NOT NULL and handover_date IS NULL");
        pst.setString(1,"working");
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            assigned = rs.getInt(1);
        }
         PreparedStatement pst3 = con.prepareStatement("select count(*) from asset where status like ? "
                + "and provide_date IS NULL and handover_date IS NULL");
        pst3.setString(1,"working");
        ResultSet rs3 = pst3.executeQuery();
        while(rs3.next()){
            not_assigned = rs3.getInt(1);
        }
        PreparedStatement pst1= con.prepareStatement("select count(*) from asset where status like ?");
        pst1.setString(1,"in-service");
        ResultSet rs1 = pst1.executeQuery();
        while(rs1.next()){
            in_service = rs1.getInt(1);
        }
        PreparedStatement pst2 = con.prepareStatement("select count(*) from asset where status like ?");
        pst2.setString(1,"scrap");
        ResultSet rs2 = pst2.executeQuery();
        while(rs2.next()){
            scrap = rs2.getInt(1);
        }
        
        PreparedStatement pst8 = con.prepareStatement("select count(*) from asset where account like ? and availability = 'no' ");
        pst8.setString(1,"Products Team");
        ResultSet rs8 = pst8.executeQuery();
        while(rs8.next()){
             products_team = rs8.getInt(1);
        }
        PreparedStatement pst4 = con.prepareStatement("select count(*) from asset where account like ? and availability = 'no' ");
        pst4.setString(1,"Supporting Team");
        ResultSet rs4 = pst4.executeQuery();
        while(rs4.next()){
            supporting_team = rs4.getInt(1);
        }
        PreparedStatement pst5 = con.prepareStatement("select count(*) from asset where account like ? and availability = 'no' ");
        pst5.setString(1,"Amex");
        ResultSet rs5 = pst5.executeQuery();
        while(rs5.next()){
            amex = rs5.getInt(1);
        }
        PreparedStatement pst6 = con.prepareStatement("select count(*) from asset where account like ? and availability = 'no' ");
        pst6.setString(1,"Citibank");
        ResultSet rs6 = pst6.executeQuery();
        while(rs6.next()){
            citibank = rs6.getInt(1);
        }
        PreparedStatement pst7 = con.prepareStatement("select count(*) from asset where account like ? and availability = 'no' ");
        pst7.setString(1,"AirNZ");
        ResultSet rs7 = pst7.executeQuery();
        while(rs7.next()){
            airnz = rs7.getInt(1);
        }
        PreparedStatement pst9 = con.prepareStatement("select count(*) from asset where account like ? and availability = 'no'");
        pst9.setString(1,"AerLingus");
        ResultSet rs9 = pst9.executeQuery();
        while(rs9.next()){
            aerlingus  = rs9.getInt(1);
        }
        PreparedStatement pst10 = con.prepareStatement("select count(*) from asset where account like ? and availability = 'no'");
        pst10.setString(1,"Bench-PS");
        ResultSet rs10 = pst10.executeQuery();
        while(rs10.next()){
           bench_ps  = rs10.getInt(1);
        }
         PreparedStatement pst11 = con.prepareStatement("select count(*) from asset where account like ? and availability = 'no' ");
        pst11.setString(1,"Sabre_Infosys");
        ResultSet rs11 = pst11.executeQuery();
        while(rs11.next()){
           sabre_infosys  = rs11.getInt(1);
        } PreparedStatement pst12 = con.prepareStatement("select count(*) from asset where account like ? and availability = 'no' ");
        pst12.setString(1,"Travelport");
        ResultSet rs12 = pst12.executeQuery();
        while(rs12.next()){
           travelport = rs12.getInt(1);
        } PreparedStatement pst13 = con.prepareStatement("select count(*) from asset where account like ? and availability = 'no' ");
        pst13.setString(1,"DevOPS");
        ResultSet rs13 = pst13.executeQuery();
        while(rs13.next()){
           devops  = rs13.getInt(1);
        }
  }catch(Exception e){System.out.println(e);}
        DefaultPieDataset dataset=new DefaultPieDataset(); 
        DefaultPieDataset invdataset = new DefaultPieDataset();
    dataset.setValue("assigned: "+assigned, assigned);  
    dataset.setValue("not assigned: "+not_assigned,not_assigned );
    dataset.setValue("in-service: "+in_service, in_service);  
    dataset.setValue("scrap: "+scrap, scrap); 
    
    // Create chart  
   chart = ChartFactory.createPieChart(  
        "Asset Status",  
        dataset,  
        true,   
        true,  
        false);  
  
    //Format Label  
    PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(  
        " {0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));  
    ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);  
    
    
    invdataset.setValue("Products Team: "+products_team,products_team);
    invdataset.setValue("Supporting Team: "+supporting_team,supporting_team);
    invdataset.setValue("Amex: "+amex, amex);
    invdataset.setValue("Citibank: "+citibank,citibank);
    invdataset.setValue("AirNZ: "+airnz,airnz);
    invdataset.setValue("AerLingus: "+aerlingus,aerlingus);
    invdataset.setValue("Bench_PS: "+bench_ps,bench_ps);
    invdataset.setValue("Sabre_infosys: "+sabre_infosys,sabre_infosys);
    invdataset.setValue("Travelport: "+travelport,travelport);
    invdataset.setValue("DevOPS: "+devops,devops);
  
    JFreeChart invchart = ChartFactory.createPieChart(  
        "Inventory",  
        invdataset,  
        true,   
        true,  
        false);  
  
    //Format Label  
    PieSectionLabelGenerator invlabelGenerator = new StandardPieSectionLabelGenerator(  
        " {0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));  
    ((PiePlot) invchart.getPlot()).setLabelGenerator(invlabelGenerator); 
     ChartPanel panel = new ChartPanel(chart);  
    ChartPanel invpanel = new ChartPanel(invchart);
    
    inventoryPanel.removeAll();
    inventoryPanel.add(invpanel,BorderLayout.CENTER);
    inventoryPanel.validate();
  
    
    }
    public Availability() {
        initComponents();
        Vp.setVisible(true);
        Ap.setVisible(false);
        Up.setVisible(false);
        Pie.setVisible(false);
        //textKeyReleased(null);
        setExtendedState(Availability.MAXIMIZED_BOTH);
        
        String sql="SELECT asset_tag ,category,brand,model,status,os,ms_office FROM asset where availability='assigned' and handover_date IS NULL and provide_date IS NOT  NULL and status='in-service';";
       
        try
        {
            
            stmt1 = con1.createStatement();
            pst1=con1.prepareStatement(sql);
            ResultSet rs1=pst1.executeQuery();
            
            
            DefaultTableModel model=(DefaultTableModel) showTable.getModel();
            model.setRowCount(0);
            while(rs1.next())
            {
              model.addRow(new String[]{rs1.getString(1),rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getString(5),rs1.getString(6),rs1.getString(7)});
            }
            
        } catch(Exception e)
        {System.out.println(e);}
        DefaultTableModel dtm3 = (DefaultTableModel) showTable.getModel();
        int r3 = showTable.getRowCount();
        avail.setText(""+r3+"");
    }
   
//    
    public  void update(String a,String a1, String a2, String a3, String a4, String a5,String a6)
    {
        update.n = a;
        update.n1 = a1;
        update.n2 = a2;
        update.n3 = a3;
        update.n4 = a4;
        update.n5 = a5;
        update.n6 = a6;
    }
//        System.out.println(update.n);
//    }
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
        logimg1 = new javax.swing.JLabel();
        Apanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        Apanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        Vp = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        asearch = new javax.swing.JTextField();
        esearch = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        avail = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        showTable = new javax.swing.JTable();
        Ap = new javax.swing.JPanel();
        Up = new javax.swing.JPanel();
        Pie = new javax.swing.JPanel();
        statusPanel = new javax.swing.JPanel();
        inventoryPanel = new javax.swing.JPanel();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 161, 225));
        jPanel2.setPreferredSize(new java.awt.Dimension(516, 79));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Asset Status");

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
        logimg.setIcon(new javax.swing.ImageIcon("C:\\Users\\abaru\\Videos\\asset-management\\src\\tpftool\\images\\userwhite (1).png")); // NOI18N
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
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
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
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(loginpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(0, 161, 225));

        logimg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tpftool/images/Images/back_white1.png"))); // NOI18N
        logimg1.setText("jLabel23");
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

        Apanel1.setBackground(new java.awt.Color(0, 161, 225));
        Apanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 255, 255)));
        Apanel1.setPreferredSize(new java.awt.Dimension(234, 46));
        Apanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Apanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Apanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Apanel1MouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Status Change");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });

        javax.swing.GroupLayout Apanel1Layout = new javax.swing.GroupLayout(Apanel1);
        Apanel1.setLayout(Apanel1Layout);
        Apanel1Layout.setHorizontalGroup(
            Apanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Apanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Apanel1Layout.setVerticalGroup(
            Apanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        Apanel4.setBackground(new java.awt.Color(0, 161, 225));
        Apanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 255, 255)));
        Apanel4.setPreferredSize(new java.awt.Dimension(234, 46));
        Apanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Apanel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Apanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Apanel4MouseExited(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Pie Chart");
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

        javax.swing.GroupLayout Apanel4Layout = new javax.swing.GroupLayout(Apanel4);
        Apanel4.setLayout(Apanel4Layout);
        Apanel4Layout.setHorizontalGroup(
            Apanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Apanel4Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Apanel4Layout.setVerticalGroup(
            Apanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Apanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logimg1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(215, Short.MAX_VALUE))
            .addComponent(Apanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logimg1)
                .addGap(18, 18, 18)
                .addComponent(Apanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(Apanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(464, Short.MAX_VALUE))
        );

        Vp.setBackground(new java.awt.Color(255, 255, 255));
        Vp.setPreferredSize(new java.awt.Dimension(978, 637));

        jPanel5.setBackground(new java.awt.Color(0, 161, 225));
        jPanel5.setPreferredSize(new java.awt.Dimension(184, 3));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jLabel12.setFont(new java.awt.Font("Kievit Offc Pro", 0, 18)); // NOI18N
        jLabel12.setText("Search by Employee            :");

        jLabel13.setFont(new java.awt.Font("Kievit Offc Pro", 0, 18)); // NOI18N
        jLabel13.setText("Search by Asset ID              :");

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

        esearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esearchActionPerformed(evt);
            }
        });
        esearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                esearchKeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setText("Total Assets :");

        avail.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jButton1.setText("Change status");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        showTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Asset Tag", "Brand", "Model", "Account", "eid", "provide_date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        showTable.getTableHeader().setReorderingAllowed(false);
        showTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(showTable);

        javax.swing.GroupLayout VpLayout = new javax.swing.GroupLayout(Vp);
        Vp.setLayout(VpLayout);
        VpLayout.setHorizontalGroup(
            VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VpLayout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VpLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(772, Short.MAX_VALUE))
                    .addGroup(VpLayout.createSequentialGroup()
                        .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE)
                            .addGroup(VpLayout.createSequentialGroup()
                                .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(VpLayout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(avail))
                                    .addGroup(VpLayout.createSequentialGroup()
                                        .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel12))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(asearch, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(esearch, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jButton1))
                                .addGap(0, 439, Short.MAX_VALUE)))
                        .addGap(20, 20, 20))))
        );
        VpLayout.setVerticalGroup(
            VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VpLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(asearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(esearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(VpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(avail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 38, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        Ap.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout ApLayout = new javax.swing.GroupLayout(Ap);
        Ap.setLayout(ApLayout);
        ApLayout.setHorizontalGroup(
            ApLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 988, Short.MAX_VALUE)
        );
        ApLayout.setVerticalGroup(
            ApLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 637, Short.MAX_VALUE)
        );

        Up.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout UpLayout = new javax.swing.GroupLayout(Up);
        Up.setLayout(UpLayout);
        UpLayout.setHorizontalGroup(
            UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 988, Short.MAX_VALUE)
        );
        UpLayout.setVerticalGroup(
            UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 643, Short.MAX_VALUE)
        );

        Pie.setBackground(new java.awt.Color(255, 255, 255));

        statusPanel.setPreferredSize(new java.awt.Dimension(300, 250));
        statusPanel.setLayout(new java.awt.BorderLayout());

        inventoryPanel.setPreferredSize(new java.awt.Dimension(300, 250));
        inventoryPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout PieLayout = new javax.swing.GroupLayout(Pie);
        Pie.setLayout(PieLayout);
        PieLayout.setHorizontalGroup(
            PieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PieLayout.createSequentialGroup()
                .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inventoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                .addContainerGap())
        );
        PieLayout.setVerticalGroup(
            PieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PieLayout.createSequentialGroup()
                .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PieLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inventoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(232, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Up, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Ap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Vp, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Pie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Up, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Ap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Vp, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Pie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1255, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
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

    private void logimg1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logimg1MouseClicked
        // TODO add your handling code here:
        this.dispose();
         if(Global.user.User == "superadmin"){
        Homescreen3 a = new Homescreen3();
        a.setVisible(true);}
        else{Homescreen31 f = new Homescreen31(); f.setVisible(true);}
        //new Homescreen3().setVisible(true);
    }//GEN-LAST:event_logimg1MouseClicked

    private void logimg1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logimg1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_logimg1MouseEntered

    private void logimg1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logimg1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_logimg1MouseExited

    private void asearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_asearchKeyReleased
        // TODO add your handling code here:
        String name = asearch.getText().toUpperCase();

        DefaultTableModel dtm = (DefaultTableModel) showTable.getModel();
        int r = showTable.getRowCount();

        while (r-- > 0) {
            dtm.removeRow(r);
        }

        try {
            st = con1.createStatement();
            pst = con1.prepareStatement("Select asset_tag,brand,model,account,eid,provide_date from asset where availability='assigned' and (asset_tag) like ? "
                    + "and handover_date IS NULL and provide_date IS NOT NULL and status like ?;");
            pst.setString(1, "%" + name + "%");
            pst.setString(2, "in-service");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                java.util.Vector v = new java.util.Vector();
                v.add(rs.getString("asset_tag"));
                v.add(rs.getString("brand"));
                v.add(rs.getString("model"));
                v.add(rs.getString("account"));
                v.add(rs.getString("eid"));
                v.add(rs.getString("provide_date"));
                dtm.addRow(v);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database error");
        }
    }//GEN-LAST:event_asearchKeyReleased

    private void esearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_esearchKeyReleased
        // TODO add your handling code here:
         String name2 = esearch.getText();
        DefaultTableModel dtm2 = (DefaultTableModel) showTable.getModel();
        int r2 = showTable.getRowCount();
        while (r2-- > 0) {
            dtm2.removeRow(r2);
        }
        try {
            st = con1.createStatement();
            PreparedStatement pst0 = con1.prepareStatement("Select asset_tag,brand,model,account,eid,provide_date from asset where availability='assigned' and eid like ? "
                    + "and handover_date IS NULL and provide_date IS NOT NULL and status like ?");
            pst0.setString(1, "%" + name2 + "%");
            pst0.setString(2, "in-service");
            ResultSet rs = pst0.executeQuery();
            while (rs.next()) {
                java.util.Vector v1 = new java.util.Vector();
                v1.add(rs.getString("asset_tag"));
                v1.add(rs.getString("brand"));
                v1.add(rs.getString("model"));
                v1.add(rs.getString("account"));
                v1.add(rs.getString("eid"));
                v1.add(rs.getString("provide_date"));

                dtm2.addRow(v1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database error");
        }
    }//GEN-LAST:event_esearchKeyReleased

    private void esearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_esearchActionPerformed

    private void asearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asearchActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        Pie.setVisible(false);
        Vp.setVisible(true);
        Ap.setVisible(false);
        Up.setVisible(false);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        // TODO add your handling code here:
        Apanel1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
        Apanel1.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        // TODO add your handling code here:
        Apanel1.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.white));
        Apanel1.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_jLabel7MouseExited

    private void Apanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Apanel1MouseClicked
        // TODO add your handling code here:

        Pie.setVisible(false);
        Vp.setVisible(true);
        Ap.setVisible(false);
        Up.setVisible(false);
    }//GEN-LAST:event_Apanel1MouseClicked

    private void Apanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Apanel1MouseEntered
        // TODO add your handling code here:
        Apanel1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
        Apanel1.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_Apanel1MouseEntered

    private void Apanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Apanel1MouseExited
        // TODO add your handling code here:
        //All.setBorder(BorderFactory.createEmptyBorder());
        Apanel1.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.white));
        Apanel1.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_Apanel1MouseExited

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        Pie.setVisible(true);
        Vp.setVisible(false);
        Ap.setVisible(false);
        Up.setVisible(false);
         piecall();
         ChartPanel panel = new ChartPanel(chart);  
    
    statusPanel.removeAll();
    statusPanel.add(panel,BorderLayout.CENTER);
    statusPanel.validate();
//    
//    inventoryPanel.removeAll();
//    inventoryPanel.add(invpanel,BorderLayout.CENTER);
//    inventoryPanel.validate();

    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        // TODO add your handling code here:
        Apanel4.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
        Apanel4.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        // TODO add your handling code here:
        Apanel4.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.white));
        Apanel4.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_jLabel10MouseExited

    private void Apanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Apanel4MouseClicked
        // TODO add your handling code here:
        Pie.setVisible(true);
        Vp.setVisible(false);
        Ap.setVisible(false);
        Up.setVisible(false);
         piecall();
         ChartPanel panel = new ChartPanel(chart);  
    
    statusPanel.removeAll();
    statusPanel.add(panel,BorderLayout.CENTER);
    statusPanel.validate();
//    
//    inventoryPanel.removeAll();
//    inventoryPanel.add(invpanel,BorderLayout.CENTER);
//    inventoryPanel.validate();
      
        
    }//GEN-LAST:event_Apanel4MouseClicked

    private void Apanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Apanel4MouseEntered
        // TODO add your handling code here:
        Apanel4.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
        Apanel4.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_Apanel4MouseEntered

    private void Apanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Apanel4MouseExited
        // TODO add your handling code here:
        Apanel4.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.white));
        Apanel4.setBackground(new Color(0,161,225));
    }//GEN-LAST:event_Apanel4MouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            String Brand="";
            String Model="";
            String Account="";
            String eid="";
            String provide_date="";
            String comments = "";
            DefaultTableModel RecordTable = (DefaultTableModel) showTable.getModel();
            String AssetTag = RecordTable.getValueAt(showTable.getSelectedRow(), 0).toString();
            
            try {
                Brand = RecordTable.getValueAt(showTable.getSelectedRow(), 1).toString();
            } catch (Exception e) {
                Brand="";
            }
            try
            {
                Model = RecordTable.getValueAt(showTable.getSelectedRow(), 2).toString();
            }
            catch(Exception e)
            {
                Model="";
            }
            try {
                Account = RecordTable.getValueAt(showTable.getSelectedRow(), 3).toString();
                
            } catch (Exception e) {
                Account="";
            }
            try
            {
               eid = RecordTable.getValueAt(showTable.getSelectedRow(), 4).toString();
            }
            catch(Exception e)
            {
                eid="";
            }
            try {
                provide_date = RecordTable.getValueAt(showTable.getSelectedRow(), 5).toString();
                
            } catch (Exception e) {
                provide_date="";
            }
             try {
                 Connection con1 = db.connection;
                    PreparedStatement pst3 = con1.prepareStatement("select comment from asset where asset_tag like ? and provide_date IS NOT NULL and handover_date IS NULL and status like 'in-service';");
                    pst3.setString(1, AssetTag);
                    ResultSet rs = pst3.executeQuery();
                    while(rs.next()){
                        comments = rs.getString("comment");
                    }
             }catch(Exception e){comments = "";}
             System.out.println(comments);
            update(AssetTag, Brand, Model, Account, eid, provide_date,comments);
            join assign = new join();
            assign.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void showTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_showTableMouseClicked

    private void logtextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logtextMouseClicked
        // TODO add your handling code here:
        this.dispose();
        //new Logins().setVisible(true);
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
        ///new Logins().setVisible(true);
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
        //new Logins().setVisible(true);
    }//GEN-LAST:event_loginpanelMouseClicked

    private void loginpanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginpanelMouseEntered
        // TODO add your handling code here:
        loginpanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.white));
    }//GEN-LAST:event_loginpanelMouseEntered

    private void loginpanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginpanelMouseExited
        // TODO add your handling code here:
        loginpanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }//GEN-LAST:event_loginpanelMouseExited

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
            java.util.logging.Logger.getLogger(Availability.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Availability.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Availability.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Availability.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Availability().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Ap;
    private javax.swing.JPanel Apanel1;
    private javax.swing.JPanel Apanel4;
    public static javax.swing.JPanel Pie;
    private javax.swing.JPanel Up;
    private javax.swing.JPanel Vp;
    private javax.swing.JTextField asearch;
    private javax.swing.JLabel avail;
    private javax.swing.JTextField esearch;
    public static javax.swing.JPanel inventoryPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logimg;
    private javax.swing.JLabel logimg1;
    private javax.swing.JPanel loginpanel;
    private javax.swing.JLabel logtext;
    private javax.swing.JTable showTable;
    public static javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables


}
