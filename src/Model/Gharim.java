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
public class Gharim extends Mustahiq{
    private String golongan;
    public Gharim(String id, String nama, String golongan, String alamat) {
        super(id, nama, golongan, alamat);
        this.golongan = golongan;
    }
    
}
