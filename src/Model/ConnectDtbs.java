/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author Hồ Thúc Đồng
 */
public class ConnectDtbs {
    Connection connection;
    String host = "localhost";
    int port = 1433;
    String databaseName = "BookStoreManagerment";
    String username = "sa"; 
    String password = "123201";
    
    public Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://"+host+":"+port+";databaseName="+databaseName,username,password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDtbs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDtbs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connection;
    }
    
    public void close() {
        if(connection!=null){
            try {
                if(connection.isClosed()){
                    connection.close();
                    connection = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectDtbs.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args){
        ConnectDtbs cnn = new ConnectDtbs();
        Connection connect = cnn.getConnection();
        try {
            Statement stt = connect.createStatement();
            ResultSet rs = stt.executeQuery("Select * From ChucNang");
            while(rs.next()){
                System.out.println(rs.getString("MaChucNang")+" "+rs.getString("TenChucNang"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDtbs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
