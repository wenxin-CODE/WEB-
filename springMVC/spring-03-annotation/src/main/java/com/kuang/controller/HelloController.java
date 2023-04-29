package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller是为了让Spring IOC容器初始化时自动扫描到
//@RequestMapping是为了映射请求路径，这里因为类与方法上都有映射所以访问时应该是/HelloController/hello
@Controller
@RequestMapping("/HelloController")//与下面的形成父子关系
public class HelloController {

    //真实访问地址 : 项目名/HelloController/hello
//  注意配置tomcat的application context设置，浏览器访问时候涉及到他
    @RequestMapping("/hello")
    public String sayHello(Model model){
        //封装数据，向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg","hello,SpringMVC");
        //web-inf/jsp/hello.jsp
        return "hello";//被视图解析器（hello.jsp）处理
    }

    @RequestMapping("/hello1")
    public String sayHello1(Model model){
        //封装数据，向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg","hello,SpringMVCaaaaaa");
        //web-inf/jsp/hello.jsp
        return "hello";//被视图解析器（hello.jsp）处理
    }
}