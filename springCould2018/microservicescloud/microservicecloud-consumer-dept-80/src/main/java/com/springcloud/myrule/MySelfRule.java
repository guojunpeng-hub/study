package com.springcloud.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){

//        return new RandomRule();// ribbon默认是轮询，我自定义随机
                return new RandomRule_GJP();// 自定义调用轮询，每台调用五次
    }
}
