/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import util.DBConnection;

public class NhanVienDAO {

    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> list = new ArrayList<>();
        String sql = "SELECT maNV, tenNV, ngaySinh, gioiTinh, diaChi, soDienThoai, vaiTro, maTK FROM NhanVien";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("maNV"));
                nv.setTenNV(rs.getString("tenNV"));

                // Lấy ngày sinh từ cơ sở dữ liệu
                java.sql.Date sqlDate = rs.getDate("ngaySinh");
                if (sqlDate != null) {
                    // Chuyển đổi sang định dạng dd/MM/yyyy khi cần thiết
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String formattedDate = sdf.format(sqlDate);
                    nv.setNgaySinh(formattedDate); // Giả sử bạn có phương thức này trong NhanVien
                }

                nv.setGioiTinh(rs.getString("gioiTinh"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setSoDienThoai(rs.getString("soDienThoai"));
                nv.setVaiTro(rs.getString("vaiTro"));
                nv.setMaTK(rs.getString("maTK"));
                list.add(nv);
            }

            System.out.println("Lấy được " + list.size() + " nhân viên");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean updateNhanVien(NhanVien nv) {
        String sql = "UPDATE NhanVien SET tenNV=?, ngaySinh=?, gioiTinh=?, diaChi=?, soDienThoai=?, vaiTro=?, maTK=? WHERE maNV=?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nv.getTenNV());
            ps.setString(2, nv.getNgaySinh().toString());
            ps.setString(3, nv.getGioiTinh());
            ps.setString(4, nv.getDiaChi());
            ps.setString(5, nv.getSoDienThoai());
            ps.setString(6, nv.getVaiTro());
            ps.setString(7, nv.getMaTK());
            ps.setString(8, nv.getMaNV());

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean createNhanVienById(NhanVien nv) throws Exception {
    String sql = "INSERT INTO NhanVien(maNV, tenNV, ngaySinh, gioiTinh, diaChi, soDienThoai, vaiTro, maTK) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    try (Connection conn = DBConnection.getConnection(); 
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, nv.getMaNV());
        ps.setString(2, nv.getTenNV());

        // Parse chuỗi ngày sinh "dd/MM/yyyy" sang java.sql.Date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date utilDate = sdf.parse(nv.getNgaySinh());
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        ps.setDate(3, sqlDate);  // truyền đúng kiểu java.sql.Date

        ps.setString(4, nv.getGioiTinh());
        ps.setString(5, nv.getDiaChi());
        ps.setString(6, nv.getSoDienThoai());
        ps.setString(7, nv.getVaiTro());
        ps.setString(8, nv.getMaTK());

        int check = ps.executeUpdate();
        return check > 0;
    } catch (Exception e) {
        System.err.println("SQL Error: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
}



    public NhanVien getNhanVienById(String id) {
        String sql = "SELECT maNV, tenNV, ngaySinh, gioiTinh, diaChi, soDienThoai, vaiTro, maTK FROM NhanVien WHERE maNV = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new NhanVien(
                        rs.getString("maNV"),
                        rs.getString("tenNV"),
                        rs.getString("ngaySinh"),
                        rs.getString("gioiTinh"),
                        rs.getString("diaChi"),
                        rs.getString("soDienThoai"),
                        rs.getString("vaiTro"),
                        rs.getString("maTK")
                );
            }
            return null; // No record found
        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    

    public NhanVien deleteNhanVienById(String id) {
        String selectSql = "SELECT maNV, tenNV, ngaySinh, gioiTinh, diaChi, soDienThoai, vaiTro, maTK FROM NhanVien WHERE maNV = ?";
        String deleteSql = "DELETE FROM NhanVien WHERE maNV = ?";
        NhanVien entity = null;
        try (Connection conn = DBConnection.getConnection()) {
            // Step 1: Retrieve entity by id (like EntityManager.find)
            try (PreparedStatement selectStmt = conn.prepareStatement(selectSql)) {
                selectStmt.setString(1, id);
                try (ResultSet rs = selectStmt.executeQuery()) {
                    if (rs.next()) {
                        entity = new NhanVien();
                        entity.setMaNV(rs.getString("maNV"));
                        entity.setTenNV(rs.getString("tenNV"));
                        entity.setNgaySinh(rs.getString("ngaySinh"));
                        entity.setGioiTinh(rs.getString("gioiTinh"));
                        entity.setDiaChi(rs.getString("diaChi"));
                        entity.setSoDienThoai(rs.getString("soDienThoai"));
                        entity.setVaiTro(rs.getString("vaiTro"));
                        entity.setMaTK(rs.getString("maTK"));
                    } else {
                        // Entity not found; return null like JPA
                        return null;
                    }
                }
            }

            // Step 2: Remove entity (like EntityManager.remove)
            try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSql)) {
                deleteStmt.setString(1, id);
                int affectedRows = deleteStmt.executeUpdate();
                if (affectedRows == 0) {
                    // No rows deleted - possible race condition
                    System.err.println("No rows deleted for id: " + id);
                    return null;
                } else {
                    System.out.println("Đã xóa");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        // Return deleted entity instance
        return entity;
    }

}
