package com.wu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
//@LoadBalanced//Ribbon,只要加了这个注解，这个RestTemplate就变成了负载均衡
public class ConfigBean {  //@Configuration ... 相当于spring中的配置文件 applicationContext.xml文件
    @Bean
    @LoadBalanced//Ribbon,只要加了这个注解，这个RestTemplate就变成了负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
