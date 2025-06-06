/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import java.awt.Dimension;
import java.awt.GridLayout;

/**
 *
 * @author ADMIN
 */
public class Menu_QuanLy extends javax.swing.JFrame {

    /**
     * Creates new form JFrame
     */
    public Menu_QuanLy() {
        initComponents();
//        this.addComponentListener(new ComponentAdapter(){
//            @Override
//            public void componentResized(ComponentEvent e){
//                Style_Display();
//            }
//        });
        setLocationRelativeTo(null);
    }

    private void Style_Display(){
        Dimension frameSize = getSize();
        int width = frameSize.width;
        int height = frameSize.height;

        // Ngưỡng để thay đổi bố cục (điều chỉnh các giá trị này theo yêu cầu)
        int widthThreshold = 500; // Nếu chiều rộng < 600, xem xét bố cục dọc cho các nút
        int heightThreshold = 400; // Nếu chiều cao < 400, xem xét bố cục ngang cho các nút

        if (width < widthThreshold && height >= heightThreshold ) {
            // Chiều rộng hẹp, chiều cao đủ lớn: Xếp chồng các nút theo chiều dọc (4x1)
            if (!(jPanel1.getLayout() instanceof GridLayout || 
                ((GridLayout) jPanel1.getLayout()).getRows() != 4 ||
                ((GridLayout) jPanel1.getLayout()).getColumns() != 1) ||
                ((GridLayout) jPanel1.getLayout()).getRows() != 4) {
                jPanel1.setLayout(new GridLayout(4, 1, 10, 10));
                jPanel1.revalidate(); // Tái hợp lệ hóa bố cục
                jPanel1.repaint();    // Vẽ lại thành phần
            }
        } else if (height < heightThreshold && width >= widthThreshold) {
            // Chiều cao thấp, chiều rộng đủ lớn: Sắp xếp các nút theo chiều ngang (1x4)
             if (!(jPanel1.getLayout() instanceof GridLayout) ||
                 ((GridLayout) jPanel1.getLayout()).getColumns() != 4) {
                jPanel1.setLayout(new GridLayout(1, 4, 10, 10));
                jPanel1.revalidate();
                jPanel1.repaint();
            }
        }
        else {
            // Lưới 2x2 mặc định cho kích thước lớn hơn hoặc khi cả hai đều nhỏ
            if (!(jPanel1.getLayout() instanceof GridLayout) ||
                ((GridLayout) jPanel1.getLayout()).getRows() != 2 ||
                ((GridLayout) jPanel1.getLayout()).getColumns() != 2) {
                jPanel1.setLayout(new GridLayout(2, 2, 10, 10));
                jPanel1.revalidate();
                jPanel1.repaint();
            }
        }

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnQLDH = new javax.swing.JButton();
        btnQLSP = new javax.swing.JButton();
        btnQLNV = new javax.swing.JButton();
        btnQLKH = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnTaiKhoan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 450));
        setSize(new java.awt.Dimension(600, 450));

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 450));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Menu");
        jLabel1.setMaximumSize(new java.awt.Dimension(65, 32));
        jLabel1.setMinimumSize(new java.awt.Dimension(65, 32));
        jLabel1.setPreferredSize(new java.awt.Dimension(65, 32));

        btnQLDH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnQLDH.setText("Quản lý đơn hàng");
        btnQLDH.setMaximumSize(new java.awt.Dimension(183, 32));
        btnQLDH.setMinimumSize(new java.awt.Dimension(183, 32));
        btnQLDH.setPreferredSize(new java.awt.Dimension(183, 32));
        btnQLDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLDHActionPerformed(evt);
            }
        });

        btnQLSP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnQLSP.setText("Quản lý sản phẩm");
        btnQLSP.setPreferredSize(new java.awt.Dimension(200, 32));
        btnQLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLSPActionPerformed(evt);
            }
        });

        btnQLNV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnQLNV.setText("Quản lý nhân viên");
        btnQLNV.setMaximumSize(new java.awt.Dimension(184, 32));
        btnQLNV.setMinimumSize(new java.awt.Dimension(184, 32));
        btnQLNV.setPreferredSize(new java.awt.Dimension(184, 32));
        btnQLNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLNVActionPerformed(evt);
            }
        });

        btnQLKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnQLKH.setText("Quản lý khách hàng");
        btnQLKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLKHActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/logout (2).png"))); // NOI18N
        btnExit.setText("Quay lại");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTaiKhoan.setText("Quản lý tài khoản");
        btnTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaiKhoanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnQLDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnQLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTaiKhoan))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnQLNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnQLKH))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(btnExit)))
                .addGap(168, 168, 168))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnQLDH, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(btnQLSP, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(btnTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnQLNV, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQLKH, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(btnExit)
                .addContainerGap(789, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1109, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQLDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLDHActionPerformed
        // TODO add your handling code here:
        this.dispose();
        
        new QuanLyDonHang().setVisible(true);
    }//GEN-LAST:event_btnQLDHActionPerformed

    private void btnQLNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLNVActionPerformed
        // TODO add your handling code here:
        this.dispose();
        
        new QuanLyNhanVien().setVisible(true);
    }//GEN-LAST:event_btnQLNVActionPerformed

    private void btnQLKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLKHActionPerformed
        // TODO add your handling code here:
        this.dispose();
        
        new QuanLyKhachHang().setVisible(true);
    }//GEN-LAST:event_btnQLKHActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new LogIn().setVisible(true);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnQLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLSPActionPerformed
        // TODO add your handling code here:
        this.dispose();
        
        new QuanLySanPham().setVisible(true);
    }//GEN-LAST:event_btnQLSPActionPerformed

    private void btnTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiKhoanActionPerformed
        // TODO add your handling code here:
        this.dispose();
        
        new QuanLyTaiKhoan().setVisible(true);
    }//GEN-LAST:event_btnTaiKhoanActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_QuanLy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnQLDH;
    private javax.swing.JButton btnQLKH;
    private javax.swing.JButton btnQLNV;
    private javax.swing.JButton btnQLSP;
    private javax.swing.JButton btnTaiKhoan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
