/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.Zakat;
import View.MainRoute;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import view.MainZakat;

/**
 *
 * @author ADIV
 */
public class ControllerZakat extends MouseAdapter implements ActionListener {
    private MainZakat view;
    private Database db;
    
    
    public ControllerZakat() {
        view = new MainZakat();
        db = new Database();
        view.setVisible(true);
        view.addActionListener(this);
        view.addMouseAdapter(this);
        view.isiMustahiq();
        loadtableZakat();
        
        
    }
    
    public void loadtableZakat(){
        DefaultTableModel model2 = new DefaultTableModel(new String[]{"Id Zakat","Id Mustahiq","Nama Zakat"},0);
        ArrayList<Zakat> zakat = db.getZakat();
        for(Zakat z : zakat){
            model2.addRow(new Object[]{z.getIdZakat(),z.getIdMustahiq(),z.getNama()});
        }
        view.setjTableZakat(model2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       Object source = e.getSource();
       if(source.equals(view.getjButton_tambahZakat())){
           btnTambahActionPerfomed();
           loadtableZakat();
       }else if(source.equals(view.getjButton_deleteZakat())){
           btnDeleteActionPerformed();
           loadtableZakat();
       }else if(source.equals(view.getjButton_updateZakat())){
           btnUpdateActionPerformed();
           loadtableZakat();
       }else if(source.equals(view.getjButton_ResetZakat())){
           btnResetActionPeformed();
           loadtableZakat();
       }else if(source.equals(view.getjButton_kembaliZakat())){
           btnKembaliActionPerformed();
       }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getjTableZakat())){
            int i = view.getSelectedZakat();
            String idZakat = view.getjTableZakat().getModel().getValueAt(i, 0).toString();
            String idMustahiq = view.getjTableZakat().getModel().getValueAt(i, 1).toString();
            String nama = view.getjTableZakat().getModel().getValueAt(i, 2).toString();
            
            view.setjTextField_idZakat(idZakat);
            view.setjComboBox_idMustahiq(idMustahiq);
            view.setjTextField_namaZakat(nama);
        }
    }
    
     public void btnTambahActionPerfomed(){
        String idzakat = view.getjTextField_idZakat();
        String idmustahiq = view.getjComboBox_idMustahiq();
        String nama = view.getjTextField_namaZakat();
        
        if(idzakat.isEmpty() || nama.isEmpty()){
            view.showMessage("Tidak Boleh Kosong", "Error", 0);
        }else{
            if(db.cekIdZakat(idzakat)){
                view.showMessage("Id Sama Gan", "Error", 0);
            }else{
                db.addzakat(new Zakat(idzakat,idmustahiq,nama));
                view.Reset();
                view.showMessage("Data Berhasil Ditambah", "Success", 1);
                
            }
        }
    }
     
     public void btnDeleteActionPerformed(){
         String id = view.getjTextField_idZakat();
         if(id.isEmpty()){
            view.showMessage("Tidak Boleh Kosong", "Error", 0);
        }else{
            db.delzakat(id);
            view.Reset();
            view.showMessage("Berhasil Gan", "Success", 1);
        }
     }
     
     public void btnResetActionPeformed(){
         view.Reset();
     }
     
     public void btnUpdateActionPerformed(){
        String idzakat = view.getjTextField_idZakat();
        String idmustahiq = view.getjComboBox_idMustahiq();
        String nama = view.getjTextField_namaZakat();
      
        
        if(idzakat.isEmpty() || nama.isEmpty() || idmustahiq.isEmpty()){
            view.showMessage("Tidak Boleh Kosong", "Error", 0);
        }else{
            if(!db.cekIdZakat(idzakat)){
                view.showMessage("Id Sama Gan", "Error", 0);
            }else{
                db.updateZakat(new Zakat(idzakat,idmustahiq,nama));
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
