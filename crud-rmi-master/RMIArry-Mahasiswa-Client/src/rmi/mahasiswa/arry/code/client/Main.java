package rmi.mahasiswa.arry.code.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.SwingUtilities;
import rmi.mahasiswa.arry.code.client.view.FormClient;
import rmi.mahasiswa.code.service.MahasiswaService;

//class main client
public class Main{
    public static void main(String[] args) throws RemoteException, NotBoundException {
        System.out.println("====================================================");
        System.out.println("=====      Baik Mas saya juga udah siap      =======");
        System.out.println("===================================================="); 
        
        try{
        //port yang digunakan
        int port = 2302;
        
        //getRegistry, Menghubungkan interface client dengan server yg telah dibuat
        Registry client = LocateRegistry.getRegistry("localhost", port);
        //membuat objek 'Remote Object' MahasiswaService yang ada di Program API
        MahasiswaService service = (MahasiswaService) client.lookup("service");
        
        //Menjalankan JFrame client yang telah dibuat
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FormClient formMahasiswa= new FormClient(service);
                formMahasiswa.setVisible(true); 
            }
        });
        
        //Feedback ketika client berhasil dijalnkan
        System.out.println("[Client] Client berhasil berjalan Mas........");
        }catch(RemoteException e){
            //Feedback ketika client gagal dijalankan
            System.out.println("[Client] Client gagal dijalankan Mas, baca keterangan lebih lanjut..\n\t "+e);
        }
    
    }
}
