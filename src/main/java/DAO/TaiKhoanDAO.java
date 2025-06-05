/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author ADMIN
 */
public class TaiKhoanDAO {
     public TaiKhoan dangNhap(String tenTK, String mk) {
        TaiKhoan tk = null;
        String sql = "SELECT * FROM TaiKhoan WHERE tenTK = ? AND mk = ?";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, tenTK);
            stmt.setString(2, mk);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                tk = new TaiKhoan();
                tk.setMaTK(rs.getString("maTK"));
                tk.setTenTK(rs.getString("tenTK"));
                tk.setMk(rs.getString("mk"));
                tk.setQuyen(rs.getString("quyen"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tk;
    }
     
    public List<TaiKhoan> hienThiTatCaTaiKhoan() {
        List<TaiKhoan> list = new ArrayList<>();
        String sql = "SELECT maTK, tenTK, mk, quyen FROM TaiKhoan";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                
                tk.setMaTK(rs.getString("maTK"));
                tk.setTenTK(rs.getString("tenTK"));
                tk.setMk(rs.getString("mk"));
                tk.setQuyen(rs.getString("quyen"));
                
                list.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public boolean themTaiKhoan(TaiKhoan tk) throws Exception {
        String sql = "INSERT INTO TaiKhoan(maTK, tenTK, mk, quyen)"
                   + "VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, tk.getMaTK());
            ps.setString(2, tk.getTenTK());
            ps.setString(3, tk.getMk());
            ps.setString(4, tk.getQuyen());

            int check = ps.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean suaTaiKhoan(TaiKhoan tk) {
        String sql = "UPDATE TaiKhoan SET tenTK=?, mk=?, quyen=? WHERE maTK=?";
        
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(4, tk.getMaTK());
            ps.setString(1, tk.getTenTK());
            ps.setString(2, tk.getMk());
            ps.setString(3, tk.getQuyen());

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public TaiKhoan xoaNhanVienTheoMaTK(String maTK) {
        String selectSql = "SELECT maTK, tenTK, mk, quyen FROM TaiKhoan WHERE maTK = ?";
        String deleteSql = "DELETE FROM TaiKhoan WHERE maTK = ?";
        TaiKhoan tk = null;
        try (Connection conn = DBConnection.getConnection()) {
            try (PreparedStatement selectStmt = conn.prepareStatement(selectSql)) {
                selectStmt.setString(1, maTK);
                try (ResultSet rs = selectStmt.executeQuery()) {
                    if (rs.next()) {
                        tk = new TaiKhoan();
                        tk.setMaTK(rs.getString("maTK"));
                        tk.setTenTK(rs.getString("tenTK"));
                        tk.setMk(rs.getString("mk"));
                        tk.setQuyen(rs.getString("quyen"));
                    } else {
                        return null;
                    }
                }
            }

            try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSql)) {
                deleteStmt.setString(1, maTK);
                int affectedRows = deleteStmt.executeUpdate();
                if (affectedRows == 0) {
                    System.err.println("No rows deleted for id: " + maTK);
                    return null;
                } else {
                    System.out.println("Đã xóa");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return tk;
    }
    
    public TaiKhoan timTaiKhoanTheoMaTK(String maTK) {
        String sql = "SELECT maTK, tenTK, mk, quyen FROM TaiKhoan WHERE maTK = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maTK);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new TaiKhoan(
                        rs.getString("maTK"),
                        rs.getString("tenTK"),
                        rs.getString("mk"),
                        rs.getString("quyen")
                );
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
