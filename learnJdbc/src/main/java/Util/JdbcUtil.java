package Util;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcUtil {
    public static void main(String[] args) {
        try {
            getConnection();
        }catch (Exception e){

        }

    }
    public static  void getConnection() throws SQLException,ClassNotFoundException {

        String url = "jdbc:mysql//127.0.0.1:3306";
        String database = "test";
        String username = "root";
        String password = "root";


        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url,username,password);
        System.out.println(conn);

    }
}
