
package gestion_pharmacie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author samuel Njoya
 */
public class selling extends javax.swing.JFrame {

    DefaultTableModel model;
    
    public selling() {
        initComponents();
        showDate();
        setDetailMedicineTable();
        
    }
    
    public void showDate(){
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        lbl_date.setText(s.format(d));
    }

    public void billFacture(){
     //  int id = Integer.parseInt(txt_id_bill.getText());
       String medicine = txt_medicine_bill.getText();
       int quantity = Integer.parseInt(txt_qty_bill.getText());
       double price = Double.parseDouble(txt_price_bill.getText());
       double totalPrice = quantity*price;
       
       
         txt_area_bill.setText(txt_area_bill.getText()+"   \t*************SMART CENTER************ \n "
            //    + "ID:    \t"+id+" \n "
                 + "Medicine:    \t "+medicine+"\n "
                 + "quantity:     \t"+quantity+" \n "
                 + "price:     \t"+price+" \n "
                 + "Total price:     \t"+price+" * "+""+quantity+" \n "
                 + "                  \t"+totalPrice+" \n "
         );
        
    }
  
     //MEDICINE DETAIL
     public void setDetailMedicineTable(){
       try {
            Connection con = DBconnexion.getConnection();
            String sql = "select * from medicine";
            PreparedStatement ps = con.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
               
                String id = rs.getString("id_medicine");
                String name = rs.getString("name");
                String qty = rs.getString("quantity");
                String price = rs.getString("price");
                java.sql.Date fdate = rs.getDate("fab_date");
                java.sql.Date edate = rs.getDate("exp_date");
                String cmpy = rs.getString("company");
                
                Object[] obj = {id,name,qty,price,fdate,edate,cmpy};
                model = (DefaultTableModel) tbl_MedicineDetail.getModel();
                model.addRow(obj);
               
           }
            
            
       } catch (Exception e) {
           JOptionPane.showMessageDialog(this, e);
       }
   }
     
     //UPDATE
      public void updatingCountMedicine(){
          String id_medc = txt_id_bill.getText();
          String qty = txt_qty_bill.getText();
          
          try {
              
            Connection con = DBconnexion.getConnection();
            String sql = "update medicine set quantity = quantity - "+qty+" where id_medicine = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, id_medc);
          
            
          int RowCount =   ps.executeUpdate();
          
          if(RowCount>0){
             JOptionPane.showMessageDialog(this, "medicine count updating");
            /* int initialCount = Integer.parseInt(lbl_quantity_book.getText());
             lbl_quantity_book.setText(Integer.toString(initialCount - 1));*/
          }else{
              JOptionPane.showMessageDialog(this, "medicine count not updating");
          }
              
          } catch (Exception e) {
              JOptionPane.showMessageDialog(this, e);
          }
      }
      
       //FOR DON'T HAVE REDONDANCE
     public void clearTable(){
       DefaultTableModel model = (DefaultTableModel) tbl_MedicineDetail.getModel();
       model.setRowCount(0);
       
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_qty_bill = new javax.swing.JTextField();
        txt_medicine_bill = new javax.swing.JTextField();
        txt_id_bill = new javax.swing.JTextField();
        btn_clear = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_MedicineDetail = new rojerusan.RSTableMetro();
        jLabel18 = new javax.swing.JLabel();
        btn_add1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_area_bill = new javax.swing.JTextArea();
        txt_price_bill = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 51));
        jLabel9.setText("BILL ID");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 101, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 51));
        jLabel11.setText("MEDICINE");
        jLabel11.setToolTipText("");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 101, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 51));
        jLabel10.setText("QTY");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 101, -1));

        txt_qty_bill.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.add(txt_qty_bill, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 115, -1));

        txt_medicine_bill.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.add(txt_medicine_bill, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 115, -1));

        txt_id_bill.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.add(txt_id_bill, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 115, -1));

        btn_clear.setBackground(new java.awt.Color(0, 153, 51));
        btn_clear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        jPanel2.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 230, 82, 40));

        btn_add.setBackground(new java.awt.Color(0, 153, 51));
        btn_add.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("ADD TO BILL");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel2.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 130, 40));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 51));
        jLabel16.setText("BILL");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 157, 20));

        lbl_date.setBackground(new java.awt.Color(255, 255, 255));
        lbl_date.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_date.setForeground(new java.awt.Color(0, 153, 51));
        lbl_date.setText("DATE");
        jPanel2.add(lbl_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 170, -1));

        tbl_MedicineDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Quantity", "Price", "FAB_DATE", "EXP_DATE", "Company"
            }
        ));
        tbl_MedicineDetail.setColorBackgoundHead(new java.awt.Color(0, 153, 51));
        tbl_MedicineDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_MedicineDetailMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_MedicineDetail);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 530, 160));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 153, 51));
        jLabel18.setText("BILLING");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 247, -1));

        btn_add1.setBackground(new java.awt.Color(0, 153, 51));
        btn_add1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_add1.setForeground(new java.awt.Color(255, 255, 255));
        btn_add1.setText("PRINT");
        btn_add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 500, 82, 40));

        txt_area_bill.setColumns(20);
        txt_area_bill.setRows(5);
        jScrollPane1.setViewportView(txt_area_bill);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 520, 180));

        txt_price_bill.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.add(txt_price_bill, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 115, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 51));
        jLabel12.setText("PRICE");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 101, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 850, 550));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("COMPANY");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SELLING");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("AGENT");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("x");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 20, 20, -1));
        jLabel1.getAccessibleContext().setAccessibleName("x");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("BACK");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 620));

        setSize(new java.awt.Dimension(977, 615));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
       txt_area_bill.setText("");
       txt_id_bill.setText("");
       txt_medicine_bill.setText("");
       txt_qty_bill.setText("");
       txt_price_bill.setText("");
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
       billFacture();
        updatingCountMedicine();
        clearTable();
        setDetailMedicineTable();
      
    }//GEN-LAST:event_btn_addActionPerformed

    private void tbl_MedicineDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_MedicineDetailMouseClicked
        int rowNo = tbl_MedicineDetail.getSelectedRow();
        TableModel model = tbl_MedicineDetail.getModel();

      
        
        txt_id_bill.setText(model.getValueAt(rowNo, 0).toString());
        txt_medicine_bill.setText(model.getValueAt(rowNo, 1).toString());
        txt_qty_bill.setText(model.getValueAt(rowNo, 2).toString());
        txt_price_bill.setText(model.getValueAt(rowNo, 3).toString());
       /* date_fab.setDateFormatString(model.getValueAt(rowNo, 4).toString());
        date_exp.setDateFormatString(model.getValueAt(rowNo, 5).toString());
        cmb_cmpy.setSelectedItem(model.getValueAt(rowNo, 6).toString());*/

       /* btn_add.setEnabled(false);
        btn_delete.setEnabled(true);
        btn_update.setEnabled(true);*/
    }//GEN-LAST:event_tbl_MedicineDetailMouseClicked

    private void btn_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add1ActionPerformed
        try {
            txt_area_bill.print();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btn_add1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        medecine1 md = new medecine1();
        md.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new selling().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_add1;
    private javax.swing.JButton btn_clear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_date;
    private rojerusan.RSTableMetro tbl_MedicineDetail;
    private javax.swing.JTextArea txt_area_bill;
    private javax.swing.JTextField txt_id_bill;
    private javax.swing.JTextField txt_medicine_bill;
    private javax.swing.JTextField txt_price_bill;
    private javax.swing.JTextField txt_qty_bill;
    // End of variables declaration//GEN-END:variables
}
