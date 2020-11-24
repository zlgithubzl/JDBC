import java.util.HashMap;

public class guitu implements Runnable{
    //保存线程
    private static HashMap<String,Thread> allThread=new HashMap<>();
    private  int len = 100;
    private static boolean isHaveWinner = false;

    public static void main(String[] args) {
        guitu gt = new guitu();
        Thread thread = new Thread(gt,"兔子");
        Thread thread2 = new Thread(gt,"乌龟");
        thread.start();
        thread2.start();
    }

    @Override
    public void run() {

        allThread.put(Thread.currentThread().getName(),Thread.currentThread());


        for(int i=0;i<=len;i++){
            if(Thread.currentThread().getName() == "兔子" && i % 3 == 0){
                try {
                    Thread.sleep(1);
                }catch (InterruptedException ie){
                    System.out.println(ie.getStackTrace());
                }
            }else if(Thread.currentThread().getName() == "乌龟" && i % 10 == 0){
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

        System.out.println("跑完了，等着公布结果");
    }

    private boolean isOver(int para){

        if(true == isHaveWinner){
            return  true;
        }else{
            if(100 == para){    //第一百步
                isHaveWinner = true;
                System.out.println("出现了胜利者，胜利者是"+Thread.currentThread().getName());

                //判断兔子是否还在跑，是的话，就通知兔子不用跑了
                if("乌龟" == Thread.currentThread().getName()){
                    System.out.println("乌龟已经胜利了，不用跑了");
                    this.allThread.get("兔子").interrupt();
                }
                return true;
            }
        }
        return false;


    }
}
