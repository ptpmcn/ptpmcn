/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Entity.ChietKhau;
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
 * @author Mr cuong
 */
public class ChietKhauMd extends ConnectDtbs{
    public List<ChietKhau> getChietKhau(){
        List<ChietKhau> list = new ArrayList<ChietKhau>();
        String sql = "select *from ChietKhau";
        getConnection();
        try {
            Statement stt = connection.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            while(rs.next()){
                ChietKhau chietkhau = new ChietKhau();
                chietkhau.setDoanhSo(rs.getDouble("DoanhSo"));
                chietkhau.setChietKhau(rs.getInt("ChietKhau"));
                chietkhau.setMaNhaCungCap(rs.getInt("MaNhaCungCap"));
                list.add(chietkhau);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChietKhauMd.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            close();
        }
        return list;
    }
    public int addChietKhau(ChietKhau ck){
        int flag = 0;
        String sql = "insert Chietkhau(DoanhSo,ChietKhau,MaNhaCungCap) values(?,?,?)";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDouble(1, ck.getDoanhSo());
            stmt.setInt(2, ck.getChietKhau());
            stmt.setInt(3, ck.getMaNhaCungCap());
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChietKhauMd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        return flag;
    }
    public int deleteChietKhau(int id){
        int flag =0;
        String sql = "delete ChietKhau where MaNhaCungCap = ?";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChietKhauMd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        return flag;
    }
    public int updateChietKhau(ChietKhau ck,int id){
        int flag = 0;
        String sql = "update ChietKhau set DoanhSo = ?, ChietKhau =? where MaNhaCungCap =?";
        getConnection();
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setDouble(1, ck.getDoanhSo());
            stmt.setInt(2, ck.getChietKhau());
            stmt.setInt(3, id);
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChietKhauMd.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close();
        }
        return flag;
    }
}
