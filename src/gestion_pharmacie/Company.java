
package gestion_pharmacie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author samuel Njoya
 */
public class Company extends javax.swing.JFrame {

   
    DefaultTableModel model;
    
    public Company() {
        initComponents();
        setDetailCompanyTable();
        
        txt_IdC.setEditable(false);
    }

 
    //AGENTS DETAIL
     public void setDetailCompanyTable(){
       try {
            Connection con = DBconnexion.getConnection();
            String sql = "select * from company";
            PreparedStatement ps = con.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
               
                String id = rs.getString("id_company");
                String name = rs.getString("name");
                String ad = rs.getString("address");
                String ph = rs.getString("phone");
                String ep = rs.getString("experience");
               
                Object[] obj = {id,name,ad,ph,ep};
                model = (DefaultTableModel) tbl_list_Company.getModel();
                model.addRow(obj);
               
           }
            
       } catch (Exception e) {
           JOptionPane.showMessageDialog(this, e);
       }
   }
     
     
    
    
    //INSERT COMPAGY
    public boolean insertCompany(){
          
          boolean isCompany = false;
          
        String id_C = txt_IdC.getText();
        String name_C = txt_NameC.getText();
        String ad_C = txt_AddressC.getText();
        String ph_C = txt_PhoneC.getText();
        String es_C = txt_ExpeC.getText();
       
        
        try 
        {
            Connection con = DBconnexion.getConnection();
            String sql = "insert into company(name,address,phone,experience) values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, name_C);
            ps.setString(2, ad_C);
            ps.setString(3, ph_C);
            ps.setString(4, es_C);
           
         
            
          int RowCount =   ps.executeUpdate();
          
          if(RowCount>0){
              isCompany = true;
          }else{
             isCompany = false;
          }
          //  txt_book_name.setText(""); txt_book_author.setText(""); txt_book_quantirty.setText(""); 
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        }
          
        return isCompany;
      }
    
    //UPDATE COMPANY
     public  void updateCompany(){
       
        String id_C = txt_IdC.getText();
        String name_C = txt_NameC.getText();
        String ad_C = txt_AddressC.getText();
        String ph_C = txt_PhoneC.getText();
        String es_C = txt_ExpeC.getText();
       
        
         try 
        {
        
        Connection con = DBconnexion.getConnection();
            String sql = "update company set name=?,address=?,phone=?,experience=? where id_company=?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, name_C);
            ps.setString(2, ad_C);
            ps.setString(3, ph_C);
            ps.setString(4, es_C);
        
      
           ps.setString(5, id_C);
           ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "update successfuly");
      }
      catch (Exception e)
      {
        JOptionPane.showMessageDialog(this, e);
      }
   }
   
     
     //DELETE COMPANY
    public  void deleteCompany(){
        
        String id_C = txt_IdC.getText();
        
         try 
        {
        
        Connection con = DBconnexion.getConnection();
            String sql = "delete from company where id_company=?";
            PreparedStatement ps = con.prepareStatement(sql);
            
           ps.setString(1, id_C);
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
       DefaultTableModel model = (DefaultTableModel) tbl_list_Company.getModel();
       model.setRowCount(0);
       
   }
    
    //CLEAR INPUT
    public void clearInput(){
        txt_IdC.setText("");
        txt_ExpeC.setText("");
        txt_NameC.setText("");
        txt_AddressC.setText("");
        txt_PhoneC.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_ExpeC = new javax.swing.JTextField();
        txt_PhoneC = new javax.swing.JTextField();
        txt_NameC = new javax.swing.JTextField();
        txt_IdC = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btn_delete = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_AddressC = new javax.swing.JTextField();
        btn_clear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_list_Company = new rojerusan.RSTableMetro();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

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
        jLabel9.setText("ID");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 35, 101, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 51));
        jLabel11.setText("NAME");
        jLabel11.setToolTipText("");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 78, 101, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 51));
        jLabel10.setText("PHONE");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 43, 101, -1));

        txt_ExpeC.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.add(txt_ExpeC, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 84, 115, -1));

        txt_PhoneC.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.add(txt_PhoneC, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 47, 115, -1));

        txt_NameC.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.add(txt_NameC, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 78, 115, -1));

        txt_IdC.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.add(txt_IdC, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 38, 115, -1));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 51));
        jLabel13.setText("EXPERIENCE");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 80, 116, -1));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 51));
        jLabel14.setText("ADDRESS");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 109, 101, -1));

        btn_delete.setBackground(new java.awt.Color(0, 153, 51));
        btn_delete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("DELETE");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel2.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 150, 82, 40));

        btn_update.setBackground(new java.awt.Color(0, 153, 51));
        btn_update.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("UPDATE");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel2.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 82, 40));

        btn_add.setBackground(new java.awt.Color(0, 153, 51));
        btn_add.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("ADD");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel2.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 82, 40));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 51));
        jLabel16.setText("COMPANY LIST");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 198, 157, 20));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 153, 51));
        jLabel17.setText("MANAGE COMPANY");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 0, 247, -1));

        txt_AddressC.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.add(txt_AddressC, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 113, 115, -1));

        btn_clear.setBackground(new java.awt.Color(0, 153, 51));
        btn_clear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear.setText("CLEAR");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        jPanel2.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 150, 82, 40));

        tbl_list_Company.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Address", "Phone", "Experience"
            }
        ));
        tbl_list_Company.setColorBackgoundHead(new java.awt.Color(0, 153, 51));
        tbl_list_Company.setSelectionBackground(new java.awt.Color(0, 153, 51));
        tbl_list_Company.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_list_CompanyMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_list_Company);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 272, 620, 200));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 14, 660, 490));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("AGENT");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 142, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SELLING");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 111, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("MEDECINE");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 73, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 910, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearInput();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
       insertCompany();
       clearTable();
       setDetailCompanyTable();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        updateCompany();
        clearTable();
        setDetailCompanyTable();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        deleteCompany();
        clearTable();
        setDetailCompanyTable();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void tbl_list_CompanyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_list_CompanyMouseClicked
        int rowNo = tbl_list_Company.getSelectedRow();
       TableModel model = tbl_list_Company.getModel();
       
       txt_IdC.setText(model.getValueAt(rowNo, 0).toString());
       txt_NameC.setText(model.getValueAt(rowNo, 1).toString());
       txt_AddressC.setText(model.getValueAt(rowNo, 2).toString());
       txt_PhoneC.setText(model.getValueAt(rowNo, 3).toString());
       txt_ExpeC.setText(model.getValueAt(rowNo, 4).toString());
      
    }//GEN-LAST:event_tbl_list_CompanyMouseClicked

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
            java.util.logging.Logger.getLogger(Company.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Company.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Company.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Company.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Company().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSTableMetro tbl_list_Company;
    private javax.swing.JTextField txt_AddressC;
    private javax.swing.JTextField txt_ExpeC;
    private javax.swing.JTextField txt_IdC;
    private javax.swing.JTextField txt_NameC;
    private javax.swing.JTextField txt_PhoneC;
    // End of variables declaration//GEN-END:variables
}
