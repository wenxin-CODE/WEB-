package com.wu.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WuRandomRule extends AbstractLoadBalancerRule {

    //每个机器，访问5次，换下一个服务（总共3个）
    //total = 0 默认=0，如果=5，我们指向下一个服务结点
    //index = 0 默认=0，如果total=5，那么index+1，

    private int total = 0; //被调用的次数
    private int currentIndex = 0; //当前是谁在提供服务

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers(); //获得还活着的服务
            List<Server> allList = lb.getAllServers();  //获得全部的服务

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

            //=============================================================

            if (total < 5) {
                total++;
            } else {
                total = 0;
                currentIndex++;
                if (currentIndex >= serverCount) {
                    currentIndex = 0;
                }
            }
            server = upList.get(currentIndex);
            //=============================================================
            if (server == null) {
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }
            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }
}

