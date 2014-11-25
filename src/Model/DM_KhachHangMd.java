/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.DM_KhachHang;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dat
 */
public class DM_KhachHangMd extends ConnectDtbs{
    public List<DM_KhachHang> getDM_KhachHang(){
        List<DM_KhachHang> list = new ArrayList<DM_KhachHang>();
        String sql = "Select * From DM_KhachHang";
        getConnection();
        Statement stt;
        try {
            stt = connection.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            while(rs.next()){
                DM_KhachHang khachhang = new DM_KhachHang();
                khachhang.setDiaChi(rs.getString("DiaChi"));
                khachhang.setEmail(rs.getString("Email"));
                khachhang.setMaKhachHang(rs.getInt("MaKhachHang"));
                khachhang.setMaSoThue(rs.getInt("MaSoThue"));
                khachhang.setSoDienThoai(rs.getString("SoDienThoai"));
                khachhang.setTenKhachHang(rs.getString("TenKhachHang"));
                list.add(khachhang);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DM_KhachHangMd.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close();
        }
        return list;
        
    }
    
    
    public int addDM_KhachHang(DM_KhachHang khachHang){
        int flag = 0;
        // tu dong tan id nen ko can phai add id
        String sql ="Insert Into DM_KhachHang(TenKhachHang,DiaChi,SoDienThoai,MaSoThue,Email) Values (?,?,?,?,?)";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, khachHang.getTenKhachHang());
            stmt.setString(2, khachHang.getDiaChi());
            stmt.setString(3, khachHang.getSoDienThoai());
            stmt.setInt(4, khachHang.getMaSoThue());
            stmt.setString(5, khachHang.getEmail());
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DM_KhachHangMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return flag;
    }
    public int deleteDM_KhachHang(int id){
        int flag = 0;
        String sql = "Delete DM_KhachHang Where MaKhachHang = ?";
        getConnection();
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DM_KhachHangMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return flag;           
    }
    
    public int updateDM_KhachHang(DM_KhachHang khachHang){
        int flag = 0;
        String sql = "Update DM_KhachHang Set TenKhachHang = ?, DiaChi= ?, SoDienThoai = ?, MaSoThue = ?, Email = ?  Where MaKhachHang = ?";
        getConnection();
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, khachHang.getTenKhachHang());
            stmt.setString(2, khachHang.getDiaChi());
            stmt.setString(3, khachHang.getSoDienThoai());
            stmt.setInt(4, khachHang.getMaSoThue());
            stmt.setString(5, khachHang.getEmail());
            stmt.setInt(6, khachHang.getMaKhachHang());
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DM_KhachHangMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return flag;
    }
    
    //Testing
    public static void main(String[] args){
        DM_KhachHangMd khMd = new DM_KhachHangMd();
        DM_KhachHang khachHang = new DM_KhachHang();
        DM_KhachHang khachHang1 = new DM_KhachHang(1,"DoanVanDat","KTX","21412",21,"dat@gmail");
        
 //       System.out.println(""+khMd.addDM_KhachHang(khachHang1));
        System.out.println(""+khMd.addDM_KhachHang(khachHang1));
        List<DM_KhachHang> l = new ArrayList<DM_KhachHang>();
        l = khMd.getDM_KhachHang();
        for(DM_KhachHang kh: l){
            System.out.println(""+ kh.getTenKhachHang()+" "+kh.getEmail());
        }        
        
    }
}
