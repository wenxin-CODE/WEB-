package com.kuang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/userlist")
    public List<Map<String,Object>> userList(){
        String sql = "select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @GetMapping("/adduser")
    public String addUser(){
        String sql = "insert into mybatis.user(id,name,pwd) value (3,'mikeee','123654')";
        jdbcTemplate.update(sql);
        return "update-ok";
    }

    @GetMapping("/updateuser/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql = "update mybatis.user set name=?,pwd=? where id="+id;
        Object[] objects=new Object[2];
        objects[0]="xiaoming";
        objects[1]="ZZZZZZZZZZZZ";
        jdbcTemplate.update(sql,objects);
        return "update-ok";
    }

    @GetMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql = "delete from mybatis.user where id=?";
        jdbcTemplate.update(sql,id);
        return "delete-ok";
    }
}
