import javafx.scene.shape.StrokeLineCap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class index extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(
//                req.getParameter("s")
//        );
        String aa = req.getParameter("aa"); //return String
        String bb[] = req.getParameterValues("bb");    //return String array
        HashMap<String,String[]> cc = (HashMap) req.getParameterMap();  //return map

        Enum dd = (Enum) req.getParameterNames();    //return enum


        //遍历数组
        for(Object bbValue:bb){
            System.out.println("bb数组的值:"+bbValue);
        }
        //遍历map
        for(Object ccKey:cc.values()){
            System.out.println("map cc 的值:"+ccKey);
        }

        //遍历枚举
//        for(Object ddValue:dd.){
//            System.out.println("bb数组的值:"+bbValue);
//        }

        super.service(req,resp);
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//    }
}


