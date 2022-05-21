package com.wu.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wu.springcloud.pojo.Dept;
import com.wu.springcloud.service.DeptService;
import com.wu.springcloud.service.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;
//提供Restfull服务!!
@RestController
public class DeptController {

    @Autowired
    private DeptServiceImpl deptService;


    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGetDept") //失败了就会调用下面的这个备选方案
    public Dept getDept(@PathVariable("id") Long id) {
        Dept dept = deptService.queryById(id);
        if (dept == null) {
            throw new RuntimeException("id-->" + id + "不存在该用户，或者信息无法找到");
        }
        return dept;
    }

    //备选方案
    public Dept hystrixGetDept(@PathVariable("id") Long id) {
        return new Dept()
                .setDeptno(id)
                .setDname("id=>" + id + "没有对应的信息，null---@hystrix")
                .setDb_source("not this database in MySQL");
    }

}

