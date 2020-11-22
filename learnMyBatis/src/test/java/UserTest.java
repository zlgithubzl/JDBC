import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserTest {

    @Test
    public void test(){

        //定义数据源
        /*String DataSource = "MyBatisConf.xml";
        InputStream inputStream = Resources.getResourceAsStream(DataSource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //ArrayList<UserDao> userList =  (ArrayList<UserDao>) sqlSession.selectList("MyNamespace.findAll");


        ArrayList<Integer> param = new ArrayList<Integer>();
        param.add(1);
        param.add(6);

        //List<UserDao> userList = sqlSession.selectList("MyNamespace.findAll",param);
        List<UserDao> userList = sqlSession.selectList("MyNamespace.findAll",param);
        HashMap<String,Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("id",1);
        List<UserDao> userList2 = sqlSession.selectList("MyNamespace.findOne",hashMap);
        for(UserDao u:userList2){
            System.out.println(u);
        }*/



    }

}
