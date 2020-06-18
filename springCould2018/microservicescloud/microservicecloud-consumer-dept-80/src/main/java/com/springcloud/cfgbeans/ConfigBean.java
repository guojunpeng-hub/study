package com.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean { //boot -->spring applicationContext.xml---@Configuration配置 Configuration = applicationContext.xml
    @Bean
    @LoadBalanced   // ribbon负载均衡、是基于Netflix Ribbon实现的一套客户端，负载均衡工具
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    @Bean
    public IRule myRule(){
//        return new RandomRule();// 目的是随机算法
      return new RetryRule();// 当有故障的，多次碰壁后，就不会再访问故障机
    }
}
//    @Bean
//    public UserService getUserService()
//    {
//        return UserServiceImpl();
//    }