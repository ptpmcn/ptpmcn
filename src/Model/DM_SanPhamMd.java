/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Entity.DM_SanPham;
import java.sql.Connection;
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
public class DM_SanPhamMd extends ConnectDtbs{
    public List<DM_SanPham> getDM_SanPham(){
        List<DM_SanPham> list = new ArrayList<DM_SanPham>();
        String sql ="Select *from DM_SanPham";
        getConnection();
        try {
            Statement stt = connection.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()){
                DM_SanPham sp = new DM_SanPham();
                sp.setMaSanPham(rs.getInt("MaSanPham"));
                System.out.print(sp.getMaSanPham()+"  ");
                sp.setMaLoaiSanPham(rs.getInt("MaLoaiSanPham"));
                System.out.print(sp.getMaLoaiSanPham()+"  ");
                sp.setTenSanPham(rs.getString("TenSanPham"));
                System.out.print(sp.getTenSanPham()+"  ");
                sp.setDonViTinh(rs.getString("DonViTinh"));
                System.out.print(sp.getDonViTinh()+"  ");
                sp.setDonGiaChuan(rs.getDouble("DonGiaChuan"));
                System.out.print(sp.getDonGiaChuan()+"  ");
                sp.setSoDu(rs.getInt("SoDu"));
                System.out.print(sp.getSoDu()+"  ");
                sp.setMaVach(rs.getString("MaVach"));
                System.out.println(sp.getMaVach()+"  ");
                list.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DM_SanPhamMd.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        close();
        }
        return list;  
    }
    public int addDM_SanPham(DM_SanPham sp){
        int flag = 0;
        String sql = "Insert into DM_SanPham(MaLoaiSanPham,TenSanPham,DonViTinh,DonGiaChuan,SoDu,MaVach) values(?,?,?,?,?,?)";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,sp.getMaLoaiSanPham());
            stmt.setString(2,sp.getTenSanPham());
            stmt.setString(3,sp.getDonViTinh());
            stmt.setDouble(4, sp.getDonGiaChuan());
            stmt.setInt(5, sp.getSoDu());
            stmt.setString(6,sp.getMaVach());
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DM_SanPhamMd.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
//        this.getDM_SanPham();
        return flag;
    }
    public int deleteDM_SanPham(int id){
        int flag = 0;
        String sql = "delete DM_SanPham where MaSanPham = ?";
        getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DM_SanPhamMd.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        close();}
        return flag;
    }
    public int updateDM_SanPham(DM_SanPham sp,int id){
        int flag = 0;
        String sql = "update DM_SanPham set MaloaiSanPham = ?, TenSanPham = ?,DonViTinh = ?,DonGiaChuan = ?,SoDu = ?,MaVach = ? where MaSanPham = ?";
        getConnection();
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1,sp.getMaLoaiSanPham());
            stmt.setString(2,sp.getTenSanPham());
            stmt.setString(3,sp.getDonViTinh());
            stmt.setDouble(4,sp.getDonGiaChuan());
            stmt.setInt(5, sp.getSoDu());
            stmt.setString(6,sp.getMaVach());
            stmt.setInt(7, id);
            flag = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DM_SanPhamMd.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
        close();
        }
        return flag;
    }
    public static void main (String []args){
        DM_SanPhamMd spMd = new DM_SanPhamMd();
       // spMd.getConnection();
       // spMd.deleteDM_SanPham(13);
//        DM_SanPham sp = new DM_SanPham();
//        sp.setMaLoaiSanPham(1);
//        sp.setTenSanPham("quy");
//        sp.setDonViTinh("dong");
//        sp.setDonGiaChuan(15000.0);
//        sp.setSoDu(70);
//        sp.setMaVach("123450");
        //spMd.addDM_SanPham(sp);
        spMd.getDM_SanPham();  
//        spMd.updateDM_SanPham(sp, 2);
    }
}
