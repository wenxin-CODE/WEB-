package com.vueblog.common.lang;

import lombok.Data;
import java.io.Serializable;

@Data
public class Result implements Serializable {
    private int code;
    private String msg;
    private Object data;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }

//    public static Result succ(Object data){
//        return succ(200,"操作成功，data");
//    }

    public static Result succ(int code,String msg,Object data ) {
        Result m = new Result();
        m.setCode(code);
        m.setData(data);
        m.setMsg(msg);
        return m;
    }
//    public static Result succ(String mess, Object data) {
//        Result m = new Result();
//        m.setCode("0");
//        m.setData(data);
//        m.setMsg(mess);
//        return m;
//    }
//    public static Result fail(String mess) {
//        Result m = new Result();  
//        m.setCode("-1");
//        m.setData(null);
//        m.setMsg(mess);
//        return m;
//    }
//    public static Result fail(String mess, Object data) {
//        Result m = new Result();
//        m.setCode("-1");
//        m.setData(data);
//        m.setMsg(mess);
//        return m;
//    }
}
