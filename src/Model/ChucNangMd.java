/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Entity.ChucNang;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hồ Thúc Đồng
 */
public class ChucNangMd extends ConnectDtbs{
    public List<ChucNang> getChucNangMd(){
        List<ChucNang> list = new ArrayList<ChucNang>();
        String sql ="Select * From ChucNang";
        getConnection();
        try {
            Statement stt = connection.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            while(rs.next()){
                ChucNang chucnang = new ChucNang();
                chucnang.setMaChucNang(rs.getInt("MaChucNang"));
                //System.out.println(""+chucnang.getMaChucNang());
                chucnang.setTenChucNang(rs.getString("TenChucNang"));
                //System.out.println(""+rs.getString("TenChucNang"));
                list.add(chucnang);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChucNangMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return list;
    }
    public int addChucNang(ChucNang chucNang){
        int flag = 0;
        // tu dong tan id nen ko can phai add id
        String slq ="Insert Into ChucNang Values (?)";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(slq);
            stmt.setString(1, chucNang.getTenChucNang());
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChucNangMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return flag;
    }
    public int deleteChucNang(int id){
        int flag = 0;
        String sql = "Delete ChucNang Where MaChucNang = ?";
        getConnection();
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChucNangMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return flag;       
    }
    public int updateChucNang(int id, ChucNang chucNang){
        int flag = 0;
        String sql = "Update ChucNang Set TenChucNang=? Where MaChucNang = ?";
        getConnection();
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, chucNang.getTenChucNang());
            stmt.setInt(2, id);
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChucNangMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            close();
        }
        return flag;
    }
    // for testing purpose
    public static void main(String[] args){
        ChucNangMd cnMd = new ChucNangMd();
        ChucNang chucnang = new ChucNang();
        ChucNang chucnang1 = new ChucNang();
        chucnang1.setMaChucNang(6);
        chucnang1.setTenChucNang("sua");
        cnMd.updateChucNang(1, chucnang1);
        chucnang.setTenChucNang("chilli");
        cnMd.deleteChucNang(6);
        System.out.println(""+cnMd.addChucNang(chucnang));
        List<ChucNang> l = new ArrayList<ChucNang>();
        l = cnMd.getChucNangMd();
        for(ChucNang cn: l){
            System.out.println(""+ cn.getTenChucNang()+" "+cn.getMaChucNang());
        }
    }
}
