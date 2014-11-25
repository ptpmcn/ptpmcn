/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Mr cuong
 */
public class DM_LoaiSanPham {
    private int maLoaiSanPham;
    private String tenLoaiSanPham;
    
    public void setMaLoaiSanPham(int maLoaiSanPham){
        this.maLoaiSanPham = maLoaiSanPham;
    }
    
    public int getMaLoaiSanPham(){
        return this.maLoaiSanPham;
    }
    
    public void setTenLoaiSanPham(String tenLoaiSanPham){
        this.tenLoaiSanPham = tenLoaiSanPham;
    }
    
    public String getTenLoaiSanPham(){
        return this.tenLoaiSanPham;
    }

    public void setMaLoaiSanPham(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
