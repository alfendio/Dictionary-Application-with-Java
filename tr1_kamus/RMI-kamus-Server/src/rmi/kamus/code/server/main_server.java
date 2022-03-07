/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.kamus.code.server;


import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.kamus.code.server.service.KamusServiceServer;
import rmi.kamus.code.server.utilities.DatabaseUtilities;
/**
 *
 * @author ACER
 */
public class main_server {
    
    public static void main(String[] args) throws RemoteException{
        System.out.println("INI ADALAH AKU, SERVER");
        
        try{
            int port = 2302;
            
            Registry server = LocateRegistry.createRegistry(port);
            
            KamusServiceServer userService = new KamusServiceServer();
            
            server.rebind("service", userService);
            
            System.out.println("Server berjalan di port "+port+" \n");
        }catch(RemoteException e){
            System.out.println("server gagal dijalankan"+e);
        }
    }
    
}
