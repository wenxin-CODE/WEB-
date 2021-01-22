package com.vueblog.controller;


import com.vueblog.common.lang.Result;
import com.vueblog.entity.User;
import com.vueblog.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2021-01-19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequiresAuthentication
    //加这个注解表明必须登录，才能访问
    @GetMapping("/index")
    public Result index(){
        User user = userService.getById(1L);
        return Result.succ(user);
        //200,"操作成功",
    }

    @PostMapping("/save")
    public Result save(@Validated @RequestBody User user){
        //@Validated自动进行user规则 校验
        return Result.succ(user);
    }
}
