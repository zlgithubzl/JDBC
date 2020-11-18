package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoV1 implements DaoInterfaceV1 {

    @Override
    public Object select(){
        PreparedStatement ps = null;
        ResultSet rs = null;        //结果集
        Connection conn = null;

        try{
            String sql = "SELECT *from user where id="
        }catch (SQLException e){

        }


        return  new Object();
    }

    @Override
    public int insert() {
        return 0;
    }

    @Override
    public int update() {
        return 0;
    }

    @Override
    public int delete() {
        return 0;
    }
}
