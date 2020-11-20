import V2.Util.MyDatasource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class Test2 {

    @Test
    public void test() throws  SQLException,ClassNotFoundException{
        MyDatasource md = new MyDatasource();
            Connection conn = md.getConnection();
    }
}
