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
public class Fakir extends Mustahiq{
    private String golongan;
    
    public Fakir(String id, String nama, String golongan, String alamat) {
        super(id, nama, golongan, alamat);
        this.golongan = golongan;
    }

    /**
     * @return the Golongan
     */
    public String getGolongan() {
        return golongan;
    }

    /**
     * @param golongan the Golongan to set
     */
    public void setGolongan(String golongan) {
        this.golongan = golongan;
    }
    

    
    }
    

