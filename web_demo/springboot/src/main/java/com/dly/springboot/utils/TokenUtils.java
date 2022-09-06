package com.dly.springboot.utils;

import com.auth0.jwt.JWT;
import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class TokenUtils {

//    生成token：保证即使退出，在设定时间内仍然可以访问数据而不需重新登录

    public static String genToken(String userId,String sign){
        return JWT.create().withAudience(userId) //userId保存在token里面，作为载荷
                .withExpiresAt(DateUtil.offsetHour(new Date(),2)) //2小时过期
                .sign(Algorithm.HMAC256(sign)); //password作为token密码
    }
}
