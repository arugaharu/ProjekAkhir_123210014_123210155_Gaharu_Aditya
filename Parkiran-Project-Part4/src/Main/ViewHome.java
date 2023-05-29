package Main;

import Controller.ControllerKeluar;
import View.ViewLogin;
import Controller.ControllerMasuk;
import View.ViewKeluar;
import javax.swing.JOptionPane;
import View.ViewMasuk;

public class ViewHome extends javax.swing.JFrame {

    public ViewHome() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_masuk = new javax.swing.JButton();
        btn_keluarView = new javax.swing.JButton();
        btn_keluar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_masuk.setBackground(new java.awt.Color(102, 255, 255));
        btn_masuk.setText("KENDARAAN MASUK");
        btn_masuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_masukActionPerformed(evt);
            }
        });

        btn_keluarView.setBackground(new java.awt.Color(102, 255, 255));
        btn_keluarView.setText("KENDARAAN KELUAR");
        btn_keluarView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarViewActionPerformed(evt);
            }
        });

        btn_keluar.setBackground(new java.awt.Color(255, 51, 51));
        btn_keluar.setForeground(new java.awt.Color(255, 255, 255));
        btn_keluar.setText("Keluar");
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("MENU UTAMA");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/imgbin-hospital-health-care-clinic-computer-icons-health-RFZeJNeNZjJkbwKnMQmip2TyZ.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btn_keluar))
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(btn_masuk))
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(btn_keluarView, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btn_keluar)
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btn_masuk)
                .addGap(18, 18, 18)
                .addComponent(btn_keluarView)
                .addGap(35, 35, 35)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_masukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_masukActionPerformed
        // TODO add your handling code here:
        ViewMasuk vmasuk = new ViewMasuk();
        vmasuk.setVisible(true);

        ControllerMasuk ctrlMasuk = new ControllerMasuk(vmasuk);
        ctrlMasuk.loadTable();
        dispose();
//        masuk.setVisible();
//        ControllerMasuk ctrlMasuk = new ControllerMasuk(vmasuk);
//        ctrlMasuk.loadTable();
//        vmasuk.setVisible(true);
    }//GEN-LAST:event_btn_masukActionPerformed

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void btn_keluarViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarViewActionPerformed
        // TODO add your handling code here:
        ViewKeluar vkeluar = new ViewKeluar();
        vkeluar.setVisible(true);

        ControllerKeluar ctrlKeluar = new ControllerKeluar(vkeluar);
        ctrlKeluar.loadTable();
        vkeluar.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_keluarViewActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_keluarView;
    private javax.swing.JButton btn_masuk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
