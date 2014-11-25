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
public class PhieuChi {
    private int soPhieuChi;
    private int maNhaCungCap;
    private Date ngayPhatSinh;
    private BigDecimal soTien;
    private int maNguoiDung;
    private String lyDo;

    public int getSoPhieuChi() {
        return soPhieuChi;
    }

    public int getMaNhaCungCap() {
        return maNhaCungCap;
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

    public void setSoPhieuChi(int soPhieuChi) {
        this.soPhieuChi = soPhieuChi;
    }

    public void setMaNhaCungCap(int maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
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

    public PhieuChi(int soPhieuChi, int maNhaCungCap, Date ngayPhatSinh, BigDecimal soTien, int maNguoiDung, String lyDo) {
        this.soPhieuChi = soPhieuChi;
        this.maNhaCungCap = maNhaCungCap;
        this.ngayPhatSinh = ngayPhatSinh;
        this.soTien = soTien;
        this.maNguoiDung = maNguoiDung;
        this.lyDo = lyDo;
    }

    public PhieuChi() {
        super();
    }
    
}
