package com.evan.demo.result;

/*Result 类是为了构造 response，主要是响应码*/
public class Result {
    private int code;

    public Result(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
