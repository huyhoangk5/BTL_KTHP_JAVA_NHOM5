/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author ADMIN
 */
public class ChiTietDonHang {
    private String maDH;
    private String maSP;
    private int soLuong;
    private float tongTien;

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public ChiTietDonHang() {
    }

    public ChiTietDonHang(String maDH, String maSP, int soLuong, float tongTien) {
        this.maDH = maDH;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }
}
