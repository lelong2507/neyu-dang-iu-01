/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dbConnect;
import java.sql.*;
/**
 *
 * @author longle2507
 */
public class ConnectDB implements BaseConnection {
    private static ConnectDB instance;
    
    public static ConnectDB getInstance(){
        if(instance == null){
            instance = new ConnectDB();
        }
        
        return instance;
    }
    
    public static Connection openConnect() throws Exception{
        Class.forName(DRIVER_NAME);
        Connection con = DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
        
        return con;
    }
    
    public static void closeConnect(Connection con, PreparedStatement pst) throws Exception{
        try{
            if(con != null){
                con.close();
            }
            pst.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
