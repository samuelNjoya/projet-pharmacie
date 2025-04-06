
package gestion_pharmacie;

import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
        getCompany();
        
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
          
          
        /* java.util.Date uFabDate = date_fab.getDate();
          java.util.Date uExpDate = date_exp.getDate();
          
          Long l1 = uFabDate.getTime();
          Long l2 = uExpDate.getTime();
          
          java.sql.Date fabDate_M = new  java.sql.Date(l1);
          java.sql.Date expDate_M = new  java.sql.Date(l2); */
          
          
          
        String id_M = txt_id.getText();
        String name_M = txt_name.getText();
        String qty_M = txt_qty.getText();
        String price_M = txt_price.getText();
        String company_M = cmb_cmpy.getSelectedItem().toString();
        
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       String fabDate_M = sdf.format(date_fab.getDate());
       String expDate_M = sdf.format(date_exp.getDate());
        
        try 
        {
            Connection con = DBconnexion.getConnection();
            String sql = "insert into medicine(name,quantity,price,fab_date,exp_date,company) values(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, name_M);
            ps.setString(2, qty_M);
            ps.setString(3, price_M);
           /* ps.setDate(4,  fabDate_M);
            ps.setDate(5, expDate_M);*/
            ps.setString(4,  fabDate_M);
            ps.setString(5, expDate_M);
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
   
     public void updateMedicine1() {
    java.util.Date uFabDate = date_fab.getDate();
    java.util.Date uExpDate = date_exp.getDate();

    // Vérifiez si les dates sont nulles
    if (uFabDate == null || uExpDate == null) {
        JOptionPane.showMessageDialog(this, "Veuillez sélectionner des dates valides.");
        return;
    }

    // Afficher les dates pour débogage
    System.out.println("Date de fabrication : " + uFabDate);
    System.out.println("Date d'expiration : " + uExpDate);

   // java.sql.Date fabDate_M = new java.sql.Date(uFabDate.getTime());
    //java.sql.Date expDate_M = new java.sql.Date(uExpDate.getTime());

    // Vérifiez les valeurs après conversion
   // System.out.println("Date de fabrication (SQL) : " + fabDate_M);
   // System.out.println("Date d'expiration (SQL) : " + expDate_M);

    String id_M = txt_id.getText();
    String name_M = txt_name.getText();
    String qty_M = txt_qty.getText();
    String price_M = txt_price.getText();
    String company_M = cmb_cmpy.getSelectedItem().toString();
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String fabDate_M = sdf.format(date_fab.getDate());
    String expDate_M = sdf.format(date_exp.getDate());

    try (Connection con = DBconnexion.getConnection();
         PreparedStatement ps = con.prepareStatement("UPDATE medicine SET name=?, quantity=?, price=?, fab_date=?, exp_date=?, company=? WHERE id_medicine=?")) {

        ps.setString(1, name_M);
        ps.setString(2, qty_M);
        ps.setString(3, price_M);
        ps.setString(4, fabDate_M);
        ps.setString(5, expDate_M);
        ps.setString(6, company_M);
        ps.setString(7, id_M);

        int rowsUpdated = ps.executeUpdate();
        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(this, "Mise à jour réussie.");
        } else {
            JOptionPane.showMessageDialog(this, "Aucun enregistrement trouvé avec cet ID : " + id_M);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erreur lors de la mise à jour : " + e.getMessage());
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
     
     //GET COMPANY
     public void getCompany(){
          try {
            Connection con = DBconnexion.getConnection();
            String sql = "select * from company";
            PreparedStatement ps = con.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
     
                String Mycomp = rs.getString("name");
                cmb_cmpy.addItem(Mycomp);
               
           }
            
       } catch (Exception e) {
           JOptionPane.showMessageDialog(this, e);
       }
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_MedicineDetail = new rojerusan.RSTableMetro();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

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
        jPanel2.add(txt_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 115, -1));

        txt_qty.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.add(txt_qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 115, -1));

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
        jPanel2.add(date_exp, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 231, 25));
        jPanel2.add(date_fab, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 57, 231, 29));

        cmb_cmpy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmb_cmpy.setForeground(new java.awt.Color(0, 204, 51));
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

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 153, 51));
        jLabel18.setText("MANAGE MEDECINE");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 247, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 760, 500));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 51));
        jLabel5.setText("COMPANY");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(43, 43, 43))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 160, 50));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 51));
        jLabel4.setText("SELLING");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel4)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 160, 50));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 51));
        jLabel6.setText("AGENT");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel6)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 160, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 160, 500));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("x");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 30, 60));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 153, 51));
        jLabel17.setText("PHARMARSMART");
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 330, -1));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 930, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        updateMedicine1();
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
       //date_fab.setDateFormatString(model.getValueAt(rowNo, 4).toString());
      // date_exp.setDateFormatString(model.getValueAt(rowNo, 5).toString());
        try {
              java.util.Date df = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(rowNo, 4));
               date_fab.setDate(df);
              java.util.Date de = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(rowNo, 5));
              date_fab.setDate(de);
        } catch (Exception e) {
           // JOptionPane.showMessageDialog(this, e);
        }
    
      // date_exp.setDateFormatString(model.getValueAt(rowNo, 5).toString());
       cmb_cmpy.setSelectedItem(model.getValueAt(rowNo, 6).toString());
       
        
       btn_add.setEnabled(false);
       btn_delete.setEnabled(true);
       btn_update.setEnabled(true);
    }//GEN-LAST:event_tbl_MedicineDetailMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        Company cp = new Company();
        cp.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        selling sl = new selling();
        sl.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        Agents ag = new Agents();
        ag.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

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
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSTableMetro tbl_MedicineDetail;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_qty;
    // End of variables declaration//GEN-END:variables
}
