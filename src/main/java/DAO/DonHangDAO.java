package DAO;

import Entity.DonHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class DonHangDAO {
    private Connection connection;

    public DonHangDAO() {
        this.connection = DBConnection.getConnection();
    }

    // Thêm đơn hàng mới
    public boolean insert(DonHang donHang) {
        String sql = "INSERT INTO DonHang (maDH, maKH, ngayLap, trangThai) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, donHang.getMaDH());
            statement.setString(2, donHang.getMaKH());
            statement.setString(3, donHang.getNgayLap());
            statement.setString(4, donHang.getTrangThai());
            
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Cập nhật thông tin đơn hàng
    public boolean update(DonHang donHang) {
        String sql = "UPDATE DonHang SET maKH = ?, ngayLap = ?, trangThai = ? WHERE maDH = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, donHang.getMaKH());
            statement.setString(2, donHang.getNgayLap());
            statement.setString(3, donHang.getTrangThai());
            statement.setString(4, donHang.getMaDH());
            
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa đơn hàng
    public boolean delete(String maDH) {
        // Xóa chi tiết đơn hàng trước
        String deleteChiTietSQL = "DELETE FROM ChiTietDonHang WHERE maDH = ?";
        try (PreparedStatement statement = connection.prepareStatement(deleteChiTietSQL)) {
            statement.setString(1, maDH);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        // Sau đó xóa đơn hàng
        String deleteDonHangSQL = "DELETE FROM DonHang WHERE maDH = ?";
        try (PreparedStatement statement = connection.prepareStatement(deleteDonHangSQL)) {
            statement.setString(1, maDH);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lấy tất cả đơn hàng với thông tin khách hàng và tổng tiền
    public List<DonHang> selectAll() {
        List<DonHang> list = new ArrayList<>();
        String sql = "SELECT dh.maDH, dh.maKH, kh.tenKH, dh.ngayLap, dh.trangThai, "
                   + "SUM(ct.soLuong * sp.gia) AS tongTien "
                   + "FROM DonHang dh "
                   + "LEFT JOIN KhachHang kh ON dh.maKH = kh.maKH "
                   + "LEFT JOIN ChiTietDonHang ct ON dh.maDH = ct.maDH "
                   + "LEFT JOIN SanPham sp ON ct.maSP = sp.maSP "
                   + "GROUP BY dh.maDH, dh.maKH, kh.tenKH, dh.ngayLap, dh.trangThai";
        
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                DonHang donHang = new DonHang(
                    resultSet.getString("maDH"),
                    resultSet.getString("maKH"),
                    resultSet.getString("tenKH"),
                    resultSet.getString("ngayLap"),
                    resultSet.getString("trangThai"),
                    resultSet.getDouble("tongTien")
                );
                list.add(donHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Tìm đơn hàng theo mã với đầy đủ thông tin
    public DonHang selectById(String maDH) {
        String sql = "SELECT dh.maDH, dh.maKH, kh.tenKH, dh.ngayLap, dh.trangThai, "
                   + "SUM(ct.soLuong * sp.gia) AS tongTien "
                   + "FROM DonHang dh "
                   + "LEFT JOIN KhachHang kh ON dh.maKH = kh.maKH "
                   + "LEFT JOIN ChiTietDonHang ct ON dh.maDH = ct.maDH "
                   + "LEFT JOIN SanPham sp ON ct.maSP = sp.maSP "
                   + "WHERE dh.maDH = ? "
                   + "GROUP BY dh.maDH, dh.maKH, kh.tenKH, dh.ngayLap, dh.trangThai";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maDH);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                return new DonHang(
                    resultSet.getString("maDH"),
                    resultSet.getString("maKH"),
                    resultSet.getString("tenKH"),
                    resultSet.getString("ngayLap"),
                    resultSet.getString("trangThai"),
                    resultSet.getDouble("tongTien")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Kiểm tra mã đơn hàng đã tồn tại chưa
    public boolean isMaDHExists(String maDH) {
        String sql = "SELECT 1 FROM DonHang WHERE maDH = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maDH);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Tính tổng tiền của đơn hàng từ chi tiết đơn hàng
    public double calculateTongTien(String maDH) {
        String sql = "SELECT SUM(ct.soLuong * sp.gia) AS tongTien "
                   + "FROM ChiTietDonHang ct "
                   + "JOIN SanPham sp ON ct.maSP = sp.maSP "
                   + "WHERE ct.maDH = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maDH);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                return resultSet.getDouble("tongTien");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}