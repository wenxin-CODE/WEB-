package com.kuang.config;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocalResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
//        获取请求中的语言参数
        String language = request.getParameter("l");
        System.out.println("DEBUG====>"+language);
//        如果没有就使用默认的
        Locale locale = Locale.getDefault();

        if (!StringUtils.isEmpty(language)){
//            分割并获取
            String[] split = language.split("_");
            locale = new Locale(split[0],split[1]);

        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
