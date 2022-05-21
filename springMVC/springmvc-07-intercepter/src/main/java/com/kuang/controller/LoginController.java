package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/main")
    public String main(){
        System.out.println("进入了首页");
        return "main";
    }

    @RequestMapping("goLogin")
    public String login(){
        return "login";
    }

    @RequestMapping("login")
    public String login(HttpSession session, String username, String password, Model model){
        System.out.println("login=====>"+username);
        //用户信息放到session中
        session.setAttribute("userLoginInfo",username);
        model.addAttribute("username",username);
        return "main";
    }

    //退出登陆
    @RequestMapping("logout")
    public String logout(HttpSession session) throws Exception {
        // session 过期
        session.invalidate();
        return "login";
    }
}
