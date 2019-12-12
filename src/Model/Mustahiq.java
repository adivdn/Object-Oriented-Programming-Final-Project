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
public class Mustahiq extends Person {
    
    private String id;
    private String nama;
    private String golongan;
    private String alamat;

    public Mustahiq(String id, String nama, String golongan, String alamat) {
        this.id = id;
        super.nama =nama;
        this.golongan = golongan;
        this.alamat = alamat;
    }

   

    
   
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGolongan() {
        return golongan;
    }

    public void setGolongan(String golongan) {
        this.golongan = golongan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    
    
    
    
    
}
