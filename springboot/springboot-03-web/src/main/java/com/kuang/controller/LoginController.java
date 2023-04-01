package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

//使用http://localhost:8081/kuang/进行登录
@Controller
public class LoginController {

    @RequestMapping("/user/login")
//    @ResponseBody
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model, HttpSession session){

        System.out.println("用户密码==="+username+","+password);
        if (!StringUtils.isEmpty(username) && "123".equals(password)){
            session.setAttribute("loginuser",username);
            return "redirect:/main.html";
//            登陆成功，重定向到main页面
        }else {
            model.addAttribute("msg","错误");
            return "index";
        }
//        return "ok";
    }
}
