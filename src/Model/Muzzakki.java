/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ADIV
 */
public class Muzzakki extends Person {
    
    public String idZakat;
    public String idMuzzakki;
    public String alamat;
    public String jumlah;
    public String jenis;
    public String total;

    public Muzzakki(String idZakat, String idMuzzakki, String nama, String alamat, String jumlah, String jenis, String total) {
        this.idZakat = idZakat;
        this.idMuzzakki = idMuzzakki;
        super.nama = nama;
        this.alamat = alamat;
        this.jumlah = jumlah;
        this.jenis = jenis;
        this.total = total;
    }

    public String getIdZakat() {
        return idZakat;
    }

    public void setIdZakat(String idZakat) {
        this.idZakat = idZakat;
    }

    public String getIdMuzzakki() {
        return idMuzzakki;
    }

    public void setIdMuzzakki(String idMuzzakki) {
        this.idMuzzakki = idMuzzakki;
    }

    

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    

    
    
    
    
    
}
