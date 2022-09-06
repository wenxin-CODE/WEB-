package com.dly.springboot.controller.dto;

//接收前端请求数据

import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String password;
    private String nickname;
    private String token;
}
