
import java.lang.Thread;

public class ExtendThread{


    private static int count=0;
    public static void main(String[] arg) {
        ExtendThread tObj = new ExtendThread();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    for (int i = 0; i < 100; i++) {
                        //synchronized (tObj) {
                            tObj.notify();
                            tObj.wait();
                        //}
                        count++;
                        System.out.println("t1 " + count);
                    }
                    //synchronized (tObj) {
                        tObj.notify();
                    //}
                } catch (Throwable e) { }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    for (int i = 0; i < 100; i++) {
                       // synchronized (tObj) {
                            tObj.notify();
                            tObj.wait();
                        //}
                        count++;
                        System.out.println("t2 " + count);
                    }
                    //synchronized (tObj) {
                        tObj.notify();
                    //}
                } catch (Throwable e) { }

            }
        });
        t2.start();
        t1.start();

        System.out.println("count: " + count);
    }
}
