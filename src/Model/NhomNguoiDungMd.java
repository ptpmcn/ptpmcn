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
    public ResultSet getNhomND(){
        //List<NhomNguoiDung> list = new ArrayList<NhomNguoiDung>();
        String sql = "Select * From NhomNguoiDung";
        ResultSet rs = null;
        getConnection();
        try {
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
          /*  while(rs.next()){
                NhomNguoiDung nhomND = new NhomNguoiDung();
                nhomND.setMaNhom(rs.getInt("MaNhomNguoiDung"));
                nhomND.setTenNhom(rs.getString("TenNhomNguoiDung"));
                nhomND.setGhiChu(rs.getString("GhiChu"));
                list.add(nhomND);
            }
                  */
        } catch (SQLException ex) {
            Logger.getLogger(NhomNguoiDungMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        
        return rs;
    }

    /**
     *
     * @return
     */
    public List <NhomNguoiDung> getListNhomND(){
        List<NhomNguoiDung> list = new ArrayList<NhomNguoiDung>();
        String sql = "Select * From NhomNguoiDung";
        ResultSet rs = null;
        getConnection();
        try {
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                NhomNguoiDung nhomND = new NhomNguoiDung();
                nhomND.setMaNhom(rs.getInt("MaNhomNguoiDung"));
                nhomND.setTenNhom(rs.getString("TenNhomNguoiDung"));
                nhomND.setGhiChu(rs.getString("GhiChu"));
                list.add(nhomND);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(NhomNguoiDungMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        
        return null;
    }
    public int addNhomND(NhomNguoiDung nND){
        int flag = 0;
        String sql = "Insert Into NhomNguoiDung Values (?,?)";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nND.getTenNhom());
            stmt.setString(2, nND.getGhiChu());
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhomNguoiDungMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public int updateNhomND(NhomNguoiDung nND){
        int flag = 0 ;
        String sql = "Update NhomNguoiDung Set TenNhomNguoiDung = ?, GhiChu = ? Where MaNhomNguoiDung = ?";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(3, nND.getMaNhom());
            stmt.setString(1, nND.getTenNhom());
            stmt.setString(2, nND.getGhiChu());
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhomNguoiDungMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return flag;
    }
    
    public NhomNguoiDung getNhomND(String id){
        NhomNguoiDung nND = new NhomNguoiDung();
        String sql = "Select * From NhomNguoiDung Where MaNhomNguoiDung = "+id+";";
        getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                nND.setMaNhom(rs.getInt("MaNhomNguoiDung"));
                nND.setTenNhom(rs.getString("TenNhomNguoiDung"));
                nND.setGhiChu(rs.getString("GhiChu"));
                return nND;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(NhomNguoiDungMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return null;
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
       NhomNguoiDungMd t = new NhomNguoiDungMd();
       List<NhomNguoiDung> nND = t.getListNhomND();
       for(NhomNguoiDung n : nND){
           System.out.println(""+n.getTenNhom()+" "+n.getGhiChu()+" "+n.getMaNhom());
       }
      
       
   }
}
