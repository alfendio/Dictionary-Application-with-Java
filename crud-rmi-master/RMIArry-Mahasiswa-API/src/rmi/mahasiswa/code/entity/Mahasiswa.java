package rmi.mahasiswa.code.entity;

import java.io.Serializable;
 
//Class untuk menyimpan data yang akan masuk
public class Mahasiswa implements Serializable {
 
    //Deklarasi variable untuk mewakili entitas entitas database
    private String nama;
    private String npm;
    private String jurusan;
    private String alamat;
    private String phone;
    private String laporan; //variable tambahan untuk memberikan report kepada client

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLaporan() {
        return laporan;
    }

    public void setLaporan(String laporan) {
        this.laporan = laporan;
    }

 
    
}
