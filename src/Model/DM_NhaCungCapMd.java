/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Entity.DM_NhaCungCap;
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
public class DM_NhaCungCapMd extends ConnectDtbs{
    public List<DM_NhaCungCap> getDM_NhaCungCap(){
        List<DM_NhaCungCap> list = new ArrayList<DM_NhaCungCap>();
        String sql = "Select *from DM_NhaCungCap";
        getConnection();
        try {
            Statement stt = connection.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            while(rs.next()){
                DM_NhaCungCap ncc = new DM_NhaCungCap();
                ncc.setMaNhaCungCap(rs.getInt("MaNhaCungCap"));
                System.out.print(ncc.getMaNhaCungCap()+" ");
                ncc.setTenNhaCungCap(rs.getString("TenNhaCungCap"));
                System.out.print(ncc.getTenNhaCungCap()+"  ");
                ncc.setDiaChi(rs.getString("DiaChi"));
                System.out.print(ncc.getDiaChi()+"  ");
                ncc.setSoDienThoai(rs.getInt("SoDienThoai"));
                System.out.print(ncc.getSoDienThoai()+"  ");
                ncc.setMaSoThue(rs.getString("MaSoThue"));
                System.out.print(ncc.getMaSoThue()+"  ");
                ncc.setEmail(rs.getString("Email"));
                System.out.println(ncc.getEmail()+"  ");
                list.add(ncc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DM_NhaCungCapMd.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close();
        }
        return list;
    }
    public int addDM_NhaCungCap(DM_NhaCungCap ncc){
        int flag = 0;
        String sql = "insert DM_NhaCungCap(TenNhaCungCap,DiaChi,SoDienThoai,MaSoThue,Email) values(?,?,?,?,?)";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,ncc.getTenNhaCungCap());
            stmt.setString(2,ncc.getDiaChi());
            stmt.setInt(3, ncc.getSoDienThoai());
            stmt.setString(4, ncc.getMaSoThue());
            stmt.setString(5,ncc.getEmail());
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DM_NhaCungCapMd.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            close();
        }
        return flag;
    }
    public int deleteDM_NhaCungCap(int id){
        int flag = 0;
        String sql = "delete DM_NhaCungCap where MaNhaCungCap = ?";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DM_NhaCungCapMd.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            close();
        }
        return flag;
    }
    public int updateDM_NhaCungCap(DM_NhaCungCap ncc,int id){
        int flag = 0;
        String sql = "update DM_NhaCungCap set TenNhaCungCap =?,DiaChi =?,SoDienThoai = ?,MaSoThue = ?,Email = ? where MaNhaCungCap= ?";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, ncc.getTenNhaCungCap());
            stmt.setString(2, ncc.getDiaChi());
            stmt.setInt(3, ncc.getSoDienThoai());
            stmt.setString(4, ncc.getMaSoThue());
            stmt.setString(5, ncc.getEmail());
            stmt.setInt(6, id);
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DM_NhaCungCapMd.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            close();
        }
        return flag;
    }
    public static void main(String []args){
        DM_NhaCungCapMd  nccMd = new DM_NhaCungCapMd();
        nccMd.getDM_NhaCungCap();
//        DM_NhaCungCap ncc = new DM_NhaCungCap();
//        ncc.setTenNhaCungCap("quocgia");
//        ncc.setDiaChi("caugiay");
//        ncc.setSoDienThoai(01536456);
//        ncc.setMaSoThue("0846576");
//        ncc.setEmail("haha@gmail");
//        nccMd.addDM_NhaCungCap(ncc);
   }
}
