package com.wu.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//放在主类之外，避免被scan到，可能是定义的规则，免得鱼龙混杂
@Configuration
public class WuRule {

    @Bean
    public IRule myRule() {
        return new WuRandomRule(); //默认为轮询，现在试使用自己自定义的
    }
}

