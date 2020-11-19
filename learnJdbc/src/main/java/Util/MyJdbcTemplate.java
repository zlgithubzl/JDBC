package Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyJdbcTemplate {

    /**
     * insert update delete
     * @param sql
     * @param args
     * @return
     */
    public int update(String sql, Object...args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
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
     * 查询得到list
     * @param sql
     * @param args
     * @param rm
     * @return
     */
    public List<Object> query(String sql, Object[] args, RowMapper rm){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;

        ArrayList<Object> arrayList = new ArrayList<>();//用于存储获取到的结果集
        try {
            conn = JdbcUtil.getConnection();
            // sql由调用者传入
            ps = conn.prepareStatement(sql);

            //String sqlStr = "select id,name,pass from user where name='u1'";

            String sqlStr = "select id,name,pass from user where name=?";
            ps.setString(1,"u1");

            rs = ps.executeQuery(sqlStr);




            // 遍历设置模板参数
            //for (int i = 0; i < args.length; i++){
                //ps.setObject(i+1, args[i]);

                //ps.setString(1,"u1");
            //}




            //select得到的结果集？待探究这里返回的是啥？？？？？？？？？，再研究mysql中的类型和java数据类型的对应关系？

            //循环，将每行的数据插入到list中
            while(rs.next()){
                arrayList.add(rm.mapRow(rs));
            }

            return arrayList;//返回结果集

        }catch (SQLException se){
            throw  new DaoException(se.getMessage(),se);
        }catch (ClassNotFoundException ce){
            throw new DaoException(ce.getMessage(), ce);
        } finally{
            JdbcUtil.free(conn,ps,rs);    //  释放连接资源等
        }
    }

}
