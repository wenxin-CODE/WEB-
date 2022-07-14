package com.dly.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dly.springboot.entity.User;
import com.dly.springboot.mapper.UserMapper;
import com.dly.springboot.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")  //这个注解给访问接口统一加前缀
public class UserController {

//    @Autowired
//    private UserMapper userMapper;

    @Autowired
    private UserService userService;

//    添加或更新用户
    @PostMapping
    public boolean save(@RequestBody User user){
        return userService.saveUser(user);
    }

//   查询用户
    @GetMapping  //依赖于restcontroller
    public List<User> findAll(){
        return userService.list();
    }

//    删除用户
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return userService.removeById(id);
    }
//    @PathVariable【相当于{}】和{id}是对应的，不能单独使用


    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids){
        return userService.removeByIds(ids);
    }
//    RequestParam将地址栏的参数num和size映射到方法参数中
//    一旦属性加入到查询条件里面，这个属性的值就不能为空，不然无法加载
//    @GetMapping("/page")
//    public Map<String, Object> findPage(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize,
//                                        @RequestParam("username") String username,@RequestParam("email") String email){
//        pageNum = (pageNum - 1) * pageSize;
//        Integer total = userMapper.selectTotal(username,email);
//        List<User> data = userMapper.selectPage(pageNum, pageSize, username, email);
//        Map<String, Object> res = new HashMap<>();
//        res.put("data",data);
//        res.put("total",total);
//        return res;
//    }

//    使用mybatisplus查询
//    defaultValue = ""使得可以查询全部，没有参数

//    新添加的哪吒为什么查不出来
    @GetMapping("/page")
    public IPage<User> findPage(@RequestParam("pageNum") Integer pageNum,
                                @RequestParam("pageSize") Integer pageSize,
                                @RequestParam(value = "username",defaultValue = "") String username,
                                @RequestParam(value = "email",defaultValue = "") String email){
        Page<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.orderByDesc("id");  //按id降序排列
//        添加limit条件，默认多个以and连接

//        如果未设置这个字段（为空），就不拼接了————字符串不能匹配数据库的null
        if(!"".equals(username)){
            queryWrapper.like("username",username);
        }
//        使用or进行’或‘查询
//        queryWrapper.or(w -> w.like("email",email));
        if(!"".equals(email)){
            queryWrapper.like("email",email);
        }
        return userService.page(page,queryWrapper);
    }
}
