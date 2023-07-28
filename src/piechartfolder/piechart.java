/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package piechartfolder;

import Database.Database;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;


/**
 *
 * @author abaru
 */
public class piechart extends javax.swing.JFrame {
//private static final long serialVersionUID = 6294689542092367723L;  
  public static int assigned = 0;
  public static int free = 0;
  public static int in_service = 0;
  public static int scrap = 0;
  public static int laptop = 0;
  public static int keyboard = 0;
  public static int mouse = 0;
  public static int monitor = 0;
  public static int hard_disk = 0;
  public static int lap_battery = 0;
  public static int lap_keypad = 0;
  
    public piechart(String title) {
        super(title);
        initComponents();
          try{
        Database db = new Database();
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
            free = rs3.getInt(1);
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
        PreparedStatement pst8 = con.prepareStatement("select count(*) from inventory where category like ? ");
        pst8.setString(1,"laptop");
        ResultSet rs8 = pst8.executeQuery();
        while(rs8.next()){
            laptop = rs8.getInt(1);
        }
        PreparedStatement pst4 = con.prepareStatement("select count(*) from inventory where category like ? ");
        pst4.setString(1,"monitor");
        ResultSet rs4 = pst4.executeQuery();
        while(rs4.next()){
            monitor = rs4.getInt(1);
        }
        PreparedStatement pst5 = con.prepareStatement("select count(*) from inventory where category like ? ");
        pst5.setString(1,"keyboard");
        ResultSet rs5 = pst5.executeQuery();
        while(rs5.next()){
            keyboard = rs5.getInt(1);
        }
        PreparedStatement pst6 = con.prepareStatement("select count(*) from inventory where category like ? ");
        pst6.setString(1,"mouse");
        ResultSet rs6 = pst6.executeQuery();
        while(rs6.next()){
            mouse = rs6.getInt(1);
        }
        PreparedStatement pst7 = con.prepareStatement("select count(*) from inventory where category like ? ");
        pst7.setString(1,"hard-disk");
        ResultSet rs7 = pst7.executeQuery();
        while(rs7.next()){
            hard_disk = rs7.getInt(1);
        }
        PreparedStatement pst9 = con.prepareStatement("select count(*) from inventory where category like ? ");
        pst9.setString(1,"lap-battery");
        ResultSet rs9 = pst9.executeQuery();
        while(rs9.next()){
            lap_battery = rs9.getInt(1);
        }
        PreparedStatement pst10 = con.prepareStatement("select count(*) from inventory where category like ? ");
        pst10.setString(1,"lap-keypad");
        ResultSet rs10 = pst10.executeQuery();
        while(rs10.next()){
           lap_keypad  = rs10.getInt(1);
        }
        System.out.println(laptop);
  }catch(Exception e){System.out.println(e);}
        DefaultPieDataset dataset=new DefaultPieDataset(); 
        DefaultPieDataset invdataset = new DefaultPieDataset();
    dataset.setValue("assigned: "+assigned, assigned);  
    dataset.setValue("Free: "+free,free );
    dataset.setValue("in-service: "+in_service, in_service);  
    dataset.setValue("scrap: "+scrap, scrap); 
    
    invdataset.setValue("Laptop: "+laptop, laptop);
    invdataset.setValue("Monitor: "+monitor,monitor);
    invdataset.setValue("Keyboard: "+keyboard, keyboard);
    invdataset.setValue("Mouse: "+mouse,mouse);
    invdataset.setValue("hard_disk: "+hard_disk,hard_disk);
    invdataset.setValue("Laptop Battery: "+lap_battery,lap_battery);
    invdataset.setValue("Laptop Keypad: "+lap_keypad,lap_keypad);
    // Create chart  
    JFreeChart chart = ChartFactory.createPieChart(  
        "Asset Status",  
        dataset,  
        true,   
        true,  
        false);  
  
    //Format Label  
    PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(  
        " {0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));  
    ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);  
      
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
    // Create Panel  
    ChartPanel panel = new ChartPanel(chart);  
    ChartPanel invpanel = new ChartPanel(invchart);
    
    statusPanel.removeAll();
    statusPanel.add(panel,BorderLayout.CENTER);
    statusPanel.validate();
//    
    inventoryPanel.removeAll();
    inventoryPanel.add(invpanel,BorderLayout.CENTER);
    inventoryPanel.validate();
    
  
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        statusPanel = new javax.swing.JPanel();
        inventoryPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        statusPanel.setPreferredSize(new java.awt.Dimension(300, 250));
        statusPanel.setLayout(new java.awt.BorderLayout());

        inventoryPanel.setPreferredSize(new java.awt.Dimension(300, 250));
        inventoryPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(inventoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inventoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(piechart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(piechart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(piechart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(piechart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
      SwingUtilities.invokeLater(() -> {  
              piechart d = new piechart("Aseet status");
              d.setVisible(true);

    });  
     
  }  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel inventoryPanel;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables
}
