package Util;

import com.mysql.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class JdbcUtil {
    public static Properties prop = null;//定义静态属性？？
    private  Connection conn = null;
    static {
        try{
            InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.Properties");
            //InputStream in = new FileInputStream("jdbc.Properties");  //注意路径
            prop = new Properties();
            prop.load(in);

        }catch (IOException e){
            //?????这里将io异常转化为运行时异常，有什么用？？？？？？？？？？？
            throw new RuntimeException(e);
        }

        //加载驱动类
        try{
            Class.forName(prop.getProperty("driver"));    //这种方式加载不了驱动，为啥？？？？
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }



    }

    /**
     * get connection
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static  Connection  getConnection() throws SQLException,ClassNotFoundException {
        Connection conn = DriverManager.getConnection(prop.getProperty("host"),prop.getProperty("user"),prop.getProperty("pass"));

        return conn;
    }

    /**
     * 释放资源
     */
    public static void free(Connection conn, PreparedStatement ps, ResultSet rs){

    }



}
