package Pojo;

import java.util.Date;

public class User {
    private  int    id;
    private  String name;
    private  String login_name;
    private  String pass;
    private  String introduce_sign;
    private  int    is_deleted;
    private  int    locked_flag ;
    private  Date   create_time;


    public User(int id, String name, String login_name, String pass, String introduce_sign, int is_deleted, int locked_flag, Date create_time) {
        this.id = id;
        this.name = name;
        this.login_name = login_name;
        this.pass = pass;
        this.introduce_sign = introduce_sign;
        this.is_deleted = is_deleted;
        this.locked_flag = locked_flag;
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login_name='" + login_name + '\'' +
                ", pass='" + pass + '\'' +
                ", introduce_sign='" + introduce_sign + '\'' +
                ", is_deleted=" + is_deleted +
                ", locked_flag=" + locked_flag +
                ", create_time=" + create_time +
                '}';
    }
}
