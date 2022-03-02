package rmi.mahasiswa.arry.code.server.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

//Class untuk membuat koneksi dengan database
public class DatabaseUtilities{
    private static Connection connection;
 
    public static Connection getConnection() {
        if (connection == null) {
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                //membuat koneksi dengan localhost dengan db 'mhsiswa', dengan user 'root'
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mhsiswa", "root", "");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        return connection;
    }
}
