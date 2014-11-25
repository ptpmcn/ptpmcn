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
public class PhieuThu {
    private int soPhieuThu;
    private int maKhachHang;
    private Date ngayPhatSinh;
    private BigDecimal soTien;
    private int maNguoiDung;
    private String lyDo;

    public int getSoPhieuThu() {
        return soPhieuThu;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public Date getNgayPhatSinh() {
        return ngayPhatSinh;
    }

    public BigDecimal getSoTien() {
        return soTien;
    }

    public int getMaNguoiDung() {
        return maNguoiDung;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setSoPhieuThu(int soPhieuThu) {
        this.soPhieuThu = soPhieuThu;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setNgayPhatSinh(Date ngayPhatSinh) {
        this.ngayPhatSinh = ngayPhatSinh;
    }

    public void setSoTien(BigDecimal soTien) {
        this.soTien = soTien;
    }

    public void setMaNguoiDung(int maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public PhieuThu(int soPhieuThu, int maKhachHang, Date ngayPhatSinh, BigDecimal soTien, int maNguoiDung, String lyDo) {
        this.soPhieuThu = soPhieuThu;
        this.maKhachHang = maKhachHang;
        this.ngayPhatSinh = ngayPhatSinh;
        this.soTien = soTien;
        this.maNguoiDung = maNguoiDung;
        this.lyDo = lyDo;
    }

    public PhieuThu() {
        super();
    }
    
}
