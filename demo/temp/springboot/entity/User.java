package com.dly.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@TableName(value = "sys_user") //mybatisplus直接把类名变小写在数据库中查询，所以要注解类名
public class User {

//    mybatisplus建议声明主键，不然添加数据id会赋值为负数
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String username;
//    这个注解表示不想展示，不传给前端
    @JsonIgnore
    private String password;
//    @TableField(value = "nickname") //为属性设置别名
    private String nickname;
    private String email;
    private String phone;
    private String address;

}
