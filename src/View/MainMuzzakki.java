/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADIV
 */
public class MainMuzzakki extends javax.swing.JFrame {

    /**
     * Creates new form MainMuzzakki
     */
     
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    public MainMuzzakki() {
        initComponents();
        setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonJenis = new javax.swing.ButtonGroup();
        jPanel_Muzakki = new javax.swing.JPanel();
        jScrollPane_muzakki = new javax.swing.JScrollPane();
        jTable_muzakki = new javax.swing.JTable();
        jLabel_idZakat = new javax.swing.JLabel();
        jLabel_idMuzakki = new javax.swing.JLabel();
        jLabel_namaMuzakki = new javax.swing.JLabel();
        jLabel_alamatMuzakki = new javax.swing.JLabel();
        jLabel_jumlahAnggotaKeluargaMuzakki = new javax.swing.JLabel();
        jLabel_jenisPembayaran = new javax.swing.JLabel();
        jRadioButton_jenisPembayaranBeras = new javax.swing.JRadioButton();
        jRadioButton_JenisPembayaranUang = new javax.swing.JRadioButton();
        jTextField_idMuzakki = new javax.swing.JTextField();
        jComboBox_idZakat = new javax.swing.JComboBox<>();
        jTextField_namaMuzakki = new javax.swing.JTextField();
        jTextField_alamatMuzakki = new javax.swing.JTextField();
        jTextField_jumlahAnggotaKeluargaMuzakki = new javax.swing.JTextField();
        jTextField_totalMuzakki = new javax.swing.JTextField();
        jButton_TambahMuzakki = new javax.swing.JButton();
        jButton_deleteMuzakki = new javax.swing.JButton();
        jButton_updateMuzakki = new javax.swing.JButton();
        jButton_kembaliMuzakki = new javax.swing.JButton();
        jLabel_judulMuzakki = new javax.swing.JLabel();
        jButtonReset = new javax.swing.JButton();
        jButton_Hitung = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel_Muzakki.setBackground(new java.awt.Color(44, 62, 80));

        jTable_muzakki.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jScrollPane_muzakki.setViewportView(jTable_muzakki);

        jLabel_idZakat.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_idZakat.setText("ID Zakat ");

        jLabel_idMuzakki.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_idMuzakki.setText("ID Muzzakki");

        jLabel_namaMuzakki.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_namaMuzakki.setText("Nama Muzakki");

        jLabel_alamatMuzakki.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_alamatMuzakki.setText("Alamat");

        jLabel_jumlahAnggotaKeluargaMuzakki.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_jumlahAnggotaKeluargaMuzakki.setText("Jumlah Anggota Keluarga");

        jLabel_jenisPembayaran.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_jenisPembayaran.setText("Jenis Pembayaran");

        jRadioButton_jenisPembayaranBeras.setBackground(new java.awt.Color(102, 255, 255));
        buttonJenis.add(jRadioButton_jenisPembayaranBeras);
        jRadioButton_jenisPembayaranBeras.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jRadioButton_jenisPembayaranBeras.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton_jenisPembayaranBeras.setText("Beras");
        jRadioButton_jenisPembayaranBeras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_jenisPembayaranBerasActionPerformed(evt);
            }
        });

        jRadioButton_JenisPembayaranUang.setBackground(new java.awt.Color(102, 255, 255));
        buttonJenis.add(jRadioButton_JenisPembayaranUang);
        jRadioButton_JenisPembayaranUang.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jRadioButton_JenisPembayaranUang.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton_JenisPembayaranUang.setText("Uang");

        jButton_TambahMuzakki.setBackground(new java.awt.Color(102, 255, 51));
        jButton_TambahMuzakki.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jButton_TambahMuzakki.setText("Tambah");
        jButton_TambahMuzakki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TambahMuzakkiActionPerformed(evt);
            }
        });

        jButton_deleteMuzakki.setBackground(new java.awt.Color(255, 51, 51));
        jButton_deleteMuzakki.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jButton_deleteMuzakki.setText("Delete");

        jButton_updateMuzakki.setBackground(new java.awt.Color(204, 204, 255));
        jButton_updateMuzakki.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jButton_updateMuzakki.setText("Update");

        jButton_kembaliMuzakki.setBackground(new java.awt.Color(255, 255, 153));
        jButton_kembaliMuzakki.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jButton_kembaliMuzakki.setText("Kembali");

        jLabel_judulMuzakki.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_judulMuzakki.setFont(new java.awt.Font("Consolas", 0, 48)); // NOI18N
        jLabel_judulMuzakki.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_judulMuzakki.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_judulMuzakki.setText("Data Muzzakki");

        jButtonReset.setBackground(new java.awt.Color(51, 255, 255));
        jButtonReset.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jButtonReset.setText("Reset");

        jButton_Hitung.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Hitung.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jButton_Hitung.setText("Hitung");

        javax.swing.GroupLayout jPanel_MuzakkiLayout = new javax.swing.GroupLayout(jPanel_Muzakki);
        jPanel_Muzakki.setLayout(jPanel_MuzakkiLayout);
        jPanel_MuzakkiLayout.setHorizontalGroup(
            jPanel_MuzakkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_MuzakkiLayout.createSequentialGroup()
                .addGroup(jPanel_MuzakkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_MuzakkiLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane_muzakki, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_MuzakkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_MuzakkiLayout.createSequentialGroup()
                                .addComponent(jLabel_idMuzakki)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel_MuzakkiLayout.createSequentialGroup()
                                .addGroup(jPanel_MuzakkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel_MuzakkiLayout.createSequentialGroup()
                                        .addGroup(jPanel_MuzakkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel_jumlahAnggotaKeluargaMuzakki)
                                            .addComponent(jLabel_idZakat)
                                            .addComponent(jLabel_namaMuzakki)
                                            .addComponent(jLabel_alamatMuzakki)
                                            .addComponent(jLabel_jenisPembayaran))
                                        .addGap(34, 34, 34))
                                    .addGroup(jPanel_MuzakkiLayout.createSequentialGroup()
                                        .addGroup(jPanel_MuzakkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jButton_Hitung, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton_TambahMuzakki, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonReset)
                                        .addGap(7, 7, 7)))
                                .addGroup(jPanel_MuzakkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel_MuzakkiLayout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jButton_updateMuzakki)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton_deleteMuzakki))
                                    .addGroup(jPanel_MuzakkiLayout.createSequentialGroup()
                                        .addComponent(jRadioButton_jenisPembayaranBeras, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButton_JenisPembayaranUang, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                                    .addComponent(jTextField_idMuzakki)
                                    .addComponent(jComboBox_idZakat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField_namaMuzakki)
                                    .addComponent(jTextField_alamatMuzakki)
                                    .addComponent(jTextField_jumlahAnggotaKeluargaMuzakki)
                                    .addComponent(jTextField_totalMuzakki)))))
                    .addGroup(jPanel_MuzakkiLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_judulMuzakki, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addComponent(jButton_kembaliMuzakki)))
                .addGap(40, 40, 40))
        );
        jPanel_MuzakkiLayout.setVerticalGroup(
            jPanel_MuzakkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_MuzakkiLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel_MuzakkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_kembaliMuzakki)
                    .addComponent(jLabel_judulMuzakki, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel_MuzakkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_MuzakkiLayout.createSequentialGroup()
                        .addGroup(jPanel_MuzakkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_idZakat)
                            .addComponent(jComboBox_idZakat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_MuzakkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_idMuzakki)
                            .addComponent(jTextField_idMuzakki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_MuzakkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_namaMuzakki)
                            .addComponent(jTextField_namaMuzakki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_MuzakkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_alamatMuzakki)
                            .addComponent(jTextField_alamatMuzakki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_MuzakkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_jumlahAnggotaKeluargaMuzakki)
                            .addComponent(jTextField_jumlahAnggotaKeluargaMuzakki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel_MuzakkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_jenisPembayaran)
                            .addComponent(jRadioButton_jenisPembayaranBeras)
                            .addComponent(jRadioButton_JenisPembayaranUang))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_MuzakkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_totalMuzakki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Hitung))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_MuzakkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_TambahMuzakki)
                            .addComponent(jButton_deleteMuzakki)
                            .addComponent(jButton_updateMuzakki)
                            .addComponent(jButtonReset)))
                    .addComponent(jScrollPane_muzakki, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Muzakki, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Muzakki, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton_jenisPembayaranBerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_jenisPembayaranBerasActionPerformed
        // TODO add your handling code here:
//            int a;
//            a = Integer.parseInt(getjTextField_jumlahAnggotaKeluargaMuzakki()) * 15000;
//            setjTextField_totalMuzakki(Integer.toString(a));
//        
    }//GEN-LAST:event_jRadioButton_jenisPembayaranBerasActionPerformed

    private void jButton_TambahMuzakkiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TambahMuzakkiActionPerformed
        // TODO add your handling code here:
//            int a;
//            a = Integer.parseInt(getjTextField_jumlahAnggotaKeluargaMuzakki()) * (5/2);
//            setjTextField_totalMuzakki(Integer.toString(a));
//        
    }//GEN-LAST:event_jButton_TambahMuzakkiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMuzzakki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMuzzakki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMuzzakki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMuzzakki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMuzzakki().setVisible(true);
            }
        });
    }

    public JButton getjButton_TambahMuzakki() {
        return jButton_TambahMuzakki;
    }

    public JButton getjButton_deleteMuzakki() {
        return jButton_deleteMuzakki;
    }

    public JButton getjButton_kembaliMuzakki() {
        return jButton_kembaliMuzakki;
    }

    public JButton getjButton_updateMuzakki() {
        return jButton_updateMuzakki;
    }

    public String getjComboBox_idZakat() {
        return jComboBox_idZakat.getSelectedItem().toString();
    }

    public void setjComboBox_idZakat(String x) {
        jComboBox_idZakat.setSelectedItem(x);
    }
    public int getSelectedMuzzakki(){
        return jTable_muzakki.getSelectedRow();
    }

    public void setjTable_muzakki(DefaultTableModel x) {
        jTable_muzakki.setModel(x);
    }
    

    public String getjTextField_alamatMuzakki() {
        return jTextField_alamatMuzakki.getText();
    }

    public void setjTextField_alamatMuzakki(String x) {
        jTextField_alamatMuzakki.setText(x);
    }

    public String getjTextField_idMuzakki() {
        return jTextField_idMuzakki.getText();
    }

    public void setjTextField_idMuzakki(String x) {
        jTextField_idMuzakki.setText(x);
    }

    public String getjTextField_jumlahAnggotaKeluargaMuzakki() {
        return jTextField_jumlahAnggotaKeluargaMuzakki.getText();
    }

    public void setjTextField_jumlahAnggotaKeluargaMuzakki(String x) {
        jTextField_jumlahAnggotaKeluargaMuzakki.setText(x);
    }

    public String getjTextField_namaMuzakki() {
        return jTextField_namaMuzakki.getText();
    }

    public void setjTextField_namaMuzakki(String x) {
        jTextField_namaMuzakki.setText(x);
    }

    public String getjTextField_totalMuzakki() {
        return jTextField_totalMuzakki.getText();
    }

    public void setjTextField_totalMuzakki(String x) {
        jTextField_totalMuzakki.setText(x);
   }
    
    public void addActionListener(ActionListener x) {
        jButton_TambahMuzakki.addActionListener(x);
        jButton_deleteMuzakki.addActionListener(x);
        jButton_kembaliMuzakki.addActionListener(x);
        jButton_updateMuzakki.addActionListener(x);
        jButtonReset.addActionListener(x);
        jButton_Hitung.addActionListener(x);
        
    }

    public void addMouseAdapter(MouseAdapter x){
       jTable_muzakki.addMouseListener(x);
       
    }
     public void showMessage(String message,String title,int type){
        JOptionPane.showMessageDialog(null, message, title, type);
    }
     
     public void isiZakat(){
         try{
            String query = "SELECT idZakat from tabzakat";
           conn = DriverManager.getConnection("jdbc:mysql://localhost/zakat", "root", "");
           stmt = conn.createStatement();
           rs = stmt.executeQuery(query);
           while(rs.next()){
               jComboBox_idZakat.addItem(rs.getString("idZakat"));
           }
           conn.close();
           stmt.close();
             
         }catch (SQLException e){
             System.out.println(e);
         }
     }

    public JButton getjButtonReset() {
        return jButtonReset;
    }
    public void Reset(){
       jTextField_idMuzakki.setText("");
       jTextField_namaMuzakki.setText("");
       jTextField_alamatMuzakki.setText("");
       jTextField_jumlahAnggotaKeluargaMuzakki.setText("");
       jTextField_totalMuzakki.setText("");
    }
    
    public String getJenis(){
        if(jRadioButton_JenisPembayaranUang.isSelected()){
            return "Uang";
        }else{
            return "Beras";
        }
    }

    public JTable getjTable_muzakki() {
        return jTable_muzakki;
    }

    public JButton getjButton_Hitung() {
        return jButton_Hitung;
    }
    
    
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonJenis;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButton_Hitung;
    private javax.swing.JButton jButton_TambahMuzakki;
    private javax.swing.JButton jButton_deleteMuzakki;
    private javax.swing.JButton jButton_kembaliMuzakki;
    private javax.swing.JButton jButton_updateMuzakki;
    private javax.swing.JComboBox<String> jComboBox_idZakat;
    private javax.swing.JLabel jLabel_alamatMuzakki;
    private javax.swing.JLabel jLabel_idMuzakki;
    private javax.swing.JLabel jLabel_idZakat;
    private javax.swing.JLabel jLabel_jenisPembayaran;
    private javax.swing.JLabel jLabel_judulMuzakki;
    private javax.swing.JLabel jLabel_jumlahAnggotaKeluargaMuzakki;
    private javax.swing.JLabel jLabel_namaMuzakki;
    private javax.swing.JPanel jPanel_Muzakki;
    private javax.swing.JRadioButton jRadioButton_JenisPembayaranUang;
    private javax.swing.JRadioButton jRadioButton_jenisPembayaranBeras;
    private javax.swing.JScrollPane jScrollPane_muzakki;
    private javax.swing.JTable jTable_muzakki;
    private javax.swing.JTextField jTextField_alamatMuzakki;
    private javax.swing.JTextField jTextField_idMuzakki;
    private javax.swing.JTextField jTextField_jumlahAnggotaKeluargaMuzakki;
    private javax.swing.JTextField jTextField_namaMuzakki;
    private javax.swing.JTextField jTextField_totalMuzakki;
    // End of variables declaration//GEN-END:variables
}
