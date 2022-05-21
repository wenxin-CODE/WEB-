package com.wu.springcloud.controller;

import com.wu.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class DeptConsumerController {

    //消费者 : 不因该有service层
    //RestTemplate  有很多方法给我们直接调用  !  它的类中没有Bean所以要我们自己把它注册到Bean中
    //(url, 实体：Map, Class<T> responseType)
    @Autowired
    private RestTemplate restTemplate;  //提供多种便捷访问远程http服务的方法，简单的restful服务模板

    //private static final String REST_URL_PREFIX = "http://localhost:8001";
//用Ribbon做负载均衡的时候不应该写它，不应该写死,地址应该是一个变量,通过服务名来访问
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";


    @RequestMapping("/consumer/dept/get/{id}")
    @ResponseBody
    public Dept getDept(@PathVariable("id") Long id) {
        //service不在本项目中，所以要去远程项目获取
        //远程只能用  get 方式请求，那么这里也只能通过 get 方式获取
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @RequestMapping("/consumer/dept/add")
    @ResponseBody
    public boolean add(Dept dept) {
        //远程只能用  post 方式请求，那么这里也只能通过 post 方式获取
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping("/consumer/dept/list")
    @ResponseBody
    public List<Dept> queryAll() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

}
