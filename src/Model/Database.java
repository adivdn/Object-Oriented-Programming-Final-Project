/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Database {
    
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    private ArrayList<Muzzakki> muzzakki = new ArrayList<>();
    private ArrayList<Mustahiq> mustahiq = new ArrayList<>();
    private ArrayList<Zakat> zakat = new ArrayList<>();
   
    
    public ArrayList<Muzzakki> getMuzzakki(){
        return muzzakki;
    }
    public ArrayList<Mustahiq> getMustahiq(){
        return mustahiq;
    }
    public ArrayList<Zakat> getZakat(){
        return zakat;
    }

    public Database() {
        loadmustahiq();
        loadzakat();
        loadmuzzakki();
    }
    
   
    public void connect(){
        try{
            String url = "jdbc:mysql://localhost/zakat";
            String user = "root";
            String pass = "";
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
        }catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void disconnect(){
        try {
            conn.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public boolean manipulate(String query){
        boolean cek = false;
        try {
            int rows = stmt.executeUpdate(query);
            if (rows > 0) cek = true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cek;
    }
    
    public void loadmuzzakki(){
        connect();
        try{
            String query = "SELECT * from muzzakki";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                muzzakki.add(new Muzzakki(rs.getString("idZakat"),rs.getString("idMuzzakki"),rs.getString("namaMuzzakki"),
                rs.getString("alamat"),rs.getString("jiwa"),rs.getString("jenis"),rs.getString("total")));
            }
        }catch (SQLException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }
    
    public void loadmustahiq(){
        connect();
        try{
            String query = "SELECT * from mustahiq";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                mustahiq.add(new Mustahiq(rs.getString("id"),rs.getString("nama"),rs.getString("golongan"),rs.getString("alamat")));
            }
        }catch (SQLException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }
    public void loadzakat(){
        connect();
        try{
            String query = "SELECT * from tabzakat";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                zakat.add(new Zakat(rs.getString("idZakat"),rs.getString("id"),rs.getString("namaZakat")));
            }
        }catch (SQLException e){
             Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }
        disconnect();
    }
    
    public boolean LoginAdmin(String username,String Password){
        boolean cek = false;
        connect();
        try{
        
        String query = "SELECT username from admin where username = '" + username + "' and password = '"
                + Password + "'" ;
        
        rs = stmt.executeQuery(query);
        while (rs.next()){
            cek = true;
        }
        
        }catch (SQLException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return cek;
    }
    
    public void addmuzzakki(Muzzakki m){
        connect();
        String query = "INSERT INTO muzzakki VALUES (";
        query += "'" + m.getIdZakat() + "',";
        query += "'" + m.getIdMuzzakki() + "',";
        query += "'" + m.getNama() + "',";
        query += "'" + m.getAlamat() + "',";
        query += "'" + m.getJumlah() + "',";
        query += "'" + m.getJenis() + "',";
        query += "'" + m.getTotal() + "'";
        query += ")";
        if(manipulate(query)) muzzakki.add(m);
        disconnect();
    }
    
    public void addmustahiq (Mustahiq m){
        connect();
        String query = "INSERT INTO mustahiq VALUES (";
        query += "'" + m.getId() + "',";
        query += "'" + m.getNama() + "',";
        query += "'" + m.getGolongan() + "',";
        query += "'" + m.getAlamat() + "'";
        query += ")";
        if(manipulate(query)) mustahiq.add(m);
        disconnect();
    }
    
    public void addzakat(Zakat z){
        connect();
        String query  = "INSERT INTO tabzakat VALUES(";
        query += "'" + z.getIdZakat() + "',";
        query += "'" + z.getIdMustahiq() +"',";
        query += "'" + z.getNama() +"'";
        query += ")";
        if (manipulate(query)) zakat.add(z);
        disconnect();
    }
    
    public void delmustahiq(String id){
        connect();
        String query = "DELETE FROM mustahiq where id = '" + id + "' ";
        if(manipulate(query)){
            for(Mustahiq m :mustahiq){
                mustahiq.remove(m);
                break;
            }
        }
        disconnect();
    }
    
    public void delmuzzakki(String id){
        connect();
        String query = "DELETE FROM muzzakki WHERE idMuzzakki = '" + id + "'";
        if(manipulate(query)){
            for (Muzzakki m:muzzakki){
                if(m.getIdMuzzakki().equals(id)){
                    muzzakki.remove(m);
                    break;
                }
            }
        }
        disconnect();
    }
    public void delzakat(String id){
        connect();
        String query = "DELETE FROM tabzakat WHERE idZakat = '" + id + "'";
        if(manipulate(query)){
            for(Zakat z : zakat){
                if(z.getIdZakat().equals(id)){
                    zakat.remove(z);
                    break;
                }
            }
        }
        disconnect();
    }
    
    public void updateMuzzakki(Muzzakki m){
        connect();
        String query = "UPDATE muzzakki SET idZakat = '" + m.getIdZakat() + "',"
                       + "namaMuzzakki = '"+m.getNama()+"', "
                       + "alamat = '"+m.getAlamat()+"', "
                       + "jiwa = '"+m.getJumlah()+"', "
                       + "jenis = '"+m.getJenis()+"', "
                       + "total = '"+m.getTotal()+"' "
                       + "WHERE idMuzzakki = '" + m.getIdMuzzakki() + "' ";
        if (manipulate(query)){
            for (Muzzakki a : muzzakki){
                if(a.getIdMuzzakki().equals(m.getIdMuzzakki())){
                    a.setIdZakat(m.getIdZakat());
                    a.setNama(m.getNama());
                    a.setAlamat(m.getAlamat());
                    a.setJumlah(m.getJumlah());
                    a.setJenis(m.getJenis());
                    a.setTotal(m.getTotal());
                    break;
                }
            }
        }
        disconnect();    
    }
    public void updateMustahiq(Mustahiq m){
        connect();
        String query = "UPDATE mustahiq SET nama = '" + m.getNama() + "',"
                        + "golongan = '" + m.getGolongan() + "',"
                        + "alamat = '"+ m.getAlamat() +"' "
                        + "WHERE id = '" + m.getId() + "'";
        if (manipulate(query)){
            for(Mustahiq a : mustahiq){
                if(a.getId().equals(m.getId())){
                    a.setNama(m.getNama());
                    a.setGolongan(m.getGolongan());
                    a.setAlamat(m.getAlamat());
                    break;
                }
            }
        }
        disconnect();
    }
    public void updateZakat(Zakat z){
        connect();
        String query = "UPDATE tabzakat SET id = '" + z.getIdMustahiq() +"',"
                        +"namaZakat = '" + z.getNama() + "' "
                        +"WHERE idZakat = '" + z.getIdZakat() +"'";
        if (manipulate(query)){
            for(Zakat m : zakat){
                if(m.getIdZakat().equals(z.getIdZakat())){
                    m.setIdMustahiq(z.getIdZakat());
                    m.setNama(z.getNama());
                }
            }
        }
        disconnect();
    }
    
    public boolean cekIdMustahiq(String id){
        boolean cek = false;
        for(Mustahiq m : mustahiq){
            if(m.getId().equals(id)){
                cek = true;
                break;
            }
        }
        return cek;
    }
    
    public boolean cekIdZakat(String id){
        boolean cek = false;
        for(Zakat z : zakat){
            if(z.getIdZakat().equals(id)){
                cek = true;
                break;
            }
        }
        return cek;
    }
    public boolean cekIdMuzzakki(String id){
        boolean cek = false;
        for(Muzzakki m : muzzakki){
            if(m.getIdMuzzakki().equals(id)){
                cek = true;
                break;
            }
        }
        return cek;
    }
   
}
