package com.dly.springboot.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dly.springboot.common.Constants;
import com.dly.springboot.common.Result;
import com.dly.springboot.controller.dto.UserDTO;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.util.List;

import com.dly.springboot.service.IUserService;
import com.dly.springboot.entity.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2022-06-09
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody UserDTO userDTO){
//        RequestBody前端接受的json转为java对象
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        if(StrUtil.isBlank(username) || StrUtil.isBlank(password)){
            return Result.error(Constants.CODE_400,"参数异常");
        }
        UserDTO dto = userService.login(userDTO);
        return Result.success(dto);
//        return true;
    }
//    这里登录时，如果系统里面有两个相同的用户就会出错

    @PostMapping("/register")
    public Result register(@RequestBody UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        if(StrUtil.isBlank(username) || StrUtil.isBlank(password)){
            return Result.error(Constants.CODE_400,"参数异常");
        }
        return Result.success(userService.register(userDTO));
    }

    @PostMapping
    public Result save(@RequestBody User user) {
            return Result.success(userService.saveOrUpdate(user));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
            return Result.success(userService.removeById(id));
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids){
            return Result.success(userService.removeByIds(ids));
    }

    @GetMapping
    public List<User> findAll() {
            return userService.list();
    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable Integer id) {
            return userService.getById(id);
    }

    @GetMapping("/username/{username}")
    public Result findOne(@PathVariable String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        return Result.success(userService.getOne(queryWrapper));
    }


    @GetMapping("/page")
    public Page<User> findPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam(value = "username",defaultValue = "") String username,
                               @RequestParam(value = "email",defaultValue = "") String email){
        Page<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
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

//    导出Excel
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception{
        List<User> list = userService.list();
//        在内存中操作，写入浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
//        自定义标题别名——否则表头就是实体类属性名
        writer.addHeaderAlias("username","用户名");
        writer.addHeaderAlias("password","密码");
        writer.addHeaderAlias("nickname","昵称");
        writer.addHeaderAlias("phone","电话");
        writer.addHeaderAlias("email","邮箱");
        writer.addHeaderAlias("address","地址");
        writer.addHeaderAlias("createTime","创建时间");
        writer.addHeaderAlias("avatarUrl","头像");

//        list内容写到Excel，默认样式，强制输出标题
        writer.write(list,true);

//        设置浏览器响应格式——固定格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("用户信息", "UTF-8");
        response.setHeader("Content-Disposition","attachment;filename="+fileName+".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out,true);
        out.close();
        writer.close();

    }

//    导入
    @PostMapping("/import")
    public Boolean imp(MultipartFile file) throws Exception{
//        读取前端文件
        InputStream inputStream = file.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
//        俺对象格式接受
        List<User> list = reader.readAll(User.class);
//        System.out.println(list);
//        List<User> list = reader.read(0, 1, User.class);
        userService.saveBatch(list);
        return true;
    }

}

