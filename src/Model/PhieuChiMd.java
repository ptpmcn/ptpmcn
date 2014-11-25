/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import Entity.PhieuChi;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dat
 */
public class PhieuChiMd extends ConnectDtbs{
    public List<PhieuChi> getPhieuChi(){
        List<PhieuChi> list = new ArrayList<PhieuChi>();
        String sql = "Select * From PhieuChi";
        getConnection();
        Statement stt;
        try {
            stt = connection.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            while(rs.next()){
                PhieuChi phieuChi = new PhieuChi();
                phieuChi.setSoPhieuChi(rs.getInt("SoPhieuChi"));
                phieuChi.setMaNhaCungCap(rs.getInt("MaNhaCungCap"));
                phieuChi.setNgayPhatSinh(rs.getDate("NgayPhatSinh"));
                phieuChi.setSoTien(rs.getBigDecimal("SoTien"));
                phieuChi.setMaNguoiDung(rs.getInt("MaNguoiDung"));
                phieuChi.setLyDo(rs.getString("LiDo"));
                list.add(phieuChi);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuChiMd.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close();
        }
        return list;
        
    }
    
    
    public int addPhieuChi(PhieuChi phieuChi){
        int flag = 0;
        // tu dong tan id nen ko can phai add id
        String sql ="Insert Into PhieuChi(MaNhaCungCap,NgayPhatSinh,SoTien,MaNguoiDung,LiDo) Values (?,?,?,?,?)";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, phieuChi.getMaNhaCungCap());
            stmt.setDate(2, new java.sql.Date((phieuChi.getNgayPhatSinh()).getTime()) );            
            stmt.setBigDecimal(3, phieuChi.getSoTien());
            stmt.setInt(4, phieuChi.getMaNguoiDung());
            stmt.setString(5, phieuChi.getLyDo());
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhieuChiMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return flag;
    }
    
    public int deletePhieuChi(int id){
        int flag = 0;
        String sql = "Delete PhieuChi Where SoPhieuChi= ?";
        getConnection();
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhieuChiMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return flag;           
    }
    public int updatePhieuChi(PhieuChi phieuChi){
        int flag = 0;
        
        String sql = "Update PhieuChi Set MaNhaCungCap = ?, NgayPhatSinh = ?, SoTien = ?, MaNguoiDung = ?, LiDo = ?  Where SoPhieuChi = ?";
        getConnection();
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, phieuChi.getMaNhaCungCap());
            stmt.setDate(2, new java.sql.Date((phieuChi.getNgayPhatSinh()).getTime()));
            stmt.setBigDecimal(3, phieuChi.getSoTien());
            stmt.setInt(4, phieuChi.getMaNguoiDung());
            stmt.setString(5, phieuChi.getLyDo());
            stmt.setInt(6, phieuChi.getSoPhieuChi());
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhieuChiMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return flag;
    }
    
   
    //Testing
    public static void main(String[] args){
        PhieuChiMd phieuChiMd = new PhieuChiMd();
        Date date = new Date();
        BigDecimal t = new BigDecimal(2000);
        PhieuChi phieuChi = new PhieuChi(2,2,date,t,3,"Phieu Chi 1");
  
 //      System.out.println(""+phieuChiMd.addPhieuChi(phieuChi));
 //       System.out.println(""+phieuChiMd.deletePhieuChi(2));
 //       System.out.println(""+phieuChiMd.updatePhieuChi(phieuChi));
        List<PhieuChi> l = new ArrayList<PhieuChi>();
        l = phieuChiMd.getPhieuChi();
        for(PhieuChi pc: l){
            System.out.println(""+ pc.getMaNhaCungCap()+" "+pc.getNgayPhatSinh()+" "+pc.getSoTien()+" "+ pc.getLyDo());
        }        
        
    }
}
