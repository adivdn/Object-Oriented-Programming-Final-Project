/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.Muzzakki;
import View.MainMuzzakki;
import View.MainRoute;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADIV
 */
public class ControllerMuzzakki extends MouseAdapter implements ActionListener {
    private MainMuzzakki view;
    private Database db;

    public ControllerMuzzakki() {
        view = new MainMuzzakki();
        db = new Database();
        view.addActionListener(this);
        view.addMouseAdapter(this);
        view.setVisible(true);
        view.isiZakat();
        loadtableMuzzakki();
        
    }

    public void loadtableMuzzakki(){
        DefaultTableModel model3 = new DefaultTableModel(new String[]{"Id Zakat","Id Muzzakki","Nama","Alamat"
                                   ,"Jumlah","Jenis","Total"},0);
        ArrayList<Muzzakki> muzzakki = db.getMuzzakki();
        for(Muzzakki m : muzzakki){
            model3.addRow(new Object[]{m.getIdZakat(),m.getIdMuzzakki(),m.getNama(),m.getAlamat(),m.getJumlah(),m.getJenis()
                            ,m.getTotal()});
        }
        view.setjTable_muzakki(model3);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
         Object source = e.getSource();
       if(source.equals(view.getjButton_TambahMuzakki())){
           btnTambahActionPerfomed();
           loadtableMuzzakki();
       }else if(source.equals(view.getjButton_deleteMuzakki())){
           btnDeleteActionPerformed();
           loadtableMuzzakki();
       }else if(source.equals(view.getjButton_updateMuzakki())){
           btnUpdateActionPerformed();
           loadtableMuzzakki();
       }else if(source.equals(view.getjButtonReset())){
           btnResetActionPeformed();
           loadtableMuzzakki();
       }else if(source.equals(view.getjButton_kembaliMuzakki())){
           btnKembaliActionPerformed();
       }else if(source.equals(view.getjButton_Hitung())){
           try{
               if(view.getJenis().equals("Beras")){
                   view.setjTextField_totalMuzakki(String.valueOf(Integer.parseInt(view.getjTextField_jumlahAnggotaKeluargaMuzakki())
                   * (5/2)));
                   view.getjButton_Hitung().setEnabled(true);
               }else{
                   view.setjTextField_totalMuzakki(String.valueOf(Integer.parseInt(view.getjTextField_jumlahAnggotaKeluargaMuzakki())
                   * 15000));
                    view.getjButton_Hitung().setEnabled(true);
               }
           }catch(NumberFormatException ae){
               view.showMessage("Ada Salah Gan", "Error", 0);
           }
       }
    }

    
    @Override
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getjTable_muzakki())){
            int i = view.getSelectedMuzzakki();
            String idZakat = view.getjTable_muzakki().getModel().getValueAt(i, 0).toString();
            String idMuzzakki = view.getjTable_muzakki().getModel().getValueAt(i, 1).toString();
            String nama = view.getjTable_muzakki().getModel().getValueAt(i, 2).toString();
            String alamat = view.getjTable_muzakki().getModel().getValueAt(i, 3).toString();
            String jumlah = view.getjTable_muzakki().getModel().getValueAt(i, 4).toString();
            
            
            
            
            view.setjComboBox_idZakat(idZakat);
            view.setjTextField_idMuzakki(idMuzzakki);
            view.setjTextField_namaMuzakki(nama);
            view.setjTextField_alamatMuzakki(alamat);
            view.setjTextField_jumlahAnggotaKeluargaMuzakki(jumlah);
            
            
            
        }
    }
     public void btnTambahActionPerfomed(){
        String idzakat = view.getjComboBox_idZakat();
        String idmuzzakki = view.getjTextField_idMuzakki();
        String nama = view.getjTextField_namaMuzakki();
        String alamat = view.getjTextField_alamatMuzakki();
        String jumlah = view.getjTextField_jumlahAnggotaKeluargaMuzakki();
        String jenis = view.getJenis();
        String total = view.getjTextField_totalMuzakki();
        
        if(idmuzzakki.isEmpty() || nama.isEmpty() || alamat.isEmpty() || jumlah.isEmpty() || jenis.isEmpty() || total.isEmpty() ){
            view.showMessage("Tidak Boleh Kosong", "Error", 0);
        }else{
            if(db.cekIdMuzzakki(idmuzzakki)){
                view.showMessage("Id Sama Gan", "Error", 0);
            }else{
                db.addmuzzakki(new Muzzakki(idzakat,idmuzzakki,nama,alamat,jumlah,jenis,total));
                view.Reset();
                view.showMessage("Data Berhasil Ditambah", "Success", 1);
                
            }
        }
    }
     
     public void btnDeleteActionPerformed(){
         String id = view.getjTextField_idMuzakki();
         if(id.isEmpty()){
            view.showMessage("Tidak Boleh Kosong", "Error", 0);
        }else{
            db.delmuzzakki(id);
            view.Reset();
            view.showMessage("Berhasil Gan", "Success", 1);
        }
     }
     
     public void btnResetActionPeformed(){
         view.Reset();
     }
     
     public void btnUpdateActionPerformed(){
        String idzakat = view.getjComboBox_idZakat();
        String idmuzzakki = view.getjTextField_idMuzakki();
        String nama = view.getjTextField_namaMuzakki();
        String alamat = view.getjTextField_alamatMuzakki();
        String jumlah = view.getjTextField_jumlahAnggotaKeluargaMuzakki();
        String jenis = view.getJenis();
        String total = view.getjTextField_totalMuzakki();
        
        if(idmuzzakki.isEmpty() || alamat.isEmpty() || nama.isEmpty() || jumlah.isEmpty()){
            view.showMessage("Tidak Boleh Kosong", "Error", 0);
        }else{
            if(!db.cekIdMuzzakki(idmuzzakki)){
                view.showMessage("Id Sama Gan", "Error", 0);
            }else{
                db.updateMuzzakki(new Muzzakki(idzakat,idmuzzakki,nama,alamat,jumlah,jenis,total));
                view.Reset();
                view.showMessage("Data Berhasil Diubah", "Success", 1);
                
            }
        }
     }
    public void btnKembaliActionPerformed(){
        view.dispose();
        MainRoute m = new MainRoute();
        m.setVisible(true);
    }
    
    
}
