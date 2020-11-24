import org.junit.Test;

import java.util.concurrent.TimeUnit;


public class MyTest {
    @Test
    public void test(){
        /* new Thread(new Runnable() {
            public void run() {
                System.out.println("Runnable's run method is running");
            }
        }){
            @Override
            public void run() {
                System.out.println("Thread's run method is running");
            }
        }.start();*/

        new Thread(() -> System.out.println("Runnable's run method is running")){
            @Override
            public void run() {
                System.out.println("Thread's run method is running");

            }
        }.start();
    }
    @Test
    public void test2() throws InterruptedException {

        System.out.println(1111111111);
        ImplRunable implRunable = new ImplRunable();
        Thread thread = new Thread(implRunable,"兔子");
        Thread thread2 = new Thread(implRunable,"乌龟");
        thread.start();
        thread2.start();

        TimeUnit.SECONDS.sleep(2);
    }


}
