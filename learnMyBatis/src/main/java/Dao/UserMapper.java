package Dao;

import Pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /*
     *select
    */
    //获取所有记录
    List<User> getAllToList();
    Map<String,User> getAllToMap();
    //获取单行记录
    List<User> getOneToList();
    Map<String,User> getOneToMap();
    //获取字段值
    String getNameById(int id);

    /*
    * insert
    * */

    /**
     * map传承适用于：不需要全部字段的时候， 但是这种用户使用的还挺多
     */
    int add(Map<String,Object> paramMap);
}
