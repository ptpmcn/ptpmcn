/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Entity.NguoiDung;
import Entity.NhomNguoiDung;
import Model.NguoiDungMd;
import Model.NhomNguoiDungMd;
import View.NguoiDung_View;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import net.proteanit.sql.DbUtils;
import java.util.List;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
/**
 *
 * @author Hồ Thúc Đồng
 */
public class NguoiDungCtrl implements ActionListener,MouseListener{
    NguoiDung nguoidung;
    NguoiDungMd nguoidungMd;
    NguoiDung_View nguoidung_view;
    List<NhomNguoiDung> nhomND;
    NhomNguoiDungMd nhomNDMd;
    public NguoiDungCtrl(){
        nguoidung = new NguoiDung();
        nguoidungMd = new NguoiDungMd();
        nguoidung_view = new NguoiDung_View();
        nhomNDMd = new NhomNguoiDungMd();
        nguoidung_view.them.addActionListener(this);
        nguoidung_view.sua.addActionListener(this);
        nguoidung_view.nguoidung_table.addMouseListener(this);
        updateTable();
        loadNhomND();
    }
    public void updateTable(){
        nguoidung_view.nguoidung_table.setModel(DbUtils.resultSetToTableModel(nguoidungMd.getNguoiDung()));
    }
    public void loadNhomND(){
        nhomND = nhomNDMd.getListNhomND();
        for(NhomNguoiDung nd : nhomND){
            nguoidung_view.nhomND_cbx.addItem(nd.getTenNhom());
        }
    }
    public int convertTen_Id_NhomND(String tenNhom){
        for(NhomNguoiDung nND: nhomND){
            if(nND.getTenNhom().equals(tenNhom))
                return nND.getMaNhom();
        }
        return -1;
    }
    public void addNguoiDung(){
        int maNhomND = convertTen_Id_NhomND(nguoidung_view.nhomND_cbx.getSelectedItem().toString());
        nguoidung = new NguoiDung();
        nguoidung.setTenND(nguoidung_view.tenND_txt.getText());
        nguoidung.setTaikhoan(nguoidung_view.taikhoan_txt.getText());
        nguoidung.setMatkhau(nguoidung_view.matkhau_txt.getText());
        nguoidung.setMaNhomND(maNhomND);
        int flag = nguoidungMd.addNguoiDung(nguoidung);
        if(flag == 1){
            updateTable();
            JOptionPane.showMessageDialog(nguoidung_view,"Thành Công!");
        }
        else{
            JOptionPane.showMessageDialog(nguoidung_view, "Thất Bại!");
        }
        clearText();
    }
    public void updateNguoiDung(){
        int maNhomND = convertTen_Id_NhomND(nguoidung_view.nhomND_cbx.getSelectedItem().toString());
        nguoidung.setMatkhau(nguoidung_view.matkhau_txt.getText());
        nguoidung.setTaikhoan(nguoidung_view.taikhoan_txt.getText());
        nguoidung.setTenND(nguoidung_view.tenND_txt.getText());
        nguoidung.setMaNhomND(maNhomND);
        int flag = nguoidungMd.updateNguoiDung(nguoidung);
        if(flag == 1){
            updateTable();
            JOptionPane.showMessageDialog(nguoidung_view,"Thành Công!");
        }
        else{
            JOptionPane.showMessageDialog(nguoidung_view, "Thất Bại!");
        }
        clearText();
    }
    public void clearText(){
        nguoidung_view.matkhau_txt.setText("");
        nguoidung_view.taikhoan_txt.setText("");
        nguoidung_view.tenND_txt.setText("");
    }
    public static void main(String[] args){
        NguoiDungCtrl ndCtrl = new NguoiDungCtrl();
        ndCtrl.nguoidung_view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == nguoidung_view.them){
            addNguoiDung();
        }
        if(ae.getSource() == nguoidung_view.sua){
            updateNguoiDung();
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
       int row = nguoidung_view.nguoidung_table.getSelectedRow();
       String maND = nguoidung_view.nguoidung_table.getModel().getValueAt(row, 0).toString();
       nguoidung = nguoidungMd.getNguoiDung(maND);
       nguoidung_view.matkhau_txt.setText(nguoidung.getMatkhau());
       nguoidung_view.taikhoan_txt.setText(nguoidung.getTaikhoan());
       nguoidung_view.tenND_txt.setText(nguoidung.getTenND());
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
