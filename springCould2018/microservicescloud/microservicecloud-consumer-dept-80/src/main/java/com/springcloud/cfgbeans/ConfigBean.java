package com.springcloud.cfgbeans;

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

}
//    @Bean
//    public UserService getUserService()
//    {
//        return UserServiceImpl();
//    }