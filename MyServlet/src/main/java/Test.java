import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {

        HashMap<String,String> aa = new HashMap<>();
        aa.put("aa","bb");
        aa.put("cc","dd");
        aa.put("ee","ff");


        for(String val:aa.values()){
            System.out.println("value="+val);
        }
        for(String key:aa.keySet()){
            System.out.println("key="+key);
        }


    }
}

class aa{
    public String a="ap";
    public aa(){

    }

}
class bb{
    public String b="bp";
    public void fun() {
        //System.out.println("bb");
        System.out.println(this.toString());
    }
}
