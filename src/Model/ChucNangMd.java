/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Hồ Thúc Đồng
 */
public class ChucNangMd extends ConnectDtbs{
    public boolean getChucNangMd(){
        boolean bl = false;
        String sql ="Select * From ChucNang";
        /*code here*/
        return bl;
    }
    public boolean addChucNang(){
        boolean bl = false;
        String slq ="Insert into ChucNang .......";
        /*code here*/
        return bl;
    }
    public boolean deleteChucNang(){
        boolean bl = false;
        String sql = "Delete .....";
                /*code here*/
        return bl;       
    }
    public boolean updateChucNang(){
        boolean bl = false;
        String sql = "Update .....";
                /*code here*/
        return bl;
    }
}
