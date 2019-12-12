/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import View.MainGUI;
import View.MainRoute;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author ADIV
 */



public class ControllerLogin implements ActionListener {
    private MainGUI view;
    private Database db;

    public ControllerLogin() {
        view = new MainGUI();
        db = new Database();
      
        view.setVisible(true);
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       Object source = e.getSource();
       if(source.equals(view.getjLogin())){
           db = new Database();
           String username = view.getjUsername();
           String password = view.getjPassword();
           
           if(db.LoginAdmin(username, password)){
               view.dispose();
               MainRoute m = new MainRoute();
               m.setVisible(true);
              
           }else{
               view.reset();
               JOptionPane.showMessageDialog(view, "Username atau Password Salah");
               
           }
           
           
       }
    
  
    }
}
