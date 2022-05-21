package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//加这个注解
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private int id;  //id
    private String name;   //姓名
    private String pwd;   //密码

}
