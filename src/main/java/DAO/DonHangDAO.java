package DAO;

import Entity.DonHang;
import Entity.SanPham;
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

    // Thêm đơn hàng mới và chi tiết đơn hàng
    public boolean insert(DonHang donHang, String maSP, int soLuong) {
        try {
            connection.setAutoCommit(false);
            
            // 1. Thêm đơn hàng
            String sqlDonHang = "INSERT INTO DonHang (maDH, maKH, ngayLap, trangThai) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmtDonHang = connection.prepareStatement(sqlDonHang)) {
                stmtDonHang.setString(1, donHang.getMaDH());
                stmtDonHang.setString(2, donHang.getMaKH());
                stmtDonHang.setString(3, donHang.getNgayLap());
                stmtDonHang.setString(4, donHang.getTrangThai());
                stmtDonHang.executeUpdate();
            }
            
            // 2. Thêm chi tiết đơn hàng
            String sqlChiTiet = "INSERT INTO ChiTietDonHang (maDH, maSP, soLuong) VALUES (?, ?, ?)";
            try (PreparedStatement stmtChiTiet = connection.prepareStatement(sqlChiTiet)) {
                stmtChiTiet.setString(1, donHang.getMaDH());
                stmtChiTiet.setString(2, maSP);
                stmtChiTiet.setInt(3, soLuong);
                stmtChiTiet.executeUpdate();
            }
            
            connection.commit();
            return true;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Cập nhật đơn hàng
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

    // Cập nhật chi tiết đơn hàng
    public boolean updateChiTietDonHang(String maDH, String maSP, int soLuong) {
        String sql = "UPDATE ChiTietDonHang SET maSP = ?, soLuong = ? WHERE maDH = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maSP);
            statement.setInt(2, soLuong);
            statement.setString(3, maDH);
            
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa đơn hàng
    public boolean delete(String maDH) {
        try {
            connection.setAutoCommit(false);
            
            // Xóa chi tiết đơn hàng trước
            String deleteChiTietSQL = "DELETE FROM ChiTietDonHang WHERE maDH = ?";
            try (PreparedStatement statement = connection.prepareStatement(deleteChiTietSQL)) {
                statement.setString(1, maDH);
                statement.executeUpdate();
            }
            
            // Sau đó xóa đơn hàng
            String deleteDonHangSQL = "DELETE FROM DonHang WHERE maDH = ?";
            try (PreparedStatement statement = connection.prepareStatement(deleteDonHangSQL)) {
                statement.setString(1, maDH);
                statement.executeUpdate();
            }
            
            connection.commit();
            return true;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Lấy tất cả đơn hàng với thông tin đầy đủ
    public List<Object[]> selectAll() {
        List<Object[]> list = new ArrayList<>();
        String sql = "SELECT dh.maDH, dh.maKH, kh.tenKH, ct.maSP, ct.soLuong, dh.trangThai, dh.ngayLap, " +
                 "SUM(ct.soLuong * sp.gia) AS tongTien " +
                 "FROM DonHang dh " +
                 "LEFT JOIN KhachHang kh ON dh.maKH = kh.maKH " +
                 "LEFT JOIN ChiTietDonHang ct ON dh.maDH = ct.maDH " +
                 "LEFT JOIN SanPham sp ON ct.maSP = sp.maSP " +
                 "GROUP BY dh.maDH, dh.maKH, kh.tenKH, ct.maSP, ct.soLuong, dh.trangThai, dh.ngayLap " +
                 "ORDER BY dh.ngayLap DESC";
    
        try (PreparedStatement statement = connection.prepareStatement(sql);
         ResultSet resultSet = statement.executeQuery()) {
        
        while (resultSet.next()) {
            Object[] row = {
                resultSet.getString("maDH"),
                resultSet.getString("maKH"),
                resultSet.getString("tenKH"),
                resultSet.getString("maSP"),
                resultSet.getInt("soLuong"),
                resultSet.getString("trangThai"),
                resultSet.getString("ngayLap"),
                resultSet.getDouble("tongTien")
            };
            list.add(row);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Tìm kiếm đơn hàng theo mã
    public DonHang selectById(String maDH) {
        String sql = "SELECT dh.maDH, dh.maKH, kh.tenKH, dh.ngayLap, dh.trangThai, "
                   + "COALESCE(SUM(ct.soLuong * sp.gia), 0) AS tongTien "
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

    // Lấy danh sách mã khách hàng
    public List<String> getAllMaKH() {
        List<String> list = new ArrayList<>();
        String sql = "SELECT maKH FROM KhachHang";
        
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                list.add(resultSet.getString("maKH"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy danh sách mã sản phẩm
    public List<String> getAllMaSP() {
        List<String> list = new ArrayList<>();
        String sql = "SELECT maSP FROM SanPham";
        
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                list.add(resultSet.getString("maSP"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy giá sản phẩm theo mã
    public double getGiaSanPham(String maSP) {
        String sql = "SELECT gia FROM SanPham WHERE maSP = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maSP);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                return resultSet.getDouble("gia");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Lấy chi tiết đơn hàng (maSP và soLuong)
    public Object[] getChiTietDonHang(String maDH) {
        String sql = "SELECT ct.maSP, ct.soLuong " +
                 "FROM ChiTietDonHang ct " +
                 "WHERE ct.maDH = ?";
    
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, maDH);
        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            return new Object[]{
                resultSet.getString("maSP"),
                resultSet.getInt("soLuong")
            };
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return new Object[]{"", 0};
    }
    public List<Object[]> getAllDonHangWithChiTiet() {
    List<Object[]> result = new ArrayList<>();
    String sql = "SELECT dh.maDH, dh.maKH, kh.tenKH, dh.ngayLap, dh.trangThai, " +
                 "ct.maSP, ct.soLuong, " +
                 "SUM(ct.soLuong * sp.gia) AS tongTien " +
                 "FROM DonHang dh " +
                 "LEFT JOIN KhachHang kh ON dh.maKH = kh.maKH " +
                 "LEFT JOIN ChiTietDonHang ct ON dh.maDH = ct.maDH " +
                 "LEFT JOIN SanPham sp ON ct.maSP = sp.maSP " +
                 "GROUP BY dh.maDH, dh.maKH, kh.tenKH, dh.ngayLap, dh.trangThai, ct.maSP, ct.soLuong " +
                 "ORDER BY dh.ngayLap DESC";
    
    try (PreparedStatement stmt = connection.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        
        while (rs.next()) {
            Object[] row = {
                rs.getString("maDH"),
                rs.getString("maKH"),
                rs.getString("tenKH"),
                rs.getString("maSP"),
                rs.getInt("soLuong"),
                rs.getString("trangThai"),
                rs.getString("ngayLap"),
                rs.getDouble("tongTien")
            };
            result.add(row);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return result;
}
}