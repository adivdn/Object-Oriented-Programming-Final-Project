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
public class Muallaf extends Mustahiq{
    private String golongan;
    public Muallaf(String id, String nama, String golongan, String alamat) {
        super(id, nama, golongan, alamat);
        this.golongan =golongan;
    }

    
    public String getGolongan() {
        return golongan;
    }

    public void setGolongan(String golongan) {
        this.golongan = golongan;
    }
    
}
