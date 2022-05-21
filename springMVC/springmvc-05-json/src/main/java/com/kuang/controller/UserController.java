package com.kuang.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("/j1")
    @ResponseBody//不走视图解析，直接返回json字符串。前后端分离使用这种（@RestController相同效果）
    public String json() throws JsonProcessingException {
        User user = new User("龙哥", 3, "man");

        ObjectMapper mapper = new ObjectMapper();
        String tr = mapper.writeValueAsString(user);
        //转化为json格式

        return tr;
//        return user.toString();这个返回的就是对象格式
    }

    @RequestMapping("/j4")
    @ResponseBody
    public String json4(){
        List<User> userList = new ArrayList<>();
        User user1 = new User("龙哥1", 3, "man");
        User user2 = new User("龙哥2", 3, "man");
        User user3 = new User("龙哥3", 3, "man");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        String str = JSON.toJSONString(userList);
        return str;
    }
}
