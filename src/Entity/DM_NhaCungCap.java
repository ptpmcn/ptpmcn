/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Mr cuong
 */
public class DM_NhaCungCap {
    private int maNhaCungCap;
    private String tenNhaCungcap;
    private String diaChi;
    private int soDienThoai;
    private String maSoThue;
    private String email;
     
    public void setMaNhaCungCap(int mncc){
        this.maNhaCungCap = mncc;
    }
    public void setTenNhaCungCap(String tncc){
        this.tenNhaCungcap = tncc;
    }
    public void setDiaChi(String dc){
        this.diaChi = dc;
    }
    public void setSoDienThoai(int sdt){
        this.soDienThoai = sdt;
    }
    public void setMaSoThue(String mst){
        this.maSoThue = mst;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public int getMaNhaCungCap(){
        return maNhaCungCap;
    }
    public String getTenNhaCungCap(){
        return tenNhaCungcap;
    }
    public String getDiaChi(){
        return diaChi;
    }
    public int getSoDienThoai(){
        return soDienThoai;
    }
    public String getMaSoThue(){
        return maSoThue;
    }
    public String getEmail(){
        return email;
    }
}
