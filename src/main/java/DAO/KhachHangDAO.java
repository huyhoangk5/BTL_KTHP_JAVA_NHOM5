/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.KhachHang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.DBConnection;

/**
 *
 * @author legion
 */
public class KhachHangDAO {

    private Connection conn;

    public KhachHangDAO() {
        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=DB_BTL_JAVA;" + "username=sa;password=12345678;encrypt=false");
            this.conn = DBConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    //Thêm khách hàng
    public boolean addKhachHang(KhachHang kh) {
        String sql = "INSERT INTO KhachHang(maKH,tenKH,gioiTinh,soDienThoai,diaChi,email,loaiKH) VALUES(?,?,?,?,?,?,?)";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            
            ps.setString(1, kh.getMaKH());
            ps.setString(2, kh.getTenKH());
            ps.setString(3, kh.getGioiTinh());
            ps.setString(4, kh.getSoDienThoai());
            ps.setString(5, kh.getDiaChi());
            ps.setString(6, kh.getEmail());
            ps.setString(7, kh.getLoaiKH());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Sửa khách hàng mới
    public boolean update(KhachHang kh) {
        String sql = "UPDATE KhachHang SET tenKH = ?, gioiTinh = ?, soDienThoai = ?, diaChi = ?, email = ?, loaiKH = ? WHERE maKH = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, kh.getTenKH());
            ps.setString(2, kh.getGioiTinh());
            ps.setString(3, kh.getSoDienThoai());
            ps.setString(4, kh.getDiaChi());
            ps.setString(5, kh.getEmail());
            ps.setString(6, kh.getLoaiKH());
            ps.setString(7, kh.getMaKH());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //Xóa khách hàng
    public boolean delete(String maKH) {
        String sqlChiTietDonHang = "DELETE FROM ChiTietDonHang WHERE maDH IN (SELECT maDH FROM DonHang WHERE maKH = ?)";
        String sqlDonHang = "DELETE FROM DonHang WHERE maKH = ?";
        String sqlKhachHang = "DELETE FROM KhachHang WHERE maKH = ?";

        try {
            conn.setAutoCommit(false); //Tắt autoComit
            //Xóa Chi tiết đơn hàng
            try(PreparedStatement psChiTiet = conn.prepareStatement(sqlChiTietDonHang)){
                psChiTiet.setString(1, maKH);
                psChiTiet.executeUpdate();
            }
            //Xóa đơn hàng
            try(PreparedStatement psDonHang = conn.prepareStatement(sqlDonHang)){
                psDonHang.setString(1, maKH);
                psDonHang.executeUpdate();
            }
            //Xóa khách hàng
            try(PreparedStatement psKhachHang = conn.prepareStatement(sqlKhachHang)){
                psKhachHang.setString(1, maKH);
                int rowAffected = psKhachHang.executeUpdate();
                if(rowAffected > 0 ){
                    conn.commit();
                    return true;
                }else{
                    conn.rollback();// Hoàn tác thay đổi
                    return false;
                }
            }   
        }catch (Exception e) {
                try {
                    if(conn != null){
                        conn.rollback();
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                e.printStackTrace();
                return false;
            
        }finally{
            try {
                if (conn != null){
                    conn.setAutoCommit(true); //Bật lại kết nối
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    // Search theo mã
    public KhachHang searchByID(String maKH) {
        String sql = "SELECT * FROM KhachHang WHERE maKH = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            
            ps.setString(1, maKH);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new KhachHang(
                        rs.getString("maKH"),
                        rs.getString("tenKH"),
                        rs.getString("gioiTinh"),
                        rs.getString("soDienThoai"),
                        rs.getString("diaChi"),
                        rs.getString("email"),
                        rs.getString("loaiKH")
                );

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
//Hiển thị danh sách khách hàng
    public ArrayList<KhachHang> getListKhachHang() {
        ArrayList<KhachHang> list = new ArrayList<>();
        String sql = "SELECT * FROM KhachHang ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("maKH"));
                kh.setTenKH(rs.getString("tenKH"));
                kh.setGioiTinh(rs.getString("gioiTinh"));
                kh.setSoDienThoai(rs.getString("soDienThoai"));
                kh.setDiaChi(rs.getString("diaChi"));
                kh.setEmail(rs.getString("email"));
                kh.setLoaiKH(rs.getString("loaiKH"));

                list.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    //Kiểm tra mã khách hàng khi sửa( không được trùng với mã đã có)
    public boolean  checkID(String maKH, String maKHCu){
        String sql = "SELECT maKH FROM KhachHang WHERE maKH = ? AND maKH <> ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maKH);
            ps.setString(2, maKHCu);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

}
