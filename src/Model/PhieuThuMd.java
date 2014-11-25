/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.PhieuThu;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
/**
 *
 * @author Dat
 */
public class PhieuThuMd extends ConnectDtbs{

    public List<PhieuThu> getPhieuThu(){
        List<PhieuThu> list = new ArrayList<PhieuThu>();
        String sql = "Select * From PhieuThu";
        getConnection();
        Statement stt;
        try {
            stt = connection.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            while(rs.next()){
                PhieuThu phieuThu = new PhieuThu();
                phieuThu.setSoPhieuThu(rs.getInt("SoPhieuThu"));
                phieuThu.setMaKhachHang(rs.getInt("MaKhachHang"));
                phieuThu.setNgayPhatSinh(rs.getDate("NgayPhatSinh"));
                phieuThu.setSoTien(rs.getBigDecimal("SoTien"));
                phieuThu.setMaNguoiDung(rs.getInt("MaNguoiDung"));
                phieuThu.setLyDo(rs.getString("LiDo"));
                list.add(phieuThu);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuThuMd.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close();
        }
        return list;
        
    }
    
    
    public int addPhieuThu(PhieuThu phieuThu){
        int flag = 0;
        // tu dong tan id nen ko can phai add id
        String sql ="Insert Into PhieuThu(MaKhachHang,NgayPhatSinh,SoTien,MaNguoiDung,LiDo) Values (?,?,?,?,?)";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, phieuThu.getMaKhachHang());
            stmt.setDate(2, new java.sql.Date((phieuThu.getNgayPhatSinh()).getTime()) );            
            stmt.setBigDecimal(3, phieuThu.getSoTien());
            stmt.setInt(4, phieuThu.getMaNguoiDung());
            stmt.setString(5, phieuThu.getLyDo());
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhieuThuMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return flag;
    }
    
    public int deletePhieuThu(int id){
        int flag = 0;
        String sql = "Delete PhieuThu Where SoPhieuThu = ?";
        getConnection();
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhieuThuMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return flag;           
    }
    public int updatePhieuThu(PhieuThu phieuThu){
        int flag = 0;
        
        String sql = "Update PhieuThu Set MaKhachHang = ?, NgayPhatSinh = ?, SoTien = ?, MaNguoiDung = ?, LiDo = ?  Where SoPhieuThu = ?";
        getConnection();
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, phieuThu.getMaKhachHang());
            stmt.setDate(2, new java.sql.Date((phieuThu.getNgayPhatSinh()).getTime()));
            stmt.setBigDecimal(3, phieuThu.getSoTien());
            stmt.setInt(4, phieuThu.getMaNguoiDung());
            stmt.setString(5, phieuThu.getLyDo());
            stmt.setInt(6,phieuThu.getSoPhieuThu());
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhieuThuMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return flag;
    }
    
   
    //Testing
    public static void main(String[] args){
        PhieuThuMd phieuThuMd = new PhieuThuMd();
        Date date = new Date();
        BigDecimal t = new BigDecimal(10022);
        PhieuThu phieuThu = new PhieuThu(1,2,date,t,3,"Tra no 1 ");
   
        
        
        
  //      System.out.println(""+phieuThuMd.addPhieuThu(phieuThu));
 //       System.out.println(""+phieuThuMd.deletePhieuThu(2));
//        System.out.println(""+phieuThuMd.updatePhieuThu(phieuThu));
        List<PhieuThu> l = new ArrayList<PhieuThu>();
        l = phieuThuMd.getPhieuThu();
        for(PhieuThu pt: l){
            System.out.println(""+ pt.getMaKhachHang()+" "+pt.getNgayPhatSinh()+" "+pt.getSoTien()+" "+ pt.getLyDo());
        }        
        
    }
}
