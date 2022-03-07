/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.kamus.code.server.utilities;

import java.sql.Connection;
//import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class DatabaseUtilities {
    private static Connection connection;
    
    public static Connection getConnection() {
        if(connection == null){
            try{
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kamus_tr1", "root", "");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        return connection;
    }
    
}
