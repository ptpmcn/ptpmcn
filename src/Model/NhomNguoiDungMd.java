/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Entity.NhomNguoiDung;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
/**
 *
 * @author Hồ Thúc Đồng
 */
public class NhomNguoiDungMd extends ConnectDtbs {
    public List<NhomNguoiDung> getNhomND(){
        List<NhomNguoiDung> list = new ArrayList<NhomNguoiDung>();
        String sql = "Select * From NhomNguoiDung";
        getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                NhomNguoiDung nhomND = new NhomNguoiDung();
                nhomND.setMaNhom(rs.getInt("MaNhomNguoiDung"));
                nhomND.setTenNhom(rs.getString("TenNhomNguoiDung"));
                nhomND.setGhiChu(rs.getString("GhiChu"));
                list.add(nhomND);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhomNguoiDungMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        
        return list;
    }
    public int addNhomND(NhomNguoiDung nND){
        int flag = 0;
        String sql = "Insert Into NhomNguoiDung Values (?,?,?)";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, nND.getMaNhom());
            stmt.setString(2, nND.getTenNhom());
            stmt.setString(3, nND.getGhiChu());
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhomNguoiDungMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public int updateNhomND(NhomNguoiDung nND){
        int flag = 0 ;
        String sql = "Update NhomNguoiDung Set MaNhomNguoiDung = ?, TenNhomNguoiDung = ?, GhiChu = ? ";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, nND.getMaNhom());
            stmt.setString(2, nND.getTenNhom());
            stmt.setString(3, nND.getGhiChu());
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhomNguoiDungMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return flag;
    }
    
    public int deleteNhomND(int id){
        int flag = 0;
        String sql = "Delete From NhomNguoiDung Where MaNhomNguoiDung = ?";
        getConnection();
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhomNguoiDungMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        
        return flag;
    }
    
    public static void main(String[] args){
        NhomNguoiDungMd nND = new NhomNguoiDungMd();
        NhomNguoiDung nd = new NhomNguoiDung();
        nd.setMaNhom(1);
        nd.setGhiChu("xxxTest");
        nd.setTenNhom("xxxTest");
        nND.updateNhomND(nd);
        List<NhomNguoiDung> list = nND.getNhomND();
        for(NhomNguoiDung n: list){
            System.out.println(""+n.getTenNhom()+" "+n.getGhiChu()+" "+n.getMaNhom());
        }
    }
}
