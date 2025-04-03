/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_pharmacie;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author samuel Njoya
 */
public class DBconnexion {
    
    static  Connection con = null;

    public static Connection getConnection(){

            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/pharmacy_ms","root","");
            } catch (Exception e) {
               JOptionPane.showMessageDialog(null, e);
            }
         return  con;
    }
    
    
}
