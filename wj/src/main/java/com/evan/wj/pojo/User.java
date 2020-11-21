package com.evan.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

//@Entity 表示这是一个实体类
//@Table(name=“user”) 表示对应的表名是 user
//为了简化对数据库的操作，我们使用了 Java Persistence API（JPA），
//对于 @JsonIgnoreProperties({ “handler”,“hibernateLazyInitializer” })，解释起来比较复杂，下面的话看不懂可以忽略：
@Entity
@Table(name = "user")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    String username;
    String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}