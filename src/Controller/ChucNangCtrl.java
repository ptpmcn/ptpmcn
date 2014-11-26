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
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

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
        chucnang_view.addChucNang.addActionListener(this);
        updateTable();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource() == chucnang_view.addChucNang){
           addChucNang();
       }
    }
    
    public void updateTable(){
        chucnang_view.chucnang_table.setModel(DbUtils.resultSetToTableModel(chucnangMd.getChucNangMd()));
    }
    public void addChucNang(){
        chucnang = new ChucNang();
        chucnang.setTenChucNang(chucnang_view.tenChucNang_txt.getText());
        chucnangMd.addChucNang(chucnang);
        clearText();
        updateTable();
    }
    public void clearText(){
        chucnang_view.tenChucNang_txt.setText(null);
    }
    // Cac ham tro giup o day
    
    public static void main(String[] args){
        ChucNangCtrl cn = new ChucNangCtrl();
        cn.chucnang_view.setVisible(true);
    }
}
