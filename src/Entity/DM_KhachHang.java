/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Dat
 */
public class DM_KhachHang {
    private int maKhachHang;
    private String tenKhachHang;
    private String diaChi;
    private String soDienThoai;
    private int maSoThue;
    private String email;

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public int getMaSoThue() {
        return maSoThue;
    }

    public String getEmail() {
        return email;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setMaSoThue(int maSoThue) {
        this.maSoThue = maSoThue;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DM_KhachHang(){
        super();
    }
    public DM_KhachHang(int maKhachHang, String tenKhachHang, String diaChi, String soDienThoai, int maSoThue, String email) {
        super();
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.maSoThue = maSoThue;
        this.email = email;
    }
    
}
