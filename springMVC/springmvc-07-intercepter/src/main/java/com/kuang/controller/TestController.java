package com.kuang.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@RestController
public class TestController {

    @RequestMapping("/t1")
    public String test(){
        System.out.println("test执行了");
        return "OK";
    }
}
