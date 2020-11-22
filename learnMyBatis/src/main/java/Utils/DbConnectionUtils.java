package Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DbConnectionUtils {
    private static SqlSessionFactory sqlSessionFactory;

    //因为sqlSessionFactory
    static {
        try {
            //定义数据源
            String DataSource = "MyBatisConf.xml";
            InputStream inputStream = null;
            inputStream = Resources.getResourceAsStream(DataSource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 返货sqlsessionfactory
     * @return
     */
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
