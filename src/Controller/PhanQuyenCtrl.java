/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Entity.ChucNang;
import Entity.NhomNguoiDung;
import Entity.PhanQuyen;
import Model.ChucNangMd;
import Model.NhomNguoiDungMd;
import Model.PhanQuyenMd;
import View.PhanQuyen_View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import java.util.List;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Hồ Thúc Đồng
 */
public class PhanQuyenCtrl implements ActionListener,MouseListener{
   PhanQuyen phanquyen;
   PhanQuyenMd phanquyenMd;
   PhanQuyen_View phanquyen_view;
   List<NhomNguoiDung> nhomND_list;
   NhomNguoiDungMd nhomNDMd;
   List<ChucNang> chucnang_list;
   ChucNangMd chucnangMd;
   public PhanQuyenCtrl(){
       phanquyen = new PhanQuyen();
       phanquyenMd = new PhanQuyenMd();
       phanquyen_view = new PhanQuyen_View();
       phanquyen_view.them.addActionListener(this);
       phanquyen_view.cancel.addActionListener(this);
       phanquyen_view.sua.addActionListener(this);
       phanquyen_view.phanquyen_table.addMouseListener(this);
       nhomNDMd = new NhomNguoiDungMd();
       chucnangMd = new ChucNangMd();
       loadNhomND();
       loadChucNang();
       updateTable();
      
       
   }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == phanquyen_view.them){
            addPhanQuyen();
        }
        if(ae.getSource()== phanquyen_view.cancel){
            clearText();
        }
        if(ae.getSource() == phanquyen_view.sua){
            updatePhanQuyen();
        }
    } 
   public void updateTable(){
       phanquyen_view.phanquyen_table.setModel(DbUtils.resultSetToTableModel(phanquyenMd.getPhanQuyen()));
   }
   // load nhom nguoi dung vao combobox
   public void loadNhomND(){
       nhomND_list = nhomNDMd.getListNhomND();
       for(NhomNguoiDung nND: nhomND_list){
           phanquyen_view.nhomND_cbx.addItem(nND.getTenNhom());
       }
   }
   // load chuc nang vào combobox
   public void loadChucNang(){
       chucnang_list = chucnangMd.getListChucNang();
       for(ChucNang cn: chucnang_list){
           phanquyen_view.chucnang_cbx.addItem(cn.getTenChucNang());
       }
   }
   public int convertTen_Id_NhomND(String tenNhomND){
       for(NhomNguoiDung nND:nhomND_list){
           if(nND.getTenNhom().equals(tenNhomND))
               return nND.getMaNhom();
       }
       return -1;
   }
   public int convertTen_Id_ChucNang(String tenChucNang){
       for(ChucNang cn: chucnang_list){
           if(cn.getTenChucNang().equals(tenChucNang))
               return cn.getMaChucNang();
       }
       return -1;
   }
   public void clearText(){
       phanquyen_view.tenquyen_txt.setText("");
   }
   public void addPhanQuyen(){
       int maNhom = convertTen_Id_NhomND(phanquyen_view.nhomND_cbx.getSelectedItem().toString());
       int maChucNang = convertTen_Id_ChucNang(phanquyen_view.chucnang_cbx.getSelectedItem().toString());
       phanquyen.setTenQuyen(phanquyen_view.tenquyen_txt.getText());
       phanquyen.setMaChucNang(maChucNang);
       phanquyen.setMaNhomND(maNhom);
       int flag = phanquyenMd.addPhanQuyen(phanquyen);
       if(flag == 1){
           updateTable();
           JOptionPane.showMessageDialog(phanquyen_view,"Thành Công");
       }
       else{
           JOptionPane.showMessageDialog(phanquyen_view,"Thất Bại!");
       }
       clearText();
   }
   
   public void updatePhanQuyen(){
       int maNhom = convertTen_Id_NhomND(phanquyen_view.nhomND_cbx.getSelectedItem().toString());
       int maChucNang = convertTen_Id_ChucNang(phanquyen_view.chucnang_cbx.getSelectedItem().toString());
       phanquyen.setTenQuyen(phanquyen_view.tenquyen_txt.getText());
       phanquyen.setMaChucNang(maChucNang);
       phanquyen.setMaNhomND(maNhom);
       int flag = phanquyenMd.updatePhanQuyen(phanquyen);
       if(flag == 1){
           updateTable();
           JOptionPane.showMessageDialog(phanquyen_view,"Thành Công");
       }
       else{
           JOptionPane.showMessageDialog(phanquyen_view,"Thất Bại!");
       }
       clearText();
   }
   
    public static void main(String[] args){
        PhanQuyenCtrl pqCtrl = new PhanQuyenCtrl();
        pqCtrl.phanquyen_view.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int row = phanquyen_view.phanquyen_table.getSelectedRow();
        String maPhanQuyen = phanquyen_view.phanquyen_table.getModel().getValueAt(row, 0).toString();
        phanquyen = phanquyenMd.getPhanQuyen(maPhanQuyen);
        phanquyen_view.tenquyen_txt.setText(phanquyen.getTenQuyen());   
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
