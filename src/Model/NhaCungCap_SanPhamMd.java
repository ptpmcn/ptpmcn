/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Entity.NhaCungCap_SanPham;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mr cuong
 */
public class NhaCungCap_SanPhamMd extends ConnectDtbs{
    public int addNhaCungCap_SanPham(NhaCungCap_SanPham nccsp){
        int flag =0;
        String sql = "insert NhaCungCap_SanPham values(?,?)";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, nccsp.getMaSanPham());
            stmt.setInt(2, nccsp.getMaNhaCungCap());
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCap_SanPhamMd.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            close();
        }
        return flag;
    }
    public int deleteNhaCungCap_SanPham(int id){
        int flag = 0;
        String sql = "delete NhaCungCap_SanPham where MaNhaCungCap =?";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCap_SanPhamMd.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close();
        }
        return flag;
    }
    public int deleteSanPham_NhaCungCap(int id){
        int flag = 0;
        String sql = "delete NhaCungCap_SanPham where MaSanPham =?";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCap_SanPhamMd.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close();
        }
        return flag;
    }
    public int updateNhaCungCap_SanPham(NhaCungCap_SanPham nccsp, int id){
        int flag = 0;
        String sql = "update NhaCungCap_SanPham set MaSanPham = ? where MaNhaCungCap = ?";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, nccsp.getMaSanPham());
            stmt.setInt(2, id);
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCap_SanPhamMd.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close();
        }
        return flag;
    }
        public int updateSanPham_NhaCungCap(NhaCungCap_SanPham nccsp, int id){
        int flag = 0;
        String sql = "update NhaCungCap_SanPham set MaNhaCungCap = ? where MaSanPham = ?";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, nccsp.getMaNhaCungCap());
            stmt.setInt(2, id);
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCap_SanPhamMd.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close();
        }
        return flag;
    }
    public static void main(String []args){
        NhaCungCap_SanPhamMd nccspMd = new NhaCungCap_SanPhamMd();
        NhaCungCap_SanPham nccsp = new NhaCungCap_SanPham();
        nccsp.setMaSanPham(1);
        nccsp.setMaNhaCungCap(6);
        nccspMd.addNhaCungCap_SanPham(nccsp);
    }
}
