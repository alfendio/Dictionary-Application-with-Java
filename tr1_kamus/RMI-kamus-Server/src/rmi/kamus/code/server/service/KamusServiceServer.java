package rmi.kamus.code.server.service;

//Import package yang diperlukan
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import rmi.kamus.code.entity.Kamus;
import rmi.kamus.code.server.utilities.DatabaseUtilities;
import rmi.kamus.code.service.KamusService;

// Kelas Server Service berisi pengimplementasian method-method yang ada pada 
// pada Package API, Method inilah yang akan memproses permintaan dari client
public class KamusServiceServer extends UnicastRemoteObject implements KamusService {
   
    public KamusServiceServer() throws RemoteException {
    }
   
    //Method INSERT untuk penambahan data kedalam database
    @Override
    public Kamus insertKamus(Kamus kamus) throws RemoteException {
        System.out.println("[Server] Client memanggil fungsi insert");
        
        //Membuat variable statement yang akan diisi dengan perintah query
        PreparedStatement statement = null;
        
        try {
            //Membuat query Insert ke DB 
            statement = DatabaseUtilities.getConnection().prepareStatement( 
                    "INSERT INTO dictionary_dua VALUES (?,?,?,?)"); 
            
            //mengisi symbol '?' pada query dengan data yang diambil dari interface remote object / API
            statement.setString(1, kamus.getNomor());           
            statement.setString(2, kamus.getKata_indonesia());
            statement.setString(3, kamus.getJenis());
            statement.setString(4, kamus.getKata_inggris());
            
            
            //menjalankan perintah query diatas
            statement.executeUpdate();
            
            //Feedback ketika query berhasil dijalankan
            System.out.println("\t "+statement+"\n\t Permintaan berhasil diproses.\n"); //feedback untuk server
            
            
            return kamus;   //mengembalikan nilai yang dimasukkan ke variable kamus
                                
        } catch (SQLException e) {
            
            //Feedback ketika query gagal dijalankan
            System.out.println("\t Permintaan gagal diproses.\n");
            //kamus.setLaporan("Data Gagal Ditambahkan");
            e.printStackTrace();
            return kamus;
            
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception e) {        
                }
            }
        }
    }
        
    //Method UPDATE untuk mengedit data pada Db
    public Kamus updateKamus(Kamus kamus) throws RemoteException {
        System.out.println("[Server] Client memanggil fungsi update");
        
        //Membuat variable statement yang akan diisi dengan perintah query
        PreparedStatement statement = null;
        
        try {
            //membuat query UPDATE
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "UPDATE dictionary_dua SET kata_indonesia=?, jenis=?, kata_inggris=? WHERE dictionary_dua.nomor=?");
                    
            
            //mengisi symbol '?' pada query dengan data yang diambil dari interface remote object / API
                       
            
            statement.setString(1, kamus.getKata_indonesia());
            statement.setString(2, kamus.getJenis());
            statement.setString(3, kamus.getKata_inggris());
            statement.setString(4, kamus.getNomor());
            
            
            
            //menjalankan perintah query diatas
            statement.executeUpdate();
            
            //feedback ketika query berhasil dijalanlan
            System.out.println("\t "+statement+"\n\t Permintaan berhasil diproses.\n"); //feedback untuk server
            //kamus.setLaporan("Data Berhasil Diperabarui");  //feedback untuk client
            
            return kamus;   //mengembalikan nilai yang dimasukkan ke variable mahasiswa
                                
        
        } catch (SQLException e) {
            
            //feedback ketika query gagal dijalankan
            System.out.println("\t Permintaan gagal diproses.\n");
            //kamus.setLaporan("Data Gagal Diperbarui");
            e.printStackTrace();    //keterangan gagal lebih lanjut
            
            return kamus;   //mengembalikan nilai yang dimasukkan ke variable mahasiswa
                                
        
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
    }
    
    //Method DELETE untuk penghapusan data pada db
    @Override
    public Kamus deleteKamus(Kamus kamus) throws RemoteException {
        System.out.println("[Server] Client memanggil fungsi delete");
        
        //Membuat variable statement
        PreparedStatement statement = null;
        try {
            //mengisi statement dengan perintah query DELETE
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "DELETE FROM dictionary_dua WHERE nomor=?");
            
            //Mengisi simbol '?' pada query dengan Npm mahasiswa yang didapat dari interface remote object
            statement.setString(1, kamus.getNomor());
            
            //Menjalanakan query
            statement.executeUpdate();
            
            //feedback ketika query berhasil dijalankan
            System.out.println("\t "+statement+"\n\t Permintaan berhasil diproses.\n");
            //kamus.setLaporan("Data Berhasil Dihapus");
            return kamus;
            
        } catch (SQLException e) {
            //feedback ketika query gagal dijalankan
            System.out.println("\t Permintaan gagal diproses.\n");
            //kamus.setLaporan("Data Gagal Dihapus!");
            e.printStackTrace(); //keterangan kegagalan lebih lanjut
            return kamus;
            
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
 
    //Mengambil data yang ada pada db
    @Override
    public Kamus getKamus(String nomor) throws RemoteException {
        System.out.println("[Server] Client memanggil data pada database");
        
        //Membuat variable Statement
        PreparedStatement statement = null;
        try {
            //mengisi statement dengan perintah query untuk mendapatkan data berdasarkan nomor dari interface Remote object
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT * FROM dictionary WHERE nomor=? ");
            
            //Menjalankan perintah query
            ResultSet resultSet = statement.executeQuery();
            
            //membuat objek 'Kamus'
            Kamus kamus = null;
            //Menyimpan data data yang didapat berdasarkan NPM pada varibel mahasiswa
            if (resultSet.next()) {
                kamus = new Kamus();
                
                //record variable mahasiswa
                kamus.setNomor("nomor");
                kamus.setKata_indonesia(resultSet.getString("kata_indonesia"));
                kamus.setJenis(resultSet.getString("jenis"));
                kamus.setKata_inggris(resultSet.getString("kata_inggris"));
                
            }
            
            //feedback ketika query berhasil dijalankan
            System.out.println("\t Data berhasi ditampilkan.\n");
            return kamus;
            
        } catch (SQLException e) {
            //feedback ketika query gagal dijalankan
            e.printStackTrace(); //keterangan kegagalan
            return null;
            
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //Mengambil serluruh data yang ada pada DB
    @Override
    public List<Kamus> getAllKamus() throws RemoteException {
        System.out.println("[Server] Client memanggil data pada database");
        
        //membuat variable statement
        Statement statement = null;
        try {
            
            //membuat koneksi dengan database
            statement = DatabaseUtilities.getConnection().createStatement();
            
            //menjalankan query untuk mendapatkan seluruh data yang ada pada table mhsrmi
            ResultSet resultSet = statement.executeQuery("SELECT * FROM dictionary_dua");
            
            //membuat variable tipe data Array
            List<Kamus> list = new ArrayList<>();
            
            //infinity looping sampai seluruh data tersimpan
            while (resultSet.next()) {
                Kamus kamus = new Kamus();
                
                //menyimpan setiap data pada variable mahasiswa
                kamus.setNomor(resultSet.getString("nomor"));
                kamus.setKata_indonesia(resultSet.getString("kata_indonesia"));
                kamus.setJenis(resultSet.getString("jenis"));
                kamus.setKata_inggris(resultSet.getString("kata_inggris"));
                               
                list.add(kamus);
            }
            
            //feedback ketika query berhasil dijalankan
            System.out.println("\t Data berhasil ditampilkan.\n");
            
            return list;
            
        } catch (SQLException e) {
            //feedback ketika query gagal dijalankan
            e.printStackTrace();      
            return null;
        
        }  finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            
        } 
    } 

    

    

   

  
}