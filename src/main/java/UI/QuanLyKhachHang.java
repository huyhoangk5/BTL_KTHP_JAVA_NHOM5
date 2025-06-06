/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import DAO.KhachHangDAO;
import Entity.KhachHang;
import UI.Menu_NhanVien;
import UI.Menu_QuanLy;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Session;

/**
 *
 * @author legion
 */
public class QuanLyKhachHang extends javax.swing.JFrame {

    private KhachHangDAO khachHangDao = new KhachHangDAO();
    private ArrayList<KhachHang> list;
    DefaultTableModel model;

    public QuanLyKhachHang() {
        initComponents();
        this.setLocationRelativeTo(null);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(radNam); // Thêm jRadioButton1 (Nam)
        genderGroup.add(radNu); // Thêm jRadioButton2 (Nữ)
        list = khachHangDao.getListKhachHang();
        model = (DefaultTableModel) tblKhachHang.getModel();
        model.setColumnIdentifiers(new Object[]{
            "STT", "ID", "Fullname", "Giới Tính", "SDT", "Address", "Email", "Loại khách hàng"
        });
        
        showDB();
    }

    public void showDB() {
        model.setRowCount(0); // Xóa toàn bộ dữ liệu cũ trong bảng
        list = khachHangDao.getListKhachHang(); // Truy vấn lại từ CSDL
        int i = 1;
        model.setRowCount(0);

        for (KhachHang kh : list) {

            model.addRow(new Object[]{
                i++,
                kh.getMaKH(),
                kh.getTenKH(),
                kh.getGioiTinh(),
                kh.getSoDienThoai(),
                kh.getDiaChi(),
                kh.getEmail(),
                kh.getLoaiKH()
            });
        }
    }

    ////    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        radNam = new javax.swing.JRadioButton();
        radNu = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        txtLoai = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Thông tin khách hàng");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã khách hàng");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tên khách hàng");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Email");

        txtID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("SĐT");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Địa chỉ");

        txtAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Giới tính");

        radNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radNam.setText("Nam");
        radNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radNamActionPerformed(evt);
            }
        });

        radNu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radNu.setText("Nữ");
        radNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radNuActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Loại khách hàng");

        txtLoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtID)
                    .addComponent(txtName)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(radNam, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radNu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                .addComponent(txtPhone)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtLoai, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(radNam)
                    .addComponent(radNu))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        tblKhachHang.setBackground(new java.awt.Color(255, 255, 204));
        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã khách hàng", "Tên khách hàng", "Giới tính", "SĐT", "Địa chỉ", "Email", "Loại khách hàng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblKhachHang.getTableHeader().setReorderingAllowed(false);
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        tblKhachHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblKhachHangKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Danh sách khách hàng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 102, 0));

        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/add (2).png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/tools (1).png"))); // NOI18N
        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/trash-bin (1) (2).png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/magnifier (1).png"))); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/logout (2).png"))); // NOI18N
        btnExit.setText("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Quay lại");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEdit)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(btnSearch)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(btnExit)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnEdit)
                            .addComponent(btnDelete)
                            .addComponent(btnSearch)
                            .addComponent(btnExit))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void radNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radNamActionPerformed

    private void radNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radNuActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
        
        String quyen = Session.currentUser.getQuyen();
        
        if("Người quản lý".equals(quyen)){
            new Menu_QuanLy().setVisible(true);
        }else{
            new Menu_NhanVien().setVisible(true);
        } 
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String maKH = JOptionPane.showInputDialog(this, "Nhập mã khách hàng cần tìm: ", "Tìm kiếm khách hàng", JOptionPane.INFORMATION_MESSAGE);
        if (maKH == null || maKH.trim().isEmpty()) {
            return;
        }
        KhachHang kh = khachHangDao.searchByID(maKH.trim());
        if (kh != null) {
            model.setRowCount(0);
            model.addRow(new Object[]{
                1,
                kh.getMaKH(),
                kh.getTenKH(),
                kh.getGioiTinh(),
                kh.getSoDienThoai(),
                kh.getDiaChi(),
                kh.getEmail(),
                kh.getLoaiKH()
            });

            txtID.setText(kh.getMaKH());
            txtName.setText(kh.getTenKH());
            String gioiTinh = kh.getGioiTinh();
            if (gioiTinh.equalsIgnoreCase("Nam")) {
                radNam.setSelected(true);
            } else {
                radNu.setSelected(true);
            }
            txtPhone.setText(kh.getSoDienThoai());
            txtAddress.setText(kh.getDiaChi());
            txtEmail.setText(kh.getEmail());
            txtLoai.setText(kh.getLoaiKH());
    }//GEN-LAST:event_btnSearchActionPerformed
         else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng có mã: " + maKH, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btnAddMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
//        clearForm();
        String maKH = txtID.getText();
        String tenKH = txtName.getText();
        String gioiTinh = radNam.isSelected() ? "Nam" : "Nữ";
        String sdt = txtPhone.getText().trim();
        String diaChi = txtAddress.getText();
        String email = txtEmail.getText().trim();
        String loai = txtLoai.getText();

        if (maKH.isEmpty() || tenKH.isEmpty() || gioiTinh.isEmpty() || diaChi.isEmpty()
                || sdt.isEmpty() || email.isEmpty() || loai.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (!(sdt.length() == 10) || !sdt.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ. Phải là số và tối đa 10 chữ số.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        KhachHang kh = new KhachHang(maKH, tenKH, gioiTinh, sdt, diaChi, email, loai);
        if (khachHangDao.addKhachHang(kh)) {
            JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            list.add(kh);
            model.addRow(new Object[]{
                model.getRowCount() + 1,
                kh.getMaKH(),
                kh.getTenKH(),
                kh.getGioiTinh(),
                kh.getSoDienThoai(),
                kh.getDiaChi(),
                kh.getEmail(),
                kh.getLoaiKH()
            });
            clearForm(); // Xóa các trường nhập liệu sau khi thêm thành công
        } else {
            JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại. Hãy kiểm tra lại 'mã khách hàng'.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed
    private void clearForm() {
        txtID.setText("");
        txtName.setText("");
        txtPhone.setText("");
        txtAddress.setText("");
        txtEmail.setText("");
        txtLoai.setText("");
        radNam.setSelected(false);
        radNu.setSelected(false);
    }
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        try {
            int select = tblKhachHang.getSelectedRow();
            if (select < 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 khách hàng để sửa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

        String maKH = txtID.getText();
        String tenKH = txtName.getText();
        String gioiTinh = radNam.isSelected() ? "Nam" : "Nữ";
        String sdt = txtPhone.getText().trim();
        String diaChi = txtAddress.getText();
        String email = txtEmail.getText().trim();
        String loai = txtLoai.getText();
        
        //check ma khach hang
        String maKHCu = tblKhachHang.getValueAt(select, 1).toString();// Lay ma cu tu bang
        if(!maKH.equals(maKHCu) && khachHangDao.checkID(maKH, maKHCu)){
            JOptionPane.showMessageDialog(this,"Mã khách hàng đã tồn tại","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (maKH.isEmpty() || tenKH.isEmpty() || gioiTinh.isEmpty() || diaChi.isEmpty()
                || sdt.isEmpty() || email.isEmpty() || loai.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!(sdt.length() == 10) || !sdt.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ. Phải là số và tối đa 10 chữ số.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        KhachHang kh = new KhachHang(maKH, tenKH, gioiTinh, sdt, diaChi, email, loai);
        if (khachHangDao.update(kh)) {
                model.setValueAt(maKH, select, 1);
                model.setValueAt(tenKH, select, 2);
                model.setValueAt(gioiTinh, select, 3);
                model.setValueAt(sdt, select, 4);
                model.setValueAt(diaChi, select, 5);
                model.setValueAt(email, select, 6);
                model.setValueAt(loai, select, 7);
                JOptionPane.showMessageDialog(this, "Update Success!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, " Update Unsuccess! Mã khách hàng không thể sửa", "Error", JOptionPane.ERROR_MESSAGE);
        }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi sửa: " + e.getMessage());
            e.printStackTrace();           
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        // TODO add your handling code here:
        int index = this.tblKhachHang.getSelectedRow();

        if (index >= 0) {
            txtID.setText(model.getValueAt(index, 1).toString());
            txtName.setText(model.getValueAt(index, 2).toString());
            String gioiTinh = model.getValueAt(index, 3).toString();
            if (gioiTinh.equalsIgnoreCase("Nam")) {
                radNam.setSelected(true);
            } else {
                radNu.setSelected(true);
            }

            txtPhone.setText(model.getValueAt(index, 4).toString());
            txtAddress.setText(model.getValueAt(index, 5).toString());
            txtEmail.setText(model.getValueAt(index, 6).toString());
            txtLoai.setText(model.getValueAt(index, 7).toString());
    }//GEN-LAST:event_tblKhachHangMouseClicked
    }
    private void tblKhachHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKhachHangKeyReleased
        // TODO add your handling code here:
        int index = this.tblKhachHang.getSelectedRow();

        if (index >= 0) {
            txtID.setText(model.getValueAt(index, 1).toString());
            txtName.setText(model.getValueAt(index, 2).toString());
            String gioiTinh = model.getValueAt(index, 3).toString();
            if (gioiTinh.equalsIgnoreCase("Nam")) {
                radNam.setSelected(true);
            } else {
                radNu.setSelected(true);
            }

            txtPhone.setText(model.getValueAt(index, 4).toString());
            txtAddress.setText(model.getValueAt(index, 5).toString());
            txtEmail.setText(model.getValueAt(index, 6).toString());
            txtLoai.setText(model.getValueAt(index, 7).toString());
    }//GEN-LAST:event_tblKhachHangKeyReleased
    }
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int select = tblKhachHang.getSelectedRow();
        if (select < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng cần xóa.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String maKH = tblKhachHang.getValueAt(select, 1).toString();
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa khách hàng: "+ maKH + "?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if(khachHangDao.delete(maKH)){
                JOptionPane.showMessageDialog(this, "Delete success!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                showDB();
                clearForm();
            }else{
                JOptionPane.showMessageDialog(this, "Delete Unsuccess!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed
}
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        showDB();
        clearForm();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radNam;
    private javax.swing.JRadioButton radNu;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLoai;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
