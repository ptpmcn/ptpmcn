/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Mr cuong
 */
public class DM_SanPham {
    private int maSanPham;
    private int maLoaiSanPham;
    private String tenSanPham;
    private String donViTinh;
    private double donGiaChuan;
    private int soDu;
    private String maVach;
    
    public void setMaSanPham(int maSanPham){
        this.maSanPham = maSanPham;
    }
    public void setMaLoaiSanPham(int malsp){
        this.maLoaiSanPham = malsp;
    }
    public void setTenSanPham(String tsp){
        this.tenSanPham = tsp;
    }
    public void setDonViTinh(String dvt){
        this.donViTinh = dvt;
    }
    public void setDonGiaChuan(double dgc){
        this.donGiaChuan = dgc;
    }
    public void setSoDu(int sodu){
        this.soDu = sodu;
    }
    public void setMaVach(String MaVach){
        this.maVach = MaVach;
    }
    
    public int getMaSanPham(){
        return maSanPham;
    }
    public int getMaLoaiSanPham(){
        return maLoaiSanPham;
    }
    public String getTenSanPham(){
        return tenSanPham;
    }
    public String getDonViTinh(){
        return donViTinh;
    }
    public double getDonGiaChuan(){
        return donGiaChuan;
    }
    public int getSoDu(){
        return soDu;
    }
    public String getMaVach(){
        return maVach;
    }
}
