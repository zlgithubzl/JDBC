import Dao.UserMapper;
import Pojo.User;
import Utils.DbConnectionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTestV2 {

    @Test
    public void test(){

        //获取sqlsession
        SqlSession sqlSession = DbConnectionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //这里的userMapper具体是什么，待深入研究？？

        List<User> allUser = userMapper.getAllToList();
        for(User u:allUser){
            System.out.println(u);
        }

        String userName = userMapper.getNameById(1);
        System.out.println("第一个用户的名字："+userName);

        //新增




//        注意： mabatis中的增删改必须显式提交事务吗
            sqlSession.commit();    //将此sqlsession的事务提交
    }



    /**
     * 这样写法，如果只是新增的时候，只初始化个别字段，
     * 解决方案：使用Map传参
     */
    //userMapper.add(new User("新增的名字","新增的密码"));
    @Test
    public  void addByMap(){

        SqlSession sqlSession = DbConnectionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String,Object> map = new HashMap<String,Object>();
        //新增的时候只提供两个字段
        map.put("nameHAHA","新增的名字2");
        map.put("passHAHA","新增的密码2");
        int res = userMapper.add(map);

        System.out.println("新增的结果："+res);
        System.out.println("新增的id："+map.get("mid"));
        sqlSession.commit();        //必须显示提交事务
    }
}
