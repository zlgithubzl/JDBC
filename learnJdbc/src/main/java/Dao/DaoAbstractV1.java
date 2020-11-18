package Dao;

import Util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DaoAbstractV1 {
    protected static Connection conn;
    static{
        try{
            JdbcUtil jdbcUtil = new JdbcUtil();
            jdbcUtil.getConnection();
            conn = jdbcUtil.conn;
        }catch (ClassNotFoundException e){

        }catch (SQLException Se){

        }

    }
    public int update(String sql, Object...args){


    }
}
