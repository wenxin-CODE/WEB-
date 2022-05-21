package com.kuang.springboot09test.controller;

import com.kuang.springboot09test.service.AsynService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsynController {

    @Autowired
    AsynService asynService;

    @RequestMapping("/hello")
    public String hello(){
        asynService.hello();
        return "hello world!!!";
    }
}
