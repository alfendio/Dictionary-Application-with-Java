package rmi.kamus.code.client;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.SwingUtilities;
import rmi.kamus.code.client.view.FormClient;
import rmi.kamus.code.service.KamusService;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class main_client {
    public static void main(String[] args) throws RemoteException, NotBoundException{
        System.out.println("INI SERVER");
        
        try{
            int port = 2302;
            
            Registry client = LocateRegistry.getRegistry("localhost", port);
            
            KamusService service = (KamusService) client.lookup("service");
            
            
            SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FormClient formKamus = new FormClient(service);
                formKamus.setVisible(true);
            }
        });
            
            System.out.println("client berhasil berjalan");
        } catch (RemoteException e) {
            System.out.println("client gagal berjalan"+e);
        }
        
    }
}
