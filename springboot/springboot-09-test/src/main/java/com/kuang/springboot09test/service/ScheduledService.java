package com.kuang.springboot09test.service;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//定时执行功能
@Service
public class ScheduledService {

    //Cron表达式
    //秒 分 时 月 星期
    //每一天的0秒启动
    @Scheduled(cron = "0 * * * * 0-7")
    public void hello(){
        System.out.println("Scheduled被执行了");//在一个特定的时间执行这个方法
    }
}
