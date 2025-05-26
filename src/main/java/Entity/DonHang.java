/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author ADMIN
 */
public class DonHang {
    private String maDH;
    private String tenKH;
    private String ngayLap;
    private String trangThai;
    private double tongTien;

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public DonHang() {
    }

    public DonHang(String maDH, String tenKH, String ngayLap, String trangThai, double tongTien) {
        this.maDH = maDH;
        this.tenKH = tenKH;
        this.ngayLap = ngayLap;
        this.trangThai = trangThai;
        this.tongTien = tongTien;
    }
}
