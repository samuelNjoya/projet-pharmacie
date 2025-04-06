/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Agents extends javax.swing.JFrame {

    DefaultTableModel model;

    public Agents() {
        initComponents();
        setDetailAgentTable();
        
        txt_idA.setEditable(false);
    }

    //AGENTS DETAIL
     public void setDetailAgentTable(){
       try {
            Connection con = DBconnexion.getConnection();
            String sql = "select * from agents";
            PreparedStatement ps = con.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
               
                String id = rs.getString("id_agent");
                String name = rs.getString("name");
                String age = rs.getString("age");
                String pw = rs.getString("password");
                String ph = rs.getString("phone");
                String gd = rs.getString("gender");
               
                Object[] obj = {id,name,age,pw,ph,gd};
                model = (DefaultTableModel) tbl_list_Agent.getModel();
                model.addRow(obj);
               
           }
            
       } catch (Exception e) {
           JOptionPane.showMessageDialog(this, e);
       }
   }
     
     
    
    
    //INSERT AGENT
    public boolean insertAgent(){
          
          boolean isAgent = false;
          
        String id_A = txt_idA.getText();
        String name_A = txt_nameA.getText();
        String age_A = txt_AgeA.getText();
        String ps_A = txt_PasswordA.getText();
        String ph_A = txt_phoneA.getText();
        String gd_A = cmb_genderA.getSelectedItem().toString();
        
        try 
        {
            Connection con = DBconnexion.getConnection();
            String sql = "insert into agents(name,age,password,phone,gender) values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, name_A);
            ps.setString(2, age_A);
            ps.setString(3, ps_A);
            ps.setString(4, ph_A);
            ps.setString(5, gd_A);
         
            
          int RowCount =   ps.executeUpdate();
          
          if(RowCount>0){
              isAgent = true;
          }else{
              isAgent = false;
          }
          //  txt_book_name.setText(""); txt_book_author.setText(""); txt_book_quantirty.setText(""); 
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        }
          
        return isAgent;
      }
    
    //UPDATE AGENT
     public  void updateAgent(){
       
        String id_A = txt_idA.getText();
        String name_A = txt_nameA.getText();
        String age_A = txt_AgeA.getText();
        String ps_A = txt_PasswordA.getText();
        String ph_A = txt_phoneA.getText();
        String gd_A = cmb_genderA.getSelectedItem().toString();
        
         try 
        {
        
        Connection con = DBconnexion.getConnection();
            String sql = "update agents set name=?,age=?,password=?,phone=?,gender=? where id_agent=?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, name_A);
            ps.setString(2, age_A);
            ps.setString(3, ps_A);
            ps.setString(4, ph_A);
            ps.setString(5, gd_A);
        
      
           ps.setString(6, id_A);
           ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "update successfuly");
      }
      catch (Exception e)
      {
        JOptionPane.showMessageDialog(this, e);
      }
   }
   
     
     //DELETE AGENT
    public  void deleteAgent(){
        
        String id_A = txt_idA.getText();
        
         try 
        {
        
        Connection con = DBconnexion.getConnection();
            String sql = "delete from agents where id_agent=?";
            PreparedStatement ps = con.prepareStatement(sql);
            
           ps.setString(1, id_A);
           ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "delete successfuly");
      }
      catch (Exception e)
      {
        JOptionPane.showMessageDialog(this, e);
      }
   }
    
    //CLEAR INPUT
    public void clearInput(){
        txt_idA.setText("");
        txt_AgeA.setText("");
        txt_nameA.setText("");
        txt_PasswordA.setText("");
        txt_phoneA.setText("");
    }
    
    
    //FOR DON'T HAVE REDONDANCE
     public void clearTable(){
       DefaultTableModel model = (DefaultTableModel) tbl_list_Agent.getModel();
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
        txt_PasswordA = new javax.swing.JTextField();
        txt_phoneA = new javax.swing.JTextField();
        txt_nameA = new javax.swing.JTextField();
        txt_idA = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btn_delete = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_AgeA = new javax.swing.JTextField();
        cmb_genderA = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        btn_clear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_list_Agent = new rojerusan.RSTableMetro();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

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
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 43, 101, -1));

        txt_PasswordA.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.add(txt_PasswordA, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 84, 115, -1));

        txt_phoneA.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.add(txt_phoneA, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 47, 115, -1));

        txt_nameA.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.add(txt_nameA, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 78, 115, -1));

        txt_idA.setBackground(new java.awt.Color(204, 204, 255));
        txt_idA.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.add(txt_idA, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 38, 115, -1));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 51));
        jLabel13.setText("PASSWORD");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 80, -1, -1));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 51));
        jLabel14.setText("AGE");
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
        jLabel16.setText("AGENT LIST");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 157, 20));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 153, 51));
        jLabel17.setText("MANAGE AGENT");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 0, 247, -1));

        txt_AgeA.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.add(txt_AgeA, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 113, 115, -1));

        cmb_genderA.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmb_genderA.setForeground(new java.awt.Color(0, 204, 51));
        cmb_genderA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MALE", "FEMALE" }));
        jPanel2.add(cmb_genderA, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 118, 115, -1));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 51));
        jLabel15.setText("GENDER");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 117, 101, -1));

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

        tbl_list_Agent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Age", "Password", "Phone", "Gender"
            }
        ));
        tbl_list_Agent.setColorBackgoundHead(new java.awt.Color(0, 153, 51));
        tbl_list_Agent.setColorSelBackgound(new java.awt.Color(0, 153, 51));
        tbl_list_Agent.setSelectionBackground(new java.awt.Color(0, 153, 51));
        tbl_list_Agent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_list_AgentMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_list_Agent);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 600, 200));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 31, 670, 450));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("COMPANY");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 73, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SELLING");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 111, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("MEDECINE");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 149, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("BACK");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("x");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, 30, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 960, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearInput();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        insertAgent();
        clearTable();
        setDetailAgentTable();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        updateAgent();
        clearTable();
        setDetailAgentTable();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        deleteAgent();
        clearTable();
        setDetailAgentTable();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void tbl_list_AgentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_list_AgentMouseClicked
       int rowNo = tbl_list_Agent.getSelectedRow();
       TableModel model = tbl_list_Agent.getModel();
       
       txt_idA.setText(model.getValueAt(rowNo, 0).toString());
       txt_nameA.setText(model.getValueAt(rowNo, 1).toString());
       txt_AgeA.setText(model.getValueAt(rowNo, 2).toString());
       txt_PasswordA.setText(model.getValueAt(rowNo, 3).toString());
       txt_phoneA.setText(model.getValueAt(rowNo, 4).toString());
       cmb_genderA.setSelectedItem(model.getValueAt(rowNo, 5).toString());
    }//GEN-LAST:event_tbl_list_AgentMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        medecine1 md = new medecine1();
        md.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(Agents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cmb_genderA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSTableMetro tbl_list_Agent;
    private javax.swing.JTextField txt_AgeA;
    private javax.swing.JTextField txt_PasswordA;
    private javax.swing.JTextField txt_idA;
    private javax.swing.JTextField txt_nameA;
    private javax.swing.JTextField txt_phoneA;
    // End of variables declaration//GEN-END:variables
}
