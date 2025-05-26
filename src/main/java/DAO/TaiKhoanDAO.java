/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
