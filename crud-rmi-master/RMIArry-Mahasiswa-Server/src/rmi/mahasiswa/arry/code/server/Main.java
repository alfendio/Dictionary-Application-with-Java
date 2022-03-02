package rmi.mahasiswa.arry.code.server;
 
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.mahasiswa.arry.code.server.service.MahasiswaServiceServer;
import rmi.mahasiswa.arry.code.server.utilities.DatabaseUtilities;
 
//Class Main Server
public class Main{
    
    public static void main(String[] args) throws RemoteException {
        
        System.out.println("====================================================");
        System.out.println("=====           Server siap Mbak             =======");
        System.out.println("====================================================");
        
        try{
        //Port yang digunakan
        int port = 2302;
        
        //Mendaftarkan Remote Interface untuk server pada port 2302 
        Registry server = LocateRegistry.createRegistry(port);
        //Membuat Objek MahasiswaServiceServer
        MahasiswaServiceServer userService = new MahasiswaServiceServer();
        
        //Mendaftarkan Obejek userService dengan nama "service" pada port RMI
        server.rebind("service", userService);
        
        //Feedback ketika Server RMI berhasil dijalankan
        System.out.println("[Server] Server sedang berjalan Mbak, pada port "+port+"...\n");
        }catch(RemoteException e){
            //Feedback ketika Server RMI gagl dijalankan
            System.out.println("[Server] Server gagal dijalankan Mbak, baca keterangan lebih lanjut..\n\t "+e);
        }
    }
}