/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Mr cuong
 */
public class NhaCungCap_SanPham {
    private int maSanPham;
    private int maNhaCungCap;
    
    public void setMaSanPham(int msp){
        this.maSanPham = msp;
    }
    public void setMaNhaCungCap(int mncc){
        this.maNhaCungCap = mncc;
    }
    public int getMaSanPham(){
        return maSanPham;
    }
    public int getMaNhaCungCap(){
        return maNhaCungCap;
    }
}
