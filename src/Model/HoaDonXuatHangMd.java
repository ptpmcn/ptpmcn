/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.HoaDonXuatHang;
import Entity.PhieuThu;
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
public class HoaDonXuatHangMd extends ConnectDtbs{
    public List<HoaDonXuatHang> getHoaDonXuatHang(){
        List<HoaDonXuatHang> list = new ArrayList<HoaDonXuatHang>();
        String sql = "Select * From HoaDonXuatHang";
        getConnection();
        Statement stt;
        try {
            stt = connection.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            while(rs.next()){
                HoaDonXuatHang hoaDonXuat = new HoaDonXuatHang();
                hoaDonXuat.setSoHoaDon(rs.getInt("SoHoaDon"));
                hoaDonXuat.setMaKhachHang(rs.getInt("MaKhachHang"));
                hoaDonXuat.setNgayPhatSinh(rs.getDate("NgayPhatSinh"));
                hoaDonXuat.setSoTienThanhToan(rs.getBigDecimal("SoThanhToan"));
                hoaDonXuat.setMaNguoiDung(rs.getInt("MaNguoiDung"));
                hoaDonXuat.setTrangThai(rs.getBoolean("TrangThai"));
                list.add(hoaDonXuat);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonXuatHangMd.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close();
        }
        return list;
        
    }
    
    public int addHoaDonXuatHang(HoaDonXuatHang hoaDonXuat){
        int flag = 0;
        // tu dong tan id nen ko can phai add id
        String sql ="Insert Into HoaDonXuatHang(MaKhachHang,NgayPhatSinh,SoThanhToan,MaNguoiDung,TrangThai) Values (?,?,?,?,?)";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, hoaDonXuat.getMaKhachHang());
            stmt.setDate(2, new java.sql.Date((hoaDonXuat.getNgayPhatSinh()).getTime()) );            
            stmt.setBigDecimal(3, hoaDonXuat.getSoTienThanhToan());
            stmt.setInt(4, hoaDonXuat.getMaNguoiDung());
            stmt.setBoolean(5, hoaDonXuat.isTrangThai());
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonXuatHangMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return flag;
    }
    
    public int deleteHoaDonXuatHang(int id){
        int flag = 0;
        String sql = "Delete HoaDonXuatHang Where SoHoaDon = ?";
        getConnection();
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonXuatHangMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return flag;           
    }
    public int updateHoaDonXuatHang(HoaDonXuatHang hoaDonXuat){
        int flag = 0;
        
        String sql = "Update HoaDonXuatHang Set MaKhachHang = ?, NgayPhatSinh = ?, SoThanhToan = ?, MaNguoiDung = ?, TrangThai = ?  Where SoHoaDon = ?";
        getConnection();
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, hoaDonXuat.getMaKhachHang());
            stmt.setDate(2, new java.sql.Date((hoaDonXuat.getNgayPhatSinh()).getTime()));
            stmt.setBigDecimal(3, hoaDonXuat.getSoTienThanhToan());
            stmt.setInt(4, hoaDonXuat.getMaNguoiDung());
            stmt.setBoolean(5, hoaDonXuat.isTrangThai());
            stmt.setInt(6, hoaDonXuat.getSoHoaDon());
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonXuatHangMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return flag;
    }
    
   
    //Testing
    public static void main(String[] args){
        HoaDonXuatHangMd hoaDonXuatMd = new HoaDonXuatHangMd();
        Date date = new Date();
        BigDecimal t = new BigDecimal(2000);
        HoaDonXuatHang hoaDonXuat = new HoaDonXuatHang(1, 2, date, t, 3, true);
        
        
 //       System.out.println(""+hoaDonXuatMd.addHoaDonXuatHang(hoaDonXuat));
        System.out.println(""+hoaDonXuatMd.updateHoaDonXuatHang(hoaDonXuat));
 //       System.out.println(""+hoaDonXuatMd.deleteHoaDonXuatHang(2));
        List<HoaDonXuatHang> l = new ArrayList<HoaDonXuatHang>();
        l = hoaDonXuatMd.getHoaDonXuatHang();
        for(HoaDonXuatHang hd: l){
            System.out.println(""+ hd.getMaKhachHang()+" "+hd.getNgayPhatSinh()+" "+hd.getSoTienThanhToan()+" "+ hd.isTrangThai());
        }        
        
    }
}
