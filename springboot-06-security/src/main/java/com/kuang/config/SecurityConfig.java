package com.kuang.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    //授权
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问，但是功能页只有对应有权限的人才能访问
        //链式编程
        //请求授权的规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/levle3/**").hasRole("vip3");

        //没有权限默认为登陆也
        http.formLogin();

//        注销
        http.logout().logoutSuccessUrl("/index");
    }

    //认证
    //密码编码  PasswordEncoder
    //在SpringSecuritys5中,新增了许多加密方式
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //这些数据应该从数据库中读
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("kuangshen").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3");
    }
}
