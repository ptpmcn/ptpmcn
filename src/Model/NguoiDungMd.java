/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;
import Entity.NguoiDung;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Hồ Thúc Đồng
 */
public class NguoiDungMd extends ConnectDtbs{
    public ResultSet getNguoiDung(){
        //List<NguoiDung> list = new ArrayList<NguoiDung>();
        String sql = "Select nd.MaNguoiDung,nd.TenNguoiDung,nd.TaiKhoan,nND.TenNhomNguoiDung From NguoiDung as nd,NhomNguoiDung as nND Where nd.MaNhomNguoiDung = nND.MaNhomNguoiDung";
        getConnection();
        Statement stmt;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        /*    while(rs.next()){
                NguoiDung nd = new NguoiDung();
                nd.setMaND(rs.getInt("MaNguoiDung"));
                nd.setMaNhomND(rs.getInt("MaNhomNguoiDung"));
                nd.setMatkhau(rs.getString("MatKhau"));
                nd.setTaikhoan(rs.getString("TaiKhoan"));
                nd.setTenND(rs.getString("TenNguoiDung"));
                nd.setTrangthai(rs.getInt("TrangThai"));
                list.add(nd);
            }
            */
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return null;
    }
    
    
    public int addNguoiDung(NguoiDung nd){
        int flag = 0;
        String sql = "Insert Into NguoiDung Values (?,?,?,?,?)";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            /*auto incree id */
           // stmt.setInt(1, nd.getMaND());
            stmt.setString(1, nd.getTenND());
            stmt.setString(2, nd.getTaikhoan());
            stmt.setString(3, nd.getMatkhau());
            stmt.setInt(4, nd.getTrangthai());
            stmt.setInt(5, nd.getMaNhomND());
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        
        return flag;
    }
    
    public int deleteNguoiDung(int id){
        int flag = 0;
        String sql ="Delete From NguoiDung Where MaNguoiDung = ?";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return flag;
    }
    
    public int updateNguoiDung(NguoiDung nd){
        int flag = 0;
        String sql = "Update NguoiDung Set TenNguoiDung=?,TaiKhoan=?,MatKhau=?,TrangThai=?,MaNhomNguoiDung=? Where MaNguoiDung = ?";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nd.getTenND());
            stmt.setString(2, nd.getTaikhoan());
            stmt.setString(3, nd.getMatkhau());
            stmt.setInt(4, nd.getTrangthai());
            stmt.setInt(5, nd.getMaNhomND());
            stmt.setInt(6, nd.getMaND());
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungMd.class.getName()).log(Level.SEVERE, null, ex);
        }
       finally{
            close();
        }
        return flag;
    }
    
    public NguoiDung getNguoiDung(String maND){
        String sql = "Select * From NguoiDung Where MaNguoiDung = "+maND;
        getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                NguoiDung nd = new NguoiDung();
                nd.setMaND(rs.getInt("MaNguoiDung"));
                nd.setMaNhomND(rs.getInt("MaNhomNguoiDung"));
                nd.setMatkhau(rs.getString("MatKhau"));
                nd.setTaikhoan(rs.getString("TaiKhoan"));
                nd.setTenND(rs.getString("TenNguoiDung"));
                
                return nd;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void main(String[] args){
     /*   NguoiDungMd ndMd = new NguoiDungMd();
        NguoiDung n = new NguoiDung();
        n.setMaND(3);
        n.setMaNhomND(1);
        n.setMatkhau("12345");
        n.setTaikhoan("Copper");
        n.setTenND("XXX");
        n.setTrangthai(0);
        ndMd.updateNguoiDung(n);
        ndMd.deleteNguoiDung(2);
        for(NguoiDung nd : ndMd.getNguoiDung()){
            System.out.println(""+nd.getMaND()+" "+nd.getMaNhomND()+" "+nd.getTaikhoan()+" "+nd.getMatkhau()+" "+nd.getTenND()+" "+nd.getTrangthai());
        }
             */
    }
}
