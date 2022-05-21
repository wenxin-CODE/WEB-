package com.kuang.config;

import org.aopalliance.intercept.Interceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("URI===>"+request.getRequestURI());
        HttpSession session = request.getSession();
        //判断什么情况下登陆了，放行

        //在登录页面放行
        if(request.getRequestURI().contains("goLogin")){
            return true;
        }

        //首次登陆，放行
        if(request.getRequestURI().contains("login")){
            return true;
        }

        //获取信息了，放行
        if(request.getAttribute("userLoginInfo")!=null){
            return true;
        }

//        注意WEB-INF前面的/
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }


}
