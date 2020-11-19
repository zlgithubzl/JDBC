import Service.User;
import Util.JdbcUtil;
import Util.MyJdbcTemplate;
import Util.RowMapper;
import org.junit.Test;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Test1 {
    @Test
    public void testjdbc() throws  Exception{
        MyJdbcTemplate mt = new MyJdbcTemplate();


        //String sql = "select id,name,pass from user where name='u1'";

        String sql = "select id,name,pass from user where name= ? ";
        String name="u1";
        Object[] args = new Object[]{name};

        List list =  mt.query(sql, args, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPass(rs.getString("pass"));
                return  user;
            }
        });

        //List<ArrayList> userInfo = (ArrayList) list.get(0);     //报错：java.lang.ClassCastException: Service.User cannot be cast to java.util.ArrayList
        User userInfo = (User) list.get(0);


        System.out.println(userInfo.getPass());

    }
}
