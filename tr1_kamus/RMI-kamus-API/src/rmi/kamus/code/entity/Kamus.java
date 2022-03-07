/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.kamus.code.entity;

import java.io.Serializable;

/**
 *
 * @author ACER
 */
public class Kamus implements Serializable{
    
    private String nomor;
    private String kata_indonesia;
    private String jenis;
    private String kata_inggris;

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getKata_indonesia() {
        return kata_indonesia;
    }

    public void setKata_indonesia(String kata_indonesia) {
        this.kata_indonesia = kata_indonesia;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getKata_inggris() {
        return kata_inggris;
    }

    public void setKata_inggris(String kata_inggris) {
        this.kata_inggris = kata_inggris;
    }
    
}
