/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.ChiTietHoaDonXuatHang;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.*;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dat
 */
public class ChiTietHoaDonXuatHangMd extends ConnectDtbs{
    public List<ChiTietHoaDonXuatHang> getChiTietHoaDonXuatHang(){
        List<ChiTietHoaDonXuatHang> list = new ArrayList<ChiTietHoaDonXuatHang>();
        String sql = "Select * From ChiTietHoaDonXuatHang";
        getConnection();
        Statement stt;
        try {
            stt = connection.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            while(rs.next()){
                ChiTietHoaDonXuatHang chiTietHoaDonXuat = new ChiTietHoaDonXuatHang();
                chiTietHoaDonXuat.setId(rs.getInt("id"));
                chiTietHoaDonXuat.setSoHoaDon(rs.getInt("SoHoaDon"));
                chiTietHoaDonXuat.setMaSanPham(rs.getInt("MaSanPham"));
                chiTietHoaDonXuat.setSoLuong(rs.getInt("SoLuong"));
                chiTietHoaDonXuat.setDonGia(rs.getBigDecimal("DonGia"));
                list.add(chiTietHoaDonXuat);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonXuatHangMd.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close();
        }
        return list;
        
    }
    
    public int addChiTietHoaDonXuatHang(ChiTietHoaDonXuatHang chiTietHoaDonXuat){
        int flag = 0;
        // cần cho Id vào
        String sql ="Insert Into ChiTietHoaDonXuatHang(SoHoaDon,MaSanPham,SoLuong,DonGia) Values (?,?,?,?)";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, chiTietHoaDonXuat.getSoHoaDon());
            stmt.setInt(2, chiTietHoaDonXuat.getMaSanPham());
            stmt.setInt(3, chiTietHoaDonXuat.getSoLuong());
            stmt.setBigDecimal(4, chiTietHoaDonXuat.getDonGia());
            
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonXuatHangMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return flag;
    }
    
    public int deleteChiTietHoaDonXuatHang(int id){
        int flag = 0;
        String sql = "Delete ChiTietHoaDonXuatHang Where id = ?";
        getConnection();
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonXuatHangMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return flag;           
    }
    public int updateChiTietHoaDonXuatHang(ChiTietHoaDonXuatHang chiTietHoaDonXuat){
        int flag = 0;
        
        String sql = "Update ChiTietHoaDonXuatHang Set SoHoaDon = ?, MaSanPham = ?, SoLuong = ?, DonGia = ? Where id = ?";
        getConnection();
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, chiTietHoaDonXuat.getSoHoaDon());
            stmt.setInt(2, chiTietHoaDonXuat.getMaSanPham());
            stmt.setInt(3, chiTietHoaDonXuat.getSoLuong());
            stmt.setBigDecimal(4, chiTietHoaDonXuat.getDonGia());
            stmt.setInt(5, chiTietHoaDonXuat.getId());
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonXuatHangMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return flag;
    }
    
   
    //Testing
    public static void main(String[] args){
        ChiTietHoaDonXuatHangMd chiTietHoaDonXuatMd = new ChiTietHoaDonXuatHangMd();
        BigDecimal donGia = new BigDecimal("23000.0");
        ChiTietHoaDonXuatHang chiTietHoaDonXuat = new ChiTietHoaDonXuatHang(1,1,2,2,donGia);

//        
 //      System.out.println(""+chiTietHoaDonXuatMd.addChiTietHoaDonXuatHang(chiTietHoaDonXuat));
 //       System.out.println(""+chiTietHoaDonXuatMd.deleteChiTietHoaDonXuatHang(1));
        System.out.println(""+chiTietHoaDonXuatMd.updateChiTietHoaDonXuatHang(chiTietHoaDonXuat));
       
        List<ChiTietHoaDonXuatHang> l = new ArrayList<ChiTietHoaDonXuatHang>();
        l = chiTietHoaDonXuatMd.getChiTietHoaDonXuatHang();
        for(ChiTietHoaDonXuatHang hd: l){
            System.out.println(""+ hd.getMaSanPham()+" "+hd.getSoLuong()+" "+hd.getDonGia());
        }        
        
    }
}
