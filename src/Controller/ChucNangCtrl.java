/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Entity.ChucNang;
import Model.ChucNangMd;
import View.ChucNang_View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Hồ Thúc Đồng
 */
public class ChucNangCtrl implements ActionListener{
    ChucNang chucnang;
    ChucNangMd chucnangMd;
    ChucNang_View chucnang_view;
    /*Control here*/
    public ChucNangCtrl(){
        // khoi tao, load du lieu vao bang ....
        chucnang = new ChucNang();
        chucnangMd = new ChucNangMd();
        chucnang_view = new ChucNang_View();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource() == chucnang_view.addChucNang){
           //Them Chuc Nang o day
       }
    }
    
    
    // Cac ham tro giup o day
    
    public static void main(String[] args){
        ChucNangCtrl cn = new ChucNangCtrl();
        cn.chucnang_view.setVisible(true);
    }
}
