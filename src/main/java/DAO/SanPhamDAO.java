package DAO;

import Entity.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.DBConnection;

/**
 *
 * @author nvtqu
 */
public class SanPhamDAO {

    private Connection conn;

    public SanPhamDAO() {
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=DB_BTL_JAVA;encrypt=true;trustServerCertificate=true";
            String user = "sa"; // tài khoản SQL Server
            String password = "12345678"; // mật khẩu SQL Server
            conn = DBConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<SanPham> hienThiDanhSachSanPham() {
        ArrayList<SanPham> list = new ArrayList<>();
        String sql = "SELECT sp.maSP, sp.tenSP, sp.loaiSP, sp.tenHSX, sp.gia,kt.kichThuoc, kt.soLuong FROM SanPham sp JOIN KichThuoc kt ON sp.maKT = kt.maKT";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham s = new SanPham();
                s.setMaSP(rs.getString("maSP"));
                s.setTenSP(rs.getString("tenSP"));
                s.setLoaiSP(rs.getString("loaiSP"));
                s.setTenHSX(rs.getString("tenHSX"));
                s.setKichThuoc(rs.getString("kichThuoc"));
                s.setGia(rs.getDouble("gia"));
                s.setSoLuong(rs.getInt("soLuong"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean themSanPham(SanPham s) throws Exception {
        String insertKichThuoc = "INSERT INTO KichThuoc(maKT, kichThuoc, soLuong) VALUES (?, ?, ?)";
        String insertSanPham = "INSERT INTO SanPham(maSP, tenSP, loaiSP, tenHSX, gia, maKT) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            // 1. Thêm kích thước trước
            PreparedStatement ps1 = conn.prepareStatement(insertKichThuoc);
            ps1.setString(1, s.getMaSP()); // Dùng maSP làm maKT (nếu bạn muốn quản lý riêng thì tạo field maKT)
            ps1.setString(2, s.getKichThuoc());
            ps1.setInt(3, s.getSoLuong());
            ps1.executeUpdate();

            // 2. Thêm sản phẩm
            PreparedStatement ps2 = conn.prepareStatement(insertSanPham);
            ps2.setString(1, s.getMaSP());
            ps2.setString(2, s.getTenSP());
            ps2.setString(3, s.getLoaiSP());
            ps2.setString(4, s.getTenHSX());
            ps2.setDouble(5, s.getGia());
            ps2.setString(6, s.getMaSP()); // Tham chiếu maKT = maSP vừa chèn bên trên
            int check = ps2.executeUpdate();

            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void xoaSanPham(String masp) {
        String sql = "DELETE FROM SanPham WHERE ID = ?";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, masp);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SanPham timSanPhamTheoMaSP(String maSP) {
        String sql = "SELECT sp.maSP, sp.tenSP, sp.loaiSP, sp.tenHSX, sp.gia, kt.kichThuoc, kt.soLuong "
                + "FROM SanPham sp JOIN KichThuoc kt ON sp.maKT = kt.maKT WHERE sp.maSP = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, maSP);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new SanPham(
                        rs.getString("maSP"),
                        rs.getString("tenSP"),
                        rs.getString("loaiSP"),
                        rs.getString("tenHSX"),
                        rs.getString("kichThuoc"),
                        rs.getInt("soLuong"),
                        rs.getDouble("gia")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean suaSanPham(SanPham sp) {
        String sql = "UPDATE SanPham SET tenSP=?, loaiSP=?, tenHSX=?, gia=? WHERE maSP=?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, sp.getTenSP());
            ps.setString(2, sp.getLoaiSP());
            ps.setString(3, sp.getTenHSX());
            ps.setDouble(4, sp.getGia());
            ps.setString(5, sp.getMaSP());

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
