package com.example.project_.common.lang;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable{

    private int code;//200是正常 非200异常
    private  String msg;
    private Object data;

    public  static Result succ(Object data){
        Result r = new Result();
        r.setCode(200);
        r.setMsg("操作成功");
        r.setData(data);
        return r;
    }

    public  static Result succ(int code, String msg, Object data){
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static Result fail(String mess) {
        Result m = new Result();
        m.setCode(404);
        m.setData(null);
        m.setMsg(mess);
        return m;
     }

    public static Result fail(int code, String mess, Object data) {
        Result m = new Result();
        m.setCode(code);
        m.setData(data);
        m.setMsg(mess);
        return m;
     }

}
