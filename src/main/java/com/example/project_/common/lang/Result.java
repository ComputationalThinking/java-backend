package com.example.project_.common.lang;

import lombok.Data;

import java.io.Serializable;

//@Data
public class Result implements Serializable{

    private int code;//200是正常 非200异常
    private  String msg;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public  static Result success(Object data){
        Result r = new Result();
        r.setCode(ResultCode.SUCCESS.getCode());
        r.setMsg("操作成功");
        r.setData(data);
        System.out.println(r);
        return r;
    }

    public  static Result success(int code, String msg, Object data){
        Result r = new Result();
        r.setCode(ResultCode.SUCCESS.getCode());
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static Result fail(String mess) {
        Result m = new Result();
        m.setCode(ResultCode.FAILED.getCode());
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

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
