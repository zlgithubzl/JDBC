import Util.JdbcUtil;
import org.junit.Test;


public class Test1 {
    @Test
    public void testjdbc() throws  Exception{
        JdbcUtil jdbcUtil = new JdbcUtil();
        jdbcUtil.getConnection();
    }
}
