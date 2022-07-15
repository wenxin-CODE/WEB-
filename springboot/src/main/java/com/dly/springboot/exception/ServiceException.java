package com.dly.springboot.exception;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {

    private String code;

    public ServiceException(String code,String msg){
//        参数msg包含在RuntimeException中
        super(msg);
        this.code = code;
    }
}
