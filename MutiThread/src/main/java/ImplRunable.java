import java.awt.*;

public class ImplRunable implements Runnable{

    private  int len = 100;

    private static boolean isHaveWinner = false;

//    public ImplRunable() {
//        super();
//    }

    @Override
    public void run() {
        System.out.println(len);
        for(int i=0;i<=len;i++){
            if(Thread.currentThread().getName() == "兔子" && i % 10 == 0){
                try {
                    Thread.sleep(1);
                }catch (InterruptedException ie){
                    System.out.println(ie.getStackTrace());
                }
            }
            System.out.println(Thread.currentThread().getName()+"跑到了第"+i+"步");
            boolean res = isOver(i);
            if(true == res){
                //System.out.println("胜利者是"+Thread.currentThread().getName());
                break;
            }

        }
    }


    private boolean isOver(int para){

        if(isHaveWinner){
            return  true;
        }else{
            if(100 == para){    //第一百步
                isHaveWinner = true;
                System.out.println("胜利者是"+Thread.currentThread().getName());
                return true;
            }
        }
        return false;
    }
}
