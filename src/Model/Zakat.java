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
public class Zakat extends Person {
    
    public String idZakat;
    public String idMustahiq;

    public Zakat(String idZakat, String idMustahiq, String nama) {
        this.idZakat = idZakat;
        this.idMustahiq = idMustahiq;
        super.nama = nama;
    }
    
    

    public String getIdZakat() {
        return idZakat;
    }

    public void setIdZakat(String idZakat) {
        this.idZakat = idZakat;
    }

    public String getIdMustahiq() {
        return idMustahiq;
    }

    public void setIdMustahiq(String idMustahiq) {
        this.idMustahiq = idMustahiq;
    }

     
}
