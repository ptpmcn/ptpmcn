/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;
import Entity.PhanQuyen;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hồ Thúc Đồng
 */
public class PhanQuyenMd extends ConnectDtbs{
    public List<PhanQuyen> getPhanQuyen(){
        List<PhanQuyen> list = new ArrayList<PhanQuyen>();
        String sql = "Select * From PhanQuyen";
        getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                PhanQuyen pq = new PhanQuyen();
                pq.setMaPhanQuyen(rs.getInt("MaPhanQuyen"));
                pq.setMaChucNang(rs.getInt("MaChucNang"));
                pq.setTenQuyen(rs.getString("TenQuyen"));
                list.add(pq);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhanQuyenMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return list;
    }
    
    public int addPhanQuyen(PhanQuyen pq){
        int flag = 0;
        String sql = "Insert Into PhanQuyen values (?,?,?)";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, pq.getMaPhanQuyen());
            stmt.setInt(2, pq.getMaChucNang());
            stmt.setString(3, pq.getTenQuyen());
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhanQuyenMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
       return flag;
    }
    
    public int deletePhanQuyen(int id){
        int flag = 0;
        String sql = "Delete From PhanQuyen Where MaPhanQuyen = ?";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhanQuyenMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return flag;
    }
    
    public int updatePhanQuyen(PhanQuyen pq){
        int flag = 0;
        String sql = "Update PhanQuyen Set MaChucNang = ?, TenQuyen = ?, MaNhomNguoiDung = ? Where MaPhanQuyen = ?";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, pq.getMaChucNang());
            stmt.setString(2, pq.getTenQuyen());
            stmt.setInt(3, pq.getMaNhomND());
            stmt.setInt(4, pq.getMaPhanQuyen());
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhanQuyenMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return flag;
    }
    public static void main(String[] args){
        PhanQuyenMd pqMd = new PhanQuyenMd();
        PhanQuyen pq = new PhanQuyen();
        pq.setMaPhanQuyen(1);
        pq.setMaChucNang(1);
        pq.setMaNhomND(1);
        pq.setTenQuyen("TestUpdate2");
        System.out.println(pqMd.updatePhanQuyen(pq));
        System.out.println(""+pqMd.deletePhanQuyen(2));
        List<PhanQuyen> l = pqMd.getPhanQuyen();
        for(PhanQuyen pqt: l){
            System.out.println(""+pqt.getMaPhanQuyen()+" "+pqt.getMaChucNang()+" "+pqt.getTenQuyen());
        }
    }
}
