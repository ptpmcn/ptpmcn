/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.DM_LoaiSanPham;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mr cuong
 */
public class DM_LoaiSanPhamMd extends ConnectDtbs {
    public List<DM_LoaiSanPham> getDM_LoaiSanPham(){
            List<DM_LoaiSanPham> list = new ArrayList<DM_LoaiSanPham>();
            String sql = "Select * From DM_LoaiSanPham";
            getConnection();
            try {
            Statement stt = connection.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            while(rs.next()){
               DM_LoaiSanPham lsp = new DM_LoaiSanPham();
               lsp.setMaLoaiSanPham(rs.getInt("MaLoaiSanPham"));
               System.out.print(lsp.getMaLoaiSanPham());
               lsp.setTenLoaiSanPham(rs.getString("TenLoaiSanPham"));
               System.out.println(""+lsp.getTenLoaiSanPham());
               list.add(lsp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DM_LoaiSanPhamMd.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            close();
        }
        return list;
    }
    
    public int addDM_LoaiSanPham(DM_LoaiSanPham lsp){
        int flag = 0;
        String sql = "Insert into DM_LoaiSanPham values(?)";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, lsp.getTenLoaiSanPham());
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DM_LoaiSanPhamMd.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            close();
        }
        return flag;
    }
    
    public int deleteDM_LoaiSanPham(int id){
        int flag = 0;
        String sql = "delete DM_LoaiSanPham where MaloaiSanPham = ?";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,id);
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DM_LoaiSanPhamMd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        return flag;
    }
    
    public int updateDM_LoaiSanPham(int id, String ten){
        int flag = 0;
        String sql = "update DM_LoaiSanPham set TenLoaiSanPham = ? where MaLoaiSanPham = ?";
        getConnection();
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1,ten);
            stmt.setInt(2, id);
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DM_LoaiSanPhamMd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        return flag;
    }
    public static void main(String[] args){
        DM_LoaiSanPhamMd lspMd = new DM_LoaiSanPhamMd();
//      System.out.print(lspMd.updateDM_LoaiSanPham(4,"vở"));
      lspMd.getDM_LoaiSanPham();
//      lspMd.deleteDM_LoaiSanPham(6);
//      DM_LoaiSanPham lsp = new DM_LoaiSanPham();
//      lsp.setTenLoaiSanPham("compa");
//      lspMd.addDM_LoaiSanPham(lsp);
    }
}
