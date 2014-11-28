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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Hồ Thúc Đồng
 */
public class ChucNangCtrl implements ActionListener,MouseListener{
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
        chucnang_view.sua.addActionListener(this);
        chucnang_view.chucnang_table.addMouseListener(this);
        updateTable();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource() == chucnang_view.addChucNang){
           addChucNang();
       }
       if(ae.getSource() == chucnang_view.sua){
           updateChucNang();
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
    public void updateChucNang(){
        chucnang.setTenChucNang(chucnang_view.tenChucNang_txt.getText());
        int flag = chucnangMd.updateChucNang(chucnang);
        if(flag == 1){
            updateTable();
            JOptionPane.showMessageDialog(chucnang_view, "Successfull!");
        }
        else{
            JOptionPane.showMessageDialog(chucnang_view, "Fail!");
        }
        clearText();
    }
    public void clearText(){
        chucnang_view.tenChucNang_txt.setText(null);
    }
    // Cac ham tro giup o day
    
    public static void main(String[] args){
        ChucNangCtrl cn = new ChucNangCtrl();
        cn.chucnang_view.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int row = chucnang_view.chucnang_table.getSelectedRow();
        String id = chucnang_view.chucnang_table.getModel().getValueAt(row, 0).toString();
        chucnang = chucnangMd.getChucNang(id);
        chucnang_view.tenChucNang_txt.setText(chucnang.getTenChucNang());
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
       
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
}
