/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Mr cuong
 */
public class ChietKhau {
    private int maChietKhau;
    private double doanhSo;
    private int chietKhau;
    private int maNhaCungCap;
    public void setMaChietKhau(int mck){
        this.maChietKhau = mck;
    }
    public void setDoanhSo(double ds){
        this.doanhSo = ds;
    }
    public void setChietKhau(int ck){
        this.chietKhau = ck;
    }
    public void setMaNhaCungCap(int mncc){
        this.maNhaCungCap = mncc;
    }
    public int getMaChietKhau(){
        return maChietKhau;
    }
    public double getDoanhSo(){
        return doanhSo;
    }
    public int getChietKhau(){
        return chietKhau;
    }
    public int getMaNhaCungCap(){
        return maNhaCungCap;
    }

}
