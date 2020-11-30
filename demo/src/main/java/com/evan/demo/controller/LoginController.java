package com.evan.demo.controller;

import com.evan.demo.pojo.User;
import com.evan.demo.result.Result;
import com.evan.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

//1.用户访问 URL，检测是否为登录页面，如果是登录页面则不拦截
//2.如果用户访问的不是登录页面，检测用户是否已登录，如果未登录则跳转到登录页面
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestUser.getPassword());
        if (null == user) {
            return new Result(400);
        } else {
            //session.setAttribute("user",user);
            //把用户信息存在 Session 对象
            //访问别的页面时，可以通过判断是否存在用户变量来判断用户是否登录
            return new Result(200);
        }
    }
}
