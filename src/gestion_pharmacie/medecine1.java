
package gestion_pharmacie;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author samuel Njoya
 */
public class medecine1 extends javax.swing.JFrame {

    DefaultTableModel model;
    
    
    public medecine1() {
        initComponents();
        setDetailMedicineTable();
        
       btn_add.setEnabled(true);
       btn_delete.setEnabled(false);
       btn_update.setEnabled(false);
       txt_id.setEditable(false);
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
                Date fdate = rs.getDate("fab_date");
                Date edate = rs.getDate("exp_date");
                String cmpy = rs.getString("company");
                
                Object[] obj = {id,name,qty,price,fdate,edate,cmpy};
                model = (DefaultTableModel) tbl_MedicineDetail.getModel();
                model.addRow(obj);
               
           }
            
       } catch (Exception e) {
           JOptionPane.showMessageDialog(this, e);
       }
   }
     
     
    
    
    //INSERT MEDICINE
    public boolean insertMedicine(){
          
          boolean isMedicine = false;
          
          
          java.util.Date uFabDate = date_fab.getDate();
          java.util.Date uExpDate = date_exp.getDate();
          
          Long l1 = uFabDate.getTime();
          Long l2 = uExpDate.getTime();
          
          java.sql.Date fabDate_M = new  java.sql.Date(l1);
          java.sql.Date expDate_M = new  java.sql.Date(l2);
          
        String id_M = txt_id.getText();
        String name_M = txt_name.getText();
        String qty_M = txt_qty.getText();
        String price_M = txt_price.getText();
        String company_M = cmb_cmpy.getSelectedItem().toString();
        
        try 
        {
            Connection con = DBconnexion.getConnection();
            String sql = "insert into medicine(name,quantity,price,fab_date,exp_date,company) values(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, name_M);
            ps.setString(2, qty_M);
            ps.setString(3, price_M);
            ps.setDate(4, fabDate_M);
            ps.setDate(5, expDate_M);
            ps.setString(6, company_M);
            
          int RowCount =   ps.executeUpdate();
          
          if(RowCount>0){
              isMedicine = true;
          }else{
              isMedicine = false;
          }
          //  txt_book_name.setText(""); txt_book_author.setText(""); txt_book_quantirty.setText(""); 
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        }
          
        return isMedicine;
      }
    
    //UPDATE
     public  void updateMedicine(){
        java.util.Date uFabDate = date_fab.getDate();
        java.util.Date uExpDate = date_exp.getDate();
          
        Long l1 = uFabDate.getTime();
        Long l2 = uExpDate.getTime();
          
        java.sql.Date fabDate_M = new  java.sql.Date(l1);
        java.sql.Date expDate_M = new  java.sql.Date(l2);
        
        String id_M = txt_id.getText();
        String name_M = txt_name.getText();
        String qty_M = txt_qty.getText();
        String price_M = txt_price.getText();
        String company_M = cmb_cmpy.getSelectedItem().toString();
        
         try 
        {
        
        Connection con = DBconnexion.getConnection();
            String sql = "update medicine set name=?,quantity=?,price=?,fab_date=?,exp_date=?,company=? where id_medicine=?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, name_M);
            ps.setString(2, qty_M);
            ps.setString(3, price_M);
            ps.setDate(4, fabDate_M);
            ps.setDate(5, expDate_M);
            ps.setString(6, company_M);
        
      
           ps.setString(7, id_M);
           ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "update successfuly");
      }
      catch (Exception e)
      {
        JOptionPane.showMessageDialog(this, e);
      }
   }
   
     
     //DELETE
    public  void deleteMedicine(){
        
        String id = txt_id.getText();
        
         try 
        {
        
        Connection con = DBconnexion.getConnection();
            String sql = "delete from medicine where id_medicine=?";
            PreparedStatement ps = con.prepareStatement(sql);
            
           ps.setString(1, id);
           ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "delete successfuly");
      }
      catch (Exception e)
      {
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
        jLabel12 = new javax.swing.JLabel();
        txt_price = new javax.swing.JTextField();
        txt_qty = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        date_exp = new com.toedter.calendar.JDateChooser();
        date_fab = new com.toedter.calendar.JDateChooser();
        cmb_cmpy = new javax.swing.JComboBox<>();
        btn_delete = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_MedicineDetail = new rojerusan.RSTableMetro();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 51));
        jLabel9.setText("ID");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 35, 101, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 51));
        jLabel11.setText("NAME");
        jLabel11.setToolTipText("");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 79, 101, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 51));
        jLabel10.setText("QTY");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 125, 101, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 51));
        jLabel12.setText("PRICE");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 151, 101, -1));

        txt_price.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.add(txt_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 155, 115, -1));

        txt_qty.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.add(txt_qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 129, 115, -1));

        txt_name.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 83, 115, -1));

        txt_id.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 39, 115, -1));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 51));
        jLabel15.setText("FABDATE");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 57, 101, -1));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 51));
        jLabel13.setText("EXPDATE");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 116, 101, -1));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 51));
        jLabel14.setText("COMPANY");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 151, 101, -1));
        jPanel2.add(date_exp, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 116, 231, 25));
        jPanel2.add(date_fab, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 57, 231, 29));

        cmb_cmpy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmb_cmpy.setForeground(new java.awt.Color(0, 204, 51));
        cmb_cmpy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SMART CMP", "HTP WES", "SMART HPT", "H1 CMPY", " " }));
        jPanel2.add(cmb_cmpy, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 152, 231, -1));

        btn_delete.setBackground(new java.awt.Color(0, 153, 51));
        btn_delete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("DELETE");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel2.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 217, 82, 40));

        btn_update.setBackground(new java.awt.Color(0, 153, 51));
        btn_update.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("UPDATE");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel2.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 217, 82, 40));

        btn_add.setBackground(new java.awt.Color(0, 153, 51));
        btn_add.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("ADD");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel2.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 217, 82, 40));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 51));
        jLabel16.setText("MEDECINE LIST");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 265, 157, 20));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 153, 51));
        jLabel17.setText("MANAGE MEDECINE");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 0, 247, -1));

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

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 700, 180));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 760, 510));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("COMPANY");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 23, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SELLING");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 61, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("AGENT");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 99, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 944, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
       insertMedicine();
       clearTable();
       setDetailMedicineTable();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        updateMedicine();
        clearTable();
       setDetailMedicineTable();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        deleteMedicine();
        clearTable();
       setDetailMedicineTable();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void tbl_MedicineDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_MedicineDetailMouseClicked
       int rowNo = tbl_MedicineDetail.getSelectedRow();
       TableModel model = tbl_MedicineDetail.getModel();
       
       txt_id.setText(model.getValueAt(rowNo, 0).toString());
       txt_name.setText(model.getValueAt(rowNo, 1).toString());
       txt_qty.setText(model.getValueAt(rowNo, 2).toString());
       txt_price.setText(model.getValueAt(rowNo, 3).toString());
       date_fab.setDateFormatString(model.getValueAt(rowNo, 4).toString());
       date_exp.setDateFormatString(model.getValueAt(rowNo, 5).toString());
       cmb_cmpy.setSelectedItem(model.getValueAt(rowNo, 6).toString());
       
        
       btn_add.setEnabled(false);
       btn_delete.setEnabled(true);
       btn_update.setEnabled(true);
    }//GEN-LAST:event_tbl_MedicineDetailMouseClicked

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
            java.util.logging.Logger.getLogger(medecine1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(medecine1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(medecine1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(medecine1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new medecine1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cmb_cmpy;
    private com.toedter.calendar.JDateChooser date_exp;
    private com.toedter.calendar.JDateChooser date_fab;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSTableMetro tbl_MedicineDetail;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_qty;
    // End of variables declaration//GEN-END:variables
}
