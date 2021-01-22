package com.vueblog.controller;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vueblog.common.dto.LoginDto;
import com.vueblog.common.lang.Result;
import com.vueblog.entity.User;
import com.vueblog.service.UserService;
import com.vueblog.util.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AccountController {

    @Autowired
    UserService userService;

    @Autowired
    JwtUtils jwtUtils;

//    没有在对应的Controller类中添加对GET请求的处理方法。
//    虽然笔者并没有使用get请求，但是在进入首页加载表单的时候，
//    默认就是个get请求，而恰好这个请求被笔者的设置拦截了，
//    所以当请求被拦截后又找不到对应的处理方法
//    @RequestMapping(value = "login",method = RequestMethod.GET)
//    public ModelAndView login(){
//        return new ModelAndView("home");
//    }

    //@CrossOrigin
    @PostMapping("/login")
    public Result login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response){
        User user = userService.getOne(new QueryWrapper<User>().eq("username",loginDto.getUsername()));
        Assert.notNull(user,"用户不存在");

        if(!user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))){
            return Result.fail("密码不正确");
        }

        String jwt = jwtUtils.generateToken(user.getId());

        response.setHeader("Authorization",jwt);
        response.setHeader("Access-control-Expose-Header","Authorization");

        return Result.succ(MapUtil.builder()
                .put("id",user.getId())
                .put("username",user.getUsername())
                .put("avatar",user.getAvatar())
                .put("email",user.getEmail())
                .map()
        );
    }

    @RequiresAuthentication
    @GetMapping("/logout")
    public Result logout(){
        SecurityUtils.getSubject().logout();

        return Result.succ(null);
    }
}
