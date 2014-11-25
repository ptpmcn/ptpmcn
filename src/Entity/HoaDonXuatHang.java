/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Dat
 */
public class HoaDonXuatHang {
    private int soHoaDon;
    private int maKhachHang;
    private Date ngayPhatSinh;
    private BigDecimal soTienThanhToan;
    private int maNguoiDung;
    private boolean trangThai;

    public int getSoHoaDon() {
        return soHoaDon;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public Date getNgayPhatSinh() {
        return ngayPhatSinh;
    }

    public BigDecimal getSoTienThanhToan() {
        return soTienThanhToan;
    }

    public int getMaNguoiDung() {
        return maNguoiDung;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setSoHoaDon(int soHoaDon) {
        this.soHoaDon = soHoaDon;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setNgayPhatSinh(Date ngayPhatSinh) {
        this.ngayPhatSinh = ngayPhatSinh;
    }

    public void setSoTienThanhToan(BigDecimal soTienThanhToan) {
        this.soTienThanhToan = soTienThanhToan;
    }

    public void setMaNguoiDung(int maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public HoaDonXuatHang(int soHoaDon, int maKhachHang, Date ngayPhatSinh, BigDecimal soTienThanhToan, int maNguoiDung, boolean trangThai) {
        this.soHoaDon = soHoaDon;
        this.maKhachHang = maKhachHang;
        this.ngayPhatSinh = ngayPhatSinh;
        this.soTienThanhToan = soTienThanhToan;
        this.maNguoiDung = maNguoiDung;
        this.trangThai = trangThai;
    }

    public HoaDonXuatHang() {
        super();
    }
    
}
