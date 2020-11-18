package Dao;

import Util.DaoException;
import Util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 第一版 没有将数据映射抽取到父类中
 */
public abstract class DaoAbstractV1 {
    protected static Connection conn;
    static{
        try{
            //JdbcUtil jdbcUtil = new JdbcUtil();
            conn = JdbcUtil.getConnection();
        }catch (ClassNotFoundException e){

        }catch (SQLException Se){

        }

    }

    /**
     * insert update delete
     * @param sql
     * @param args
     * @return
     */
    public int update(String sql, Object...args){
        PreparedStatement ps = null;
        ResultSet         rs = null;
        try {
            conn = JdbcUtil.getConnection();
            // sql由调用者传入
            ps = conn.prepareStatement(sql);
            // 遍历设置模板参数
            for (int i = 0; i < args.length; i++){
                ps.setObject(i + 1, args[i]);
            }
            return ps.executeUpdate();
        }catch (SQLException se){
            throw  new DaoException(se.getMessage(),se);
        }catch (ClassNotFoundException ce){
            throw new DaoException(ce.getMessage(), ce);
        } finally{
            JdbcUtil.free(conn,ps,rs);    //  释放连接资源等
        }
    }

    /**
     * SELECT
     * @param sql
     * @return
     */
    public ResultSet query(String sql){
        PreparedStatement ps = null;
        ResultSet         rs = null;
        try {
            conn = JdbcUtil.getConnection();
            // sql由调用者传入
            ps = conn.prepareStatement(sql);
            // 遍历设置模板参数

            return ps.executeQuery();
        }catch (SQLException se){
            throw  new DaoException(se.getMessage(),se);
        }catch (ClassNotFoundException ce){
            throw new DaoException(ce.getMessage(), ce);
        } finally{
            JdbcUtil.free(conn,ps,rs);    //  释放连接资源等
        }
    }



}
