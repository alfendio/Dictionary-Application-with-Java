package rmi.mahasiswa.code.service;

import java.rmi.Remote; 
import java.rmi.RemoteException;
import java.util.List; 
import rmi.mahasiswa.code.entity.Mahasiswa;

//Class Interface yang nantinya akan menjebatani permintaan client ke server 
//sebagai Remote Object
public interface MahasiswaService extends Remote {
    
    Mahasiswa insertMahasiswa(Mahasiswa mahasiswa) throws RemoteException;

    Mahasiswa updateMahasiswa(Mahasiswa mahasiswa) throws RemoteException;

    Mahasiswa deleteMahasiswa(Mahasiswa mahasiswa) throws RemoteException;

    Mahasiswa getMahasiswa(String npm) throws RemoteException;

    List<Mahasiswa> getAllMahasiswa() throws RemoteException;
}
