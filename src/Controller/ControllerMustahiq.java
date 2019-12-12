/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.Mustahiq;
import View.MainMustahiq;
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
public class ControllerMustahiq extends MouseAdapter implements ActionListener {
    private MainMustahiq view;
    private Database db;

    public ControllerMustahiq() {
        view = new MainMustahiq();
        db = new Database();
        view.setVisible(true);
        view.addActionListener(this);
        view.addMouseAdapter(this);
        loadTableMustahiq();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getjButton_tambahMustahiq())){
            btnTambahActionPerfomed();
            loadTableMustahiq();
            
        }else if(source.equals(view.getjButton_deleteMustahiq())){
            btnDeleteActionPerformed();
            loadTableMustahiq();
        }else if(source.equals(view.getjButton_updateMustahiq())){
            btnUpdateActionPerformed();
            loadTableMustahiq();
        }else if(source.equals(view.getjButton_ResetMustahiq())){
            btnResetActionPerformed();
            loadTableMustahiq();
        }else if(source.equals(view.getjButton_kembaliMustahiq())){
            btnKembaliActionPerformed();
        }
    }
    
    public void loadTableMustahiq(){
        DefaultTableModel model1 = new DefaultTableModel(new String[]{"Id Mustahiq","Nama Mustahiq","Golongan","Alamat"},0);
        ArrayList<Mustahiq> mustahiq = db.getMustahiq();
        for (Mustahiq m :mustahiq){
            model1.addRow(new Object[]{m.getId(),m.getNama(),m.getGolongan(),m.getAlamat()});
        }
        view.setjTableMustahiq(model1);
    }
    
    public void btnTambahActionPerfomed(){
        String id = view.getjTextField_idMustahiq();
        String nama = view.getjTextField_namaMustahiq();
        String golongan = view.getjComboBox_golMustahiq();
        String alamat = view.getjTextField_alamatMustahiq();
        
        if(id.isEmpty() || nama.isEmpty() || golongan.isEmpty() || alamat.isEmpty() ){
            view.showMessage("Tidak Boleh Kosong", "Error", 0);
        }else{
            if(db.cekIdMustahiq(id)){
                view.showMessage("Id Sama Gan", "Error", 0);
            }else{
                db.addmustahiq(new Mustahiq(id,nama,golongan,alamat));
                view.Reset();
                view.showMessage("Data Berhasil Ditambah", "Success", 1);
                
            }
        }
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getjTableMustahiq())){
            int i = view.getSelectedMustahiq();
            String id = view.getjTableMustahiq().getModel().getValueAt(i, 0).toString();
            String nama = view.getjTableMustahiq().getModel().getValueAt(i, 1).toString();
            String golongan = view.getjTableMustahiq().getModel().getValueAt(i, 2).toString();
            String alamat = view.getjTableMustahiq().getModel().getValueAt(i, 3).toString();
            
            view.setjTextField_idMustahiq(id);
            view.setjTextField_namaMustahiq(nama);
            view.setjComboBox_golMustahiq(golongan);
            view.setjTextField_alamatMustahiq(alamat);
            
        }
    }
    public void btnDeleteActionPerformed(){
        String id = view.getjTextField_idMustahiq();
        if(id.isEmpty()){
            view.showMessage("Tidak Boleh Kosong", "Error", 0);
        }else{
            db.delmustahiq(id);
            view.Reset();
            view.showMessage("Berhasil Gan", "Success", 1);
        }
    }
    
    public void btnResetActionPerformed(){
        view.Reset();
    }
    
    public void btnUpdateActionPerformed(){
        String id = view.getjTextField_idMustahiq();
        String nama = view.getjTextField_namaMustahiq();
        String golongan = view.getjComboBox_golMustahiq();
        String alamat = view.getjTextField_alamatMustahiq();
        
        if(id.isEmpty() || nama.isEmpty() || golongan.isEmpty() || alamat.isEmpty() ){
            view.showMessage("Tidak Boleh Kosong", "Error", 0);
        }else{
            if(!db.cekIdMustahiq(id)){
                view.showMessage("Id Sama Gan", "Error", 0);
            }else{
                db.updateMustahiq(new Mustahiq(id,nama,golongan,alamat));
                view.Reset();
                view.showMessage("Data Berhasil Ditambah", "Success", 1);
                
            }
        }
    }
    
    public void btnKembaliActionPerformed(){
        view.dispose();
        MainRoute m = new MainRoute();
        m.setVisible(true);
        
    }
    
}
