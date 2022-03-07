/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.kamus.code.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import rmi.kamus.code.entity.Kamus;

/**
 *
 * @author ACER
 */
public interface KamusService extends Remote{
    
    Kamus insertKamus(Kamus kamus) throws RemoteException;
    
    Kamus updateKamus(Kamus kamus) throws RemoteException;
    
    Kamus deleteKamus(Kamus kamus) throws RemoteException;
    
    Kamus getKamus(String nomor) throws RemoteException;
    
    List<Kamus> getAllKamus() throws RemoteException;
}
