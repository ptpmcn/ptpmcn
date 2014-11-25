/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.math.BigDecimal;

/**
 *
 * @author Dat
 */
public class ChiTietHoaDonXuatHang {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    private int soHoaDon;
    private int maSanPham;
    private int soLuong;
    private BigDecimal donGia;
 //   private BigDecimal donGia;

    public int getSoHoaDon() {
        return soHoaDon;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setSoHoaDon(int soHoaDon) {
        this.soHoaDon = soHoaDon;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public ChiTietHoaDonXuatHang() {
        super();
    }
    
    public ChiTietHoaDonXuatHang(int id, int soHoaDon, int maSanPham, int soLuong, BigDecimal donGia) {
        this.id = id;
        this.soHoaDon = soHoaDon;
        this.maSanPham = maSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
    
}
