/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Entity.NhomNguoiDung;
import Model.NhomNguoiDungMd;
import View.NhomNguoiDung_View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import net.proteanit.sql.DbUtils;
import javax.swing.JOptionPane;
/**
 *
 * @author Hồ Thúc Đồng
 */
public class NhomNguoiDungCtrl implements ActionListener,MouseListener{
    NhomNguoiDung nhomND;
    NhomNguoiDungMd nhomNDMd;
    NhomNguoiDung_View nhomND_view;
    public NhomNguoiDungCtrl(){
        nhomND = new NhomNguoiDung();
        nhomNDMd = new NhomNguoiDungMd();
        nhomND_view = new NhomNguoiDung_View();
        nhomND_view.addNhomND.addActionListener(this);
        nhomND_view.sua.addActionListener(this);
        nhomND_view.cancel.addActionListener(this);
        nhomND_view.nhomND_table.addMouseListener(this);
        updateTable();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== nhomND_view.addNhomND){
            addNhomNguoiDung();
        }
        if(ae.getSource()== nhomND_view.sua){
            updateNhomND();
        }
        if(ae.getSource()== nhomND_view.cancel){
            clearText();
        }
    }
    
    public void updateTable(){
        nhomND_view.nhomND_table.setModel(DbUtils.resultSetToTableModel(nhomNDMd.getNhomND()));
    }
    
    public void addNhomNguoiDung(){
        nhomND = new NhomNguoiDung();
        nhomND.setTenNhom(nhomND_view.tenNhomND_txt.getText());
        nhomND.setGhiChu(nhomND_view.ghichu_txt.getText());
        nhomNDMd.addNhomND(nhomND);
        clearText();
        updateTable();
    }
    
    public void updateNhomND(){
        nhomND.setTenNhom(nhomND_view.tenNhomND_txt.getText());
        nhomND.setGhiChu(nhomND_view.ghichu_txt.getText());
        System.out.println(""+nhomND.getTenNhom()+""+nhomND.getGhiChu());
        int flag = nhomNDMd.updateNhomND(nhomND);
        if(flag == 1){    
            updateTable();
            JOptionPane.showMessageDialog(nhomND_view, "Successfull!");
        }else{
            JOptionPane.showMessageDialog(nhomND_view, "Fail!");
        }
            clearText();
    }
    public void clearText(){
        nhomND_view.tenNhomND_txt.setText(null);
        nhomND_view.ghichu_txt.setText(null);
    }
    
    public static void main(String[] args){
        NhomNguoiDungCtrl nndCtrl = new NhomNguoiDungCtrl();
        nndCtrl.nhomND_view.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
         int row = nhomND_view.nhomND_table.getSelectedRow();
         String id = nhomND_view.nhomND_table.getModel().getValueAt(row, 0).toString();
         nhomND = nhomNDMd.getNhomND(id);
         nhomND_view.tenNhomND_txt.setText(nhomND.getTenNhom());
         nhomND_view.ghichu_txt.setText(nhomND.getGhiChu());
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
