package rmi.mahasiswa.arry.code.server.service;

//Import package yang diperlukan
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import rmi.mahasiswa.code.entity.Mahasiswa;
import rmi.mahasiswa.arry.code.server.utilities.DatabaseUtilities;
import rmi.mahasiswa.code.service.MahasiswaService;

// Kelas Server Service berisi pengimplementasian method-method yang ada pada 
// pada Package API, Method inilah yang akan memproses permintaan dari client
public class MahasiswaServiceServer extends UnicastRemoteObject implements MahasiswaService {
   
    public MahasiswaServiceServer() throws RemoteException {
    }
   
    //Method INSERT untuk penambahan data kedalam database
    @Override
    public Mahasiswa insertMahasiswa(Mahasiswa mahasiswa) throws RemoteException {
        System.out.println("[Server] Client memanggil fungsi insert");
        
        //Membuat variable statement yang akan diisi dengan perintah query
        PreparedStatement statement = null;
        
        try {
            //Membuat query Insert ke DB 
            statement = DatabaseUtilities.getConnection().prepareStatement( 
                    "INSERT INTO `mhsrmi` VALUES (?,?,?,?,?)"); 
            
            //mengisi symbol '?' pada query dengan data yang diambil dari interface remote object / API
            statement.setString(1, mahasiswa.getNpm());           
            statement.setString(2, mahasiswa.getNama());
            statement.setString(3, mahasiswa.getJurusan());
            statement.setString(4, mahasiswa.getAlamat());
            statement.setString(5, mahasiswa.getPhone()); 
            
            //menjalankan perintah query diatas
            statement.executeUpdate();
            
            //Feedback ketika query berhasil dijalankan
            System.out.println("\t "+statement+"\n\t Permintaan berhasil diproses.\n"); //feedback untuk server
            mahasiswa.setLaporan("Data Berhasil Ditambahkan");  //feedback untuk client
            
            return mahasiswa;   //mengembalikan nilai yang dimasukkan ke variable mahasiswa
                                //dalam konteks ini adalah variable 'setLaporan' untuk feedback ke client.
        } catch (SQLException e) {
            
            //Feedback ketika query gagal dijalankan
            System.out.println("\t Permintaan gagal diproses.\n");
            mahasiswa.setLaporan("Data Gagal Ditambahkan");
            e.printStackTrace();
            return mahasiswa;
            
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
    @Override
    public Mahasiswa updateMahasiswa(Mahasiswa mahasiswa) throws RemoteException {
        System.out.println("[Server] Client memanggil fungsi update");
        
        //Membuat variable statement yang akan diisi dengan perintah query
        PreparedStatement statement = null;
        
        try {
            //membuat query UPDATE
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "UPDATE mhsrmi SET nama=?, jurusan=?, alamat=?, phone=? WHERE npm=?");
            
            //mengisi symbol '?' pada query dengan data yang diambil dari interface remote object / API
            statement.setString(1, mahasiswa.getNama());
            statement.setString(2, mahasiswa.getJurusan());
            statement.setString(3, mahasiswa.getAlamat());
            statement.setString(4, mahasiswa.getPhone());
            statement.setString(5, mahasiswa.getNpm());
            
            //menjalankan perintah query diatas
            statement.executeUpdate();
            
            //feedback ketika query berhasil dijalanlan
            System.out.println("\t "+statement+"\n\t Permintaan berhasil diproses.\n"); //feedback untuk server
            mahasiswa.setLaporan("Data Berhasil Diperabarui");  //feedback untuk client
            
            return mahasiswa;   //mengembalikan nilai yang dimasukkan ke variable mahasiswa
                                //dalam konteks ini adalah variable 'setLaporan' untuk feedback ke client.
        
        } catch (SQLException e) {
            
            //feedback ketika query gagal dijalankan
            System.out.println("\t Permintaan gagal diproses.\n");
            mahasiswa.setLaporan("Data Gagal Diperbarui");
            e.printStackTrace();    //keterangan gagal lebih lanjut
            
            return mahasiswa;   //mengembalikan nilai yang dimasukkan ke variable mahasiswa
                                //dalam konteks ini adalah variable 'setLaporan' untuk feedback ke client.
        
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
    public Mahasiswa deleteMahasiswa(Mahasiswa mahasiswa) throws RemoteException {
        System.out.println("[Server] Client memanggil fungsi delete");
        
        //Membuat variable statement
        PreparedStatement statement = null;
        try {
            //mengisi statement dengan perintah query DELETE
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "DELETE FROM mhsrmi WHERE npm=?");
            
            //Mengisi simbol '?' pada query dengan Npm mahasiswa yang didapat dari interface remote object
            statement.setString(1, mahasiswa.getNpm());
            
            //Menjalanakan query
            statement.executeUpdate();
            
            //feedback ketika query berhasil dijalankan
            System.out.println("\t "+statement+"\n\t Permintaan berhasil diproses.\n");
            mahasiswa.setLaporan("Data Berhasil Dihapus");
            return mahasiswa;
            
        } catch (SQLException e) {
            //feedback ketika query gagal dijalankan
            System.out.println("\t Permintaan gagal diproses.\n");
            mahasiswa.setLaporan("Data Gagal Dihapus!");
            e.printStackTrace(); //keterangan kegagalan lebih lanjut
            return mahasiswa;
            
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
    public Mahasiswa getMahasiswa(String npm) throws RemoteException {
        System.out.println("[Server] Client memanggil data pada database");
        
        //Membuat variable Statement
        PreparedStatement statement = null;
        try {
            //mengisi statement dengan perintah query untuk mendapatkan data berdasarkan NPM dari interface Remote object
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT * FROM mhsrmi WHERE Npm=? ");
            
            //Menjalankan perintah query
            ResultSet resultSet = statement.executeQuery();
            
            //membuat objek 'Mahasiswa'
            Mahasiswa mahasiswa = null;
            //Menyimpan data data yang didapat berdasarkan NPM pada varibel mahasiswa
            if (resultSet.next()) {
                mahasiswa = new Mahasiswa();
                
                //record variable mahasiswa
                mahasiswa.setNpm(npm);
                mahasiswa.setNama(resultSet.getString("nama"));
                mahasiswa.setJurusan(resultSet.getString("jurusan"));
                mahasiswa.setAlamat(resultSet.getString("alamat"));
                mahasiswa.setPhone(resultSet.getString("phone"));
            }
            
            //feedback ketika query berhasil dijalankan
            System.out.println("\t Data berhasi ditampilkan.\n");
            return mahasiswa;
            
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

    //Menagambil serluruh data yang ada pada Db
    @Override
    public List<Mahasiswa> getAllMahasiswa() throws RemoteException {
        System.out.println("[Server] Client memanggil data pada database");
        
        //membuat variable statement
        Statement statement = null;
        try {
            
            //membuat koneksi dengan database
            statement = DatabaseUtilities.getConnection().createStatement();
            
            //menjalankan query untuk mendapatkan seluruh data yang ada pada table mhsrmi
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mhsrmi ");
            
            //membuat variable tipe data Array
            List<Mahasiswa> list = new ArrayList<>();
            
            //infinity looping sampai seluruh data tersimpan
            while (resultSet.next()) {
                Mahasiswa mahasiswa = new Mahasiswa();
                
                //menyimpan setiap data pada variable mahasiswa
                mahasiswa.setNama(resultSet.getString("nama"));
                mahasiswa.setNpm(resultSet.getString("npm"));
                mahasiswa.setJurusan(resultSet.getString("jurusan"));
                mahasiswa.setAlamat(resultSet.getString("alamat"));
                mahasiswa.setPhone(resultSet.getString("phone"));                
                list.add(mahasiswa);
            }
            
            //feedback ketika query berhasil dijalankan
            System.out.println("\t Data berhasil ditampilkan.\n");
            
            return list;
            
        } catch (SQLException e) {
            //feedback ketika query gagal dijalankan
            e.printStackTrace();      
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

    //endofclass. Arry Febryan - 20160225200
}