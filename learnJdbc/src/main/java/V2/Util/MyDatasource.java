package V2.Util;

import Util.JdbcUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

public class MyDatasource {


    private static int minCount = 5;
    private static int initCount = 10;
    private static int maxCount = 20;
    //当前连接池中的空闲连接数
    private static int currentCount;


    private final static LinkedList<Connection> connPool = new LinkedList<>();

    public  MyDatasource() {
        /**
         * 初始化连接池
         */
        System.out.println("初始化连接");
        try{
            for(int i = 0;i<minCount;i++){
                Connection realConnection = JdbcUtil.getConnection();
                connPool.add(realConnection);
                currentCount++;
            }
        }catch (SQLException se){
            System.out.println("11");
        }catch (ClassNotFoundException ce){
            System.out.println("22");
        }

        System.out.println("共初始化了"+currentCount+"个mysql连接");
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException{
        synchronized (connPool){ //加锁
            if(currentCount>0){
                currentCount--;
                if(currentCount<minCount){
                    //及时添加新的连接，保证最小连接数

                }
                return connPool.removeFirst();
            }
//           //创建新的连接
            return this.getProxyConnection(JdbcUtil.getConnection());


        }
    }

    /**
     *
     * @param realConnection  真是的连接对象
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    private Connection getProxyConnection(Connection realConnection) throws SQLException, ClassNotFoundException {

        Connection proxyConnection = (Connection) Proxy.newProxyInstance(
                this.getClass().getClassLoader(),//探究这里的this指的是哪个对象，这里不应该使用realConnection对象的classLoader吗？？？？？？？？？？？
                realConnection.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //这里对close进行拦截
                        if("close".equals(method.getName())){
                            if(MyDatasource.currentCount<MyDatasource.maxCount){
                                //MyDatasource.connPool.addLast(proxy);
                                MyDatasource.connPool.addLast((Connection) proxy);
                                MyDatasource.currentCount++;
                                return "success";
                            }
                        }else{
                            realConnection.close();
                            return "success222";
                        }
                        return method.invoke(realConnection,args);



                        //return null;
                    }
                }

        );
        System.out.println("新建connection成功");
        return proxyConnection;
    }


}
